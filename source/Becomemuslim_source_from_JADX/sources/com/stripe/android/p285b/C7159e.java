package com.stripe.android.p285b;

import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: CustomerSource */
/* renamed from: com.stripe.android.b.e */
public class C7159e extends C5729q implements C5731s {
    /* renamed from: a */
    private C5731s f25353a;

    private C7159e(C5731s c5731s) {
        this.f25353a = c5731s;
    }

    /* renamed from: y */
    public String mo5067y() {
        return this.f25353a == null ? null : this.f25353a.mo5067y();
    }

    /* renamed from: c */
    public C7162i m33257c() {
        return this.f25353a instanceof C7162i ? (C7162i) this.f25353a : null;
    }

    /* renamed from: d */
    public String m33258d() {
        C7162i c = m33257c();
        C7157c e = m33259e();
        if (c != null && c.m33297q().equals("card")) {
            C8035j c8035j = (C8035j) c.m33296p();
            if (c8035j != null) {
                return c8035j.m38947e();
            }
        } else if (e != null) {
            return e.m33246z();
        }
        return null;
    }

    /* renamed from: e */
    public C7157c m33259e() {
        return this.f25353a instanceof C7157c ? (C7157c) this.f25353a : null;
    }

    /* renamed from: f */
    public String m33260f() {
        if (this.f25353a instanceof C7157c) {
            return "card";
        }
        return this.f25353a instanceof C7162i ? ((C7162i) this.f25353a).m33297q() : "unknown";
    }

    /* renamed from: a */
    public static C7159e m33254a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String d = C5730r.m24288d(jSONObject, "object");
        jSONObject = "card".equals(d) ? C7157c.m33213a(jSONObject) : ShareConstants.FEED_SOURCE_PARAM.equals(d) ? C7162i.m33275a(jSONObject) : null;
        if (jSONObject == null) {
            return null;
        }
        return new C7159e(jSONObject);
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        if (this.f25353a instanceof C7162i) {
            return ((C7162i) this.f25353a).mo5066b();
        }
        if (this.f25353a instanceof C7157c) {
            return ((C7157c) this.f25353a).mo5066b();
        }
        return new HashMap();
    }

    /* renamed from: a */
    public JSONObject mo5065a() {
        if (this.f25353a instanceof C7162i) {
            return ((C7162i) this.f25353a).mo5065a();
        }
        if (this.f25353a instanceof C7157c) {
            return ((C7157c) this.f25353a).mo5065a();
        }
        return new JSONObject();
    }
}
