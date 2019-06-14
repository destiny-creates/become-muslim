package com.stripe.android.p285b;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import com.stripe.android.C5772r;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: Source */
/* renamed from: com.stripe.android.b.i */
public class C7162i extends C5729q implements C5731s {
    /* renamed from: a */
    public static final Set<String> f25362a = new HashSet();
    /* renamed from: b */
    private String f25363b;
    /* renamed from: c */
    private Long f25364c;
    /* renamed from: d */
    private String f25365d;
    /* renamed from: e */
    private C7163k f25366e;
    /* renamed from: f */
    private Long f25367f;
    /* renamed from: g */
    private String f25368g;
    /* renamed from: h */
    private String f25369h;
    /* renamed from: i */
    private String f25370i;
    /* renamed from: j */
    private Boolean f25371j;
    /* renamed from: k */
    private Map<String, String> f25372k;
    /* renamed from: l */
    private C7164l f25373l;
    /* renamed from: m */
    private C7165n f25374m;
    /* renamed from: n */
    private C7166o f25375n;
    /* renamed from: o */
    private String f25376o;
    /* renamed from: p */
    private Map<String, Object> f25377p;
    /* renamed from: q */
    private C7167t f25378q;
    /* renamed from: r */
    private String f25379r;
    /* renamed from: s */
    private String f25380s;

    static {
        f25362a.add("card");
        f25362a.add("sepa_debit");
    }

    C7162i(String str, Long l, String str2, C7163k c7163k, Long l2, String str3, String str4, Boolean bool, Map<String, String> map, C7164l c7164l, C7165n c7165n, C7166o c7166o, String str5, Map<String, Object> map2, C7167t c7167t, String str6, String str7, String str8) {
        this.f25363b = str;
        this.f25364c = l;
        this.f25365d = str2;
        this.f25366e = c7163k;
        this.f25367f = l2;
        this.f25368g = str3;
        this.f25370i = str4;
        this.f25371j = bool;
        this.f25372k = map;
        this.f25373l = c7164l;
        this.f25374m = c7165n;
        this.f25375n = c7166o;
        this.f25376o = str5;
        this.f25377p = map2;
        this.f25378q = c7167t;
        this.f25379r = str6;
        this.f25369h = str7;
        this.f25380s = str8;
    }

    /* renamed from: y */
    public String mo5067y() {
        return this.f25363b;
    }

    /* renamed from: c */
    public Long m33283c() {
        return this.f25364c;
    }

    /* renamed from: d */
    public String m33284d() {
        return this.f25365d;
    }

    /* renamed from: e */
    public C7163k m33285e() {
        return this.f25366e;
    }

    /* renamed from: f */
    public Long m33286f() {
        return this.f25367f;
    }

    /* renamed from: g */
    public String m33287g() {
        return this.f25368g;
    }

    /* renamed from: h */
    public String m33288h() {
        return this.f25370i;
    }

    /* renamed from: i */
    public Boolean m33289i() {
        return this.f25371j;
    }

    /* renamed from: j */
    public Map<String, String> m33290j() {
        return this.f25372k;
    }

    /* renamed from: k */
    public C7164l m33291k() {
        return this.f25373l;
    }

    /* renamed from: l */
    public C7165n m33292l() {
        return this.f25374m;
    }

    /* renamed from: m */
    public C7166o m33293m() {
        return this.f25375n;
    }

    /* renamed from: n */
    public String m33294n() {
        return this.f25376o;
    }

    /* renamed from: o */
    public Map<String, Object> m33295o() {
        return this.f25377p;
    }

    /* renamed from: p */
    public C7167t m33296p() {
        return this.f25378q;
    }

    /* renamed from: q */
    public String m33297q() {
        return this.f25379r;
    }

    /* renamed from: r */
    public String m33298r() {
        return this.f25369h;
    }

