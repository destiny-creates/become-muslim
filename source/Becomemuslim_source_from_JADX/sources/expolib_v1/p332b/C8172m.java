package expolib_v1.p332b;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: RealBufferedSink */
/* renamed from: expolib_v1.b.m */
final class C8172m implements C7496d {
    /* renamed from: a */
    public final C8170c f30355a = new C8170c();
    /* renamed from: b */
    public final C6257r f30356b;
    /* renamed from: c */
    boolean f30357c;

    /* compiled from: RealBufferedSink */
    /* renamed from: expolib_v1.b.m$1 */
    class C62531 extends OutputStream {
        /* renamed from: a */
        final /* synthetic */ C8172m f20383a;

        C62531(C8172m c8172m) {
            this.f20383a = c8172m;
        }

        public void write(int i) {
            if (this.f20383a.f30357c) {
                throw new IOException("closed");
            }
            this.f20383a.f30355a.m39604b((byte) i);
            this.f20383a.mo6403x();
        }

        public void write(byte[] bArr, int i, int i2) {
            if (this.f20383a.f30357c) {
                throw new IOException("closed");
            }
            this.f20383a.f30355a.m39605b(bArr, i, i2);
            this.f20383a.mo6403x();
        }

        public void flush() {
            if (!this.f20383a.f30357c) {
                this.f20383a.flush();
            }
        }

        public void close() {
            this.f20383a.close();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f20383a);
            stringBuilder.append(".outputStream()");
            return stringBuilder.toString();
        }
    }

    C8172m(C6257r c6257r) {
        if (c6257r != null) {
            this.f30356b = c6257r;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    /* renamed from: b */
    public C8170c mo6372b() {
        return this.f30355a;
    }

    /* renamed from: a */
    public void mo5257a(C8170c c8170c, long j) {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        this.f30355a.mo5257a(c8170c, j);
        mo6403x();
    }

    /* renamed from: c */
    public C7496d mo6376c(C6251f c6251f) {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        this.f30355a.m39590a(c6251f);
        return mo6403x();
    }

    /* renamed from: b */
    public C7496d mo6373b(String str) {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        this.f30355a.m39591a(str);
        return mo6403x();
    }

    /* renamed from: d */
    public C7496d mo6380d(byte[] bArr) {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        this.f30355a.m39610c(bArr);
        return mo6403x();
    }

    /* renamed from: c */
    public C7496d mo6377c(byte[] bArr, int i, int i2) {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        this.f30355a.m39605b(bArr, i, i2);
        return mo6403x();
    }

    /* renamed from: a */
    public long mo6368a(C6258s c6258s) {
        if (c6258s != null) {
            long j = 0;
            while (true) {
                long read = c6258s.read(this.f30355a, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
                mo6403x();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: i */
    public C7496d mo6389i(int i) {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        this.f30355a.m39604b(i);
        return mo6403x();
    }

    /* renamed from: h */
    public C7496d mo6386h(int i) {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        this.f30355a.m39609c(i);
        return mo6403x();
    }

    /* renamed from: g */
    public C7496d mo6383g(int i) {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        this.f30355a.m39616d(i);
        return mo6403x();
    }

    /* renamed from: n */
    public C7496d mo6397n(long j) {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        this.f30355a.m39632i(j);
        return mo6403x();
    }

    /* renamed from: m */
    public C7496d mo6394m(long j) {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        this.f30355a.m39634j(j);
        return mo6403x();
    }

    /* renamed from: l */
    public C7496d mo6393l(long j) {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        this.f30355a.m39637k(j);
        return mo6403x();
    }

    /* renamed from: x */
    public C7496d mo6403x() {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        long h = this.f30355a.m39628h();
        if (h > 0) {
            this.f30356b.mo5257a(this.f30355a, h);
        }
        return this;
    }

    /* renamed from: e */
    public C7496d mo6381e() {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        long a = this.f30355a.m39582a();
        if (a > 0) {
            this.f30356b.mo5257a(this.f30355a, a);
        }
        return this;
    }

    /* renamed from: c */
    public OutputStream mo6379c() {
        return new C62531(this);
    }

    public void flush() {
        if (this.f30357c) {
            throw new IllegalStateException("closed");
        }
        if (this.f30355a.f30353b > 0) {
            this.f30356b.mo5257a(this.f30355a, this.f30355a.f30353b);
        }
        this.f30356b.flush();
    }

    public void close() {
        if (!this.f30357c) {
            Throwable th = null;
            try {
                if (this.f30355a.f30353b > 0) {
                    this.f30356b.mo5257a(this.f30355a, this.f30355a.f30353b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f30356b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f30357c = true;
            if (th != null) {
                C6260u.m25888a(th);
            }
        }
    }

    public C6259t timeout() {
        return this.f30356b.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(this.f30356b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
