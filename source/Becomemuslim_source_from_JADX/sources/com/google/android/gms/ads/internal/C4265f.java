package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.my;
import com.google.android.gms.internal.ads.nd;
import com.google.android.gms.internal.ads.no;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.ads.internal.f */
final /* synthetic */ class C4265f implements my {
    /* renamed from: a */
    static final my f11280a = new C4265f();

    private C4265f() {
    }

    /* renamed from: a */
    public final no m13900a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            ax.m7468i().l().f(jSONObject.getString("appSettingsJson"));
        }
        return nd.a(null);
    }
}
