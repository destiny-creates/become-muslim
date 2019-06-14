package com.onesignal;

import org.json.JSONObject;

/* compiled from: OSSubscriptionStateChanges */
public class ak {
    /* renamed from: a */
    OSSubscriptionState f18323a;
    /* renamed from: b */
    OSSubscriptionState f18324b;

    /* renamed from: a */
    public JSONObject m23085a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f18324b.m23045f());
            jSONObject.put("to", this.f18323a.m23045f());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return m23085a().toString();
    }
}
