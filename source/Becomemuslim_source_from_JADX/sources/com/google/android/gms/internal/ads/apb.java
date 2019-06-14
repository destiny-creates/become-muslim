package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.internal.ads.aoy.C4921a;
import com.google.android.gms.p174b.C4757d;

final class apb extends C4921a<apy> {
    /* renamed from: a */
    private final /* synthetic */ Context f23770a;
    /* renamed from: b */
    private final /* synthetic */ aou f23771b;
    /* renamed from: c */
    private final /* synthetic */ String f23772c;
    /* renamed from: d */
    private final /* synthetic */ bcy f23773d;
    /* renamed from: e */
    private final /* synthetic */ aoy f23774e;

    apb(aoy aoy, Context context, aou aou, String str, bcy bcy) {
        this.f23774e = aoy;
        this.f23770a = context;
        this.f23771b = aou;
        this.f23772c = str;
        this.f23773d = bcy;
        super(aoy);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3854a() {
        apy a = this.f23774e.f14801c.m30057a(this.f23770a, this.f23771b, this.f23772c, this.f23773d, 2);
        if (a != null) {
            return a;
        }
        aoy.m18671a(this.f23770a, "interstitial");
        return new arp();
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3855a(aqk aqk) {
        return aqk.createInterstitialAdManager(C4757d.a(this.f23770a), this.f23771b, this.f23772c, this.f23773d, C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }
}
