package com.onesignal;

import com.onesignal.ar.C5480a;
import com.onesignal.bj.C5495a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserStatePushSynchronizer */
class bi extends bj {
    /* renamed from: g */
    private static boolean f24826g;

    /* compiled from: UserStatePushSynchronizer */
    /* renamed from: com.onesignal.bi$1 */
    class C69561 extends C5480a {
        /* renamed from: a */
        final /* synthetic */ bi f24825a;

        C69561(bi biVar) {
            this.f24825a = biVar;
        }

        /* renamed from: a */
        void mo4940a(String str) {
            bi.f24826g = true;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("tags") != null) {
                    synchronized (this.f24825a.a) {
                        JSONObject a = this.f24825a.m23410a(this.f24825a.e.f18498b.optJSONObject("tags"), this.f24825a.m23428g().f18498b.optJSONObject("tags"), null, null);
                        this.f24825a.e.f18498b.put("tags", jSONObject.optJSONObject("tags"));
                        this.f24825a.e.m23388d();
                        this.f24825a.m23428g().m23385b(jSONObject, a);
                        this.f24825a.m23428g().m23388d();
                    }
                }
            } catch (String str2) {
                str2.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    protected void mo4952b(JSONObject jSONObject) {
    }

    bi() {
    }

    /* renamed from: a */
    protected be mo4946a(String str, boolean z) {
        return new bh(str, z);
    }

    /* renamed from: a */
    boolean mo4950a() {
        return m23428g().mo4945b();
    }

    /* renamed from: a */
    C5495a mo4947a(boolean z) {
        C5495a c5495a;
        if (z) {
            z = am.m23244m();
            String k = am.m23237k();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("players/");
            stringBuilder.append(z);
            stringBuilder.append("?app_id=");
            stringBuilder.append(k);
            ar.m23295b(stringBuilder.toString(), new C69561(this));
        }
        synchronized (this.a) {
            c5495a = new C5495a(f24826g, C5518o.m23503a(this.f.f18498b, "tags"));
        }
        return c5495a;
    }

    /* renamed from: c */
    protected void mo4954c() {
        m23409a(Integer.valueOf(0)).m23390a();
    }

    /* renamed from: a */
    void mo4949a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.putOpt("identifier", jSONObject.optString("identifier", null));
            if (jSONObject.has("device_type")) {
                jSONObject2.put("device_type", jSONObject.optInt("device_type"));
            }
            jSONObject2.putOpt("parent_player_id", jSONObject.optString("parent_player_id", null));
            JSONObject jSONObject3 = m23432k().f18498b;
            m23410a(jSONObject3, jSONObject2, jSONObject3, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jSONObject2 = new JSONObject();
            if (jSONObject.has("subscribableStatus")) {
                jSONObject2.put("subscribableStatus", jSONObject.optInt("subscribableStatus"));
            }
            if (jSONObject.has("androidPermission")) {
                jSONObject2.put("androidPermission", jSONObject.optBoolean("androidPermission"));
            }
            jSONObject = m23432k().f18497a;
            m23410a(jSONObject, jSONObject2, jSONObject, null);
        } catch (JSONObject jSONObject4) {
            jSONObject4.printStackTrace();
        }
    }

    /* renamed from: a */
    void m32649a(String str, String str2) {
        try {
            be k = m23432k();
            k.f18497a.put("email_auth_hash", str2);
            str2 = k.f18498b;
            m23410a((JSONObject) str2, (JSONObject) new JSONObject().put("email", str), (JSONObject) str2, null);
        } catch (String str3) {
            str3.printStackTrace();
        }
    }

    /* renamed from: b */
    void mo4953b(boolean z) {
        try {
            m23432k().f18497a.put("userSubscribePref", z);
        } catch (boolean z2) {
            z2.printStackTrace();
        }
    }

    /* renamed from: b */
    public boolean mo4951b() {
        return m23428g().f18497a.optBoolean("userSubscribePref", true);
    }

    /* renamed from: c */
    public void mo4959c(boolean z) {
        try {
            m23432k().f18497a.put("androidPermission", z);
        } catch (boolean z2) {
            z2.printStackTrace();
        }
    }

    /* renamed from: d */
    protected String mo4956d() {
        return am.m23244m();
    }

    /* renamed from: a */
    void mo4948a(String str) {
        am.m23223g(str);
    }

    /* renamed from: e */
    void mo4958e() {
        try {
            m23432k().f18497a.put("logoutEmail", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    protected void mo4955c(JSONObject jSONObject) {
        if (jSONObject.has("email") != null) {
            am.m23120A();
        }
    }

    /* renamed from: d */
    protected void mo4957d(JSONObject jSONObject) {
        if (jSONObject.has("email")) {
            am.m23262z();
        }
        if (jSONObject.has("identifier") != null) {
            am.m23235j();
        }
    }
}
