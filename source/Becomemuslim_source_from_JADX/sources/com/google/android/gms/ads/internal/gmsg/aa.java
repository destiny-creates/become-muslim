package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.qo;
import java.util.Map;

final class aa implements ae<qo> {
    aa() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        qo qoVar = (qo) obj;
        if (((Boolean) aph.f().a(asp.bt)).booleanValue()) {
            qoVar.d(Boolean.parseBoolean((String) map.get("disabled")) ^ 1);
        }
    }
}
