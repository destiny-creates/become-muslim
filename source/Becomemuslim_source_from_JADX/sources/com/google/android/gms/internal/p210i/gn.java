package com.google.android.gms.internal.p210i;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.i.gn */
public final class gn<K, V> extends LinkedHashMap<K, V> {
    /* renamed from: b */
    private static final gn f16651b;
    /* renamed from: a */
    private boolean f16652a = true;

    private gn() {
    }

    private gn(Map<K, V> map) {
        super(map);
    }

    /* renamed from: a */
    public static <K, V> gn<K, V> m20595a() {
        return f16651b;
    }

    /* renamed from: a */
    public final void m20597a(gn<K, V> gnVar) {
        m20596e();
        if (!gnVar.isEmpty()) {
            putAll(gnVar);
        }
    }

    public final Set<Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        m20596e();
        super.clear();
    }

    public final V put(K k, V v) {
        m20596e();
        fm.m20556a((Object) k);
        fm.m20556a((Object) v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        m20596e();
        for (Object next : map.keySet()) {
            fm.m20556a(next);
            fm.m20556a(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        m20596e();
        return super.remove(obj);
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
            obj = true;
            return obj != null;
        }
    }

    /* renamed from: a */
    private static int m20594a(Object obj) {
        if (obj instanceof byte[]) {
            return fm.m20562c((byte[]) obj);
        }
        if (!(obj instanceof fn)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = 0;
        for (Entry entry : entrySet()) {
            i += gn.m20594a(entry.getValue()) ^ gn.m20594a(entry.getKey());
        }
        return i;
    }

    /* renamed from: b */
    public final gn<K, V> m20598b() {
        return isEmpty() ? new gn() : new gn(this);
    }

    /* renamed from: c */
    public final void m20599c() {
        this.f16652a = false;
    }

    /* renamed from: d */
    public final boolean m20600d() {
        return this.f16652a;
    }

    /* renamed from: e */
    private final void m20596e() {
        if (!this.f16652a) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        gn gnVar = new gn();
        f16651b = gnVar;
        gnVar.f16652a = false;
    }
}
