package com.p064b.p065a.p067b;

import org.json.JSONObject;

/* compiled from: CheckForUpdatesResponseTransform */
/* renamed from: com.b.a.b.g */
class C1005g {
    C1005g() {
    }

    /* renamed from: a */
    public C1004f m3449a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new C1004f(jSONObject.optString("url", null), jSONObject.optString("version_string", null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
    }
}
