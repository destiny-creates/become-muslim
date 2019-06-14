package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.C2898i;

final class db implements dd {
    /* renamed from: a */
    private final /* synthetic */ Context f24061a;

    db(Context context) {
        this.f24061a = context;
    }

    /* renamed from: a */
    public final boolean mo4234a(mv mvVar) {
        aph.m18683a();
        boolean c = mi.m19880c(this.f24061a);
        Object obj = (((Boolean) aph.m18688f().m18889a(asp.dd)).booleanValue() && mvVar.f28712d) ? 1 : null;
        if (da.m19377b(this.f24061a, mvVar.f28712d) && c && obj == null) {
            if (C2898i.c(this.f24061a)) {
                if (!((Boolean) aph.m18688f().m18889a(asp.f14917H)).booleanValue()) {
                }
            }
            return false;
        }
        return true;
    }
}
