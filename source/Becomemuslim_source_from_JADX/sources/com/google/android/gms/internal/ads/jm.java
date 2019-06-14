package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

final class jm extends ji {
    /* renamed from: a */
    private Context f28702a;

    jm(Context context) {
        this.f28702a = context;
    }

    /* renamed from: a */
    public final void mo6079a() {
        boolean isAdIdFakeForDebugLogging;
        try {
            isAdIdFakeForDebugLogging = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.f28702a);
        } catch (Throwable e) {
            mt.m19919b("Fail to get isAdIdFakeForDebugLogging", e);
            isAdIdFakeForDebugLogging = false;
        }
        mm.m19897a(isAdIdFakeForDebugLogging);
        StringBuilder stringBuilder = new StringBuilder(43);
        stringBuilder.append("Update ad debug logging enablement as ");
        stringBuilder.append(isAdIdFakeForDebugLogging);
        mt.m19924e(stringBuilder.toString());
    }

    public final void h_() {
    }
}
