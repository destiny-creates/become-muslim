package com.google.android.gms.ads.internal.gmsg;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.ads.qo;
import java.util.Map;

/* renamed from: com.google.android.gms.ads.internal.gmsg.x */
final class C4283x implements ae<qo> {
    C4283x() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        ((qo) obj).c(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close")));
    }
}
