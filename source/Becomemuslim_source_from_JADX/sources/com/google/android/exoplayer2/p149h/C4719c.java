package com.google.android.exoplayer2.p149h;

import com.google.android.exoplayer2.C2543l;
import com.google.android.exoplayer2.p135b.C4085e;
import com.google.android.exoplayer2.p149h.C4219h.C4218a;
import com.google.android.exoplayer2.p162j.C2484f;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2524i;

/* compiled from: ClippingMediaPeriod */
/* renamed from: com.google.android.exoplayer2.h.c */
public final class C4719c implements C4219h, C4218a {
    /* renamed from: a */
    public final C4219h f12782a;
    /* renamed from: b */
    private C4218a f12783b;
    /* renamed from: c */
    private long f12784c = -9223372036854775807L;
    /* renamed from: d */
    private long f12785d = -9223372036854775807L;
    /* renamed from: e */
    private C4189a[] f12786e = new C4189a[null];
    /* renamed from: f */
    private boolean f12787f;

    /* compiled from: ClippingMediaPeriod */
    /* renamed from: com.google.android.exoplayer2.h.c$a */
    private final class C4189a implements C2435m {
        /* renamed from: a */
        final /* synthetic */ C4719c f10900a;
        /* renamed from: b */
        private final C2435m f10901b;
        /* renamed from: c */
        private final long f10902c;
        /* renamed from: d */
        private final long f10903d;
        /* renamed from: e */
        private boolean f10904e;
        /* renamed from: f */
        private boolean f10905f;

        public C4189a(C4719c c4719c, C2435m c2435m, long j, long j2, boolean z) {
            this.f10900a = c4719c;
            this.f10901b = c2435m;
            this.f10902c = j;
            this.f10903d = j2;
            this.f10904e = z;
        }

        /* renamed from: a */
        public void m13434a() {
            this.f10904e = false;
        }

        /* renamed from: b */
        public void m13435b() {
            this.f10905f = false;
        }

        /* renamed from: c */
        public boolean mo2236c() {
            return this.f10901b.mo2236c();
        }

        public void f_() {
            this.f10901b.f_();
        }

        /* renamed from: a */
        public int mo2235a(C2543l c2543l, C4085e c4085e, boolean z) {
            if (this.f10904e) {
                return -3;
            }
            if (this.f10905f) {
                c4085e.a_(4);
                return -4;
            }
            z = this.f10901b.mo2235a(c2543l, c4085e, z);
            if (z) {
                c4085e = c2543l.f6476a;
                int i = false;
                int i2 = this.f10902c != 0 ? 0 : c4085e.f6395u;
                if (this.f10903d == Long.MIN_VALUE) {
                    i = c4085e.f6396v;
                }
                c2543l.f6476a = c4085e.m7007a(i2, i);
                return -5;
            } else if (this.f10903d == Long.MIN_VALUE || ((!z || c4085e.f10319c < this.f10903d) && !(z && this.f10900a.mo2242d() == Long.MIN_VALUE))) {
                if (z && c4085e.m6206c() == null) {
                    c4085e.f10319c -= this.f10902c;
                }
                return z;
            } else {
                c4085e.mo2145a();
                c4085e.a_(4);
                this.f10905f = true;
                return -4;
            }
        }

        /* renamed from: a */
        public int mo2234a(long j) {
            return this.f10901b.mo2234a(this.f10902c + j);
        }
    }

    /* renamed from: a */
    public /* synthetic */ void mo3205a(C2437n c2437n) {
        m16140b((C4219h) c2437n);
    }

    public C4719c(C4219h c4219h, boolean z) {
        this.f12782a = c4219h;
        this.f12787f = z;
    }

    /* renamed from: a */
    public void m16134a(long j, long j2) {
        this.f12784c = j;
        this.f12785d = j2;
    }

    /* renamed from: a */
    public void mo3204a(C4218a c4218a, long j) {
        this.f12783b = c4218a;
        this.f12782a.mo3204a(this, this.f12784c + j);
    }

    public void e_() {
        this.f12782a.e_();
    }

    /* renamed from: b */
    public C2439q mo3207b() {
        return this.f12782a.mo3207b();
    }

