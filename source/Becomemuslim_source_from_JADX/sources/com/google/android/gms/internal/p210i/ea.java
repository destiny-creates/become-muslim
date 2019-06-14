package com.google.android.gms.internal.p210i;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.i.ea */
final class ea implements Comparator<dy> {
    ea() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        dy dyVar = (dy) obj;
        dy dyVar2 = (dy) obj2;
        ef efVar = (ef) dyVar.iterator();
        ef efVar2 = (ef) dyVar2.iterator();
        while (efVar.hasNext() && efVar2.hasNext()) {
            int compare = Integer.compare(dy.m20454b(efVar.mo6158a()), dy.m20454b(efVar2.mo6158a()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(dyVar.mo6160a(), dyVar2.mo6160a());
    }
}
