package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.common.util.ByteConstants;
import com.facebook.imageutils.JfifUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class FileLruCache {
    private static final String HEADER_CACHEKEY_KEY = "key";
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    static final String TAG = "FileLruCache";
    private static final AtomicLong bufferIndex = new AtomicLong();
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    private AtomicLong lastClearCacheTime = new AtomicLong(0);
    private final Limits limits;
    private final Object lock;
    private final String tag;

    /* renamed from: com.facebook.internal.FileLruCache$3 */
    class C18033 implements Runnable {
        C18033() {
        }

        public void run() {
            FileLruCache.this.trim();
        }
    }

    private static class BufferFile {
        private static final String FILE_NAME_PREFIX = "buffer";
        private static final FilenameFilter filterExcludeBufferFiles = new C18041();
        private static final FilenameFilter filterExcludeNonBufferFiles = new C18052();

        /* renamed from: com.facebook.internal.FileLruCache$BufferFile$1 */
        static class C18041 implements FilenameFilter {
            C18041() {
            }

            public boolean accept(File file, String str) {
                return str.startsWith(BufferFile.FILE_NAME_PREFIX) ^ 1;
            }
        }

        /* renamed from: com.facebook.internal.FileLruCache$BufferFile$2 */
        static class C18052 implements FilenameFilter {
            C18052() {
            }

            public boolean accept(File file, String str) {
                return str.startsWith(BufferFile.FILE_NAME_PREFIX);
            }
        }

        private BufferFile() {
        }

        static void deleteAll(File file) {
            file = file.listFiles(excludeNonBufferFiles());
            if (file != null) {
                for (File delete : file) {
                    delete.delete();
                }
            }
        }

        static FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        static FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        static File newFile(File file) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(FILE_NAME_PREFIX);
            stringBuilder.append(Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
            return new File(file, stringBuilder.toString());
        }
    }

    private static class CloseCallbackOutputStream extends OutputStream {
        final StreamCloseCallback callback;
        final OutputStream innerStream;

        CloseCallbackOutputStream(OutputStream outputStream, StreamCloseCallback streamCloseCallback) {
            this.innerStream = outputStream;
            this.callback = streamCloseCallback;
        }

        public void close() {
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
            }
        }

        public void flush() {
            this.innerStream.flush();
        }

        public void write(byte[] bArr, int i, int i2) {
            this.innerStream.write(bArr, i, i2);
        }

        public void write(byte[] bArr) {
            this.innerStream.write(bArr);
        }

        public void write(int i) {
            this.innerStream.write(i);
        }
    }

    private static final class CopyingInputStream extends InputStream {
        final InputStream input;
        final OutputStream output;

        public boolean markSupported() {
            return false;
        }

        CopyingInputStream(InputStream inputStream, OutputStream outputStream) {
            this.input = inputStream;
            this.output = outputStream;
        }

        public int available() {
            return this.input.available();
        }

        public void close() {
            try {
                this.input.close();
            } finally {
                this.output.close();
            }
        }

        public void mark(int i) {
            throw new UnsupportedOperationException();
        }

        public int read(byte[] bArr) {
            int read = this.input.read(bArr);
            if (read > 0) {
                this.output.write(bArr, 0, read);
            }
            return read;
        }

        public int read() {
            int read = this.input.read();
            if (read >= 0) {
                this.output.write(read);
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            i2 = this.input.read(bArr, i, i2);
            if (i2 > 0) {
                this.output.write(bArr, i, i2);
            }
            return i2;
        }

        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        public long skip(long j) {
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (j2 < j) {
                int read = read(bArr, 0, (int) Math.min(j - j2, (long) bArr.length));
                if (read < 0) {
                    return j2;
                }
                j2 += (long) read;
            }
            return j2;
        }
    }

    public static final class Limits {
        private int byteCount = ByteConstants.MB;
        private int fileCount = 1024;

        int getByteCount() {
            return this.byteCount;
        }

        int getFileCount() {
            return this.fileCount;
        }

        void setByteCount(int i) {
            if (i >= 0) {
                this.byteCount = i;
                return;
            }
            throw new InvalidParameterException("Cache byte-count limit must be >= 0");
        }

        void setFileCount(int i) {
            if (i >= 0) {
                this.fileCount = i;
                return;
            }
            throw new InvalidParameterException("Cache file count limit must be >= 0");
        }
    }

    private static final class ModifiedFile implements Comparable<ModifiedFile> {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        private final File file;
        private final long modified;

        ModifiedFile(File file) {
            this.file = file;
            this.modified = file.lastModified();
        }

        File getFile() {
            return this.file;
        }

        long getModified() {
            return this.modified;
        }

        public int compareTo(ModifiedFile modifiedFile) {
            if (getModified() < modifiedFile.getModified()) {
                return -1;
            }
            if (getModified() > modifiedFile.getModified()) {
                return 1;
            }
            return getFile().compareTo(modifiedFile.getFile());
        }

        public boolean equals(Object obj) {
            return ((obj instanceof ModifiedFile) && compareTo((ModifiedFile) obj) == null) ? true : null;
        }

        public int hashCode() {
            return ((1073 + this.file.hashCode()) * 37) + ((int) (this.modified % 2147483647L));
        }
    }

    private interface StreamCloseCallback {
        void onClose();
    }

    private static final class StreamHeader {
        private static final int HEADER_VERSION = 0;

        private StreamHeader() {
        }

        static void writeHeader(OutputStream outputStream, JSONObject jSONObject) {
            jSONObject = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write((jSONObject.length >> 16) & JfifUtil.MARKER_FIRST_BYTE);
            outputStream.write((jSONObject.length >> 8) & JfifUtil.MARKER_FIRST_BYTE);
            outputStream.write((jSONObject.length >> 0) & JfifUtil.MARKER_FIRST_BYTE);
            outputStream.write(jSONObject);
        }

        static JSONObject readHeader(InputStream inputStream) {
            if (inputStream.read() != 0) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int read = inputStream.read();
                if (read == -1) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i2 = (i2 << 8) + (read & JfifUtil.MARKER_FIRST_BYTE);
            }
            byte[] bArr = new byte[i2];
            while (i < bArr.length) {
                i2 = inputStream.read(bArr, i, bArr.length - i);
                if (i2 < 1) {
                    inputStream = LoggingBehavior.CACHE;
                    String str = FileLruCache.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("readHeader: stream.read stopped at ");
                    stringBuilder.append(Integer.valueOf(i));
                    stringBuilder.append(" when expected ");
                    stringBuilder.append(bArr.length);
                    Logger.log(inputStream, str, stringBuilder.toString());
                    return null;
                }
                i += i2;
            }
            try {
                inputStream = new JSONTokener(new String(bArr)).nextValue();
                if (inputStream instanceof JSONObject) {
                    return (JSONObject) inputStream;
                }
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str2 = FileLruCache.TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("readHeader: expected JSONObject, got ");
                stringBuilder2.append(inputStream.getClass().getCanonicalName());
                Logger.log(loggingBehavior, str2, stringBuilder2.toString());
                return null;
            } catch (InputStream inputStream2) {
                throw new IOException(inputStream2.getMessage());
            }
        }
    }

    public FileLruCache(String str, Limits limits) {
        this.tag = str;
        this.limits = limits;
        this.directory = new File(FacebookSdk.getCacheDir(), str);
        this.lock = new Object();
        if (this.directory.mkdirs() != null || this.directory.isDirectory() != null) {
            BufferFile.deleteAll(this.directory);
        }
    }

    long sizeInBytesForTest() {
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
        r7 = this;
        r0 = r7.lock;
        monitor-enter(r0);
    L_0x0003:
        r1 = r7.isTrimPending;	 Catch:{ all -> 0x002c }
        if (r1 != 0) goto L_0x0026;	 Catch:{ all -> 0x002c }
    L_0x0007:
        r1 = r7.isTrimInProgress;	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x000c;	 Catch:{ all -> 0x002c }
    L_0x000b:
        goto L_0x0026;	 Catch:{ all -> 0x002c }
    L_0x000c:
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
        r0 = r7.directory;
        r0 = r0.listFiles();
        r1 = 0;
        if (r0 == 0) goto L_0x0025;
    L_0x0017:
        r3 = r0.length;
        r4 = 0;
    L_0x0019:
        if (r4 >= r3) goto L_0x0025;
    L_0x001b:
        r5 = r0[r4];
        r5 = r5.length();
        r1 = r1 + r5;
        r4 = r4 + 1;
        goto L_0x0019;
    L_0x0025:
        return r1;
    L_0x0026:
        r1 = r7.lock;	 Catch:{ InterruptedException -> 0x0003 }
        r1.wait();	 Catch:{ InterruptedException -> 0x0003 }
        goto L_0x0003;
    L_0x002c:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FileLruCache.sizeInBytesForTest():long");
    }

    public InputStream get(String str) {
        return get(str, null);
    }

    public java.io.InputStream get(java.lang.String r7, java.lang.String r8) {
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
        r6 = this;
        r0 = new java.io.File;
        r1 = r6.directory;
        r2 = com.facebook.internal.Utility.md5hash(r7);
        r0.<init>(r1, r2);
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0085 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0085 }
        r3 = new java.io.BufferedInputStream;
        r4 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r3.<init>(r2, r4);
        r2 = com.facebook.internal.FileLruCache.StreamHeader.readHeader(r3);	 Catch:{ all -> 0x0080 }
        if (r2 != 0) goto L_0x0022;
    L_0x001e:
        r3.close();
        return r1;
    L_0x0022:
        r4 = "key";	 Catch:{ all -> 0x0080 }
        r4 = r2.optString(r4);	 Catch:{ all -> 0x0080 }
        if (r4 == 0) goto L_0x007c;	 Catch:{ all -> 0x0080 }
    L_0x002a:
        r7 = r4.equals(r7);	 Catch:{ all -> 0x0080 }
        if (r7 != 0) goto L_0x0031;	 Catch:{ all -> 0x0080 }
    L_0x0030:
        goto L_0x007c;	 Catch:{ all -> 0x0080 }
    L_0x0031:
        r7 = "tag";	 Catch:{ all -> 0x0080 }
        r7 = r2.optString(r7, r1);	 Catch:{ all -> 0x0080 }
        if (r8 != 0) goto L_0x003b;	 Catch:{ all -> 0x0080 }
    L_0x0039:
        if (r7 != 0) goto L_0x0043;	 Catch:{ all -> 0x0080 }
    L_0x003b:
        if (r8 == 0) goto L_0x0047;	 Catch:{ all -> 0x0080 }
    L_0x003d:
        r7 = r8.equals(r7);	 Catch:{ all -> 0x0080 }
        if (r7 != 0) goto L_0x0047;
    L_0x0043:
        r3.close();
        return r1;
    L_0x0047:
        r7 = new java.util.Date;	 Catch:{ all -> 0x0080 }
        r7.<init>();	 Catch:{ all -> 0x0080 }
        r7 = r7.getTime();	 Catch:{ all -> 0x0080 }
        r1 = com.facebook.LoggingBehavior.CACHE;	 Catch:{ all -> 0x0080 }
        r2 = TAG;	 Catch:{ all -> 0x0080 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0080 }
        r4.<init>();	 Catch:{ all -> 0x0080 }
        r5 = "Setting lastModified to ";	 Catch:{ all -> 0x0080 }
        r4.append(r5);	 Catch:{ all -> 0x0080 }
        r5 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x0080 }
        r4.append(r5);	 Catch:{ all -> 0x0080 }
        r5 = " for ";	 Catch:{ all -> 0x0080 }
        r4.append(r5);	 Catch:{ all -> 0x0080 }
        r5 = r0.getName();	 Catch:{ all -> 0x0080 }
        r4.append(r5);	 Catch:{ all -> 0x0080 }
        r4 = r4.toString();	 Catch:{ all -> 0x0080 }
        com.facebook.internal.Logger.log(r1, r2, r4);	 Catch:{ all -> 0x0080 }
        r0.setLastModified(r7);	 Catch:{ all -> 0x0080 }
        return r3;
    L_0x007c:
        r3.close();
        return r1;
    L_0x0080:
        r7 = move-exception;
        r3.close();
        throw r7;
    L_0x0085:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FileLruCache.get(java.lang.String, java.lang.String):java.io.InputStream");
    }

    public OutputStream openPutStream(String str) {
        return openPutStream(str, null);
    }

    public OutputStream openPutStream(String str, String str2) {
        LoggingBehavior loggingBehavior;
        String str3;
        final File newFile = BufferFile.newFile(this.directory);
        newFile.delete();
        if (newFile.createNewFile()) {
            try {
                OutputStream fileOutputStream = new FileOutputStream(newFile);
                final long currentTimeMillis = System.currentTimeMillis();
                final String str4 = str;
                OutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(fileOutputStream, new StreamCloseCallback() {
                    public void onClose() {
                        if (currentTimeMillis < FileLruCache.this.lastClearCacheTime.get()) {
                            newFile.delete();
                        } else {
                            FileLruCache.this.renameToTargetAndTrim(str4, newFile);
                        }
                    }
                }), Utility.DEFAULT_STREAM_BUFFER_SIZE);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(HEADER_CACHEKEY_KEY, str);
                    if (Utility.isNullOrEmpty(str2) == null) {
                        jSONObject.put(HEADER_CACHE_CONTENT_TAG_KEY, str2);
                    }
                    StreamHeader.writeHeader(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (String str5) {
                    loggingBehavior = LoggingBehavior.CACHE;
                    str3 = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error creating JSON header for cache file: ");
                    stringBuilder.append(str5);
                    Logger.log(loggingBehavior, 5, str3, stringBuilder.toString());
                    throw new IOException(str5.getMessage());
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                }
            } catch (String str52) {
                loggingBehavior = LoggingBehavior.CACHE;
                str3 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Error creating buffer output stream: ");
                stringBuilder2.append(str52);
                Logger.log(loggingBehavior, 5, str3, stringBuilder2.toString());
                throw new IOException(str52.getMessage());
            }
        }
        str2 = new StringBuilder();
        str2.append("Could not create file at ");
        str2.append(newFile.getAbsolutePath());
        throw new IOException(str2.toString());
    }

    public void clearCache() {
        final File[] listFiles = this.directory.listFiles(BufferFile.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (listFiles != null) {
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    for (File delete : listFiles) {
                        delete.delete();
                    }
                }
            });
        }
    }

    public String getLocation() {
        return this.directory.getPath();
    }

    private void renameToTargetAndTrim(String str, File file) {
        if (file.renameTo(new File(this.directory, Utility.md5hash(str))) == null) {
            file.delete();
        }
        postTrim();
    }

    public InputStream interceptAndPut(String str, InputStream inputStream) {
        return new CopyingInputStream(inputStream, openPutStream(str));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{FileLruCache: tag:");
        stringBuilder.append(this.tag);
        stringBuilder.append(" file:");
        stringBuilder.append(this.directory.getName());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void postTrim() {
        synchronized (this.lock) {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk.getExecutor().execute(new C18033());
            }
        }
    }

    private void trim() {
        synchronized (this.lock) {
            r1.isTrimPending = false;
            r1.isTrimInProgress = true;
        }
        try {
            long j;
            Logger.log(LoggingBehavior.CACHE, TAG, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            File[] listFiles = r1.directory.listFiles(BufferFile.excludeBufferFiles());
            long j2 = 0;
            if (listFiles != null) {
                long j3 = 0;
                j = j3;
                for (File file : listFiles) {
                    ModifiedFile modifiedFile = new ModifiedFile(file);
                    priorityQueue.add(modifiedFile);
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String str = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("  trim considering time=");
                    stringBuilder.append(Long.valueOf(modifiedFile.getModified()));
                    stringBuilder.append(" name=");
                    stringBuilder.append(modifiedFile.getFile().getName());
                    Logger.log(loggingBehavior, str, stringBuilder.toString());
                    j3 += file.length();
                    j++;
                }
                j2 = j3;
            } else {
                j = 0;
            }
            while (true) {
                if (j2 <= ((long) r1.limits.getByteCount())) {
                    if (j <= ((long) r1.limits.getFileCount())) {
                        synchronized (r1.lock) {
                            r1.isTrimInProgress = false;
                            r1.lock.notifyAll();
                        }
                        return;
                    }
                }
                File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                String str2 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("  trim removing ");
                stringBuilder2.append(file2.getName());
                Logger.log(loggingBehavior2, str2, stringBuilder2.toString());
                j2 -= file2.length();
                j--;
                file2.delete();
            }
        } catch (Throwable th) {
            synchronized (r1.lock) {
                r1.isTrimInProgress = false;
                r1.lock.notifyAll();
            }
        }
    }
}
