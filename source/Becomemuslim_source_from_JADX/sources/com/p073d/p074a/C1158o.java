package com.p073d.p074a;

import com.facebook.cache.disk.DefaultDiskStorage.FileType;
import com.facebook.imageutils.JfifUtil;
import com.p073d.p074a.C1155l.C1154a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.WritableByteChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: QueueFile */
/* renamed from: com.d.a.o */
public class C1158o implements Closeable {
    /* renamed from: c */
    private static final Logger f3265c = Logger.getLogger(C1158o.class.getName());
    /* renamed from: d */
    private static final byte[] f3266d = new byte[4096];
    /* renamed from: a */
    final RandomAccessFile f3267a;
    /* renamed from: b */
    int f3268b;
    /* renamed from: e */
    private int f3269e;
    /* renamed from: f */
    private C1156a f3270f;
    /* renamed from: g */
    private C1156a f3271g;
    /* renamed from: h */
    private final byte[] f3272h = new byte[16];

    /* compiled from: QueueFile */
    /* renamed from: com.d.a.o$a */
    static class C1156a {
        /* renamed from: a */
        static final C1156a f3259a = new C1156a(0, 0);
        /* renamed from: b */
        final int f3260b;
        /* renamed from: c */
        final int f3261c;

        C1156a(int i, int i2) {
            this.f3260b = i;
            this.f3261c = i2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append("[");
            stringBuilder.append("position = ");
            stringBuilder.append(this.f3260b);
            stringBuilder.append(", length = ");
            stringBuilder.append(this.f3261c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: QueueFile */
    /* renamed from: com.d.a.o$b */
    final class C1157b extends InputStream {
        /* renamed from: a */
        final /* synthetic */ C1158o f3262a;
        /* renamed from: b */
        private int f3263b;
        /* renamed from: c */
        private int f3264c;

        C1157b(C1158o c1158o, C1156a c1156a) {
            this.f3262a = c1158o;
            this.f3263b = c1158o.m4103a(c1156a.f3260b + 4);
            this.f3264c = c1156a.f3261c;
        }

        public int read(byte[] bArr, int i, int i2) {
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (this.f3264c == 0) {
                return -1;
            } else {
                if (i2 > this.f3264c) {
                    i2 = this.f3264c;
                }
                this.f3262a.m4105a(this.f3263b, bArr, i, i2);
                this.f3263b = this.f3262a.m4103a(this.f3263b + i2);
                this.f3264c -= i2;
                return i2;
            }
        }

        public int read() {
            if (this.f3264c == 0) {
                return -1;
            }
            this.f3262a.f3267a.seek((long) this.f3263b);
            int read = this.f3262a.f3267a.read();
            this.f3263b = this.f3262a.m4103a(this.f3263b + 1);
            this.f3264c--;
            return read;
        }
    }

    public C1158o(File file) {
        if (!file.exists()) {
            C1158o.m4093a(file);
        }
        this.f3267a = C1158o.m4094b(file);
        m4098d();
    }

    /* renamed from: b */
    private static void m4096b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* renamed from: a */
    private static int m4090a(byte[] bArr, int i) {
        return ((((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 24) + ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 16)) + ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 8)) + (bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: d */
    private void m4098d() {
        this.f3267a.seek(0);
        this.f3267a.readFully(this.f3272h);
        this.f3268b = C1158o.m4090a(this.f3272h, 0);
        StringBuilder stringBuilder;
        if (((long) this.f3268b) > this.f3267a.length()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("File is truncated. Expected length: ");
            stringBuilder.append(this.f3268b);
            stringBuilder.append(", Actual length: ");
            stringBuilder.append(this.f3267a.length());
            throw new IOException(stringBuilder.toString());
        } else if (this.f3268b > 0) {
            this.f3269e = C1158o.m4090a(this.f3272h, 4);
            int a = C1158o.m4090a(this.f3272h, 8);
            int a2 = C1158o.m4090a(this.f3272h, 12);
            this.f3270f = m4097c(a);
            this.f3271g = m4097c(a2);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("File is corrupt; length stored in header (");
            stringBuilder.append(this.f3268b);
            stringBuilder.append(") is invalid.");
            throw new IOException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private void m4092a(int i, int i2, int i3, int i4) {
        C1158o.m4096b(this.f3272h, 0, i);
        C1158o.m4096b(this.f3272h, 4, i2);
        C1158o.m4096b(this.f3272h, 8, i3);
        C1158o.m4096b(this.f3272h, 12, i4);
        this.f3267a.seek(0);
        this.f3267a.write(this.f3272h);
    }

    /* renamed from: c */
    private C1156a m4097c(int i) {
        if (i == 0) {
            return C1156a.f3259a;
        }
        m4105a(i, this.f3272h, 0, 4);
        return new C1156a(i, C1158o.m4090a(this.f3272h, 0));
    }

    /* renamed from: a */
    private static void m4093a(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getPath());
        stringBuilder.append(FileType.TEMP);
        File file2 = new File(stringBuilder.toString());
        RandomAccessFile b = C1158o.m4094b(file2);
        try {
            b.setLength(4096);
            b.seek(0);
            byte[] bArr = new byte[16];
            C1158o.m4096b(bArr, 0, 4096);
            b.write(bArr);
            if (file2.renameTo(file) == null) {
                throw new IOException("Rename failed!");
            }
        } finally {
            b.close();
        }
    }

    /* renamed from: b */
    private static RandomAccessFile m4094b(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    /* renamed from: a */
    int m4103a(int i) {
        return i < this.f3268b ? i : (i + 16) - this.f3268b;
    }

    /* renamed from: b */
    private void m4095b(int i, byte[] bArr, int i2, int i3) {
        i = m4103a(i);
        if (i + i3 <= this.f3268b) {
            this.f3267a.seek((long) i);
            this.f3267a.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f3268b - i;
        this.f3267a.seek((long) i);
        this.f3267a.write(bArr, i2, i4);
        this.f3267a.seek(16);
        this.f3267a.write(bArr, i2 + i4, i3 - i4);
    }

    /* renamed from: a */
    private void m4091a(int i, int i2) {
        while (i2 > 0) {
            int min = Math.min(i2, f3266d.length);
            m4095b(i, f3266d, 0, min);
            i2 -= min;
            i += min;
        }
    }

    /* renamed from: a */
    void m4105a(int i, byte[] bArr, int i2, int i3) {
        i = m4103a(i);
        if (i + i3 <= this.f3268b) {
            this.f3267a.seek((long) i);
            this.f3267a.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f3268b - i;
        this.f3267a.seek((long) i);
        this.f3267a.readFully(bArr, i2, i4);
        this.f3267a.seek(16);
        this.f3267a.readFully(bArr, i2 + i4, i3 - i4);
    }

    /* renamed from: a */
    public void m4106a(byte[] bArr) {
        m4107a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public synchronized void m4107a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if ((i | i2) >= 0) {
                if (i2 <= bArr.length - i) {
                    int i3;
                    m4099d(i2);
                    boolean a = m4108a();
                    if (a) {
                        i3 = 16;
                    } else {
                        i3 = m4103a((this.f3271g.f3260b + 4) + this.f3271g.f3261c);
                    }
                    C1156a c1156a = new C1156a(i3, i2);
                    C1158o.m4096b(this.f3272h, 0, i2);
                    m4095b(c1156a.f3260b, this.f3272h, 0, 4);
                    m4095b(c1156a.f3260b + 4, bArr, i, i2);
                    m4092a(this.f3268b, this.f3269e + 1, a ? c1156a.f3260b : this.f3270f.f3260b, c1156a.f3260b);
                    this.f3271g = c1156a;
                    this.f3269e++;
                    if (a) {
                        this.f3270f = this.f3271g;
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("data == null");
    }

    /* renamed from: e */
    private int m4100e() {
        if (this.f3269e == 0) {
            return 16;
        }
        if (this.f3271g.f3260b >= this.f3270f.f3260b) {
            return (((this.f3271g.f3260b - this.f3270f.f3260b) + 4) + this.f3271g.f3261c) + 16;
        }
        return (((this.f3271g.f3260b + 4) + this.f3271g.f3261c) + this.f3268b) - this.f3270f.f3260b;
    }

    /* renamed from: f */
    private int m4102f() {
        return this.f3268b - m4100e();
    }

    /* renamed from: a */
    public synchronized boolean m4108a() {
        return this.f3269e == 0;
    }

    /* renamed from: d */
    private void m4099d(int i) {
        i += 4;
        int f = m4102f();
        if (f < i) {
            int i2;
            int i3 = this.f3268b;
            while (true) {
                f += i3;
                i2 = i3 << 1;
                if (i2 < i3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot grow file beyond ");
                    stringBuilder.append(i3);
                    stringBuilder.append(" bytes");
                    throw new EOFException(stringBuilder.toString());
                } else if (f >= i) {
                    break;
                } else {
                    i3 = i2;
                }
            }
            m4101e(i2);
            i = m4103a((this.f3271g.f3260b + 4) + this.f3271g.f3261c);
            if (i <= this.f3270f.f3260b) {
                WritableByteChannel channel = this.f3267a.getChannel();
                channel.position((long) this.f3268b);
                i -= 16;
                long j = (long) i;
                if (channel.transferTo(16, j, channel) == j) {
                    m4091a(16, i);
                } else {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f3271g.f3260b < this.f3270f.f3260b) {
                i = (this.f3268b + this.f3271g.f3260b) - 16;
                m4092a(i2, this.f3269e, this.f3270f.f3260b, i);
                this.f3271g = new C1156a(i, this.f3271g.f3261c);
            } else {
                m4092a(i2, this.f3269e, this.f3270f.f3260b, this.f3271g.f3260b);
            }
            this.f3268b = i2;
        }
    }

    /* renamed from: e */
    private void m4101e(int i) {
        this.f3267a.setLength((long) i);
        this.f3267a.getChannel().force(true);
    }

    /* renamed from: a */
    public synchronized int m4104a(C1154a c1154a) {
        int i = this.f3270f.f3260b;
        int i2 = 0;
        while (i2 < this.f3269e) {
            C1156a c = m4097c(i);
            if (c1154a.mo793a(new C1157b(this, c), c.f3261c)) {
                i = m4103a((c.f3260b + 4) + c.f3261c);
                i2++;
            } else {
                return i2 + 1;
            }
        }
        return this.f3269e;
    }

    /* renamed from: b */
    public synchronized int m4109b() {
        return this.f3269e;
    }

    /* renamed from: b */
    public synchronized void m4110b(int i) {
        if (m4108a()) {
            throw new NoSuchElementException();
        } else if (i < 0) {
            r1 = new StringBuilder();
            r1.append("Cannot remove negative (");
            r1.append(i);
            r1.append(") number of elements.");
            throw new IllegalArgumentException(r1.toString());
        } else if (i != 0) {
            if (i == this.f3269e) {
                m4111c();
            } else if (i <= this.f3269e) {
                int i2 = this.f3270f.f3260b;
                int i3 = this.f3270f.f3260b;
                int i4 = this.f3270f.f3261c;
                int i5 = 0;
                for (int i6 = 0; i6 < i; i6++) {
                    i5 += i4 + 4;
                    i3 = m4103a((i3 + 4) + i4);
                    m4105a(i3, this.f3272h, 0, 4);
                    i4 = C1158o.m4090a(this.f3272h, 0);
                }
                m4092a(this.f3268b, this.f3269e - i, i3, this.f3271g.f3260b);
                this.f3269e -= i;
                this.f3270f = new C1156a(i3, i4);
                m4091a(i2, i5);
            } else {
                r1 = new StringBuilder();
                r1.append("Cannot remove more elements (");
                r1.append(i);
                r1.append(") than present in queue (");
                r1.append(this.f3269e);
                r1.append(").");
                throw new IllegalArgumentException(r1.toString());
            }
        }
    }

    /* renamed from: c */
    public synchronized void m4111c() {
        m4092a(4096, 0, 0, 0);
        this.f3267a.seek(16);
        this.f3267a.write(f3266d, 0, 4080);
        this.f3269e = 0;
        this.f3270f = C1156a.f3259a;
        this.f3271g = C1156a.f3259a;
        if (this.f3268b > 4096) {
            m4101e(4096);
        }
        this.f3268b = 4096;
    }

    public synchronized void close() {
        this.f3267a.close();
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append('[');
        stringBuilder.append("fileLength=");
        stringBuilder.append(this.f3268b);
        stringBuilder.append(", size=");
        stringBuilder.append(this.f3269e);
        stringBuilder.append(", first=");
        stringBuilder.append(this.f3270f);
        stringBuilder.append(", last=");
        stringBuilder.append(this.f3271g);
        stringBuilder.append(", element lengths=[");
        try {
            m4104a(new C1154a(this) {
                /* renamed from: a */
                boolean f9271a = true;
                /* renamed from: c */
                final /* synthetic */ C1158o f9273c;

                /* renamed from: a */
                public boolean mo793a(InputStream inputStream, int i) {
                    if (this.f9271a != null) {
                        this.f9271a = null;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(i);
                    return true;
                }
            });
        } catch (Throwable e) {
            f3265c.log(Level.WARNING, "read error", e);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
