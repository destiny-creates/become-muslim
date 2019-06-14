package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.jn;
import org.json.JSONObject;

final class ag implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ JSONObject f6872a;
    /* renamed from: b */
    private final /* synthetic */ af f6873b;

    ag(af afVar, JSONObject jSONObject) {
        this.f6873b = afVar;
        this.f6872a = jSONObject;
    }

    public final void run() {
        this.f6873b.f6869a.a("fetchHttpRequestCompleted", this.f6872a);
        jn.b("Dispatched http response.");
    }
}
