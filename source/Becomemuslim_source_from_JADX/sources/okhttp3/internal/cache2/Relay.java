package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import p286d.C5869f;
import p286d.C5876t;
import p286d.C5877u;
import p286d.C8037c;

final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final C5869f PREFIX_CLEAN = C5869f.m24697a("OkHttp cache v1\n");
    static final C5869f PREFIX_DIRTY = C5869f.m24697a("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final C8037c buffer = new C8037c();
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final C5869f metadata;
    int sourceCount;
    C5876t upstream;
    final C8037c upstreamBuffer = new C8037c();
    long upstreamPos;
    Thread upstreamReader;

    class RelaySource implements C5876t {
        private FileOperator fileOperator = new FileOperator(Relay.this.file.getChannel());
        private long sourcePos;
        private final C5877u timeout = new C5877u();

        RelaySource() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(p286d.C8037c r22, long r23) {
            /*
            r21 = this;
            r1 = r21;
            r2 = r23;
            r0 = r1.fileOperator;
            if (r0 == 0) goto L_0x0142;
        L_0x0008:
            r4 = okhttp3.internal.cache2.Relay.this;
            monitor-enter(r4);
        L_0x000b:
            r5 = r1.sourcePos;	 Catch:{ all -> 0x013f }
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r7 = r0.upstreamPos;	 Catch:{ all -> 0x013f }
            r0 = 2;
            r9 = -1;
            r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
            if (r5 != 0) goto L_0x0039;
        L_0x0018:
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r5 = r5.complete;	 Catch:{ all -> 0x013f }
            if (r5 == 0) goto L_0x0020;
        L_0x001e:
            monitor-exit(r4);	 Catch:{ all -> 0x013f }
            return r9;
        L_0x0020:
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r5 = r5.upstreamReader;	 Catch:{ all -> 0x013f }
            if (r5 == 0) goto L_0x002e;
        L_0x0026:
            r0 = r1.timeout;	 Catch:{ all -> 0x013f }
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r0.waitUntilNotified(r5);	 Catch:{ all -> 0x013f }
            goto L_0x000b;
        L_0x002e:
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r6 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x013f }
            r5.upstreamReader = r6;	 Catch:{ all -> 0x013f }
            r5 = 1;
            monitor-exit(r4);	 Catch:{ all -> 0x013f }
            goto L_0x004c;
        L_0x0039:
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r5 = r5.buffer;	 Catch:{ all -> 0x013f }
            r5 = r5.m38961a();	 Catch:{ all -> 0x013f }
            r11 = 0;
            r5 = r7 - r5;
            r11 = r1.sourcePos;	 Catch:{ all -> 0x013f }
            r11 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
            if (r11 >= 0) goto L_0x0120;
        L_0x004a:
            monitor-exit(r4);	 Catch:{ all -> 0x013f }
            r5 = 2;
        L_0x004c:
            r11 = 32;
            if (r5 != r0) goto L_0x006a;
        L_0x0050:
            r4 = r1.sourcePos;
            r7 = r7 - r4;
            r2 = java.lang.Math.min(r2, r7);
            r13 = r1.fileOperator;
            r4 = r1.sourcePos;
            r14 = r4 + r11;
            r16 = r22;
            r17 = r2;
            r13.read(r14, r16, r17);
            r4 = r1.sourcePos;
            r4 = r4 + r2;
            r1.sourcePos = r4;
            return r2;
        L_0x006a:
            r4 = 0;
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            r0 = r0.upstream;	 Catch:{ all -> 0x010e }
            r5 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            r5 = r5.upstreamBuffer;	 Catch:{ all -> 0x010e }
            r6 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            r13 = r6.bufferMaxSize;	 Catch:{ all -> 0x010e }
            r5 = r0.read(r5, r13);	 Catch:{ all -> 0x010e }
            r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));
            if (r0 != 0) goto L_0x0095;
        L_0x007f:
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            r0.commit(r7);	 Catch:{ all -> 0x010e }
            r2 = okhttp3.internal.cache2.Relay.this;
            monitor-enter(r2);
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x0092 }
            r0.upstreamReader = r4;	 Catch:{ all -> 0x0092 }
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x0092 }
            r0.notifyAll();	 Catch:{ all -> 0x0092 }
            monitor-exit(r2);	 Catch:{ all -> 0x0092 }
            return r9;
        L_0x0092:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0092 }
            throw r0;
        L_0x0095:
            r2 = java.lang.Math.min(r5, r2);	 Catch:{ all -> 0x010e }
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            r13 = r0.upstreamBuffer;	 Catch:{ all -> 0x010e }
            r15 = 0;
            r14 = r22;
            r17 = r2;
            r13.m38967a(r14, r15, r17);	 Catch:{ all -> 0x010e }
            r9 = r1.sourcePos;	 Catch:{ all -> 0x010e }
            r0 = 0;
            r9 = r9 + r2;
            r1.sourcePos = r9;	 Catch:{ all -> 0x010e }
            r15 = r1.fileOperator;	 Catch:{ all -> 0x010e }
            r0 = 0;
            r16 = r7 + r11;
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            r0 = r0.upstreamBuffer;	 Catch:{ all -> 0x010e }
            r18 = r0.m39026u();	 Catch:{ all -> 0x010e }
            r19 = r5;
            r15.write(r16, r18, r19);	 Catch:{ all -> 0x010e }
            r7 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010e }
            monitor-enter(r7);	 Catch:{ all -> 0x010e }
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010b }
            r0 = r0.buffer;	 Catch:{ all -> 0x010b }
            r8 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010b }
            r8 = r8.upstreamBuffer;	 Catch:{ all -> 0x010b }
            r0.write(r8, r5);	 Catch:{ all -> 0x010b }
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010b }
            r0 = r0.buffer;	 Catch:{ all -> 0x010b }
            r8 = r0.m38961a();	 Catch:{ all -> 0x010b }
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010b }
            r10 = r0.bufferMaxSize;	 Catch:{ all -> 0x010b }
            r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
            if (r0 <= 0) goto L_0x00f1;
        L_0x00dc:
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010b }
            r0 = r0.buffer;	 Catch:{ all -> 0x010b }
            r8 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010b }
            r8 = r8.buffer;	 Catch:{ all -> 0x010b }
            r8 = r8.m38961a();	 Catch:{ all -> 0x010b }
            r10 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010b }
            r10 = r10.bufferMaxSize;	 Catch:{ all -> 0x010b }
            r12 = 0;
            r8 = r8 - r10;
            r0.mo6309i(r8);	 Catch:{ all -> 0x010b }
        L_0x00f1:
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x010b }
            r8 = r0.upstreamPos;	 Catch:{ all -> 0x010b }
            r10 = 0;
            r8 = r8 + r5;
            r0.upstreamPos = r8;	 Catch:{ all -> 0x010b }
            monitor-exit(r7);	 Catch:{ all -> 0x010b }
            r5 = okhttp3.internal.cache2.Relay.this;
            monitor-enter(r5);
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x0108 }
            r0.upstreamReader = r4;	 Catch:{ all -> 0x0108 }
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x0108 }
            r0.notifyAll();	 Catch:{ all -> 0x0108 }
            monitor-exit(r5);	 Catch:{ all -> 0x0108 }
            return r2;
        L_0x0108:
            r0 = move-exception;
            monitor-exit(r5);	 Catch:{ all -> 0x0108 }
            throw r0;
        L_0x010b:
            r0 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x010b }
            throw r0;	 Catch:{ all -> 0x010e }
        L_0x010e:
            r0 = move-exception;
            r2 = okhttp3.internal.cache2.Relay.this;
            monitor-enter(r2);
            r3 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x011d }
            r3.upstreamReader = r4;	 Catch:{ all -> 0x011d }
            r3 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x011d }
            r3.notifyAll();	 Catch:{ all -> 0x011d }
            monitor-exit(r2);	 Catch:{ all -> 0x011d }
            throw r0;
        L_0x011d:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x011d }
            throw r0;
        L_0x0120:
            r9 = r1.sourcePos;	 Catch:{ all -> 0x013f }
            r0 = 0;
            r7 = r7 - r9;
            r2 = java.lang.Math.min(r2, r7);	 Catch:{ all -> 0x013f }
            r0 = okhttp3.internal.cache2.Relay.this;	 Catch:{ all -> 0x013f }
            r9 = r0.buffer;	 Catch:{ all -> 0x013f }
            r7 = r1.sourcePos;	 Catch:{ all -> 0x013f }
            r0 = 0;
            r11 = r7 - r5;
            r10 = r22;
            r13 = r2;
            r9.m38967a(r10, r11, r13);	 Catch:{ all -> 0x013f }
            r5 = r1.sourcePos;	 Catch:{ all -> 0x013f }
            r0 = 0;
            r5 = r5 + r2;
            r1.sourcePos = r5;	 Catch:{ all -> 0x013f }
            monitor-exit(r4);	 Catch:{ all -> 0x013f }
            return r2;
        L_0x013f:
            r0 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x013f }
            throw r0;
        L_0x0142:
            r0 = new java.lang.IllegalStateException;
            r2 = "closed";
            r0.<init>(r2);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(d.c, long):long");
        }

        public C5877u timeout() {
            return this.timeout;
        }

        public void close() {
            if (this.fileOperator != null) {
                Closeable closeable = null;
                this.fileOperator = null;
                synchronized (Relay.this) {
                    Relay relay = Relay.this;
                    relay.sourceCount--;
                    if (Relay.this.sourceCount == 0) {
                        RandomAccessFile randomAccessFile = Relay.this.file;
                        Relay.this.file = null;
                        closeable = randomAccessFile;
                    }
                }
                if (closeable != null) {
                    Util.closeQuietly(closeable);
                }
            }
        }
    }

    private Relay(RandomAccessFile randomAccessFile, C5876t c5876t, long j, C5869f c5869f, long j2) {
        this.file = randomAccessFile;
        this.upstream = c5876t;
        this.complete = c5876t == null ? true : null;
        this.upstreamPos = j;
        this.metadata = c5869f;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file, C5876t c5876t, C5869f c5869f, long j) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        File relay = new Relay(randomAccessFile, c5876t, 0, c5869f, j);
        randomAccessFile.setLength(null);
        relay.writeHeader(PREFIX_DIRTY, -1, -1);
        return relay;
    }

    public static Relay read(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        file = new FileOperator(randomAccessFile.getChannel());
        C8037c c8037c = new C8037c();
        file.read(0, c8037c, FILE_HEADER_SIZE);
        if (c8037c.mo6299d((long) PREFIX_CLEAN.mo5110h()).equals(PREFIX_CLEAN)) {
            long k = c8037c.mo6311k();
            long k2 = c8037c.mo6311k();
            c8037c = new C8037c();
            file.read(k + FILE_HEADER_SIZE, c8037c, k2);
            return new Relay(randomAccessFile, null, k, c8037c.m39021p(), 0);
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(C5869f c5869f, long j, long j2) {
        C8037c c8037c = new C8037c();
        c8037c.m38968a(c5869f);
        c8037c.m39011j(j);
        c8037c.m39011j(j2);
        if (c8037c.m38961a() == FILE_HEADER_SIZE) {
            new FileOperator(this.file.getChannel()).write(0, c8037c, FILE_HEADER_SIZE);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long j) {
        C8037c c8037c = new C8037c();
        c8037c.m38968a(this.metadata);
        new FileOperator(this.file.getChannel()).write(FILE_HEADER_SIZE + j, c8037c, (long) this.metadata.mo5110h());
    }

    void commit(long j) {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, (long) this.metadata.mo5110h());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = 1;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = 0;
    }

    boolean isClosed() {
        return this.file == null;
    }

    public C5869f metadata() {
        return this.metadata;
    }

    public C5876t newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }
}
