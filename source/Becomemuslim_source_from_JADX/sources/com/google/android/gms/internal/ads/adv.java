package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class adv implements Iterator<Entry<K, V>> {
    /* renamed from: a */
    private int f14323a;
    /* renamed from: b */
    private Iterator<Entry<K, V>> f14324b;
    /* renamed from: c */
    private final /* synthetic */ adt f14325c;

    private adv(adt adt) {
        this.f14325c = adt;
        this.f14323a = this.f14325c.f14317b.size();
    }

    /* renamed from: a */
    private final Iterator<Entry<K, V>> m18167a() {
        if (this.f14324b == null) {
            this.f14324b = this.f14325c.f14321f.entrySet().iterator();
        }
        return this.f14324b;
    }

    public final boolean hasNext() {
        return (this.f14323a > 0 && this.f14323a <= this.f14325c.f14317b.size()) || m18167a().hasNext();
    }

    public final /* synthetic */ Object next() {
        Object next;
        if (m18167a().hasNext()) {
            next = m18167a().next();
        } else {
            List b = this.f14325c.f14317b;
            int i = this.f14323a - 1;
            this.f14323a = i;
            next = b.get(i);
        }
        return (Entry) next;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
