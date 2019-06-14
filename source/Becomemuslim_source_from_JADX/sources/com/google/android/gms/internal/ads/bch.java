package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@cm
public final class bch {
    /* renamed from: a */
    public final String f15173a;
    /* renamed from: b */
    public final String f15174b;
    /* renamed from: c */
    public final List<String> f15175c;
    /* renamed from: d */
    public final String f15176d;
    /* renamed from: e */
    public final String f15177e;
    /* renamed from: f */
    public final List<String> f15178f;
    /* renamed from: g */
    public final List<String> f15179g;
    /* renamed from: h */
    public final List<String> f15180h;
    /* renamed from: i */
    public final List<String> f15181i;
    /* renamed from: j */
    public final List<String> f15182j;
    /* renamed from: k */
    public final String f15183k;
    /* renamed from: l */
    public final List<String> f15184l;
    /* renamed from: m */
    public final List<String> f15185m;
    /* renamed from: n */
    public final List<String> f15186n;
    /* renamed from: o */
    public final String f15187o;
    /* renamed from: p */
    public final String f15188p;
    /* renamed from: q */
    public final String f15189q;
    /* renamed from: r */
    public final List<String> f15190r;
    /* renamed from: s */
    public final String f15191s;
    /* renamed from: t */
    public final long f15192t;
    /* renamed from: u */
    private final String f15193u;

    public bch(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, List<String> list4, List<String> list5, String str5, String str6, List<String> list6, List<String> list7, List<String> list8, String str7, String str8, String str9, List<String> list9, String str10, List<String> list10, String str11, long j) {
        this.f15173a = str;
        this.f15174b = null;
        this.f15175c = list;
        this.f15176d = null;
        this.f15177e = null;
        this.f15178f = list2;
        this.f15179g = list3;
        this.f15180h = list4;
        this.f15181i = list5;
        this.f15183k = str5;
        this.f15184l = list6;
        this.f15185m = list7;
        this.f15186n = list8;
        this.f15187o = null;
        this.f15188p = null;
        this.f15189q = null;
        this.f15190r = null;
        this.f15191s = null;
        this.f15182j = list10;
        this.f15193u = null;
        this.f15192t = -1;
    }

    public bch(JSONObject jSONObject) {
        List a;
        this.f15174b = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.f15175c = Collections.unmodifiableList(arrayList);
        this.f15176d = jSONObject.optString("allocation_id", null);
        ax.x();
        this.f15178f = bcr.m19235a(jSONObject, "clickurl");
        ax.x();
        this.f15179g = bcr.m19235a(jSONObject, "imp_urls");
        ax.x();
        this.f15180h = bcr.m19235a(jSONObject, "downloaded_imp_urls");
        ax.x();
        this.f15182j = bcr.m19235a(jSONObject, "fill_urls");
        ax.x();
        this.f15184l = bcr.m19235a(jSONObject, "video_start_urls");
        ax.x();
        this.f15186n = bcr.m19235a(jSONObject, "video_complete_urls");
        ax.x();
        List a2 = bcr.m19235a(jSONObject, "video_reward_urls");
        if (!((Boolean) aph.m18688f().m18889a(asp.ax)).booleanValue()) {
            a2 = this.f15186n;
        }
        this.f15185m = a2;
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            ax.x();
            a = bcr.m19235a(optJSONObject, "manual_impression_urls");
        } else {
            a = null;
        }
        this.f15181i = a;
        this.f15173a = optJSONObject != null ? optJSONObject.toString() : null;
        optJSONObject = jSONObject.optJSONObject("data");
        this.f15183k = optJSONObject != null ? optJSONObject.toString() : null;
        this.f15177e = optJSONObject != null ? optJSONObject.optString("class_name") : null;
        this.f15187o = jSONObject.optString("html_template", null);
        this.f15188p = jSONObject.optString("ad_base_url", null);
        optJSONObject = jSONObject.optJSONObject("assets");
        this.f15189q = optJSONObject != null ? optJSONObject.toString() : null;
        ax.x();
        this.f15190r = bcr.m19235a(jSONObject, "template_ids");
        optJSONObject = jSONObject.optJSONObject("ad_loader_options");
        this.f15191s = optJSONObject != null ? optJSONObject.toString() : null;
        this.f15193u = jSONObject.optString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, null);
        this.f15192t = jSONObject.optLong("ad_network_timeout_millis", -1);
    }

    /* renamed from: a */
    public final boolean m19220a() {
        return "banner".equalsIgnoreCase(this.f15193u);
    }

    /* renamed from: b */
    public final boolean m19221b() {
        return AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equalsIgnoreCase(this.f15193u);
    }
}
