package com.google.android.gms.internal.p210i;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.hu */
final class hu implements Iterator<Entry<K, V>> {
    /* renamed from: a */
    private int f16681a;
    /* renamed from: b */
    private boolean f16682b;
    /* renamed from: c */
    private Iterator<Entry<K, V>> f16683c;
    /* renamed from: d */
    private final /* synthetic */ hm f16684d;

    private hu(hm hmVar) {
        this.f16684d = hmVar;
        this.f16681a = -1;
    }

    public final boolean hasNext() {
        if (this.f16681a + 1 >= this.f16684d.f16667b.size()) {
            if (this.f16684d.f16668c.isEmpty() || !m20760a().hasNext()) {
                return false;
            }
        }
        return true;
    }

    public final void remove() {
        if (this.f16682b) {
            this.f16682b = false;
            this.f16684d.m20747f();
            if (this.f16681a < this.f16684d.f16667b.size()) {
                hm hmVar = this.f16684d;
                int i = this.f16681a;
                this.f16681a = i - 1;
                hmVar.m20744c(i);
                return;
            }
            m20760a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    /* renamed from: a */
    private final Iterator<Entry<K, V>> m20760a() {
        if (this.f16683c == null) {
            this.f16683c = this.f16684d.f16668c.entrySet().iterator();
        }
        return this.f16683c;
    }

    public final /* synthetic */ Object next() {
        this.f16682b = true;
        int i = this.f16681a + 1;
        this.f16681a = i;
        if (i < this.f16684d.f16667b.size()) {
            return (Entry) this.f16684d.f16667b.get(this.f16681a);
        }
        return (Entry) m20760a().next();
    }
}
