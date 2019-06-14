package com.onesignal;

import org.json.JSONObject;

/* compiled from: OSPermissionStateChanges */
public class ai {
    /* renamed from: a */
    ah f18318a;
    /* renamed from: b */
    ah f18319b;

    /* renamed from: a */
    public JSONObject m23080a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f18319b.m23079d());
            jSONObject.put("to", this.f18318a.m23079d());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return m23080a().toString();
    }
}
