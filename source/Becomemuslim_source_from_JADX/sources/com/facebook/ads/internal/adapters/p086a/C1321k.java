package com.facebook.ads.internal.adapters.p086a;

import android.text.TextUtils;
import com.facebook.ads.internal.adapters.p086a.C1308b.C1307a;
import com.facebook.ads.internal.adapters.p086a.C1311c.C1310a;
import com.facebook.ads.internal.adapters.p086a.C1319i.C1318a;
import com.facebook.ads.internal.p095j.C1399c;
import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.stetho.server.http.HttpStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.a.k */
public class C1321k implements Serializable {
    private static final long serialVersionUID = -5352540727250859603L;
    /* renamed from: a */
    private final C1319i f3834a;
    /* renamed from: b */
    private final C1311c f3835b;
    /* renamed from: c */
    private final C1313e f3836c;
    /* renamed from: d */
    private final C1305a f3837d;
    /* renamed from: e */
    private final C1308b f3838e;
    /* renamed from: f */
    private final C1314f f3839f;
    /* renamed from: g */
    private final String f3840g;
    /* renamed from: h */
    private int f3841h = HttpStatus.HTTP_OK;

    private C1321k(C1319i c1319i, C1311c c1311c, C1313e c1313e, C1305a c1305a, C1308b c1308b, C1314f c1314f, String str) {
        this.f3834a = c1319i;
        this.f3835b = c1311c;
        this.f3836c = c1313e;
        this.f3837d = c1305a;
        this.f3838e = c1308b;
        this.f3839f = c1314f;
        this.f3840g = str;
    }

    /* renamed from: a */
    public static C1321k m4552a(JSONObject jSONObject) {
        C1319i a = new C1318a().m4540a(jSONObject.optString("advertiser_name")).m4542b(jSONObject.optJSONObject("icon") != null ? jSONObject.optJSONObject("icon").optString("url") : "").m4543c(jSONObject.optString("ad_choices_link_url")).m4544d(C1321k.m4554b(jSONObject)).m4541a();
        C1311c a2 = new C1310a().m4498a(jSONObject.optString("title")).m4500b(jSONObject.optString(MessengerShareContentUtility.SUBTITLE)).m4501c(jSONObject.optString("body")).m4499a();
        C1313e c1313e = new C1313e(jSONObject.optString("fbad_command"), jSONObject.optString("call_to_action"));
        JSONObject optJSONObject = jSONObject.optJSONObject("layout");
        C1320j c1320j = null;
        C1305a c1305a = new C1305a(C1312d.m4505a(optJSONObject != null ? optJSONObject.optJSONObject("portrait") : null), C1312d.m4505a(optJSONObject != null ? optJSONObject.optJSONObject("landscape") : null));
        optJSONObject = jSONObject.optJSONObject("playable_data");
        if (optJSONObject != null) {
            c1320j = new C1320j(optJSONObject.optString("uri"), jSONObject.optInt("skippable_seconds", 0), C1321k.m4555c(optJSONObject));
        }
        return new C1321k(a, a2, c1313e, c1305a, new C1307a().m4476a(jSONObject.optString("video_url")).m4480b(jSONObject.optJSONObject(MessengerShareContentUtility.MEDIA_IMAGE) != null ? jSONObject.optJSONObject(MessengerShareContentUtility.MEDIA_IMAGE).optString("url") : "").m4474a(jSONObject.optInt("skippable_seconds")).m4479b(jSONObject.optInt("video_duration_sec")).m4475a(c1320j).m4478a(), new C1314f(C1399c.m4800a(jSONObject.optString("end_card_markup")), jSONObject.optString("activation_command"), C1321k.m4553a(jSONObject.optJSONArray("end_card_images"))), jSONObject.optString(UserDataStore.CITY));
    }

    /* renamed from: a */
    private static List<String> m4553a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new ArrayList();
        }
        List<String> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            CharSequence optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static String m4554b(JSONObject jSONObject) {
        jSONObject = jSONObject.optJSONObject("generic_text");
        return jSONObject == null ? "Sponsored" : jSONObject.optString("sponsored", "Sponsored");
    }

    /* renamed from: c */
    private static String m4555c(JSONObject jSONObject) {
        jSONObject = jSONObject.optJSONObject("generic_text");
        return jSONObject == null ? "Rewarded Play" : jSONObject.optString("rewarded_play_text", "Rewarded Play");
    }

    /* renamed from: a */
    public C1319i m4556a() {
        return this.f3834a;
    }

    /* renamed from: a */
    public void m4557a(int i) {
        this.f3841h = i;
    }

    /* renamed from: a */
    public void m4558a(String str) {
        this.f3839f.m4517a(str);
    }

    /* renamed from: b */
    public C1311c m4559b() {
        return this.f3835b;
    }

    /* renamed from: b */
    public void m4560b(String str) {
        this.f3838e.m4485a(str);
    }

    /* renamed from: c */
    public C1313e m4561c() {
        return this.f3836c;
    }

    /* renamed from: d */
    public C1305a m4562d() {
        return this.f3837d;
    }

    /* renamed from: e */
    public C1308b m4563e() {
        return this.f3838e;
    }

    /* renamed from: f */
    public C1314f m4564f() {
        return this.f3839f;
    }

    /* renamed from: g */
    public String m4565g() {
        return this.f3840g;
    }

    /* renamed from: h */
    public int m4566h() {
        return this.f3841h;
    }
}
