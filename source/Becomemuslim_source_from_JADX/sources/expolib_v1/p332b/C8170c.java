package expolib_v1.p332b;

import com.facebook.common.time.Clock;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.stetho.dumpapp.Framer;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* compiled from: Buffer */
/* renamed from: expolib_v1.b.c */
public final class C8170c implements C7496d, C7497e, Cloneable {
    /* renamed from: c */
    private static final byte[] f30351c = new byte[]{(byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    /* renamed from: a */
    C6255o f30352a;
    /* renamed from: b */
    long f30353b;

    /* compiled from: Buffer */
    /* renamed from: expolib_v1.b.c$1 */
    class C62491 extends OutputStream {
        /* renamed from: a */
        final /* synthetic */ C8170c f20375a;

        public void close() {
        }

        public void flush() {
        }

        C62491(C8170c c8170c) {
            this.f20375a = c8170c;
        }

        public void write(int i) {
            this.f20375a.m39604b((byte) i);
        }

        public void write(byte[] bArr, int i, int i2) {
            this.f20375a.m39605b(bArr, i, i2);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f20375a);
            stringBuilder.append(".outputStream()");
            return stringBuilder.toString();
        }
    }

    /* compiled from: Buffer */
    /* renamed from: expolib_v1.b.c$2 */
    class C62502 extends InputStream {
        /* renamed from: a */
        final /* synthetic */ C8170c f20376a;

        public void close() {
        }

        C62502(C8170c c8170c) {
            this.f20376a = c8170c;
        }

        public int read() {
            return this.f20376a.f30353b > 0 ? this.f20376a.mo6388i() & JfifUtil.MARKER_FIRST_BYTE : -1;
        }

        public int read(byte[] bArr, int i, int i2) {
            return this.f20376a.mo6365a(bArr, i, i2);
        }

        public int available() {
            return (int) Math.min(this.f20376a.f30353b, 2147483647L);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f20376a);
            stringBuilder.append(".inputStream()");
            return stringBuilder.toString();
        }
    }

    /* renamed from: b */
    public C8170c mo6372b() {
        return this;
    }

    public void close() {
    }

    /* renamed from: d */
    public C8170c m39615d() {
        return this;
    }

    /* renamed from: e */
    public C7496d mo6381e() {
        return this;
    }

    public void flush() {
    }

    /* renamed from: b */
    public /* synthetic */ C7496d mo6373b(String str) {
        return m39591a(str);
    }

    /* renamed from: c */
    public /* synthetic */ C7496d mo6376c(C6251f c6251f) {
        return m39590a(c6251f);
    }

    /* renamed from: c */
    public /* synthetic */ C7496d mo6377c(byte[] bArr, int i, int i2) {
        return m39605b(bArr, i, i2);
    }

    public /* synthetic */ Object clone() {
        return m39651v();
    }

    /* renamed from: d */
    public /* synthetic */ C7496d mo6380d(byte[] bArr) {
        return m39610c(bArr);
    }

    /* renamed from: g */
    public /* synthetic */ C7496d mo6383g(int i) {
        return m39616d(i);
    }

    /* renamed from: h */
    public /* synthetic */ C7496d mo6386h(int i) {
        return m39609c(i);
    }

    /* renamed from: i */
    public /* synthetic */ C7496d mo6389i(int i) {
        return m39604b(i);
    }

    /* renamed from: l */
    public /* synthetic */ C7496d mo6393l(long j) {
        return m39637k(j);
    }

    /* renamed from: m */
    public /* synthetic */ C7496d mo6394m(long j) {
        return m39634j(j);
    }

    /* renamed from: n */
    public /* synthetic */ C7496d mo6397n(long j) {
        return m39632i(j);
    }

    /* renamed from: x */
    public /* synthetic */ C7496d mo6403x() {
        return m39615d();
    }

    /* renamed from: a */
    public long m39582a() {
        return this.f30353b;
    }

    /* renamed from: c */
    public OutputStream mo6379c() {
        return new C62491(this);
    }

    /* renamed from: f */
    public boolean mo6382f() {
        return this.f30353b == 0;
    }

    /* renamed from: a */
    public void mo6370a(long j) {
        if (this.f30353b < j) {
            throw new EOFException();
        }
    }

