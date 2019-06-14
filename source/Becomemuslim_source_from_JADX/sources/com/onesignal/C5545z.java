package com.onesignal;

import org.json.JSONObject;

/* compiled from: OSEmailSubscriptionState */
/* renamed from: com.onesignal.z */
public class C5545z implements Cloneable {
    /* renamed from: a */
    ag<Object, C5545z> f18591a = new ag("changed", false);
    /* renamed from: b */
    private String f18592b;
    /* renamed from: c */
    private String f18593c;

    C5545z(boolean z) {
        if (z) {
            this.f18592b = aq.m23283b(aq.f18435a, "PREFS_ONESIGNAL_EMAIL_ID_LAST", null);
            this.f18593c = aq.m23283b(aq.f18435a, "PREFS_ONESIGNAL_EMAIL_ADDRESS_LAST", null);
            return;
        }
        this.f18592b = am.m23248n();
        this.f18593c = as.m23308b().m23426f();
    }

    /* renamed from: a */
    void m23586a() {
        Object obj;
        if (this.f18592b == null) {
            if (this.f18593c == null) {
                obj = null;
                this.f18592b = null;
                this.f18593c = null;
                if (obj != null) {
                    this.f18591a.m23074c(this);
                }
            }
        }
        obj = 1;
        this.f18592b = null;
        this.f18593c = null;
        if (obj != null) {
            this.f18591a.m23074c(this);
        }
    }

    /* renamed from: a */
    void m23587a(String str) {
        int equals = str.equals(this.f18592b) ^ 1;
        this.f18592b = str;
        if (equals != 0) {
            this.f18591a.m23074c(this);
        }
    }

    /* renamed from: b */
    public String m23588b() {
        return this.f18592b;
    }

    /* renamed from: b */
    void m23589b(String str) {
        int equals = str.equals(this.f18593c) ^ 1;
        this.f18593c = str;
        if (equals != 0) {
            this.f18591a.m23074c(this);
        }
    }

    /* renamed from: c */
    public String m23590c() {
        return this.f18593c;
    }

    /* renamed from: d */
    public boolean m23591d() {
        return (this.f18592b == null || this.f18593c == null) ? false : true;
    }

    protected java.lang.Object clone() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = super.clone();	 Catch:{ Throwable -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.z.clone():java.lang.Object");
    }

    /* renamed from: e */
    public JSONObject m23592e() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f18592b != null) {
                jSONObject.put("emailUserId", this.f18592b);
            } else {
                jSONObject.put("emailUserId", JSONObject.NULL);
            }
            if (this.f18593c != null) {
                jSONObject.put("emailAddress", this.f18593c);
            } else {
                jSONObject.put("emailAddress", JSONObject.NULL);
            }
            jSONObject.put("subscribed", m23591d());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return m23592e().toString();
    }
}
