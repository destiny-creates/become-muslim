package com.stripe.android.p285b;

import com.facebook.internal.AnalyticsEvents;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SourceCodeVerification */
/* renamed from: com.stripe.android.b.k */
public class C7163k extends C5729q {
    /* renamed from: a */
    private int f25381a;
    /* renamed from: b */
    private String f25382b;

    C7163k(int i, String str) {
        this.f25381a = i;
        this.f25382b = str;
    }

    /* renamed from: c */
    public int m33305c() {
        return this.f25381a;
    }

    /* renamed from: d */
    public String m33306d() {
        return this.f25382b;
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("attempts_remaining", Integer.valueOf(this.f25381a));
        if (this.f25382b != null) {
            hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.f25382b);
        }
        return hashMap;
    }

    /* renamed from: a */
    public org.json.JSONObject mo5065a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "attempts_remaining";	 Catch:{ JSONException -> 0x0013 }
        r2 = r3.f25381a;	 Catch:{ JSONException -> 0x0013 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0013 }
        r1 = "status";	 Catch:{ JSONException -> 0x0013 }
        r2 = r3.f25382b;	 Catch:{ JSONException -> 0x0013 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r2);	 Catch:{ JSONException -> 0x0013 }
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.k.a():org.json.JSONObject");
    }

    /* renamed from: a */
    public static C7163k m33301a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new C7163k(jSONObject.optInt("attempts_remaining", -1), C7163k.m33302a(C5730r.m24288d(jSONObject, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)));
    }

    /* renamed from: a */
    private static String m33302a(String str) {
        if ("pending".equals(str)) {
            return "pending";
        }
        if (AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED.equals(str)) {
            return AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED;
        }
        return "failed".equals(str) != null ? "failed" : null;
    }
}
