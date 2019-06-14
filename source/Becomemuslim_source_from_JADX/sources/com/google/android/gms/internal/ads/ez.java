package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug.MemoryInfo;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.applinks.AppLinkData;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.internal.ax;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@cm
public final class ez {
    /* renamed from: a */
    private static final SimpleDateFormat f15371a = new SimpleDateFormat("yyyyMMdd", Locale.US);

    /* renamed from: a */
    public static dp m19396a(Context context, dl dlVar, String str) {
        dl dlVar2 = dlVar;
        String optString;
        try {
            int b;
            int i;
            String str2;
            dp dpVar;
            long j;
            JSONArray optJSONArray;
            List list;
            List list2;
            List list3;
            List a;
            List a2;
            long j2;
            String optString2;
            boolean optBoolean;
            JSONObject jSONObject = new JSONObject(str);
            optString = jSONObject.optString("ad_base_url", null);
            Object optString3 = jSONObject.optString("ad_url", null);
            String optString4 = jSONObject.optString("ad_size", null);
            String optString5 = jSONObject.optString("ad_slot_size", optString4);
            boolean z = (dlVar2 == null || dlVar2.f28557m == 0) ? false : true;
            CharSequence optString6 = jSONObject.optString("ad_json", null);
            if (optString6 == null) {
                optString6 = jSONObject.optString("ad_html", null);
            }
            if (optString6 == null) {
                optString6 = jSONObject.optString("body", null);
            }
            if (optString6 == null && jSONObject.has("ads")) {
                optString6 = jSONObject.toString();
            }
            String optString7 = jSONObject.optString("debug_dialog", null);
            String optString8 = jSONObject.optString("debug_signals", null);
            long j3 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString9 = jSONObject.optString("orientation", null);
            if ("portrait".equals(optString9)) {
                b = ax.g().mo4309b();
            } else if ("landscape".equals(optString9)) {
                b = ax.g().mo4307a();
            } else {
                i = -1;
                if (TextUtils.isEmpty(optString6) || TextUtils.isEmpty(optString3)) {
                    optString9 = optString;
                    str2 = optString6;
                    dpVar = null;
                    j = -1;
                } else {
                    dpVar = eu.m37474a(dlVar, context, dlVar2.f28555k.f28709a, optString3, null, null, null, null, null);
                    String str3 = dpVar.f28596a;
                    optString9 = dpVar.f28597b;
                    j = dpVar.f28608m;
                    str2 = optString9;
                    optString9 = str3;
                }
                if (str2 == null) {
                    return new dp(0);
                }
                optJSONArray = jSONObject.optJSONArray("click_urls");
                list = dpVar != null ? null : dpVar.f28598c;
                if (optJSONArray != null) {
                    list = m19398a(optJSONArray, list);
                }
                optJSONArray = jSONObject.optJSONArray("impression_urls");
                list2 = dpVar != null ? null : dpVar.f28600e;
                if (optJSONArray != null) {
                    list2 = m19398a(optJSONArray, list2);
                }
                optJSONArray = jSONObject.optJSONArray("downloaded_impression_urls");
                list3 = dpVar != null ? null : dpVar.f28589R;
                a = optJSONArray == null ? m19398a(optJSONArray, list3) : list3;
                optJSONArray = jSONObject.optJSONArray("manual_impression_urls");
                list3 = dpVar != null ? null : dpVar.f28604i;
                a2 = optJSONArray == null ? m19398a(optJSONArray, list3) : list3;
                if (dpVar != null) {
                    if (dpVar.f28606k != -1) {
                        i = dpVar.f28606k;
                    }
                    if (dpVar.f28601f > 0) {
                        j2 = dpVar.f28601f;
                        optString2 = jSONObject.optString("active_view");
                        optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                        return new dp(dlVar, optString9, str2, list, list2, j2, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), a2, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, optBoolean ? jSONObject.optString("ad_passback_url", null) : null, optString2, jSONObject.optBoolean("custom_render_allowed", false), z, dlVar2.f28560p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), hq.m37547a(jSONObject.optJSONArray("rewards")), m19398a(jSONObject.optJSONArray("video_start_urls"), null), m19398a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), dr.m37459a(jSONObject.optJSONObject("auto_protection_configuration")), dlVar2.f28525G, jSONObject.optString("set_cookie", ""), m19398a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", dlVar2.f28529K), optString5, ia.m37548a(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true), dlVar2.f28539U, jSONObject.optBoolean("custom_close_blocked"), 0, jSONObject.optBoolean("enable_omid", false), a, jSONObject.optBoolean("disable_closable_area", false), jSONObject.optString("omid_settings", null));
                    }
                }
                j2 = j3;
                optString2 = jSONObject.optString("active_view");
                optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                if (optBoolean) {
                }
                return new dp(dlVar, optString9, str2, list, list2, j2, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), a2, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, optBoolean ? jSONObject.optString("ad_passback_url", null) : null, optString2, jSONObject.optBoolean("custom_render_allowed", false), z, dlVar2.f28560p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), hq.m37547a(jSONObject.optJSONArray("rewards")), m19398a(jSONObject.optJSONArray("video_start_urls"), null), m19398a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), dr.m37459a(jSONObject.optJSONObject("auto_protection_configuration")), dlVar2.f28525G, jSONObject.optString("set_cookie", ""), m19398a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", dlVar2.f28529K), optString5, ia.m37548a(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true), dlVar2.f28539U, jSONObject.optBoolean("custom_close_blocked"), 0, jSONObject.optBoolean("enable_omid", false), a, jSONObject.optBoolean("disable_closable_area", false), jSONObject.optString("omid_settings", null));
            }
            i = b;
            if (TextUtils.isEmpty(optString6)) {
            }
            optString9 = optString;
            str2 = optString6;
            dpVar = null;
            j = -1;
            if (str2 == null) {
                return new dp(0);
            }
            optJSONArray = jSONObject.optJSONArray("click_urls");
            if (dpVar != null) {
            }
            if (optJSONArray != null) {
                list = m19398a(optJSONArray, list);
            }
            optJSONArray = jSONObject.optJSONArray("impression_urls");
            if (dpVar != null) {
            }
            if (optJSONArray != null) {
                list2 = m19398a(optJSONArray, list2);
            }
            optJSONArray = jSONObject.optJSONArray("downloaded_impression_urls");
            if (dpVar != null) {
            }
            if (optJSONArray == null) {
            }
            optJSONArray = jSONObject.optJSONArray("manual_impression_urls");
            if (dpVar != null) {
            }
            if (optJSONArray == null) {
            }
            if (dpVar != null) {
                if (dpVar.f28606k != -1) {
                    i = dpVar.f28606k;
                }
                if (dpVar.f28601f > 0) {
                    j2 = dpVar.f28601f;
                    optString2 = jSONObject.optString("active_view");
                    optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                    if (optBoolean) {
                    }
                    return new dp(dlVar, optString9, str2, list, list2, j2, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), a2, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, optBoolean ? jSONObject.optString("ad_passback_url", null) : null, optString2, jSONObject.optBoolean("custom_render_allowed", false), z, dlVar2.f28560p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), hq.m37547a(jSONObject.optJSONArray("rewards")), m19398a(jSONObject.optJSONArray("video_start_urls"), null), m19398a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), dr.m37459a(jSONObject.optJSONObject("auto_protection_configuration")), dlVar2.f28525G, jSONObject.optString("set_cookie", ""), m19398a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", dlVar2.f28529K), optString5, ia.m37548a(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true), dlVar2.f28539U, jSONObject.optBoolean("custom_close_blocked"), 0, jSONObject.optBoolean("enable_omid", false), a, jSONObject.optBoolean("disable_closable_area", false), jSONObject.optString("omid_settings", null));
                }
            }
            j2 = j3;
            optString2 = jSONObject.optString("active_view");
            optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
            }
            return new dp(dlVar, optString9, str2, list, list2, j2, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), a2, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, optBoolean ? jSONObject.optString("ad_passback_url", null) : null, optString2, jSONObject.optBoolean("custom_render_allowed", false), z, dlVar2.f28560p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), hq.m37547a(jSONObject.optJSONArray("rewards")), m19398a(jSONObject.optJSONArray("video_start_urls"), null), m19398a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), dr.m37459a(jSONObject.optJSONObject("auto_protection_configuration")), dlVar2.f28525G, jSONObject.optString("set_cookie", ""), m19398a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", dlVar2.f28529K), optString5, ia.m37548a(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true), dlVar2.f28539U, jSONObject.optBoolean("custom_close_blocked"), 0, jSONObject.optBoolean("enable_omid", false), a, jSONObject.optBoolean("disable_closable_area", false), jSONObject.optString("omid_settings", null));
        } catch (JSONException e) {
            optString = "Could not parse the inline ad response: ";
            String valueOf = String.valueOf(e.getMessage());
            mt.m19924e(valueOf.length() != 0 ? optString.concat(valueOf) : new String(optString));
            return new dp(0);
        }
    }

    /* renamed from: a */
    private static Integer m19397a(boolean z) {
        return Integer.valueOf(z);
    }

    /* renamed from: a */
    private static List<String> m19398a(JSONArray jSONArray, List<String> list) {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    /* renamed from: a */
    private static JSONArray m19399a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static JSONObject m19400a(Context context, es esVar) {
        String str;
        String str2;
        es esVar2 = esVar;
        dl dlVar = esVar2.f15351j;
        Location location = esVar2.f15345d;
        fi fiVar = esVar2.f15352k;
        Bundle bundle = esVar2.f15342a;
        JSONObject jSONObject = esVar2.f15353l;
        try {
            Object obj;
            int i;
            String str3;
            Bundle bundle2;
            JSONObject jSONObject2;
            Object obj2;
            Object valueOf;
            String str4;
            int i2;
            mv mvVar;
            boolean z;
            boolean z2;
            boolean z3;
            Bundle bundle3;
            Object obj3;
            Bundle bundle4;
            Object obj4;
            Bundle bundle5;
            HashMap hashMap;
            String[] split;
            int length;
            String str5;
            Map hashMap2 = new HashMap();
            hashMap2.put("extra_caps", aph.m18688f().m18889a(asp.bT));
            if (esVar2.f15344c.size() > 0) {
                hashMap2.put("eid", TextUtils.join(",", esVar2.f15344c));
            }
            if (dlVar.f28546b != null) {
                hashMap2.put("ad_pos", dlVar.f28546b);
            }
            aoq aoq = dlVar.f28547c;
            String a = jh.m19602a();
            if (a != null) {
                hashMap2.put("abf", a);
            }
            if (aoq.f28262b != -1) {
                hashMap2.put("cust_age", f15371a.format(new Date(aoq.f28262b)));
            }
            if (aoq.f28263c != null) {
                hashMap2.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, aoq.f28263c);
            }
            int i3 = -1;
            if (aoq.f28264d != -1) {
                hashMap2.put("cust_gender", Integer.valueOf(aoq.f28264d));
            }
            if (aoq.f28265e != null) {
                hashMap2.put("kw", aoq.f28265e);
            }
            if (aoq.f28267g != -1) {
                hashMap2.put("tag_for_child_directed_treatment", Integer.valueOf(aoq.f28267g));
            }
            if (aoq.f28266f) {
                Object valueOf2;
                if (((Boolean) aph.m18688f().m18889a(asp.dk)).booleanValue()) {
                    obj = "test_request";
                    valueOf2 = Boolean.valueOf(true);
                } else {
                    obj = "adtest";
                    valueOf2 = ViewProps.ON;
                }
                hashMap2.put(obj, valueOf2);
            }
            if (aoq.f28261a >= 2) {
                if (aoq.f28268h) {
                    hashMap2.put("d_imp_hdr", Integer.valueOf(1));
                }
                if (!TextUtils.isEmpty(aoq.f28269i)) {
                    hashMap2.put("ppid", aoq.f28269i);
                }
            }
            if (aoq.f28261a >= 3 && aoq.f28272l != null) {
                hashMap2.put("url", aoq.f28272l);
            }
            if (aoq.f28261a >= 5) {
                if (aoq.f28274n != null) {
                    hashMap2.put("custom_targeting", aoq.f28274n);
                }
                if (aoq.f28275o != null) {
                    hashMap2.put("category_exclusions", aoq.f28275o);
                }
                if (aoq.f28276p != null) {
                    hashMap2.put("request_agent", aoq.f28276p);
                }
            }
            if (aoq.f28261a >= 6 && aoq.f28277q != null) {
                hashMap2.put("request_pkg", aoq.f28277q);
            }
            if (aoq.f28261a >= 7) {
                hashMap2.put("is_designed_for_families", Boolean.valueOf(aoq.f28278r));
            }
            if (dlVar.f28548d.f28285g != null) {
                Object obj5 = null;
                Object obj6 = null;
                for (aou aou : dlVar.f28548d.f28285g) {
                    if (!aou.f28287i && r16 == null) {
                        hashMap2.put("format", aou.f28279a);
                        obj5 = 1;
                    }
                    if (aou.f28287i && r17 == null) {
                        hashMap2.put("fluid", "height");
                        obj6 = 1;
                    }
                    if (obj5 != null && r17 != null) {
                        break;
                    }
                }
            } else {
                hashMap2.put("format", dlVar.f28548d.f28279a);
                if (dlVar.f28548d.f28287i) {
                    hashMap2.put("fluid", "height");
                }
            }
            if (dlVar.f28548d.f28283e == -1) {
                hashMap2.put("smart_w", MessengerShareContentUtility.WEBVIEW_RATIO_FULL);
            }
            if (dlVar.f28548d.f28280b == -2) {
                hashMap2.put("smart_h", "auto");
            }
            if (dlVar.f28548d.f28285g != null) {
                StringBuilder stringBuilder = new StringBuilder();
                aou[] aouArr = dlVar.f28548d.f28285g;
                int length2 = aouArr.length;
                int i4 = 0;
                Object obj7 = null;
                while (i4 < length2) {
                    aou aou2 = aouArr[i4];
                    if (aou2.f28287i) {
                        obj7 = 1;
                    } else {
                        if (stringBuilder.length() != 0) {
                            stringBuilder.append("|");
                        }
                        stringBuilder.append(aou2.f28283e == i3 ? (int) (((float) aou2.f28284f) / fiVar.f15457s) : aou2.f28283e);
                        stringBuilder.append("x");
                        stringBuilder.append(aou2.f28280b == -2 ? (int) (((float) aou2.f28281c) / fiVar.f15457s) : aou2.f28280b);
                    }
                    i4++;
                    i3 = -1;
                }
                if (obj7 != null) {
                    if (stringBuilder.length() != 0) {
                        i = 0;
                        stringBuilder.insert(0, "|");
                    } else {
                        i = 0;
                    }
                    stringBuilder.insert(i, "320x50");
                }
                hashMap2.put("sz", stringBuilder);
            }
            if (dlVar.f28557m != 0) {
                hashMap2.put("native_version", Integer.valueOf(dlVar.f28557m));
                hashMap2.put("native_templates", dlVar.f28558n);
                str3 = "native_image_orientation";
                aus aus = dlVar.f28569y;
                if (aus != null) {
                    switch (aus.f28389c) {
                        case 0:
                            break;
                        case 1:
                            obj = "portrait";
                            break;
                        case 2:
                            obj = "landscape";
                            break;
                        default:
                            obj = "not_set";
                            break;
                    }
                }
                obj = "any";
                hashMap2.put(str3, obj);
                if (!dlVar.f28570z.isEmpty()) {
                    hashMap2.put("native_custom_templates", dlVar.f28570z);
                }
                if (dlVar.f28545a >= 24) {
                    hashMap2.put("max_num_ads", Integer.valueOf(dlVar.f28543Y));
                }
                if (!TextUtils.isEmpty(dlVar.f28541W)) {
                    try {
                        hashMap2.put("native_advanced_settings", new JSONArray(dlVar.f28541W));
                    } catch (Throwable e) {
                        mt.m19921c("Problem creating json from native advanced settings", e);
                    }
                }
            }
            if (dlVar.f28540V != null && dlVar.f28540V.size() > 0) {
                for (Integer num : dlVar.f28540V) {
                    Object valueOf3;
                    if (num.intValue() == 2) {
                        obj = "iba";
                        valueOf3 = Boolean.valueOf(true);
                    } else if (num.intValue() == 1) {
                        obj = "ina";
                        valueOf3 = Boolean.valueOf(true);
                    }
                    hashMap2.put(obj, valueOf3);
                }
            }
            if (dlVar.f28548d.f28288j) {
                hashMap2.put("ene", Boolean.valueOf(true));
            }
            if (((Boolean) aph.m18688f().m18889a(asp.ax)).booleanValue()) {
                hashMap2.put("xsrve", Boolean.valueOf(true));
            }
            if (dlVar.f28533O != null) {
                hashMap2.put("is_icon_ad", Boolean.valueOf(true));
                hashMap2.put("icon_ad_expansion_behavior", Integer.valueOf(dlVar.f28533O.f28294a));
            }
            hashMap2.put("slotname", dlVar.f28549e);
            hashMap2.put("pn", dlVar.f28550f.packageName);
            if (dlVar.f28551g != null) {
                hashMap2.put("vc", Integer.valueOf(dlVar.f28551g.versionCode));
            }
            hashMap2.put("ms", esVar2.f15349h);
            hashMap2.put("seq_num", dlVar.f28553i);
            hashMap2.put("session_id", dlVar.f28554j);
            hashMap2.put("js", dlVar.f28555k.f28709a);
            fs fsVar = esVar2.f15346e;
            Bundle bundle6 = dlVar.f28531M;
            Bundle bundle7 = esVar2.f15343b;
            hashMap2.put("am", Integer.valueOf(fiVar.f15439a));
            hashMap2.put("cog", m19397a(fiVar.f15440b));
            hashMap2.put("coh", m19397a(fiVar.f15441c));
            if (!TextUtils.isEmpty(fiVar.f15442d)) {
                hashMap2.put("carrier", fiVar.f15442d);
            }
            hashMap2.put("gl", fiVar.f15443e);
            if (fiVar.f15444f) {
                hashMap2.put("simulator", Integer.valueOf(1));
            }
            if (fiVar.f15445g) {
                hashMap2.put("is_sidewinder", Integer.valueOf(1));
            }
            hashMap2.put("ma", m19397a(fiVar.f15446h));
            hashMap2.put("sp", m19397a(fiVar.f15447i));
            hashMap2.put("hl", fiVar.f15448j);
            if (!TextUtils.isEmpty(fiVar.f15449k)) {
                hashMap2.put("mv", fiVar.f15449k);
            }
            hashMap2.put("muv", Integer.valueOf(fiVar.f15451m));
            if (fiVar.f15452n != -2) {
                hashMap2.put("cnt", Integer.valueOf(fiVar.f15452n));
            }
            hashMap2.put("gnt", Integer.valueOf(fiVar.f15453o));
            hashMap2.put("pt", Integer.valueOf(fiVar.f15454p));
            hashMap2.put("rm", Integer.valueOf(fiVar.f15455q));
            hashMap2.put("riv", Integer.valueOf(fiVar.f15456r));
            Bundle bundle8 = new Bundle();
            bundle8.putString("build_build", fiVar.f15464z);
            bundle8.putString("build_device", fiVar.f15437A);
            Bundle bundle9 = new Bundle();
            bundle9.putBoolean("is_charging", fiVar.f15461w);
            Bundle bundle10 = bundle6;
            bundle9.putDouble("battery_level", fiVar.f15460v);
            bundle8.putBundle("battery", bundle9);
            Bundle bundle11 = new Bundle();
            bundle11.putInt("active_network_state", fiVar.f15463y);
            bundle11.putBoolean("active_network_metered", fiVar.f15462x);
            if (fsVar != null) {
                bundle6 = new Bundle();
                bundle6.putInt("predicted_latency_micros", fsVar.f15498a);
                bundle6.putLong("predicted_down_throughput_bps", fsVar.f15499b);
                bundle6.putLong("predicted_up_throughput_bps", fsVar.f15500c);
                bundle11.putBundle("predictions", bundle6);
            }
            bundle8.putBundle("network", bundle11);
            Bundle bundle12 = new Bundle();
            bundle12.putBoolean("is_browser_custom_tabs_capable", fiVar.f15438B);
            bundle8.putBundle("browser", bundle12);
            if (bundle10 != null) {
                str3 = "android_mem_info";
                bundle11 = new Bundle();
                bundle2 = bundle;
                jSONObject2 = jSONObject;
                bundle9 = bundle10;
                bundle11.putString("runtime_free", Long.toString(bundle9.getLong("runtime_free_memory", -1)));
                bundle11.putString("runtime_max", Long.toString(bundle9.getLong("runtime_max_memory", -1)));
                bundle11.putString("runtime_total", Long.toString(bundle9.getLong("runtime_total_memory", -1)));
                i = 0;
                bundle11.putString("web_view_count", Integer.toString(bundle9.getInt("web_view_count", 0)));
                MemoryInfo memoryInfo = (MemoryInfo) bundle9.getParcelable("debug_memory_info");
                if (memoryInfo != null) {
                    bundle11.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
                    bundle11.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
                    bundle11.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
                    bundle11.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
                    bundle11.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
                    bundle11.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
                    bundle11.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
                    bundle11.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
                    bundle11.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
                }
                bundle8.putBundle(str3, bundle11);
            } else {
                bundle2 = bundle;
                jSONObject2 = jSONObject;
                i = 0;
            }
            bundle = new Bundle();
            bundle.putBundle("parental_controls", bundle7);
            if (!TextUtils.isEmpty(fiVar.f15450l)) {
                bundle.putString("package_version", fiVar.f15450l);
            }
            bundle8.putBundle("play_store", bundle);
            hashMap2.put("device", bundle8);
            bundle = new Bundle();
            bundle.putString("doritos", esVar2.f15347f);
            bundle.putString("doritos_v2", esVar2.f15348g);
            if (((Boolean) aph.m18688f().m18889a(asp.aJ)).booleanValue()) {
                Object id;
                boolean isLimitAdTrackingEnabled;
                String str6;
                if (esVar2.f15350i != null) {
                    id = esVar2.f15350i.getId();
                    isLimitAdTrackingEnabled = esVar2.f15350i.isLimitAdTrackingEnabled();
                } else {
                    id = null;
                    isLimitAdTrackingEnabled = false;
                }
                if (TextUtils.isEmpty(id)) {
                    aph.m18683a();
                    bundle.putString("pdid", mi.m19876b(context));
                    str6 = "pdidtype";
                    str3 = "ssaid";
                } else {
                    bundle.putString("rdid", id);
                    bundle.putBoolean("is_lat", isLimitAdTrackingEnabled);
                    str6 = "idtype";
                    str3 = "adid";
                }
                bundle.putString(str6, str3);
            }
            hashMap2.put("pii", bundle);
            hashMap2.put("platform", Build.MANUFACTURER);
            hashMap2.put("submodel", Build.MODEL);
            if (location == null) {
                if (dlVar.f28547c.f28261a >= 2 && dlVar.f28547c.f28271k != null) {
                    location = dlVar.f28547c.f28271k;
                }
                if (dlVar.f28545a >= 2) {
                    hashMap2.put("quality_signals", dlVar.f28556l);
                }
                if (dlVar.f28545a >= 4 && dlVar.f28560p) {
                    hashMap2.put("forceHttps", Boolean.valueOf(dlVar.f28560p));
                }
                if (bundle2 != null) {
                    hashMap2.put("content_info", bundle2);
                }
                if (dlVar.f28545a < 5) {
                    hashMap2.put("u_sd", Float.valueOf(dlVar.f28563s));
                    hashMap2.put("sh", Integer.valueOf(dlVar.f28562r));
                    obj2 = "sw";
                    valueOf = Integer.valueOf(dlVar.f28561q);
                } else {
                    hashMap2.put("u_sd", Float.valueOf(fiVar.f15457s));
                    hashMap2.put("sh", Integer.valueOf(fiVar.f15459u));
                    obj2 = "sw";
                    valueOf = Integer.valueOf(fiVar.f15458t);
                }
                hashMap2.put(obj2, valueOf);
                if (dlVar.f28545a >= 6) {
                    if (!TextUtils.isEmpty(dlVar.f28564t)) {
                        try {
                            hashMap2.put("view_hierarchy", new JSONObject(dlVar.f28564t));
                        } catch (Throwable e2) {
                            mt.m19921c("Problem serializing view hierarchy to JSON", e2);
                        }
                    }
                    hashMap2.put("correlation_id", Long.valueOf(dlVar.f28565u));
                }
                if (dlVar.f28545a >= 7) {
                    hashMap2.put("request_id", dlVar.f28566v);
                }
                if (dlVar.f28545a >= 12 && !TextUtils.isEmpty(dlVar.f28520B)) {
                    hashMap2.put("anchor", dlVar.f28520B);
                }
                if (dlVar.f28545a >= 13) {
                    hashMap2.put("android_app_volume", Float.valueOf(dlVar.f28521C));
                }
                if (dlVar.f28545a >= 18) {
                    hashMap2.put("android_app_muted", Boolean.valueOf(dlVar.f28527I));
                }
                if (dlVar.f28545a >= 14 && dlVar.f28522D > 0) {
                    hashMap2.put("target_api", Integer.valueOf(dlVar.f28522D));
                }
                if (dlVar.f28545a >= 15) {
                    str4 = "scroll_index";
                    i2 = -1;
                    if (dlVar.f28523E == -1) {
                        i2 = dlVar.f28523E;
                    }
                    hashMap2.put(str4, Integer.valueOf(i2));
                }
                if (dlVar.f28545a >= 16) {
                    hashMap2.put("_activity_context", Boolean.valueOf(dlVar.f28524F));
                }
                if (dlVar.f28545a >= 18) {
                    if (!TextUtils.isEmpty(dlVar.f28528J)) {
                        try {
                            hashMap2.put("app_settings", new JSONObject(dlVar.f28528J));
                        } catch (Throwable e22) {
                            mt.m19921c("Problem creating json from app settings", e22);
                        }
                    }
                    hashMap2.put("render_in_browser", Boolean.valueOf(dlVar.f28529K));
                }
                if (dlVar.f28545a >= 18) {
                    hashMap2.put("android_num_video_cache_tasks", Integer.valueOf(dlVar.f28530L));
                }
                mvVar = dlVar.f28555k;
                z = dlVar.f28544Z;
                z2 = esVar2.f15354m;
                z3 = dlVar.ab;
                bundle3 = new Bundle();
                bundle12 = new Bundle();
                bundle12.putString("cl", "193400285");
                bundle12.putString("rapid_rc", "dev");
                bundle12.putString("rapid_rollup", "HEAD");
                bundle3.putBundle("build_meta", bundle12);
                bundle3.putString("mf", Boolean.toString(((Boolean) aph.m18688f().m18889a(asp.bV)).booleanValue()));
                bundle3.putBoolean("instant_app", z);
                bundle3.putBoolean("lite", mvVar.f28713e);
                bundle3.putBoolean("local_service", z2);
                bundle3.putBoolean("is_privileged_process", z3);
                hashMap2.put("sdk_env", bundle3);
                hashMap2.put("cache_state", jSONObject2);
                if (dlVar.f28545a >= 19) {
                    hashMap2.put("gct", dlVar.f28532N);
                }
                if (dlVar.f28545a >= 21 && dlVar.f28534P) {
                    hashMap2.put("de", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
                if (((Boolean) aph.m18688f().m18889a(asp.aT)).booleanValue()) {
                    str = dlVar.f28548d.f28279a;
                    if (!str.equals("interstitial_mb")) {
                        if (str.equals("reward_mb")) {
                            obj3 = null;
                            bundle4 = dlVar.f28535Q;
                            obj4 = bundle4 == null ? 1 : null;
                            if (!(obj3 == null || obj4 == null)) {
                                bundle5 = new Bundle();
                                bundle5.putBundle("interstitial_pool", bundle4);
                                hashMap2.put("counters", bundle5);
                            }
                        }
                    }
                    obj3 = 1;
                    bundle4 = dlVar.f28535Q;
                    if (bundle4 == null) {
                    }
                    bundle5 = new Bundle();
                    bundle5.putBundle("interstitial_pool", bundle4);
                    hashMap2.put("counters", bundle5);
                }
                if (dlVar.f28536R != null) {
                    hashMap2.put("gmp_app_id", dlVar.f28536R);
                }
                if (dlVar.f28537S != null) {
                    obj3 = "fbs_aiid";
                    obj2 = "";
                } else if ("TIME_OUT".equals(dlVar.f28537S)) {
                    obj3 = "fbs_aiid";
                    obj2 = dlVar.f28537S;
                } else {
                    obj3 = "sai_timeout";
                    obj2 = aph.m18688f().m18889a(asp.av);
                }
                hashMap2.put(obj3, obj2);
                if (dlVar.f28538T != null) {
                    hashMap2.put("fbs_aeid", dlVar.f28538T);
                }
                if (dlVar.f28545a >= 24) {
                    hashMap2.put("disable_ml", Boolean.valueOf(dlVar.aa));
                }
                str = (String) aph.m18688f().m18889a(asp.f14914E);
                if (!(str == null || str.isEmpty())) {
                    if (VERSION.SDK_INT >= ((Integer) aph.m18688f().m18889a(asp.f14915F)).intValue()) {
                        hashMap = new HashMap();
                        split = str.split(",");
                        length = split.length;
                        for (i = 
/*
Method generation error in method: com.google.android.gms.internal.ads.ez.a(android.content.Context, com.google.android.gms.internal.ads.es):org.json.JSONObject, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r10_118 'i' int) = (r10_116 'i' int), (r10_117 'i' int) binds: {(r10_116 'i' int)=B:191:0x0544, (r10_117 'i' int)=B:192:0x0548} in method: com.google.android.gms.internal.ads.ez.a(android.content.Context, com.google.android.gms.internal.ads.es):org.json.JSONObject, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:279)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:187)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:12)
	at jadx.core.ProcessClass.process(ProcessClass.java:40)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 36 more

*/

                        /* renamed from: a */
                        public static JSONObject m19401a(dp dpVar) {
                            String str;
                            Object obj;
                            JSONObject jSONObject = new JSONObject();
                            if (dpVar.f28596a != null) {
                                jSONObject.put("ad_base_url", dpVar.f28596a);
                            }
                            if (dpVar.f28607l != null) {
                                jSONObject.put("ad_size", dpVar.f28607l);
                            }
                            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, dpVar.f28614s);
                            jSONObject.put(dpVar.f28614s ? "ad_json" : "ad_html", dpVar.f28597b);
                            if (dpVar.f28609n != null) {
                                jSONObject.put("debug_dialog", dpVar.f28609n);
                            }
                            if (dpVar.f28583L != null) {
                                jSONObject.put("debug_signals", dpVar.f28583L);
                            }
                            if (dpVar.f28601f != -1) {
                                jSONObject.put("interstitial_timeout", ((double) dpVar.f28601f) / 1000.0d);
                            }
                            if (dpVar.f28606k == ax.g().mo4309b()) {
                                str = "orientation";
                                obj = "portrait";
                            } else {
                                if (dpVar.f28606k == ax.g().mo4307a()) {
                                    str = "orientation";
                                    obj = "landscape";
                                }
                                if (dpVar.f28598c != null) {
                                    jSONObject.put("click_urls", m19399a(dpVar.f28598c));
                                }
                                if (dpVar.f28600e != null) {
                                    jSONObject.put("impression_urls", m19399a(dpVar.f28600e));
                                }
                                if (dpVar.f28589R != null) {
                                    jSONObject.put("downloaded_impression_urls", m19399a(dpVar.f28589R));
                                }
                                if (dpVar.f28604i != null) {
                                    jSONObject.put("manual_impression_urls", m19399a(dpVar.f28604i));
                                }
                                if (dpVar.f28612q != null) {
                                    jSONObject.put("active_view", dpVar.f28612q);
                                }
                                jSONObject.put("ad_is_javascript", dpVar.f28610o);
                                if (dpVar.f28611p != null) {
                                    jSONObject.put("ad_passback_url", dpVar.f28611p);
                                }
                                jSONObject.put("mediation", dpVar.f28602g);
                                jSONObject.put("custom_render_allowed", dpVar.f28613r);
                                jSONObject.put("content_url_opted_out", dpVar.f28616u);
                                jSONObject.put("content_vertical_opted_out", dpVar.f28584M);
                                jSONObject.put("prefetch", dpVar.f28617v);
                                if (dpVar.f28605j != -1) {
                                    jSONObject.put("refresh_interval_milliseconds", dpVar.f28605j);
                                }
                                if (dpVar.f28603h != -1) {
                                    jSONObject.put("mediation_config_cache_time_milliseconds", dpVar.f28603h);
                                }
                                if (!TextUtils.isEmpty(dpVar.f28619x)) {
                                    jSONObject.put("gws_query_id", dpVar.f28619x);
                                }
                                jSONObject.put("fluid", dpVar.f28620y ? "height" : "");
                                jSONObject.put("native_express", dpVar.f28621z);
                                if (dpVar.f28573B != null) {
                                    jSONObject.put("video_start_urls", m19399a(dpVar.f28573B));
                                }
                                if (dpVar.f28574C != null) {
                                    jSONObject.put("video_complete_urls", m19399a(dpVar.f28574C));
                                }
                                if (dpVar.f28572A != null) {
                                    hq hqVar = dpVar.f28572A;
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("rb_type", hqVar.f28691a);
                                    jSONObject2.put("rb_amount", hqVar.f28692b);
                                    JSONArray jSONArray = new JSONArray();
                                    jSONArray.put(jSONObject2);
                                    jSONObject.put("rewards", jSONArray);
                                }
                                jSONObject.put("use_displayed_impression", dpVar.f28575D);
                                jSONObject.put("auto_protection_configuration", dpVar.f28576E);
                                jSONObject.put("render_in_browser", dpVar.f28580I);
                                jSONObject.put("disable_closable_area", dpVar.f28590S);
                                return jSONObject;
                            }
                            jSONObject.put(str, obj);
                            if (dpVar.f28598c != null) {
                                jSONObject.put("click_urls", m19399a(dpVar.f28598c));
                            }
                            if (dpVar.f28600e != null) {
                                jSONObject.put("impression_urls", m19399a(dpVar.f28600e));
                            }
                            if (dpVar.f28589R != null) {
                                jSONObject.put("downloaded_impression_urls", m19399a(dpVar.f28589R));
                            }
                            if (dpVar.f28604i != null) {
                                jSONObject.put("manual_impression_urls", m19399a(dpVar.f28604i));
                            }
                            if (dpVar.f28612q != null) {
                                jSONObject.put("active_view", dpVar.f28612q);
                            }
                            jSONObject.put("ad_is_javascript", dpVar.f28610o);
                            if (dpVar.f28611p != null) {
                                jSONObject.put("ad_passback_url", dpVar.f28611p);
                            }
                            jSONObject.put("mediation", dpVar.f28602g);
                            jSONObject.put("custom_render_allowed", dpVar.f28613r);
                            jSONObject.put("content_url_opted_out", dpVar.f28616u);
                            jSONObject.put("content_vertical_opted_out", dpVar.f28584M);
                            jSONObject.put("prefetch", dpVar.f28617v);
                            if (dpVar.f28605j != -1) {
                                jSONObject.put("refresh_interval_milliseconds", dpVar.f28605j);
                            }
                            if (dpVar.f28603h != -1) {
                                jSONObject.put("mediation_config_cache_time_milliseconds", dpVar.f28603h);
                            }
                            if (TextUtils.isEmpty(dpVar.f28619x)) {
                                jSONObject.put("gws_query_id", dpVar.f28619x);
                            }
                            if (dpVar.f28620y) {
                            }
                            jSONObject.put("fluid", dpVar.f28620y ? "height" : "");
                            jSONObject.put("native_express", dpVar.f28621z);
                            if (dpVar.f28573B != null) {
                                jSONObject.put("video_start_urls", m19399a(dpVar.f28573B));
                            }
                            if (dpVar.f28574C != null) {
                                jSONObject.put("video_complete_urls", m19399a(dpVar.f28574C));
                            }
                            if (dpVar.f28572A != null) {
                                hq hqVar2 = dpVar.f28572A;
                                JSONObject jSONObject22 = new JSONObject();
                                jSONObject22.put("rb_type", hqVar2.f28691a);
                                jSONObject22.put("rb_amount", hqVar2.f28692b);
                                JSONArray jSONArray2 = new JSONArray();
                                jSONArray2.put(jSONObject22);
                                jSONObject.put("rewards", jSONArray2);
                            }
                            jSONObject.put("use_displayed_impression", dpVar.f28575D);
                            jSONObject.put("auto_protection_configuration", dpVar.f28576E);
                            jSONObject.put("render_in_browser", dpVar.f28580I);
                            jSONObject.put("disable_closable_area", dpVar.f28590S);
                            return jSONObject;
                        }

                        /* renamed from: a */
                        private static void m19402a(HashMap<String, Object> hashMap, Location location) {
                            HashMap hashMap2 = new HashMap();
                            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
                            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
                            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
                            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
                            hashMap2.put("radius", valueOf);
                            hashMap2.put("lat", valueOf3);
                            hashMap2.put("long", valueOf4);
                            hashMap2.put("time", valueOf2);
                            hashMap.put("uule", hashMap2);
                        }
                    }
