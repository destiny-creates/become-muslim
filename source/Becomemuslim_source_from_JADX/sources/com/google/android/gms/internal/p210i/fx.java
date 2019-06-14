package com.google.android.gms.internal.p210i;

import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.fx */
final class fx<K> implements Entry<K, Object> {
    /* renamed from: a */
    private Entry<K, fv> f16637a;

    private fx(Entry<K, fv> entry) {
        this.f16637a = entry;
    }

    public final K getKey() {
        return this.f16637a.getKey();
    }

    public final Object getValue() {
        if (((fv) this.f16637a.getValue()) == null) {
            return null;
        }
        return fv.m31598a();
    }

    /* renamed from: a */
    public final fv m20578a() {
        return (fv) this.f16637a.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof gt) {
            return ((fv) this.f16637a.getValue()).m20580a((gt) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
