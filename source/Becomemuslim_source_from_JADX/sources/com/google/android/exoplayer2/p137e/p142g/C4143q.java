package com.google.android.exoplayer2.p137e.p142g;

import android.util.SparseArray;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2323h;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2327l.C4154a;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2528k;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2537s;

/* compiled from: PsExtractor */
/* renamed from: com.google.android.exoplayer2.e.g.q */
public final class C4143q implements C2303e {
    /* renamed from: a */
    public static final C2323h f10733a = new C41421();
    /* renamed from: b */
    private final C2537s f10734b;
    /* renamed from: c */
    private final SparseArray<C2312a> f10735c;
    /* renamed from: d */
    private final C2529l f10736d;
    /* renamed from: e */
    private boolean f10737e;
    /* renamed from: f */
    private boolean f10738f;
    /* renamed from: g */
    private boolean f10739g;
    /* renamed from: h */
    private C2320g f10740h;

    /* compiled from: PsExtractor */
    /* renamed from: com.google.android.exoplayer2.e.g.q$a */
    private static final class C2312a {
        /* renamed from: a */
        private final C2305h f5734a;
        /* renamed from: b */
        private final C2537s f5735b;
        /* renamed from: c */
        private final C2528k f5736c = new C2528k(new byte[64]);
        /* renamed from: d */
        private boolean f5737d;
        /* renamed from: e */
        private boolean f5738e;
        /* renamed from: f */
        private boolean f5739f;
        /* renamed from: g */
        private int f5740g;
        /* renamed from: h */
        private long f5741h;

        public C2312a(C2305h c2305h, C2537s c2537s) {
            this.f5734a = c2305h;
            this.f5735b = c2537s;
        }

        /* renamed from: a */
        public void m6422a() {
            this.f5739f = false;
            this.f5734a.mo2208a();
        }

        /* renamed from: a */
        public void m6423a(C2529l c2529l) {
            c2529l.m7092a(this.f5736c.f6437a, 0, 3);
            this.f5736c.m7073a(0);
            m6420b();
            c2529l.m7092a(this.f5736c.f6437a, 0, this.f5740g);
            this.f5736c.m7073a(0);
            m6421c();
            this.f5734a.mo2209a(this.f5741h, true);
            this.f5734a.mo2211a(c2529l);
            this.f5734a.mo2212b();
        }

        /* renamed from: b */
        private void m6420b() {
            this.f5736c.m7078b(8);
            this.f5737d = this.f5736c.m7084e();
            this.f5738e = this.f5736c.m7084e();
            this.f5736c.m7078b(6);
            this.f5740g = this.f5736c.m7081c(8);
        }

        /* renamed from: c */
        private void m6421c() {
            this.f5741h = 0;
            if (this.f5737d) {
                this.f5736c.m7078b(4);
                long c = ((long) this.f5736c.m7081c(3)) << 30;
                this.f5736c.m7078b(1);
                c |= (long) (this.f5736c.m7081c(15) << 15);
                this.f5736c.m7078b(1);
                c |= (long) this.f5736c.m7081c(15);
                this.f5736c.m7078b(1);
                if (!this.f5739f && this.f5738e) {
                    this.f5736c.m7078b(4);
                    long c2 = ((long) this.f5736c.m7081c(3)) << 30;
                    this.f5736c.m7078b(1);
                    c2 |= (long) (this.f5736c.m7081c(15) << 15);
                    this.f5736c.m7078b(1);
                    c2 |= (long) this.f5736c.m7081c(15);
                    this.f5736c.m7078b(1);
                    this.f5735b.m7149b(c2);
                    this.f5739f = true;
                }
                this.f5741h = this.f5735b.m7149b(c);
            }
        }
    }

    /* compiled from: PsExtractor */
    /* renamed from: com.google.android.exoplayer2.e.g.q$1 */
    static class C41421 implements C2323h {
        C41421() {
        }

        /* renamed from: a */
        public C2303e[] mo2161a() {
            return new C2303e[]{new C4143q()};
        }
    }

