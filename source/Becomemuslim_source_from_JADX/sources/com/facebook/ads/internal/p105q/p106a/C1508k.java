package com.facebook.ads.internal.p105q.p106a;

import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.q.a.k */
public class C1508k {
    /* renamed from: a */
    public static String m5306a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public static String m5307a(JSONObject jSONObject, String str) {
        return C1508k.m5308a(jSONObject, str, null);
    }

    /* renamed from: a */
    public static String m5308a(JSONObject jSONObject, String str, String str2) {
        String optString = jSONObject.optString(str, str2);
        return "null".equals(optString) ? null : optString;
    }
}
