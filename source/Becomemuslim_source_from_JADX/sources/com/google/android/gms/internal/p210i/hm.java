package com.google.android.gms.internal.p210i;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.internal.i.hm */
class hm<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    /* renamed from: a */
    private final int f16666a;
    /* renamed from: b */
    private List<ht> f16667b;
    /* renamed from: c */
    private Map<K, V> f16668c;
    /* renamed from: d */
    private boolean f16669d;
    /* renamed from: e */
    private volatile hv f16670e;
    /* renamed from: f */
    private Map<K, V> f16671f;
    /* renamed from: g */
    private volatile hp f16672g;

    /* renamed from: a */
    static <FieldDescriptorType extends fc<FieldDescriptorType>> hm<FieldDescriptorType, Object> m20740a(int i) {
        return new hn(i);
    }

    private hm(int i) {
        this.f16666a = i;
        this.f16667b = Collections.emptyList();
        this.f16668c = Collections.emptyMap();
        this.f16671f = Collections.emptyMap();
    }

    /* renamed from: a */
    public void mo4581a() {
        if (!this.f16669d) {
            Map emptyMap;
            if (this.f16668c.isEmpty()) {
                emptyMap = Collections.emptyMap();
            } else {
                emptyMap = Collections.unmodifiableMap(this.f16668c);
            }
            this.f16668c = emptyMap;
            if (this.f16671f.isEmpty()) {
                emptyMap = Collections.emptyMap();
            } else {
                emptyMap = Collections.unmodifiableMap(this.f16671f);
            }
            this.f16671f = emptyMap;
            this.f16669d = true;
        }
    }

    /* renamed from: b */
    public final boolean m20752b() {
        return this.f16669d;
    }

    /* renamed from: c */
    public final int m20753c() {
        return this.f16667b.size();
    }

    /* renamed from: b */
    public final Entry<K, V> m20751b(int i) {
        return (Entry) this.f16667b.get(i);
    }

    /* renamed from: d */
    public final Iterable<Entry<K, V>> m20754d() {
        if (this.f16668c.isEmpty()) {
            return hq.m20757a();
        }
        return this.f16668c.entrySet();
    }

    public int size() {
        return this.f16667b.size() + this.f16668c.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (m20739a(comparable) < 0) {
            if (this.f16668c.containsKey(comparable) == null) {
                return null;
            }
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = m20739a(comparable);
        if (a >= 0) {
            return ((ht) this.f16667b.get(a)).getValue();
        }
        return this.f16668c.get(comparable);
    }

    /* renamed from: a */
    public final V m20749a(K k, V v) {
        m20747f();
        int a = m20739a((Comparable) k);
        if (a >= 0) {
            return ((ht) this.f16667b.get(a)).setValue(v);
        }
        m20747f();
        if (this.f16667b.isEmpty() && !(this.f16667b instanceof ArrayList)) {
            this.f16667b = new ArrayList(this.f16666a);
        }
        a = -(a + 1);
        if (a >= this.f16666a) {
            return m20748g().put(k, v);
        }
        if (this.f16667b.size() == this.f16666a) {
            ht htVar = (ht) this.f16667b.remove(this.f16666a - 1);
            m20748g().put((Comparable) htVar.getKey(), htVar.getValue());
        }
        this.f16667b.add(a, new ht(this, k, v));
        return null;
    }

    public void clear() {
        m20747f();
        if (!this.f16667b.isEmpty()) {
            this.f16667b.clear();
        }
        if (!this.f16668c.isEmpty()) {
            this.f16668c.clear();
        }
    }

    public V remove(Object obj) {
        m20747f();
        Comparable comparable = (Comparable) obj;
        int a = m20739a(comparable);
        if (a >= 0) {
            return m20744c(a);
        }
        if (this.f16668c.isEmpty()) {
            return null;
        }
        return this.f16668c.remove(comparable);
    }

    /* renamed from: c */
    private final V m20744c(int i) {
        m20747f();
        i = ((ht) this.f16667b.remove(i)).getValue();
        if (!this.f16668c.isEmpty()) {
            Iterator it = m20748g().entrySet().iterator();
            this.f16667b.add(new ht(this, (Entry) it.next()));
            it.remove();
        }
        return i;
    }

    /* renamed from: a */
    private final int m20739a(K k) {
        int compareTo;
        int size = this.f16667b.size() - 1;
        if (size >= 0) {
            compareTo = k.compareTo((Comparable) ((ht) this.f16667b.get(size)).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        compareTo = 0;
        while (compareTo <= size) {
            int i = (compareTo + size) / 2;
            int compareTo2 = k.compareTo((Comparable) ((ht) this.f16667b.get(i)).getKey());
            if (compareTo2 < 0) {
                size = i - 1;
            } else if (compareTo2 <= 0) {
                return i;
            } else {
                compareTo = i + 1;
            }
        }
        return -(compareTo + 1);
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.f16670e == null) {
            this.f16670e = new hv();
        }
        return this.f16670e;
    }

    /* renamed from: e */
    final Set<Entry<K, V>> m20755e() {
        if (this.f16672g == null) {
            this.f16672g = new hp();
        }
        return this.f16672g;
    }

    /* renamed from: f */
    private final void m20747f() {
        if (this.f16669d) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: g */
    private final SortedMap<K, V> m20748g() {
        m20747f();
        if (this.f16668c.isEmpty() && !(this.f16668c instanceof TreeMap)) {
            this.f16668c = new TreeMap();
            this.f16671f = ((TreeMap) this.f16668c).descendingMap();
        }
        return (SortedMap) this.f16668c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hm)) {
            return super.equals(obj);
        }
        hm hmVar = (hm) obj;
        int size = size();
        if (size != hmVar.size()) {
            return false;
        }
        int c = m20753c();
        if (c != hmVar.m20753c()) {
            return entrySet().equals(hmVar.entrySet());
        }
        for (int i = 0; i < c; i++) {
            if (!m20751b(i).equals(hmVar.m20751b(i))) {
                return false;
            }
        }
        if (c != size) {
            return this.f16668c.equals(hmVar.f16668c);
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < m20753c(); i2++) {
            i += ((ht) this.f16667b.get(i2)).hashCode();
        }
        return this.f16668c.size() > 0 ? i + this.f16668c.hashCode() : i;
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m20749a((Comparable) obj, obj2);
    }
}
