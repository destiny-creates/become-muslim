package com.google.android.exoplayer2.p137e.p141e;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2327l;
import com.google.android.exoplayer2.p137e.C2327l.C4154a;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p164l.C2529l;

/* compiled from: StreamReader */
/* renamed from: com.google.android.exoplayer2.e.e.h */
abstract class C2295h {
    /* renamed from: a */
    private final C2290d f5633a = new C2290d();
    /* renamed from: b */
    private C2329m f5634b;
    /* renamed from: c */
    private C2320g f5635c;
    /* renamed from: d */
    private C2292f f5636d;
    /* renamed from: e */
    private long f5637e;
    /* renamed from: f */
    private long f5638f;
    /* renamed from: g */
    private long f5639g;
    /* renamed from: h */
    private int f5640h;
    /* renamed from: i */
    private int f5641i;
    /* renamed from: j */
    private C2294a f5642j;
    /* renamed from: k */
    private long f5643k;
    /* renamed from: l */
    private boolean f5644l;
    /* renamed from: m */
    private boolean f5645m;

    /* compiled from: StreamReader */
    /* renamed from: com.google.android.exoplayer2.e.e.h$a */
    static class C2294a {
        /* renamed from: a */
        C2515k f5631a;
        /* renamed from: b */
        C2292f f5632b;

        C2294a() {
        }
    }

    /* compiled from: StreamReader */
    /* renamed from: com.google.android.exoplayer2.e.e.h$b */
    private static final class C4123b implements C2292f {
        /* renamed from: a */
        public long mo2201a(long j) {
            return 0;
        }

        /* renamed from: a */
        public long mo2202a(C2304f c2304f) {
            return -1;
        }

        private C4123b() {
        }

        /* renamed from: c */
        public C2327l mo2203c() {
            return new C4154a(-9223372036854775807L);
        }
    }

    /* renamed from: a */
    protected abstract boolean mo2205a(C2529l c2529l, long j, C2294a c2294a);

    /* renamed from: b */
    protected abstract long mo2206b(C2529l c2529l);

    /* renamed from: a */
    void m6349a(C2320g c2320g, C2329m c2329m) {
        this.f5635c = c2320g;
        this.f5634b = c2329m;
        mo2204a(true);
    }

    /* renamed from: a */
    protected void mo2204a(boolean z) {
        if (z) {
            this.f5642j = new C2294a();
            this.f5638f = 0;
            this.f5640h = false;
        } else {
            this.f5640h = true;
        }
        this.f5637e = -1;
        this.f5639g = 0;
    }

    /* renamed from: a */
    final void m6348a(long j, long j2) {
        this.f5633a.m6334a();
        if (j == 0) {
            mo2204a(this.f5644l ^ 1);
        } else if (this.f5640h != null) {
            this.f5637e = this.f5636d.mo2201a(j2);
            this.f5640h = 2;
        }
    }

    /* renamed from: a */
    final int m6346a(C2304f c2304f, C2326k c2326k) {
        switch (this.f5640h) {
            case 0:
                return m6344a(c2304f);
            case 1:
                c2304f.mo2186b((int) this.f5638f);
                this.f5640h = 2;
                return null;
            case 2:
                return m6345b(c2304f, c2326k);
            default:
                throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    private int m6344a(C2304f c2304f) {
        boolean z = true;
        while (z) {
            if (this.f5633a.m6335a(c2304f)) {
                this.f5643k = c2304f.mo2189c() - this.f5638f;
                z = mo2205a(this.f5633a.m6337c(), this.f5638f, this.f5642j);
                if (z) {
                    this.f5638f = c2304f.mo2189c();
                }
            } else {
                this.f5640h = 3;
                return -1;
            }
        }
        this.f5641i = this.f5642j.f5631a.f6393s;
        if (!this.f5645m) {
            this.f5634b.mo2199a(this.f5642j.f5631a);
            this.f5645m = true;
        }
        if (this.f5642j.f5632b != null) {
            this.f5636d = this.f5642j.f5632b;
        } else if (c2304f.mo2192d() == -1) {
            this.f5636d = new C4123b();
        } else {
            C2291e b = this.f5633a.m6336b();
            this.f5636d = new C4117a(this.f5638f, c2304f.mo2192d(), this, b.f5627h + b.f5628i, b.f5622c);
        }
        this.f5642j = null;
        this.f5640h = 2;
        this.f5633a.m6338d();
        return null;
    }

    /* renamed from: b */
    private int m6345b(C2304f c2304f, C2326k c2326k) {
        C2304f c2304f2 = c2304f;
        long a = this.f5636d.mo2202a(c2304f2);
        if (a >= 0) {
            c2326k.f5776a = a;
            return 1;
        }
        if (a < -1) {
            mo2207c(-(a + 2));
        }
        if (!r0.f5644l) {
            r0.f5635c.mo2233a(r0.f5636d.mo2203c());
            r0.f5644l = true;
        }
        if (r0.f5643k <= 0) {
            if (!r0.f5633a.m6335a(c2304f2)) {
                r0.f5640h = 3;
                return -1;
            }
        }
        r0.f5643k = 0;
        C2529l c = r0.f5633a.m6337c();
        a = mo2206b(c);
        if (a >= 0 && r0.f5639g + a >= r0.f5637e) {
            long a2 = m6347a(r0.f5639g);
            r0.f5634b.mo2200a(c, c.m7095c());
            r0.f5634b.mo2198a(a2, 1, c.m7095c(), 0, null);
            r0.f5637e = -1;
        }
        r0.f5639g += a;
        return 0;
    }

    /* renamed from: a */
    protected long m6347a(long j) {
        return (j * 1000000) / ((long) this.f5641i);
    }

    /* renamed from: b */
    protected long m6352b(long j) {
        return (((long) this.f5641i) * j) / 1000000;
    }

    /* renamed from: c */
    protected void mo2207c(long j) {
        this.f5639g = j;
    }
}
