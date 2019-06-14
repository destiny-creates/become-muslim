package p286d;

import com.facebook.common.time.Clock;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.stetho.dumpapp.Framer;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* compiled from: Buffer */
/* renamed from: d.c */
public final class C8037c implements C7203d, C7204e, Cloneable, ByteChannel {
    /* renamed from: c */
    private static final byte[] f29837c = new byte[]{(byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    /* renamed from: a */
    C5873p f29838a;
    /* renamed from: b */
    long f29839b;

    /* compiled from: Buffer */
    /* renamed from: d.c$1 */
    class C58671 extends InputStream {
        /* renamed from: a */
        final /* synthetic */ C8037c f19518a;

        public void close() {
        }

        C58671(C8037c c8037c) {
            this.f19518a = c8037c;
        }

        public int read() {
            return this.f19518a.f29839b > 0 ? this.f19518a.mo6304h() & JfifUtil.MARKER_FIRST_BYTE : -1;
        }

        public int read(byte[] bArr, int i, int i2) {
            return this.f19518a.m38960a(bArr, i, i2);
        }

        public int available() {
            return (int) Math.min(this.f19518a.f29839b, 2147483647L);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f19518a);
            stringBuilder.append(".inputStream()");
            return stringBuilder.toString();
        }
    }

    /* compiled from: Buffer */
    /* renamed from: d.c$a */
    public static final class C5868a implements Closeable {
        /* renamed from: a */
        public C8037c f19519a;
        /* renamed from: b */
        public boolean f19520b;
        /* renamed from: c */
        public long f19521c = -1;
        /* renamed from: d */
        public byte[] f19522d;
        /* renamed from: e */
        public int f19523e = -1;
        /* renamed from: f */
        public int f19524f = -1;
        /* renamed from: g */
        private C5873p f19525g;

        /* renamed from: a */
        public int m24692a() {
            if (this.f19521c == this.f19519a.f29839b) {
                throw new IllegalStateException();
            } else if (this.f19521c == -1) {
                return m24693a(0);
            } else {
                return m24693a(this.f19521c + ((long) (this.f19524f - this.f19523e)));
            }
        }

        /* renamed from: a */
        public int m24693a(long j) {
            int i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if (i < 0 || j > this.f19519a.f29839b) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j), Long.valueOf(this.f19519a.f29839b)}));
            }
            if (i != 0) {
                if (j != this.f19519a.f29839b) {
                    long j2 = 0;
                    long j3 = this.f19519a.f29839b;
                    C5873p c5873p = this.f19519a.f29838a;
                    C5873p c5873p2 = this.f19519a.f29838a;
                    if (this.f19525g != null) {
                        long j4 = this.f19521c - ((long) (this.f19523e - this.f19525g.f19540b));
                        if (j4 > j) {
                            c5873p2 = this.f19525g;
                            j3 = j4;
                        } else {
                            c5873p = this.f19525g;
                            j2 = j4;
                        }
                    }
                    if (j3 - j > j - j2) {
                        while (j >= ((long) (c5873p.f19541c - c5873p.f19540b)) + j2) {
                            j2 += (long) (c5873p.f19541c - c5873p.f19540b);
                            c5873p = c5873p.f19544f;
                        }
                    } else {
                        j2 = j3;
                        c5873p = c5873p2;
                        while (j2 > j) {
                            c5873p = c5873p.f19545g;
                            j2 -= (long) (c5873p.f19541c - c5873p.f19540b);
                        }
                    }
                    if (this.f19520b && c5873p.f19542d) {
                        C5873p b = c5873p.m24739b();
                        if (this.f19519a.f29838a == c5873p) {
                            this.f19519a.f29838a = b;
                        }
                        c5873p = c5873p.m24737a(b);
                        c5873p.f19545g.m24740c();
                    }
                    this.f19525g = c5873p;
                    this.f19521c = j;
                    this.f19522d = c5873p.f19539a;
                    this.f19523e = c5873p.f19540b + ((int) (j - j2));
                    this.f19524f = c5873p.f19541c;
                    return this.f19524f - this.f19523e;
                }
            }
            this.f19525g = null;
            this.f19521c = j;
            this.f19522d = null;
            this.f19523e = -1;
            this.f19524f = -1;
            return -1;
        }

        public void close() {
            if (this.f19519a != null) {
                this.f19519a = null;
                this.f19525g = null;
                this.f19521c = -1;
                this.f19522d = null;
                this.f19523e = -1;
                this.f19524f = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }

    /* renamed from: b */
    public C8037c mo6292b() {
        return this;
    }

    /* renamed from: c */
    public C8037c m38988c() {
        return this;
    }

    public void close() {
    }

    /* renamed from: d */
    public C7203d mo6298d() {
        return this;
    }

    public void flush() {
    }

    public boolean isOpen() {
        return true;
    }

    /* renamed from: b */
    public /* synthetic */ C7203d mo6293b(C5869f c5869f) {
        return m38968a(c5869f);
    }

    /* renamed from: b */
    public /* synthetic */ C7203d mo6294b(String str) {
        return m38969a(str);
    }

    /* renamed from: c */
    public /* synthetic */ C7203d mo6296c(byte[] bArr) {
        return m38982b(bArr);
    }

    /* renamed from: c */
    public /* synthetic */ C7203d mo6297c(byte[] bArr, int i, int i2) {
        return m38983b(bArr, i, i2);
    }

    public /* synthetic */ Object clone() {
        return m39026u();
    }

    /* renamed from: g */
    public /* synthetic */ C7203d mo6303g(int i) {
        return m38992d(i);
    }

    /* renamed from: h */
    public /* synthetic */ C7203d mo6305h(int i) {
        return m38989c(i);
    }

    /* renamed from: i */
    public /* synthetic */ C7203d mo6307i(int i) {
        return m38981b(i);
    }

    /* renamed from: m */
    public /* synthetic */ C7203d mo6314m(long j) {
        return m39014l(j);
    }

    /* renamed from: n */
    public /* synthetic */ C7203d mo6316n(long j) {
        return m39013k(j);
    }

    /* renamed from: w */
    public /* synthetic */ C7203d mo6320w() {
        return m38988c();
    }

    /* renamed from: a */
    public long m38961a() {
        return this.f29839b;
    }

    /* renamed from: e */
    public boolean mo6300e() {
        return this.f29839b == 0;
    }

    /* renamed from: a */
    public void mo6288a(long j) {
        if (this.f29839b < j) {
            throw new EOFException();
        }
    }

    /* renamed from: b */
    public boolean mo6295b(long j) {
        return this.f29839b >= j ? 1 : 0;
    }

    /* renamed from: f */
    public InputStream mo6301f() {
        return new C58671(this);
    }

    /* renamed from: a */
    public C8037c m38967a(C8037c c8037c, long j, long j2) {
        if (c8037c != null) {
            C5878v.m24746a(this.f29839b, j, j2);
            if (j2 == 0) {
                return this;
            }
            c8037c.f29839b += j2;
            C5873p c5873p = this.f29838a;
            while (j >= ((long) (c5873p.f19541c - c5873p.f19540b))) {
                j -= (long) (c5873p.f19541c - c5873p.f19540b);
                c5873p = c5873p.f19544f;
            }
            while (j2 > 0) {
                C5873p a = c5873p.m24735a();
                a.f19540b = (int) (((long) a.f19540b) + j);
                a.f19541c = Math.min(a.f19540b + ((int) j2), a.f19541c);
                if (c8037c.f29838a == null) {
                    a.f19545g = a;
                    a.f19544f = a;
                    c8037c.f29838a = a;
                } else {
                    c8037c.f29838a.f19545g.m24737a(a);
                }
                j2 -= (long) (a.f19541c - a.f19540b);
                c5873p = c5873p.f19544f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: g */
    public long m39001g() {
        long j = this.f29839b;
        if (j == 0) {
            return 0;
        }
        C5873p c5873p = this.f29838a.f19545g;
        if (c5873p.f19541c < Utility.DEFAULT_STREAM_BUFFER_SIZE && c5873p.f19543e) {
            j -= (long) (c5873p.f19541c - c5873p.f19540b);
        }
        return j;
    }

    /* renamed from: h */
    public byte mo6304h() {
        if (this.f29839b != 0) {
            C5873p c5873p = this.f29838a;
            int i = c5873p.f19540b;
            int i2 = c5873p.f19541c;
            int i3 = i + 1;
            byte b = c5873p.f19539a[i];
            this.f29839b--;
            if (i3 == i2) {
                this.f29838a = c5873p.m24740c();
                C5874q.m24743a(c5873p);
            } else {
                c5873p.f19540b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    /* renamed from: c */
    public byte m38987c(long j) {
        C5878v.m24746a(this.f29839b, j, 1);
        C5873p c5873p;
        if (this.f29839b - j > j) {
            c5873p = this.f29838a;
            while (true) {
                long j2 = (long) (c5873p.f19541c - c5873p.f19540b);
                if (j < j2) {
                    return c5873p.f19539a[c5873p.f19540b + ((int) j)];
                }
                j -= j2;
                c5873p = c5873p.f19544f;
            }
        } else {
            j -= this.f29839b;
            c5873p = this.f29838a;
            do {
                c5873p = c5873p.f19545g;
                j += (long) (c5873p.f19541c - c5873p.f19540b);
            } while (j < 0);
            return c5873p.f19539a[c5873p.f19540b + ((int) j)];
        }
    }

    /* renamed from: i */
    public short mo6308i() {
        if (this.f29839b >= 2) {
            C5873p c5873p = this.f29838a;
            int i = c5873p.f19540b;
            int i2 = c5873p.f19541c;
            if (i2 - i < 2) {
                return (short) (((mo6304h() & JfifUtil.MARKER_FIRST_BYTE) << 8) | (mo6304h() & JfifUtil.MARKER_FIRST_BYTE));
            }
            byte[] bArr = c5873p.f19539a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            i = ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE);
            this.f29839b -= 2;
            if (i4 == i2) {
                this.f29838a = c5873p.m24740c();
                C5874q.m24743a(c5873p);
            } else {
                c5873p.f19540b = i4;
            }
            return (short) i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size < 2: ");
        stringBuilder.append(this.f29839b);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: j */
    public int mo6310j() {
        if (this.f29839b >= 4) {
            C5873p c5873p = this.f29838a;
            int i = c5873p.f19540b;
            int i2 = c5873p.f19541c;
            if (i2 - i < 4) {
                return ((((mo6304h() & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((mo6304h() & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((mo6304h() & JfifUtil.MARKER_FIRST_BYTE) << 8)) | (mo6304h() & JfifUtil.MARKER_FIRST_BYTE);
            }
            byte[] bArr = c5873p.f19539a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            i = ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 16);
            i3 = i4 + 1;
            i |= (bArr[i4] & JfifUtil.MARKER_FIRST_BYTE) << 8;
            i4 = i3 + 1;
            i |= bArr[i3] & JfifUtil.MARKER_FIRST_BYTE;
            this.f29839b -= 4;
            if (i4 == i2) {
                this.f29838a = c5873p.m24740c();
                C5874q.m24743a(c5873p);
            } else {
                c5873p.f19540b = i4;
            }
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size < 4: ");
        stringBuilder.append(this.f29839b);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: k */
    public long mo6311k() {
        if (this.f29839b >= 8) {
            C5873p c5873p = this.f29838a;
            int i = c5873p.f19540b;
            int i2 = c5873p.f19541c;
            if (i2 - i < 8) {
                return ((((long) mo6310j()) & 4294967295L) << 32) | (4294967295L & ((long) mo6310j()));
            }
            byte[] bArr = c5873p.f19539a;
            int i3 = i + 1;
            i = i3 + 1;
            int i4 = i + 1;
            i = i4 + 1;
            int i5 = i + 1;
            i = i5 + 1;
            i5 = i + 1;
            long j = (((((((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48)) | ((((long) bArr[i]) & 255) << 40)) | ((((long) bArr[i4]) & 255) << 32)) | ((((long) bArr[i]) & 255) << 24)) | ((((long) bArr[i5]) & 255) << 16)) | ((((long) bArr[i]) & 255) << 8);
            i = i5 + 1;
            long j2 = (((long) bArr[i5]) & 255) | j;
            this.f29839b -= 8;
            if (i == i2) {
                this.f29838a = c5873p.m24740c();
                C5874q.m24743a(c5873p);
            } else {
                c5873p.f19540b = i;
            }
            return j2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size < 8: ");
        stringBuilder.append(this.f29839b);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: l */
    public short mo6312l() {
        return C5878v.m24745a(mo6308i());
    }

    /* renamed from: m */
    public int mo6313m() {
        return C5878v.m24744a(mo6310j());
    }

    /* renamed from: n */
    public long mo6315n() {
        long j = 0;
        if (this.f29839b != 0) {
            int i = 0;
            long j2 = -7;
            Object obj = null;
            Object obj2 = null;
            do {
                C5873p c5873p = r0.f29838a;
                byte[] bArr = c5873p.f19539a;
                int i2 = c5873p.f19540b;
                int i3 = c5873p.f19541c;
                while (i2 < i3) {
                    int i4 = bArr[i2];
                    if (i4 >= (byte) 48 && i4 <= (byte) 57) {
                        int i5 = 48 - i4;
                        int i6 = (j > -922337203685477580L ? 1 : (j == -922337203685477580L ? 0 : -1));
                        if (i6 >= 0) {
                            if (i6 != 0 || ((long) i5) >= j2) {
                                j = (j * 10) + ((long) i5);
                            }
                        }
                        C8037c b = new C8037c().m39013k(j).m38981b(i4);
                        if (obj == null) {
                            b.mo6304h();
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Number too large: ");
                        stringBuilder.append(b.m39022q());
                        throw new NumberFormatException(stringBuilder.toString());
                    } else if (i4 == Framer.STDIN_FRAME_PREFIX && i == 0) {
                        j2--;
                        obj = 1;
                    } else if (i != 0) {
                        obj2 = 1;
                        if (i2 != i3) {
                            r0.f29838a = c5873p.m24740c();
                            C5874q.m24743a(c5873p);
                        } else {
                            c5873p.f19540b = i2;
                        }
                        if (obj2 == null) {
                            break;
                        }
                    } else {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Expected leading [0-9] or '-' character but was 0x");
                        stringBuilder2.append(Integer.toHexString(i4));
                        throw new NumberFormatException(stringBuilder2.toString());
                    }
                    i2++;
                    i++;
                }
                if (i2 != i3) {
                    c5873p.f19540b = i2;
                } else {
                    r0.f29838a = c5873p.m24740c();
                    C5874q.m24743a(c5873p);
                }
                if (obj2 == null) {
                    break;
                }
            } while (r0.f29838a != null);
            r0.f29839b -= (long) i;
            return obj != null ? j : -j;
        } else {
            throw new IllegalStateException("size == 0");
        }
    }

    /* renamed from: o */
    public long mo6317o() {
        if (this.f29839b != 0) {
            int i = 0;
            long j = 0;
            Object obj = null;
            do {
                C5873p c5873p = this.f29838a;
                byte[] bArr = c5873p.f19539a;
                int i2 = c5873p.f19540b;
                int i3 = c5873p.f19541c;
                while (i2 < i3) {
                    int i4;
                    int i5 = bArr[i2];
                    if (i5 >= (byte) 48 && i5 <= (byte) 57) {
                        i4 = i5 - 48;
                    } else if (i5 >= (byte) 97 && i5 <= (byte) 102) {
                        i4 = (i5 - 97) + 10;
                    } else if (i5 >= (byte) 65 && i5 <= (byte) 70) {
                        i4 = (i5 - 65) + 10;
                    } else if (i != 0) {
                        obj = 1;
                        if (i2 != i3) {
                            this.f29838a = c5873p.m24740c();
                            C5874q.m24743a(c5873p);
                        } else {
                            c5873p.f19540b = i2;
                        }
                        if (obj == null) {
                            break;
                        }
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Expected leading [0-9a-fA-F] character but was 0x");
                        stringBuilder.append(Integer.toHexString(i5));
                        throw new NumberFormatException(stringBuilder.toString());
                    }
                    if ((-1152921504606846976L & j) == 0) {
                        j = (j << 4) | ((long) i4);
                        i2++;
                        i++;
                    } else {
                        C8037c b = new C8037c().m39014l(j).m38981b(i5);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Number too large: ");
                        stringBuilder2.append(b.m39022q());
                        throw new NumberFormatException(stringBuilder2.toString());
                    }
                }
                if (i2 != i3) {
                    c5873p.f19540b = i2;
                } else {
                    this.f29838a = c5873p.m24740c();
                    C5874q.m24743a(c5873p);
                }
                if (obj == null) {
                    break;
                }
            } while (this.f29838a != null);
            this.f29839b -= (long) i;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    /* renamed from: p */
    public C5869f m39021p() {
        return new C5869f(mo6319s());
    }

    /* renamed from: d */
    public C5869f mo6299d(long j) {
        return new C5869f(mo6306h(j));
    }

    /* renamed from: a */
    public void mo6289a(C8037c c8037c, long j) {
        if (this.f29839b >= j) {
            c8037c.write(this, j);
        } else {
            c8037c.write(this, this.f29839b);
            throw new EOFException();
        }
    }

    /* renamed from: q */
    public String m39022q() {
        try {
            return m38973a(this.f29839b, C5878v.f19548a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: e */
    public String m38996e(long j) {
        return m38973a(j, C5878v.f19548a);
    }

    /* renamed from: a */
    public String mo6287a(Charset charset) {
        try {
            return m38973a(this.f29839b, charset);
        } catch (Charset charset2) {
            throw new AssertionError(charset2);
        }
    }

    /* renamed from: a */
    public String m38973a(long j, Charset charset) {
        C5878v.m24746a(this.f29839b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount > Integer.MAX_VALUE: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (j == 0) {
            return "";
        } else {
            C5873p c5873p = this.f29838a;
            if (((long) c5873p.f19540b) + j > ((long) c5873p.f19541c)) {
                return new String(mo6306h(j), charset);
            }
            String str = new String(c5873p.f19539a, c5873p.f19540b, (int) j, charset);
            c5873p.f19540b = (int) (((long) c5873p.f19540b) + j);
            this.f29839b -= j;
            if (c5873p.f19540b == c5873p.f19541c) {
                this.f29838a = c5873p.m24740c();
                C5874q.m24743a(c5873p);
            }
            return str;
        }
    }

    /* renamed from: r */
    public String mo6318r() {
        return mo6302f((long) Clock.MAX_TIME);
    }

    /* renamed from: f */
    public String mo6302f(long j) {
        if (j >= 0) {
            long j2 = Clock.MAX_TIME;
            if (j != Clock.MAX_TIME) {
                j2 = j + 1;
            }
            long a = m38963a((byte) 10, 0, j2);
            if (a != -1) {
                return m39003g(a);
            }
            if (j2 < m38961a() && m38987c(j2 - 1) == (byte) 13 && m38987c(j2) == (byte) 10) {
                return m39003g(j2);
            }
            C8037c c8037c = new C8037c();
            m38967a(c8037c, 0, Math.min(32, m38961a()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\\n not found: limit=");
            stringBuilder.append(Math.min(m38961a(), j));
            stringBuilder.append(" content=");
            stringBuilder.append(c8037c.m39021p().mo5108f());
            stringBuilder.append(8230);
            throw new EOFException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("limit < 0: ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: g */
    String m39003g(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (m38987c(j2) == (byte) 13) {
                j = m38996e(j2);
                mo6309i(2);
                return j;
            }
        }
        j = m38996e(j);
        mo6309i(1);
        return j;
    }

    /* renamed from: s */
    public byte[] mo6319s() {
        try {
            return mo6306h(this.f29839b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: h */
    public byte[] mo6306h(long j) {
        C5878v.m24746a(this.f29839b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            mo6290a(bArr);
            return bArr;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("byteCount > Integer.MAX_VALUE: ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public void mo6290a(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int a = m38960a(bArr, i, bArr.length - i);
            if (a != -1) {
                i += a;
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public int m38960a(byte[] bArr, int i, int i2) {
        C5878v.m24746a((long) bArr.length, (long) i, (long) i2);
        C5873p c5873p = this.f29838a;
        if (c5873p == null) {
            return -1;
        }
        i2 = Math.min(i2, c5873p.f19541c - c5873p.f19540b);
        System.arraycopy(c5873p.f19539a, c5873p.f19540b, bArr, i, i2);
        c5873p.f19540b += i2;
        this.f29839b -= (long) i2;
        if (c5873p.f19540b == c5873p.f19541c) {
            this.f29838a = c5873p.m24740c();
            C5874q.m24743a(c5873p);
        }
        return i2;
    }

    public int read(ByteBuffer byteBuffer) {
        C5873p c5873p = this.f29838a;
        if (c5873p == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), c5873p.f19541c - c5873p.f19540b);
        byteBuffer.put(c5873p.f19539a, c5873p.f19540b, min);
        c5873p.f19540b += min;
        this.f29839b -= (long) min;
        if (c5873p.f19540b == c5873p.f19541c) {
            this.f29838a = c5873p.m24740c();
            C5874q.m24743a(c5873p);
        }
        return min;
    }

    /* renamed from: t */
    public void m39025t() {
        try {
            mo6309i(this.f29839b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: i */
    public void mo6309i(long j) {
        while (j > 0) {
            if (this.f29838a != null) {
                int min = (int) Math.min(j, (long) (this.f29838a.f19541c - this.f29838a.f19540b));
                long j2 = (long) min;
                this.f29839b -= j2;
                j -= j2;
                C5873p c5873p = this.f29838a;
                c5873p.f19540b += min;
                if (this.f29838a.f19540b == this.f29838a.f19541c) {
                    C5873p c5873p2 = this.f29838a;
                    this.f29838a = c5873p2.m24740c();
                    C5874q.m24743a(c5873p2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public C8037c m38968a(C5869f c5869f) {
        if (c5869f != null) {
            c5869f.mo5100a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public C8037c m38969a(String str) {
        return m38970a(str, 0, str.length());
    }

    /* renamed from: a */
    public C8037c m38970a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            i2 = new StringBuilder();
            i2.append("beginIndex < 0: ");
            i2.append(i);
            throw new IllegalArgumentException(i2.toString());
        } else if (i2 < i) {
            r0 = new StringBuilder();
            r0.append("endIndex < beginIndex: ");
            r0.append(i2);
            r0.append(" < ");
            r0.append(i);
            throw new IllegalArgumentException(r0.toString());
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                int i3;
                int min;
                int i4;
                if (charAt < '') {
                    C5873p e = m38995e(1);
                    byte[] bArr = e.f19539a;
                    i3 = e.f19541c - i;
                    min = Math.min(i2, 8192 - i3);
                    int i5 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i5 < min) {
                        i = str.charAt(i5);
                        if (i >= 128) {
                            break;
                        }
                        i4 = i5 + 1;
                        bArr[i5 + i3] = (byte) i;
                        i5 = i4;
                    }
                    i3 = (i3 + i5) - e.f19541c;
                    e.f19541c += i3;
                    this.f29839b += (long) i3;
                    i = i5;
                } else if (charAt < 'ࠀ') {
                    m38981b((charAt >> 6) | JfifUtil.MARKER_SOFn);
                    m38981b((charAt & 63) | 128);
                    i++;
                } else {
                    if (charAt >= '?') {
                        if (charAt <= '?') {
                            i3 = i + 1;
                            if (i3 < i2) {
                                min = str.charAt(i3);
                            } else {
                                min = 0;
                            }
                            if (charAt <= '?' && min >= 56320) {
                                if (min <= 57343) {
                                    i4 = (((charAt & -55297) << 10) | (-56321 & min)) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                                    m38981b((i4 >> 18) | 240);
                                    m38981b(((i4 >> 12) & 63) | 128);
                                    m38981b(((i4 >> 6) & 63) | 128);
                                    m38981b((i4 & 63) | 128);
                                    i += 2;
                                }
                            }
                            m38981b(63);
                            i = i3;
                        }
                    }
                    m38981b((charAt >> 12) | 224);
                    m38981b(((charAt >> 6) & 63) | 128);
                    m38981b((charAt & 63) | 128);
                    i++;
                }
            }
            return this;
        } else {
            r0 = new StringBuilder();
            r0.append("endIndex > string.length: ");
            r0.append(i2);
            r0.append(" > ");
            r0.append(str.length());
            throw new IllegalArgumentException(r0.toString());
        }
    }

    /* renamed from: a */
    public C8037c m38966a(int i) {
        if (i < 128) {
            m38981b(i);
        } else if (i < 2048) {
            m38981b((i >> 6) | JfifUtil.MARKER_SOFn);
            m38981b((i & 63) | 128);
        } else if (i < NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
            if (i < 55296 || i > 57343) {
                m38981b((i >> 12) | 224);
                m38981b(((i >> 6) & 63) | 128);
                m38981b((i & 63) | 128);
            } else {
                m38981b(63);
            }
        } else if (i <= 1114111) {
            m38981b((i >> 18) | 240);
            m38981b(((i >> 12) & 63) | 128);
            m38981b(((i >> 6) & 63) | 128);
            m38981b((i & 63) | 128);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected code point: ");
            stringBuilder.append(Integer.toHexString(i));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return this;
    }

    /* renamed from: a */
    public C8037c m38972a(String str, Charset charset) {
        return m38971a(str, 0, str.length(), charset);
    }

    /* renamed from: a */
    public C8037c m38971a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            i2 = new StringBuilder();
            i2.append("beginIndex < 0: ");
            i2.append(i);
            throw new IllegalAccessError(i2.toString());
        } else if (i2 < i) {
            charset = new StringBuilder();
            charset.append("endIndex < beginIndex: ");
            charset.append(i2);
            charset.append(" < ");
            charset.append(i);
            throw new IllegalArgumentException(charset.toString());
        } else if (i2 > str.length()) {
            charset = new StringBuilder();
            charset.append("endIndex > string.length: ");
            charset.append(i2);
            charset.append(" > ");
            charset.append(str.length());
            throw new IllegalArgumentException(charset.toString());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(C5878v.f19548a)) {
            return m38970a(str, i, i2);
        } else {
            str = str.substring(i, i2).getBytes(charset);
            return m38983b(str, 0, str.length);
        }
    }

    /* renamed from: b */
    public C8037c m38982b(byte[] bArr) {
        if (bArr != null) {
            return m38983b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public C8037c m38983b(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            C5878v.m24746a((long) bArr.length, (long) i, j);
            i2 += i;
            while (i < i2) {
                C5873p e = m38995e(1);
                int min = Math.min(i2 - i, 8192 - e.f19541c);
                System.arraycopy(bArr, i, e.f19539a, e.f19541c, min);
                i += min;
                e.f19541c += min;
            }
            this.f29839b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                C5873p e = m38995e(1);
                int min = Math.min(i, 8192 - e.f19541c);
                byteBuffer.get(e.f19539a, e.f19541c, min);
                i -= min;
                e.f19541c += min;
            }
            this.f29839b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public long mo6286a(C5876t c5876t) {
        if (c5876t != null) {
            long j = 0;
            while (true) {
                long read = c5876t.read(this, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: b */
    public C8037c m38981b(int i) {
        C5873p e = m38995e(1);
        byte[] bArr = e.f19539a;
        int i2 = e.f19541c;
        e.f19541c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f29839b++;
        return this;
    }

    /* renamed from: c */
    public C8037c m38989c(int i) {
        C5873p e = m38995e(2);
        byte[] bArr = e.f19539a;
        int i2 = e.f19541c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & JfifUtil.MARKER_FIRST_BYTE);
        e.f19541c = i2;
        this.f29839b += 2;
        return this;
    }

    /* renamed from: d */
    public C8037c m38992d(int i) {
        C5873p e = m38995e(4);
        byte[] bArr = e.f19539a;
        int i2 = e.f19541c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & JfifUtil.MARKER_FIRST_BYTE);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & JfifUtil.MARKER_FIRST_BYTE);
        e.f19541c = i2;
        this.f29839b += 4;
        return this;
    }

    /* renamed from: j */
    public C8037c m39011j(long j) {
        C5873p e = m38995e(8);
        byte[] bArr = e.f19539a;
        int i = e.f19541c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 40) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 32) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 24) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 16) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 8) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j & 255));
        e.f19541c = i3;
        this.f29839b += 8;
        return this;
    }

    /* renamed from: k */
    public C8037c m39013k(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return m38981b((int) 48);
        }
        Object obj = null;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return m38969a("-9223372036854775808");
            }
            obj = 1;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (obj != null) {
            i2++;
        }
        C5873p e = m38995e(i2);
        byte[] bArr = e.f19539a;
        int i3 = e.f19541c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = f29837c[(int) (j % 10)];
            j /= 10;
        }
        if (obj != null) {
            bArr[i3 - 1] = 45;
        }
        e.f19541c += i2;
        this.f29839b += (long) i2;
        return this;
    }

    /* renamed from: l */
    public C8037c m39014l(long j) {
        if (j == 0) {
            return m38981b((int) 48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C5873p e = m38995e(numberOfTrailingZeros);
        byte[] bArr = e.f19539a;
        int i = e.f19541c;
        for (int i2 = (e.f19541c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f29837c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f19541c += numberOfTrailingZeros;
        this.f29839b += (long) numberOfTrailingZeros;
        return this;
    }

    /* renamed from: e */
    C5873p m38995e(int i) {
        if (i < 1 || i > Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            throw new IllegalArgumentException();
        } else if (this.f29838a == null) {
            this.f29838a = C5874q.m24742a();
            i = this.f29838a;
            C5873p c5873p = this.f29838a;
            r1 = this.f29838a;
            c5873p.f19545g = r1;
            i.f19544f = r1;
            return r1;
        } else {
            r1 = this.f29838a.f19545g;
            if (r1.f19541c + i > Utility.DEFAULT_STREAM_BUFFER_SIZE || r1.f19543e == 0) {
                r1 = r1.m24737a(C5874q.m24742a());
            }
            return r1;
        }
    }

    public void write(C8037c c8037c, long j) {
        if (c8037c == null) {
            throw new IllegalArgumentException("source == null");
        } else if (c8037c != this) {
            C5878v.m24746a(c8037c.f29839b, 0, j);
            while (j > 0) {
                C5873p c5873p;
                long j2;
                if (j < ((long) (c8037c.f29838a.f19541c - c8037c.f29838a.f19540b))) {
                    c5873p = this.f29838a != null ? this.f29838a.f19545g : null;
                    if (c5873p != null && c5873p.f19543e) {
                        int i;
                        j2 = ((long) c5873p.f19541c) + j;
                        if (c5873p.f19542d) {
                            i = 0;
                        } else {
                            i = c5873p.f19540b;
                        }
                        if (j2 - ((long) i) <= 8192) {
                            c8037c.f29838a.m24738a(c5873p, (int) j);
                            c8037c.f29839b -= j;
                            this.f29839b += j;
                            return;
                        }
                    }
                    c8037c.f29838a = c8037c.f29838a.m24736a((int) j);
                }
                c5873p = c8037c.f29838a;
                j2 = (long) (c5873p.f19541c - c5873p.f19540b);
                c8037c.f29838a = c5873p.m24740c();
                if (this.f29838a == null) {
                    this.f29838a = c5873p;
                    c5873p = this.f29838a;
                    C5873p c5873p2 = this.f29838a;
                    C5873p c5873p3 = this.f29838a;
                    c5873p2.f19545g = c5873p3;
                    c5873p.f19544f = c5873p3;
                } else {
                    this.f29838a.f19545g.m24737a(c5873p).m24741d();
                }
                c8037c.f29839b -= j2;
                this.f29839b += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long read(C8037c c8037c, long j) {
        if (c8037c == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f29839b == 0) {
            return -1;
        } else {
            if (j > this.f29839b) {
                j = this.f29839b;
            }
            c8037c.write(this, j);
            return j;
        }
    }

    /* renamed from: a */
    public long mo6285a(byte b) {
        return m38963a(b, 0, (long) Clock.MAX_TIME);
    }

    /* renamed from: a */
    public long m38963a(byte b, long j, long j2) {
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f29839b), Long.valueOf(j), Long.valueOf(j2)}));
        }
        if (j2 > this.f29839b) {
            j2 = this.f29839b;
        }
        if (j == j2) {
            return -1;
        }
        C5873p c5873p = this.f29838a;
        if (c5873p == null) {
            return -1;
        }
        if (this.f29839b - j >= j) {
            while (true) {
                long j4 = ((long) (c5873p.f19541c - c5873p.f19540b)) + j3;
                if (j4 >= j) {
                    break;
                }
                c5873p = c5873p.f19544f;
                j3 = j4;
            }
        } else {
            j3 = this.f29839b;
            while (j3 > j) {
                c5873p = c5873p.f19545g;
                j3 -= (long) (c5873p.f19541c - c5873p.f19540b);
            }
        }
        while (j3 < j2) {
            byte[] bArr = c5873p.f19539a;
            int min = (int) Math.min((long) c5873p.f19541c, (((long) c5873p.f19540b) + j2) - j3);
            for (j = (int) ((((long) c5873p.f19540b) + j) - j3); j < min; j++) {
                if (bArr[j] == b) {
                    return ((long) (j - c5873p.f19540b)) + j3;
                }
            }
            j = ((long) (c5873p.f19541c - c5873p.f19540b)) + j3;
            c5873p = c5873p.f19544f;
            j3 = j;
        }
        return -1;
    }

    /* renamed from: a */
    public boolean mo6291a(long j, C5869f c5869f) {
        return m38979a(j, c5869f, 0, c5869f.mo5110h());
    }

    /* renamed from: a */
    public boolean m38979a(long j, C5869f c5869f, int i, int i2) {
        if (j >= 0 && i >= 0 && i2 >= 0 && this.f29839b - j >= ((long) i2)) {
            if (c5869f.mo5110h() - i >= i2) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (m38987c(((long) i3) + j) != c5869f.mo5097a(i + i3)) {
                        return false;
                    }
                }
                return 1;
            }
        }
        return false;
    }

    public C5877u timeout() {
        return C5877u.NONE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8037c)) {
            return false;
        }
        C8037c c8037c = (C8037c) obj;
        if (this.f29839b != c8037c.f29839b) {
            return false;
        }
        long j = 0;
        if (this.f29839b == 0) {
            return true;
        }
        C5873p c5873p = this.f29838a;
        obj = c8037c.f29838a;
        int i = c5873p.f19540b;
        int i2 = obj.f19540b;
        while (j < this.f29839b) {
            long min = (long) Math.min(c5873p.f19541c - i, obj.f19541c - i2);
            int i3 = i2;
            i2 = i;
            i = 0;
            while (((long) i) < min) {
                int i4 = i2 + 1;
                int i5 = i3 + 1;
                if (c5873p.f19539a[i2] != obj.f19539a[i3]) {
                    return false;
                }
                i++;
                i2 = i4;
                i3 = i5;
            }
            if (i2 == c5873p.f19541c) {
                c5873p = c5873p.f19544f;
                i = c5873p.f19540b;
            } else {
                i = i2;
            }
            if (i3 == obj.f19541c) {
                obj = obj.f19544f;
                i2 = obj.f19540b;
            } else {
                i2 = i3;
            }
            j += min;
        }
        return true;
    }

    public int hashCode() {
        C5873p c5873p = this.f29838a;
        if (c5873p == null) {
            return 0;
        }
        int i = 1;
        do {
            for (int i2 = c5873p.f19540b; i2 < c5873p.f19541c; i2++) {
                i = (i * 31) + c5873p.f19539a[i2];
            }
            c5873p = c5873p.f19544f;
        } while (c5873p != this.f29838a);
        return i;
    }

    public String toString() {
        return m39027v().toString();
    }

    /* renamed from: u */
    public C8037c m39026u() {
        C8037c c8037c = new C8037c();
        if (this.f29839b == 0) {
            return c8037c;
        }
        c8037c.f29838a = this.f29838a.m24735a();
        C5873p c5873p = c8037c.f29838a;
        C5873p c5873p2 = c8037c.f29838a;
        C5873p c5873p3 = c8037c.f29838a;
        c5873p2.f19545g = c5873p3;
        c5873p.f19544f = c5873p3;
        c5873p = this.f29838a;
        while (true) {
            c5873p = c5873p.f19544f;
            if (c5873p != this.f29838a) {
                c8037c.f29838a.f19545g.m24737a(c5873p.m24735a());
            } else {
                c8037c.f29839b = this.f29839b;
                return c8037c;
            }
        }
    }

    /* renamed from: v */
    public C5869f m39027v() {
        if (this.f29839b <= 2147483647L) {
            return m38998f((int) this.f29839b);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size > Integer.MAX_VALUE: ");
        stringBuilder.append(this.f29839b);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: f */
    public C5869f m38998f(int i) {
        if (i == 0) {
            return C5869f.f19527b;
        }
        return new C7215r(this, i);
    }

    /* renamed from: a */
    public C5868a m38965a(C5868a c5868a) {
        if (c5868a.f19519a == null) {
            c5868a.f19519a = this;
            c5868a.f19520b = true;
            return c5868a;
        }
        throw new IllegalStateException("already attached to a buffer");
    }
}
