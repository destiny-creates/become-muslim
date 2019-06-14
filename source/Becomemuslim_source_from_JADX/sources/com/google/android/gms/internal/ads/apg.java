package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.internal.ads.aoy.C4921a;
import com.google.android.gms.p174b.C4757d;

final class apg extends C4921a<C4936r> {
    /* renamed from: a */
    private final /* synthetic */ Activity f23786a;
    /* renamed from: b */
    private final /* synthetic */ aoy f23787b;

    apg(aoy aoy, Activity activity) {
        this.f23787b = aoy;
        this.f23786a = activity;
        super(aoy);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3854a() {
        C4936r a = this.f23787b.f14806h.m31000a(this.f23786a);
        if (a != null) {
            return a;
        }
        aoy.m18671a(this.f23786a, "ad_overlay");
        return null;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3855a(aqk aqk) {
        return aqk.createAdOverlay(C4757d.a(this.f23786a));
    }
}
