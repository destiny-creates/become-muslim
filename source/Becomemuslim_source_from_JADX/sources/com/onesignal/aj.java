package com.onesignal;

import org.json.JSONObject;

/* compiled from: OSPermissionSubscriptionState */
public class aj {
    /* renamed from: a */
    OSSubscriptionState f18320a;
    /* renamed from: b */
    ah f18321b;
    /* renamed from: c */
    C5545z f18322c;

    /* renamed from: a */
    public ah m23081a() {
        return this.f18321b;
    }

    /* renamed from: b */
    public OSSubscriptionState m23082b() {
        return this.f18320a;
    }

    /* renamed from: c */
    public C5545z m23083c() {
        return this.f18322c;
    }

    /* renamed from: d */
    public JSONObject m23084d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("permissionStatus", this.f18321b.m23079d());
            jSONObject.put("subscriptionStatus", this.f18320a.m23045f());
            jSONObject.put("emailSubscriptionStatus", this.f18322c.m23592e());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return m23084d().toString();
    }
}
