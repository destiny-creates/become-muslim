package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.EnumSet;
import java.util.Map;

public abstract class InterstitialAdapter implements AdAdapter {
    public final AdPlacementType getPlacementType() {
        return AdPlacementType.INTERSTITIAL;
    }

    public abstract void loadInterstitialAd(Context context, InterstitialAdapterListener interstitialAdapterListener, Map<String, Object> map, C1412c c1412c, EnumSet<CacheFlag> enumSet);

    public abstract boolean show();
}