    /* renamed from: c */
    public void mo2166c() {
    }

    public C4143q() {
        this(new C2537s(0));
    }

    public C4143q(C2537s c2537s) {
        this.f10734b = c2537s;
        this.f10736d = new C2529l(4096);
        this.f10735c = new SparseArray();
    }

    /* renamed from: a */
    public boolean mo2165a(C2304f c2304f) {
        byte[] bArr = new byte[14];
        boolean z = false;
        c2304f.mo2191c(bArr, 0, 14);
        if (442 != (((((bArr[0] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((bArr[1] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((bArr[2] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | (bArr[3] & JfifUtil.MARKER_FIRST_BYTE)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        c2304f.mo2190c(bArr[13] & 7);
        c2304f.mo2191c(bArr, 0, 3);
        if (1 == ((((bArr[0] & JfifUtil.MARKER_FIRST_BYTE) << 16) | ((bArr[1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | (bArr[2] & JfifUtil.MARKER_FIRST_BYTE))) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public void mo2164a(C2320g c2320g) {
        this.f10740h = c2320g;
        c2320g.mo2233a(new C4154a(-9223372036854775807L));
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        this.f10734b.m7152d();
        for (j = null; j < this.f10735c.size(); j++) {
            ((C2312a) this.f10735c.valueAt(j)).m6422a();
        }
    }

    /* renamed from: a */
    public int mo2162a(C2304f c2304f, C2326k c2326k) {
        if (c2304f.mo2188b(this.f10736d.f6441a, 0, 4, true) == null) {
            return -1;
        }
        this.f10736d.m7096c(0);
        c2326k = this.f10736d.m7111o();
        if (c2326k == 441) {
            return -1;
        }
        if (c2326k == 442) {
            c2304f.mo2191c(this.f10736d.f6441a, 0, 10);
            this.f10736d.m7096c(9);
            c2304f.mo2186b((this.f10736d.m7103g() & 7) + 14);
            return 0;
        } else if (c2326k == 443) {
            c2304f.mo2191c(this.f10736d.f6441a, 0, 2);
            this.f10736d.m7096c(0);
            c2304f.mo2186b(this.f10736d.m7104h() + 6);
            return 0;
        } else if (((c2326k & -256) >> 8) != 1) {
            c2304f.mo2186b(1);
            return 0;
        } else {
            c2326k &= JfifUtil.MARKER_FIRST_BYTE;
            C2312a c2312a = (C2312a) this.f10735c.get(c2326k);
            if (!this.f10737e) {
                if (c2312a == null) {
                    C2305h c2305h = null;
                    if (!this.f10738f && c2326k == 189) {
                        c2305h = new C4128b();
                        this.f10738f = true;
                    } else if (!this.f10738f && (c2326k & 224) == JfifUtil.MARKER_SOFn) {
                        c2305h = new C4140n();
                        this.f10738f = true;
                    } else if (!this.f10739g && (c2326k & 240) == 224) {
                        c2305h = new C4135i();
                        this.f10739g = true;
                    }
                    if (c2305h != null) {
                        c2305h.mo2210a(this.f10740h, new C2318d(c2326k, 256));
                        c2312a = new C2312a(c2305h, this.f10734b);
                        this.f10735c.put(c2326k, c2312a);
                    }
                }
                if (!(this.f10738f == null || this.f10739g == null) || c2304f.mo2189c() > 1048576) {
                    this.f10737e = true;
                    this.f10740h.mo2232a();
                }
            }
            c2304f.mo2191c(this.f10736d.f6441a, 0, 2);
            this.f10736d.m7096c(0);
            c2326k = this.f10736d.m7104h() + 6;
            if (c2312a == null) {
                c2304f.mo2186b(c2326k);
            } else {
                this.f10736d.m7089a(c2326k);
                c2304f.mo2187b(this.f10736d.f6441a, 0, c2326k);
                this.f10736d.m7096c(6);
                c2312a.m6423a(this.f10736d);
                this.f10736d.m7094b(this.f10736d.m7099e());
            }
            return 0;
        }
    }
}
