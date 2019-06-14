package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class CountingMemoryCache<K, V> implements MemoryTrimmable, MemoryCache<K, V> {
    @VisibleForTesting
    static final long PARAMS_INTERCHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5);
    private final CacheTrimStrategy mCacheTrimStrategy;
    @VisibleForTesting
    final CountingLruMap<K, Entry<K, V>> mCachedEntries;
    @VisibleForTesting
    final CountingLruMap<K, Entry<K, V>> mExclusiveEntries;
    private long mLastCacheParamsCheck;
    protected MemoryCacheParams mMemoryCacheParams;
    private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
    @VisibleForTesting
    final Map<Bitmap, Object> mOtherEntries = new WeakHashMap();
    private final ValueDescriptor<V> mValueDescriptor;

    public interface CacheTrimStrategy {
        double getTrimRatio(MemoryTrimType memoryTrimType);
    }

    @VisibleForTesting
    static class Entry<K, V> {
        public int clientCount = 0;
        public boolean isOrphan = false;
        public final K key;
        public final EntryStateObserver<K> observer;
        public final CloseableReference<V> valueRef;

        private Entry(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
            this.key = Preconditions.checkNotNull(k);
            this.valueRef = (CloseableReference) Preconditions.checkNotNull(CloseableReference.cloneOrNull((CloseableReference) closeableReference));
            this.observer = entryStateObserver;
        }

        @VisibleForTesting
        static <K, V> Entry<K, V> of(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
            return new Entry(k, closeableReference, entryStateObserver);
        }
    }

    public interface EntryStateObserver<K> {
        void onExclusivityChanged(K k, boolean z);
    }

    public CountingMemoryCache(ValueDescriptor<V> valueDescriptor, CacheTrimStrategy cacheTrimStrategy, Supplier<MemoryCacheParams> supplier) {
        this.mValueDescriptor = valueDescriptor;
        this.mExclusiveEntries = new CountingLruMap(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new CountingLruMap(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = (MemoryCacheParams) this.mMemoryCacheParamsSupplier.get();
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
    }

    private ValueDescriptor<Entry<K, V>> wrapValueDescriptor(final ValueDescriptor<V> valueDescriptor) {
        return new ValueDescriptor<Entry<K, V>>() {
            public int getSizeInBytes(Entry<K, V> entry) {
                return valueDescriptor.getSizeInBytes(entry.valueRef.get());
            }
        };
    }

    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference) {
        return cache(k, closeableReference, null);
    }

    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
        Entry entry;
        CloseableReference<V> closeableReference2;
        CloseableReference referenceToClose;
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(closeableReference);
        maybeUpdateCacheParams();
        synchronized (this) {
            entry = (Entry) this.mExclusiveEntries.remove(k);
            Entry entry2 = (Entry) this.mCachedEntries.remove(k);
            closeableReference2 = null;
            if (entry2 != null) {
                makeOrphan(entry2);
                referenceToClose = referenceToClose(entry2);
            } else {
                referenceToClose = null;
            }
            if (canCacheNewValue(closeableReference.get())) {
                closeableReference = Entry.of(k, closeableReference, entryStateObserver);
                this.mCachedEntries.put(k, closeableReference);
                closeableReference2 = newClientReference(closeableReference);
            }
        }
        CloseableReference.closeSafely(referenceToClose);
        maybeNotifyExclusiveEntryRemoval(entry);
        maybeEvictEntries();
        return closeableReference2;
    }

    private synchronized boolean canCacheNewValue(V v) {
        boolean z;
        v = this.mValueDescriptor.getSizeInBytes(v);
        z = true;
        if (v > this.mMemoryCacheParams.maxCacheEntrySize || getInUseCount() > this.mMemoryCacheParams.maxCacheEntries - 1 || getInUseSizeInBytes() > this.mMemoryCacheParams.maxCacheSize - v) {
            z = false;
        }
        return z;
    }

    public CloseableReference<V> get(K k) {
        Entry entry;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            entry = (Entry) this.mExclusiveEntries.remove(k);
            Entry entry2 = (Entry) this.mCachedEntries.get(k);
            k = entry2 != null ? newClientReference(entry2) : null;
        }
        maybeNotifyExclusiveEntryRemoval(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return k;
    }

    private synchronized CloseableReference<V> newClientReference(final Entry<K, V> entry) {
        increaseClientCount(entry);
        return CloseableReference.of(entry.valueRef.get(), new ResourceReleaser<V>() {
            public void release(V v) {
                CountingMemoryCache.this.releaseClientReference(entry);
            }
        });
    }

    private void releaseClientReference(Entry<K, V> entry) {
        CloseableReference referenceToClose;
        Preconditions.checkNotNull(entry);
        synchronized (this) {
            decreaseClientCount(entry);
            boolean maybeAddToExclusives = maybeAddToExclusives(entry);
            referenceToClose = referenceToClose(entry);
        }
        CloseableReference.closeSafely(referenceToClose);
        if (!maybeAddToExclusives) {
            entry = null;
        }
        maybeNotifyExclusiveEntryInsertion(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private synchronized boolean maybeAddToExclusives(Entry<K, V> entry) {
        if (entry.isOrphan || entry.clientCount != 0) {
            return null;
        }
        this.mExclusiveEntries.put(entry.key, entry);
        return true;
    }

    public CloseableReference<V> reuse(K k) {
        Preconditions.checkNotNull(k);
        synchronized (this) {
            Entry entry = (Entry) this.mExclusiveEntries.remove(k);
            Object obj = 1;
            boolean z = false;
            if (entry != null) {
                Entry entry2 = (Entry) this.mCachedEntries.remove(k);
                Preconditions.checkNotNull(entry2);
                if (entry2.clientCount == 0) {
                    z = true;
                }
                Preconditions.checkState(z);
                k = entry2.valueRef;
            } else {
                k = null;
                obj = null;
            }
        }
        if (obj != null) {
            maybeNotifyExclusiveEntryRemoval(entry);
        }
        return k;
    }

    public int removeAll(Predicate<K> predicate) {
        ArrayList removeAll;
        synchronized (this) {
            removeAll = this.mExclusiveEntries.removeAll(predicate);
            predicate = this.mCachedEntries.removeAll(predicate);
            makeOrphans(predicate);
        }
        maybeClose(predicate);
        maybeNotifyExclusiveEntryRemoval(removeAll);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return predicate.size();
    }

    public void clear() {
        ArrayList clear;
        ArrayList clear2;
        synchronized (this) {
            clear = this.mExclusiveEntries.clear();
            clear2 = this.mCachedEntries.clear();
            makeOrphans(clear2);
        }
        maybeClose(clear2);
        maybeNotifyExclusiveEntryRemoval(clear);
        maybeUpdateCacheParams();
    }

    public synchronized boolean contains(Predicate<K> predicate) {
        return this.mCachedEntries.getMatchingEntries(predicate).isEmpty() ^ 1;
    }

    public synchronized boolean contains(K k) {
        return this.mCachedEntries.contains(k);
    }

    public void trim(MemoryTrimType memoryTrimType) {
        ArrayList trimExclusivelyOwnedEntries;
        double trimRatio = this.mCacheTrimStrategy.getTrimRatio(memoryTrimType);
        synchronized (this) {
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, Math.max(0, ((int) (((double) this.mCachedEntries.getSizeInBytes()) * (1.0d - trimRatio))) - getInUseSizeInBytes()));
            makeOrphans(trimExclusivelyOwnedEntries);
        }
        maybeClose(trimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(trimExclusivelyOwnedEntries);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private synchronized void maybeUpdateCacheParams() {
        if (this.mLastCacheParamsCheck + PARAMS_INTERCHECK_INTERVAL_MS <= SystemClock.uptimeMillis()) {
            this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
            this.mMemoryCacheParams = (MemoryCacheParams) this.mMemoryCacheParamsSupplier.get();
        }
    }

    private void maybeEvictEntries() {
        ArrayList trimExclusivelyOwnedEntries;
        synchronized (this) {
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
            makeOrphans(trimExclusivelyOwnedEntries);
        }
        maybeClose(trimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(trimExclusivelyOwnedEntries);
    }

    private synchronized ArrayList<Entry<K, V>> trimExclusivelyOwnedEntries(int i, int i2) {
        i = Math.max(i, 0);
        i2 = Math.max(i2, 0);
        if (this.mExclusiveEntries.getCount() <= i && this.mExclusiveEntries.getSizeInBytes() <= i2) {
            return 0;
        }
        ArrayList<Entry<K, V>> arrayList = new ArrayList();
        while (true) {
            if (this.mExclusiveEntries.getCount() <= i) {
                if (this.mExclusiveEntries.getSizeInBytes() <= i2) {
                    return arrayList;
                }
            }
            Object firstKey = this.mExclusiveEntries.getFirstKey();
            this.mExclusiveEntries.remove(firstKey);
            arrayList.add(this.mCachedEntries.remove(firstKey));
        }
    }

    private void maybeClose(ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                CloseableReference.closeSafely(referenceToClose((Entry) arrayList.next()));
            }
        }
    }

    private void maybeNotifyExclusiveEntryRemoval(ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                maybeNotifyExclusiveEntryRemoval((Entry) arrayList.next());
            }
        }
    }

    private static <K, V> void maybeNotifyExclusiveEntryRemoval(Entry<K, V> entry) {
        if (entry != null && entry.observer != null) {
            entry.observer.onExclusivityChanged(entry.key, false);
        }
    }

    private static <K, V> void maybeNotifyExclusiveEntryInsertion(Entry<K, V> entry) {
        if (entry != null && entry.observer != null) {
            entry.observer.onExclusivityChanged(entry.key, true);
        }
    }

    private synchronized void makeOrphans(ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                makeOrphan((Entry) arrayList.next());
            }
        }
    }

    private synchronized void makeOrphan(Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(entry.isOrphan ^ true);
        entry.isOrphan = true;
    }

    private synchronized void increaseClientCount(Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(entry.isOrphan ^ 1);
        entry.clientCount++;
    }

    private synchronized void decreaseClientCount(Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(entry.clientCount > 0);
        entry.clientCount--;
    }

    private synchronized CloseableReference<V> referenceToClose(Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        entry = (entry.isOrphan && entry.clientCount == 0) ? entry.valueRef : null;
        return entry;
    }

    public synchronized int getCount() {
        return this.mCachedEntries.getCount();
    }

    public synchronized int getSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes();
    }

    public synchronized int getInUseCount() {
        return this.mCachedEntries.getCount() - this.mExclusiveEntries.getCount();
    }

    public synchronized int getInUseSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes() - this.mExclusiveEntries.getSizeInBytes();
    }

    public synchronized int getEvictionQueueCount() {
        return this.mExclusiveEntries.getCount();
    }

    public synchronized int getEvictionQueueSizeInBytes() {
        return this.mExclusiveEntries.getSizeInBytes();
    }
}
