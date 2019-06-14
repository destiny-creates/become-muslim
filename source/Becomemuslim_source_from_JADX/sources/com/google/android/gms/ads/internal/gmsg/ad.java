package com.google.android.gms.ads.internal.gmsg;

import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.internal.ads.qo;
import java.util.Map;

final class ad implements ae<qo> {
    ad() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        qo qoVar = (qo) obj;
        if (map.keySet().contains(ViewProps.START)) {
            qoVar.e(true);
        }
        if (map.keySet().contains("stop")) {
            qoVar.e(false);
        }
    }
}
