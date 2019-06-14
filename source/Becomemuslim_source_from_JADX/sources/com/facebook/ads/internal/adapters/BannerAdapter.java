package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.C1486e;
import java.util.Map;

public abstract class BannerAdapter implements AdAdapter {
    public final AdPlacementType getPlacementType() {
        return AdPlacementType.BANNER;
    }

    public abstract void loadBannerAd(Context context, C1412c c1412c, C1486e c1486e, BannerAdapterListener bannerAdapterListener, Map<String, Object> map);
}
