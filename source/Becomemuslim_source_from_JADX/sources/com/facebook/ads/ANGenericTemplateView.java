package com.facebook.ads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p099n.C1416a;
import com.facebook.ads.internal.p099n.C1429k;
import com.facebook.ads.internal.p099n.C1430l;

public class ANGenericTemplateView extends RelativeLayout {
    /* renamed from: a */
    private final C1416a f3629a;

    public ANGenericTemplateView(Context context, NativeAdBase nativeAdBase, C1429k c1429k) {
        MediaView mediaView;
        C1430l a;
        super(context);
        AdIconView adIconView = new AdIconView(getContext());
        if (nativeAdBase instanceof NativeAd) {
            MediaView mediaView2 = new MediaView(getContext());
            NativeAd nativeAd = (NativeAd) nativeAdBase;
            mediaView2.setNativeAd(nativeAd);
            adIconView.setNativeAd(nativeAd);
            mediaView = mediaView2;
            a = nativeAd.m15480f().m4423a();
        } else {
            NativeBannerAd nativeBannerAd = (NativeBannerAd) nativeAdBase;
            adIconView.setNativeBannerAd(nativeBannerAd);
            a = nativeBannerAd.m15486a().m4431a();
            mediaView = null;
        }
        this.f3629a = new C1416a(context, nativeAdBase.m11395g(), this, new AdChoicesView(getContext(), nativeAdBase, true), mediaView, adIconView, a, c1429k);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3629a.m4902a();
    }
}
