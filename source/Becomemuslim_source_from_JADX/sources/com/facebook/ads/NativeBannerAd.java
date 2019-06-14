package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.NativeBannerAdView.Type;
import com.facebook.ads.internal.adapters.C3572y;
import com.facebook.ads.internal.p093h.C1389d;
import com.facebook.ads.internal.p099n.C1426g;
import com.facebook.ads.internal.protocol.C1487f;
import java.util.List;

public class NativeBannerAd extends NativeAdBase {
    public NativeBannerAd(Context context, C3572y c3572y, C1389d c1389d) {
        super(context, c3572y, c1389d);
        m11393a(C1487f.NATIVE_BANNER);
    }

    public NativeBannerAd(Context context, String str) {
        super(context, str);
        m11393a(C1487f.NATIVE_BANNER);
    }

    /* renamed from: a */
    Type m15486a() {
        return m11395g().m4979I() == null ? null : Type.m4430a(m11395g().m4979I());
    }

    /* renamed from: a */
    void m15487a(Type type) {
        m11395g().m4988a(type.m4431a());
    }

    public void registerViewForInteraction(View view, AdIconView adIconView) {
        registerViewForInteraction(view, adIconView, null);
    }

    public void registerViewForInteraction(View view, AdIconView adIconView, List<View> list) {
        if (adIconView != null) {
            adIconView.setNativeBannerAd(this);
        }
        if (list != null) {
            m11395g().m4984a(view, (C1426g) adIconView, (List) list);
        } else {
            m11395g().m4983a(view, (C1426g) adIconView);
        }
    }
}
