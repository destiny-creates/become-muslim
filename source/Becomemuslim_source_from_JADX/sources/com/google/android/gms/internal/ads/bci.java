package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@cm
public final class bci {
    /* renamed from: a */
    public final List<bch> f15194a;
    /* renamed from: b */
    public final long f15195b;
    /* renamed from: c */
    public final List<String> f15196c;
    /* renamed from: d */
    public final List<String> f15197d;
    /* renamed from: e */
    public final List<String> f15198e;
    /* renamed from: f */
    public final List<String> f15199f;
    /* renamed from: g */
    public final List<String> f15200g;
    /* renamed from: h */
    public final boolean f15201h;
    /* renamed from: i */
    public final String f15202i;
    /* renamed from: j */
    public final long f15203j;
    /* renamed from: k */
    public final String f15204k;
    /* renamed from: l */
    public final int f15205l;
    /* renamed from: m */
    public final int f15206m;
    /* renamed from: n */
    public final long f15207n;
    /* renamed from: o */
    public final boolean f15208o;
    /* renamed from: p */
    public final boolean f15209p;
    /* renamed from: q */
    public final boolean f15210q;
    /* renamed from: r */
    public int f15211r;
    /* renamed from: s */
    public int f15212s;
    /* renamed from: t */
    public boolean f15213t;

    public bci(String str) {
        this(new JSONObject(str));
    }

    public bci(List<bch> list, long j, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, boolean z, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3, boolean z2) {
        this.f15194a = list;
        this.f15195b = j;
        this.f15196c = list2;
        this.f15197d = list3;
        this.f15198e = list4;
        this.f15199f = list5;
        this.f15200g = list6;
        this.f15201h = z;
        this.f15202i = str;
        this.f15203j = -1;
        this.f15211r = 0;
        this.f15212s = 1;
        this.f15204k = null;
        this.f15205l = 0;
        this.f15206m = -1;
        this.f15207n = -1;
        this.f15208o = false;
        this.f15209p = false;
        this.f15210q = false;
        this.f15213t = false;
    }

    public bci(JSONObject jSONObject) {
        if (mt.m19917a(2)) {
            String str = "Mediation Response JSON: ";
            String valueOf = String.valueOf(jSONObject.toString(2));
            jn.m30864a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            bch bch = new bch(jSONArray.getJSONObject(i2));
            boolean z = true;
            if (bch.m19220a()) {
                this.f15213t = true;
            }
            arrayList.add(bch);
            if (i < 0) {
                for (String equals : bch.f15175c) {
                    if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                        break;
                    }
                }
                z = false;
                if (z) {
                    i = i2;
                }
            }
        }
        this.f15211r = i;
        this.f15212s = jSONArray.length();
        this.f15194a = Collections.unmodifiableList(arrayList);
        this.f15202i = jSONObject.optString("qdata");
        this.f15206m = jSONObject.optInt("fs_model_type", -1);
        long j = -1;
        this.f15207n = jSONObject.optLong("timeout_ms", -1);
        jSONObject = jSONObject.optJSONObject("settings");
        if (jSONObject != null) {
            this.f15195b = jSONObject.optLong("ad_network_timeout_millis", -1);
            ax.x();
            this.f15196c = bcr.m19235a(jSONObject, "click_urls");
            ax.x();
            this.f15197d = bcr.m19235a(jSONObject, "imp_urls");
            ax.x();
            this.f15198e = bcr.m19235a(jSONObject, "downloaded_imp_urls");
            ax.x();
            this.f15199f = bcr.m19235a(jSONObject, "nofill_urls");
            ax.x();
            this.f15200g = bcr.m19235a(jSONObject, "remote_ping_urls");
            this.f15201h = jSONObject.optBoolean("render_in_browser", false);
            long optLong = jSONObject.optLong("refresh", -1);
            if (optLong > 0) {
                j = 1000 * optLong;
            }
            this.f15203j = j;
            hq a = hq.m37547a(jSONObject.optJSONArray("rewards"));
            if (a == null) {
                this.f15204k = null;
                this.f15205l = 0;
            } else {
                this.f15204k = a.f28691a;
                this.f15205l = a.f28692b;
            }
            this.f15208o = jSONObject.optBoolean("use_displayed_impression", false);
            this.f15209p = jSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.f15210q = jSONObject.optBoolean("allow_pub_owned_ad_view", false);
            return;
        }
        this.f15195b = -1;
        this.f15196c = null;
        this.f15197d = null;
        this.f15198e = null;
        this.f15199f = null;
        this.f15200g = null;
        this.f15203j = -1;
        this.f15204k = null;
        this.f15205l = 0;
        this.f15208o = false;
        this.f15201h = false;
        this.f15209p = false;
        this.f15210q = false;
    }
}
