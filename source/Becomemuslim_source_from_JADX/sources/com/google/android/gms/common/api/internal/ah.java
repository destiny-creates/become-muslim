package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.C2781a.C4340f;
import java.util.ArrayList;

final class ah extends al {
    /* renamed from: a */
    private final ArrayList<C4340f> f11427a;
    /* renamed from: b */
    private final /* synthetic */ ab f11428b;

    public ah(ab abVar, ArrayList<C4340f> arrayList) {
        this.f11428b = abVar;
        super(abVar);
        this.f11427a = arrayList;
    }

    /* renamed from: a */
    public final void mo2394a() {
        this.f11428b.f11398a.f13166d.f11435c = this.f11428b.m14103i();
        ArrayList arrayList = this.f11427a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((C4340f) obj).m14040a(this.f11428b.f11412o, this.f11428b.f11398a.f13166d.f11435c);
        }
    }
}
