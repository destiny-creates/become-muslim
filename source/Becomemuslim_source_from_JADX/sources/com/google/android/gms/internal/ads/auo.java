package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

final /* synthetic */ class auo implements rx {
    /* renamed from: a */
    private final aun f23815a;
    /* renamed from: b */
    private final Map f23816b;
    /* renamed from: c */
    private final bq f23817c;

    auo(aun aun, Map map, bq bqVar) {
        this.f23815a = aun;
        this.f23816b = map;
        this.f23817c = bqVar;
    }

    /* renamed from: a */
    public final void mo3817a(boolean z) {
        aun aun = this.f23815a;
        Map map = this.f23816b;
        bq bqVar = this.f23817c;
        aun.f23813a.f15011b = (String) map.get("id");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("messageType", "htmlLoaded");
            jSONObject.put("id", aun.f23813a.f15011b);
            bqVar.mo4223a("sendMessageToNativeJs", jSONObject);
        } catch (Throwable e) {
            mt.m19919b("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
