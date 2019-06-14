package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

@cm
public final class ip implements ir {
    /* renamed from: a */
    public final no<Info> mo4301a(Context context) {
        no nzVar = new nz();
        aph.m18683a();
        if (mi.m19883f(context)) {
            ju.m19678a(new iq(this, context, nzVar));
        }
        return nzVar;
    }

    /* renamed from: a */
    public final no<String> mo4302a(String str, PackageInfo packageInfo) {
        return nd.m19938a((Object) str);
    }
}
