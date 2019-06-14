package com.facebook.ads.internal.p085a;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.a.g */
public class C1302g {
    /* renamed from: a */
    private final String f3752a;
    /* renamed from: b */
    private final String f3753b;
    /* renamed from: c */
    private final String f3754c;
    /* renamed from: d */
    private final List<String> f3755d;
    /* renamed from: e */
    private final String f3756e;
    /* renamed from: f */
    private final String f3757f;

    private C1302g(String str, String str2, String str3, List<String> list, String str4, String str5) {
        this.f3752a = str;
        this.f3753b = str2;
        this.f3754c = str3;
        this.f3755d = list;
        this.f3756e = str4;
        this.f3757f = str5;
    }

    /* renamed from: a */
    public static C1302g m4453a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("package");
        String optString2 = jSONObject.optString("appsite");
        String optString3 = jSONObject.optString("appsite_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("key_hashes");
        List arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
        }
        return new C1302g(optString, optString2, optString3, arrayList, jSONObject.optString("market_uri"), jSONObject.optString(MessengerShareContentUtility.FALLBACK_URL));
    }

    /* renamed from: a */
    public String m4454a() {
        return this.f3752a;
    }

    /* renamed from: b */
    public String m4455b() {
        return this.f3753b;
    }

    /* renamed from: c */
    public String m4456c() {
        return this.f3754c;
    }
}
