package com.google.android.gms.internal.ads;

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

class adt<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    /* renamed from: a */
    private final int f14316a;
    /* renamed from: b */
    private List<aea> f14317b;
    /* renamed from: c */
    private Map<K, V> f14318c;
    /* renamed from: d */
    private boolean f14319d;
    /* renamed from: e */
    private volatile aec f14320e;
    /* renamed from: f */
    private Map<K, V> f14321f;
    /* renamed from: g */
    private volatile adw f14322g;

    private adt(int i) {
        this.f14316a = i;
        this.f14317b = Collections.emptyList();
        this.f14318c = Collections.emptyMap();
        this.f14321f = Collections.emptyMap();
    }

    /* renamed from: a */
    private final int m18150a(K k) {
        int compareTo;
        int size = this.f14317b.size() - 1;
        if (size >= 0) {
            compareTo = k.compareTo((Comparable) ((aea) this.f14317b.get(size)).getKey());
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
            int compareTo2 = k.compareTo((Comparable) ((aea) this.f14317b.get(i)).getKey());
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

    /* renamed from: a */
    static <FieldDescriptorType extends abk<FieldDescriptorType>> adt<FieldDescriptorType, Object> m18151a(int i) {
        return new adu(i);
    }

    /* renamed from: c */
    private final V m18155c(int i) {
        m18158f();
        V value = ((aea) this.f14317b.remove(i)).getValue();
        if (!this.f14318c.isEmpty()) {
            Iterator it = m18159g().entrySet().iterator();
            this.f14317b.add(new aea(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* renamed from: f */
    private final void m18158f() {
        if (this.f14319d) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: g */
    private final SortedMap<K, V> m18159g() {
        m18158f();
        if (this.f14318c.isEmpty() && !(this.f14318c instanceof TreeMap)) {
            this.f14318c = new TreeMap();
            this.f14321f = ((TreeMap) this.f14318c).descendingMap();
        }
        return (SortedMap) this.f14318c;
    }

    /* renamed from: a */
    public final V m18160a(K k, V v) {
        m18158f();
        int a = m18150a((Comparable) k);
        if (a >= 0) {
            return ((aea) this.f14317b.get(a)).setValue(v);
        }
        m18158f();
        if (this.f14317b.isEmpty() && !(this.f14317b instanceof ArrayList)) {
            this.f14317b = new ArrayList(this.f14316a);
        }
        a = -(a + 1);
        if (a >= this.f14316a) {
            return m18159g().put(k, v);
        }
        if (this.f14317b.size() == this.f14316a) {
            aea aea = (aea) this.f14317b.remove(this.f14316a - 1);
            m18159g().put((Comparable) aea.getKey(), aea.getValue());
        }
        this.f14317b.add(a, new aea(this, k, v));
        return null;
    }

    /* renamed from: a */
    public void mo3767a() {
        if (!this.f14319d) {
            this.f14318c = this.f14318c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f14318c);
            this.f14321f = this.f14321f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f14321f);
            this.f14319d = true;
        }
    }

    /* renamed from: b */
    public final Entry<K, V> m18162b(int i) {
        return (Entry) this.f14317b.get(i);
    }

    /* renamed from: b */
    public final boolean m18163b() {
        return this.f14319d;
    }

    /* renamed from: c */
    public final int m18164c() {
        return this.f14317b.size();
    }

    public void clear() {
        m18158f();
        if (!this.f14317b.isEmpty()) {
            this.f14317b.clear();
        }
        if (!this.f14318c.isEmpty()) {
            this.f14318c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (m18150a(comparable) < 0) {
            if (!this.f14318c.containsKey(comparable)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public final Iterable<Entry<K, V>> m18165d() {
        return this.f14318c.isEmpty() ? adx.m18168a() : this.f14318c.entrySet();
    }

    /* renamed from: e */
    final Set<Entry<K, V>> m18166e() {
        if (this.f14322g == null) {
            this.f14322g = new adw();
        }
        return this.f14322g;
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.f14320e == null) {
            this.f14320e = new aec();
        }
        return this.f14320e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof adt)) {
            return super.equals(obj);
        }
        adt adt = (adt) obj;
        int size = size();
        if (size != adt.size()) {
            return false;
        }
        int c = m18164c();
        if (c != adt.m18164c()) {
            return entrySet().equals(adt.entrySet());
        }
        for (int i = 0; i < c; i++) {
            if (!m18162b(i).equals(adt.m18162b(i))) {
                return false;
            }
        }
        return c != size ? this.f14318c.equals(adt.f14318c) : true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = m18150a(comparable);
        return a >= 0 ? ((aea) this.f14317b.get(a)).getValue() : this.f14318c.get(comparable);
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < m18164c(); i2++) {
            i += ((aea) this.f14317b.get(i2)).hashCode();
        }
        return this.f14318c.size() > 0 ? i + this.f14318c.hashCode() : i;
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m18160a((Comparable) obj, obj2);
    }

    public V remove(Object obj) {
        m18158f();
        Comparable comparable = (Comparable) obj;
        int a = m18150a(comparable);
        return a >= 0 ? m18155c(a) : this.f14318c.isEmpty() ? null : this.f14318c.remove(comparable);
    }

    public int size() {
        return this.f14317b.size() + this.f14318c.size();
    }
}
