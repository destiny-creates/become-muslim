package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class CountingLruMap<K, V> {
    private final LinkedHashMap<K, V> mMap = new LinkedHashMap();
    private int mSizeInBytes = 0;
    private final ValueDescriptor<V> mValueDescriptor;

    public CountingLruMap(ValueDescriptor<V> valueDescriptor) {
        this.mValueDescriptor = valueDescriptor;
    }

    @VisibleForTesting
    synchronized ArrayList<K> getKeys() {
        return new ArrayList(this.mMap.keySet());
    }

    @VisibleForTesting
    synchronized ArrayList<V> getValues() {
        return new ArrayList(this.mMap.values());
    }

    public synchronized int getCount() {
        return this.mMap.size();
    }

    public synchronized int getSizeInBytes() {
        return this.mSizeInBytes;
    }

    public synchronized K getFirstKey() {
        return this.mMap.isEmpty() ? null : this.mMap.keySet().iterator().next();
    }

    public synchronized ArrayList<Entry<K, V>> getMatchingEntries(Predicate<K> predicate) {
        ArrayList<Entry<K, V>> arrayList;
        arrayList = new ArrayList(this.mMap.entrySet().size());
        for (Entry entry : this.mMap.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.mMap.containsKey(k);
    }

    public synchronized V get(K k) {
        return this.mMap.get(k);
    }

    public synchronized V put(K k, V v) {
        V remove;
        remove = this.mMap.remove(k);
        this.mSizeInBytes -= getValueSizeInBytes(remove);
        this.mMap.put(k, v);
        this.mSizeInBytes += getValueSizeInBytes(v);
        return remove;
    }

    public synchronized V remove(K k) {
        k = this.mMap.remove(k);
        this.mSizeInBytes -= getValueSizeInBytes(k);
        return k;
    }

    public synchronized ArrayList<V> removeAll(Predicate<K> predicate) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList();
        Iterator it = this.mMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry.getValue());
                this.mSizeInBytes -= getValueSizeInBytes(entry.getValue());
                it.remove();
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<V> clear() {
        ArrayList<V> arrayList;
        arrayList = new ArrayList(this.mMap.values());
        this.mMap.clear();
        this.mSizeInBytes = 0;
        return arrayList;
    }

    private int getValueSizeInBytes(V v) {
        return v == null ? null : this.mValueDescriptor.getSizeInBytes(v);
    }
}
