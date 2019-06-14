package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.internal.C2850d.C2846c;
import com.google.android.gms.common.internal.C2861n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class ae extends al {
    /* renamed from: a */
    final /* synthetic */ ab f11422a;
    /* renamed from: b */
    private final Map<C4340f, ad> f11423b;

    public ae(ab abVar, Map<C4340f, ad> map) {
        this.f11422a = abVar;
        super(abVar);
        this.f11423b = map;
    }

    /* renamed from: a */
    public final void mo2394a() {
        C2861n c2861n = new C2861n(this.f11422a.f11401d);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (C4340f c4340f : this.f11423b.keySet()) {
            if (!c4340f.m14049k() || ((ad) this.f11423b.get(c4340f)).f11421c) {
                arrayList2.add(c4340f);
            } else {
                arrayList.add(c4340f);
            }
        }
        int i = -1;
        int i2 = 0;
        if (!arrayList.isEmpty()) {
            ArrayList arrayList3 = (ArrayList) arrayList;
            int size = arrayList3.size();
            while (i2 < size) {
                Object obj = arrayList3.get(i2);
                i2++;
                i = c2861n.m8362a(this.f11422a.f11400c, (C4340f) obj);
                if (i != 0) {
                    break;
                }
            }
        }
        ArrayList arrayList4 = (ArrayList) arrayList2;
        int size2 = arrayList4.size();
        while (i2 < size2) {
            obj = arrayList4.get(i2);
            i2++;
            i = c2861n.m8362a(this.f11422a.f11400c, (C4340f) obj);
            if (i == 0) {
                break;
            }
        }
        if (i != 0) {
            this.f11422a.f11398a.m16716a(new af(this, this.f11422a, new C4775b(i, null)));
            return;
        }
        if (this.f11422a.f11410m) {
            this.f11422a.f11408k.mo3454A();
        }
        for (C4340f c4340f2 : this.f11423b.keySet()) {
            C2846c c2846c = (C2846c) this.f11423b.get(c4340f2);
            if (!c4340f2.m14049k() || c2861n.m8362a(this.f11422a.f11400c, c4340f2) == 0) {
                c4340f2.m14038a(c2846c);
            } else {
                this.f11422a.f11398a.m16716a(new ag(this, this.f11422a, c2846c));
            }
        }
    }
}
