package com.google.android.p133a;

import android.support.v4.util.C3211a;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: SizeMap */
/* renamed from: com.google.android.a.l */
class C2211l {
    /* renamed from: a */
    private final C3211a<C2186a, SortedSet<C2210k>> f5260a = new C3211a();

    C2211l() {
    }

    /* renamed from: a */
    public boolean m6103a(C2210k c2210k) {
        SortedSet sortedSet;
        for (C2186a c2186a : this.f5260a.keySet()) {
            if (c2186a.m6027a(c2210k)) {
                sortedSet = (SortedSet) this.f5260a.get(c2186a);
                if (sortedSet.contains(c2210k)) {
                    return null;
                }
                sortedSet.add(c2210k);
                return true;
            }
        }
        sortedSet = new TreeSet();
        sortedSet.add(c2210k);
        this.f5260a.put(C2186a.m6022a(c2210k.m6098a(), c2210k.m6100b()), sortedSet);
        return true;
    }

    /* renamed from: a */
    public void m6102a(C2186a c2186a) {
        this.f5260a.remove(c2186a);
    }

    /* renamed from: a */
    Set<C2186a> m6101a() {
        return this.f5260a.keySet();
    }

    /* renamed from: b */
    SortedSet<C2210k> m6104b(C2186a c2186a) {
        return (SortedSet) this.f5260a.get(c2186a);
    }

    /* renamed from: b */
    void m6105b() {
        this.f5260a.clear();
    }

    /* renamed from: c */
    boolean m6106c() {
        return this.f5260a.isEmpty();
    }
}
