package com.google.android.gms.internal.p210i;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.fy */
final class fy<K> implements Iterator<Entry<K, Object>> {
    /* renamed from: a */
    private Iterator<Entry<K, Object>> f16638a;

    public fy(Iterator<Entry<K, Object>> it) {
        this.f16638a = it;
    }

    public final boolean hasNext() {
        return this.f16638a.hasNext();
    }

    public final void remove() {
        this.f16638a.remove();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.f16638a.next();
        return entry.getValue() instanceof fv ? new fx(entry) : entry;
    }
}
