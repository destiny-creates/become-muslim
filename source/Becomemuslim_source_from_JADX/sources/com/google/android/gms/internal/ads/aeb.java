package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

final class aeb implements Iterator<Entry<K, V>> {
    /* renamed from: a */
    private int f14331a;
    /* renamed from: b */
    private boolean f14332b;
    /* renamed from: c */
    private Iterator<Entry<K, V>> f14333c;
    /* renamed from: d */
    private final /* synthetic */ adt f14334d;

    private aeb(adt adt) {
        this.f14334d = adt;
        this.f14331a = -1;
    }

    /* renamed from: a */
    private final Iterator<Entry<K, V>> m18171a() {
        if (this.f14333c == null) {
            this.f14333c = this.f14334d.f14318c.entrySet().iterator();
        }
        return this.f14333c;
    }

    public final boolean hasNext() {
        if (this.f14331a + 1 >= this.f14334d.f14317b.size()) {
            if (this.f14334d.f14318c.isEmpty() || !m18171a().hasNext()) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object next() {
        this.f14332b = true;
        int i = this.f14331a + 1;
        this.f14331a = i;
        return (Entry) (i < this.f14334d.f14317b.size() ? this.f14334d.f14317b.get(this.f14331a) : m18171a().next());
    }

    public final void remove() {
        if (this.f14332b) {
            this.f14332b = false;
            this.f14334d.m18158f();
            if (this.f14331a < this.f14334d.f14317b.size()) {
                adt adt = this.f14334d;
                int i = this.f14331a;
                this.f14331a = i - 1;
                adt.m18155c(i);
                return;
            }
            m18171a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
