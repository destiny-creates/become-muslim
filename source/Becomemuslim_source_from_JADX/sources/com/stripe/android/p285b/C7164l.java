package com.stripe.android.p285b;

import com.facebook.places.model.PlaceFields;
import com.stripe.android.C5772r;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SourceOwner */
/* renamed from: com.stripe.android.b.l */
public class C7164l extends C5729q {
    /* renamed from: a */
    private C7156a f25383a;
    /* renamed from: b */
    private String f25384b;
    /* renamed from: c */
    private String f25385c;
    /* renamed from: d */
    private String f25386d;
    /* renamed from: e */
    private C7156a f25387e;
    /* renamed from: f */
    private String f25388f;
    /* renamed from: g */
    private String f25389g;
    /* renamed from: h */
    private String f25390h;

    C7164l(C7156a c7156a, String str, String str2, String str3, C7156a c7156a2, String str4, String str5, String str6) {
        this.f25383a = c7156a;
        this.f25384b = str;
        this.f25385c = str2;
        this.f25386d = str3;
        this.f25387e = c7156a2;
        this.f25388f = str4;
        this.f25389g = str5;
        this.f25390h = str6;
    }

    /* renamed from: c */
    public C7156a m33310c() {
        return this.f25383a;
    }

    /* renamed from: d */
    public String m33311d() {
        return this.f25384b;
    }

    /* renamed from: e */
    public String m33312e() {
        return this.f25385c;
    }

    /* renamed from: f */
    public String m33313f() {
        return this.f25386d;
    }

    /* renamed from: g */
    public C7156a m33314g() {
        return this.f25387e;
    }

    /* renamed from: h */
    public String m33315h() {
        return this.f25388f;
    }

    /* renamed from: i */
    public String m33316i() {
        return this.f25389g;
    }

    /* renamed from: j */
    public String m33317j() {
        return this.f25390h;
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map<String, Object> hashMap = new HashMap();
        if (this.f25383a != null) {
            hashMap.put("address", this.f25383a.mo5066b());
        }
        hashMap.put("email", this.f25384b);
        hashMap.put("name", this.f25385c);
        hashMap.put(PlaceFields.PHONE, this.f25386d);
        if (this.f25387e != null) {
            hashMap.put("verified_address", this.f25387e.mo5066b());
        }
        hashMap.put("verified_email", this.f25388f);
        hashMap.put("verified_name", this.f25389g);
        hashMap.put("verified_phone", this.f25390h);
        C5772r.m24411a(hashMap);
        return hashMap;
    }

    /* renamed from: a */
    public org.json.JSONObject mo5065a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = r4.f25383a;
        r2 = 0;
        if (r1 != 0) goto L_0x000c;
    L_0x000a:
        r1 = r2;
        goto L_0x0012;
    L_0x000c:
        r1 = r4.f25383a;
        r1 = r1.mo5065a();
    L_0x0012:
        r3 = r4.f25387e;
        if (r3 != 0) goto L_0x0017;
    L_0x0016:
        goto L_0x001d;
    L_0x0017:
        r2 = r4.f25387e;
        r2 = r2.mo5065a();
    L_0x001d:
        if (r1 == 0) goto L_0x002a;
    L_0x001f:
        r3 = r1.length();	 Catch:{ JSONException -> 0x0061 }
        if (r3 <= 0) goto L_0x002a;	 Catch:{ JSONException -> 0x0061 }
    L_0x0025:
        r3 = "address";	 Catch:{ JSONException -> 0x0061 }
        r0.put(r3, r1);	 Catch:{ JSONException -> 0x0061 }
    L_0x002a:
        r1 = "email";	 Catch:{ JSONException -> 0x0061 }
        r3 = r4.f25384b;	 Catch:{ JSONException -> 0x0061 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r3);	 Catch:{ JSONException -> 0x0061 }
        r1 = "name";	 Catch:{ JSONException -> 0x0061 }
        r3 = r4.f25385c;	 Catch:{ JSONException -> 0x0061 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r3);	 Catch:{ JSONException -> 0x0061 }
        r1 = "phone";	 Catch:{ JSONException -> 0x0061 }
        r3 = r4.f25386d;	 Catch:{ JSONException -> 0x0061 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r3);	 Catch:{ JSONException -> 0x0061 }
        if (r2 == 0) goto L_0x004c;	 Catch:{ JSONException -> 0x0061 }
    L_0x0041:
        r1 = r2.length();	 Catch:{ JSONException -> 0x0061 }
        if (r1 <= 0) goto L_0x004c;	 Catch:{ JSONException -> 0x0061 }
    L_0x0047:
        r1 = "verified_address";	 Catch:{ JSONException -> 0x0061 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0061 }
    L_0x004c:
        r1 = "verified_email";	 Catch:{ JSONException -> 0x0061 }
        r2 = r4.f25388f;	 Catch:{ JSONException -> 0x0061 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r2);	 Catch:{ JSONException -> 0x0061 }
        r1 = "verified_name";	 Catch:{ JSONException -> 0x0061 }
        r2 = r4.f25389g;	 Catch:{ JSONException -> 0x0061 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r2);	 Catch:{ JSONException -> 0x0061 }
        r1 = "verified_phone";	 Catch:{ JSONException -> 0x0061 }
        r2 = r4.f25390h;	 Catch:{ JSONException -> 0x0061 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r2);	 Catch:{ JSONException -> 0x0061 }
    L_0x0061:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.l.a():org.json.JSONObject");
    }

    /* renamed from: a */
    public static C7164l m33307a(JSONObject jSONObject) {
        C5729q c5729q = null;
        if (jSONObject == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("address");
        C7156a a = optJSONObject != null ? C7156a.m33204a(optJSONObject) : null;
        String d = C5730r.m24288d(jSONObject, "email");
        String d2 = C5730r.m24288d(jSONObject, "name");
        String d3 = C5730r.m24288d(jSONObject, PlaceFields.PHONE);
        optJSONObject = jSONObject.optJSONObject("verified_address");
        if (optJSONObject != null) {
            c5729q = C7156a.m33204a(optJSONObject);
        }
        return new C7164l(a, d, d2, d3, c5729q, C5730r.m24288d(jSONObject, "verified_email"), C5730r.m24288d(jSONObject, "verified_name"), C5730r.m24288d(jSONObject, "verified_phone"));
    }
}
