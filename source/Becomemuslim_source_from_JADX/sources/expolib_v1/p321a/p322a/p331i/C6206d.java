package expolib_v1.p321a.p322a.p331i;

import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C6257r;
import expolib_v1.p332b.C6259t;
import expolib_v1.p332b.C7496d;
import expolib_v1.p332b.C8170c;
import java.io.IOException;
import java.util.Random;

/* compiled from: WebSocketWriter */
/* renamed from: expolib_v1.a.a.i.d */
final class C6206d {
    /* renamed from: j */
    static final /* synthetic */ boolean f20076j = (C6206d.class.desiredAssertionStatus() ^ 1);
    /* renamed from: a */
    final boolean f20077a;
    /* renamed from: b */
    final Random f20078b;
    /* renamed from: c */
    final C7496d f20079c;
    /* renamed from: d */
    boolean f20080d;
    /* renamed from: e */
    final C8170c f20081e = new C8170c();
    /* renamed from: f */
    final C7476a f20082f = new C7476a(this);
    /* renamed from: g */
    boolean f20083g;
    /* renamed from: h */
    final byte[] f20084h;
    /* renamed from: i */
    final byte[] f20085i;

    /* compiled from: WebSocketWriter */
    /* renamed from: expolib_v1.a.a.i.d$a */
    final class C7476a implements C6257r {
        /* renamed from: a */
        int f25952a;
        /* renamed from: b */
        long f25953b;
        /* renamed from: c */
        boolean f25954c;
        /* renamed from: d */
        boolean f25955d;
        /* renamed from: e */
        final /* synthetic */ C6206d f25956e;

        C7476a(C6206d c6206d) {
            this.f25956e = c6206d;
        }

        /* renamed from: a */
        public void mo5257a(C8170c c8170c, long j) {
            if (this.f25955d) {
                throw new IOException("closed");
            }
            this.f25956e.f20081e.mo5257a(c8170c, j);
            c8170c = (this.f25954c == null || this.f25953b == -1 || this.f25956e.f20081e.m39582a() <= this.f25953b - 8192) ? null : true;
            long h = this.f25956e.f20081e.m39628h();
            if (h > 0 && c8170c == null) {
                synchronized (this.f25956e) {
                    this.f25956e.m25543a(this.f25952a, h, this.f25954c, false);
                }
                this.f25954c = 0;
            }
        }

        public void flush() {
            if (this.f25955d) {
                throw new IOException("closed");
            }
            synchronized (this.f25956e) {
                this.f25956e.m25543a(this.f25952a, this.f25956e.f20081e.m39582a(), this.f25954c, false);
            }
            this.f25954c = false;
        }

        public C6259t timeout() {
            return this.f25956e.f20079c.timeout();
        }

        public void close() {
            if (this.f25955d) {
                throw new IOException("closed");
            }
            synchronized (this.f25956e) {
                this.f25956e.m25543a(this.f25952a, this.f25956e.f20081e.m39582a(), this.f25954c, true);
            }
            this.f25955d = true;
            this.f25956e.f20083g = false;
        }
    }

    C6206d(boolean z, C7496d c7496d, Random random) {
        if (c7496d == null) {
            throw new NullPointerException("sink == null");
        } else if (random != null) {
            this.f20077a = z;
            this.f20079c = c7496d;
            this.f20078b = random;
            c7496d = null;
            this.f20084h = z ? new byte[4] : null;
            if (z) {
                c7496d = new byte[true];
            }
            this.f20085i = c7496d;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    /* renamed from: a */
    void m25545a(C6251f c6251f) {
        synchronized (this) {
            m25541b(9, c6251f);
        }
    }

    /* renamed from: b */
    void m25546b(C6251f c6251f) {
        synchronized (this) {
            m25541b(10, c6251f);
        }
    }

    /* renamed from: a */
    void m25544a(int i, C6251f c6251f) {
        C6251f c6251f2 = C6251f.f20378b;
        if (!(i == 0 && c6251f == null)) {
            if (i != 0) {
                C6203b.m25529b(i);
            }
            C8170c c8170c = new C8170c();
            c8170c.m39609c(i);
            if (c6251f != null) {
                c8170c.m39590a(c6251f);
            }
            c6251f2 = c8170c.m39646q();
        }
        synchronized (this) {
            try {
                m25541b(8, c6251f2);
                this.f20080d = true;
            } catch (Throwable th) {
                this.f20080d = true;
            }
        }
    }

    /* renamed from: b */
    private void m25541b(int i, C6251f c6251f) {
        if (!f20076j) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        if (this.f20080d) {
            throw new IOException("closed");
        }
        int h = c6251f.mo5366h();
        if (((long) h) <= 125) {
            this.f20079c.mo6389i(i | 128);
            if (this.f20077a != 0) {
                this.f20079c.mo6389i(h | 128);
                this.f20078b.nextBytes(this.f20084h);
                this.f20079c.mo6380d(this.f20084h);
                i = c6251f.mo5368i();
                C6203b.m25528a(i, (long) i.length, this.f20084h, 0);
                this.f20079c.mo6380d(i);
            } else {
                this.f20079c.mo6389i(h);
                this.f20079c.mo6376c(c6251f);
            }
            this.f20079c.flush();
            return;
        }
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    }

    /* renamed from: a */
    C6257r m25542a(int i, long j) {
        if (this.f20083g) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.f20083g = true;
        this.f20082f.f25952a = i;
        this.f20082f.f25953b = j;
        this.f20082f.f25954c = true;
        this.f20082f.f25955d = 0;
        return this.f20082f;
    }

    /* renamed from: a */
    void m25543a(int i, long j, boolean z, boolean z2) {
        if (!f20076j) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        if (this.f20080d) {
            throw new IOException("closed");
        }
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= 128;
        }
        this.f20079c.mo6389i(i);
        i = this.f20077a != 0 ? 128 : 0;
        if (j <= true) {
            this.f20079c.mo6389i(i | ((int) j));
        } else if (j <= true) {
            this.f20079c.mo6389i(i | 126);
            this.f20079c.mo6386h((int) j);
        } else {
            this.f20079c.mo6389i(i | 127);
            this.f20079c.mo6397n(j);
        }
        if (this.f20077a != 0) {
            this.f20078b.nextBytes(this.f20084h);
            this.f20079c.mo6380d(this.f20084h);
            z = 0;
            while (z < j) {
                i = this.f20081e.mo6365a(this.f20085i, 0, (int) Math.min(j, (long) this.f20085i.length));
                if (i != -1) {
                    long j2 = (long) i;
                    C6203b.m25528a(this.f20085i, j2, this.f20084h, z);
                    this.f20079c.mo6377c(this.f20085i, 0, i);
                    z += j2;
                } else {
                    throw new AssertionError();
                }
            }
        }
        this.f20079c.mo5257a(this.f20081e, j);
        this.f20079c.mo6381e();
    }
}
