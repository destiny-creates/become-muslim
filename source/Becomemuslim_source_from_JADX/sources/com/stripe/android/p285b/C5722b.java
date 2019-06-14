package com.stripe.android.p285b;

import com.facebook.appevents.UserDataStore;
import org.json.JSONObject;

/* compiled from: BankAccount */
/* renamed from: com.stripe.android.b.b */
public class C5722b {
    /* renamed from: a */
    private String f19048a;
    /* renamed from: b */
    private String f19049b;
    /* renamed from: c */
    private String f19050c;
    /* renamed from: d */
    private String f19051d;
    /* renamed from: e */
    private String f19052e;
    /* renamed from: f */
    private String f19053f;
    /* renamed from: g */
    private String f19054g;
    /* renamed from: h */
    private String f19055h;
    /* renamed from: i */
    private String f19056i;

    public C5722b(String str, String str2, String str3, String str4) {
        this.f19050c = str;
        this.f19052e = str2;
        this.f19053f = str3;
        this.f19056i = str4;
    }

    public C5722b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f19048a = str;
        this.f19049b = str2;
        this.f19051d = str3;
        this.f19052e = str4;
        this.f19053f = str5;
        this.f19054g = str6;
        this.f19055h = str7;
        this.f19056i = str8;
    }

    /* renamed from: a */
    public String m24187a() {
        return this.f19050c;
    }

    /* renamed from: b */
    public String m24189b() {
        return this.f19048a;
    }

    /* renamed from: a */
    public C5722b m24186a(String str) {
        this.f19048a = str;
        return this;
    }

    /* renamed from: c */
    public String m24190c() {
        return this.f19049b;
    }

    /* renamed from: b */
    public C5722b m24188b(String str) {
        this.f19049b = str;
        return this;
    }

    /* renamed from: d */
    public String m24191d() {
        return this.f19051d;
    }

    /* renamed from: e */
    public String m24192e() {
        return this.f19052e;
    }

    /* renamed from: f */
    public String m24193f() {
        return this.f19053f;
    }

    /* renamed from: g */
    public String m24194g() {
        return this.f19054g;
    }

    /* renamed from: h */
    public String m24195h() {
        return this.f19055h;
    }

    /* renamed from: i */
    public String m24196i() {
        return this.f19056i;
    }

    /* renamed from: c */
    public static String m24185c(String str) {
        if ("company".equals(str)) {
            return "company";
        }
        return "individual".equals(str) != null ? "individual" : null;
    }

    /* renamed from: a */
    public static C5722b m24184a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new C5722b(C5730r.m24288d(jSONObject, "account_holder_name"), C5722b.m24185c(C5730r.m24288d(jSONObject, "account_holder_type")), C5730r.m24288d(jSONObject, "bank_name"), C5730r.m24289e(jSONObject, UserDataStore.COUNTRY), C5730r.m24290f(jSONObject, "currency"), C5730r.m24288d(jSONObject, "fingerprint"), C5730r.m24288d(jSONObject, "last4"), C5730r.m24288d(jSONObject, "routing_number"));
    }
}
