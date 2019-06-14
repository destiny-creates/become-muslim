package expolib_v1.p321a.p322a.p326d;

import expolib_v1.p321a.C6234q;
import expolib_v1.p321a.C6234q.C6233a;
import expolib_v1.p321a.C6237r;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ab.C6208a;
import expolib_v1.p321a.ac;
import expolib_v1.p321a.p322a.C6148a;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p324b.C6154g;
import expolib_v1.p321a.p322a.p324b.C7439c;
import expolib_v1.p321a.p322a.p325c.C6157c;
import expolib_v1.p321a.p322a.p325c.C6160e;
import expolib_v1.p321a.p322a.p325c.C6162i;
import expolib_v1.p321a.p322a.p325c.C6163k;
import expolib_v1.p321a.p322a.p325c.C7443h;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6257r;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C6259t;
import expolib_v1.p332b.C7496d;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C7500i;
import expolib_v1.p332b.C8170c;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* compiled from: Http1Codec */
/* renamed from: expolib_v1.a.a.d.a */
public final class C7448a implements C6157c {
    /* renamed from: a */
    final C7490w f25838a;
    /* renamed from: b */
    final C6154g f25839b;
    /* renamed from: c */
    final C7497e f25840c;
    /* renamed from: d */
    final C7496d f25841d;
    /* renamed from: e */
    int f25842e = 0;

    /* compiled from: Http1Codec */
    /* renamed from: expolib_v1.a.a.d.a$a */
    private abstract class C7445a implements C6258s {
        /* renamed from: a */
        protected final C7500i f25828a;
        /* renamed from: b */
        protected boolean f25829b;
        /* renamed from: c */
        final /* synthetic */ C7448a f25830c;

        private C7445a(C7448a c7448a) {
            this.f25830c = c7448a;
            this.f25828a = new C7500i(this.f25830c.f25840c.timeout());
        }

        public C6259t timeout() {
            return this.f25828a;
        }

