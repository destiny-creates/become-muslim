package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.NativeAdView.Type;
import com.facebook.ads.internal.adapters.C3572y;
import com.facebook.ads.internal.p093h.C1389d;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1426g;
import com.facebook.ads.internal.protocol.C1487f;
import java.util.ArrayList;
import java.util.List;

public class NativeAd extends NativeAdBase {
    public NativeAd(Context context, C3572y c3572y, C1389d c1389d) {
        super(context, c3572y, c1389d);
        m11393a(C1487f.NATIVE_UNKNOWN);
    }

    public NativeAd(Context context, String str) {
        super(context, str);
        m11393a(C1487f.NATIVE_UNKNOWN);
    }

    NativeAd(NativeAdBase nativeAdBase) {
        super(nativeAdBase);
    }

    NativeAd(C1425f c1425f) {
        super(c1425f);
    }

    /* renamed from: a */
    String m15474a() {
        return m11395g().m4972B();
    }

    /* renamed from: a */
    void m15475a(Type type) {
        m11395g().m4988a(type.m4423a());
    }

    /* renamed from: b */
    String m15476b() {
        return m11395g().m4973C();
    }

    /* renamed from: c */
    String m15477c() {
        return m11395g().m4974D();
    }

    /* renamed from: d */
    VideoAutoplayBehavior m15478d() {
        return VideoAutoplayBehavior.fromInternalAutoplayBehavior(m11395g().m4975E());
    }

    /* renamed from: e */
    List<NativeAd> m15479e() {
        if (m11395g().m4976F() == null) {
            return null;
        }
        List<NativeAd> arrayList = new ArrayList();
        for (C1425f nativeAd : m11395g().m4976F()) {
            arrayList.add(new NativeAd(nativeAd));
        }
        return arrayList;
    }

    /* renamed from: f */
    Type m15480f() {
        return m11395g().m4979I() == null ? null : Type.m4422a(m11395g().m4979I());
    }

    public void registerViewForInteraction(View view, MediaView mediaView) {
        registerViewForInteraction(view, mediaView, (AdIconView) null);
    }

    public void registerViewForInteraction(View view, MediaView mediaView, AdIconView adIconView) {
        registerViewForInteraction(view, mediaView, adIconView, null);
    }

    public void registerViewForInteraction(View view, MediaView mediaView, AdIconView adIconView, List<View> list) {
        if (mediaView != null) {
            mediaView.setNativeAd(this);
        }
        if (adIconView != null) {
            adIconView.setNativeAd(this);
        }
        if (list != null) {
            m11395g().m4984a(view, (C1426g) mediaView, (List) list);
        } else {
            m11395g().m4983a(view, (C1426g) mediaView);
        }
    }

    public void registerViewForInteraction(View view, MediaView mediaView, List<View> list) {
        registerViewForInteraction(view, mediaView, null, list);
    }
}
