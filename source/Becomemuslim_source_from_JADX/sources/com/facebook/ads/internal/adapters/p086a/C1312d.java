package com.facebook.ads.internal.adapters.p086a;

import android.graphics.Color;
import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.a.d */
public class C1312d implements Serializable {
    /* renamed from: a */
    public static final int f3793a = Color.parseColor("#90949c");
    /* renamed from: b */
    public static final int f3794b = Color.parseColor("#4b4f56");
    /* renamed from: c */
    public static final int f3795c = Color.parseColor("#f6f7f9");
    /* renamed from: d */
    public static final int f3796d = Color.parseColor("#ff4080ff");
    /* renamed from: e */
    public static final int f3797e = Color.parseColor("#23272F");
    /* renamed from: f */
    public static final int f3798f = Color.parseColor("#ff4080ff");
    private static final long serialVersionUID = 8946536326456653736L;
    /* renamed from: g */
    private int f3799g = f3793a;
    /* renamed from: h */
    private int f3800h = f3794b;
    /* renamed from: i */
    private int f3801i = -16777216;
    /* renamed from: j */
    private int f3802j = f3795c;
    /* renamed from: k */
    private int f3803k = f3796d;
    /* renamed from: l */
    private int f3804l = -1;
    /* renamed from: m */
    private int f3805m = -16777216;

    /* renamed from: a */
    public static C1312d m4505a(JSONObject jSONObject) {
        C1312d c1312d = new C1312d();
        if (jSONObject != null) {
            Object optString = jSONObject.optString("accent_color");
            Object optString2 = jSONObject.optString("body_color");
            Object optString3 = jSONObject.optString("subtitle_color");
            Object optString4 = jSONObject.optString("bg_color");
            Object optString5 = jSONObject.optString("cta_color");
            Object optString6 = jSONObject.optString("cta_text_color");
            Object optString7 = jSONObject.optString("title_color");
            if (!TextUtils.isEmpty(optString)) {
                c1312d.f3799g = Color.parseColor(optString);
            }
            if (!TextUtils.isEmpty(optString2)) {
                c1312d.f3800h = Color.parseColor(optString2);
            }
            if (!TextUtils.isEmpty(optString3)) {
                c1312d.f3801i = Color.parseColor(optString3);
            }
            if (!TextUtils.isEmpty(optString4)) {
                c1312d.f3802j = Color.parseColor(optString4);
            }
            if (!TextUtils.isEmpty(optString5)) {
                c1312d.f3803k = Color.parseColor(optString5);
            }
            if (!TextUtils.isEmpty(optString6)) {
                c1312d.f3804l = Color.parseColor(optString6);
            }
            if (!TextUtils.isEmpty(optString7)) {
                c1312d.f3805m = Color.parseColor(optString7);
            }
        }
        return c1312d;
    }

    /* renamed from: a */
    public int m4506a(boolean z) {
        return z ? -1 : this.f3799g;
    }

    /* renamed from: b */
    public int m4507b(boolean z) {
        return z ? -1 : this.f3800h;
    }

    /* renamed from: c */
    public int m4508c(boolean z) {
        return z ? -1 : this.f3801i;
    }

    /* renamed from: d */
    public int m4509d(boolean z) {
        return z ? f3797e : this.f3802j;
    }

    /* renamed from: e */
    public int m4510e(boolean z) {
        return z ? -1 : this.f3803k;
    }

    /* renamed from: f */
    public int m4511f(boolean z) {
        return z ? f3798f : this.f3804l;
    }

    /* renamed from: g */
    public int m4512g(boolean z) {
        return z ? -1 : this.f3805m;
    }
}