        /* renamed from: a */
        protected final void m33832a(boolean z) {
            if (this.f25830c.f25842e != 6) {
                if (this.f25830c.f25842e == 5) {
                    this.f25830c.m33844a(this.f25828a);
                    this.f25830c.f25842e = 6;
                    if (this.f25830c.f25839b != null) {
                        this.f25830c.f25839b.m25260a(z ^ 1, this.f25830c);
                    }
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("state: ");
                stringBuilder.append(this.f25830c.f25842e);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: expolib_v1.a.a.d.a$b */
    private final class C7446b implements C6257r {
        /* renamed from: a */
        final /* synthetic */ C7448a f25831a;
        /* renamed from: b */
        private final C7500i f25832b = new C7500i(this.f25831a.f25841d.timeout());
        /* renamed from: c */
        private boolean f25833c;

        C7446b(C7448a c7448a) {
            this.f25831a = c7448a;
        }

        public C6259t timeout() {
            return this.f25832b;
        }

        /* renamed from: a */
        public void mo5257a(C8170c c8170c, long j) {
            if (this.f25833c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                this.f25831a.f25841d.mo6393l(j);
                this.f25831a.f25841d.mo6373b("\r\n");
                this.f25831a.f25841d.mo5257a(c8170c, j);
                this.f25831a.f25841d.mo6373b("\r\n");
            }
        }

        public synchronized void flush() {
            if (!this.f25833c) {
                this.f25831a.f25841d.flush();
            }
        }

        public synchronized void close() {
            if (!this.f25833c) {
                this.f25833c = true;
                this.f25831a.f25841d.mo6373b("0\r\n\r\n");
                this.f25831a.m33844a(this.f25832b);
                this.f25831a.f25842e = 3;
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: expolib_v1.a.a.d.a$d */
    private final class C7447d implements C6257r {
        /* renamed from: a */
        final /* synthetic */ C7448a f25834a;
        /* renamed from: b */
        private final C7500i f25835b = new C7500i(this.f25834a.f25841d.timeout());
        /* renamed from: c */
        private boolean f25836c;
        /* renamed from: d */
        private long f25837d;

        C7447d(C7448a c7448a, long j) {
            this.f25834a = c7448a;
            this.f25837d = j;
        }

        public C6259t timeout() {
            return this.f25835b;
        }

        /* renamed from: a */
        public void mo5257a(C8170c c8170c, long j) {
            if (this.f25836c) {
                throw new IllegalStateException("closed");
            }
            C6165c.m25314a(c8170c.m39582a(), 0, j);
            if (j <= this.f25837d) {
                this.f25834a.f25841d.mo5257a(c8170c, j);
                this.f25837d -= j;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected ");
            stringBuilder.append(this.f25837d);
            stringBuilder.append(" bytes but received ");
            stringBuilder.append(j);
            throw new ProtocolException(stringBuilder.toString());
        }

        public void flush() {
            if (!this.f25836c) {
                this.f25834a.f25841d.flush();
            }
        }

        public void close() {
            if (!this.f25836c) {
                this.f25836c = true;
                if (this.f25837d <= 0) {
                    this.f25834a.m33844a(this.f25835b);
                    this.f25834a.f25842e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: expolib_v1.a.a.d.a$c */
    private class C8163c extends C7445a {
        /* renamed from: d */
        final /* synthetic */ C7448a f30336d;
        /* renamed from: e */
        private final C6237r f30337e;
        /* renamed from: f */
        private long f30338f = -1;
        /* renamed from: g */
        private boolean f30339g = true;

        C8163c(C7448a c7448a, C6237r c6237r) {
            this.f30336d = c7448a;
            super();
            this.f30337e = c6237r;
        }

        public long read(C8170c c8170c, long j) {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (!this.f30339g) {
                return -1;
            } else {
                if (this.f30338f == 0 || this.f30338f == -1) {
                    m39575a();
                    if (!this.f30339g) {
                        return -1;
                    }
                }
                c8170c = this.f30336d.f25840c.read(c8170c, Math.min(j, this.f30338f));
                if (c8170c != -1) {
                    this.f30338f -= c8170c;
                    return c8170c;
                }
                m33832a(null);
                throw new ProtocolException("unexpected end of stream");
            }
        }

        /* renamed from: a */
        private void m39575a() {
            if (this.f30338f != -1) {
                this.f30336d.f25840c.mo6401s();
            }
            try {
                this.f30338f = this.f30336d.f25840c.mo6399p();
                String trim = this.f30336d.f25840c.mo6401s().trim();
                if (this.f30338f < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("expected chunk size and optional extensions but was \"");
                    stringBuilder.append(this.f30338f);
                    stringBuilder.append(trim);
                    stringBuilder.append("\"");
                    throw new ProtocolException(stringBuilder.toString());
                } else if (this.f30338f == 0) {
                    this.f30339g = false;
                    C6160e.m25284a(this.f30336d.f25838a.m33977g(), this.f30337e, this.f30336d.m33848d());
                    m33832a(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() {
            if (!this.b) {
                if (this.f30339g && !C6165c.m25317a((C6258s) this, 100, TimeUnit.MILLISECONDS)) {
                    m33832a(false);
                }
                this.b = true;
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: expolib_v1.a.a.d.a$e */
    private class C8164e extends C7445a {
        /* renamed from: d */
        final /* synthetic */ C7448a f30340d;
        /* renamed from: e */
        private long f30341e;

        public C8164e(C7448a c7448a, long j) {
            this.f30340d = c7448a;
            super();
            this.f30341e = j;
            if (this.f30341e == 0) {
                m33832a(true);
            }
        }

        public long read(C8170c c8170c, long j) {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.f30341e == 0) {
                return -1;
            } else {
                c8170c = this.f30340d.f25840c.read(c8170c, Math.min(this.f30341e, j));
                if (c8170c != -1) {
                    this.f30341e -= c8170c;
                    if (this.f30341e == 0) {
                        m33832a(true);
                    }
                    return c8170c;
                }
                m33832a(null);
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void close() {
            if (!this.b) {
                if (!(this.f30341e == 0 || C6165c.m25317a((C6258s) this, 100, TimeUnit.MILLISECONDS))) {
                    m33832a(false);
                }
                this.b = true;
            }
        }
    }

    /* compiled from: Http1Codec */
    /* renamed from: expolib_v1.a.a.d.a$f */
    private class C8165f extends C7445a {
        /* renamed from: d */
        final /* synthetic */ C7448a f30342d;
        /* renamed from: e */
        private boolean f30343e;

        C8165f(C7448a c7448a) {
            this.f30342d = c7448a;
            super();
        }

        public long read(C8170c c8170c, long j) {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.f30343e) {
                return -1;
            } else {
                c8170c = this.f30342d.f25840c.read(c8170c, j);
                if (c8170c != -1) {
                    return c8170c;
                }
                this.f30343e = true;
                m33832a(true);
                return -1;
            }
        }

        public void close() {
            if (!this.b) {
                if (!this.f30343e) {
                    m33832a(false);
                }
                this.b = true;
            }
        }
    }

    public C7448a(C7490w c7490w, C6154g c6154g, C7497e c7497e, C7496d c7496d) {
        this.f25838a = c7490w;
        this.f25839b = c6154g;
        this.f25840c = c7497e;
        this.f25841d = c7496d;
    }

    /* renamed from: a */
    public C6257r mo5263a(C6246z c6246z, long j) {
        if ("chunked".equalsIgnoreCase(c6246z.m25822a("Transfer-Encoding")) != null) {
            return m33849e();
        }
        if (j != -1) {
            return m33838a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* renamed from: c */
    public void mo5267c() {
        C7439c b = this.f25839b.m25261b();
        if (b != null) {
            b.m33812b();
        }
    }

    /* renamed from: a */
    public void mo5265a(C6246z c6246z) {
        m33842a(c6246z.m25825c(), C6162i.m25299a(c6246z, this.f25839b.m25261b().mo5249a().m25592b().type()));
    }

    /* renamed from: a */
    public ac mo5262a(ab abVar) {
        return new C7443h(abVar.m25584g(), C6252l.m25859a(m33835b(abVar)));
    }

    /* renamed from: b */
    private C6258s m33835b(ab abVar) {
        if (!C6160e.m25291d(abVar)) {
            return m33845b(0);
        }
        if ("chunked".equalsIgnoreCase(abVar.m25577a("Transfer-Encoding"))) {
            return m33840a(abVar.m25576a().m25821a());
        }
        long a = C6160e.m25280a(abVar);
        if (a != -1) {
            return m33845b(a);
        }
        return m33850f();
    }

    /* renamed from: a */
    public void mo5264a() {
        this.f25841d.flush();
    }

    /* renamed from: b */
    public void mo5266b() {
        this.f25841d.flush();
    }

    /* renamed from: a */
    public void m33842a(C6234q c6234q, String str) {
        if (this.f25842e == 0) {
            this.f25841d.mo6373b(str).mo6373b("\r\n");
            int a = c6234q.m25716a();
            for (int i = null; i < a; i++) {
                this.f25841d.mo6373b(c6234q.m25717a(i)).mo6373b(": ").mo6373b(c6234q.m25720b(i)).mo6373b("\r\n");
            }
            this.f25841d.mo6373b("\r\n");
            this.f25842e = 1;
            return;
        }
        str = new StringBuilder();
        str.append("state: ");
        str.append(this.f25842e);
        throw new IllegalStateException(str.toString());
    }

    /* renamed from: a */
    public C6208a mo5261a(boolean z) {
        if (this.f25842e != 1) {
            if (this.f25842e != 3) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("state: ");
                stringBuilder.append(this.f25842e);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        try {
            C6163k a = C6163k.m25301a(this.f25840c.mo6401s());
            C6208a a2 = new C6208a().m25566a(a.f19904a).m25560a(a.f19905b).m25568a(a.f19906c).m25565a(m33848d());
            if (z && a.f19905b) {
                return false;
            }
            this.f25842e = true;
            return a2;
        } catch (boolean z2) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("unexpected end of stream on ");
            stringBuilder2.append(this.f25839b);
            IOException iOException = new IOException(stringBuilder2.toString());
            iOException.initCause(z2);
            throw iOException;
        }
    }

    /* renamed from: d */
    public C6234q m33848d() {
        C6233a c6233a = new C6233a();
        while (true) {
            String s = this.f25840c.mo6401s();
            if (s.length() == 0) {
                return c6233a.m25709a();
            }
            C6148a.f19868a.mo5334a(c6233a, s);
        }
    }

    /* renamed from: e */
    public C6257r m33849e() {
        if (this.f25842e == 1) {
            this.f25842e = 2;
            return new C7446b(this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.f25842e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: a */
    public C6257r m33838a(long j) {
        if (this.f25842e == 1) {
            this.f25842e = 2;
            return new C7447d(this, j);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.f25842e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: b */
    public C6258s m33845b(long j) {
        if (this.f25842e == 4) {
            this.f25842e = 5;
            return new C8164e(this, j);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.f25842e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: a */
    public C6258s m33840a(C6237r c6237r) {
        if (this.f25842e == 4) {
            this.f25842e = 5;
            return new C8163c(this, c6237r);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.f25842e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: f */
    public C6258s m33850f() {
        if (this.f25842e != 4) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("state: ");
            stringBuilder.append(this.f25842e);
            throw new IllegalStateException(stringBuilder.toString());
        } else if (this.f25839b != null) {
            this.f25842e = 5;
            this.f25839b.m25264d();
            return new C8165f(this);
        } else {
            throw new IllegalStateException("streamAllocation == null");
        }
    }

    /* renamed from: a */
    void m33844a(C7500i c7500i) {
        C6259t a = c7500i.m34064a();
        c7500i.m34063a(C6259t.f20394c);
        a.mo5351f();
        a.P_();
    }
}
