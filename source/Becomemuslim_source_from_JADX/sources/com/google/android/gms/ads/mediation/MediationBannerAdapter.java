package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.C2631d;

public interface MediationBannerAdapter extends C2683b {
    View getBannerView();

    void requestBannerAd(Context context, C2684c c2684c, Bundle bundle, C2631d c2631d, C2681a c2681a, Bundle bundle2);
}
