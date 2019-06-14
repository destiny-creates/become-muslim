package com.google.android.gms.internal.ads;

import com.google.ads.C2172a.C2170a;
import com.google.ads.C2172a.C2171b;
import com.google.ads.mediation.C2174a;
import java.util.Date;
import java.util.HashSet;

@cm
public final class beg {
    /* renamed from: a */
    public static int m19346a(C2170a c2170a) {
        switch (beh.f15236a[c2170a.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public static C2174a m19347a(aoq aoq, boolean z) {
        C2171b c2171b;
        HashSet hashSet = aoq.f28265e != null ? new HashSet(aoq.f28265e) : null;
        Date date = new Date(aoq.f28262b);
        switch (aoq.f28264d) {
            case 1:
                c2171b = C2171b.MALE;
                break;
            case 2:
                c2171b = C2171b.FEMALE;
                break;
            default:
                c2171b = C2171b.UNKNOWN;
                break;
        }
        return new C2174a(date, c2171b, hashSet, z, aoq.f28271k);
    }
}