    /* renamed from: g */
    public InputStream mo6384g() {
        return new C62502(this);
    }

    /* renamed from: a */
    public C8170c m39589a(C8170c c8170c, long j, long j2) {
        if (c8170c != null) {
            C6260u.m25887a(this.f30353b, j, j2);
            if (j2 == 0) {
                return this;
            }
            c8170c.f30353b += j2;
            C6255o c6255o = this.f30352a;
            while (j >= ((long) (c6255o.f20387c - c6255o.f20386b))) {
                j -= (long) (c6255o.f20387c - c6255o.f20386b);
                c6255o = c6255o.f20390f;
            }
            while (j2 > 0) {
                C6255o c6255o2 = new C6255o(c6255o);
                c6255o2.f20386b = (int) (((long) c6255o2.f20386b) + j);
                c6255o2.f20387c = Math.min(c6255o2.f20386b + ((int) j2), c6255o2.f20387c);
                if (c8170c.f30352a == null) {
                    c6255o2.f20391g = c6255o2;
                    c6255o2.f20390f = c6255o2;
                    c8170c.f30352a = c6255o2;
                } else {
                    c8170c.f30352a.f20391g.m25874a(c6255o2);
                }
                j2 -= (long) (c6255o2.f20387c - c6255o2.f20386b);
                c6255o = c6255o.f20390f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: h */
    public long m39628h() {
        long j = this.f30353b;
        if (j == 0) {
            return 0;
        }
        C6255o c6255o = this.f30352a.f20391g;
        if (c6255o.f20387c < Utility.DEFAULT_STREAM_BUFFER_SIZE && c6255o.f20389e) {
            j -= (long) (c6255o.f20387c - c6255o.f20386b);
        }
        return j;
    }

    /* renamed from: i */
    public byte mo6388i() {
        if (this.f30353b != 0) {
            C6255o c6255o = this.f30352a;
            int i = c6255o.f20386b;
            int i2 = c6255o.f20387c;
            int i3 = i + 1;
            byte b = c6255o.f20385a[i];
            this.f30353b--;
            if (i3 == i2) {
                this.f30352a = c6255o.m25872a();
                C6256p.m25878a(c6255o);
            } else {
                c6255o.f20386b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    /* renamed from: b */
    public byte m39601b(long j) {
        C6260u.m25887a(this.f30353b, j, 1);
        C6255o c6255o = this.f30352a;
        while (true) {
            long j2 = (long) (c6255o.f20387c - c6255o.f20386b);
            if (j < j2) {
                return c6255o.f20385a[c6255o.f20386b + ((int) j)];
            }
            j -= j2;
            c6255o = c6255o.f20390f;
        }
    }

    /* renamed from: j */
    public short mo6390j() {
        if (this.f30353b >= 2) {
            C6255o c6255o = this.f30352a;
            int i = c6255o.f20386b;
            int i2 = c6255o.f20387c;
            if (i2 - i < 2) {
                return (short) (((mo6388i() & JfifUtil.MARKER_FIRST_BYTE) << 8) | (mo6388i() & JfifUtil.MARKER_FIRST_BYTE));
            }
            byte[] bArr = c6255o.f20385a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            i = ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE);
            this.f30353b -= 2;
            if (i4 == i2) {
                this.f30352a = c6255o.m25872a();
                C6256p.m25878a(c6255o);
            } else {
                c6255o.f20386b = i4;
            }
            return (short) i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size < 2: ");
        stringBuilder.append(this.f30353b);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: k */
    public int mo6391k() {
        if (this.f30353b >= 4) {
            C6255o c6255o = this.f30352a;
            int i = c6255o.f20386b;
            int i2 = c6255o.f20387c;
            if (i2 - i < 4) {
                return ((((mo6388i() & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((mo6388i() & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((mo6388i() & JfifUtil.MARKER_FIRST_BYTE) << 8)) | (mo6388i() & JfifUtil.MARKER_FIRST_BYTE);
            }
            byte[] bArr = c6255o.f20385a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            i = ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 16);
            i3 = i4 + 1;
            i |= (bArr[i4] & JfifUtil.MARKER_FIRST_BYTE) << 8;
            i4 = i3 + 1;
            i |= bArr[i3] & JfifUtil.MARKER_FIRST_BYTE;
            this.f30353b -= 4;
            if (i4 == i2) {
                this.f30352a = c6255o.m25872a();
                C6256p.m25878a(c6255o);
            } else {
                c6255o.f20386b = i4;
            }
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size < 4: ");
        stringBuilder.append(this.f30353b);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: l */
    public long mo6392l() {
        if (this.f30353b >= 8) {
            C6255o c6255o = this.f30352a;
            int i = c6255o.f20386b;
            int i2 = c6255o.f20387c;
            if (i2 - i < 8) {
                return ((((long) mo6391k()) & 4294967295L) << 32) | (4294967295L & ((long) mo6391k()));
            }
            byte[] bArr = c6255o.f20385a;
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
            this.f30353b -= 8;
            if (i == i2) {
                this.f30352a = c6255o.m25872a();
                C6256p.m25878a(c6255o);
            } else {
                c6255o.f20386b = i;
            }
            return j2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size < 8: ");
        stringBuilder.append(this.f30353b);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: m */
    public short mo6395m() {
        return C6260u.m25886a(mo6390j());
    }

    /* renamed from: n */
    public int mo6396n() {
        return C6260u.m25885a(mo6391k());
    }

    /* renamed from: o */
    public long mo6398o() {
        long j = 0;
        if (this.f30353b != 0) {
            int i = 0;
            long j2 = -7;
            Object obj = null;
            Object obj2 = null;
            do {
                C6255o c6255o = r0.f30352a;
                byte[] bArr = c6255o.f20385a;
                int i2 = c6255o.f20386b;
                int i3 = c6255o.f20387c;
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
                        C8170c b = new C8170c().m39634j(j).m39604b(i4);
                        if (obj == null) {
                            b.mo6388i();
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Number too large: ");
                        stringBuilder.append(b.mo6400r());
                        throw new NumberFormatException(stringBuilder.toString());
                    } else if (i4 == Framer.STDIN_FRAME_PREFIX && i == 0) {
                        j2--;
                        obj = 1;
                    } else if (i != 0) {
                        obj2 = 1;
                        if (i2 != i3) {
                            r0.f30352a = c6255o.m25872a();
                            C6256p.m25878a(c6255o);
                        } else {
                            c6255o.f20386b = i2;
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
                    c6255o.f20386b = i2;
                } else {
                    r0.f30352a = c6255o.m25872a();
                    C6256p.m25878a(c6255o);
                }
                if (obj2 == null) {
                    break;
                }
            } while (r0.f30352a != null);
            r0.f30353b -= (long) i;
            return obj != null ? j : -j;
        } else {
            throw new IllegalStateException("size == 0");
        }
    }

    /* renamed from: p */
    public long mo6399p() {
        if (this.f30353b != 0) {
            int i = 0;
            long j = 0;
            Object obj = null;
            do {
                C6255o c6255o = this.f30352a;
                byte[] bArr = c6255o.f20385a;
                int i2 = c6255o.f20386b;
                int i3 = c6255o.f20387c;
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
                            this.f30352a = c6255o.m25872a();
                            C6256p.m25878a(c6255o);
                        } else {
                            c6255o.f20386b = i2;
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
                        C8170c b = new C8170c().m39637k(j).m39604b(i5);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Number too large: ");
                        stringBuilder2.append(b.mo6400r());
                        throw new NumberFormatException(stringBuilder2.toString());
                    }
                }
                if (i2 != i3) {
                    c6255o.f20386b = i2;
                } else {
                    this.f30352a = c6255o.m25872a();
                    C6256p.m25878a(c6255o);
                }
                if (obj == null) {
                    break;
                }
            } while (this.f30352a != null);
            this.f30353b -= (long) i;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    /* renamed from: q */
    public C6251f m39646q() {
        return new C6251f(mo6402t());
    }

    /* renamed from: c */
    public C6251f mo6378c(long j) {
        return new C6251f(mo6385g(j));
    }

    /* renamed from: b */
    public void mo6374b(C8170c c8170c, long j) {
        if (this.f30353b >= j) {
            c8170c.mo5257a(this, j);
        } else {
            c8170c.mo5257a(this, this.f30353b);
            throw new EOFException();
        }
    }

    /* renamed from: a */
    public long mo6367a(C6257r c6257r) {
        long j = this.f30353b;
        if (j > 0) {
            c6257r.mo5257a(this, j);
        }
        return j;
    }

    /* renamed from: r */
    public String mo6400r() {
        try {
            return m39595a(this.f30353b, C6260u.f20398a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: d */
    public String m39618d(long j) {
        return m39595a(j, C6260u.f20398a);
    }

    /* renamed from: a */
    public String mo6369a(Charset charset) {
        try {
            return m39595a(this.f30353b, charset);
        } catch (Charset charset2) {
            throw new AssertionError(charset2);
        }
    }

    /* renamed from: a */
    public String m39595a(long j, Charset charset) {
        C6260u.m25887a(this.f30353b, 0, j);
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
            C6255o c6255o = this.f30352a;
            if (((long) c6255o.f20386b) + j > ((long) c6255o.f20387c)) {
                return new String(mo6385g(j), charset);
            }
            String str = new String(c6255o.f20385a, c6255o.f20386b, (int) j, charset);
            c6255o.f20386b = (int) (((long) c6255o.f20386b) + j);
            this.f30353b -= j;
            if (c6255o.f20386b == c6255o.f20387c) {
                this.f30352a = c6255o.m25872a();
                C6256p.m25878a(c6255o);
            }
            return str;
        }
    }

    /* renamed from: s */
    public String mo6401s() {
        return m39621e((long) Clock.MAX_TIME);
    }

    /* renamed from: e */
    public String m39621e(long j) {
        if (j >= 0) {
            long j2 = Clock.MAX_TIME;
            if (j != Clock.MAX_TIME) {
                j2 = j + 1;
            }
            long a = m39584a((byte) 10, 0, j2);
            if (a != -1) {
                return m39623f(a);
            }
            if (j2 < m39582a() && m39601b(j2 - 1) == (byte) 13 && m39601b(j2) == (byte) 10) {
                return m39623f(j2);
            }
            C8170c c8170c = new C8170c();
            m39589a(c8170c, 0, Math.min(32, m39582a()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\\n not found: limit=");
            stringBuilder.append(Math.min(m39582a(), j));
            stringBuilder.append(" content=");
            stringBuilder.append(c8170c.m39646q().mo5364f());
            stringBuilder.append(8230);
            throw new EOFException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("limit < 0: ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: f */
    String m39623f(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (m39601b(j2) == (byte) 13) {
                j = m39618d(j2);
                mo6387h(2);
                return j;
            }
        }
        j = m39618d(j);
        mo6387h(1);
        return j;
    }

    /* renamed from: t */
    public byte[] mo6402t() {
        try {
            return mo6385g(this.f30353b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: g */
    public byte[] mo6385g(long j) {
        C6260u.m25887a(this.f30353b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            mo6375b(bArr);
            return bArr;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("byteCount > Integer.MAX_VALUE: ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int m39580a(byte[] bArr) {
        return mo6365a(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public void mo6375b(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int a = mo6365a(bArr, i, bArr.length - i);
            if (a != -1) {
                i += a;
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public int mo6365a(byte[] bArr, int i, int i2) {
        C6260u.m25887a((long) bArr.length, (long) i, (long) i2);
        C6255o c6255o = this.f30352a;
        if (c6255o == null) {
            return -1;
        }
        i2 = Math.min(i2, c6255o.f20387c - c6255o.f20386b);
        System.arraycopy(c6255o.f20385a, c6255o.f20386b, bArr, i, i2);
        c6255o.f20386b += i2;
        this.f30353b -= (long) i2;
        if (c6255o.f20386b == c6255o.f20387c) {
            this.f30352a = c6255o.m25872a();
            C6256p.m25878a(c6255o);
        }
        return i2;
    }

    /* renamed from: u */
    public void m39650u() {
        try {
            mo6387h(this.f30353b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: h */
    public void mo6387h(long j) {
        while (j > 0) {
            if (this.f30352a != null) {
                int min = (int) Math.min(j, (long) (this.f30352a.f20387c - this.f30352a.f20386b));
                long j2 = (long) min;
                this.f30353b -= j2;
                j -= j2;
                C6255o c6255o = this.f30352a;
                c6255o.f20386b += min;
                if (this.f30352a.f20386b == this.f30352a.f20387c) {
                    C6255o c6255o2 = this.f30352a;
                    this.f30352a = c6255o2.m25872a();
                    C6256p.m25878a(c6255o2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public C8170c m39590a(C6251f c6251f) {
        if (c6251f != null) {
            c6251f.mo5356a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public C8170c m39591a(String str) {
        return m39592a(str, 0, str.length());
    }

    /* renamed from: a */
    public C8170c m39592a(String str, int i, int i2) {
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
                    C6255o e = m39620e(1);
                    byte[] bArr = e.f20385a;
                    i3 = e.f20387c - i;
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
                    i3 = (i3 + i5) - e.f20387c;
                    e.f20387c += i3;
                    this.f30353b += (long) i3;
                    i = i5;
                } else if (charAt < 'ࠀ') {
                    m39604b((charAt >> 6) | JfifUtil.MARKER_SOFn);
                    m39604b((charAt & 63) | 128);
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
                                    m39604b((i4 >> 18) | 240);
                                    m39604b(((i4 >> 12) & 63) | 128);
                                    m39604b(((i4 >> 6) & 63) | 128);
                                    m39604b((i4 & 63) | 128);
                                    i += 2;
                                }
                            }
                            m39604b(63);
                            i = i3;
                        }
                    }
                    m39604b((charAt >> 12) | 224);
                    m39604b(((charAt >> 6) & 63) | 128);
                    m39604b((charAt & 63) | 128);
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
    public C8170c m39588a(int i) {
        if (i < 128) {
            m39604b(i);
        } else if (i < 2048) {
            m39604b((i >> 6) | JfifUtil.MARKER_SOFn);
            m39604b((i & 63) | 128);
        } else if (i < NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
            if (i < 55296 || i > 57343) {
                m39604b((i >> 12) | 224);
                m39604b(((i >> 6) & 63) | 128);
                m39604b((i & 63) | 128);
            } else {
                m39604b(63);
            }
        } else if (i <= 1114111) {
            m39604b((i >> 18) | 240);
            m39604b(((i >> 12) & 63) | 128);
            m39604b(((i >> 6) & 63) | 128);
            m39604b((i & 63) | 128);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected code point: ");
            stringBuilder.append(Integer.toHexString(i));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return this;
    }

    /* renamed from: a */
    public C8170c m39594a(String str, Charset charset) {
        return m39593a(str, 0, str.length(), charset);
    }

    /* renamed from: a */
    public C8170c m39593a(String str, int i, int i2, Charset charset) {
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
        } else if (charset.equals(C6260u.f20398a)) {
            return m39592a(str, i, i2);
        } else {
            str = str.substring(i, i2).getBytes(charset);
            return m39605b(str, 0, str.length);
        }
    }

    /* renamed from: c */
    public C8170c m39610c(byte[] bArr) {
        if (bArr != null) {
            return m39605b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public C8170c m39605b(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            C6260u.m25887a((long) bArr.length, (long) i, j);
            i2 += i;
            while (i < i2) {
                C6255o e = m39620e(1);
                int min = Math.min(i2 - i, 8192 - e.f20387c);
                System.arraycopy(bArr, i, e.f20385a, e.f20387c, min);
                i += min;
                e.f20387c += min;
            }
            this.f30353b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public long mo6368a(C6258s c6258s) {
        if (c6258s != null) {
            long j = 0;
            while (true) {
                long read = c6258s.read(this, 8192);
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
    public C8170c m39604b(int i) {
        C6255o e = m39620e(1);
        byte[] bArr = e.f20385a;
        int i2 = e.f20387c;
        e.f20387c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f30353b++;
        return this;
    }

    /* renamed from: c */
    public C8170c m39609c(int i) {
        C6255o e = m39620e(2);
        byte[] bArr = e.f20385a;
        int i2 = e.f20387c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & JfifUtil.MARKER_FIRST_BYTE);
        e.f20387c = i2;
        this.f30353b += 2;
        return this;
    }

    /* renamed from: d */
    public C8170c m39616d(int i) {
        C6255o e = m39620e(4);
        byte[] bArr = e.f20385a;
        int i2 = e.f20387c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & JfifUtil.MARKER_FIRST_BYTE);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & JfifUtil.MARKER_FIRST_BYTE);
        e.f20387c = i2;
        this.f30353b += 4;
        return this;
    }

    /* renamed from: i */
    public C8170c m39632i(long j) {
        C6255o e = m39620e(8);
        byte[] bArr = e.f20385a;
        int i = e.f20387c;
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
        e.f20387c = i3;
        this.f30353b += 8;
        return this;
    }

    /* renamed from: j */
    public C8170c m39634j(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return m39604b((int) 48);
        }
        Object obj = null;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return m39591a("-9223372036854775808");
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
        C6255o e = m39620e(i2);
        byte[] bArr = e.f20385a;
        int i3 = e.f20387c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = f30351c[(int) (j % 10)];
            j /= 10;
        }
        if (obj != null) {
            bArr[i3 - 1] = 45;
        }
        e.f20387c += i2;
        this.f30353b += (long) i2;
        return this;
    }

    /* renamed from: k */
    public C8170c m39637k(long j) {
        if (j == 0) {
            return m39604b((int) 48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C6255o e = m39620e(numberOfTrailingZeros);
        byte[] bArr = e.f20385a;
        int i = e.f20387c;
        for (int i2 = (e.f20387c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f30351c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f20387c += numberOfTrailingZeros;
        this.f30353b += (long) numberOfTrailingZeros;
        return this;
    }

    /* renamed from: e */
    C6255o m39620e(int i) {
        if (i < 1 || i > Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            throw new IllegalArgumentException();
        } else if (this.f30352a == null) {
            this.f30352a = C6256p.m25877a();
            i = this.f30352a;
            C6255o c6255o = this.f30352a;
            r1 = this.f30352a;
            c6255o.f20391g = r1;
            i.f20390f = r1;
            return r1;
        } else {
            r1 = this.f30352a.f20391g;
            if (r1.f20387c + i > Utility.DEFAULT_STREAM_BUFFER_SIZE || r1.f20389e == 0) {
                r1 = r1.m25874a(C6256p.m25877a());
            }
            return r1;
        }
    }

    /* renamed from: a */
    public void mo5257a(C8170c c8170c, long j) {
        if (c8170c == null) {
            throw new IllegalArgumentException("source == null");
        } else if (c8170c != this) {
            C6260u.m25887a(c8170c.f30353b, 0, j);
            while (j > 0) {
                C6255o c6255o;
                long j2;
                if (j < ((long) (c8170c.f30352a.f20387c - c8170c.f30352a.f20386b))) {
                    c6255o = this.f30352a != null ? this.f30352a.f20391g : null;
                    if (c6255o != null && c6255o.f20389e) {
                        int i;
                        j2 = ((long) c6255o.f20387c) + j;
                        if (c6255o.f20388d) {
                            i = 0;
                        } else {
                            i = c6255o.f20386b;
                        }
                        if (j2 - ((long) i) <= 8192) {
                            c8170c.f30352a.m25875a(c6255o, (int) j);
                            c8170c.f30353b -= j;
                            this.f30353b += j;
                            return;
                        }
                    }
                    c8170c.f30352a = c8170c.f30352a.m25873a((int) j);
                }
                c6255o = c8170c.f30352a;
                j2 = (long) (c6255o.f20387c - c6255o.f20386b);
                c8170c.f30352a = c6255o.m25872a();
                if (this.f30352a == null) {
                    this.f30352a = c6255o;
                    c6255o = this.f30352a;
                    C6255o c6255o2 = this.f30352a;
                    C6255o c6255o3 = this.f30352a;
                    c6255o2.f20391g = c6255o3;
                    c6255o.f20390f = c6255o3;
                } else {
                    this.f30352a.f20391g.m25874a(c6255o).m25876b();
                }
                c8170c.f30353b -= j2;
                this.f30353b += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long read(C8170c c8170c, long j) {
        if (c8170c == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f30353b == 0) {
            return -1;
        } else {
            if (j > this.f30353b) {
                j = this.f30353b;
            }
            c8170c.mo5257a(this, j);
            return j;
        }
    }

    /* renamed from: a */
    public long mo6366a(byte b) {
        return m39584a(b, 0, (long) Clock.MAX_TIME);
    }

    /* renamed from: a */
    public long m39584a(byte b, long j, long j2) {
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f30353b), Long.valueOf(j), Long.valueOf(j2)}));
        }
        if (j2 > this.f30353b) {
            j2 = this.f30353b;
        }
        if (j == j2) {
            return -1;
        }
        C6255o c6255o = this.f30352a;
        if (c6255o == null) {
            return -1;
        }
        if (this.f30353b - j >= j) {
            while (true) {
                long j4 = ((long) (c6255o.f20387c - c6255o.f20386b)) + j3;
                if (j4 >= j) {
                    break;
                }
                c6255o = c6255o.f20390f;
                j3 = j4;
            }
        } else {
            j3 = this.f30353b;
            while (j3 > j) {
                c6255o = c6255o.f20391g;
                j3 -= (long) (c6255o.f20387c - c6255o.f20386b);
            }
        }
        while (j3 < j2) {
            byte[] bArr = c6255o.f20385a;
            int min = (int) Math.min((long) c6255o.f20387c, (((long) c6255o.f20386b) + j2) - j3);
            for (j = (int) ((((long) c6255o.f20386b) + j) - j3); j < min; j++) {
                if (bArr[j] == b) {
                    return ((long) (j - c6255o.f20386b)) + j3;
                }
            }
            j = ((long) (c6255o.f20387c - c6255o.f20386b)) + j3;
            c6255o = c6255o.f20390f;
            j3 = j;
        }
        return -1;
    }

    /* renamed from: b */
    public long m39602b(C6251f c6251f) {
        return m39585a(c6251f, 0);
    }

    /* renamed from: a */
    public long m39585a(C6251f c6251f, long j) {
        C8170c c8170c = this;
        if (c6251f.mo5366h() != 0) {
            long j2 = 0;
            if (j >= 0) {
                C6255o c6255o = c8170c.f30352a;
                long j3 = -1;
                if (c6255o == null) {
                    return -1;
                }
                if (c8170c.f30353b - j >= j) {
                    while (true) {
                        long j4 = ((long) (c6255o.f20387c - c6255o.f20386b)) + j2;
                        if (j4 >= j) {
                            break;
                        }
                        c6255o = c6255o.f20390f;
                        j2 = j4;
                    }
                } else {
                    j2 = c8170c.f30353b;
                    while (j2 > j) {
                        c6255o = c6255o.f20391g;
                        j2 -= (long) (c6255o.f20387c - c6255o.f20386b);
                    }
                }
                byte a = c6251f.mo5353a(0);
                int h = c6251f.mo5366h();
                long j5 = (c8170c.f30353b - ((long) h)) + 1;
                long j6 = j;
                long j7 = j2;
                C6255o c6255o2 = c6255o;
                while (j7 < j5) {
                    C6255o c6255o3;
                    byte[] bArr = c6255o2.f20385a;
                    int min = (int) Math.min((long) c6255o2.f20387c, (((long) c6255o2.f20386b) + j5) - j7);
                    int i = (int) ((((long) c6255o2.f20386b) + j6) - j7);
                    while (i < min) {
                        byte[] bArr2;
                        if (bArr[i] == a) {
                            bArr2 = bArr;
                            c6255o3 = c6255o2;
                            if (m39579a(c6255o2, i + 1, c6251f, 1, h)) {
                                return ((long) (i - c6255o3.f20386b)) + j7;
                            }
                        } else {
                            bArr2 = bArr;
                            c6255o3 = c6255o2;
                        }
                        i++;
                        c6255o2 = c6255o3;
                        bArr = bArr2;
                        c8170c = this;
                    }
                    c6255o3 = c6255o2;
                    j6 = ((long) (c6255o3.f20387c - c6255o3.f20386b)) + j7;
                    c6255o2 = c6255o3.f20390f;
                    j7 = j6;
                    c8170c = this;
                    j3 = -1;
                }
                return j3;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    /* renamed from: a */
    public boolean mo6371a(long j, C6251f c6251f) {
        return m39600a(j, c6251f, 0, c6251f.mo5366h());
    }

    /* renamed from: a */
    public boolean m39600a(long j, C6251f c6251f, int i, int i2) {
        if (j >= 0 && i >= 0 && i2 >= 0 && this.f30353b - j >= ((long) i2)) {
            if (c6251f.mo5366h() - i >= i2) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (m39601b(((long) i3) + j) != c6251f.mo5353a(i + i3)) {
                        return false;
                    }
                }
                return 1;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m39579a(C6255o c6255o, int i, C6251f c6251f, int i2, int i3) {
        int i4 = c6255o.f20387c;
        byte[] bArr = c6255o.f20385a;
        while (i2 < i3) {
            if (i == i4) {
                c6255o = c6255o.f20390f;
                i = c6255o.f20385a;
                i4 = c6255o.f20386b;
                bArr = i;
                i = i4;
                i4 = c6255o.f20387c;
            }
            if (bArr[i] != c6251f.mo5353a(i2)) {
                return null;
            }
            i++;
            i2++;
        }
        return true;
    }

    public C6259t timeout() {
        return C6259t.f20394c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8170c)) {
            return false;
        }
        C8170c c8170c = (C8170c) obj;
        if (this.f30353b != c8170c.f30353b) {
            return false;
        }
        long j = 0;
        if (this.f30353b == 0) {
            return true;
        }
        C6255o c6255o = this.f30352a;
        obj = c8170c.f30352a;
        int i = c6255o.f20386b;
        int i2 = obj.f20386b;
        while (j < this.f30353b) {
            long min = (long) Math.min(c6255o.f20387c - i, obj.f20387c - i2);
            int i3 = i2;
            i2 = i;
            i = 0;
            while (((long) i) < min) {
                int i4 = i2 + 1;
                int i5 = i3 + 1;
                if (c6255o.f20385a[i2] != obj.f20385a[i3]) {
                    return false;
                }
                i++;
                i2 = i4;
                i3 = i5;
            }
            if (i2 == c6255o.f20387c) {
                c6255o = c6255o.f20390f;
                i = c6255o.f20386b;
            } else {
                i = i2;
            }
            if (i3 == obj.f20387c) {
                obj = obj.f20390f;
                i2 = obj.f20386b;
            } else {
                i2 = i3;
            }
            j += min;
        }
        return true;
    }

    public int hashCode() {
        C6255o c6255o = this.f30352a;
        if (c6255o == null) {
            return 0;
        }
        int i = 1;
        do {
            for (int i2 = c6255o.f20386b; i2 < c6255o.f20387c; i2++) {
                i = (i * 31) + c6255o.f20385a[i2];
            }
            c6255o = c6255o.f20390f;
        } while (c6255o != this.f30352a);
        return i;
    }

    public String toString() {
        return m39652w().toString();
    }

    /* renamed from: v */
    public C8170c m39651v() {
        C8170c c8170c = new C8170c();
        if (this.f30353b == 0) {
            return c8170c;
        }
        c8170c.f30352a = new C6255o(this.f30352a);
        C6255o c6255o = c8170c.f30352a;
        C6255o c6255o2 = c8170c.f30352a;
        C6255o c6255o3 = c8170c.f30352a;
        c6255o2.f20391g = c6255o3;
        c6255o.f20390f = c6255o3;
        c6255o = this.f30352a;
        while (true) {
            c6255o = c6255o.f20390f;
            if (c6255o != this.f30352a) {
                c8170c.f30352a.f20391g.m25874a(new C6255o(c6255o));
            } else {
                c8170c.f30353b = this.f30353b;
                return c8170c;
            }
        }
    }

    /* renamed from: w */
    public C6251f m39652w() {
        if (this.f30353b <= 2147483647L) {
            return m39622f((int) this.f30353b);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size > Integer.MAX_VALUE: ");
        stringBuilder.append(this.f30353b);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: f */
    public C6251f m39622f(int i) {
        if (i == 0) {
            return C6251f.f20378b;
        }
        return new C7506q(this, i);
    }
}
