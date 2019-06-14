package com.google.android.exoplayer2.p137e.p143h;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2323h;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2329m;

/* compiled from: WavExtractor */
/* renamed from: com.google.android.exoplayer2.e.h.a */
public final class C4151a implements C2303e {
    /* renamed from: a */
    public static final C2323h f10772a = new C41501();
    /* renamed from: b */
    private C2320g f10773b;
    /* renamed from: c */
    private C2329m f10774c;
    /* renamed from: d */
    private C4152b f10775d;
    /* renamed from: e */
    private int f10776e;
    /* renamed from: f */
    private int f10777f;

    /* compiled from: WavExtractor */
    /* renamed from: com.google.android.exoplayer2.e.h.a$1 */
    static class C41501 implements C2323h {
        C41501() {
        }

        /* renamed from: a */
        public C2303e[] mo2161a() {
            return new C2303e[]{new C4151a()};
        }
    }

    /* renamed from: c */
    public void mo2166c() {
    }

    /* renamed from: a */
    public boolean mo2165a(C2304f c2304f) {
        return C2322c.m6441a(c2304f) != null ? true : null;
    }

    /* renamed from: a */
    public void mo2164a(C2320g c2320g) {
        this.f10773b = c2320g;
        this.f10774c = c2320g.mo2231a(0, 1);
        this.f10775d = null;
        c2320g.mo2232a();
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        this.f10777f = 0;
    }

    /* renamed from: a */
    public int mo2162a(C2304f c2304f, C2326k c2326k) {
        if (this.f10775d == null) {
            this.f10775d = C2322c.m6441a(c2304f);
            if (this.f10775d != null) {
                this.f10774c.mo2199a(C2515k.m6987a(null, "audio/raw", null, this.f10775d.m13209e(), 32768, this.f10775d.m13211g(), this.f10775d.m13210f(), this.f10775d.m13212h(), null, null, 0, null));
                this.f10776e = this.f10775d.m13208d();
            } else {
                throw new C2571p("Unsupported or unrecognized wav header.");
            }
        }
        if (this.f10775d.m13207c() == null) {
            C2322c.m6442a(c2304f, this.f10775d);
            this.f10773b.mo2233a(this.f10775d);
        }
        c2326k = this.f10774c.mo2197a(c2304f, 32768 - this.f10777f, true);
        if (c2326k != -1) {
            this.f10777f += c2326k;
        }
        int i = this.f10777f / this.f10776e;
        if (i > 0) {
            long a = this.f10775d.m13202a(c2304f.mo2189c() - ((long) this.f10777f));
            int i2 = i * this.f10776e;
            this.f10777f -= i2;
            this.f10774c.mo2198a(a, 1, i2, this.f10777f, null);
        }
        if (c2326k == -1) {
            return -1;
        }
        return 0;
    }
}
