package com.facebook.common.statfs;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StatFsHelper {
    private static final long RESTAT_INTERVAL_MS = TimeUnit.MINUTES.toMillis(2);
    private static StatFsHelper sStatsFsHelper;
    private final Lock lock = new ReentrantLock();
    private volatile File mExternalPath;
    private volatile StatFs mExternalStatFs = null;
    private volatile boolean mInitialized = false;
    private volatile File mInternalPath;
    private volatile StatFs mInternalStatFs = null;
    private long mLastRestatTime;

    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper getInstance() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (sStatsFsHelper == null) {
                sStatsFsHelper = new StatFsHelper();
            }
            statFsHelper = sStatsFsHelper;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void ensureInitialized() {
        if (!this.mInitialized) {
            this.lock.lock();
            try {
                if (!this.mInitialized) {
                    this.mInternalPath = Environment.getDataDirectory();
                    this.mExternalPath = Environment.getExternalStorageDirectory();
                    updateStats();
                    this.mInitialized = true;
                }
                this.lock.unlock();
            } catch (Throwable th) {
                this.lock.unlock();
            }
        }
    }

    public boolean testLowDiskSpace(StorageType storageType, long j) {
        ensureInitialized();
        long availableStorageSpace = getAvailableStorageSpace(storageType);
        storageType = true;
        if (availableStorageSpace <= 0) {
            return true;
        }
        if (availableStorageSpace >= j) {
            storageType = null;
        }
        return storageType;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long getFreeStorageSpace(StorageType storageType) {
        ensureInitialized();
        maybeUpdateStats();
        storageType = storageType == StorageType.INTERNAL ? this.mInternalStatFs : this.mExternalStatFs;
        if (storageType == null) {
            return -1;
        }
        long blockSizeLong;
        long freeBlocksLong;
        if (VERSION.SDK_INT >= 18) {
            blockSizeLong = storageType.getBlockSizeLong();
            freeBlocksLong = storageType.getFreeBlocksLong();
        } else {
            blockSizeLong = (long) storageType.getBlockSize();
            freeBlocksLong = (long) storageType.getFreeBlocks();
        }
        return blockSizeLong * freeBlocksLong;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long getTotalStorageSpace(StorageType storageType) {
        ensureInitialized();
        maybeUpdateStats();
        storageType = storageType == StorageType.INTERNAL ? this.mInternalStatFs : this.mExternalStatFs;
        if (storageType == null) {
            return -1;
        }
        long blockSizeLong;
        long blockCountLong;
        if (VERSION.SDK_INT >= 18) {
            blockSizeLong = storageType.getBlockSizeLong();
            blockCountLong = storageType.getBlockCountLong();
        } else {
            blockSizeLong = (long) storageType.getBlockSize();
            blockCountLong = (long) storageType.getBlockCount();
        }
        return blockSizeLong * blockCountLong;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long getAvailableStorageSpace(StorageType storageType) {
        ensureInitialized();
        maybeUpdateStats();
        storageType = storageType == StorageType.INTERNAL ? this.mInternalStatFs : this.mExternalStatFs;
        if (storageType == null) {
            return 0;
        }
        long blockSizeLong;
        long availableBlocksLong;
        if (VERSION.SDK_INT >= 18) {
            blockSizeLong = storageType.getBlockSizeLong();
            availableBlocksLong = storageType.getAvailableBlocksLong();
        } else {
            blockSizeLong = (long) storageType.getBlockSize();
            availableBlocksLong = (long) storageType.getAvailableBlocks();
        }
        return blockSizeLong * availableBlocksLong;
    }

    private void maybeUpdateStats() {
        if (this.lock.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.mLastRestatTime > RESTAT_INTERVAL_MS) {
                    updateStats();
                }
                this.lock.unlock();
            } catch (Throwable th) {
                this.lock.unlock();
            }
        }
    }

    public void resetStats() {
        if (this.lock.tryLock()) {
            try {
                ensureInitialized();
                updateStats();
            } finally {
                this.lock.unlock();
            }
        }
    }

    private void updateStats() {
        this.mInternalStatFs = updateStatsHelper(this.mInternalStatFs, this.mInternalPath);
        this.mExternalStatFs = updateStatsHelper(this.mExternalStatFs, this.mExternalPath);
        this.mLastRestatTime = SystemClock.uptimeMillis();
    }

    private android.os.StatFs updateStatsHelper(android.os.StatFs r3, java.io.File r4) {
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
        r2 = this;
        r0 = 0;
        if (r4 == 0) goto L_0x0026;
    L_0x0003:
        r1 = r4.exists();
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0026;
    L_0x000a:
        if (r3 != 0) goto L_0x0017;
    L_0x000c:
        r3 = r4.getAbsolutePath();	 Catch:{ IllegalArgumentException -> 0x0025, Throwable -> 0x0015 }
        r3 = createStatFs(r3);	 Catch:{ IllegalArgumentException -> 0x0025, Throwable -> 0x0015 }
        goto L_0x001e;	 Catch:{ IllegalArgumentException -> 0x0025, Throwable -> 0x0015 }
    L_0x0015:
        r3 = move-exception;	 Catch:{ IllegalArgumentException -> 0x0025, Throwable -> 0x0015 }
        goto L_0x0020;	 Catch:{ IllegalArgumentException -> 0x0025, Throwable -> 0x0015 }
    L_0x0017:
        r4 = r4.getAbsolutePath();	 Catch:{ IllegalArgumentException -> 0x0025, Throwable -> 0x0015 }
        r3.restat(r4);	 Catch:{ IllegalArgumentException -> 0x0025, Throwable -> 0x0015 }
    L_0x001e:
        r0 = r3;
        goto L_0x0025;
    L_0x0020:
        r3 = com.facebook.common.internal.Throwables.propagate(r3);
        throw r3;
    L_0x0025:
        return r0;
    L_0x0026:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.statfs.StatFsHelper.updateStatsHelper(android.os.StatFs, java.io.File):android.os.StatFs");
    }

    protected static StatFs createStatFs(String str) {
        return new StatFs(str);
    }
}
