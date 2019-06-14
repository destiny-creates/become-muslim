package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.p099n.C1430l;

public class NativeAdView {

    public enum Type {
        HEIGHT_300(C1430l.HEIGHT_300),
        HEIGHT_400(C1430l.HEIGHT_400);
        
        /* renamed from: a */
        private final C1430l f3705a;

        private Type(C1430l c1430l) {
            this.f3705a = c1430l;
        }

        /* renamed from: a */
        static Type m4422a(C1430l c1430l) {
            return c1430l == C1430l.HEIGHT_300 ? HEIGHT_300 : c1430l == C1430l.HEIGHT_400 ? HEIGHT_400 : null;
        }

        /* renamed from: a */
        C1430l m4423a() {
            return this.f3705a;
        }

        public int getHeight() {
            return this.f3705a.m5049b();
        }

        public int getValue() {
            return this.f3705a.m5049b();
        }

        public int getWidth() {
            return this.f3705a.m5048a();
        }
    }

    public static View render(Context context, NativeAd nativeAd, Type type) {
        return render(context, nativeAd, type, null);
    }

    public static View render(Context context, NativeAd nativeAd, Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAd.isNativeConfigEnabled()) {
            nativeAdViewAttributes = nativeAd.getAdViewAttributes();
        } else if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        nativeAd.m15475a(type);
        return new ANGenericTemplateView(context, nativeAd, nativeAdViewAttributes != null ? nativeAdViewAttributes.m4424a() : null);
    }
}
