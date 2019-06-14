package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.disk.DiskStorage.DiskDumpInfo;
import com.facebook.cache.disk.DiskStorage.Entry;
import com.facebook.cache.disk.DiskStorage.Inserter;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.util.Collection;

public class DynamicDefaultDiskStorage implements DiskStorage {
    private static final Class<?> TAG = DynamicDefaultDiskStorage.class;
    private final String mBaseDirectoryName;
    private final Supplier<File> mBaseDirectoryPathSupplier;
    private final CacheErrorLogger mCacheErrorLogger;
    @VisibleForTesting
    volatile State mCurrentState = new State(null, null);
    private final int mVersion;

    @VisibleForTesting
    static class State {
        public final DiskStorage delegate;
        public final File rootDirectory;

        @VisibleForTesting
        State(File file, DiskStorage diskStorage) {
            this.delegate = diskStorage;
            this.rootDirectory = file;
        }
    }

    public DynamicDefaultDiskStorage(int i, Supplier<File> supplier, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mBaseDirectoryPathSupplier = supplier;
        this.mBaseDirectoryName = str;
    }

    public boolean isEnabled() {
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
        r1 = this;
        r0 = r1.get();	 Catch:{ IOException -> 0x0009 }
        r0 = r0.isEnabled();	 Catch:{ IOException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DynamicDefaultDiskStorage.isEnabled():boolean");
    }

    public boolean isExternal() {
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
        r1 = this;
        r0 = r1.get();	 Catch:{ IOException -> 0x0009 }
        r0 = r0.isExternal();	 Catch:{ IOException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DynamicDefaultDiskStorage.isExternal():boolean");
    }

    public java.lang.String getStorageName() {
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
        r1 = this;
        r0 = r1.get();	 Catch:{ IOException -> 0x0009 }
        r0 = r0.getStorageName();	 Catch:{ IOException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DynamicDefaultDiskStorage.getStorageName():java.lang.String");
    }

    public BinaryResource getResource(String str, Object obj) {
        return get().getResource(str, obj);
    }

    public boolean contains(String str, Object obj) {
        return get().contains(str, obj);
    }

    public boolean touch(String str, Object obj) {
        return get().touch(str, obj);
    }

    public void purgeUnexpectedResources() {
        try {
            get().purgeUnexpectedResources();
        } catch (Throwable e) {
            FLog.m5671e(TAG, "purgeUnexpectedResources", e);
        }
    }

    public Inserter insert(String str, Object obj) {
        return get().insert(str, obj);
    }

    public Collection<Entry> getEntries() {
        return get().getEntries();
    }

    public long remove(Entry entry) {
        return get().remove(entry);
    }

    public long remove(String str) {
        return get().remove(str);
    }

    public void clearAll() {
        get().clearAll();
    }

    public DiskDumpInfo getDumpInfo() {
        return get().getDumpInfo();
    }

    @VisibleForTesting
    synchronized DiskStorage get() {
        if (shouldCreateNewStorage()) {
            deleteOldStorageIfNecessary();
            createStorage();
        }
        return (DiskStorage) Preconditions.checkNotNull(this.mCurrentState.delegate);
    }

    private boolean shouldCreateNewStorage() {
        State state = this.mCurrentState;
        if (!(state.delegate == null || state.rootDirectory == null)) {
            if (state.rootDirectory.exists()) {
                return false;
            }
        }
        return true;
    }

    @VisibleForTesting
    void deleteOldStorageIfNecessary() {
        if (this.mCurrentState.delegate != null && this.mCurrentState.rootDirectory != null) {
            FileTree.deleteRecursively(this.mCurrentState.rootDirectory);
        }
    }

    private void createStorage() {
        File file = new File((File) this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
        createRootDirectoryIfNecessary(file);
        this.mCurrentState = new State(file, new DefaultDiskStorage(file, this.mVersion, this.mCacheErrorLogger));
    }

    @VisibleForTesting
    void createRootDirectoryIfNecessary(File file) {
        try {
            FileUtils.mkdirs(file);
            FLog.m5655d(TAG, "Created cache directory %s", file.getAbsolutePath());
        } catch (File file2) {
            this.mCacheErrorLogger.logError(CacheErrorCategory.WRITE_CREATE_DIR, TAG, "createRootDirectoryIfNecessary", file2);
            throw file2;
        }
    }
}
