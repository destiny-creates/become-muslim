package com.google.android.gms.p185e;

import android.util.LruCache;

/* renamed from: com.google.android.gms.e.bm */
final class bm extends LruCache<K, V> {
    /* renamed from: a */
    private final /* synthetic */ fk f7479a;

    bm(bl blVar, int i, fk fkVar) {
        this.f7479a = fkVar;
        super(i);
    }

    protected final int sizeOf(K k, V v) {
        return this.f7479a.mo2547a(k, v);
    }
}
