package com.google.ads.mediation;

import android.app.Activity;
import android.view.View;
import com.google.ads.C2173b;

@Deprecated
public interface MediationBannerAdapter<ADDITIONAL_PARAMETERS extends C2184f, SERVER_PARAMETERS extends C2183e> extends C2175b<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
    View getBannerView();

    void requestBannerAd(C2176c c2176c, Activity activity, SERVER_PARAMETERS server_parameters, C2173b c2173b, C2174a c2174a, ADDITIONAL_PARAMETERS additional_parameters);
}
