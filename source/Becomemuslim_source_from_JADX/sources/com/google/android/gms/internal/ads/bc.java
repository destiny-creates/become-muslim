package com.google.android.gms.internal.ads;

import com.facebook.common.util.UriUtil;
import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

final class bc implements ae<Object> {
    /* renamed from: a */
    private final /* synthetic */ aty f23888a;
    /* renamed from: b */
    private final /* synthetic */ ay f23889b;

    bc(ay ayVar, aty aty) {
        this.f23889b = ayVar;
        this.f23888a = aty;
    }

    public final void zza(Object obj, Map<String, String> map) {
        this.f23889b.m19115a(this.f23888a, (String) map.get(UriUtil.LOCAL_ASSET_SCHEME));
    }
}
