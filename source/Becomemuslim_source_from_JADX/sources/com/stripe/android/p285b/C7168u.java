package com.stripe.android.p285b;

import android.text.TextUtils;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: Token */
/* renamed from: com.stripe.android.b.u */
public class C7168u implements C5731s {
    /* renamed from: a */
    private final String f25400a;
    /* renamed from: b */
    private final String f25401b;
    /* renamed from: c */
    private final Date f25402c;
    /* renamed from: d */
    private final boolean f25403d;
    /* renamed from: e */
    private final boolean f25404e;
    /* renamed from: f */
    private final C5722b f25405f;
    /* renamed from: g */
    private final C7157c f25406g;

    public C7168u(String str, boolean z, Date date, Boolean bool, C7157c c7157c) {
        this.f25400a = str;
        this.f25401b = "card";
        this.f25402c = date;
        this.f25403d = z;
        this.f25406g = c7157c;
        this.f25404e = bool.booleanValue();
        this.f25405f = null;
    }

    public C7168u(String str, boolean z, Date date, Boolean bool, C5722b c5722b) {
        this.f25400a = str;
        this.f25401b = "bank_account";
        this.f25402c = date;
        this.f25403d = z;
        this.f25406g = null;
        this.f25404e = bool.booleanValue();
        this.f25405f = c5722b;
    }

    public C7168u(String str, boolean z, Date date, Boolean bool) {
        this.f25400a = str;
        this.f25401b = "pii";
        this.f25402c = date;
        this.f25406g = null;
        this.f25405f = null;
        this.f25404e = bool.booleanValue();
        this.f25403d = z;
    }

    /* renamed from: a */
    public Date m33340a() {
        return this.f25402c;
    }

    /* renamed from: y */
    public String mo5067y() {
        return this.f25400a;
    }

    /* renamed from: b */
    public boolean m33341b() {
        return this.f25403d;
    }

    /* renamed from: c */
    public boolean m33342c() {
        return this.f25404e;
    }

    /* renamed from: d */
    public C7157c m33343d() {
        return this.f25406g;
    }

    /* renamed from: e */
    public C5722b m33344e() {
        return this.f25405f;
    }

    /* renamed from: a */
    public static com.stripe.android.p285b.C7168u m33337a(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x000a }
        r0.<init>(r1);	 Catch:{ JSONException -> 0x000a }
        r1 = com.stripe.android.p285b.C7168u.m33338a(r0);	 Catch:{ JSONException -> 0x000a }
        return r1;
    L_0x000a:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.b.u.a(java.lang.String):com.stripe.android.b.u");
    }

    /* renamed from: a */
    public static C7168u m33338a(JSONObject jSONObject) {
        C7168u c7168u = null;
        if (jSONObject == null) {
            return null;
        }
        String d = C5730r.m24288d(jSONObject, "id");
        Long c = C5730r.m24287c(jSONObject, "created");
        Boolean a = C5730r.m24274a(jSONObject, "livemode");
        String b = C7168u.m33339b(C5730r.m24288d(jSONObject, "type"));
        Boolean a2 = C5730r.m24274a(jSONObject, "used");
        if (!(d == null || c == null)) {
            if (a != null) {
                Date date = new Date(c.longValue() * 1000);
                JSONObject c7168u2;
                if ("bank_account".equals(b)) {
                    jSONObject = jSONObject.optJSONObject("bank_account");
                    if (jSONObject == null) {
                        return null;
                    }
                    c7168u2 = new C7168u(d, a.booleanValue(), date, a2, C5722b.m24184a(jSONObject));
                } else if ("card".equals(b)) {
                    jSONObject = jSONObject.optJSONObject("card");
                    if (jSONObject == null) {
                        return null;
                    }
                    c7168u2 = new C7168u(d, a.booleanValue(), date, a2, C7157c.m33213a(jSONObject));
                } else {
                    if ("pii".equals(b) != null) {
                        c7168u = new C7168u(d, a.booleanValue(), date, a2);
                    }
                    jSONObject = c7168u;
                }
                return jSONObject;
            }
        }
        return null;
    }

    /* renamed from: b */
    static String m33339b(String str) {
        if (str != null) {
            if (!TextUtils.isEmpty(str.trim())) {
                if ("card".equals(str)) {
                    return "card";
                }
                if ("bank_account".equals(str)) {
                    return "bank_account";
                }
                if ("pii".equals(str) != null) {
                    return "pii";
                }
                return null;
            }
        }
        return null;
    }
}
