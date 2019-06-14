package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@cm
public final class iw {
    /* renamed from: a */
    private final long f15624a;
    /* renamed from: b */
    private final List<String> f15625b = new ArrayList();
    /* renamed from: c */
    private final List<String> f15626c = new ArrayList();
    /* renamed from: d */
    private final Map<String, bci> f15627d = new HashMap();
    /* renamed from: e */
    private String f15628e;
    /* renamed from: f */
    private String f15629f;
    /* renamed from: g */
    private boolean f15630g;

    public iw(String str, long j) {
        int i = 0;
        this.f15630g = false;
        this.f15629f = str;
        this.f15624a = j;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1) != 1) {
                    this.f15630g = false;
                    mt.m19924e("App settings could not be fetched successfully.");
                    return;
                }
                this.f15630g = true;
                this.f15628e = jSONObject.optString("app_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        String optString = jSONObject2.optString("format");
                        CharSequence optString2 = jSONObject2.optString("ad_unit_id");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                if ("interstitial".equalsIgnoreCase(optString)) {
                                    this.f15626c.add(optString2);
                                } else if ("rewarded".equalsIgnoreCase(optString)) {
                                    jSONObject2 = jSONObject2.optJSONObject("mediation_config");
                                    if (jSONObject2 != null) {
                                        this.f15627d.put(optString2, new bci(jSONObject2));
                                    }
                                }
                            }
                        }
                    }
                }
                optJSONArray = jSONObject.optJSONArray("persistable_banner_ad_unit_ids");
                if (optJSONArray != null) {
                    while (i < optJSONArray.length()) {
                        this.f15625b.add(optJSONArray.optString(i));
                        i++;
                    }
                }
            } catch (Throwable e) {
                mt.m19921c("Exception occurred while processing app setting json", e);
                ax.i().m30834a(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    /* renamed from: a */
    public final long m19580a() {
        return this.f15624a;
    }

    /* renamed from: b */
    public final boolean m19581b() {
        return this.f15630g;
    }

    /* renamed from: c */
    public final String m19582c() {
        return this.f15629f;
    }

    /* renamed from: d */
    public final String m19583d() {
        return this.f15628e;
    }

    /* renamed from: e */
    public final Map<String, bci> m19584e() {
        return this.f15627d;
    }
}
