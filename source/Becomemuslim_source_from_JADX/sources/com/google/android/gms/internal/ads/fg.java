package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@cm
public final class fg {
    /* renamed from: a */
    private final List<String> f15423a;
    /* renamed from: b */
    private final String f15424b;
    /* renamed from: c */
    private final String f15425c;
    /* renamed from: d */
    private final String f15426d;
    /* renamed from: e */
    private final boolean f15427e;
    /* renamed from: f */
    private final String f15428f;
    /* renamed from: g */
    private final String f15429g;
    /* renamed from: h */
    private String f15430h;
    /* renamed from: i */
    private final int f15431i;
    /* renamed from: j */
    private final boolean f15432j;
    /* renamed from: k */
    private final JSONObject f15433k;

    public fg(int i, Map<String, String> map) {
        this.f15430h = (String) map.get("url");
        this.f15424b = (String) map.get("base_uri");
        this.f15425c = (String) map.get("post_parameters");
        this.f15427e = m19416b((String) map.get("drt_include"));
        this.f15428f = (String) map.get("request_id");
        this.f15426d = (String) map.get("type");
        this.f15423a = m19417c((String) map.get("errors"));
        this.f15431i = i;
        this.f15429g = (String) map.get("fetched_ad");
        this.f15432j = m19416b((String) map.get("render_test_ad_label"));
        this.f15433k = new JSONObject();
    }

    public fg(JSONObject jSONObject) {
        this.f15430h = jSONObject.optString("url");
        this.f15424b = jSONObject.optString("base_uri");
        this.f15425c = jSONObject.optString("post_parameters");
        this.f15427e = m19416b(jSONObject.optString("drt_include"));
        this.f15428f = jSONObject.optString("request_id");
        this.f15426d = jSONObject.optString("type");
        this.f15423a = m19417c(jSONObject.optString("errors"));
        int i = 1;
        if (jSONObject.optInt("valid", 0) == 1) {
            i = -2;
        }
        this.f15431i = i;
        this.f15429g = jSONObject.optString("fetched_ad");
        this.f15432j = jSONObject.optBoolean("render_test_ad_label");
        jSONObject = jSONObject.optJSONObject("preprocessor_flags");
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.f15433k = jSONObject;
    }

    /* renamed from: b */
    private static boolean m19416b(String str) {
        return str != null && (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) || str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
    }

    /* renamed from: c */
    private static List<String> m19417c(String str) {
        return str == null ? null : Arrays.asList(str.split(","));
    }

    /* renamed from: a */
    public final int m19418a() {
        return this.f15431i;
    }

    /* renamed from: a */
    public final void m19419a(String str) {
        this.f15430h = str;
    }

    /* renamed from: b */
    public final List<String> m19420b() {
        return this.f15423a;
    }

    /* renamed from: c */
    public final String m19421c() {
        return this.f15424b;
    }

    /* renamed from: d */
    public final String m19422d() {
        return this.f15425c;
    }

    /* renamed from: e */
    public final String m19423e() {
        return this.f15430h;
    }

    /* renamed from: f */
    public final String m19424f() {
        return this.f15426d;
    }

    /* renamed from: g */
    public final boolean m19425g() {
        return this.f15427e;
    }

    /* renamed from: h */
    public final String m19426h() {
        return this.f15428f;
    }

    /* renamed from: i */
    public final String m19427i() {
        return this.f15429g;
    }

    /* renamed from: j */
    public final boolean m19428j() {
        return this.f15432j;
    }
}
