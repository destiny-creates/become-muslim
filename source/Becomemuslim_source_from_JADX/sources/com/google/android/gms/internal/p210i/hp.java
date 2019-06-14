package com.google.android.gms.internal.p210i;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.hp */
final class hp extends hv {
    /* renamed from: a */
    private final /* synthetic */ hm f24533a;

    private hp(hm hmVar) {
        this.f24533a = hmVar;
        super(hmVar);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new ho(this.f24533a);
    }
}
