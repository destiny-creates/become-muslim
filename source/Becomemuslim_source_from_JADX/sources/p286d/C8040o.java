package p286d;

import com.facebook.common.time.Clock;
import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: RealBufferedSource */
/* renamed from: d.o */
final class C8040o implements C7204e {
    /* renamed from: a */
    public final C8037c f29844a = new C8037c();
    /* renamed from: b */
    public final C5876t f29845b;
    /* renamed from: c */
    boolean f29846c;

    /* compiled from: RealBufferedSource */
    /* renamed from: d.o$1 */
    class C58721 extends InputStream {
        /* renamed from: a */
        final /* synthetic */ C8040o f19538a;

        C58721(C8040o c8040o) {
            this.f19538a = c8040o;
        }

        public int read() {
            if (this.f19538a.f29846c) {
                throw new IOException("closed");
            } else if (this.f19538a.f29844a.f29839b == 0 && this.f19538a.f29845b.read(this.f19538a.f29844a, 8192) == -1) {
                return -1;
            } else {
                return this.f19538a.f29844a.mo6304h() & JfifUtil.MARKER_FIRST_BYTE;
            }
        }

        public int read(byte[] bArr, int i, int i2) {
            if (this.f19538a.f29846c) {
                throw new IOException("closed");
            }
            C5878v.m24746a((long) bArr.length, (long) i, (long) i2);
            if (this.f19538a.f29844a.f29839b == 0 && this.f19538a.f29845b.read(this.f19538a.f29844a, 8192) == -1) {
                return -1;
            }
            return this.f19538a.f29844a.m38960a(bArr, i, i2);
        }

        public int available() {
            if (!this.f19538a.f29846c) {
                return (int) Math.min(this.f19538a.f29844a.f29839b, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() {
            this.f19538a.close();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f19538a);
            stringBuilder.append(".inputStream()");
            return stringBuilder.toString();
        }
    }

    C8040o(C5876t c5876t) {
        if (c5876t != null) {
            this.f29845b = c5876t;
            return;
        }
        throw new NullPointerException("source == null");
    }

    /* renamed from: b */
    public C8037c mo6292b() {
        return this.f29844a;
    }

    public long read(C8037c c8037c, long j) {
        if (c8037c == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f29846c) {
            throw new IllegalStateException("closed");
        } else if (this.f29844a.f29839b == 0 && this.f29845b.read(this.f29844a, 8192) == -1) {
            return -1;
        } else {
            return this.f29844a.read(c8037c, Math.min(j, this.f29844a.f29839b));
        }
    }

    /* renamed from: e */
    public boolean mo6300e() {
        if (!this.f29846c) {
            return this.f29844a.mo6300e() && this.f29845b.read(this.f29844a, 8192) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: a */
    public void mo6288a(long j) {
        if (mo6295b(j) == null) {
            throw new EOFException();
        }
    }

    /* renamed from: b */
    public boolean mo6295b(long j) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f29846c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f29844a.f29839b < j) {
                if (this.f29845b.read(this.f29844a, 8192) == -1) {
                    return 0;
                }
            }
            return 1;
        }
    }

    /* renamed from: h */
    public byte mo6304h() {
        mo6288a(1);
        return this.f29844a.mo6304h();
    }

    /* renamed from: d */
    public C5869f mo6299d(long j) {
        mo6288a(j);
        return this.f29844a.mo6299d(j);
    }

    /* renamed from: s */
    public byte[] mo6319s() {
        this.f29844a.mo6286a(this.f29845b);
        return this.f29844a.mo6319s();
    }

    /* renamed from: h */
    public byte[] mo6306h(long j) {
        mo6288a(j);
        return this.f29844a.mo6306h(j);
    }

    /* renamed from: a */
    public void mo6290a(byte[] bArr) {
        try {
            mo6288a((long) bArr.length);
            this.f29844a.mo6290a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f29844a.f29839b > 0) {
                int a = this.f29844a.m38960a(bArr, i, (int) this.f29844a.f29839b);
                if (a != -1) {
                    i += a;
                } else {
                    throw new AssertionError();
                }
            }
            throw e;
        }
    }

    public int read(ByteBuffer byteBuffer) {
        if (this.f29844a.f29839b == 0 && this.f29845b.read(this.f29844a, 8192) == -1) {
            return -1;
        }
        return this.f29844a.read(byteBuffer);
    }

    /* renamed from: a */
    public void mo6289a(C8037c c8037c, long j) {
        try {
            mo6288a(j);
            this.f29844a.mo6289a(c8037c, j);
        } catch (long j2) {
            c8037c.mo6286a(this.f29844a);
            throw j2;
        }
    }

