package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StagingArea {
    private static final Class<?> TAG = StagingArea.class;
    private Map<CacheKey, EncodedImage> mMap = new HashMap();

    private StagingArea() {
    }

    public static StagingArea getInstance() {
        return new StagingArea();
    }

    public synchronized void put(CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.checkNotNull(cacheKey);
        Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
        EncodedImage.closeSafely((EncodedImage) this.mMap.put(cacheKey, EncodedImage.cloneOrNull(encodedImage)));
        logStats();
    }

    public void clearAll() {
        synchronized (this) {
            List arrayList = new ArrayList(this.mMap.values());
            this.mMap.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            EncodedImage encodedImage = (EncodedImage) arrayList.get(i);
            if (encodedImage != null) {
                encodedImage.close();
            }
        }
    }

    public boolean remove(CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        synchronized (this) {
            EncodedImage encodedImage = (EncodedImage) this.mMap.remove(cacheKey);
        }
        if (encodedImage == null) {
            return null;
        }
        try {
            boolean isValid = encodedImage.isValid();
            return isValid;
        } finally {
            encodedImage.close();
        }
    }

    public synchronized boolean remove(CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.checkNotNull(cacheKey);
        Preconditions.checkNotNull(encodedImage);
        Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
        EncodedImage encodedImage2 = (EncodedImage) this.mMap.get(cacheKey);
        if (encodedImage2 == null) {
            return false;
        }
        CloseableReference byteBufferRef = encodedImage2.getByteBufferRef();
        CloseableReference byteBufferRef2 = encodedImage.getByteBufferRef();
        if (!(byteBufferRef == null || byteBufferRef2 == null)) {
            try {
                if (byteBufferRef.get() == byteBufferRef2.get()) {
                    this.mMap.remove(cacheKey);
                    logStats();
                    return true;
                }
            } finally {
                CloseableReference.closeSafely(byteBufferRef2);
                CloseableReference.closeSafely(byteBufferRef);
                EncodedImage.closeSafely(encodedImage2);
            }
        }
        CloseableReference.closeSafely(byteBufferRef2);
        CloseableReference.closeSafely(byteBufferRef);
        EncodedImage.closeSafely(encodedImage2);
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.facebook.imagepipeline.image.EncodedImage get(com.facebook.cache.common.CacheKey r7) {
        /*
        r6 = this;
        monitor-enter(r6);
        com.facebook.common.internal.Preconditions.checkNotNull(r7);	 Catch:{ all -> 0x0051 }
        r0 = r6.mMap;	 Catch:{ all -> 0x0051 }
        r0 = r0.get(r7);	 Catch:{ all -> 0x0051 }
        r0 = (com.facebook.imagepipeline.image.EncodedImage) r0;	 Catch:{ all -> 0x0051 }
        if (r0 == 0) goto L_0x004e;
    L_0x000e:
        monitor-enter(r0);	 Catch:{ all -> 0x0051 }
        r1 = com.facebook.imagepipeline.image.EncodedImage.isValid(r0);	 Catch:{ all -> 0x004b }
        if (r1 != 0) goto L_0x0045;
    L_0x0015:
        r1 = r6.mMap;	 Catch:{ all -> 0x004b }
        r1.remove(r7);	 Catch:{ all -> 0x004b }
        r1 = TAG;	 Catch:{ all -> 0x004b }
        r2 = "Found closed reference %d for key %s (%d)";
        r3 = 3;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x004b }
        r4 = 0;
        r5 = java.lang.System.identityHashCode(r0);	 Catch:{ all -> 0x004b }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x004b }
        r3[r4] = r5;	 Catch:{ all -> 0x004b }
        r4 = 1;
        r5 = r7.getUriString();	 Catch:{ all -> 0x004b }
        r3[r4] = r5;	 Catch:{ all -> 0x004b }
        r4 = 2;
        r7 = java.lang.System.identityHashCode(r7);	 Catch:{ all -> 0x004b }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x004b }
        r3[r4] = r7;	 Catch:{ all -> 0x004b }
        com.facebook.common.logging.FLog.m5712w(r1, r2, r3);	 Catch:{ all -> 0x004b }
        r7 = 0;
        monitor-exit(r0);	 Catch:{ all -> 0x004b }
        monitor-exit(r6);
        return r7;
    L_0x0045:
        r7 = com.facebook.imagepipeline.image.EncodedImage.cloneOrNull(r0);	 Catch:{ all -> 0x004b }
        monitor-exit(r0);	 Catch:{ all -> 0x004b }
        goto L_0x004f;
    L_0x004b:
        r7 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x004b }
        throw r7;	 Catch:{ all -> 0x0051 }
    L_0x004e:
        r7 = r0;
    L_0x004f:
        monitor-exit(r6);
        return r7;
    L_0x0051:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.StagingArea.get(com.facebook.cache.common.CacheKey):com.facebook.imagepipeline.image.EncodedImage");
    }

    public synchronized boolean containsKey(CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        if (!this.mMap.containsKey(cacheKey)) {
            return false;
        }
        EncodedImage encodedImage = (EncodedImage) this.mMap.get(cacheKey);
        synchronized (encodedImage) {
            if (EncodedImage.isValid(encodedImage)) {
                return true;
            }
            this.mMap.remove(cacheKey);
            FLog.m5712w(TAG, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.getUriString(), Integer.valueOf(System.identityHashCode(cacheKey)));
            return false;
        }
    }

    private synchronized void logStats() {
        FLog.m5695v(TAG, "Count = %d", Integer.valueOf(this.mMap.size()));
    }
}
