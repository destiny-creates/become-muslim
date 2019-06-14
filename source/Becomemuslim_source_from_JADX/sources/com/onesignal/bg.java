package com.onesignal;

import com.onesignal.bj.C5495a;
import org.json.JSONObject;

/* compiled from: UserStateEmailSynchronizer */
class bg extends bj {
    /* renamed from: a */
    C5495a mo4947a(boolean z) {
        return null;
    }

    /* renamed from: a */
    void mo4949a(JSONObject jSONObject) {
    }

    /* renamed from: a */
    boolean mo4950a() {
        return false;
    }

    /* renamed from: b */
    void mo4953b(boolean z) {
    }

    bg() {
    }

    /* renamed from: a */
    protected be mo4946a(String str, boolean z) {
        return new bf(str, z);
    }

    /* renamed from: b */
    void mo4951b() {
        mo4954c();
    }

    /* renamed from: c */
    protected void mo4954c() {
        Object obj = (mo4956d() == null && m23426f() == null) ? 1 : null;
        if (obj == null) {
            if (am.m23244m() != null) {
                m23409a(Integer.valueOf(0)).m23390a();
            }
        }
    }

    /* renamed from: a */
    void m32629a(String str, String str2) {
        Object obj;
        String optString;
        JSONObject jSONObject;
        JSONObject jSONObject2 = m23432k().f18498b;
        if (str.equals(jSONObject2.optString("identifier"))) {
            if (jSONObject2.optString("email_auth_hash").equals(str2 == null ? "" : str2)) {
                obj = 1;
                if (obj == null) {
                    am.m23262z();
                }
                optString = jSONObject2.optString("identifier", null);
                if (optString == null) {
                    m23433l();
                }
                try {
                    jSONObject = new JSONObject();
                    jSONObject.put("identifier", str);
                    if (str2 != null) {
                        jSONObject.put("email_auth_hash", str2);
                    }
                    if (str2 == null && optString != null && optString.equals(str) == null) {
                        am.m23217f("");
                        m23434m();
                        m23433l();
                    }
                    m23410a(jSONObject2, jSONObject, jSONObject2, null);
                    mo4954c();
                } catch (String str3) {
                    str3.printStackTrace();
                }
                return;
            }
        }
        obj = null;
        if (obj == null) {
            optString = jSONObject2.optString("identifier", null);
            if (optString == null) {
                m23433l();
            }
            jSONObject = new JSONObject();
            jSONObject.put("identifier", str3);
            if (str2 != null) {
                jSONObject.put("email_auth_hash", str2);
            }
            am.m23217f("");
            m23434m();
            m23433l();
            m23410a(jSONObject2, jSONObject, jSONObject2, null);
            mo4954c();
            return;
        }
        am.m23262z();
    }

    /* renamed from: d */
    protected String mo4956d() {
        return am.m23248n();
    }

    /* renamed from: a */
    void mo4948a(String str) {
        am.m23226h(str);
    }

    /* renamed from: b */
    protected void mo4952b(JSONObject jSONObject) {
        try {
            jSONObject.put("device_type", 11);
            jSONObject.putOpt("device_player_id", am.m23244m());
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
        }
    }

    /* renamed from: e */
    void mo4958e() {
        am.m23217f("");
        m23434m();
        m23428g().f18498b.remove("identifier");
        this.f.f18498b.remove("email_auth_hash");
        this.f.f18498b.remove("device_player_id");
        this.f.m23388d();
        am.m23255s().f18322c.m23586a();
    }

    /* renamed from: c */
    protected void mo4955c(JSONObject jSONObject) {
        if (jSONObject.has("identifier") != null) {
            am.m23120A();
        }
    }

    /* renamed from: d */
    protected void mo4957d(JSONObject jSONObject) {
        if (jSONObject.has("identifier") != null) {
            am.m23262z();
        }
    }
}
