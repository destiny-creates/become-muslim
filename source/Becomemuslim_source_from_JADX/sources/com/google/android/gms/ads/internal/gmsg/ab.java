package com.google.android.gms.ads.internal.gmsg;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.internal.ads.qo;
import java.util.Map;

final class ab implements ae<qo> {
    ab() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        qo qoVar = (qo) obj;
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("pause".equals(str)) {
            qoVar.m_();
            return;
        }
        if ("resume".equals(str)) {
            qoVar.n_();
        }
    }
}
