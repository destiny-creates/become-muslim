package com.google.android.exoplayer2.p137e.p138a;

import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2323h;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2327l.C4154a;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: FlvExtractor */
/* renamed from: com.google.android.exoplayer2.e.a.b */
public final class C4093b implements C2303e {
    /* renamed from: a */
    public static final C2323h f10356a = new C40921();
    /* renamed from: b */
    private static final int f10357b = C2541v.m7193g("FLV");
    /* renamed from: c */
    private final C2529l f10358c = new C2529l(4);
    /* renamed from: d */
    private final C2529l f10359d = new C2529l(9);
    /* renamed from: e */
    private final C2529l f10360e = new C2529l(11);
    /* renamed from: f */
    private final C2529l f10361f = new C2529l();
    /* renamed from: g */
    private final C4094c f10362g = new C4094c();
    /* renamed from: h */
    private C2320g f10363h;
    /* renamed from: i */
    private int f10364i = 1;
    /* renamed from: j */
    private long f10365j = -9223372036854775807L;
    /* renamed from: k */
    private int f10366k;
    /* renamed from: l */
    private int f10367l;
    /* renamed from: m */
    private int f10368m;
    /* renamed from: n */
    private long f10369n;
    /* renamed from: o */
    private boolean f10370o;
    /* renamed from: p */
    private C4091a f10371p;
    /* renamed from: q */
    private C4096e f10372q;

    /* compiled from: FlvExtractor */
    /* renamed from: com.google.android.exoplayer2.e.a.b$1 */
    static class C40921 implements C2323h {
        C40921() {
        }

        /* renamed from: a */
        public C2303e[] mo2161a() {
            return new C2303e[]{new C4093b()};
        }
    }

    /* renamed from: c */
    public void mo2166c() {
    }

    /* renamed from: a */
    public boolean mo2165a(C2304f c2304f) {
        boolean z = false;
        c2304f.mo2191c(this.f10358c.f6441a, 0, 3);
        this.f10358c.m7096c(0);
        if (this.f10358c.m7107k() != f10357b) {
            return false;
        }
        c2304f.mo2191c(this.f10358c.f6441a, 0, 2);
        this.f10358c.m7096c(0);
        if ((this.f10358c.m7104h() & 250) != 0) {
            return false;
        }
        c2304f.mo2191c(this.f10358c.f6441a, 0, 4);
        this.f10358c.m7096c(0);
        int o = this.f10358c.m7111o();
        c2304f.mo2183a();
        c2304f.mo2190c(o);
        c2304f.mo2191c(this.f10358c.f6441a, 0, 4);
        this.f10358c.m7096c(0);
        if (this.f10358c.m7111o() == null) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public void mo2164a(C2320g c2320g) {
        this.f10363h = c2320g;
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        this.f10364i = 1;
        this.f10365j = -9223372036854775807L;
        this.f10366k = 0;
    }

    /* renamed from: a */
    public int mo2162a(C2304f c2304f, C2326k c2326k) {
        while (true) {
            switch (this.f10364i) {
                case 1:
                    if (m12800b(c2304f) != null) {
                        break;
                    }
                    return -1;
                case 2:
                    m12801c(c2304f);
                    break;
                case 3:
                    if (m12802d(c2304f) != null) {
                        break;
                    }
                    return -1;
                case 4:
                    if (m12803e(c2304f) == null) {
                        break;
                    }
                    return null;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    /* renamed from: b */
    private boolean m12800b(C2304f c2304f) {
        boolean z = false;
        if (c2304f.mo2184a(this.f10359d.f6441a, 0, 9, true) == null) {
            return false;
        }
        this.f10359d.m7096c(0);
        this.f10359d.m7098d(4);
        c2304f = this.f10359d.m7103g();
        Object obj = (c2304f & 4) != 0 ? 1 : null;
        if ((c2304f & 1) != null) {
            z = true;
        }
        if (obj != null && this.f10371p == null) {
            this.f10371p = new C4091a(this.f10363h.mo2231a(8, 1));
        }
        if (z && this.f10372q == null) {
            this.f10372q = new C4096e(this.f10363h.mo2231a(9, 2));
        }
        this.f10363h.mo2232a();
        this.f10366k = (this.f10359d.m7111o() - 9) + 4;
        this.f10364i = 2;
        return true;
    }

    /* renamed from: c */
    private void m12801c(C2304f c2304f) {
        c2304f.mo2186b(this.f10366k);
        this.f10366k = null;
        this.f10364i = 3;
    }

    /* renamed from: d */
    private boolean m12802d(C2304f c2304f) {
        if (c2304f.mo2184a(this.f10360e.f6441a, 0, 11, true) == null) {
            return false;
        }
        this.f10360e.m7096c(0);
        this.f10367l = this.f10360e.m7103g();
        this.f10368m = this.f10360e.m7107k();
        this.f10369n = (long) this.f10360e.m7107k();
        this.f10369n = (((long) (this.f10360e.m7103g() << 24)) | this.f10369n) * 1000;
        this.f10360e.m7098d(3);
        this.f10364i = 4;
        return true;
    }

    /* renamed from: e */
    private boolean m12803e(C2304f c2304f) {
        boolean z = true;
        if (this.f10367l == 8 && this.f10371p != null) {
            m12799a();
            this.f10371p.m6242b(m12804f(c2304f), this.f10365j + this.f10369n);
        } else if (this.f10367l == 9 && this.f10372q != null) {
            m12799a();
            this.f10372q.m6242b(m12804f(c2304f), this.f10365j + this.f10369n);
        } else if (this.f10367l != 18 || this.f10370o) {
            c2304f.mo2186b(this.f10368m);
            z = false;
        } else {
            this.f10362g.m6242b(m12804f(c2304f), this.f10369n);
            long a = this.f10362g.m12819a();
            if (a != -9223372036854775807L) {
                this.f10363h.mo2233a(new C4154a(a));
                this.f10370o = true;
            }
        }
        this.f10366k = 4;
        this.f10364i = 2;
        return z;
    }

    /* renamed from: f */
    private C2529l m12804f(C2304f c2304f) {
        if (this.f10368m > this.f10361f.m7099e()) {
            this.f10361f.m7091a(new byte[Math.max(this.f10361f.m7099e() * 2, this.f10368m)], 0);
        } else {
            this.f10361f.m7096c(0);
        }
        this.f10361f.m7094b(this.f10368m);
        c2304f.mo2187b(this.f10361f.f6441a, 0, this.f10368m);
        return this.f10361f;
    }

    /* renamed from: a */
    private void m12799a() {
        if (!this.f10370o) {
            this.f10363h.mo2233a(new C4154a(-9223372036854775807L));
            this.f10370o = true;
        }
        if (this.f10365j == -9223372036854775807L) {
            this.f10365j = this.f10362g.m12819a() == -9223372036854775807L ? -this.f10369n : 0;
        }
    }
}
