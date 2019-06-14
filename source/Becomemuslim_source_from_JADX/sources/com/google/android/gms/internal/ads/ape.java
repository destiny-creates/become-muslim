package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.internal.ads.aoy.C4921a;
import com.google.android.gms.p174b.C4757d;

final class ape extends C4921a<gh> {
    /* renamed from: a */
    private final /* synthetic */ Context f23783a;
    /* renamed from: b */
    private final /* synthetic */ bcy f23784b;
    /* renamed from: c */
    private final /* synthetic */ aoy f23785c;

    ape(aoy aoy, Context context, bcy bcy) {
        this.f23785c = aoy;
        this.f23783a = context;
        this.f23784b = bcy;
        super(aoy);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3854a() {
        gh a = this.f23785c.f14805g.m30758a(this.f23783a, this.f23784b);
        if (a != null) {
            return a;
        }
        aoy.m18671a(this.f23783a, "rewarded_video");
        return new ars();
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3855a(aqk aqk) {
        return aqk.createRewardedVideoAd(C4757d.a(this.f23783a), this.f23784b, C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }
}
