package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.C4736a;
import com.google.android.gms.ads.internal.ae;
import com.google.android.gms.common.util.C2904o;

@cm
public final class ao {
    /* renamed from: a */
    public static kp m18657a(Context context, C4736a c4736a, it itVar, ahi ahi, qo qoVar, bcy bcy, ap apVar, atc atc) {
        kp atVar;
        dp dpVar = itVar.f15601b;
        kp auVar;
        if (dpVar.f28602g) {
            auVar = new au(context, itVar, bcy, apVar, atc, qoVar);
        } else {
            if (!dpVar.f28614s) {
                if (!(c4736a instanceof ae)) {
                    atVar = (((Boolean) aph.m18688f().m18889a(asp.ah)).booleanValue() && C2904o.g() && !C2904o.i() && qoVar != null && qoVar.mo6135t().m20093d()) ? new at(context, itVar, qoVar, apVar) : new aq(context, itVar, qoVar, apVar);
                }
            }
            if (dpVar.f28614s && (c4736a instanceof ae)) {
                auVar = new aw(context, (ae) c4736a, itVar, ahi, apVar, atc);
            } else {
                atVar = new ar(itVar, apVar);
            }
        }
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(atVar.getClass().getName());
        mt.m19918b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        atVar.mo3819c();
        return atVar;
    }
}
