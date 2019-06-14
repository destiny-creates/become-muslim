package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.C4742s;
import com.google.android.gms.ads.internal.overlay.C4870q;
import com.google.android.gms.ads.internal.overlay.C4871r;
import com.google.android.gms.ads.internal.overlay.C4872x;
import com.google.android.gms.ads.internal.overlay.C4873y;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.ads.C4936r;
import com.google.android.gms.internal.ads.ab;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.apt;
import com.google.android.gms.internal.ads.apy;
import com.google.android.gms.internal.ads.aql;
import com.google.android.gms.internal.ads.aqq;
import com.google.android.gms.internal.ads.auu;
import com.google.android.gms.internal.ads.auw;
import com.google.android.gms.internal.ads.avi;
import com.google.android.gms.internal.ads.avn;
import com.google.android.gms.internal.ads.bcy;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.fy;
import com.google.android.gms.internal.ads.gh;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.mv;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.HashMap;

@Keep
@DynamiteApi
@cm
public class ClientApi extends aql {
    public apt createAdLoaderBuilder(C2758b c2758b, String str, bcy bcy, int i) {
        Context context = (Context) C4757d.m16685a(c2758b);
        ax.m7464e();
        return new C4738l(context, str, bcy, new mv(C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE, i, true, jw.k(context)), bu.m7504a(context));
    }

    public C4936r createAdOverlay(C2758b c2758b) {
        Activity activity = (Activity) C4757d.m16685a(c2758b);
        AdOverlayInfoParcel a = AdOverlayInfoParcel.m16553a(activity.getIntent());
        if (a == null) {
            return new C4871r(activity);
        }
        switch (a.f13031k) {
            case 1:
                return new C4870q(activity);
            case 2:
                return new C4872x(activity);
            case 3:
                return new C4873y(activity);
            case 4:
                return new C4742s(activity, a);
            default:
                return new C4871r(activity);
        }
    }

    public apy createBannerAdManager(C2758b c2758b, aou aou, String str, bcy bcy, int i) {
        Context context = (Context) C4757d.m16685a(c2758b);
        ax.m7464e();
        return new bw(context, aou, str, bcy, new mv(C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE, i, true, jw.k(context)), bu.m7504a(context));
    }

    public ab createInAppPurchaseManager(C2758b c2758b) {
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.apy createInterstitialAdManager(com.google.android.gms.p174b.C2758b r8, com.google.android.gms.internal.ads.aou r9, java.lang.String r10, com.google.android.gms.internal.ads.bcy r11, int r12) {
        /*
        r7 = this;
        r8 = com.google.android.gms.p174b.C4757d.m16685a(r8);
        r1 = r8;
        r1 = (android.content.Context) r1;
        com.google.android.gms.internal.ads.asp.a(r1);
        r5 = new com.google.android.gms.internal.ads.mv;
        com.google.android.gms.ads.internal.ax.m7464e();
        r8 = com.google.android.gms.internal.ads.jw.k(r1);
        r0 = 1;
        r2 = 12451000; // 0xbdfcb8 float:1.7447567E-38 double:6.1516114E-317;
        r5.<init>(r2, r12, r0, r8);
        r8 = "reward_mb";
        r12 = r9.f28279a;
        r8 = r8.equals(r12);
        if (r8 != 0) goto L_0x0036;
    L_0x0024:
        r12 = com.google.android.gms.internal.ads.asp.aT;
        r2 = com.google.android.gms.internal.ads.aph.f();
        r12 = r2.a(r12);
        r12 = (java.lang.Boolean) r12;
        r12 = r12.booleanValue();
        if (r12 != 0) goto L_0x004c;
    L_0x0036:
        if (r8 == 0) goto L_0x004b;
    L_0x0038:
        r8 = com.google.android.gms.internal.ads.asp.aU;
        r12 = com.google.android.gms.internal.ads.aph.f();
        r8 = r12.a(r8);
        r8 = (java.lang.Boolean) r8;
        r8 = r8.booleanValue();
        if (r8 == 0) goto L_0x004b;
    L_0x004a:
        goto L_0x004c;
    L_0x004b:
        r0 = 0;
    L_0x004c:
        if (r0 == 0) goto L_0x005d;
    L_0x004e:
        r8 = new com.google.android.gms.internal.ads.azj;
        r9 = com.google.android.gms.ads.internal.bu.m7504a(r1);
        r0 = r8;
        r2 = r10;
        r3 = r11;
        r4 = r5;
        r5 = r9;
        r0.<init>(r1, r2, r3, r4, r5);
        return r8;
    L_0x005d:
        r8 = new com.google.android.gms.ads.internal.m;
        r6 = com.google.android.gms.ads.internal.bu.m7504a(r1);
        r0 = r8;
        r2 = r9;
        r3 = r10;
        r4 = r11;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.ClientApi.createInterstitialAdManager(com.google.android.gms.b.b, com.google.android.gms.internal.ads.aou, java.lang.String, com.google.android.gms.internal.ads.bcy, int):com.google.android.gms.internal.ads.apy");
    }

    public avi createNativeAdViewDelegate(C2758b c2758b, C2758b c2758b2) {
        return new auu((FrameLayout) C4757d.m16685a(c2758b), (FrameLayout) C4757d.m16685a(c2758b2));
    }

    public avn createNativeAdViewHolderDelegate(C2758b c2758b, C2758b c2758b2, C2758b c2758b3) {
        return new auw((View) C4757d.m16685a(c2758b), (HashMap) C4757d.m16685a(c2758b2), (HashMap) C4757d.m16685a(c2758b3));
    }

    public gh createRewardedVideoAd(C2758b c2758b, bcy bcy, int i) {
        Context context = (Context) C4757d.m16685a(c2758b);
        ax.m7464e();
        return new fy(context, bu.m7504a(context), bcy, new mv(C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE, i, true, jw.k(context)));
    }

    public apy createSearchAdManager(C2758b c2758b, aou aou, String str, int i) {
        Context context = (Context) C4757d.m16685a(c2758b);
        ax.m7464e();
        return new ar(context, aou, str, new mv(C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE, i, true, jw.k(context)));
    }

    public aqq getMobileAdsSettingsManager(C2758b c2758b) {
        return null;
    }

    public aqq getMobileAdsSettingsManagerWithClientJarVersion(C2758b c2758b, int i) {
        Context context = (Context) C4757d.m16685a(c2758b);
        ax.m7464e();
        return C4745z.m16599a(context, new mv(C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE, i, true, jw.k(context)));
    }
}
