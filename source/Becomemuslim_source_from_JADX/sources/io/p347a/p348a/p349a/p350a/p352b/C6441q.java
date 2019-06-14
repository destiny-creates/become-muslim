package io.p347a.p348a.p349a.p350a.p352b;

import com.facebook.cache.disk.DefaultDiskStorage.FileType;
import com.facebook.imageutils.JfifUtil;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.WritableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: QueueFile */
/* renamed from: io.a.a.a.a.b.q */
public class C6441q implements Closeable {
    /* renamed from: b */
    private static final Logger f20810b = Logger.getLogger(C6441q.class.getName());
    /* renamed from: a */
    int f20811a;
    /* renamed from: c */
    private final RandomAccessFile f20812c;
    /* renamed from: d */
    private int f20813d;
    /* renamed from: e */
    private C6438a f20814e;
    /* renamed from: f */
    private C6438a f20815f;
    /* renamed from: g */
    private final byte[] f20816g = new byte[16];

    /* compiled from: QueueFile */
    /* renamed from: io.a.a.a.a.b.q$a */
    static class C6438a {
        /* renamed from: a */
        static final C6438a f20804a = new C6438a(0, 0);
        /* renamed from: b */
        final int f20805b;
        /* renamed from: c */
        final int f20806c;

        C6438a(int i, int i2) {
            this.f20805b = i;
            this.f20806c = i2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append("[");
            stringBuilder.append("position = ");
            stringBuilder.append(this.f20805b);
            stringBuilder.append(", length = ");
            stringBuilder.append(this.f20806c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: QueueFile */
    /* renamed from: io.a.a.a.a.b.q$b */
    private final class C6439b extends InputStream {
        /* renamed from: a */
        final /* synthetic */ C6441q f20807a;
        /* renamed from: b */
        private int f20808b;
        /* renamed from: c */
        private int f20809c;

        private C6439b(C6441q c6441q, C6438a c6438a) {
            this.f20807a = c6441q;
            this.f20808b = c6441q.m26431b(c6438a.f20805b + 4);
            this.f20809c = c6438a.f20806c;
        }

        public int read(byte[] bArr, int i, int i2) {
            C6441q.m26433b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (this.f20809c <= 0) {
                return -1;
            } else {
                if (i2 > this.f20809c) {
                    i2 = this.f20809c;
                }
                this.f20807a.m26434b(this.f20808b, bArr, i, i2);
                this.f20808b = this.f20807a.m26431b(this.f20808b + i2);
                this.f20809c -= i2;
                return i2;
            }
        }

        public int read() {
            if (this.f20809c == 0) {
                return -1;
            }
            this.f20807a.f20812c.seek((long) this.f20808b);
            int read = this.f20807a.f20812c.read();
            this.f20808b = this.f20807a.m26431b(this.f20808b + 1);
            this.f20809c--;
            return read;
        }
    }

    /* compiled from: QueueFile */
    /* renamed from: io.a.a.a.a.b.q$c */
    public interface C6440c {
        /* renamed from: a */
        void mo5437a(InputStream inputStream, int i);
    }

    public C6441q(File file) {
        if (!file.exists()) {
            C6441q.m26429a(file);
        }
        this.f20812c = C6441q.m26432b(file);
        m26436c();
    }

    /* renamed from: b */
    private static void m26435b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* renamed from: a */
    private static void m26430a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int b : iArr) {
            C6441q.m26435b(bArr, i, b);
            i += 4;
        }
    }

