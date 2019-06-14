package com.facebook.ads;

import android.graphics.Typeface;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p099n.C1429k;
import org.json.JSONObject;

public class NativeAdViewAttributes {
    /* renamed from: a */
    private C1429k f3706a;

    public NativeAdViewAttributes() {
        this.f3706a = new C1429k();
    }

    NativeAdViewAttributes(C1429k c1429k) {
        this.f3706a = c1429k;
    }

    public NativeAdViewAttributes(JSONObject jSONObject) {
        try {
            this.f3706a = new C1429k(jSONObject);
        } catch (Throwable e) {
            this.f3706a = new C1429k();
            C1398b.m4797a(C1397a.m4794a(e, "Error retrieving native ui configuration data"));
        }
    }

    /* renamed from: a */
    C1429k m4424a() {
        return this.f3706a;
    }

    public boolean getAutoplay() {
        return this.f3706a.m5046j();
    }

    public boolean getAutoplayOnMobile() {
        return this.f3706a.m5047k();
    }

    public int getBackgroundColor() {
        return this.f3706a.m5032b();
    }

    public int getButtonBorderColor() {
        return this.f3706a.m5043g();
    }

    public int getButtonColor() {
        return this.f3706a.m5039e();
    }

    public int getButtonTextColor() {
        return this.f3706a.m5041f();
    }

    public int getDescriptionTextColor() {
        return this.f3706a.m5037d();
    }

    public int getDescriptionTextSize() {
        return this.f3706a.m5045i();
    }

    public int getTitleTextColor() {
        return this.f3706a.m5035c();
    }

    public int getTitleTextSize() {
        return this.f3706a.m5044h();
    }

    public Typeface getTypeface() {
        return this.f3706a.m5028a();
    }

    public NativeAdViewAttributes setAutoplay(boolean z) {
        this.f3706a.m5034b(z);
        return this;
    }

    public NativeAdViewAttributes setAutoplayOnMobile(boolean z) {
        this.f3706a.m5031a(z);
        return this;
    }

    public NativeAdViewAttributes setBackgroundColor(int i) {
        this.f3706a.m5029a(i);
        return this;
    }

    public NativeAdViewAttributes setButtonBorderColor(int i) {
        this.f3706a.m5042f(i);
        return this;
    }

    public NativeAdViewAttributes setButtonColor(int i) {
        this.f3706a.m5038d(i);
        return this;
    }

    public NativeAdViewAttributes setButtonTextColor(int i) {
        this.f3706a.m5040e(i);
        return this;
    }

    public NativeAdViewAttributes setDescriptionTextColor(int i) {
        this.f3706a.m5036c(i);
        return this;
    }

    public NativeAdViewAttributes setTitleTextColor(int i) {
        this.f3706a.m5033b(i);
        return this;
    }

    public NativeAdViewAttributes setTypeface(Typeface typeface) {
        this.f3706a.m5030a(typeface);
        return this;
    }
}