    /* renamed from: a */
    public long mo3202a(C2484f[] c2484fArr, boolean[] zArr, C2435m[] c2435mArr, boolean[] zArr2, long j) {
        C2435m[] c2435mArr2 = c2435mArr;
        this.f12786e = new C4189a[c2435mArr2.length];
        C2435m[] c2435mArr3 = new C2435m[c2435mArr2.length];
        int i = 0;
        while (true) {
            C2435m c2435m = null;
            if (i >= c2435mArr2.length) {
                break;
            }
            r8.f12786e[i] = (C4189a) c2435mArr2[i];
            if (r8.f12786e[i] != null) {
                c2435m = r8.f12786e[i].f10901b;
            }
            c2435mArr3[i] = c2435m;
            i++;
        }
        long a = r8.f12782a.mo3202a(c2484fArr, zArr, c2435mArr3, zArr2, j + r8.f12784c);
        boolean z = true;
        if (r8.f12787f) {
            boolean z2 = r8.f12784c != 0 && C4719c.m16131a(c2484fArr);
            r8.f12787f = z2;
        }
        if (a != j + r8.f12784c) {
            if (a >= r8.f12784c) {
                if (r8.f12785d != Long.MIN_VALUE) {
                    if (a <= r8.f12785d) {
                    }
                }
            }
            z = false;
        }
        C2516a.m7019b(z);
        int i2 = 0;
        while (i2 < c2435mArr2.length) {
            C2435m[] c2435mArr4;
            if (c2435mArr3[i2] == null) {
                r8.f12786e[i2] = null;
            } else if (c2435mArr2[i2] == null || r8.f12786e[i2].f10901b != c2435mArr3[i2]) {
                c2435mArr4 = c2435mArr3;
                r8.f12786e[i2] = new C4189a(this, c2435mArr3[i2], r8.f12784c, r8.f12785d, r8.f12787f);
                c2435mArr2[i2] = r8.f12786e[i2];
                i2++;
                c2435mArr3 = c2435mArr4;
            }
            c2435mArr4 = c2435mArr3;
            c2435mArr2[i2] = r8.f12786e[i2];
            i2++;
            c2435mArr3 = c2435mArr4;
        }
        return a - r8.f12784c;
    }

    /* renamed from: a */
    public void mo3203a(long j) {
        this.f12782a.mo3203a(j + this.f12784c);
    }

    /* renamed from: c */
    public long mo3208c() {
        if (this.f12787f) {
            for (C4189a c4189a : this.f12786e) {
                if (c4189a != null) {
                    c4189a.m13434a();
                }
            }
            this.f12787f = false;
            long c = mo3208c();
            if (c == -9223372036854775807L) {
                c = 0;
            }
            return c;
        }
        long c2 = this.f12782a.mo3208c();
        if (c2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        C2516a.m7019b(c2 >= this.f12784c);
        if (this.f12785d != Long.MIN_VALUE) {
            if (c2 > this.f12785d) {
                z = false;
            }
        }
        C2516a.m7019b(z);
        return c2 - this.f12784c;
    }

    /* renamed from: d */
    public long mo2242d() {
        long d = this.f12782a.mo2242d();
        if (d != Long.MIN_VALUE) {
            if (this.f12785d == Long.MIN_VALUE || d < this.f12785d) {
                return Math.max(0, d - this.f12784c);
            }
        }
        return Long.MIN_VALUE;
    }

    /* renamed from: b */
    public long mo3206b(long j) {
        boolean z = false;
        for (C4189a c4189a : this.f12786e) {
            if (c4189a != null) {
                c4189a.m13435b();
            }
        }
        long b = this.f12782a.mo3206b(this.f12784c + j);
        if (b == j + this.f12784c || (b >= this.f12784c && (this.f12785d == Long.MIN_VALUE || b <= this.f12785d))) {
            z = true;
        }
        C2516a.m7019b(z);
        return b - this.f12784c;
    }

    /* renamed from: e */
    public long mo2243e() {
        long e = this.f12782a.mo2243e();
        if (e != Long.MIN_VALUE) {
            if (this.f12785d == Long.MIN_VALUE || e < this.f12785d) {
                return e - this.f12784c;
            }
        }
        return Long.MIN_VALUE;
    }

    /* renamed from: c */
    public boolean mo2241c(long j) {
        return this.f12782a.mo2241c(j + this.f12784c);
    }

    /* renamed from: a */
    public void mo3223a(C4219h c4219h) {
        c4219h = (this.f12784c == -9223372036854775807L || this.f12785d == -9223372036854775807L) ? null : true;
        C2516a.m7019b(c4219h);
        this.f12783b.mo3223a(this);
    }

    /* renamed from: b */
    public void m16140b(C4219h c4219h) {
        this.f12783b.mo3205a(this);
    }

    /* renamed from: a */
    private static boolean m16131a(C2484f[] c2484fArr) {
        for (C2484f c2484f : c2484fArr) {
            if (c2484f != null && !C2524i.m7050a(c2484f.mo2307h().f6380f)) {
                return 1;
            }
        }
        return false;
    }
}
