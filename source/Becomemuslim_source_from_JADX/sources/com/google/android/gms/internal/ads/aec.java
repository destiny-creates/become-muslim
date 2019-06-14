package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class aec extends AbstractSet<Entry<K, V>> {
    /* renamed from: a */
    private final /* synthetic */ adt f14335a;

    private aec(adt adt) {
        this.f14335a = adt;
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f14335a.m18160a((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.f14335a.clear();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.f14335a.get(entry.getKey());
        obj = entry.getValue();
        if (obj2 != obj) {
            if (obj2 == null || !obj2.equals(obj)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new aeb(this.f14335a, null);
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f14335a.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.f14335a.size();
    }
}
