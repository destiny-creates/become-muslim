package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.internal.ads.aoy.C4921a;
import com.google.android.gms.p174b.C4757d;

final class apc extends C4921a<apt> {
    /* renamed from: a */
    private final /* synthetic */ Context f23775a;
    /* renamed from: b */
    private final /* synthetic */ String f23776b;
    /* renamed from: c */
    private final /* synthetic */ bcy f23777c;
    /* renamed from: d */
    private final /* synthetic */ aoy f23778d;

    apc(aoy aoy, Context context, String str, bcy bcy) {
        this.f23778d = aoy;
        this.f23775a = context;
        this.f23776b = str;
        this.f23777c = bcy;
        super(aoy);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3854a() {
        apt a = this.f23778d.f14802d.m30055a(this.f23775a, this.f23776b, this.f23777c);
        if (a != null) {
            return a;
        }
        aoy.m18671a(this.f23775a, "native_ad");
        return new arl();
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3855a(aqk aqk) {
        return aqk.createAdLoaderBuilder(C4757d.a(this.f23775a), this.f23776b, this.f23777c, C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }
}
