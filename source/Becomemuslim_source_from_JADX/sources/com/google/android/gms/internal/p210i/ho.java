package com.google.android.gms.internal.p210i;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.ho */
final class ho implements Iterator<Entry<K, V>> {
    /* renamed from: a */
    private int f16673a;
    /* renamed from: b */
    private Iterator<Entry<K, V>> f16674b;
    /* renamed from: c */
    private final /* synthetic */ hm f16675c;

    private ho(hm hmVar) {
        this.f16675c = hmVar;
        this.f16673a = this.f16675c.f16667b.size();
    }

    public final boolean hasNext() {
        return (this.f16673a > 0 && this.f16673a <= this.f16675c.f16667b.size()) || m20756a().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    private final Iterator<Entry<K, V>> m20756a() {
        if (this.f16674b == null) {
            this.f16674b = this.f16675c.f16671f.entrySet().iterator();
        }
        return this.f16674b;
    }

    public final /* synthetic */ Object next() {
        if (m20756a().hasNext()) {
            return (Entry) m20756a().next();
        }
        List b = this.f16675c.f16667b;
        int i = this.f16673a - 1;
        this.f16673a = i;
        return (Entry) b.get(i);
    }
}
