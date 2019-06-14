package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.cz;
import com.google.android.gms.internal.p210i.dd;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.e.dp */
final class dp implements dr {
    /* renamed from: a */
    private final /* synthetic */ Map f11681a;
    /* renamed from: b */
    private final /* synthetic */ Map f11682b;
    /* renamed from: c */
    private final /* synthetic */ Map f11683c;
    /* renamed from: d */
    private final /* synthetic */ Map f11684d;

    dp(dm dmVar, Map map, Map map2, Map map3, Map map4) {
        this.f11681a = map;
        this.f11682b = map2;
        this.f11683c = map3;
        this.f11684d = map4;
    }

    /* renamed from: a */
    public final void mo2548a(dd ddVar, Set<cz> set, Set<cz> set2, da daVar) {
        List list = (List) this.f11681a.get(ddVar);
        this.f11682b.get(ddVar);
        if (list != null) {
            set.addAll(list);
            daVar.mo2529c();
        }
        List list2 = (List) this.f11683c.get(ddVar);
        this.f11684d.get(ddVar);
        if (list2 != null) {
            set2.addAll(list2);
            daVar.mo2530d();
        }
    }
}
