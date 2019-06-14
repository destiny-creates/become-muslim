package com.google.android.gms.ads.internal.gmsg;

import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.internal.ads.qo;
import java.util.Map;

final class ac implements ae<qo> {
    ac() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        qo qoVar = (qo) obj;
        if (map.keySet().contains(ViewProps.START)) {
            qoVar.v().h();
        } else if (map.keySet().contains("stop")) {
            qoVar.v().i();
        } else {
            if (map.keySet().contains("cancel")) {
                qoVar.v().j();
            }
        }
    }
}
