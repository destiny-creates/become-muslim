package com.onesignal;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: OSNotification */
public class aa {
    /* renamed from: a */
    public boolean f18265a;
    /* renamed from: b */
    public boolean f18266b;
    /* renamed from: c */
    public int f18267c;
    /* renamed from: d */
    public ae f18268d;
    /* renamed from: e */
    public C5441a f18269e;
    /* renamed from: f */
    public List<ae> f18270f;

    /* compiled from: OSNotification */
    /* renamed from: com.onesignal.aa$a */
    public enum C5441a {
        Notification,
        InAppAlert,
        None
    }

    /* renamed from: a */
    public JSONObject m23068a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isAppInFocus", this.f18265a);
            jSONObject.put("shown", this.f18266b);
            jSONObject.put("androidNotificationId", this.f18267c);
            jSONObject.put("displayType", this.f18269e.ordinal());
            if (this.f18270f != null) {
                JSONArray jSONArray = new JSONArray();
                for (ae a : this.f18270f) {
                    jSONArray.put(a.m23071a());
                }
                jSONObject.put("groupedNotifications", jSONArray);
            }
            jSONObject.put(MessengerShareContentUtility.ATTACHMENT_PAYLOAD, this.f18268d.m23071a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }
}
