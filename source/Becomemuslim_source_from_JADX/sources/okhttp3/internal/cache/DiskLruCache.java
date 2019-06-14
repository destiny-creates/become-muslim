package okhttp3.internal.cache;

import com.facebook.ads.AdError;
import com.facebook.cache.disk.DefaultDiskStorage.FileType;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import p286d.C5870l;
import p286d.C5876t;
import p286d.C7203d;

public final class DiskLruCache implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable = new C66201();
    boolean closed;
    final File directory;
    private final Executor executor;
    final FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    C7203d journalWriter;
    final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75f, true);
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    private long nextSequenceNumber = 0;
    int redundantOpCount;
    private long size = 0;
    final int valueCount;

    /* renamed from: okhttp3.internal.cache.DiskLruCache$1 */
    class C66201 implements Runnable {
        C66201() {
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = okhttp3.internal.cache.DiskLruCache.this;
            monitor-enter(r0);
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ all -> 0x0041 }
            r1 = r1.initialized;	 Catch:{ all -> 0x0041 }
            r2 = 1;	 Catch:{ all -> 0x0041 }
            r1 = r1 ^ r2;	 Catch:{ all -> 0x0041 }
            r3 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ all -> 0x0041 }
            r3 = r3.closed;	 Catch:{ all -> 0x0041 }
            r1 = r1 | r3;	 Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x0012;	 Catch:{ all -> 0x0041 }
        L_0x0010:
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            return;
        L_0x0012:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x0018 }
            r1.trimToSize();	 Catch:{ IOException -> 0x0018 }
            goto L_0x001c;
        L_0x0018:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ all -> 0x0041 }
            r1.mostRecentTrimFailed = r2;	 Catch:{ all -> 0x0041 }
        L_0x001c:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x002f }
            r1 = r1.journalRebuildRequired();	 Catch:{ IOException -> 0x002f }
            if (r1 == 0) goto L_0x003f;	 Catch:{ IOException -> 0x002f }
        L_0x0024:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x002f }
            r1.rebuildJournal();	 Catch:{ IOException -> 0x002f }
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x002f }
            r3 = 0;	 Catch:{ IOException -> 0x002f }
            r1.redundantOpCount = r3;	 Catch:{ IOException -> 0x002f }
            goto L_0x003f;
        L_0x002f:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ all -> 0x0041 }
            r1.mostRecentRebuildFailed = r2;	 Catch:{ all -> 0x0041 }
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ all -> 0x0041 }
            r2 = p286d.C5870l.m24721a();	 Catch:{ all -> 0x0041 }
            r2 = p286d.C5870l.m24719a(r2);	 Catch:{ all -> 0x0041 }
            r1.journalWriter = r2;	 Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            return;	 Catch:{ all -> 0x0041 }
        L_0x0041:
            r1 = move-exception;	 Catch:{ all -> 0x0041 }
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.1.run():void");
        }
    }

    /* renamed from: okhttp3.internal.cache.DiskLruCache$3 */
    class C66213 implements Iterator<Snapshot> {
        final Iterator<Entry> delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
        Snapshot nextSnapshot;
        Snapshot removeSnapshot;

        C66213() {
        }

        public boolean hasNext() {
            if (this.nextSnapshot != null) {
                return true;
            }
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.closed) {
                    return false;
                }
                while (this.delegate.hasNext()) {
                    Snapshot snapshot = ((Entry) this.delegate.next()).snapshot();
                    if (snapshot != null) {
                        this.nextSnapshot = snapshot;
                        return true;
                    }
                }
                return false;
            }
        }

        public Snapshot next() {
            if (hasNext()) {
                this.removeSnapshot = this.nextSnapshot;
                this.nextSnapshot = null;
                return this.removeSnapshot;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.removeSnapshot;
            if (r0 == 0) goto L_0x0018;
        L_0x0004:
            r0 = 0;
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x0015, all -> 0x0011 }
            r2 = r3.removeSnapshot;	 Catch:{ IOException -> 0x0015, all -> 0x0011 }
            r2 = r2.key;	 Catch:{ IOException -> 0x0015, all -> 0x0011 }
            r1.remove(r2);	 Catch:{ IOException -> 0x0015, all -> 0x0011 }
            goto L_0x0015;
        L_0x0011:
            r1 = move-exception;
            r3.removeSnapshot = r0;
            throw r1;
        L_0x0015:
            r3.removeSnapshot = r0;
            return;
        L_0x0018:
            r0 = new java.lang.IllegalStateException;
            r1 = "remove() before next()";
            r0.<init>(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.3.remove():void");
        }
    }

    public final class Editor {
        private boolean done;
        final Entry entry;
        final boolean[] written;

        Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable != null ? null : new boolean[DiskLruCache.this.valueCount];
        }

        void detach() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.entry;
            r0 = r0.currentEditor;
            if (r0 != r3) goto L_0x0022;
        L_0x0006:
            r0 = 0;
        L_0x0007:
            r1 = okhttp3.internal.cache.DiskLruCache.this;
            r1 = r1.valueCount;
            if (r0 >= r1) goto L_0x001d;
        L_0x000d:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x001a }
            r1 = r1.fileSystem;	 Catch:{ IOException -> 0x001a }
            r2 = r3.entry;	 Catch:{ IOException -> 0x001a }
            r2 = r2.dirtyFiles;	 Catch:{ IOException -> 0x001a }
            r2 = r2[r0];	 Catch:{ IOException -> 0x001a }
            r1.delete(r2);	 Catch:{ IOException -> 0x001a }
        L_0x001a:
            r0 = r0 + 1;
            goto L_0x0007;
        L_0x001d:
            r0 = r3.entry;
            r1 = 0;
            r0.currentEditor = r1;
        L_0x0022:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.detach():void");
        }

        public p286d.C5876t newSource(int r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = okhttp3.internal.cache.DiskLruCache.this;
            monitor-enter(r0);
            r1 = r4.done;	 Catch:{ all -> 0x002f }
            if (r1 != 0) goto L_0x0029;	 Catch:{ all -> 0x002f }
        L_0x0007:
            r1 = r4.entry;	 Catch:{ all -> 0x002f }
            r1 = r1.readable;	 Catch:{ all -> 0x002f }
            r2 = 0;	 Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0027;	 Catch:{ all -> 0x002f }
        L_0x000e:
            r1 = r4.entry;	 Catch:{ all -> 0x002f }
            r1 = r1.currentEditor;	 Catch:{ all -> 0x002f }
            if (r1 == r4) goto L_0x0015;
        L_0x0014:
            goto L_0x0027;
        L_0x0015:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ FileNotFoundException -> 0x0025 }
            r1 = r1.fileSystem;	 Catch:{ FileNotFoundException -> 0x0025 }
            r3 = r4.entry;	 Catch:{ FileNotFoundException -> 0x0025 }
            r3 = r3.cleanFiles;	 Catch:{ FileNotFoundException -> 0x0025 }
            r5 = r3[r5];	 Catch:{ FileNotFoundException -> 0x0025 }
            r5 = r1.source(r5);	 Catch:{ FileNotFoundException -> 0x0025 }
            monitor-exit(r0);	 Catch:{ all -> 0x002f }
            return r5;	 Catch:{ all -> 0x002f }
        L_0x0025:
            monitor-exit(r0);	 Catch:{ all -> 0x002f }
            return r2;	 Catch:{ all -> 0x002f }
        L_0x0027:
            monitor-exit(r0);	 Catch:{ all -> 0x002f }
            return r2;	 Catch:{ all -> 0x002f }
        L_0x0029:
            r5 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x002f }
            r5.<init>();	 Catch:{ all -> 0x002f }
            throw r5;	 Catch:{ all -> 0x002f }
        L_0x002f:
            r5 = move-exception;	 Catch:{ all -> 0x002f }
            monitor-exit(r0);	 Catch:{ all -> 0x002f }
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSource(int):d.t");
        }

        public p286d.C5875s newSink(int r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = okhttp3.internal.cache.DiskLruCache.this;
            monitor-enter(r0);
            r1 = r3.done;	 Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x0039;	 Catch:{ all -> 0x003f }
        L_0x0007:
            r1 = r3.entry;	 Catch:{ all -> 0x003f }
            r1 = r1.currentEditor;	 Catch:{ all -> 0x003f }
            if (r1 == r3) goto L_0x0013;	 Catch:{ all -> 0x003f }
        L_0x000d:
            r4 = p286d.C5870l.m24721a();	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            return r4;	 Catch:{ all -> 0x003f }
        L_0x0013:
            r1 = r3.entry;	 Catch:{ all -> 0x003f }
            r1 = r1.readable;	 Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x001e;	 Catch:{ all -> 0x003f }
        L_0x0019:
            r1 = r3.written;	 Catch:{ all -> 0x003f }
            r2 = 1;	 Catch:{ all -> 0x003f }
            r1[r4] = r2;	 Catch:{ all -> 0x003f }
        L_0x001e:
            r1 = r3.entry;	 Catch:{ all -> 0x003f }
            r1 = r1.dirtyFiles;	 Catch:{ all -> 0x003f }
            r4 = r1[r4];	 Catch:{ all -> 0x003f }
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ FileNotFoundException -> 0x0033 }
            r1 = r1.fileSystem;	 Catch:{ FileNotFoundException -> 0x0033 }
            r4 = r1.sink(r4);	 Catch:{ FileNotFoundException -> 0x0033 }
            r1 = new okhttp3.internal.cache.DiskLruCache$Editor$1;	 Catch:{ all -> 0x003f }
            r1.<init>(r4);	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            return r1;	 Catch:{ all -> 0x003f }
        L_0x0033:
            r4 = p286d.C5870l.m24721a();	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            return r4;	 Catch:{ all -> 0x003f }
        L_0x0039:
            r4 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x003f }
            r4.<init>();	 Catch:{ all -> 0x003f }
            throw r4;	 Catch:{ all -> 0x003f }
        L_0x003f:
            r4 = move-exception;	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSink(int):d.s");
        }

        public void commit() {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    DiskLruCache.this.completeEdit(this, true);
                }
                this.done = true;
            }
        }

        public void abort() {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    DiskLruCache.this.completeEdit(this, false);
                }
                this.done = true;
            }
        }

        public void abortUnlessCommitted() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = okhttp3.internal.cache.DiskLruCache.this;
            monitor-enter(r0);
            r1 = r3.done;	 Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013;	 Catch:{ all -> 0x0015 }
        L_0x0007:
            r1 = r3.entry;	 Catch:{ all -> 0x0015 }
            r1 = r1.currentEditor;	 Catch:{ all -> 0x0015 }
            if (r1 != r3) goto L_0x0013;
        L_0x000d:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x0013 }
            r2 = 0;	 Catch:{ IOException -> 0x0013 }
            r1.completeEdit(r3, r2);	 Catch:{ IOException -> 0x0013 }
        L_0x0013:
            monitor-exit(r0);	 Catch:{ all -> 0x0015 }
            return;	 Catch:{ all -> 0x0015 }
        L_0x0015:
            r1 = move-exception;	 Catch:{ all -> 0x0015 }
            monitor-exit(r0);	 Catch:{ all -> 0x0015 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.abortUnlessCommitted():void");
        }
    }

    private final class Entry {
        final File[] cleanFiles;
        Editor currentEditor;
        final File[] dirtyFiles;
        final String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;

        Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new File[DiskLruCache.this.valueCount];
            this.dirtyFiles = new File[DiskLruCache.this.valueCount];
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append('.');
            str = stringBuilder.length();
            for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                stringBuilder.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.this.directory, stringBuilder.toString());
                stringBuilder.append(FileType.TEMP);
                this.dirtyFiles[i] = new File(DiskLruCache.this.directory, stringBuilder.toString());
                stringBuilder.setLength(str);
            }
        }

        void setLengths(java.lang.String[] r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r5.length;
            r1 = okhttp3.internal.cache.DiskLruCache.this;
            r1 = r1.valueCount;
            if (r0 != r1) goto L_0x001e;
        L_0x0007:
            r0 = 0;
        L_0x0008:
            r1 = r5.length;	 Catch:{ NumberFormatException -> 0x0019 }
            if (r0 >= r1) goto L_0x0018;	 Catch:{ NumberFormatException -> 0x0019 }
        L_0x000b:
            r1 = r4.lengths;	 Catch:{ NumberFormatException -> 0x0019 }
            r2 = r5[r0];	 Catch:{ NumberFormatException -> 0x0019 }
            r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x0019 }
            r1[r0] = r2;	 Catch:{ NumberFormatException -> 0x0019 }
            r0 = r0 + 1;
            goto L_0x0008;
        L_0x0018:
            return;
        L_0x0019:
            r5 = r4.invalidLengths(r5);
            throw r5;
        L_0x001e:
            r5 = r4.invalidLengths(r5);
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Entry.setLengths(java.lang.String[]):void");
        }

        void writeLengths(C7203d c7203d) {
            for (long n : this.lengths) {
                c7203d.mo6307i(32).mo6316n(n);
            }
        }

        private IOException invalidLengths(String[] strArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected journal line: ");
            stringBuilder.append(Arrays.toString(strArr));
            throw new IOException(stringBuilder.toString());
        }

        okhttp3.internal.cache.DiskLruCache.Snapshot snapshot() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r10 = this;
            r0 = okhttp3.internal.cache.DiskLruCache.this;
            r0 = java.lang.Thread.holdsLock(r0);
            if (r0 == 0) goto L_0x0057;
        L_0x0008:
            r0 = okhttp3.internal.cache.DiskLruCache.this;
            r0 = r0.valueCount;
            r0 = new p286d.C5876t[r0];
            r1 = r10.lengths;
            r1 = r1.clone();
            r7 = r1;
            r7 = (long[]) r7;
            r8 = 0;
            r1 = 0;
        L_0x0019:
            r2 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ FileNotFoundException -> 0x003e }
            r2 = r2.valueCount;	 Catch:{ FileNotFoundException -> 0x003e }
            if (r1 >= r2) goto L_0x0030;	 Catch:{ FileNotFoundException -> 0x003e }
        L_0x001f:
            r2 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ FileNotFoundException -> 0x003e }
            r2 = r2.fileSystem;	 Catch:{ FileNotFoundException -> 0x003e }
            r3 = r10.cleanFiles;	 Catch:{ FileNotFoundException -> 0x003e }
            r3 = r3[r1];	 Catch:{ FileNotFoundException -> 0x003e }
            r2 = r2.source(r3);	 Catch:{ FileNotFoundException -> 0x003e }
            r0[r1] = r2;	 Catch:{ FileNotFoundException -> 0x003e }
            r1 = r1 + 1;	 Catch:{ FileNotFoundException -> 0x003e }
            goto L_0x0019;	 Catch:{ FileNotFoundException -> 0x003e }
        L_0x0030:
            r9 = new okhttp3.internal.cache.DiskLruCache$Snapshot;	 Catch:{ FileNotFoundException -> 0x003e }
            r2 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ FileNotFoundException -> 0x003e }
            r3 = r10.key;	 Catch:{ FileNotFoundException -> 0x003e }
            r4 = r10.sequenceNumber;	 Catch:{ FileNotFoundException -> 0x003e }
            r1 = r9;	 Catch:{ FileNotFoundException -> 0x003e }
            r6 = r0;	 Catch:{ FileNotFoundException -> 0x003e }
            r1.<init>(r3, r4, r6, r7);	 Catch:{ FileNotFoundException -> 0x003e }
            return r9;
        L_0x003e:
            r1 = okhttp3.internal.cache.DiskLruCache.this;
            r1 = r1.valueCount;
            if (r8 >= r1) goto L_0x0050;
        L_0x0044:
            r1 = r0[r8];
            if (r1 == 0) goto L_0x0050;
        L_0x0048:
            r1 = r0[r8];
            okhttp3.internal.Util.closeQuietly(r1);
            r8 = r8 + 1;
            goto L_0x003e;
        L_0x0050:
            r0 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x0055 }
            r0.removeEntry(r10);	 Catch:{ IOException -> 0x0055 }
        L_0x0055:
            r0 = 0;
            return r0;
        L_0x0057:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Entry.snapshot():okhttp3.internal.cache.DiskLruCache$Snapshot");
        }
    }

    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final C5876t[] sources;

        Snapshot(String str, long j, C5876t[] c5876tArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = c5876tArr;
            this.lengths = jArr;
        }

        public String key() {
            return this.key;
        }

        public Editor edit() {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public C5876t getSource(int i) {
            return this.sources[i];
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        public void close() {
            for (Closeable closeQuietly : this.sources) {
                Util.closeQuietly(closeQuietly);
            }
        }
    }

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
        this.executor = executor;
    }

    public synchronized void initialize() {
        if (!this.initialized) {
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (Throwable e) {
                    Platform platform = Platform.get();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("DiskLruCache ");
                    stringBuilder.append(this.directory);
                    stringBuilder.append(" is corrupt: ");
                    stringBuilder.append(e.getMessage());
                    stringBuilder.append(", removing");
                    platform.log(5, stringBuilder.toString(), e);
                    delete();
                } finally {
                    this.closed = false;
                }
            }
            rebuildJournal();
            this.initialized = true;
        }
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void readJournal() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.fileSystem;
        r1 = r8.journalFile;
        r0 = r0.source(r1);
        r0 = p286d.C5870l.m24720a(r0);
        r1 = r0.mo6318r();	 Catch:{ all -> 0x00ac }
        r2 = r0.mo6318r();	 Catch:{ all -> 0x00ac }
        r3 = r0.mo6318r();	 Catch:{ all -> 0x00ac }
        r4 = r0.mo6318r();	 Catch:{ all -> 0x00ac }
        r5 = r0.mo6318r();	 Catch:{ all -> 0x00ac }
        r6 = "libcore.io.DiskLruCache";	 Catch:{ all -> 0x00ac }
        r6 = r6.equals(r1);	 Catch:{ all -> 0x00ac }
        if (r6 == 0) goto L_0x0078;	 Catch:{ all -> 0x00ac }
    L_0x0028:
        r6 = "1";	 Catch:{ all -> 0x00ac }
        r6 = r6.equals(r2);	 Catch:{ all -> 0x00ac }
        if (r6 == 0) goto L_0x0078;	 Catch:{ all -> 0x00ac }
    L_0x0030:
        r6 = r8.appVersion;	 Catch:{ all -> 0x00ac }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ all -> 0x00ac }
        r3 = r6.equals(r3);	 Catch:{ all -> 0x00ac }
        if (r3 == 0) goto L_0x0078;	 Catch:{ all -> 0x00ac }
    L_0x003c:
        r3 = r8.valueCount;	 Catch:{ all -> 0x00ac }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ all -> 0x00ac }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x00ac }
        if (r3 == 0) goto L_0x0078;	 Catch:{ all -> 0x00ac }
    L_0x0048:
        r3 = "";	 Catch:{ all -> 0x00ac }
        r3 = r3.equals(r5);	 Catch:{ all -> 0x00ac }
        if (r3 == 0) goto L_0x0078;
    L_0x0050:
        r1 = 0;
    L_0x0051:
        r2 = r0.mo6318r();	 Catch:{ EOFException -> 0x005b }
        r8.readJournalLine(r2);	 Catch:{ EOFException -> 0x005b }
        r1 = r1 + 1;
        goto L_0x0051;
    L_0x005b:
        r2 = r8.lruEntries;	 Catch:{ all -> 0x00ac }
        r2 = r2.size();	 Catch:{ all -> 0x00ac }
        r1 = r1 - r2;	 Catch:{ all -> 0x00ac }
        r8.redundantOpCount = r1;	 Catch:{ all -> 0x00ac }
        r1 = r0.mo6300e();	 Catch:{ all -> 0x00ac }
        if (r1 != 0) goto L_0x006e;	 Catch:{ all -> 0x00ac }
    L_0x006a:
        r8.rebuildJournal();	 Catch:{ all -> 0x00ac }
        goto L_0x0074;	 Catch:{ all -> 0x00ac }
    L_0x006e:
        r1 = r8.newJournalWriter();	 Catch:{ all -> 0x00ac }
        r8.journalWriter = r1;	 Catch:{ all -> 0x00ac }
    L_0x0074:
        okhttp3.internal.Util.closeQuietly(r0);
        return;
    L_0x0078:
        r3 = new java.io.IOException;	 Catch:{ all -> 0x00ac }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ac }
        r6.<init>();	 Catch:{ all -> 0x00ac }
        r7 = "unexpected journal header: [";	 Catch:{ all -> 0x00ac }
        r6.append(r7);	 Catch:{ all -> 0x00ac }
        r6.append(r1);	 Catch:{ all -> 0x00ac }
        r1 = ", ";	 Catch:{ all -> 0x00ac }
        r6.append(r1);	 Catch:{ all -> 0x00ac }
        r6.append(r2);	 Catch:{ all -> 0x00ac }
        r1 = ", ";	 Catch:{ all -> 0x00ac }
        r6.append(r1);	 Catch:{ all -> 0x00ac }
        r6.append(r4);	 Catch:{ all -> 0x00ac }
        r1 = ", ";	 Catch:{ all -> 0x00ac }
        r6.append(r1);	 Catch:{ all -> 0x00ac }
        r6.append(r5);	 Catch:{ all -> 0x00ac }
        r1 = "]";	 Catch:{ all -> 0x00ac }
        r6.append(r1);	 Catch:{ all -> 0x00ac }
        r1 = r6.toString();	 Catch:{ all -> 0x00ac }
        r3.<init>(r1);	 Catch:{ all -> 0x00ac }
        throw r3;	 Catch:{ all -> 0x00ac }
    L_0x00ac:
        r1 = move-exception;
        okhttp3.internal.Util.closeQuietly(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private C7203d newJournalWriter() {
        return C5870l.m24719a(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class cls = DiskLruCache.class;
            }

            protected void onException(IOException iOException) {
                DiskLruCache.this.hasJournalErrors = true;
            }
        });
    }

    private void readJournalLine(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            String substring;
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == REMOVE.length() && str.startsWith(REMOVE)) {
                    this.lruEntries.remove(substring);
                    return;
                }
            }
            substring = str.substring(i, indexOf2);
            Entry entry = (Entry) this.lruEntries.get(substring);
            if (entry == null) {
                entry = new Entry(substring);
                this.lruEntries.put(substring, entry);
            }
            if (indexOf2 != -1 && indexOf == CLEAN.length() && str.startsWith(CLEAN)) {
                str = str.substring(indexOf2 + 1).split(" ");
                entry.readable = true;
                entry.currentEditor = null;
                entry.setLengths(str);
            } else if (indexOf2 == -1 && indexOf == DIRTY.length() && str.startsWith(DIRTY)) {
                entry.currentEditor = new Editor(entry);
            } else if (!(indexOf2 == -1 && indexOf == READ.length() && str.startsWith(READ))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected journal line: ");
                stringBuilder.append(str);
                throw new IOException(stringBuilder.toString());
            }
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected journal line: ");
        stringBuilder.append(str);
        throw new IOException(stringBuilder.toString());
    }

    private void processJournal() {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i = 0;
            if (entry.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += entry.lengths[i];
                    i++;
                }
            } else {
                entry.currentEditor = null;
                while (i < this.valueCount) {
                    this.fileSystem.delete(entry.cleanFiles[i]);
                    this.fileSystem.delete(entry.dirtyFiles[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    synchronized void rebuildJournal() {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        C7203d a = C5870l.m24719a(this.fileSystem.sink(this.journalFileTmp));
        try {
            a.mo6294b(MAGIC).mo6307i(10);
            a.mo6294b("1").mo6307i(10);
            a.mo6316n((long) this.appVersion).mo6307i(10);
            a.mo6316n((long) this.valueCount).mo6307i(10);
            a.mo6307i(10);
            for (Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    a.mo6294b(DIRTY).mo6307i(32);
                    a.mo6294b(entry.key);
                    a.mo6307i(10);
                } else {
                    a.mo6294b(CLEAN).mo6307i(32);
                    a.mo6294b(entry.key);
                    entry.writeLengths(a);
                    a.mo6307i(10);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.rename(this.journalFile, this.journalFileBackup);
            }
            this.fileSystem.rename(this.journalFileTmp, this.journalFile);
            this.fileSystem.delete(this.journalFileBackup);
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } finally {
            a.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r3.initialize();	 Catch:{ all -> 0x0050 }
        r3.checkNotClosed();	 Catch:{ all -> 0x0050 }
        r3.validateKey(r4);	 Catch:{ all -> 0x0050 }
        r0 = r3.lruEntries;	 Catch:{ all -> 0x0050 }
        r0 = r0.get(r4);	 Catch:{ all -> 0x0050 }
        r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x0050 }
        r1 = 0;
        if (r0 == 0) goto L_0x004e;
    L_0x0015:
        r2 = r0.readable;	 Catch:{ all -> 0x0050 }
        if (r2 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x004e;
    L_0x001a:
        r0 = r0.snapshot();	 Catch:{ all -> 0x0050 }
        if (r0 != 0) goto L_0x0022;
    L_0x0020:
        monitor-exit(r3);
        return r1;
    L_0x0022:
        r1 = r3.redundantOpCount;	 Catch:{ all -> 0x0050 }
        r1 = r1 + 1;
        r3.redundantOpCount = r1;	 Catch:{ all -> 0x0050 }
        r1 = r3.journalWriter;	 Catch:{ all -> 0x0050 }
        r2 = "READ";
        r1 = r1.mo6294b(r2);	 Catch:{ all -> 0x0050 }
        r2 = 32;
        r1 = r1.mo6307i(r2);	 Catch:{ all -> 0x0050 }
        r4 = r1.mo6294b(r4);	 Catch:{ all -> 0x0050 }
        r1 = 10;
        r4.mo6307i(r1);	 Catch:{ all -> 0x0050 }
        r4 = r3.journalRebuildRequired();	 Catch:{ all -> 0x0050 }
        if (r4 == 0) goto L_0x004c;
    L_0x0045:
        r4 = r3.executor;	 Catch:{ all -> 0x0050 }
        r1 = r3.cleanupRunnable;	 Catch:{ all -> 0x0050 }
        r4.execute(r1);	 Catch:{ all -> 0x0050 }
    L_0x004c:
        monitor-exit(r3);
        return r0;
    L_0x004e:
        monitor-exit(r3);
        return r1;
    L_0x0050:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.get(java.lang.String):okhttp3.internal.cache.DiskLruCache$Snapshot");
    }

    public Editor edit(String str) {
        return edit(str, -1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String r5, long r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r4.initialize();	 Catch:{ all -> 0x0074 }
        r4.checkNotClosed();	 Catch:{ all -> 0x0074 }
        r4.validateKey(r5);	 Catch:{ all -> 0x0074 }
        r0 = r4.lruEntries;	 Catch:{ all -> 0x0074 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0074 }
        r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x0074 }
        r1 = -1;
        r3 = 0;
        r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x0023;
    L_0x0019:
        if (r0 == 0) goto L_0x0021;
    L_0x001b:
        r1 = r0.sequenceNumber;	 Catch:{ all -> 0x0074 }
        r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));
        if (r6 == 0) goto L_0x0023;
    L_0x0021:
        monitor-exit(r4);
        return r3;
    L_0x0023:
        if (r0 == 0) goto L_0x002b;
    L_0x0025:
        r6 = r0.currentEditor;	 Catch:{ all -> 0x0074 }
        if (r6 == 0) goto L_0x002b;
    L_0x0029:
        monitor-exit(r4);
        return r3;
    L_0x002b:
        r6 = r4.mostRecentTrimFailed;	 Catch:{ all -> 0x0074 }
        if (r6 != 0) goto L_0x006b;
    L_0x002f:
        r6 = r4.mostRecentRebuildFailed;	 Catch:{ all -> 0x0074 }
        if (r6 == 0) goto L_0x0034;
    L_0x0033:
        goto L_0x006b;
    L_0x0034:
        r6 = r4.journalWriter;	 Catch:{ all -> 0x0074 }
        r7 = "DIRTY";
        r6 = r6.mo6294b(r7);	 Catch:{ all -> 0x0074 }
        r7 = 32;
        r6 = r6.mo6307i(r7);	 Catch:{ all -> 0x0074 }
        r6 = r6.mo6294b(r5);	 Catch:{ all -> 0x0074 }
        r7 = 10;
        r6.mo6307i(r7);	 Catch:{ all -> 0x0074 }
        r6 = r4.journalWriter;	 Catch:{ all -> 0x0074 }
        r6.flush();	 Catch:{ all -> 0x0074 }
        r6 = r4.hasJournalErrors;	 Catch:{ all -> 0x0074 }
        if (r6 == 0) goto L_0x0056;
    L_0x0054:
        monitor-exit(r4);
        return r3;
    L_0x0056:
        if (r0 != 0) goto L_0x0062;
    L_0x0058:
        r0 = new okhttp3.internal.cache.DiskLruCache$Entry;	 Catch:{ all -> 0x0074 }
        r0.<init>(r5);	 Catch:{ all -> 0x0074 }
        r6 = r4.lruEntries;	 Catch:{ all -> 0x0074 }
        r6.put(r5, r0);	 Catch:{ all -> 0x0074 }
    L_0x0062:
        r5 = new okhttp3.internal.cache.DiskLruCache$Editor;	 Catch:{ all -> 0x0074 }
        r5.<init>(r0);	 Catch:{ all -> 0x0074 }
        r0.currentEditor = r5;	 Catch:{ all -> 0x0074 }
        monitor-exit(r4);
        return r5;
    L_0x006b:
        r5 = r4.executor;	 Catch:{ all -> 0x0074 }
        r6 = r4.cleanupRunnable;	 Catch:{ all -> 0x0074 }
        r5.execute(r6);	 Catch:{ all -> 0x0074 }
        monitor-exit(r4);
        return r3;
    L_0x0074:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.edit(java.lang.String, long):okhttp3.internal.cache.DiskLruCache$Editor");
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized != null) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public synchronized long size() {
        initialize();
        return this.size;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized void completeEdit(okhttp3.internal.cache.DiskLruCache.Editor r10, boolean r11) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r10.entry;	 Catch:{ all -> 0x00fc }
        r1 = r0.currentEditor;	 Catch:{ all -> 0x00fc }
        if (r1 != r10) goto L_0x00f6;
    L_0x0007:
        r1 = 0;
        if (r11 == 0) goto L_0x0047;
    L_0x000a:
        r2 = r0.readable;	 Catch:{ all -> 0x00fc }
        if (r2 != 0) goto L_0x0047;
    L_0x000e:
        r2 = 0;
    L_0x000f:
        r3 = r9.valueCount;	 Catch:{ all -> 0x00fc }
        if (r2 >= r3) goto L_0x0047;
    L_0x0013:
        r3 = r10.written;	 Catch:{ all -> 0x00fc }
        r3 = r3[r2];	 Catch:{ all -> 0x00fc }
        if (r3 == 0) goto L_0x002d;
    L_0x0019:
        r3 = r9.fileSystem;	 Catch:{ all -> 0x00fc }
        r4 = r0.dirtyFiles;	 Catch:{ all -> 0x00fc }
        r4 = r4[r2];	 Catch:{ all -> 0x00fc }
        r3 = r3.exists(r4);	 Catch:{ all -> 0x00fc }
        if (r3 != 0) goto L_0x002a;
    L_0x0025:
        r10.abort();	 Catch:{ all -> 0x00fc }
        monitor-exit(r9);
        return;
    L_0x002a:
        r2 = r2 + 1;
        goto L_0x000f;
    L_0x002d:
        r10.abort();	 Catch:{ all -> 0x00fc }
        r10 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00fc }
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00fc }
        r11.<init>();	 Catch:{ all -> 0x00fc }
        r0 = "Newly created entry didn't create value for index ";
        r11.append(r0);	 Catch:{ all -> 0x00fc }
        r11.append(r2);	 Catch:{ all -> 0x00fc }
        r11 = r11.toString();	 Catch:{ all -> 0x00fc }
        r10.<init>(r11);	 Catch:{ all -> 0x00fc }
        throw r10;	 Catch:{ all -> 0x00fc }
    L_0x0047:
        r10 = r9.valueCount;	 Catch:{ all -> 0x00fc }
        if (r1 >= r10) goto L_0x0080;
    L_0x004b:
        r10 = r0.dirtyFiles;	 Catch:{ all -> 0x00fc }
        r10 = r10[r1];	 Catch:{ all -> 0x00fc }
        if (r11 == 0) goto L_0x0078;
    L_0x0051:
        r2 = r9.fileSystem;	 Catch:{ all -> 0x00fc }
        r2 = r2.exists(r10);	 Catch:{ all -> 0x00fc }
        if (r2 == 0) goto L_0x007d;
    L_0x0059:
        r2 = r0.cleanFiles;	 Catch:{ all -> 0x00fc }
        r2 = r2[r1];	 Catch:{ all -> 0x00fc }
        r3 = r9.fileSystem;	 Catch:{ all -> 0x00fc }
        r3.rename(r10, r2);	 Catch:{ all -> 0x00fc }
        r10 = r0.lengths;	 Catch:{ all -> 0x00fc }
        r3 = r10[r1];	 Catch:{ all -> 0x00fc }
        r10 = r9.fileSystem;	 Catch:{ all -> 0x00fc }
        r5 = r10.size(r2);	 Catch:{ all -> 0x00fc }
        r10 = r0.lengths;	 Catch:{ all -> 0x00fc }
        r10[r1] = r5;	 Catch:{ all -> 0x00fc }
        r7 = r9.size;	 Catch:{ all -> 0x00fc }
        r10 = 0;
        r7 = r7 - r3;
        r7 = r7 + r5;
        r9.size = r7;	 Catch:{ all -> 0x00fc }
        goto L_0x007d;
    L_0x0078:
        r2 = r9.fileSystem;	 Catch:{ all -> 0x00fc }
        r2.delete(r10);	 Catch:{ all -> 0x00fc }
    L_0x007d:
        r1 = r1 + 1;
        goto L_0x0047;
    L_0x0080:
        r10 = r9.redundantOpCount;	 Catch:{ all -> 0x00fc }
        r1 = 1;
        r10 = r10 + r1;
        r9.redundantOpCount = r10;	 Catch:{ all -> 0x00fc }
        r10 = 0;
        r0.currentEditor = r10;	 Catch:{ all -> 0x00fc }
        r10 = r0.readable;	 Catch:{ all -> 0x00fc }
        r10 = r10 | r11;
        r2 = 10;
        r3 = 32;
        if (r10 == 0) goto L_0x00bc;
    L_0x0092:
        r0.readable = r1;	 Catch:{ all -> 0x00fc }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00fc }
        r1 = "CLEAN";
        r10 = r10.mo6294b(r1);	 Catch:{ all -> 0x00fc }
        r10.mo6307i(r3);	 Catch:{ all -> 0x00fc }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00fc }
        r1 = r0.key;	 Catch:{ all -> 0x00fc }
        r10.mo6294b(r1);	 Catch:{ all -> 0x00fc }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00fc }
        r0.writeLengths(r10);	 Catch:{ all -> 0x00fc }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00fc }
        r10.mo6307i(r2);	 Catch:{ all -> 0x00fc }
        if (r11 == 0) goto L_0x00da;
    L_0x00b2:
        r10 = r9.nextSequenceNumber;	 Catch:{ all -> 0x00fc }
        r1 = 1;
        r1 = r1 + r10;
        r9.nextSequenceNumber = r1;	 Catch:{ all -> 0x00fc }
        r0.sequenceNumber = r10;	 Catch:{ all -> 0x00fc }
        goto L_0x00da;
    L_0x00bc:
        r10 = r9.lruEntries;	 Catch:{ all -> 0x00fc }
        r11 = r0.key;	 Catch:{ all -> 0x00fc }
        r10.remove(r11);	 Catch:{ all -> 0x00fc }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00fc }
        r11 = "REMOVE";
        r10 = r10.mo6294b(r11);	 Catch:{ all -> 0x00fc }
        r10.mo6307i(r3);	 Catch:{ all -> 0x00fc }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00fc }
        r11 = r0.key;	 Catch:{ all -> 0x00fc }
        r10.mo6294b(r11);	 Catch:{ all -> 0x00fc }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00fc }
        r10.mo6307i(r2);	 Catch:{ all -> 0x00fc }
    L_0x00da:
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00fc }
        r10.flush();	 Catch:{ all -> 0x00fc }
        r10 = r9.size;	 Catch:{ all -> 0x00fc }
        r0 = r9.maxSize;	 Catch:{ all -> 0x00fc }
        r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r10 > 0) goto L_0x00ed;
    L_0x00e7:
        r10 = r9.journalRebuildRequired();	 Catch:{ all -> 0x00fc }
        if (r10 == 0) goto L_0x00f4;
    L_0x00ed:
        r10 = r9.executor;	 Catch:{ all -> 0x00fc }
        r11 = r9.cleanupRunnable;	 Catch:{ all -> 0x00fc }
        r10.execute(r11);	 Catch:{ all -> 0x00fc }
    L_0x00f4:
        monitor-exit(r9);
        return;
    L_0x00f6:
        r10 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00fc }
        r10.<init>();	 Catch:{ all -> 0x00fc }
        throw r10;	 Catch:{ all -> 0x00fc }
    L_0x00fc:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.completeEdit(okhttp3.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    boolean journalRebuildRequired() {
        return this.redundantOpCount >= AdError.SERVER_ERROR_CODE && this.redundantOpCount >= this.lruEntries.size();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r5.initialize();	 Catch:{ all -> 0x0029 }
        r5.checkNotClosed();	 Catch:{ all -> 0x0029 }
        r5.validateKey(r6);	 Catch:{ all -> 0x0029 }
        r0 = r5.lruEntries;	 Catch:{ all -> 0x0029 }
        r6 = r0.get(r6);	 Catch:{ all -> 0x0029 }
        r6 = (okhttp3.internal.cache.DiskLruCache.Entry) r6;	 Catch:{ all -> 0x0029 }
        r0 = 0;
        if (r6 != 0) goto L_0x0017;
    L_0x0015:
        monitor-exit(r5);
        return r0;
    L_0x0017:
        r6 = r5.removeEntry(r6);	 Catch:{ all -> 0x0029 }
        if (r6 == 0) goto L_0x0027;
    L_0x001d:
        r1 = r5.size;	 Catch:{ all -> 0x0029 }
        r3 = r5.maxSize;	 Catch:{ all -> 0x0029 }
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 > 0) goto L_0x0027;
    L_0x0025:
        r5.mostRecentTrimFailed = r0;	 Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r5);
        return r6;
    L_0x0029:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.remove(java.lang.String):boolean");
    }

    boolean removeEntry(Entry entry) {
        if (entry.currentEditor != null) {
            entry.currentEditor.detach();
        }
        for (int i = 0; i < this.valueCount; i++) {
            this.fileSystem.delete(entry.cleanFiles[i]);
            this.size -= entry.lengths[i];
            entry.lengths[i] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.mo6294b(REMOVE).mo6307i(32).mo6294b(entry.key).mo6307i(10);
        this.lruEntries.remove(entry.key);
        if (journalRebuildRequired() != null) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public synchronized boolean isClosed() {
        return this.closed;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    public synchronized void close() {
        if (this.initialized) {
            if (!this.closed) {
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                    if (entry.currentEditor != null) {
                        entry.currentEditor.abort();
                    }
                }
                trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
        }
        this.closed = true;
    }

    void trimToSize() {
        while (this.size > this.maxSize) {
            removeEntry((Entry) this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }

    public void delete() {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public synchronized void evictAll() {
        initialize();
        for (Entry removeEntry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
            removeEntry(removeEntry);
        }
        this.mostRecentTrimFailed = false;
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("keys must match regex [a-z0-9_-]{1,120}: \"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public synchronized Iterator<Snapshot> snapshots() {
        initialize();
        return new C66213();
    }
}
