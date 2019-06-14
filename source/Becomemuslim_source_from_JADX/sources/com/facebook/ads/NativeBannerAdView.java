package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.p099n.C1430l;

public class NativeBannerAdView {

    public enum Type {
        HEIGHT_100(C1430l.HEIGHT_100),
        HEIGHT_120(C1430l.HEIGHT_120);
        
        /* renamed from: a */
        private final C1430l f3719a;

        private Type(C1430l c1430l) {
            this.f3719a = c1430l;
        }

        /* renamed from: a */
        static Type m4430a(C1430l c1430l) {
            return c1430l == C1430l.HEIGHT_100 ? HEIGHT_100 : c1430l == C1430l.HEIGHT_120 ? HEIGHT_120 : null;
        }

        /* renamed from: a */
        C1430l m4431a() {
            return this.f3719a;
        }

        public int getHeight() {
            return this.f3719a.m5049b();
        }

        public int getValue() {
            return this.f3719a.m5049b();
        }

        public int getWidth() {
            return this.f3719a.m5048a();
        }
    }

    public static View render(Context context, NativeBannerAd nativeBannerAd, Type type) {
        return render(context, nativeBannerAd, type, null);
    }

    public static View render(Context context, NativeBannerAd nativeBannerAd, Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeBannerAd.isNativeConfigEnabled()) {
            nativeAdViewAttributes = nativeBannerAd.getAdViewAttributes();
        } else if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        nativeBannerAd.m15487a(type);
        return new ANGenericTemplateView(context, nativeBannerAd, nativeAdViewAttributes != null ? nativeAdViewAttributes.m4424a() : null);
    }
}
