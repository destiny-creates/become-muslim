package com.stripe.android.p285b;

import com.stripe.android.C5775u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SourceReceiver */
/* renamed from: com.stripe.android.b.n */
public class C7165n extends C5729q {
    /* renamed from: a */
    private String f25391a;
    /* renamed from: b */
    private long f25392b;
    /* renamed from: c */
    private long f25393c;
    /* renamed from: d */
    private long f25394d;

    C7165n(String str, long j, long j2, long j3) {
        this.f25391a = str;
        this.f25392b = j;
        this.f25393c = j2;
        this.f25394d = j3;
    }

    /* renamed from: c */
    public String m33321c() {
        return this.f25391a;
    }

    /* renamed from: d */
    public long m33322d() {
        return this.f25392b;
    }

    /* renamed from: e */
    public long m33323e() {
        return this.f25393c;
    }

    /* renamed from: f */
    public long m33324f() {
        return this.f25394d;
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map<String, Object> hashMap = new HashMap();
        if (!C5775u.m24419b(this.f25391a)) {
            hashMap.put("address", this.f25391a);
        }
        hashMap.put("address", this.f25391a);
        hashMap.put("amount_charged", Long.valueOf(this.f25392b));
        hashMap.put("amount_received", Long.valueOf(this.f25393c));
        hashMap.put("amount_returned", Long.valueOf(this.f25394d));
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
        r1 = "address";
        r2 = r4.f25391a;
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r2);
        r1 = "amount_charged";	 Catch:{ JSONException -> 0x0022 }
        r2 = r4.f25392b;	 Catch:{ JSONException -> 0x0022 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0022 }
        r1 = "amount_received";	 Catch:{ JSONException -> 0x0022 }
        r2 = r4.f25393c;	 Catch:{ JSONException -> 0x0022 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0022 }
        r1 = "amount_returned";	 Catch:{ JSONException -> 0x0022 }
        r2 = r4.f25394d;	 Catch:{ JSONException -> 0x0022 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0022 }
        return r0;
    L_0x0022:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.n.a():org.json.JSONObject");
    }

    /* renamed from: a */
    public static C7165n m33318a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new C7165n(C5730r.m24288d(jSONObject, "address"), jSONObject.optLong("amount_charged"), jSONObject.optLong("amount_received"), jSONObject.optLong("amount_returned"));
    }
}
