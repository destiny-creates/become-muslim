package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1513p;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.p084a.C1288a;
import java.util.EnumSet;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.adapters.s */
public abstract class C3570s implements AdAdapter, C1513p<Bundle> {
    /* renamed from: a */
    public abstract void mo2860a(Context context, C1288a c1288a, Map<String, Object> map, C1412c c1412c, EnumSet<CacheFlag> enumSet);

    /* renamed from: e */
    public abstract boolean mo2861e();

    public AdPlacementType getPlacementType() {
        return AdPlacementType.INSTREAM;
    }
}
