package com.google.android.exoplayer2.p137e.p142g;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2537s;

/* compiled from: SpliceInfoSectionReader */
/* renamed from: com.google.android.exoplayer2.e.g.u */
public final class C4145u implements C2313r {
    /* renamed from: a */
    private C2537s f10747a;
    /* renamed from: b */
    private C2329m f10748b;
    /* renamed from: c */
    private boolean f10749c;

    /* renamed from: a */
    public void mo2219a(C2537s c2537s, C2320g c2320g, C2318d c2318d) {
        this.f10747a = c2537s;
        c2318d.m6431a();
        this.f10748b = c2320g.mo2231a(c2318d.m6432b(), 4);
        this.f10748b.mo2199a(C2515k.m6992a(c2318d.m6433c(), "application/x-scte35", null, -1, null));
    }

    /* renamed from: a */
    public void mo2218a(C2529l c2529l) {
        if (!this.f10749c) {
            if (this.f10747a.m7150c() != -9223372036854775807L) {
                this.f10748b.mo2199a(C2515k.m6983a(null, "application/x-scte35", this.f10747a.m7150c()));
                this.f10749c = true;
            } else {
                return;
            }
        }
        int b = c2529l.m7093b();
        this.f10748b.mo2200a(c2529l, b);
        this.f10748b.mo2198a(this.f10747a.m7148b(), 1, b, 0, null);
    }
}
