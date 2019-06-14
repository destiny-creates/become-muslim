package com.google.android.gms.internal.ads;

import java.util.Map.Entry;

final class aea implements Comparable<aea>, Entry<K, V> {
    /* renamed from: a */
    private final K f14328a;
    /* renamed from: b */
    private V f14329b;
    /* renamed from: c */
    private final /* synthetic */ adt f14330c;

    aea(adt adt, K k, V v) {
        this.f14330c = adt;
        this.f14328a = k;
        this.f14329b = v;
    }

    aea(adt adt, Entry<K, V> entry) {
        this(adt, (Comparable) entry.getKey(), entry.getValue());
    }

    /* renamed from: a */
    private static boolean m18170a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((aea) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return m18170a(this.f14328a, entry.getKey()) && m18170a(this.f14329b, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.f14328a;
    }

    public final V getValue() {
        return this.f14329b;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.f14328a == null ? 0 : this.f14328a.hashCode();
        if (this.f14329b != null) {
            i = this.f14329b.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.f14330c.m18158f();
        V v2 = this.f14329b;
        this.f14329b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f14328a);
        String valueOf2 = String.valueOf(this.f14329b);
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length());
        stringBuilder.append(valueOf);
        stringBuilder.append("=");
        stringBuilder.append(valueOf2);
        return stringBuilder.toString();
    }
}
