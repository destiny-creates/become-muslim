package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

final class acd<K> implements Iterator<Entry<K, Object>> {
    /* renamed from: a */
    private Iterator<Entry<K, Object>> f14257a;

    public acd(Iterator<Entry<K, Object>> it) {
        this.f14257a = it;
    }

    public final boolean hasNext() {
        return this.f14257a.hasNext();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.f14257a.next();
        return entry.getValue() instanceof abz ? new acb(entry) : entry;
    }

    public final void remove() {
        this.f14257a.remove();
    }
}
