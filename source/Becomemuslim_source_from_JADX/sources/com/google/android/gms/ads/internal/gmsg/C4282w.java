package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.overlay.C4740d;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.qo;
import java.util.Map;

/* renamed from: com.google.android.gms.ads.internal.gmsg.w */
final class C4282w implements ae<qo> {
    C4282w() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        qo qoVar = (qo) obj;
        C4740d r = qoVar.r();
        if (r != null) {
            r.m16559a();
            return;
        }
        C4740d s = qoVar.s();
        if (s != null) {
            s.m16559a();
        } else {
            jn.e("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
