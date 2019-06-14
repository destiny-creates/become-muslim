package expolib_v1.p332b;

import com.facebook.common.time.Clock;
import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: RealBufferedSource */
/* renamed from: expolib_v1.b.n */
final class C8173n implements C7497e {
    /* renamed from: a */
    public final C8170c f30358a = new C8170c();
    /* renamed from: b */
    public final C6258s f30359b;
    /* renamed from: c */
    boolean f30360c;

    /* compiled from: RealBufferedSource */
    /* renamed from: expolib_v1.b.n$1 */
    class C62541 extends InputStream {
        /* renamed from: a */
        final /* synthetic */ C8173n f20384a;

        C62541(C8173n c8173n) {
            this.f20384a = c8173n;
        }

        public int read() {
            if (this.f20384a.f30360c) {
                throw new IOException("closed");
            } else if (this.f20384a.f30358a.f30353b == 0 && this.f20384a.f30359b.read(this.f20384a.f30358a, 8192) == -1) {
                return -1;
            } else {
                return this.f20384a.f30358a.mo6388i() & JfifUtil.MARKER_FIRST_BYTE;
            }
        }

        public int read(byte[] bArr, int i, int i2) {
            if (this.f20384a.f30360c) {
                throw new IOException("closed");
            }
            C6260u.m25887a((long) bArr.length, (long) i, (long) i2);
            if (this.f20384a.f30358a.f30353b == 0 && this.f20384a.f30359b.read(this.f20384a.f30358a, 8192) == -1) {
                return -1;
            }
            return this.f20384a.f30358a.mo6365a(bArr, i, i2);
        }

        public int available() {
            if (!this.f20384a.f30360c) {
                return (int) Math.min(this.f20384a.f30358a.f30353b, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() {
            this.f20384a.close();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f20384a);
            stringBuilder.append(".inputStream()");
            return stringBuilder.toString();
        }
    }

    C8173n(C6258s c6258s) {
        if (c6258s != null) {
            this.f30359b = c6258s;
            return;
        }
        throw new NullPointerException("source == null");
    }

    /* renamed from: b */
    public C8170c mo6372b() {
        return this.f30358a;
    }

    public long read(C8170c c8170c, long j) {
        if (c8170c == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f30360c) {
            throw new IllegalStateException("closed");
        } else if (this.f30358a.f30353b == 0 && this.f30359b.read(this.f30358a, 8192) == -1) {
            return -1;
        } else {
            return this.f30358a.read(c8170c, Math.min(j, this.f30358a.f30353b));
        }
    }

    /* renamed from: f */
    public boolean mo6382f() {
        if (!this.f30360c) {
            return this.f30358a.mo6382f() && this.f30359b.read(this.f30358a, 8192) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: a */
    public void mo6370a(long j) {
        if (m39683b(j) == null) {
            throw new EOFException();
        }
    }

    /* renamed from: b */
    public boolean m39683b(long j) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f30360c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f30358a.f30353b < j) {
                if (this.f30359b.read(this.f30358a, 8192) == -1) {
                    return 0;
                }
            }
            return 1;
        }
    }

    /* renamed from: i */
    public byte mo6388i() {
        mo6370a(1);
        return this.f30358a.mo6388i();
    }

    /* renamed from: c */
    public C6251f mo6378c(long j) {
        mo6370a(j);
        return this.f30358a.mo6378c(j);
    }

    /* renamed from: t */
    public byte[] mo6402t() {
        this.f30358a.mo6368a(this.f30359b);
        return this.f30358a.mo6402t();
    }

    /* renamed from: g */
    public byte[] mo6385g(long j) {
        mo6370a(j);
        return this.f30358a.mo6385g(j);
    }

