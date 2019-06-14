package com.stripe.android.p285b;

import com.facebook.appevents.UserDataStore;
import com.stripe.android.C5772r;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SourceCardData */
/* renamed from: com.stripe.android.b.j */
public class C8035j extends C7167t {
    /* renamed from: c */
    private String f29815c;
    /* renamed from: d */
    private String f29816d;
    /* renamed from: e */
    private String f29817e;
    /* renamed from: f */
    private String f29818f;
    /* renamed from: g */
    private String f29819g;
    /* renamed from: h */
    private String f29820h;
    /* renamed from: i */
    private Integer f29821i;
    /* renamed from: j */
    private Integer f29822j;
    /* renamed from: k */
    private String f29823k;
    /* renamed from: l */
    private String f29824l;
    /* renamed from: m */
    private String f29825m;
    /* renamed from: n */
    private String f29826n;

    private C8035j() {
        m33336a("address_line1_check", "address_zip_check", "brand", UserDataStore.COUNTRY, "cvc_check", "dynamic_last4", "exp_month", "exp_year", "funding", "last4", "three_d_secure", "tokenization_method");
    }

    /* renamed from: c */
    public String m38945c() {
        return this.f29817e;
    }

    /* renamed from: d */
    public String m38946d() {
        return this.f29824l;
    }

    /* renamed from: e */
    public String m38947e() {
        return this.f29826n;
    }

    /* renamed from: a */
    public JSONObject mo5065a() {
        JSONObject jSONObject = new JSONObject();
        C5730r.m24283a(jSONObject, "address_line1_check", this.f29815c);
        C5730r.m24283a(jSONObject, "address_zip_check", this.f29816d);
        C5730r.m24283a(jSONObject, "brand", this.f29817e);
        C5730r.m24283a(jSONObject, UserDataStore.COUNTRY, this.f29818f);
        C5730r.m24283a(jSONObject, "dynamic_last4", this.f29820h);
        C5730r.m24281a(jSONObject, "exp_month", this.f29821i);
        C5730r.m24281a(jSONObject, "exp_year", this.f29822j);
        C5730r.m24283a(jSONObject, "funding", this.f29823k);
        C5730r.m24283a(jSONObject, "last4", this.f29824l);
        C5730r.m24283a(jSONObject, "three_d_secure", this.f29825m);
        C5730r.m24283a(jSONObject, "tokenization_method", this.f29826n);
        C7167t.m33334a(jSONObject, this.a);
        return jSONObject;
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("address_line1_check", this.f29815c);
        hashMap.put("address_zip_check", this.f29816d);
        hashMap.put("brand", this.f29817e);
        hashMap.put(UserDataStore.COUNTRY, this.f29818f);
        hashMap.put("dynamic_last4", this.f29820h);
        hashMap.put("exp_month", this.f29821i);
        hashMap.put("exp_year", this.f29822j);
        hashMap.put("funding", this.f29823k);
        hashMap.put("last4", this.f29824l);
        hashMap.put("three_d_secure", this.f29825m);
        hashMap.put("tokenization_method", this.f29826n);
        C7167t.m33333a((Map) hashMap, this.a);
        C5772r.m24411a(hashMap);
        return hashMap;
    }

    /* renamed from: b */
    private C8035j m38933b(String str) {
        this.f29815c = str;
        return this;
    }

    /* renamed from: c */
    private C8035j m38934c(String str) {
        this.f29816d = str;
        return this;
    }

    /* renamed from: d */
    private C8035j m38935d(String str) {
        this.f29817e = str;
        return this;
    }

    /* renamed from: e */
    private C8035j m38936e(String str) {
        this.f29818f = str;
        return this;
    }

    /* renamed from: f */
    private C8035j m38937f(String str) {
        this.f29819g = str;
        return this;
    }

    /* renamed from: g */
    private C8035j m38938g(String str) {
        this.f29820h = str;
        return this;
    }

    /* renamed from: a */
    private C8035j m38929a(Integer num) {
        this.f29821i = num;
        return this;
    }

    /* renamed from: b */
    private C8035j m38932b(Integer num) {
        this.f29822j = num;
        return this;
    }

    /* renamed from: h */
    private C8035j m38939h(String str) {
        this.f29823k = str;
        return this;
    }

    /* renamed from: i */
    private C8035j m38940i(String str) {
        this.f29824l = str;
        return this;
    }

    /* renamed from: j */
    private C8035j m38941j(String str) {
        this.f29825m = str;
        return this;
    }

    /* renamed from: k */
    private C8035j m38942k(String str) {
        this.f29826n = str;
        return this;
    }

    /* renamed from: a */
    static C8035j m38930a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C8035j c8035j = new C8035j();
        c8035j.m38933b(C5730r.m24288d(jSONObject, "address_line1_check")).m38934c(C5730r.m24288d(jSONObject, "address_zip_check")).m38935d(C7157c.m33214a(C5730r.m24288d(jSONObject, "brand"))).m38936e(C5730r.m24288d(jSONObject, UserDataStore.COUNTRY)).m38937f(C5730r.m24288d(jSONObject, "cvc_check")).m38938g(C5730r.m24288d(jSONObject, "dynamic_last4")).m38929a(C5730r.m24285b(jSONObject, "exp_month")).m38932b(C5730r.m24285b(jSONObject, "exp_year")).m38939h(C7157c.m33215b(C5730r.m24288d(jSONObject, "funding"))).m38940i(C5730r.m24288d(jSONObject, "last4")).m38941j(C8035j.m38931a(C5730r.m24288d(jSONObject, "three_d_secure"))).m38942k(C5730r.m24288d(jSONObject, "tokenization_method"));
        jSONObject = C7167t.m33332a(jSONObject, c8035j.b);
        if (jSONObject != null) {
            c8035j.m33335a((Map) jSONObject);
        }
        return c8035j;
    }

    /* renamed from: a */
    static String m38931a(String str) {
        if (C5730r.m24275a(str) == null) {
            return null;
        }
        if ("required".equalsIgnoreCase(str)) {
            return "required";
        }
        if ("optional".equalsIgnoreCase(str)) {
            return "optional";
        }
        return "not_supported".equalsIgnoreCase(str) != null ? "not_supported" : "unknown";
    }
}
