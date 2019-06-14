package com.google.android.gms.internal.ads;

import java.util.Map.Entry;

final class acb<K> implements Entry<K, Object> {
    /* renamed from: a */
    private Entry<K, abz> f14256a;

    private acb(Entry<K, abz> entry) {
        this.f14256a = entry;
    }

    /* renamed from: a */
    public final abz m17958a() {
        return (abz) this.f14256a.getValue();
    }

    public final K getKey() {
        return this.f14256a.getKey();
    }

    public final Object getValue() {
        return ((abz) this.f14256a.getValue()) == null ? null : abz.m29732a();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof acx) {
            return ((abz) this.f14256a.getValue()).m17960a((acx) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
