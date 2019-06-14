package com.facebook.imagepipeline.cache;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import p043b.C0829j;

public class BufferedDiskCache {
    private static final Class<?> TAG = BufferedDiskCache.class;
    private final FileCache mFileCache;
    private final ImageCacheStatsTracker mImageCacheStatsTracker;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final PooledByteStreams mPooledByteStreams;
    private final Executor mReadExecutor;
    private final StagingArea mStagingArea = StagingArea.getInstance();
    private final Executor mWriteExecutor;

    /* renamed from: com.facebook.imagepipeline.cache.BufferedDiskCache$5 */
    class C17665 implements Callable<Void> {
        C17665() {
        }

        public Void call() {
            BufferedDiskCache.this.mStagingArea.clearAll();
            BufferedDiskCache.this.mFileCache.clearAll();
            return null;
        }
    }

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.mFileCache = fileCache;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mPooledByteStreams = pooledByteStreams;
        this.mReadExecutor = executor;
        this.mWriteExecutor = executor2;
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
    }

    public boolean containsSync(CacheKey cacheKey) {
        if (!this.mStagingArea.containsKey(cacheKey)) {
            if (this.mFileCache.hasKeySync(cacheKey) == null) {
                return null;
            }
        }
        return true;
    }

    public C0829j<Boolean> contains(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return C0829j.m2979a(Boolean.valueOf(true));
        }
        return containsAsync(cacheKey);
    }

    private C0829j<Boolean> containsAsync(final CacheKey cacheKey) {
        try {
            return C0829j.m2980a(new Callable<Boolean>() {
                public Boolean call() {
                    return Boolean.valueOf(BufferedDiskCache.this.checkInStagingAreaAndFileCache(cacheKey));
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.m5713w(TAG, (Throwable) e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return C0829j.m2978a(e);
        }
    }

    public boolean diskCheckSync(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return true;
        }
        return checkInStagingAreaAndFileCache(cacheKey);
    }

    public C0829j<EncodedImage> get(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
        if (encodedImage != null) {
            return foundPinnedImage(cacheKey, encodedImage);
        }
        return getAsync(cacheKey, atomicBoolean);
    }

    private boolean checkInStagingAreaAndFileCache(com.facebook.cache.common.CacheKey r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = r3.mStagingArea;
        r0 = r0.get(r4);
        if (r0 == 0) goto L_0x001d;
    L_0x0008:
        r0.close();
        r0 = TAG;
        r1 = "Found image for %s in staging area";
        r2 = r4.getUriString();
        com.facebook.common.logging.FLog.m5695v(r0, r1, r2);
        r0 = r3.mImageCacheStatsTracker;
        r0.onStagingAreaHit(r4);
        r4 = 1;
        return r4;
    L_0x001d:
        r0 = TAG;
        r1 = "Did not find image for %s in staging area";
        r2 = r4.getUriString();
        com.facebook.common.logging.FLog.m5695v(r0, r1, r2);
        r0 = r3.mImageCacheStatsTracker;
        r0.onStagingAreaMiss();
        r0 = r3.mFileCache;	 Catch:{ Exception -> 0x0034 }
        r4 = r0.hasKey(r4);	 Catch:{ Exception -> 0x0034 }
        return r4;
    L_0x0034:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.BufferedDiskCache.checkInStagingAreaAndFileCache(com.facebook.cache.common.CacheKey):boolean");
    }

    private C0829j<EncodedImage> getAsync(final CacheKey cacheKey, final AtomicBoolean atomicBoolean) {
        try {
            return C0829j.m2980a(new Callable<EncodedImage>() {
                public com.facebook.imagepipeline.image.EncodedImage call() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                    /*
                    r4 = this;
                    r0 = r6;
                    r0 = r0.get();
                    if (r0 != 0) goto L_0x0080;
                L_0x0008:
                    r0 = com.facebook.imagepipeline.cache.BufferedDiskCache.this;
                    r0 = r0.mStagingArea;
                    r1 = r5;
                    r0 = r0.get(r1);
                    if (r0 == 0) goto L_0x0031;
                L_0x0016:
                    r1 = com.facebook.imagepipeline.cache.BufferedDiskCache.TAG;
                    r2 = "Found image for %s in staging area";
                    r3 = r5;
                    r3 = r3.getUriString();
                    com.facebook.common.logging.FLog.m5695v(r1, r2, r3);
                    r1 = com.facebook.imagepipeline.cache.BufferedDiskCache.this;
                    r1 = r1.mImageCacheStatsTracker;
                    r2 = r5;
                    r1.onStagingAreaHit(r2);
                    goto L_0x005e;
                L_0x0031:
                    r0 = com.facebook.imagepipeline.cache.BufferedDiskCache.TAG;
                    r1 = "Did not find image for %s in staging area";
                    r2 = r5;
                    r2 = r2.getUriString();
                    com.facebook.common.logging.FLog.m5695v(r0, r1, r2);
                    r0 = com.facebook.imagepipeline.cache.BufferedDiskCache.this;
                    r0 = r0.mImageCacheStatsTracker;
                    r0.onStagingAreaMiss();
                    r0 = com.facebook.imagepipeline.cache.BufferedDiskCache.this;	 Catch:{ Exception -> 0x007e }
                    r1 = r5;	 Catch:{ Exception -> 0x007e }
                    r0 = r0.readFromDiskCache(r1);	 Catch:{ Exception -> 0x007e }
                    r0 = com.facebook.common.references.CloseableReference.of(r0);	 Catch:{ Exception -> 0x007e }
                    r1 = new com.facebook.imagepipeline.image.EncodedImage;	 Catch:{ all -> 0x0079 }
                    r1.<init>(r0);	 Catch:{ all -> 0x0079 }
                    com.facebook.common.references.CloseableReference.closeSafely(r0);	 Catch:{ Exception -> 0x007e }
                    r0 = r1;
                L_0x005e:
                    r1 = java.lang.Thread.interrupted();
                    if (r1 == 0) goto L_0x0078;
                L_0x0064:
                    r1 = com.facebook.imagepipeline.cache.BufferedDiskCache.TAG;
                    r2 = "Host thread was interrupted, decreasing reference count";
                    com.facebook.common.logging.FLog.m5694v(r1, r2);
                    if (r0 == 0) goto L_0x0072;
                L_0x006f:
                    r0.close();
                L_0x0072:
                    r0 = new java.lang.InterruptedException;
                    r0.<init>();
                    throw r0;
                L_0x0078:
                    return r0;
                L_0x0079:
                    r1 = move-exception;
                    com.facebook.common.references.CloseableReference.closeSafely(r0);	 Catch:{ Exception -> 0x007e }
                    throw r1;	 Catch:{ Exception -> 0x007e }
                L_0x007e:
                    r0 = 0;
                    return r0;
                L_0x0080:
                    r0 = new java.util.concurrent.CancellationException;
                    r0.<init>();
                    throw r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.BufferedDiskCache.2.call():com.facebook.imagepipeline.image.EncodedImage");
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.m5713w(TAG, (Throwable) e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return C0829j.m2978a(e);
        }
    }

    public void put(final CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.checkNotNull(cacheKey);
        Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
        this.mStagingArea.put(cacheKey, encodedImage);
        final EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
        try {
            this.mWriteExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        BufferedDiskCache.this.writeToDiskCache(cacheKey, cloneOrNull);
                    } finally {
                        BufferedDiskCache.this.mStagingArea.remove(cacheKey, cloneOrNull);
                        EncodedImage.closeSafely(cloneOrNull);
                    }
                }
            });
        } catch (Throwable e) {
            FLog.m5713w(TAG, e, "Failed to schedule disk-cache write for %s", cacheKey.getUriString());
            this.mStagingArea.remove(cacheKey, encodedImage);
            EncodedImage.closeSafely(cloneOrNull);
        }
    }

    public C0829j<Void> remove(final CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        this.mStagingArea.remove(cacheKey);
        try {
            return C0829j.m2980a(new Callable<Void>() {
                public Void call() {
                    BufferedDiskCache.this.mStagingArea.remove(cacheKey);
                    BufferedDiskCache.this.mFileCache.remove(cacheKey);
                    return null;
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.m5713w(TAG, (Throwable) e, "Failed to schedule disk-cache remove for %s", cacheKey.getUriString());
            return C0829j.m2978a(e);
        }
    }

    public C0829j<Void> clearAll() {
        this.mStagingArea.clearAll();
        try {
            return C0829j.m2980a(new C17665(), this.mWriteExecutor);
        } catch (Exception e) {
            FLog.m5713w(TAG, (Throwable) e, "Failed to schedule disk-cache clear", new Object[0]);
            return C0829j.m2978a(e);
        }
    }

    private C0829j<EncodedImage> foundPinnedImage(CacheKey cacheKey, EncodedImage encodedImage) {
        FLog.m5695v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
        return C0829j.m2979a((Object) encodedImage);
    }

    private PooledByteBuffer readFromDiskCache(CacheKey cacheKey) {
        InputStream openStream;
        try {
            FLog.m5695v(TAG, "Disk cache read for %s", cacheKey.getUriString());
            BinaryResource resource = this.mFileCache.getResource(cacheKey);
            if (resource == null) {
                FLog.m5695v(TAG, "Disk cache miss for %s", cacheKey.getUriString());
                this.mImageCacheStatsTracker.onDiskCacheMiss();
                return null;
            }
            FLog.m5695v(TAG, "Found entry in disk cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheHit();
            openStream = resource.openStream();
            PooledByteBuffer newByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(openStream, (int) resource.size());
            openStream.close();
            FLog.m5695v(TAG, "Successful read from disk cache for %s", cacheKey.getUriString());
            return newByteBuffer;
        } catch (Throwable e) {
            FLog.m5713w(TAG, e, "Exception reading from cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheGetFail();
            throw e;
        } catch (Throwable th) {
            openStream.close();
        }
    }

    private void writeToDiskCache(CacheKey cacheKey, final EncodedImage encodedImage) {
        FLog.m5695v(TAG, "About to write to disk-cache for key %s", cacheKey.getUriString());
        try {
            this.mFileCache.insert(cacheKey, new WriterCallback() {
                public void write(OutputStream outputStream) {
                    BufferedDiskCache.this.mPooledByteStreams.copy(encodedImage.getInputStream(), outputStream);
                }
            });
            FLog.m5695v(TAG, "Successful disk-cache write for key %s", cacheKey.getUriString());
        } catch (Throwable e) {
            FLog.m5713w(TAG, e, "Failed to write to disk-cache for key %s", cacheKey.getUriString());
        }
    }
}
