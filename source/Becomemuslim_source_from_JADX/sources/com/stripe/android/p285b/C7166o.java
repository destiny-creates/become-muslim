package com.stripe.android.p285b;

import com.facebook.internal.AnalyticsEvents;
import com.stripe.android.C5772r;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SourceRedirect */
/* renamed from: com.stripe.android.b.o */
public class C7166o extends C5729q {
    /* renamed from: a */
    private String f25395a;
    /* renamed from: b */
    private String f25396b;
    /* renamed from: c */
    private String f25397c;

    C7166o(String str, String str2, String str3) {
        this.f25395a = str;
        this.f25396b = str2;
        this.f25397c = str3;
    }

    /* renamed from: c */
    public String m33329c() {
        return this.f25395a;
    }

    /* renamed from: d */
    public String m33330d() {
        return this.f25396b;
    }

    /* renamed from: e */
    public String m33331e() {
        return this.f25397c;
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("return_url", this.f25395a);
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.f25396b);
        hashMap.put("url", this.f25397c);
        C5772r.m24411a(hashMap);
        return hashMap;
    }

    /* renamed from: a */
    public JSONObject mo5065a() {
        JSONObject jSONObject = new JSONObject();
        C5730r.m24283a(jSONObject, "return_url", this.f25395a);
        C5730r.m24283a(jSONObject, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.f25396b);
        C5730r.m24283a(jSONObject, "url", this.f25397c);
        return jSONObject;
    }

    /* renamed from: a */
    public static C7166o m33325a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new C7166o(C5730r.m24288d(jSONObject, "return_url"), C7166o.m33326a(C5730r.m24288d(jSONObject, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)), C5730r.m24288d(jSONObject, "url"));
    }

    /* renamed from: a */
    private static String m33326a(String str) {
        if ("pending".equals(str)) {
            return "pending";
        }
        if (AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED.equals(str)) {
            return AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED;
        }
        return "failed".equals(str) != null ? "failed" : null;
    }
}
