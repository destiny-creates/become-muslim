package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ab;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.cs */
final class cs extends aq {
    /* renamed from: a */
    private static final String f11668a = C4992a.f16273o.toString();
    /* renamed from: b */
    private static final String f11669b = ab.f16338z.toString();
    /* renamed from: c */
    private static final String f11670c = ab.f16337y.toString();

    public cs() {
        super(f11668a, new String[0]);
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return false;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        double doubleValue;
        double doubleValue2;
        ct ctVar = (ct) map.get(f11669b);
        ct ctVar2 = (ct) map.get(f11670c);
        if (!(ctVar == null || ctVar == eu.m8736g() || ctVar2 == null || ctVar2 == eu.m8736g())) {
            et b = eu.m8720b(ctVar);
            map = eu.m8720b(ctVar2);
            if (!(b == eu.m8730e() || map == eu.m8730e())) {
                doubleValue = b.doubleValue();
                doubleValue2 = map.doubleValue();
                if (doubleValue <= doubleValue2) {
                    return eu.m8716a(Long.valueOf(Math.round((Math.random() * (doubleValue2 - doubleValue)) + doubleValue)));
                }
            }
        }
        doubleValue = 0.0d;
        doubleValue2 = 2.147483647E9d;
        return eu.m8716a(Long.valueOf(Math.round((Math.random() * (doubleValue2 - doubleValue)) + doubleValue)));
    }
}
