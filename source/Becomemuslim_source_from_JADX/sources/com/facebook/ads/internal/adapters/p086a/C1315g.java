package com.facebook.ads.internal.adapters.p086a;

import android.content.Context;
import com.facebook.ads.internal.adapters.p086a.C1319i.C1318a;
import com.facebook.ads.internal.p105q.p109d.C1540a;
import com.facebook.ads.internal.p105q.p109d.C1541b;
import com.facebook.appevents.UserDataStore;
import com.facebook.stetho.server.http.HttpStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.a.g */
public class C1315g implements Serializable {
    private static final long serialVersionUID = 8751287062553772011L;
    /* renamed from: a */
    private final C1319i f3812a;
    /* renamed from: b */
    private final C1305a f3813b;
    /* renamed from: c */
    private final List<C1316h> f3814c;
    /* renamed from: d */
    private final int f3815d;
    /* renamed from: e */
    private final int f3816e;
    /* renamed from: f */
    private int f3817f = HttpStatus.HTTP_OK;
    /* renamed from: g */
    private final String f3818g;
    /* renamed from: h */
    private final String f3819h;

    private C1315g(C1319i c1319i, C1305a c1305a, List<C1316h> list, String str, String str2, int i, int i2) {
        this.f3812a = c1319i;
        this.f3813b = c1305a;
        this.f3814c = list;
        this.f3818g = str;
        this.f3819h = str2;
        this.f3815d = i;
        this.f3816e = i2;
    }

    /* renamed from: a */
    public static C1315g m4521a(JSONObject jSONObject, Context context) {
        C1319i a = new C1318a().m4540a(jSONObject.optString("title")).m4542b(jSONObject.optJSONObject("icon") != null ? jSONObject.optJSONObject("icon").optString("url") : "").m4543c(jSONObject.optString("ad_choices_link_url")).m4544d(C1315g.m4522a(jSONObject)).m4541a();
        JSONObject optJSONObject = jSONObject.optJSONObject("layout");
        JSONObject jSONObject2 = null;
        C1312d a2 = C1312d.m4505a(optJSONObject != null ? optJSONObject.optJSONObject("portrait") : null);
        if (optJSONObject != null) {
            jSONObject2 = optJSONObject.optJSONObject("landscape");
        }
        C1305a c1305a = new C1305a(a2, C1312d.m4505a(jSONObject2));
        int i = 0;
        int optInt = jSONObject.optInt("viewability_check_initial_delay", 0);
        int optInt2 = jSONObject.optInt("viewability_check_interval", 1000);
        String optString = jSONObject.optString(UserDataStore.CITY);
        String optString2 = jSONObject.optString("request_id", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("carousel");
        List arrayList = new ArrayList();
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            arrayList.add(C1316h.m4532a(jSONObject));
        } else {
            while (i < optJSONArray.length()) {
                try {
                    arrayList.add(C1316h.m4532a(optJSONArray.getJSONObject(i)));
                } catch (Exception e) {
                    C1540a.m5396a(context, "parsing", C1541b.f4576u, e);
                    e.printStackTrace();
                }
                i++;
            }
        }
        return new C1315g(a, c1305a, arrayList, optString, optString2, optInt, optInt2);
    }

    /* renamed from: a */
    private static String m4522a(JSONObject jSONObject) {
        jSONObject = jSONObject.optJSONObject("generic_text");
        return jSONObject == null ? "Sponsored" : jSONObject.optString("sponsored", "Sponsored");
    }

    /* renamed from: a */
    public C1319i m4523a() {
        return this.f3812a;
    }

    /* renamed from: a */
    public void m4524a(int i) {
        this.f3817f = i;
    }

    /* renamed from: b */
    public C1305a m4525b() {
        return this.f3813b;
    }

    /* renamed from: c */
    public String m4526c() {
        return this.f3818g;
    }

    /* renamed from: d */
    public List<C1316h> m4527d() {
        return Collections.unmodifiableList(this.f3814c);
    }

    /* renamed from: e */
    public String m4528e() {
        return this.f3819h;
    }

    /* renamed from: f */
    public int m4529f() {
        return this.f3815d;
    }

    /* renamed from: g */
    public int m4530g() {
        return this.f3816e;
    }

    /* renamed from: h */
    public int m4531h() {
        return this.f3817f;
    }
}