    /* renamed from: a */
    private static int m26422a(byte[] bArr, int i) {
        return ((((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 24) + ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 16)) + ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 8)) + (bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: c */
    private void m26436c() {
        this.f20812c.seek(0);
        this.f20812c.readFully(this.f20816g);
        this.f20811a = C6441q.m26422a(this.f20816g, 0);
        if (((long) this.f20811a) <= this.f20812c.length()) {
            this.f20813d = C6441q.m26422a(this.f20816g, 4);
            int a = C6441q.m26422a(this.f20816g, 8);
            int a2 = C6441q.m26422a(this.f20816g, 12);
            this.f20814e = m26423a(a);
            this.f20815f = m26423a(a2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("File is truncated. Expected length: ");
        stringBuilder.append(this.f20811a);
        stringBuilder.append(", Actual length: ");
        stringBuilder.append(this.f20812c.length());
        throw new IOException(stringBuilder.toString());
    }

    /* renamed from: a */
    private void m26426a(int i, int i2, int i3, int i4) {
        C6441q.m26430a(this.f20816g, i, i2, i3, i4);
        this.f20812c.seek(0);
        this.f20812c.write(this.f20816g);
    }

    /* renamed from: a */
    private C6438a m26423a(int i) {
        if (i == 0) {
            return C6438a.f20804a;
        }
        this.f20812c.seek((long) i);
        return new C6438a(i, this.f20812c.readInt());
    }

    /* renamed from: a */
    private static void m26429a(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getPath());
        stringBuilder.append(FileType.TEMP);
        File file2 = new File(stringBuilder.toString());
        RandomAccessFile b = C6441q.m26432b(file2);
        try {
            b.setLength(4096);
            b.seek(0);
            byte[] bArr = new byte[16];
            C6441q.m26430a(bArr, 4096, 0, 0, 0);
            b.write(bArr);
            if (file2.renameTo(file) == null) {
                throw new IOException("Rename failed!");
            }
        } finally {
            b.close();
        }
    }

    /* renamed from: b */
    private static RandomAccessFile m26432b(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    /* renamed from: b */
    private int m26431b(int i) {
        return i < this.f20811a ? i : (i + 16) - this.f20811a;
    }

    /* renamed from: a */
    private void m26427a(int i, byte[] bArr, int i2, int i3) {
        i = m26431b(i);
        if (i + i3 <= this.f20811a) {
            this.f20812c.seek((long) i);
            this.f20812c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f20811a - i;
        this.f20812c.seek((long) i);
        this.f20812c.write(bArr, i2, i4);
        this.f20812c.seek(16);
        this.f20812c.write(bArr, i2 + i4, i3 - i4);
    }

    /* renamed from: b */
    private void m26434b(int i, byte[] bArr, int i2, int i3) {
        i = m26431b(i);
        if (i + i3 <= this.f20811a) {
            this.f20812c.seek((long) i);
            this.f20812c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f20811a - i;
        this.f20812c.seek((long) i);
        this.f20812c.readFully(bArr, i2, i4);
        this.f20812c.seek(16);
        this.f20812c.readFully(bArr, i2 + i4, i3 - i4);
    }

    /* renamed from: a */
    public void m26442a(byte[] bArr) {
        m26443a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public synchronized void m26443a(byte[] bArr, int i, int i2) {
        C6441q.m26433b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int i3;
        m26437c(i2);
        boolean b = m26445b();
        if (b) {
            i3 = 16;
        } else {
            i3 = m26431b((this.f20815f.f20805b + 4) + this.f20815f.f20806c);
        }
        C6438a c6438a = new C6438a(i3, i2);
        C6441q.m26435b(this.f20816g, 0, i2);
        m26427a(c6438a.f20805b, this.f20816g, 0, 4);
        m26427a(c6438a.f20805b + 4, bArr, i, i2);
        m26426a(this.f20811a, this.f20813d + 1, b ? c6438a.f20805b : this.f20814e.f20805b, c6438a.f20805b);
        this.f20815f = c6438a;
        this.f20813d++;
        if (b) {
            this.f20814e = this.f20815f;
        }
    }

    /* renamed from: a */
    public int m26440a() {
        if (this.f20813d == 0) {
            return 16;
        }
        if (this.f20815f.f20805b >= this.f20814e.f20805b) {
            return (((this.f20815f.f20805b - this.f20814e.f20805b) + 4) + this.f20815f.f20806c) + 16;
        }
        return (((this.f20815f.f20805b + 4) + this.f20815f.f20806c) + this.f20811a) - this.f20814e.f20805b;
    }

    /* renamed from: d */
    private int m26438d() {
        return this.f20811a - m26440a();
    }

    /* renamed from: b */
    public synchronized boolean m26445b() {
        return this.f20813d == 0;
    }

    /* renamed from: c */
    private void m26437c(int i) {
        i += 4;
        int d = m26438d();
        if (d < i) {
            int i2 = this.f20811a;
            do {
                d += i2;
                i2 <<= 1;
            } while (d < i);
            m26439d(i2);
            i = m26431b((this.f20815f.f20805b + 4) + this.f20815f.f20806c);
            if (i < this.f20814e.f20805b) {
                WritableByteChannel channel = this.f20812c.getChannel();
                channel.position((long) this.f20811a);
                long j = (long) (i - 4);
                if (channel.transferTo(16, j, channel) != j) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f20815f.f20805b < this.f20814e.f20805b) {
                i = (this.f20811a + this.f20815f.f20805b) - 16;
                m26426a(i2, this.f20813d, this.f20814e.f20805b, i);
                this.f20815f = new C6438a(i, this.f20815f.f20806c);
            } else {
                m26426a(i2, this.f20813d, this.f20814e.f20805b, this.f20815f.f20805b);
            }
            this.f20811a = i2;
        }
    }

    /* renamed from: d */
    private void m26439d(int i) {
        this.f20812c.setLength((long) i);
        this.f20812c.getChannel().force(true);
    }

    /* renamed from: a */
    public synchronized void m26441a(C6440c c6440c) {
        int i = this.f20814e.f20805b;
        for (int i2 = 0; i2 < this.f20813d; i2++) {
            C6438a a = m26423a(i);
            c6440c.mo5437a(new C6439b(a), a.f20806c);
            i = m26431b((a.f20805b + 4) + a.f20806c);
        }
    }

    /* renamed from: b */
    private static <T> T m26433b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public synchronized void close() {
        this.f20812c.close();
    }

    /* renamed from: a */
    public boolean m26444a(int i, int i2) {
        return (m26440a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append('[');
        stringBuilder.append("fileLength=");
        stringBuilder.append(this.f20811a);
        stringBuilder.append(", size=");
        stringBuilder.append(this.f20813d);
        stringBuilder.append(", first=");
        stringBuilder.append(this.f20814e);
        stringBuilder.append(", last=");
        stringBuilder.append(this.f20815f);
        stringBuilder.append(", element lengths=[");
        try {
            m26441a(new C6440c(this) {
                /* renamed from: a */
                boolean f26305a = true;
                /* renamed from: c */
                final /* synthetic */ C6441q f26307c;

                /* renamed from: a */
                public void mo5437a(InputStream inputStream, int i) {
                    if (this.f26305a != null) {
                        this.f26305a = null;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(i);
                }
            });
        } catch (Throwable e) {
            f20810b.log(Level.WARNING, "read error", e);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