    /* renamed from: a */
    public String mo6287a(Charset charset) {
        if (charset != null) {
            this.f29844a.mo6286a(this.f29845b);
            return this.f29844a.mo6287a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* renamed from: r */
    public String mo6318r() {
        return mo6302f(Clock.MAX_TIME);
    }

    /* renamed from: f */
    public String mo6302f(long j) {
        if (j >= 0) {
            long j2 = j == Clock.MAX_TIME ? Clock.MAX_TIME : j + 1;
            long a = m39043a((byte) 10, 0, j2);
            if (a != -1) {
                return this.f29844a.m39003g(a);
            }
            if (j2 < Clock.MAX_TIME && mo6295b(j2) && this.f29844a.m38987c(j2 - 1) == (byte) 13 && mo6295b(1 + j2) && this.f29844a.m38987c(j2) == (byte) 10) {
                return this.f29844a.m39003g(j2);
            }
            C8037c c8037c = new C8037c();
            this.f29844a.m38967a(c8037c, 0, Math.min(32, this.f29844a.m38961a()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\\n not found: limit=");
            stringBuilder.append(Math.min(this.f29844a.m38961a(), j));
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

    /* renamed from: i */
    public short mo6308i() {
        mo6288a(2);
        return this.f29844a.mo6308i();
    }

    /* renamed from: l */
    public short mo6312l() {
        mo6288a(2);
        return this.f29844a.mo6312l();
    }

    /* renamed from: j */
    public int mo6310j() {
        mo6288a(4);
        return this.f29844a.mo6310j();
    }

    /* renamed from: m */
    public int mo6313m() {
        mo6288a(4);
        return this.f29844a.mo6313m();
    }

    /* renamed from: k */
    public long mo6311k() {
        mo6288a(8);
        return this.f29844a.mo6311k();
    }

    /* renamed from: n */
    public long mo6315n() {
        mo6288a(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!mo6295b((long) i2)) {
                break;
            }
            byte c = this.f29844a.m38987c((long) i);
            if (c < (byte) 48 || c > (byte) 57) {
                if (i != 0) {
                    break;
                } else if (c != Framer.STDIN_FRAME_PREFIX) {
                    break;
                }
            }
            i = i2;
        }
        if (i != 0) {
            return this.f29844a.mo6315n();
        }
        throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(c)}));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: o */
    public long mo6317o() {
        /*
        r6 = this;
        r0 = 1;
        r6.mo6288a(r0);
        r0 = 0;
        r1 = 0;
    L_0x0007:
        r2 = r1 + 1;
        r3 = (long) r2;
        r3 = r6.mo6295b(r3);
        if (r3 == 0) goto L_0x004a;
    L_0x0010:
        r3 = r6.f29844a;
        r4 = (long) r1;
        r3 = r3.m38987c(r4);
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
        r0 = r6.f29844a;
        r0 = r0.mo6317o();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: d.o.o():long");
    }

    /* renamed from: i */
    public void mo6309i(long j) {
        if (this.f29846c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f29844a.f29839b == 0) {
                if (this.f29845b.read(this.f29844a, 8192) == -1) {
                    throw new EOFException();
                }
            }
            long min = Math.min(j, this.f29844a.m38961a());
            this.f29844a.mo6309i(min);
            j -= min;
        }
    }

    /* renamed from: a */
    public long mo6285a(byte b) {
        return m39043a(b, 0, Clock.MAX_TIME);
    }

    /* renamed from: a */
    public long m39043a(byte b, long j, long j2) {
        if (this.f29846c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long a = this.f29844a.m38963a(b, j, j2);
                if (a != -1) {
                    return a;
                }
                a = this.f29844a.f29839b;
                if (a < j2) {
                    if (this.f29845b.read(this.f29844a, 8192) != -1) {
                        j = Math.max(j, a);
                    }
                }
                return -1;
            }
            return -1;
        }
    }

    /* renamed from: a */
    public boolean mo6291a(long j, C5869f c5869f) {
        return m39049a(j, c5869f, 0, c5869f.mo5110h());
    }

    /* renamed from: a */
    public boolean m39049a(long j, C5869f c5869f, int i, int i2) {
        if (this.f29846c) {
            throw new IllegalStateException("closed");
        }
        if (j >= 0 && i >= 0 && i2 >= 0) {
            if (c5869f.mo5110h() - i >= i2) {
                int i3 = 0;
                while (i3 < i2) {
                    long j2 = ((long) i3) + j;
                    if (!mo6295b(1 + j2) || this.f29844a.m38987c(j2) != c5869f.mo5097a(i + i3)) {
                        return false;
                    }
                    i3++;
                }
                return 1;
            }
        }
        return false;
    }

    /* renamed from: f */
    public InputStream mo6301f() {
        return new C58721(this);
    }

    public boolean isOpen() {
        return this.f29846c ^ 1;
    }

    public void close() {
        if (!this.f29846c) {
            this.f29846c = true;
            this.f29845b.close();
            this.f29844a.m39025t();
        }
    }

    public C5877u timeout() {
        return this.f29845b.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(this.f29845b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
