package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Map;

public abstract class ab implements AdAdapter {
    /* renamed from: a */
    RewardData f9484a;
    /* renamed from: b */
    int f9485b;

    /* renamed from: a */
    public abstract int mo2866a();

    /* renamed from: a */
    public void m11512a(int i) {
        this.f9485b = i;
    }

    /* renamed from: a */
    public abstract void mo2867a(Context context, ac acVar, Map<String, Object> map, boolean z);

    /* renamed from: a */
    public void m11514a(RewardData rewardData) {
        this.f9484a = rewardData;
    }

    /* renamed from: b */
    public abstract boolean mo2868b();

    public AdPlacementType getPlacementType() {
        return AdPlacementType.REWARDED_VIDEO;
    }
}