    /* renamed from: s */
    public String m33299s() {
        return this.f25380s;
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("id", this.f25363b);
        hashMap.put("amount", this.f25364c);
        hashMap.put("client_secret", this.f25365d);
        C5729q.m24268a((Map) hashMap, "code_verification", this.f25366e);
        hashMap.put("created", this.f25367f);
        hashMap.put("currency", this.f25368g);
        hashMap.put("flow", this.f25370i);
        hashMap.put("livemode", this.f25371j);
        hashMap.put("metadata", this.f25372k);
        C5729q.m24268a((Map) hashMap, "owner", this.f25373l);
        C5729q.m24268a((Map) hashMap, "receiver", this.f25374m);
        C5729q.m24268a((Map) hashMap, "redirect", this.f25375n);
        hashMap.put(this.f25369h, this.f25377p);
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.f25376o);
        hashMap.put("type", this.f25369h);
        hashMap.put("usage", this.f25380s);
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
        r3 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "id";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25363b;	 Catch:{ JSONException -> 0x0088 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "object";	 Catch:{ JSONException -> 0x0088 }
        r2 = "source";	 Catch:{ JSONException -> 0x0088 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "amount";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25364c;	 Catch:{ JSONException -> 0x0088 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "client_secret";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25365d;	 Catch:{ JSONException -> 0x0088 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "code_verification";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25366e;	 Catch:{ JSONException -> 0x0088 }
        com.stripe.android.p285b.C5729q.m24270a(r0, r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "created";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25367f;	 Catch:{ JSONException -> 0x0088 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "currency";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25368g;	 Catch:{ JSONException -> 0x0088 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "flow";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25370i;	 Catch:{ JSONException -> 0x0088 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "livemode";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25371j;	 Catch:{ JSONException -> 0x0088 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = r3.f25372k;	 Catch:{ JSONException -> 0x0088 }
        r1 = com.stripe.android.p285b.C5730r.m24279a(r1);	 Catch:{ JSONException -> 0x0088 }
        if (r1 == 0) goto L_0x0051;	 Catch:{ JSONException -> 0x0088 }
    L_0x004c:
        r2 = "metadata";	 Catch:{ JSONException -> 0x0088 }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x0088 }
    L_0x0051:
        r1 = r3.f25377p;	 Catch:{ JSONException -> 0x0088 }
        r1 = com.stripe.android.p285b.C5730r.m24279a(r1);	 Catch:{ JSONException -> 0x0088 }
        if (r1 == 0) goto L_0x005e;	 Catch:{ JSONException -> 0x0088 }
    L_0x0059:
        r2 = r3.f25369h;	 Catch:{ JSONException -> 0x0088 }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x0088 }
    L_0x005e:
        r1 = "owner";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25373l;	 Catch:{ JSONException -> 0x0088 }
        com.stripe.android.p285b.C5729q.m24270a(r0, r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "receiver";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25374m;	 Catch:{ JSONException -> 0x0088 }
        com.stripe.android.p285b.C5729q.m24270a(r0, r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "redirect";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25375n;	 Catch:{ JSONException -> 0x0088 }
        com.stripe.android.p285b.C5729q.m24270a(r0, r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "status";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25376o;	 Catch:{ JSONException -> 0x0088 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "type";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25369h;	 Catch:{ JSONException -> 0x0088 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r2);	 Catch:{ JSONException -> 0x0088 }
        r1 = "usage";	 Catch:{ JSONException -> 0x0088 }
        r2 = r3.f25380s;	 Catch:{ JSONException -> 0x0088 }
        com.stripe.android.p285b.C5730r.m24283a(r0, r1, r2);	 Catch:{ JSONException -> 0x0088 }
    L_0x0088:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.i.a():org.json.JSONObject");
    }

    /* renamed from: a */
    public static com.stripe.android.p285b.C7162i m33274a(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x000a }
        r0.<init>(r1);	 Catch:{ JSONException -> 0x000a }
        r1 = com.stripe.android.p285b.C7162i.m33275a(r0);	 Catch:{ JSONException -> 0x000a }
        return r1;
    L_0x000a:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.i.a(java.lang.String):com.stripe.android.b.i");
    }

    /* renamed from: a */
    public static C7162i m33275a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        C5729q c5729q = null;
        if (jSONObject2 != null) {
            if (ShareConstants.FEED_SOURCE_PARAM.equals(jSONObject2.optString("object"))) {
                String d = C5730r.m24288d(jSONObject2, "id");
                Long c = C5730r.m24287c(jSONObject2, "amount");
                String d2 = C5730r.m24288d(jSONObject2, "client_secret");
                C7163k c7163k = (C7163k) C7162i.m33276a(jSONObject2, "code_verification", C7163k.class);
                Long c2 = C5730r.m24287c(jSONObject2, "created");
                String d3 = C5730r.m24288d(jSONObject2, "currency");
                String e = C7162i.m33280e(C5730r.m24288d(jSONObject2, "flow"));
                Boolean valueOf = Boolean.valueOf(jSONObject2.optBoolean("livemode"));
                Map b = C5730r.m24286b(jSONObject2.optJSONObject("metadata"));
                C7164l c7164l = (C7164l) C7162i.m33276a(jSONObject2, "owner", C7164l.class);
                C7165n c7165n = (C7165n) C7162i.m33276a(jSONObject2, "receiver", C7165n.class);
                C7166o c7166o = (C7166o) C7162i.m33276a(jSONObject2, "redirect", C7166o.class);
                String b2 = C7162i.m33277b(C5730r.m24288d(jSONObject2, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS));
                String d4 = C5730r.m24288d(jSONObject2, "type");
                if (d4 == null) {
                    d4 = "unknown";
                }
                String c3 = C7162i.m33278c(d4);
                if (c3 == null) {
                    c3 = "unknown";
                }
                String str = c3;
                Map a = C5730r.m24277a(jSONObject2.optJSONObject(d4));
                if (f25362a.contains(d4)) {
                    c5729q = (C7167t) C7162i.m33276a(jSONObject2, d4, C7167t.class);
                }
                return new C7162i(d, c, d2, c7163k, c2, d3, e, valueOf, b, c7164l, c7165n, c7166o, b2, a, c5729q, str, d4, C7162i.m33279d(C5730r.m24288d(jSONObject2, "usage")));
            }
        }
        return null;
    }

    /* renamed from: a */
    static <T extends C5729q> T m33276a(JSONObject jSONObject, String str, Class<T> cls) {
        if (!jSONObject.has(str)) {
            return null;
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case -808719889:
                if (str.equals("receiver") != null) {
                    obj = 2;
                    break;
                }
                break;
            case -776144932:
                if (str.equals("redirect") != null) {
                    obj = 3;
                    break;
                }
                break;
            case 3046160:
                if (str.equals("card") != null) {
                    obj = 4;
                    break;
                }
                break;
            case 106164915:
                if (str.equals("owner") != null) {
                    obj = 1;
                    break;
                }
                break;
            case 1615551277:
                if (str.equals("code_verification") != null) {
                    obj = null;
                    break;
                }
                break;
            case 1636477296:
                if (str.equals("sepa_debit") != null) {
                    obj = 5;
                    break;
                }
                break;
            default:
                break;
        }
        switch (obj) {
            case null:
                return (C5729q) cls.cast(C7163k.m33301a(jSONObject.optJSONObject("code_verification")));
            case 1:
                return (C5729q) cls.cast(C7164l.m33307a(jSONObject.optJSONObject("owner")));
            case 2:
                return (C5729q) cls.cast(C7165n.m33318a(jSONObject.optJSONObject("receiver")));
            case 3:
                return (C5729q) cls.cast(C7166o.m33325a(jSONObject.optJSONObject("redirect")));
            case 4:
                return (C5729q) cls.cast(C8035j.m38930a(jSONObject.optJSONObject("card")));
            case 5:
                return (C5729q) cls.cast(C8036p.m38949a(jSONObject.optJSONObject("sepa_debit")));
            default:
                return null;
        }
    }

    /* renamed from: b */
    static String m33277b(String str) {
        if ("pending".equals(str)) {
            return "pending";
        }
        if ("chargeable".equals(str)) {
            return "chargeable";
        }
        if ("consumed".equals(str)) {
            return "consumed";
        }
        if ("canceled".equals(str)) {
            return "canceled";
        }
        return "failed".equals(str) != null ? "failed" : null;
    }

    /* renamed from: c */
    static String m33278c(String str) {
        if ("bitcoin".equals(str)) {
            return "bitcoin";
        }
        if ("card".equals(str)) {
            return "card";
        }
        if ("three_d_secure".equals(str)) {
            return "three_d_secure";
        }
        if ("giropay".equals(str)) {
            return "giropay";
        }
        if ("sepa_debit".equals(str)) {
            return "sepa_debit";
        }
        if ("ideal".equals(str)) {
            return "ideal";
        }
        if ("sofort".equals(str)) {
            return "sofort";
        }
        if ("bancontact".equals(str)) {
            return "bancontact";
        }
        if ("alipay".equals(str)) {
            return "alipay";
        }
        if ("p24".equals(str)) {
            return "p24";
        }
        return "unknown".equals(str) != null ? "unknown" : null;
    }

    /* renamed from: d */
    static String m33279d(String str) {
        if ("reusable".equals(str)) {
            return "reusable";
        }
        return "single_use".equals(str) != null ? "single_use" : null;
    }

    /* renamed from: e */
    static String m33280e(String str) {
        if ("redirect".equals(str)) {
            return "redirect";
        }
        if ("receiver".equals(str)) {
            return "receiver";
        }
        if ("code_verification".equals(str)) {
            return "code_verification";
        }
        return ViewProps.NONE.equals(str) != null ? ViewProps.NONE : null;
    }
}
