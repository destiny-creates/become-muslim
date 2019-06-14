package com.google.android.gms.internal.p210i;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.hv */
class hv extends AbstractSet<Entry<K, V>> {
    /* renamed from: a */
    private final /* synthetic */ hm f16685a;

    private hv(hm hmVar) {
        this.f16685a = hmVar;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new hu(this.f16685a);
    }

    public int size() {
        return this.f16685a.size();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.f16685a.get(entry.getKey());
        obj = entry.getValue();
        if (obj2 != obj) {
            if (obj2 == null || obj2.equals(obj) == null) {
                return null;
            }
        }
        return true;
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return null;
        }
        this.f16685a.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.f16685a.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return null;
        }
        this.f16685a.m20749a((Comparable) entry.getKey(), entry.getValue());
        return true;
    }
}
