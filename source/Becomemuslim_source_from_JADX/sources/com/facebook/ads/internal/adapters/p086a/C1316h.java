package com.facebook.ads.internal.adapters.p086a;

import com.facebook.ads.internal.adapters.p086a.C1308b.C1307a;
import com.facebook.ads.internal.adapters.p086a.C1311c.C1310a;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.Serializable;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.a.h */
public class C1316h implements Serializable {
    private static final long serialVersionUID = 85021702336014823L;
    /* renamed from: a */
    private final C1311c f3820a;
    /* renamed from: b */
    private final C1313e f3821b;
    /* renamed from: c */
    private final C1308b f3822c;

    private C1316h(C1311c c1311c, C1313e c1313e, C1308b c1308b) {
        this.f3820a = c1311c;
        this.f3821b = c1313e;
        this.f3822c = c1308b;
    }

    /* renamed from: a */
    static C1316h m4532a(JSONObject jSONObject) {
        C1311c a = new C1310a().m4498a(jSONObject.optString("title")).m4500b(jSONObject.optString(MessengerShareContentUtility.SUBTITLE)).m4501c(jSONObject.optString("body")).m4499a();
        C1313e c1313e = new C1313e(jSONObject.optString("fbad_command"), jSONObject.optString("call_to_action"));
        boolean optBoolean = jSONObject.optBoolean("video_autoplay_enabled");
        C1307a b = new C1307a().m4476a(jSONObject.optString("video_url")).m4477a(optBoolean).m4481b(jSONObject.optBoolean("video_autoplay_with_sound"));
        int i = 0;
        if (optBoolean) {
            i = jSONObject.optInt("unskippable_seconds", 0);
        }
        C1307a a2 = b.m4474a(i);
        jSONObject = jSONObject.optJSONObject(MessengerShareContentUtility.MEDIA_IMAGE);
        if (jSONObject != null) {
            a2.m4480b(jSONObject.optString("url")).m4482c(jSONObject.optInt("width")).m4483d(jSONObject.optInt("height"));
        }
        return new C1316h(a, c1313e, a2.m4478a());
    }

    /* renamed from: a */
    public C1311c m4533a() {
        return this.f3820a;
    }

    /* renamed from: b */
    public C1313e m4534b() {
        return this.f3821b;
    }

    /* renamed from: c */
    public C1308b m4535c() {
        return this.f3822c;
    }
}
