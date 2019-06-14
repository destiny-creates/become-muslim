package com.google.android.gms.p185e;

import android.annotation.TargetApi;
import android.util.LruCache;
import com.facebook.common.util.ByteConstants;

@TargetApi(12)
/* renamed from: com.google.android.gms.e.bl */
final class bl<K, V> implements fh<K, V> {
    /* renamed from: a */
    private LruCache<K, V> f11637a;

    bl(int i, fk<K, V> fkVar) {
        this.f11637a = new bm(this, ByteConstants.MB, fkVar);
    }

    /* renamed from: a */
    public final void mo2511a(K k, V v) {
        this.f11637a.put(k, v);
    }

    /* renamed from: a */
    public final V mo2510a(K k) {
        return this.f11637a.get(k);
    }
}
