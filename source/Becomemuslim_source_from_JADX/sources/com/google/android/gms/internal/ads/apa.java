package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.internal.ads.aoy.C4921a;
import com.google.android.gms.p174b.C4757d;

final class apa extends C4921a<apy> {
    /* renamed from: a */
    private final /* synthetic */ Context f23766a;
    /* renamed from: b */
    private final /* synthetic */ aou f23767b;
    /* renamed from: c */
    private final /* synthetic */ String f23768c;
    /* renamed from: d */
    private final /* synthetic */ aoy f23769d;

    apa(aoy aoy, Context context, aou aou, String str) {
        this.f23769d = aoy;
        this.f23766a = context;
        this.f23767b = aou;
        this.f23768c = str;
        super(aoy);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3854a() {
        apy a = this.f23769d.f14801c.m30057a(this.f23766a, this.f23767b, this.f23768c, null, 3);
        if (a != null) {
            return a;
        }
        aoy.m18671a(this.f23766a, "search");
        return new arp();
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3855a(aqk aqk) {
        return aqk.createSearchAdManager(C4757d.a(this.f23766a), this.f23767b, this.f23768c, C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }
}
