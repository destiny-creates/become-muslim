package com.facebook.ads.internal.p099n;

import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.n.h */
public class C1427h {
    /* renamed from: a */
    private final String f4217a;
    /* renamed from: b */
    private final int f4218b;
    /* renamed from: c */
    private final int f4219c;

    public C1427h(String str, int i, int i2) {
        this.f4217a = str;
        this.f4218b = i;
        this.f4219c = i2;
    }

    /* renamed from: a */
    public static C1427h m5021a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("url");
        return optString == null ? null : new C1427h(optString, jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    /* renamed from: a */
    public String m5022a() {
        return this.f4217a;
    }

    /* renamed from: b */
    public int m5023b() {
        return this.f4218b;
    }

    /* renamed from: c */
    public int m5024c() {
        return this.f4219c;
    }
}
