package com.facebook.cache.disk;

import android.os.Environment;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage.DiskDumpInfo;
import com.facebook.cache.disk.DiskStorage.DiskDumpInfoEntry;
import com.facebook.cache.disk.DiskStorage.Entry;
import com.facebook.cache.disk.DiskStorage.Inserter;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.file.FileUtils.ParentDirNotFoundException;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DefaultDiskStorage implements DiskStorage {
    private static final String CONTENT_FILE_EXTENSION = ".cnt";
    private static final String DEFAULT_DISK_STORAGE_VERSION_PREFIX = "v2";
    private static final int SHARDING_BUCKET_COUNT = 100;
    private static final Class<?> TAG = DefaultDiskStorage.class;
    private static final String TEMP_FILE_EXTENSION = ".tmp";
    static final long TEMP_FILE_LIFETIME_MS = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger mCacheErrorLogger;
    private final Clock mClock = SystemClock.get();
    private final boolean mIsExternal;
    private final File mRootDirectory;
    private final File mVersionDirectory;

    private static class FileInfo {
        public final String resourceId;
        @FileType
        public final String type;

        private FileInfo(@FileType String str, String str2) {
            this.type = str;
            this.resourceId = str2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.type);
            stringBuilder.append("(");
            stringBuilder.append(this.resourceId);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public String toPath(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(File.separator);
            stringBuilder.append(this.resourceId);
            stringBuilder.append(this.type);
            return stringBuilder.toString();
        }

        public File createTempFile(File file) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.resourceId);
            stringBuilder.append(".");
            return File.createTempFile(stringBuilder.toString(), ".tmp", file);
        }

        public static FileInfo fromFile(File file) {
            file = file.getName();
            int lastIndexOf = file.lastIndexOf(46);
            if (lastIndexOf <= 0) {
                return null;
            }
            String access$800 = DefaultDiskStorage.getFileTypefromExtension(file.substring(lastIndexOf));
            if (access$800 == null) {
                return null;
            }
            file = file.substring(0, lastIndexOf);
            if (access$800.equals(".tmp")) {
                int lastIndexOf2 = file.lastIndexOf(46);
                if (lastIndexOf2 <= 0) {
                    return null;
                }
                file = file.substring(0, lastIndexOf2);
            }
            return new FileInfo(access$800, file);
        }
    }

    public @interface FileType {
        public static final String CONTENT = ".cnt";
        public static final String TEMP = ".tmp";
    }

    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("File was not written completely. Expected: ");
            stringBuilder.append(j);
            stringBuilder.append(", found: ");
            stringBuilder.append(j2);
            super(stringBuilder.toString());
            this.expected = j;
            this.actual = j2;
        }
    }

    private class EntriesCollector implements FileTreeVisitor {
        private final List<Entry> result;

        public void postVisitDirectory(File file) {
        }

        public void preVisitDirectory(File file) {
        }

        private EntriesCollector() {
            this.result = new ArrayList();
        }

        public void visitFile(File file) {
            FileInfo access$000 = DefaultDiskStorage.this.getShardFileInfo(file);
            if (access$000 != null && access$000.type == ".cnt") {
                this.result.add(new EntryImpl(access$000.resourceId, file));
            }
        }

        public List<Entry> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    @VisibleForTesting
    static class EntryImpl implements Entry {
        private final String id;
        private final FileBinaryResource resource;
        private long size;
        private long timestamp;

        private EntryImpl(String str, File file) {
            Preconditions.checkNotNull(file);
            this.id = (String) Preconditions.checkNotNull(str);
            this.resource = FileBinaryResource.createOrNull(file);
            this.size = -1;
            this.timestamp = -1;
        }

        public String getId() {
            return this.id;
        }

        public long getTimestamp() {
            if (this.timestamp < 0) {
                this.timestamp = this.resource.getFile().lastModified();
            }
            return this.timestamp;
        }

        public FileBinaryResource getResource() {
            return this.resource;
        }

        public long getSize() {
            if (this.size < 0) {
                this.size = this.resource.size();
            }
            return this.size;
        }
    }

    @VisibleForTesting
    class InserterImpl implements Inserter {
        private final String mResourceId;
        @VisibleForTesting
        final File mTemporaryFile;

        public InserterImpl(String str, File file) {
            this.mResourceId = str;
            this.mTemporaryFile = file;
        }

        public void writeData(WriterCallback writerCallback, Object obj) {
            try {
                long j = this.mTemporaryFile;
                obj = new FileOutputStream(j);
                try {
                    OutputStream countingOutputStream = new CountingOutputStream(obj);
                    writerCallback.write(countingOutputStream);
                    countingOutputStream.flush();
                    j = countingOutputStream.getCount();
                    if (this.mTemporaryFile.length() != j) {
                        throw new IncompleteFileException(j, this.mTemporaryFile.length());
                    }
                } finally {
                    obj.close();
                }
            } catch (WriterCallback writerCallback2) {
                DefaultDiskStorage.this.mCacheErrorLogger.logError(CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.TAG, "updateResource", writerCallback2);
                throw writerCallback2;
            }
        }

        public BinaryResource commit(Object obj) {
            obj = DefaultDiskStorage.this.getContentFileFor(this.mResourceId);
            try {
                FileUtils.rename(this.mTemporaryFile, obj);
                if (obj.exists()) {
                    obj.setLastModified(DefaultDiskStorage.this.mClock.now());
                }
                return FileBinaryResource.createOrNull(obj);
            } catch (Object obj2) {
                CacheErrorCategory cacheErrorCategory;
                Throwable cause = obj2.getCause();
                if (cause == null) {
                    cacheErrorCategory = CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                } else if (cause instanceof ParentDirNotFoundException) {
                    cacheErrorCategory = CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                } else if (cause instanceof FileNotFoundException) {
                    cacheErrorCategory = CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                } else {
                    cacheErrorCategory = CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                }
                DefaultDiskStorage.this.mCacheErrorLogger.logError(cacheErrorCategory, DefaultDiskStorage.TAG, "commit", obj2);
                throw obj2;
            }
        }

        public boolean cleanUp() {
            if (this.mTemporaryFile.exists()) {
                if (!this.mTemporaryFile.delete()) {
                    return false;
                }
            }
            return true;
        }
    }

    private class PurgingVisitor implements FileTreeVisitor {
        private boolean insideBaseDirectory;

        private PurgingVisitor() {
        }

        public void preVisitDirectory(File file) {
            if (!this.insideBaseDirectory && file.equals(DefaultDiskStorage.this.mVersionDirectory) != null) {
                this.insideBaseDirectory = true;
            }
        }

        public void visitFile(File file) {
            if (!this.insideBaseDirectory || !isExpectedFile(file)) {
                file.delete();
            }
        }

        public void postVisitDirectory(File file) {
            if (!(DefaultDiskStorage.this.mRootDirectory.equals(file) || this.insideBaseDirectory)) {
                file.delete();
            }
            if (this.insideBaseDirectory && file.equals(DefaultDiskStorage.this.mVersionDirectory) != null) {
                this.insideBaseDirectory = null;
            }
        }

        private boolean isExpectedFile(File file) {
            FileInfo access$000 = DefaultDiskStorage.this.getShardFileInfo(file);
            boolean z = false;
            if (access$000 == null) {
                return false;
            }
            if (access$000.type == ".tmp") {
                return isRecentFile(file);
            }
            if (access$000.type == ".cnt") {
                z = true;
            }
            Preconditions.checkState(z);
            return true;
        }

        private boolean isRecentFile(File file) {
            return file.lastModified() > DefaultDiskStorage.this.mClock.now() - DefaultDiskStorage.TEMP_FILE_LIFETIME_MS ? true : null;
        }
    }

    public boolean isEnabled() {
        return true;
    }

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        Preconditions.checkNotNull(file);
        this.mRootDirectory = file;
        this.mIsExternal = isExternal(file, cacheErrorLogger);
        this.mVersionDirectory = new File(this.mRootDirectory, getVersionSubdirectoryName(i));
        this.mCacheErrorLogger = cacheErrorLogger;
        recreateDirectoryIfVersionChanges();
    }

    private static boolean isExternal(File file, CacheErrorLogger cacheErrorLogger) {
        Throwable e;
        CacheErrorCategory cacheErrorCategory;
        Class cls;
        StringBuilder stringBuilder;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                return false;
            }
            CharSequence file2 = externalStorageDirectory.toString();
            try {
                file = file.getCanonicalPath();
                try {
                    return file.contains(file2);
                } catch (IOException e2) {
                    e = e2;
                    cacheErrorCategory = CacheErrorCategory.OTHER;
                    cls = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("failed to read folder to check if external: ");
                    stringBuilder.append(file);
                    cacheErrorLogger.logError(cacheErrorCategory, cls, stringBuilder.toString(), e);
                    return false;
                }
            } catch (IOException e3) {
                e = e3;
                file = null;
                cacheErrorCategory = CacheErrorCategory.OTHER;
                cls = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("failed to read folder to check if external: ");
                stringBuilder.append(file);
                cacheErrorLogger.logError(cacheErrorCategory, cls, stringBuilder.toString(), e);
                return false;
            }
        } catch (File file3) {
            cacheErrorLogger.logError(CacheErrorCategory.OTHER, TAG, "failed to get the external storage directory!", file3);
            return false;
        }
    }

    @VisibleForTesting
    static String getVersionSubdirectoryName(int i) {
        return String.format((Locale) null, "%s.ols%d.%d", new Object[]{DEFAULT_DISK_STORAGE_VERSION_PREFIX, Integer.valueOf(100), Integer.valueOf(i)});
    }

    public boolean isExternal() {
        return this.mIsExternal;
    }

    public String getStorageName() {
        String absolutePath = this.mRootDirectory.getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_");
        stringBuilder.append(absolutePath.substring(absolutePath.lastIndexOf(47) + 1, absolutePath.length()));
        stringBuilder.append("_");
        stringBuilder.append(absolutePath.hashCode());
        return stringBuilder.toString();
    }

    private void recreateDirectoryIfVersionChanges() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = r5.mRootDirectory;
        r0 = r0.exists();
        r1 = 1;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0019;
    L_0x000a:
        r0 = r5.mVersionDirectory;
        r0 = r0.exists();
        if (r0 != 0) goto L_0x0018;
    L_0x0012:
        r0 = r5.mRootDirectory;
        com.facebook.common.file.FileTree.deleteRecursively(r0);
        goto L_0x0019;
    L_0x0018:
        r1 = 0;
    L_0x0019:
        if (r1 == 0) goto L_0x003e;
    L_0x001b:
        r0 = r5.mVersionDirectory;	 Catch:{ CreateDirectoryException -> 0x0021 }
        com.facebook.common.file.FileUtils.mkdirs(r0);	 Catch:{ CreateDirectoryException -> 0x0021 }
        goto L_0x003e;
    L_0x0021:
        r0 = r5.mCacheErrorLogger;
        r1 = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR;
        r2 = TAG;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "version directory could not be created: ";
        r3.append(r4);
        r4 = r5.mVersionDirectory;
        r3.append(r4);
        r3 = r3.toString();
        r4 = 0;
        r0.logError(r1, r2, r3, r4);
    L_0x003e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DefaultDiskStorage.recreateDirectoryIfVersionChanges():void");
    }

    @VisibleForTesting
    File getContentFileFor(String str) {
        return new File(getFilename(str));
    }

    private String getSubdirectoryPath(String str) {
        str = String.valueOf(Math.abs(str.hashCode() % 100));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mVersionDirectory);
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private File getSubdirectory(String str) {
        return new File(getSubdirectoryPath(str));
    }

    public void purgeUnexpectedResources() {
        FileTree.walkFileTree(this.mRootDirectory, new PurgingVisitor());
    }

    private void mkdirs(File file, String str) {
        try {
            FileUtils.mkdirs(file);
        } catch (File file2) {
            this.mCacheErrorLogger.logError(CacheErrorCategory.WRITE_CREATE_DIR, TAG, str, file2);
            throw file2;
        }
    }

    public Inserter insert(String str, Object obj) {
        obj = new FileInfo(".tmp", str);
        File subdirectory = getSubdirectory(obj.resourceId);
        if (!subdirectory.exists()) {
            mkdirs(subdirectory, "insert");
        }
        try {
            return new InserterImpl(str, obj.createTempFile(subdirectory));
        } catch (String str2) {
            this.mCacheErrorLogger.logError(CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "insert", str2);
            throw str2;
        }
    }

    public BinaryResource getResource(String str, Object obj) {
        str = getContentFileFor(str);
        if (str.exists() == null) {
            return null;
        }
        str.setLastModified(this.mClock.now());
        return FileBinaryResource.createOrNull(str);
    }

    private String getFilename(String str) {
        FileInfo fileInfo = new FileInfo(".cnt", str);
        return fileInfo.toPath(getSubdirectoryPath(fileInfo.resourceId));
    }

    public boolean contains(String str, Object obj) {
        return query(str, null);
    }

    public boolean touch(String str, Object obj) {
        return query(str, true);
    }

    private boolean query(String str, boolean z) {
        str = getContentFileFor(str);
        boolean exists = str.exists();
        if (z && exists) {
            str.setLastModified(this.mClock.now());
        }
        return exists;
    }

    public long remove(Entry entry) {
        return doRemove(((EntryImpl) entry).getResource().getFile());
    }

    public long remove(String str) {
        return doRemove(getContentFileFor(str));
    }

    private long doRemove(File file) {
        if (!file.exists()) {
            return 0;
        }
        return file.delete() != null ? file.length() : -1;
    }

    public void clearAll() {
        FileTree.deleteContents(this.mRootDirectory);
    }

    public DiskDumpInfo getDumpInfo() {
        List<Entry> entries = getEntries();
        DiskDumpInfo diskDumpInfo = new DiskDumpInfo();
        for (Entry dumpCacheEntry : entries) {
            DiskDumpInfoEntry dumpCacheEntry2 = dumpCacheEntry(dumpCacheEntry);
            String str = dumpCacheEntry2.type;
            if (!diskDumpInfo.typeCounts.containsKey(str)) {
                diskDumpInfo.typeCounts.put(str, Integer.valueOf(0));
            }
            diskDumpInfo.typeCounts.put(str, Integer.valueOf(((Integer) diskDumpInfo.typeCounts.get(str)).intValue() + 1));
            diskDumpInfo.entries.add(dumpCacheEntry2);
        }
        return diskDumpInfo;
    }

    private DiskDumpInfoEntry dumpCacheEntry(Entry entry) {
        EntryImpl entryImpl = (EntryImpl) entry;
        String str = "";
        byte[] read = entryImpl.getResource().read();
        String typeOfBytes = typeOfBytes(read);
        if (typeOfBytes.equals("undefined") && read.length >= 4) {
            str = String.format((Locale) null, "0x%02X 0x%02X 0x%02X 0x%02X", new Object[]{Byte.valueOf(read[0]), Byte.valueOf(read[1]), Byte.valueOf(read[2]), Byte.valueOf(read[3])});
        }
        return new DiskDumpInfoEntry(entryImpl.getResource().getFile().getPath(), typeOfBytes, (float) entryImpl.getSize(), str);
    }

    private String typeOfBytes(byte[] bArr) {
        if (bArr.length >= 2) {
            if (bArr[0] == (byte) -1 && bArr[1] == (byte) -40) {
                return "jpg";
            }
            if (bArr[0] == (byte) -119 && bArr[1] == (byte) 80) {
                return "png";
            }
            if (bArr[0] == (byte) 82 && bArr[1] == (byte) 73) {
                return "webp";
            }
            if (bArr[0] == (byte) 71 && bArr[1] == 73) {
                return "gif";
            }
        }
        return "undefined";
    }

    public List<Entry> getEntries() {
        Object entriesCollector = new EntriesCollector();
        FileTree.walkFileTree(this.mVersionDirectory, entriesCollector);
        return entriesCollector.getEntries();
    }

    private FileInfo getShardFileInfo(File file) {
        FileInfo fromFile = FileInfo.fromFile(file);
        if (fromFile == null) {
            return null;
        }
        if (getSubdirectory(fromFile.resourceId).equals(file.getParentFile()) == null) {
            fromFile = null;
        }
        return fromFile;
    }

    @FileType
    private static String getFileTypefromExtension(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        return ".tmp".equals(str) != null ? ".tmp" : null;
    }
}
