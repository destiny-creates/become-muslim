package com.facebook.ads.internal.p099n;

import android.graphics.Color;
import android.graphics.Typeface;
import com.facebook.ads.internal.settings.AdInternalSettings;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.n.k */
public class C1429k {
    /* renamed from: a */
    private Typeface f4222a = Typeface.DEFAULT;
    /* renamed from: b */
    private int f4223b = -1;
    /* renamed from: c */
    private int f4224c = -16777216;
    /* renamed from: d */
    private int f4225d = -11643291;
    /* renamed from: e */
    private int f4226e = 0;
    /* renamed from: f */
    private int f4227f = -12420889;
    /* renamed from: g */
    private int f4228g = -12420889;
    /* renamed from: h */
    private boolean f4229h = AdInternalSettings.isVideoAutoplay();
    /* renamed from: i */
    private boolean f4230i = AdInternalSettings.isVideoAutoplayOnMobile();

    public C1429k(JSONObject jSONObject) {
        int parseColor = jSONObject.getBoolean("background_transparent") ? 0 : Color.parseColor(jSONObject.getString("background_color"));
        int parseColor2 = Color.parseColor(jSONObject.getString("title_text_color"));
        int parseColor3 = Color.parseColor(jSONObject.getString("description_text_color"));
        int parseColor4 = jSONObject.getBoolean("button_transparent") ? 0 : Color.parseColor(jSONObject.getString("button_color"));
        int parseColor5 = jSONObject.getBoolean("button_border_transparent") ? 0 : Color.parseColor(jSONObject.getString("button_border_color"));
        int parseColor6 = Color.parseColor(jSONObject.getString("button_text_color"));
        Typeface create = Typeface.create(jSONObject.getString("android_typeface"), 0);
        this.f4223b = parseColor;
        this.f4224c = parseColor2;
        this.f4225d = parseColor3;
        this.f4226e = parseColor4;
        this.f4228g = parseColor5;
        this.f4227f = parseColor6;
        this.f4222a = create;
    }

    /* renamed from: a */
    public Typeface m5028a() {
        return this.f4222a;
    }

    /* renamed from: a */
    public void m5029a(int i) {
        this.f4223b = i;
    }

    /* renamed from: a */
    public void m5030a(Typeface typeface) {
        this.f4222a = typeface;
    }

    /* renamed from: a */
    public void m5031a(boolean z) {
        this.f4230i = z;
    }

    /* renamed from: b */
    public int m5032b() {
        return this.f4223b;
    }

    /* renamed from: b */
    public void m5033b(int i) {
        this.f4224c = i;
    }

    /* renamed from: b */
    public void m5034b(boolean z) {
        this.f4229h = z;
    }

    /* renamed from: c */
    public int m5035c() {
        return this.f4224c;
    }

    /* renamed from: c */
    public void m5036c(int i) {
        this.f4225d = i;
    }

    /* renamed from: d */
    public int m5037d() {
        return this.f4225d;
    }

    /* renamed from: d */
    public void m5038d(int i) {
        this.f4226e = i;
    }

    /* renamed from: e */
    public int m5039e() {
        return this.f4226e;
    }

    /* renamed from: e */
    public void m5040e(int i) {
        this.f4227f = i;
    }

    /* renamed from: f */
    public int m5041f() {
        return this.f4227f;
    }

    /* renamed from: f */
    public void m5042f(int i) {
        this.f4228g = i;
    }

    /* renamed from: g */
    public int m5043g() {
        return this.f4228g;
    }

    /* renamed from: h */
    public int m5044h() {
        return 16;
    }

    /* renamed from: i */
    public int m5045i() {
        return 10;
    }

    /* renamed from: j */
    public boolean m5046j() {
        return this.f4229h;
    }

    /* renamed from: k */
    public boolean m5047k() {
        return this.f4230i;
    }
}
