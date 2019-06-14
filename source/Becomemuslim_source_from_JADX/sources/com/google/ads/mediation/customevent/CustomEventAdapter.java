package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.C2172a.C2170a;
import com.google.ads.C2173b;
import com.google.ads.mediation.C2174a;
import com.google.ads.mediation.C2176c;
import com.google.ads.mediation.C2180d;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.customevent.C4298c;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.ads.mt;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<C4298c, C4065d>, MediationInterstitialAdapter<C4298c, C4065d> {
    /* renamed from: a */
    private View f12640a;
    /* renamed from: b */
    private CustomEventBanner f12641b;
    /* renamed from: c */
    private CustomEventInterstitial f12642c;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    static final class C4063a implements C2178b {
        /* renamed from: a */
        private final CustomEventAdapter f10145a;
        /* renamed from: b */
        private final C2176c f10146b;

        public C4063a(CustomEventAdapter customEventAdapter, C2176c c2176c) {
            this.f10145a = customEventAdapter;
            this.f10146b = c2176c;
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    class C4064b implements C2179c {
        /* renamed from: a */
        private final CustomEventAdapter f10147a;
        /* renamed from: b */
        private final C2180d f10148b;
        /* renamed from: c */
        private final /* synthetic */ CustomEventAdapter f10149c;

        public C4064b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, C2180d c2180d) {
            this.f10149c = customEventAdapter;
            this.f10147a = customEventAdapter2;
            this.f10148b = c2180d;
        }
    }

    /* renamed from: a */
    private static <T> T m15996a(String str) {
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

    public final void destroy() {
        if (this.f12641b != null) {
            this.f12641b.m6015a();
        }
        if (this.f12642c != null) {
            this.f12642c.m6015a();
        }
    }

    public final Class<C4298c> getAdditionalParametersType() {
        return C4298c.class;
    }

    public final View getBannerView() {
        return this.f12640a;
    }

    public final Class<C4065d> getServerParametersType() {
        return C4065d.class;
    }

    public final void requestBannerAd(C2176c c2176c, Activity activity, C4065d c4065d, C2173b c2173b, C2174a c2174a, C4298c c4298c) {
        this.f12641b = (CustomEventBanner) m15996a(c4065d.f10151b);
        if (this.f12641b == null) {
            c2176c.m6014a(this, C2170a.INTERNAL_ERROR);
        } else {
            this.f12641b.requestBannerAd(new C4063a(this, c2176c), activity, c4065d.f10150a, c4065d.f10152c, c2173b, c2174a, c4298c == null ? null : c4298c.m13926a(c4065d.f10150a));
        }
    }

    public final void requestInterstitialAd(C2180d c2180d, Activity activity, C4065d c4065d, C2174a c2174a, C4298c c4298c) {
        this.f12642c = (CustomEventInterstitial) m15996a(c4065d.f10151b);
        if (this.f12642c == null) {
            c2180d.m6016a(this, C2170a.INTERNAL_ERROR);
        } else {
            this.f12642c.requestInterstitialAd(new C4064b(this, this, c2180d), activity, c4065d.f10150a, c4065d.f10152c, c2174a, c4298c == null ? null : c4298c.m13926a(c4065d.f10150a));
        }
    }

    public final void showInterstitial() {
        this.f12642c.showInterstitial();
    }
}
