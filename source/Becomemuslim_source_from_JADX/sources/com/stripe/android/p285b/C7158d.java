package com.stripe.android.p285b;

import com.stripe.android.C5772r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Customer */
/* renamed from: com.stripe.android.b.d */
public class C7158d extends C5729q {
    /* renamed from: a */
    private String f25346a;
    /* renamed from: b */
    private String f25347b;
    /* renamed from: c */
    private C7160g f25348c;
    /* renamed from: d */
    private List<C7159e> f25349d = new ArrayList();
    /* renamed from: e */
    private Boolean f25350e;
    /* renamed from: f */
    private Integer f25351f;
    /* renamed from: g */
    private String f25352g;

    private C7158d() {
    }

    /* renamed from: c */
    public String m33252c() {
        return this.f25347b;
    }

    /* renamed from: d */
    public List<C7159e> m33253d() {
        return this.f25349d;
    }

    /* renamed from: a */
    public C7159e m33249a(String str) {
        for (C7159e c7159e : this.f25349d) {
            if (str.equals(c7159e.mo5067y())) {
                return c7159e;
            }
        }
        return null;
    }

    /* renamed from: a */
    public JSONObject mo5065a() {
        JSONObject jSONObject = new JSONObject();
        C5730r.m24283a(jSONObject, "id", this.f25346a);
        C5730r.m24283a(jSONObject, "object", "customer");
        C5730r.m24283a(jSONObject, "default_source", this.f25347b);
        C5729q.m24270a(jSONObject, "shipping", this.f25348c);
        JSONObject jSONObject2 = new JSONObject();
        C5730r.m24283a(jSONObject2, "object", "list");
        C5730r.m24280a(jSONObject2, "has_more", this.f25350e);
        C5730r.m24281a(jSONObject2, "total_count", this.f25351f);
        C5729q.m24271a(jSONObject2, "data", this.f25349d);
        C5730r.m24283a(jSONObject2, "url", this.f25352g);
        C5730r.m24284a(jSONObject, "sources", jSONObject2);
        return jSONObject;
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map hashMap = new HashMap();
        hashMap.put("id", this.f25346a);
        hashMap.put("object", "customer");
        hashMap.put("default_source", this.f25347b);
        C5729q.m24268a(hashMap, "shipping", this.f25348c);
        Map hashMap2 = new HashMap();
        hashMap2.put("has_more", this.f25350e);
        hashMap2.put("total_count", this.f25351f);
        hashMap2.put("object", "list");
        hashMap2.put("url", this.f25352g);
        C5729q.m24269a(hashMap2, "data", this.f25349d);
        C5772r.m24411a(hashMap2);
        hashMap.put("sources", hashMap2);
        C5772r.m24411a(hashMap);
        return hashMap;
    }

    /* renamed from: b */
    public static com.stripe.android.p285b.C7158d m33248b(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r2 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x000e }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x000e }
        r2 = com.stripe.android.p285b.C7158d.m33247a(r1);	 Catch:{ JSONException -> 0x000e }
        return r2;
    L_0x000e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.d.b(java.lang.String):com.stripe.android.b.d");
    }

    /* renamed from: a */
    public static com.stripe.android.p285b.C7158d m33247a(org.json.JSONObject r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "object";
        r0 = com.stripe.android.p285b.C5730r.m24288d(r6, r0);
        r1 = "customer";
        r0 = r1.equals(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        r6 = 0;
        return r6;
    L_0x0010:
        r0 = new com.stripe.android.b.d;
        r0.<init>();
        r1 = "id";
        r1 = com.stripe.android.p285b.C5730r.m24288d(r6, r1);
        r0.f25346a = r1;
        r1 = "default_source";
        r1 = com.stripe.android.p285b.C5730r.m24288d(r6, r1);
        r0.f25347b = r1;
        r1 = "shipping";
        r1 = r6.optJSONObject(r1);
        r1 = com.stripe.android.p285b.C7160g.m33262a(r1);
        r0.f25348c = r1;
        r1 = "sources";
        r6 = r6.optJSONObject(r1);
        if (r6 == 0) goto L_0x0090;
    L_0x0039:
        r1 = "list";
        r2 = "object";
        r2 = com.stripe.android.p285b.C5730r.m24288d(r6, r2);
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0090;
    L_0x0047:
        r1 = "has_more";
        r1 = com.stripe.android.p285b.C5730r.m24274a(r6, r1);
        r0.f25350e = r1;
        r1 = "total_count";
        r1 = com.stripe.android.p285b.C5730r.m24285b(r6, r1);
        r0.f25351f = r1;
        r1 = "url";
        r1 = com.stripe.android.p285b.C5730r.m24288d(r6, r1);
        r0.f25352g = r1;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = "data";
        r6 = r6.optJSONArray(r2);
        r2 = 0;
    L_0x006b:
        r3 = r6.length();
        if (r2 >= r3) goto L_0x008e;
    L_0x0071:
        r3 = r6.getJSONObject(r2);	 Catch:{ JSONException -> 0x008b }
        r3 = com.stripe.android.p285b.C7159e.m33254a(r3);	 Catch:{ JSONException -> 0x008b }
        if (r3 == 0) goto L_0x008b;	 Catch:{ JSONException -> 0x008b }
    L_0x007b:
        r4 = "apple_pay";	 Catch:{ JSONException -> 0x008b }
        r5 = r3.m33258d();	 Catch:{ JSONException -> 0x008b }
        r4 = r4.equals(r5);	 Catch:{ JSONException -> 0x008b }
        if (r4 == 0) goto L_0x0088;	 Catch:{ JSONException -> 0x008b }
    L_0x0087:
        goto L_0x008b;	 Catch:{ JSONException -> 0x008b }
    L_0x0088:
        r1.add(r3);	 Catch:{ JSONException -> 0x008b }
    L_0x008b:
        r2 = r2 + 1;
        goto L_0x006b;
    L_0x008e:
        r0.f25349d = r1;
    L_0x0090:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.d.a(org.json.JSONObject):com.stripe.android.b.d");
    }
}
