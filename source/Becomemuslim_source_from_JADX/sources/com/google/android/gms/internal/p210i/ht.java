package com.google.android.gms.internal.p210i;

import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.ht */
final class ht implements Comparable<ht>, Entry<K, V> {
    /* renamed from: a */
    private final K f16678a;
    /* renamed from: b */
    private V f16679b;
    /* renamed from: c */
    private final /* synthetic */ hm f16680c;

    ht(hm hmVar, Entry<K, V> entry) {
        this(hmVar, (Comparable) entry.getKey(), entry.getValue());
    }

    ht(hm hmVar, K k, V v) {
        this.f16680c = hmVar;
        this.f16678a = k;
        this.f16679b = v;
    }

    public final V getValue() {
        return this.f16679b;
    }

    public final V setValue(V v) {
        this.f16680c.m20747f();
        V v2 = this.f16679b;
        this.f16679b = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return ht.m20759a(this.f16678a, entry.getKey()) && ht.m20759a(this.f16679b, entry.getValue()) != null;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.f16678a == null ? 0 : this.f16678a.hashCode();
        if (this.f16679b != null) {
            i = this.f16679b.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f16678a);
        String valueOf2 = String.valueOf(this.f16679b);
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length());
        stringBuilder.append(valueOf);
        stringBuilder.append("=");
        stringBuilder.append(valueOf2);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static boolean m20759a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null ? true : null;
        } else {
            return obj.equals(obj2);
        }
    }

    public final /* synthetic */ Object getKey() {
        return this.f16678a;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((ht) obj).getKey());
    }
}
