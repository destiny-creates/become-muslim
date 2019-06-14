package com.stripe.android.p285b;

import com.facebook.appevents.UserDataStore;
import com.facebook.internal.ServerProtocol;
import com.stripe.android.C5772r;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SourceParams */
/* renamed from: com.stripe.android.b.m */
public class C5728m {
    /* renamed from: a */
    private Long f19080a;
    /* renamed from: b */
    private Map<String, Object> f19081b;
    /* renamed from: c */
    private String f19082c;
    /* renamed from: d */
    private String f19083d;
    /* renamed from: e */
    private Map<String, Object> f19084e;
    /* renamed from: f */
    private Map<String, String> f19085f;
    /* renamed from: g */
    private Map<String, Object> f19086g;
    /* renamed from: h */
    private String f19087h;
    /* renamed from: i */
    private String f19088i;
    /* renamed from: j */
    private String f19089j;

    private C5728m() {
    }

    /* renamed from: a */
    public static C5728m m24250a(long j, String str, String str2, String str3, String str4) {
        j = new C5728m().m24266c("alipay").m24263b(str).m24260a(j).m24267c(C5728m.m24254a("return_url", str4));
        Map hashMap = new HashMap();
        hashMap.put("name", str2);
        hashMap.put("email", str3);
        C5772r.m24411a(hashMap);
        if (hashMap.keySet().size() > null) {
            j.m24264b(hashMap);
        }
        return j;
    }

    /* renamed from: a */
    public static C5728m m24249a(long j, String str, String str2, String str3) {
        j = new C5728m().m24266c("bancontact").m24263b("eur").m24260a(j).m24264b(C5728m.m24254a("name", str)).m24267c(C5728m.m24254a("return_url", str2));
        if (str3 != null) {
            j.m24261a(C5728m.m24254a("statement_descriptor", str3));
        }
        return j;
    }

    /* renamed from: a */
    public static C5728m m24248a(long j, String str, String str2) {
        return new C5728m().m24266c("bitcoin").m24260a(j).m24263b(str).m24264b(C5728m.m24254a("email", str2));
    }

    /* renamed from: a */
    public static C5728m m24251a(C7157c c7157c) {
        C5728m c = new C5728m().m24266c("card");
        Map hashMap = new HashMap();
        hashMap.put("number", c7157c.m33227g());
        hashMap.put("exp_month", c7157c.m33230j());
        hashMap.put("exp_year", c7157c.m33231k());
        hashMap.put("cvc", c7157c.m33229i());
        C5772r.m24411a(hashMap);
        c.m24261a(hashMap);
        hashMap = new HashMap();
        hashMap.put("line1", c7157c.m33233m());
        hashMap.put("line2", c7157c.m33234n());
        hashMap.put("city", c7157c.m33235o());
        hashMap.put(UserDataStore.COUNTRY, c7157c.m33238r());
        hashMap.put(ServerProtocol.DIALOG_PARAM_STATE, c7157c.m33237q());
        hashMap.put("postal_code", c7157c.m33236p());
        C5772r.m24411a(hashMap);
        Map hashMap2 = new HashMap();
        hashMap2.put("name", c7157c.m33232l());
        if (hashMap.keySet().size() > null) {
            hashMap2.put("address", hashMap);
        }
        C5772r.m24411a(hashMap2);
        if (hashMap2.keySet().size() > null) {
            c.m24264b(hashMap2);
        }
        return c;
    }

    /* renamed from: b */
    public static C5728m m24256b(long j, String str, String str2, String str3) {
        j = new C5728m().m24266c("giropay").m24263b("eur").m24260a(j).m24264b(C5728m.m24254a("name", str)).m24267c(C5728m.m24254a("return_url", str2));
        if (str3 != null) {
            j.m24261a(C5728m.m24254a("statement_descriptor", str3));
        }
        return j;
    }

    /* renamed from: b */
    public static C5728m m24257b(long j, String str, String str2, String str3, String str4) {
        j = new C5728m().m24266c("ideal").m24263b("eur").m24260a(j).m24264b(C5728m.m24254a("name", str)).m24267c(C5728m.m24254a("return_url", str2));
        if (!(str3 == null || str4 == null)) {
            j.m24261a(C5728m.m24255a("statement_descriptor", (Object) str3, "bank", (Object) str4));
        }
        return j;
    }

    /* renamed from: a */
    public static C5728m m24252a(String str, String str2, String str3, String str4, String str5, String str6) {
        C5728m b = new C5728m().m24266c("sepa_debit").m24263b("eur");
        Map hashMap = new HashMap();
        hashMap.put("line1", str3);
        hashMap.put("city", str4);
        hashMap.put("postal_code", str5);
        hashMap.put(UserDataStore.COUNTRY, str6);
        Map hashMap2 = new HashMap();
        hashMap2.put("name", str);
        hashMap2.put("address", hashMap);
        b.m24264b(hashMap2).m24261a(C5728m.m24254a("iban", str2));
        return b;
    }

    /* renamed from: c */
    public static C5728m m24258c(long j, String str, String str2, String str3) {
        j = new C5728m().m24266c("sofort").m24263b("eur").m24260a(j).m24267c(C5728m.m24254a("return_url", str));
        Map a = C5728m.m24254a(UserDataStore.COUNTRY, str2);
        if (str3 != null) {
            a.put("statement_descriptor", str3);
        }
        j.m24261a(a);
        return j;
    }

    /* renamed from: d */
    public static C5728m m24259d(long j, String str, String str2, String str3) {
        j = new C5728m().m24266c("three_d_secure").m24263b(str).m24260a(j).m24267c(C5728m.m24254a("return_url", str2));
        j.m24261a(C5728m.m24254a("card", str3));
        return j;
    }

    /* renamed from: a */
    public static Map<String, Object> m24253a(String str) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("client_secret", str);
        return hashMap;
    }

    /* renamed from: a */
    public String m24262a() {
        return this.f19089j;
    }

    /* renamed from: a */
    public C5728m m24260a(long j) {
        this.f19080a = Long.valueOf(j);
        return this;
    }

    /* renamed from: a */
    public C5728m m24261a(Map<String, Object> map) {
        this.f19081b = map;
        return this;
    }

    /* renamed from: b */
    public C5728m m24263b(String str) {
        this.f19082c = str;
        return this;
    }

    /* renamed from: b */
    public C5728m m24264b(Map<String, Object> map) {
        this.f19084e = map;
        return this;
    }

    /* renamed from: c */
    public C5728m m24267c(Map<String, Object> map) {
        this.f19086g = map;
        return this;
    }

    /* renamed from: c */
    public C5728m m24266c(String str) {
        this.f19089j = str;
        this.f19083d = str;
        return this;
    }

    /* renamed from: b */
    public Map<String, Object> m24265b() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("type", this.f19083d);
        hashMap.put(this.f19083d, this.f19081b);
        hashMap.put("amount", this.f19080a);
        hashMap.put("currency", this.f19082c);
        hashMap.put("owner", this.f19084e);
        hashMap.put("redirect", this.f19086g);
        hashMap.put("metadata", this.f19085f);
        hashMap.put("token", this.f19087h);
        hashMap.put("usage", this.f19088i);
        C5772r.m24411a(hashMap);
        return hashMap;
    }

    /* renamed from: a */
    private static Map<String, Object> m24254a(String str, Object obj) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put(str, obj);
        return hashMap;
    }

    /* renamed from: a */
    private static Map<String, Object> m24255a(String str, Object obj, String str2, Object obj2) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put(str, obj);
        hashMap.put(str2, obj2);
        return hashMap;
    }
}
