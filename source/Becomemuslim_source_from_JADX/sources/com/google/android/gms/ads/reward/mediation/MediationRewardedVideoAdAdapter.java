package com.google.android.gms.ads.reward.mediation;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.C2681a;
import com.google.android.gms.ads.mediation.C2683b;

public interface MediationRewardedVideoAdAdapter extends C2683b {
    public static final String CUSTOM_EVENT_SERVER_PARAMETER_FIELD = "parameter";

    void initialize(Context context, C2681a c2681a, String str, C2701a c2701a, Bundle bundle, Bundle bundle2);

    boolean isInitialized();

    void loadAd(C2681a c2681a, Bundle bundle, Bundle bundle2);

    void showVideo();
}
