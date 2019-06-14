package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.C2631d;
import com.google.android.gms.ads.mediation.C2681a;
import com.google.android.gms.ads.mediation.C2684c;
import com.google.android.gms.ads.mediation.C2689d;
import com.google.android.gms.ads.mediation.C2690e;
import com.google.android.gms.ads.mediation.C4301i;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.ads.mt;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    /* renamed from: a */
    private View f13088a;
    /* renamed from: b */
    private CustomEventBanner f13089b;
    /* renamed from: c */
    private CustomEventInterstitial f13090c;
    /* renamed from: d */
    private CustomEventNative f13091d;

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter$a */
    static final class C4295a implements C2686b {
        /* renamed from: a */
        private final CustomEventAdapter f11329a;
        /* renamed from: b */
        private final C2684c f11330b;

        public C4295a(CustomEventAdapter customEventAdapter, C2684c c2684c) {
            this.f11329a = customEventAdapter;
            this.f11330b = c2684c;
        }
    }

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter$b */
    class C4296b implements C2687d {
        /* renamed from: a */
        private final CustomEventAdapter f11331a;
        /* renamed from: b */
        private final C2689d f11332b;
        /* renamed from: c */
        private final /* synthetic */ CustomEventAdapter f11333c;

        public C4296b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, C2689d c2689d) {
            this.f11333c = customEventAdapter;
            this.f11331a = customEventAdapter2;
            this.f11332b = c2689d;
        }
    }

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter$c */
    static class C4297c implements C2688e {
        /* renamed from: a */
        private final CustomEventAdapter f11334a;
        /* renamed from: b */
        private final C2690e f11335b;

        public C4297c(CustomEventAdapter customEventAdapter, C2690e c2690e) {
            this.f11334a = customEventAdapter;
            this.f11335b = c2690e;
        }
    }

    /* renamed from: a */
    private static <T> T m16609a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 46) + String.valueOf(message).length());
            stringBuilder.append("Could not instantiate custom event adapter: ");
            stringBuilder.append(str);
            stringBuilder.append(". ");
            stringBuilder.append(message);
            mt.e(stringBuilder.toString());
            return null;
        }
    }

    public final View getBannerView() {
        return this.f13088a;
    }

    public final void onDestroy() {
        if (this.f13089b != null) {
            this.f13089b.m7589a();
        }
        if (this.f13090c != null) {
            this.f13090c.m7589a();
        }
        if (this.f13091d != null) {
            this.f13091d.m7589a();
        }
    }

    public final void onPause() {
        if (this.f13089b != null) {
            this.f13089b.m7590b();
        }
        if (this.f13090c != null) {
            this.f13090c.m7590b();
        }
        if (this.f13091d != null) {
            this.f13091d.m7590b();
        }
    }

    public final void onResume() {
        if (this.f13089b != null) {
            this.f13089b.m7591c();
        }
        if (this.f13090c != null) {
            this.f13090c.m7591c();
        }
        if (this.f13091d != null) {
            this.f13091d.m7591c();
        }
    }

    public final void requestBannerAd(Context context, C2684c c2684c, Bundle bundle, C2631d c2631d, C2681a c2681a, Bundle bundle2) {
        this.f13089b = (CustomEventBanner) m16609a(bundle.getString("class_name"));
        if (this.f13089b == null) {
            c2684c.m7583a(this, 0);
        } else {
            this.f13089b.requestBannerAd(context, new C4295a(this, c2684c), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), c2631d, c2681a, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public final void requestInterstitialAd(Context context, C2689d c2689d, Bundle bundle, C2681a c2681a, Bundle bundle2) {
        this.f13090c = (CustomEventInterstitial) m16609a(bundle.getString("class_name"));
        if (this.f13090c == null) {
            c2689d.m7593a(this, 0);
        } else {
            this.f13090c.requestInterstitialAd(context, new C4296b(this, this, c2689d), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), c2681a, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public final void requestNativeAd(Context context, C2690e c2690e, Bundle bundle, C4301i c4301i, Bundle bundle2) {
        this.f13091d = (CustomEventNative) m16609a(bundle.getString("class_name"));
        if (this.f13091d == null) {
            c2690e.m7599a((MediationNativeAdapter) this, 0);
        } else {
            this.f13091d.requestNativeAd(context, new C4297c(this, c2690e), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), c4301i, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public final void showInterstitial() {
        this.f13090c.showInterstitial();
    }
}
