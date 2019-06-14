package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;
import org.json.JSONObject;

final class aur implements ae<Object> {
    /* renamed from: a */
    private final /* synthetic */ bq f23822a;
    /* renamed from: b */
    private final /* synthetic */ aum f23823b;

    aur(aum aum, bq bqVar) {
        this.f23823b = aum;
        this.f23822a = bqVar;
    }

    public final void zza(Object obj, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
            jSONObject.put("id", this.f23823b.f15011b);
            this.f23822a.mo4223a("sendMessageToNativeJs", jSONObject);
        } catch (Throwable e) {
            mt.m19919b("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
