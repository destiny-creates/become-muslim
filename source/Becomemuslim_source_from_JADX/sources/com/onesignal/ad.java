package com.onesignal;

import com.facebook.internal.NativeProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OSNotificationOpenResult */
public class ad {
    /* renamed from: a */
    public aa f18276a;
    /* renamed from: b */
    public ab f18277b;

    /* renamed from: a */
    public JSONObject m23069a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("actionID", this.f18277b.f18275b);
            jSONObject2.put("type", this.f18277b.f18274a.ordinal());
            jSONObject.put(NativeProtocol.WEB_DIALOG_ACTION, jSONObject2);
            jSONObject.put("notification", this.f18276a.m23068a());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
