package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.C4910m;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bu;
import com.google.android.gms.p174b.C2758b;

@cm
public final class azj extends apz {
    /* renamed from: a */
    private final String f28456a;
    /* renamed from: b */
    private boolean f28457b;
    /* renamed from: c */
    private final axy f28458c;
    /* renamed from: d */
    private C4910m f28459d;
    /* renamed from: e */
    private final aza f28460e;

    public azj(Context context, String str, bcy bcy, mv mvVar, bu buVar) {
        this(str, new axy(context, bcy, mvVar, buVar));
    }

    private azj(String str, axy axy) {
        this.f28456a = str;
        this.f28458c = axy;
        this.f28460e = new aza();
        ax.r().m19144a(axy);
    }

    /* renamed from: c */
    private final void m37214c() {
        if (this.f28459d == null) {
            this.f28459d = this.f28458c.m19103a(this.f28456a);
            this.f28460e.m19131a(this.f28459d);
        }
    }

    /* renamed from: C */
    public final String mo3881C() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    /* renamed from: D */
    public final aqh mo3882D() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    /* renamed from: E */
    public final apn mo3883E() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    /* renamed from: H */
    public final void mo3884H() {
        if (this.f28459d != null) {
            this.f28459d.c(this.f28457b);
            this.f28459d.H();
            return;
        }
        mt.m19924e("Interstitial ad must be loaded before showInterstitial().");
    }

    /* renamed from: a */
    public final String mo3885a() {
        return this.f28459d != null ? this.f28459d.a() : null;
    }

    /* renamed from: a */
    public final void mo3886a(af afVar, String str) {
        mt.m19924e("setPlayStorePurchaseParams is deprecated and should not be called.");
    }

    /* renamed from: a */
    public final void mo3887a(aou aou) {
        if (this.f28459d != null) {
            this.f28459d.a(aou);
        }
    }

    /* renamed from: a */
    public final void mo3888a(apk apk) {
        this.f28460e.f15071e = apk;
        if (this.f28459d != null) {
            this.f28460e.m19131a(this.f28459d);
        }
    }

    /* renamed from: a */
    public final void mo3889a(apn apn) {
        this.f28460e.f15067a = apn;
        if (this.f28459d != null) {
            this.f28460e.m19131a(this.f28459d);
        }
    }

    /* renamed from: a */
    public final void mo3890a(aqd aqd) {
        this.f28460e.f15068b = aqd;
        if (this.f28459d != null) {
            this.f28460e.m19131a(this.f28459d);
        }
    }

    /* renamed from: a */
    public final void mo3891a(aqh aqh) {
        this.f28460e.f15069c = aqh;
        if (this.f28459d != null) {
            this.f28460e.m19131a(this.f28459d);
        }
    }

    /* renamed from: a */
    public final void mo3892a(aqn aqn) {
        m37214c();
        if (this.f28459d != null) {
            this.f28459d.a(aqn);
        }
    }

    /* renamed from: a */
    public final void mo3893a(arb arb) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: a */
    public final void mo3894a(ary ary) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    /* renamed from: a */
    public final void mo3895a(atj atj) {
        this.f28460e.f15070d = atj;
        if (this.f28459d != null) {
            this.f28460e.m19131a(this.f28459d);
        }
    }

    /* renamed from: a */
    public final void mo3896a(gn gnVar) {
        this.f28460e.f15072f = gnVar;
        if (this.f28459d != null) {
            this.f28460e.m19131a(this.f28459d);
        }
    }

    /* renamed from: a */
    public final void mo3897a(C4939y c4939y) {
        mt.m19924e("setInAppPurchaseListener is deprecated and should not be called.");
    }

    /* renamed from: a */
    public final void mo3898a(String str) {
    }

    /* renamed from: b */
    public final void mo3899b(boolean z) {
        m37214c();
        if (this.f28459d != null) {
            this.f28459d.b(z);
        }
    }

    /* renamed from: b */
    public final boolean mo3900b(aoq aoq) {
        if (!azd.m19132a(aoq).contains("gw")) {
            m37214c();
        }
        if (azd.m19132a(aoq).contains("_skipMediation")) {
            m37214c();
        }
        if (aoq.f28270j != null) {
            m37214c();
        }
        if (this.f28459d != null) {
            return this.f28459d.b(aoq);
        }
        azd r = ax.r();
        if (azd.m19132a(aoq).contains("_ad")) {
            r.m19145b(aoq, this.f28456a);
        }
        azg a = r.m19142a(aoq, this.f28456a);
        if (a != null) {
            if (a.f15087e) {
                azi.m19160a().m19164d();
            } else {
                a.m19159a();
                azi.m19160a().m19165e();
            }
            this.f28459d = a.f15083a;
            a.f15085c.m19107a(this.f28460e);
            this.f28460e.m19131a(this.f28459d);
            return a.f15088f;
        }
        m37214c();
        azi.m19160a().m19165e();
        return this.f28459d.b(aoq);
    }

    /* renamed from: c */
    public final void mo3901c(boolean z) {
        this.f28457b = z;
    }

    /* renamed from: i */
    public final void mo3902i() {
        if (this.f28459d != null) {
            this.f28459d.i();
        }
    }

    /* renamed from: j */
    public final C2758b mo3903j() {
        return this.f28459d != null ? this.f28459d.j() : null;
    }

    /* renamed from: k */
    public final aou mo3904k() {
        return this.f28459d != null ? this.f28459d.k() : null;
    }

    /* renamed from: l */
    public final boolean mo3905l() {
        return this.f28459d != null && this.f28459d.l();
    }

    /* renamed from: m */
    public final void mo3906m() {
        if (this.f28459d != null) {
            this.f28459d.m();
        } else {
            mt.m19924e("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    /* renamed from: n */
    public final void mo3907n() {
        if (this.f28459d != null) {
            this.f28459d.n();
        }
    }

    /* renamed from: o */
    public final void mo3908o() {
        if (this.f28459d != null) {
            this.f28459d.o();
        }
    }

    /* renamed from: p */
    public final Bundle mo3909p() {
        return this.f28459d != null ? this.f28459d.p() : new Bundle();
    }

    /* renamed from: q */
    public final void mo3910q() {
        if (this.f28459d != null) {
            this.f28459d.q();
        }
    }

    /* renamed from: r */
    public final boolean mo3911r() {
        return this.f28459d != null && this.f28459d.r();
    }

    /* renamed from: s */
    public final aqv mo3912s() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    public final String w_() {
        return this.f28459d != null ? this.f28459d.w_() : null;
    }
}
