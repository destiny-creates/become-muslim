package com.google.android.gms.internal.ads;

import android.os.IInterface;
import com.google.android.gms.p174b.C2758b;

public interface aqk extends IInterface {
    apt createAdLoaderBuilder(C2758b c2758b, String str, bcy bcy, int i);

    C4936r createAdOverlay(C2758b c2758b);

    apy createBannerAdManager(C2758b c2758b, aou aou, String str, bcy bcy, int i);

    ab createInAppPurchaseManager(C2758b c2758b);

    apy createInterstitialAdManager(C2758b c2758b, aou aou, String str, bcy bcy, int i);

    avi createNativeAdViewDelegate(C2758b c2758b, C2758b c2758b2);

    avn createNativeAdViewHolderDelegate(C2758b c2758b, C2758b c2758b2, C2758b c2758b3);

    gh createRewardedVideoAd(C2758b c2758b, bcy bcy, int i);

    apy createSearchAdManager(C2758b c2758b, aou aou, String str, int i);

    aqq getMobileAdsSettingsManager(C2758b c2758b);

    aqq getMobileAdsSettingsManagerWithClientJarVersion(C2758b c2758b, int i);
}
