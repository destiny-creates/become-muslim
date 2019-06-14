package com.onesignal;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: OSNotificationPayload */
public class ae {
    /* renamed from: a */
    public String f18284a;
    /* renamed from: b */
    public String f18285b;
    /* renamed from: c */
    public String f18286c;
    /* renamed from: d */
    public String f18287d;
    /* renamed from: e */
    public String f18288e;
    /* renamed from: f */
    public JSONObject f18289f;
    /* renamed from: g */
    public String f18290g;
    /* renamed from: h */
    public String f18291h;
    /* renamed from: i */
    public String f18292i;
    /* renamed from: j */
    public String f18293j;
    /* renamed from: k */
    public String f18294k;
    /* renamed from: l */
    public String f18295l;
    /* renamed from: m */
    public String f18296m;
    /* renamed from: n */
    public int f18297n = 1;
    /* renamed from: o */
    public String f18298o;
    /* renamed from: p */
    public String f18299p;
    /* renamed from: q */
    public List<C5443a> f18300q;
    /* renamed from: r */
    public String f18301r;
    /* renamed from: s */
    public C5444b f18302s;
    /* renamed from: t */
    public String f18303t;
    /* renamed from: u */
    public int f18304u;
    /* renamed from: v */
    public String f18305v;

    /* compiled from: OSNotificationPayload */
    /* renamed from: com.onesignal.ae$a */
    public static class C5443a {
        /* renamed from: a */
        public String f18278a;
        /* renamed from: b */
        public String f18279b;
        /* renamed from: c */
        public String f18280c;

        /* renamed from: a */
        public JSONObject m23070a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f18278a);
                jSONObject.put("text", this.f18279b);
                jSONObject.put("icon", this.f18280c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* compiled from: OSNotificationPayload */
    /* renamed from: com.onesignal.ae$b */
    public static class C5444b {
        /* renamed from: a */
        public String f18281a;
        /* renamed from: b */
        public String f18282b;
        /* renamed from: c */
        public String f18283c;
    }

    /* renamed from: a */
    public JSONObject m23071a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("notificationID", this.f18284a);
            jSONObject.put("title", this.f18287d);
            jSONObject.put("body", this.f18288e);
            if (this.f18289f != null) {
                jSONObject.put("additionalData", this.f18289f);
            }
            jSONObject.put("smallIcon", this.f18290g);
            jSONObject.put("largeIcon", this.f18291h);
            jSONObject.put("bigPicture", this.f18292i);
            jSONObject.put("smallIconAccentColor", this.f18293j);
            jSONObject.put("launchURL", this.f18294k);
            jSONObject.put("sound", this.f18295l);
            jSONObject.put("ledColor", this.f18296m);
            jSONObject.put("lockScreenVisibility", this.f18297n);
            jSONObject.put("groupKey", this.f18298o);
            jSONObject.put("groupMessage", this.f18299p);
            if (this.f18300q != null) {
                JSONArray jSONArray = new JSONArray();
                for (C5443a a : this.f18300q) {
                    jSONArray.put(a.m23070a());
                }
                jSONObject.put("actionButtons", jSONArray);
            }
            jSONObject.put("fromProjectNumber", this.f18301r);
            jSONObject.put("collapseId", this.f18303t);
            jSONObject.put("priority", this.f18304u);
            jSONObject.put("rawPayload", this.f18305v);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }
}
