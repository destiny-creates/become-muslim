package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class acr<K, V> extends LinkedHashMap<K, V> {
    /* renamed from: b */
    private static final acr f14268b;
    /* renamed from: a */
    private boolean f14269a = true;

    static {
        acr acr = new acr();
        f14268b = acr;
        acr.f14269a = false;
    }

    private acr() {
    }

    private acr(Map<K, V> map) {
        super(map);
    }

    /* renamed from: a */
    private static int m17974a(Object obj) {
        if (obj instanceof byte[]) {
            return abs.m17939c((byte[]) obj);
        }
        if (!(obj instanceof abt)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public static <K, V> acr<K, V> m17975a() {
        return f14268b;
    }

    /* renamed from: e */
    private final void m17976e() {
        if (!this.f14269a) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: a */
    public final void m17977a(acr<K, V> acr) {
        m17976e();
        if (!acr.isEmpty()) {
            putAll(acr);
        }
    }

    /* renamed from: b */
    public final acr<K, V> m17978b() {
        return isEmpty() ? new acr() : new acr(this);
    }

    /* renamed from: c */
    public final void m17979c() {
        this.f14269a = false;
    }

    public final void clear() {
        m17976e();
        super.clear();
    }

    /* renamed from: d */
    public final boolean m17980d() {
        return this.f14269a;
    }

    public final Set<Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            obj = (Map) obj;
            if (this != obj) {
                if (size() == obj.size()) {
                    for (Entry entry : entrySet()) {
                        if (obj.containsKey(entry.getKey())) {
                            boolean equals;
                            Object value = entry.getValue();
                            Object obj2 = obj.get(entry.getKey());
                            if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                                equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                                continue;
                            } else {
                                equals = value.equals(obj2);
                                continue;
                            }
                            if (!equals) {
                            }
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                }
            }
            obj = 1;
            return obj != null;
        }
    }

    public final int hashCode() {
        int i = 0;
        for (Entry entry : entrySet()) {
            i += m17974a(entry.getValue()) ^ m17974a(entry.getKey());
        }
        return i;
    }

    public final V put(K k, V v) {
        m17976e();
        abs.m17933a((Object) k);
        abs.m17933a((Object) v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        m17976e();
        for (Object next : map.keySet()) {
            abs.m17933a(next);
            abs.m17933a(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        m17976e();
        return super.remove(obj);
    }
}
