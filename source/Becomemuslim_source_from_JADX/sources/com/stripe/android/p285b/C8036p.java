package com.stripe.android.p285b;

import com.facebook.appevents.UserDataStore;
import com.stripe.android.C5772r;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SourceSepaDebitData */
/* renamed from: com.stripe.android.b.p */
public class C8036p extends C7167t {
    /* renamed from: c */
    private String f29827c;
    /* renamed from: d */
    private String f29828d;
    /* renamed from: e */
    private String f29829e;
    /* renamed from: f */
    private String f29830f;
    /* renamed from: g */
    private String f29831g;
    /* renamed from: h */
    private String f29832h;
    /* renamed from: i */
    private String f29833i;

    private C8036p() {
        m33336a("bank_code", "branch_code", UserDataStore.COUNTRY, "fingerprint", "last4", "mandate_reference", "mandate_url");
    }

    /* renamed from: a */
    public static C8036p m38949a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C8036p c8036p = new C8036p();
        c8036p.m38948a(C5730r.m24288d(jSONObject, "bank_code")).m38950b(C5730r.m24288d(jSONObject, "branch_code")).m38951c(C5730r.m24288d(jSONObject, UserDataStore.COUNTRY)).m38952d(C5730r.m24288d(jSONObject, "fingerprint")).m38953e(C5730r.m24288d(jSONObject, "last4")).m38954f(C5730r.m24288d(jSONObject, "mandate_reference")).m38955g(C5730r.m24288d(jSONObject, "mandate_url"));
        jSONObject = C7167t.m33332a(jSONObject, c8036p.b);
        if (jSONObject != null) {
            c8036p.m33335a((Map) jSONObject);
        }
        return c8036p;
    }

    /* renamed from: a */
    public JSONObject mo5065a() {
        JSONObject jSONObject = new JSONObject();
        C5730r.m24283a(jSONObject, "bank_code", this.f29827c);
        C5730r.m24283a(jSONObject, "branch_code", this.f29828d);
        C5730r.m24283a(jSONObject, UserDataStore.COUNTRY, this.f29829e);
        C5730r.m24283a(jSONObject, "fingerprint", this.f29830f);
        C5730r.m24283a(jSONObject, "last4", this.f29831g);
        C5730r.m24283a(jSONObject, "mandate_reference", this.f29832h);
        C5730r.m24283a(jSONObject, "mandate_url", this.f29833i);
        C7167t.m33334a(jSONObject, this.a);
        return jSONObject;
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("bank_code", this.f29827c);
        hashMap.put("branch_code", this.f29828d);
        hashMap.put(UserDataStore.COUNTRY, this.f29829e);
        hashMap.put("fingerprint", this.f29830f);
        hashMap.put("last4", this.f29831g);
        hashMap.put("mandate_reference", this.f29832h);
        hashMap.put("mandate_url", this.f29833i);
        C7167t.m33333a((Map) hashMap, this.a);
        C5772r.m24411a(hashMap);
        return hashMap;
    }

    /* renamed from: a */
    private C8036p m38948a(String str) {
        this.f29827c = str;
        return this;
    }

    /* renamed from: b */
    private C8036p m38950b(String str) {
        this.f29828d = str;
        return this;
    }

    /* renamed from: c */
    private C8036p m38951c(String str) {
        this.f29829e = str;
        return this;
    }

    /* renamed from: d */
    private C8036p m38952d(String str) {
        this.f29830f = str;
        return this;
    }

    /* renamed from: e */
    private C8036p m38953e(String str) {
        this.f29831g = str;
        return this;
    }

    /* renamed from: f */
    private C8036p m38954f(String str) {
        this.f29832h = str;
        return this;
    }

    /* renamed from: g */
    private C8036p m38955g(String str) {
        this.f29833i = str;
        return this;
    }
}
