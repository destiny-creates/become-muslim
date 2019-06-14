package com.google.ads.mediation;

import android.app.Activity;

@Deprecated
public interface MediationInterstitialAdapter<ADDITIONAL_PARAMETERS extends C2184f, SERVER_PARAMETERS extends C2183e> extends C2175b<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
    void requestInterstitialAd(C2180d c2180d, Activity activity, SERVER_PARAMETERS server_parameters, C2174a c2174a, ADDITIONAL_PARAMETERS additional_parameters);

    void showInterstitial();
}
