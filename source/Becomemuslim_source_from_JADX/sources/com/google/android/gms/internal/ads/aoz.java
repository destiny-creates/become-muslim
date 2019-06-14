package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.internal.ads.aoy.C4921a;
import com.google.android.gms.p174b.C4757d;

final class aoz extends C4921a<apy> {
    /* renamed from: a */
    private final /* synthetic */ Context f23761a;
    /* renamed from: b */
    private final /* synthetic */ aou f23762b;
    /* renamed from: c */
    private final /* synthetic */ String f23763c;
    /* renamed from: d */
    private final /* synthetic */ bcy f23764d;
    /* renamed from: e */
    private final /* synthetic */ aoy f23765e;

    aoz(aoy aoy, Context context, aou aou, String str, bcy bcy) {
        this.f23765e = aoy;
        this.f23761a = context;
        this.f23762b = aou;
        this.f23763c = str;
        this.f23764d = bcy;
        super(aoy);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3854a() {
        apy a = this.f23765e.f14801c.m30057a(this.f23761a, this.f23762b, this.f23763c, this.f23764d, 1);
        if (a != null) {
            return a;
        }
        aoy.m18671a(this.f23761a, "banner");
        return new arp();
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3855a(aqk aqk) {
        return aqk.createBannerAdManager(C4757d.a(this.f23761a), this.f23762b, this.f23763c, this.f23764d, C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }
}