    /* renamed from: b */
    public void mo6375b(byte[] bArr) {
        try {
            mo6370a((long) bArr.length);
            this.f30358a.mo6375b(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f30358a.f30353b > 0) {
                int a = this.f30358a.mo6365a(bArr, i, (int) this.f30358a.f30353b);
                if (a != -1) {
                    i += a;
                } else {
                    throw new AssertionError();
                }
            }
            throw e;
        }
    }

    /* renamed from: a */
    public int mo6365a(byte[] bArr, int i, int i2) {
        long j = (long) i2;
        C6260u.m25887a((long) bArr.length, (long) i, j);
        if (this.f30358a.f30353b == 0 && this.f30359b.read(this.f30358a, 8192) == -1) {
            return -1;
        }
        return this.f30358a.mo6365a(bArr, i, (int) Math.min(j, this.f30358a.f30353b));
    }

    /* renamed from: b */
    public void mo6374b(C8170c c8170c, long j) {
        try {
            mo6370a(j);
            this.f30358a.mo6374b(c8170c, j);
        } catch (long j2) {
            c8170c.mo6368a(this.f30358a);
            throw j2;
        }
    }

    /* renamed from: a */
    public long mo6367a(C6257r c6257r) {
        if (c6257r != null) {
            long j = 0;
            while (this.f30359b.read(this.f30358a, 8192) != -1) {
                long h = this.f30358a.m39628h();
                if (h > 0) {
                    j += h;
                    c6257r.mo5257a(this.f30358a, h);
                }
            }
            if (this.f30358a.m39582a() <= 0) {
                return j;
            }
            j += this.f30358a.m39582a();
            c6257r.mo5257a(this.f30358a, this.f30358a.m39582a());
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    /* renamed from: r */
    public String mo6400r() {
        this.f30358a.mo6368a(this.f30359b);
        return this.f30358a.mo6400r();
    }

    /* renamed from: a */
    public String mo6369a(Charset charset) {
        if (charset != null) {
            this.f30358a.mo6368a(this.f30359b);
            return this.f30358a.mo6369a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* renamed from: s */
    public String mo6401s() {
        return m39685d(Clock.MAX_TIME);
    }

    /* renamed from: d */
    public String m39685d(long j) {
        if (j >= 0) {
            long j2 = j == Clock.MAX_TIME ? Clock.MAX_TIME : j + 1;
            long a = m39674a((byte) 10, 0, j2);
            if (a != -1) {
                return this.f30358a.m39623f(a);
            }
            if (j2 < Clock.MAX_TIME && m39683b(j2) && this.f30358a.m39601b(j2 - 1) == (byte) 13 && m39683b(1 + j2) && this.f30358a.m39601b(j2) == (byte) 10) {
                return this.f30358a.m39623f(j2);
            }
            C8170c c8170c = new C8170c();
            this.f30358a.m39589a(c8170c, 0, Math.min(32, this.f30358a.m39582a()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\\n not found: limit=");
            stringBuilder.append(Math.min(this.f30358a.m39582a(), j));
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

    /* renamed from: j */
    public short mo6390j() {
        mo6370a(2);
        return this.f30358a.mo6390j();
    }

    /* renamed from: m */
    public short mo6395m() {
        mo6370a(2);
        return this.f30358a.mo6395m();
    }

    /* renamed from: k */
    public int mo6391k() {
        mo6370a(4);
        return this.f30358a.mo6391k();
    }

    /* renamed from: n */
    public int mo6396n() {
        mo6370a(4);
        return this.f30358a.mo6396n();
    }

    /* renamed from: l */
    public long mo6392l() {
        mo6370a(8);
        return this.f30358a.mo6392l();
    }

    /* renamed from: o */
    public long mo6398o() {
        mo6370a(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!m39683b((long) i2)) {
                break;
            }
            byte b = this.f30358a.m39601b((long) i);
            if (b < (byte) 48 || b > (byte) 57) {
                if (i != 0) {
                    break;
                } else if (b != Framer.STDIN_FRAME_PREFIX) {
                    break;
                }
            }
            i = i2;
        }
        if (i != 0) {
            return this.f30358a.mo6398o();
        }
        throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(b)}));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: p */
    public long mo6399p() {
        /*
        r6 = this;
        r0 = 1;
        r6.mo6370a(r0);
        r0 = 0;
        r1 = 0;
    L_0x0007:
        r2 = r1 + 1;
        r3 = (long) r2;
        r3 = r6.m39683b(r3);
        if (r3 == 0) goto L_0x004a;
    L_0x0010:
        r3 = r6.f30358a;
        r4 = (long) r1;
        r3 = r3.m39601b(r4);
        r4 = 48;
        if (r3 < r4) goto L_0x001f;
    L_0x001b:
        r4 = 57;
        if (r3 <= r4) goto L_0x0030;
    L_0x001f:
        r4 = 97;
        if (r3 < r4) goto L_0x0027;
    L_0x0023:
        r4 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r3 <= r4) goto L_0x0030;
    L_0x0027:
        r4 = 65;
        if (r3 < r4) goto L_0x0032;
    L_0x002b:
        r4 = 70;
        if (r3 <= r4) goto L_0x0030;
    L_0x002f:
        goto L_0x0032;
    L_0x0030:
        r1 = r2;
        goto L_0x0007;
    L_0x0032:
        if (r1 == 0) goto L_0x0035;
    L_0x0034:
        goto L_0x004a;
    L_0x0035:
        r1 = new java.lang.NumberFormatException;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = java.lang.Byte.valueOf(r3);
        r2[r0] = r3;
        r0 = "Expected leading [0-9a-fA-F] character but was %#x";
        r0 = java.lang.String.format(r0, r2);
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r6.f30358a;
        r0 = r0.mo6399p();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.b.n.p():long");
    }

    /* renamed from: h */
    public void mo6387h(long j) {
        if (this.f30360c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f30358a.f30353b == 0) {
                if (this.f30359b.read(this.f30358a, 8192) == -1) {
                    throw new EOFException();
                }
            }
            long min = Math.min(j, this.f30358a.m39582a());
            this.f30358a.mo6387h(min);
            j -= min;
        }
    }

    /* renamed from: a */
    public long mo6366a(byte b) {
        return m39674a(b, 0, (long) Clock.MAX_TIME);
    }

    /* renamed from: a */
    public long m39674a(byte b, long j, long j2) {
        if (this.f30360c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long a = this.f30358a.m39584a(b, j, j2);
                if (a != -1) {
                    return a;
                }
                a = this.f30358a.f30353b;
                if (a < j2) {
                    if (this.f30359b.read(this.f30358a, 8192) != -1) {
                        j = Math.max(j, a);
                    }
                }
                return -1;
            }
            return -1;
        }
    }

    /* renamed from: a */
    public boolean mo6371a(long j, C6251f c6251f) {
        return m39679a(j, c6251f, 0, c6251f.mo5366h());
    }

    /* renamed from: a */
    public boolean m39679a(long j, C6251f c6251f, int i, int i2) {
        if (this.f30360c) {
            throw new IllegalStateException("closed");
        }
        if (j >= 0 && i >= 0 && i2 >= 0) {
            if (c6251f.mo5366h() - i >= i2) {
                int i3 = 0;
                while (i3 < i2) {
                    long j2 = ((long) i3) + j;
                    if (!m39683b(1 + j2) || this.f30358a.m39601b(j2) != c6251f.mo5353a(i + i3)) {
                        return false;
                    }
                    i3++;
                }
                return 1;
            }
        }
        return false;
    }

    /* renamed from: g */
    public InputStream mo6384g() {
        return new C62541(this);
    }

    public void close() {
        if (!this.f30360c) {
            this.f30360c = true;
            this.f30359b.close();
            this.f30358a.m39650u();
        }
    }

    public C6259t timeout() {
        return this.f30359b.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(this.f30359b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
