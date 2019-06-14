package host.exp.exponent.notifications;

import com.facebook.share.internal.ShareConstants;
import host.exp.exponent.C6394j;
import host.exp.exponent.p334a.C6289b;
import org.json.JSONObject;

/* compiled from: ExponentNotification */
/* renamed from: host.exp.exponent.notifications.c */
public class C6396c {
    /* renamed from: h */
    private static final String f20700h = "c";
    /* renamed from: a */
    public final String f20701a;
    /* renamed from: b */
    public final String f20702b;
    /* renamed from: c */
    public final int f20703c;
    /* renamed from: d */
    public final boolean f20704d;
    /* renamed from: e */
    public final boolean f20705e;
    /* renamed from: f */
    public String f20706f;
    /* renamed from: g */
    public String f20707g;

    public C6396c(String str, String str2, int i, boolean z, boolean z2) {
        this.f20701a = str;
        this.f20702b = str2;
        this.f20703c = i;
        this.f20704d = z;
        this.f20705e = z2;
    }

    /* renamed from: a */
    public static C6396c m26252a(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.optString("data", null);
            if (str == null) {
                str = jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, null);
            }
            return new C6396c(jSONObject.getString("experienceId"), str, jSONObject.getInt("notificationId"), jSONObject.getBoolean("isMultiple"), jSONObject.getBoolean("remote"));
        } catch (String str2) {
            C6289b.m25953c(f20700h, str2.toString());
            return null;
        }
    }

    /* renamed from: b */
    public JSONObject m26254b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("experienceId", this.f20701a);
            if (str != null) {
                jSONObject.put("origin", str);
            }
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.f20702b);
            jSONObject.put("data", this.f20702b);
            jSONObject.put("notificationId", this.f20703c);
            jSONObject.put("isMultiple", this.f20704d);
            jSONObject.put("remote", this.f20705e);
        } catch (String str2) {
            C6289b.m25953c(f20700h, str2.toString());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public Object m26253a(String str, String str2) {
        str = new C6394j("com.facebook.react.bridge.Arguments").m26233a(str).m26246d("createMap", new Object[0]);
        if (str2 != null) {
            str.m26236a("putString", "origin", str2);
        }
        str.m26236a("putString", "data", this.f20702b);
        str.m26236a("putInt", "notificationId", Integer.valueOf(this.f20703c));
        str.m26236a("putBoolean", "isMultiple", Boolean.valueOf(this.f20704d));
        str.m26236a("putBoolean", "remote", Boolean.valueOf(this.f20705e));
        str.m26236a("putString", "actionId", this.f20706f);
        str.m26236a("putString", C6401h.f20717a, this.f20707g);
        return str.m26244c();
    }

    /* renamed from: c */
    public void m26255c(String str) {
        this.f20707g = str;
    }

    /* renamed from: d */
    public void m26256d(String str) {
        this.f20706f = str;
    }
}
