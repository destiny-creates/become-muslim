package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;

@cm
public final class pw extends ji {
    /* renamed from: a */
    final pn f28732a;
    /* renamed from: b */
    final pz f28733b;
    /* renamed from: c */
    private final String f28734c;

    pw(pn pnVar, pz pzVar, String str) {
        this.f28732a = pnVar;
        this.f28733b = pzVar;
        this.f28734c = str;
        ax.z().m20032a(this);
    }

    /* renamed from: a */
    public final void mo6079a() {
        try {
            this.f28733b.mo6124a(this.f28734c);
        } finally {
            jw.f15691a.post(new px(this));
        }
    }

    public final void h_() {
        this.f28733b.mo6125b();
    }
}
