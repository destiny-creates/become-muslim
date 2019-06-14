package com.google.p127a.p129b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: LinkedTreeMap */
/* renamed from: com.google.a.b.g */
public final class C2141g<K, V> extends AbstractMap<K, V> implements Serializable {
    /* renamed from: f */
    static final /* synthetic */ boolean f5119f = (C2141g.class.desiredAssertionStatus() ^ 1);
    /* renamed from: g */
    private static final Comparator<Comparable> f5120g = new C21361();
    /* renamed from: a */
    Comparator<? super K> f5121a;
    /* renamed from: b */
    C2140d<K, V> f5122b;
    /* renamed from: c */
    int f5123c;
    /* renamed from: d */
    int f5124d;
    /* renamed from: e */
    final C2140d<K, V> f5125e;
    /* renamed from: h */
    private C2137a f5126h;
    /* renamed from: i */
    private C2138b f5127i;

    /* compiled from: LinkedTreeMap */
    /* renamed from: com.google.a.b.g$1 */
    static class C21361 implements Comparator<Comparable> {
        C21361() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5863a((Comparable) obj, (Comparable) obj2);
        }

        /* renamed from: a */
        public int m5863a(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap */
    /* renamed from: com.google.a.b.g$a */
    class C2137a extends AbstractSet<Entry<K, V>> {
        /* renamed from: a */
        final /* synthetic */ C2141g f5105a;

        /* compiled from: LinkedTreeMap */
        /* renamed from: com.google.a.b.g$a$1 */
        class C40351 extends C2139c<Entry<K, V>> {
            /* renamed from: a */
            final /* synthetic */ C2137a f10103a;

            C40351(C2137a c2137a) {
                this.f10103a = c2137a;
                super();
            }

            public /* synthetic */ Object next() {
                return m12437a();
            }

            /* renamed from: a */
            public Entry<K, V> m12437a() {
                return m5864b();
            }
        }

        C2137a(C2141g c2141g) {
            this.f5105a = c2141g;
        }

        public int size() {
            return this.f5105a.f5123c;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C40351(this);
        }

        public boolean contains(Object obj) {
            return (!(obj instanceof Entry) || this.f5105a.m5874a((Entry) obj) == null) ? null : true;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            C2140d a = this.f5105a.m5874a((Entry) obj);
            if (a == null) {
                return false;
            }
            this.f5105a.m5875a(a, true);
            return true;
        }

        public void clear() {
            this.f5105a.clear();
        }
    }

    /* compiled from: LinkedTreeMap */
    /* renamed from: com.google.a.b.g$b */
    final class C2138b extends AbstractSet<K> {
        /* renamed from: a */
        final /* synthetic */ C2141g f5106a;

        /* compiled from: LinkedTreeMap */
        /* renamed from: com.google.a.b.g$b$1 */
        class C40361 extends C2139c<K> {
            /* renamed from: a */
            final /* synthetic */ C2138b f10104a;

            C40361(C2138b c2138b) {
                this.f10104a = c2138b;
                super();
            }

            public K next() {
                return m5864b().f5116f;
            }
        }

        C2138b(C2141g c2141g) {
            this.f5106a = c2141g;
        }

        public int size() {
            return this.f5106a.f5123c;
        }

        public Iterator<K> iterator() {
            return new C40361(this);
        }

        public boolean contains(Object obj) {
            return this.f5106a.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return this.f5106a.m5876b(obj) != null ? true : null;
        }

        public void clear() {
            this.f5106a.clear();
        }
    }

    /* compiled from: LinkedTreeMap */
    /* renamed from: com.google.a.b.g$c */
    private abstract class C2139c<T> implements Iterator<T> {
        /* renamed from: b */
        C2140d<K, V> f5107b;
        /* renamed from: c */
        C2140d<K, V> f5108c;
        /* renamed from: d */
        int f5109d;
        /* renamed from: e */
        final /* synthetic */ C2141g f5110e;

        private C2139c(C2141g c2141g) {
            this.f5110e = c2141g;
            this.f5107b = this.f5110e.f5125e.f5114d;
            this.f5108c = null;
            this.f5109d = this.f5110e.f5124d;
        }

        public final boolean hasNext() {
            return this.f5107b != this.f5110e.f5125e;
        }

        /* renamed from: b */
        final C2140d<K, V> m5864b() {
            C2140d<K, V> c2140d = this.f5107b;
            if (c2140d == this.f5110e.f5125e) {
                throw new NoSuchElementException();
            } else if (this.f5110e.f5124d == this.f5109d) {
                this.f5107b = c2140d.f5114d;
                this.f5108c = c2140d;
                return c2140d;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() {
            if (this.f5108c != null) {
                this.f5110e.m5875a(this.f5108c, true);
                this.f5108c = null;
                this.f5109d = this.f5110e.f5124d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: LinkedTreeMap */
    /* renamed from: com.google.a.b.g$d */
    static final class C2140d<K, V> implements Entry<K, V> {
        /* renamed from: a */
        C2140d<K, V> f5111a;
        /* renamed from: b */
        C2140d<K, V> f5112b;
        /* renamed from: c */
        C2140d<K, V> f5113c;
        /* renamed from: d */
        C2140d<K, V> f5114d;
        /* renamed from: e */
        C2140d<K, V> f5115e;
        /* renamed from: f */
        final K f5116f;
        /* renamed from: g */
        V f5117g;
        /* renamed from: h */
        int f5118h;

        C2140d() {
            this.f5116f = null;
            this.f5115e = this;
            this.f5114d = this;
        }

        C2140d(C2140d<K, V> c2140d, K k, C2140d<K, V> c2140d2, C2140d<K, V> c2140d3) {
            this.f5111a = c2140d;
            this.f5116f = k;
            this.f5118h = 1;
            this.f5114d = c2140d2;
            this.f5115e = c2140d3;
            c2140d3.f5114d = this;
            c2140d2.f5115e = this;
        }

        public K getKey() {
            return this.f5116f;
        }

        public V getValue() {
            return this.f5117g;
        }

        public V setValue(V v) {
            V v2 = this.f5117g;
            this.f5117g = v;
            return v2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
            r3 = this;
            r0 = r4 instanceof java.util.Map.Entry;
            r1 = 0;
            if (r0 == 0) goto L_0x0037;
        L_0x0005:
            r4 = (java.util.Map.Entry) r4;
            r0 = r3.f5116f;
            if (r0 != 0) goto L_0x0012;
        L_0x000b:
            r0 = r4.getKey();
            if (r0 != 0) goto L_0x0036;
        L_0x0011:
            goto L_0x001e;
        L_0x0012:
            r0 = r3.f5116f;
            r2 = r4.getKey();
            r0 = r0.equals(r2);
            if (r0 == 0) goto L_0x0036;
        L_0x001e:
            r0 = r3.f5117g;
            if (r0 != 0) goto L_0x0029;
        L_0x0022:
            r4 = r4.getValue();
            if (r4 != 0) goto L_0x0036;
        L_0x0028:
            goto L_0x0035;
        L_0x0029:
            r0 = r3.f5117g;
            r4 = r4.getValue();
            r4 = r0.equals(r4);
            if (r4 == 0) goto L_0x0036;
        L_0x0035:
            r1 = 1;
        L_0x0036:
            return r1;
        L_0x0037:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.g.d.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.f5116f == null ? 0 : this.f5116f.hashCode();
            if (this.f5117g != null) {
                i = this.f5117g.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f5116f);
            stringBuilder.append("=");
            stringBuilder.append(this.f5117g);
            return stringBuilder.toString();
        }

        /* renamed from: a */
        public C2140d<K, V> m5865a() {
            C2140d<K, V> c2140d = this;
            for (C2140d<K, V> c2140d2 = this.f5112b; c2140d2 != null; c2140d2 = c2140d2.f5112b) {
                c2140d = c2140d2;
            }
            return c2140d;
        }

        /* renamed from: b */
        public C2140d<K, V> m5866b() {
            C2140d<K, V> c2140d = this;
            for (C2140d<K, V> c2140d2 = this.f5113c; c2140d2 != null; c2140d2 = c2140d2.f5113c) {
                c2140d = c2140d2;
            }
            return c2140d;
        }
    }

    public C2141g() {
        this(f5120g);
    }

    public C2141g(Comparator<? super K> comparator) {
        this.f5123c = 0;
        this.f5124d = 0;
        this.f5125e = new C2140d();
        if (comparator == null) {
            comparator = f5120g;
        }
        this.f5121a = comparator;
    }

    public int size() {
        return this.f5123c;
    }

    public V get(Object obj) {
        obj = m5872a(obj);
        return obj != null ? obj.f5117g : null;
    }

    public boolean containsKey(Object obj) {
        return m5872a(obj) != null ? true : null;
    }

    public V put(K k, V v) {
        if (k != null) {
            k = m5873a((Object) k, true);
            V v2 = k.f5117g;
            k.f5117g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public void clear() {
        this.f5122b = null;
        this.f5123c = 0;
        this.f5124d++;
        C2140d c2140d = this.f5125e;
        c2140d.f5115e = c2140d;
        c2140d.f5114d = c2140d;
    }

    public V remove(Object obj) {
        obj = m5876b(obj);
        return obj != null ? obj.f5117g : null;
    }

    /* renamed from: a */
    C2140d<K, V> m5873a(K k, boolean z) {
        int compareTo;
        Comparator comparator = this.f5121a;
        C2140d c2140d = this.f5122b;
        if (c2140d != null) {
            Comparable comparable = comparator == f5120g ? (Comparable) k : null;
            while (true) {
                compareTo = comparable != null ? comparable.compareTo(c2140d.f5116f) : comparator.compare(k, c2140d.f5116f);
                if (compareTo == 0) {
                    return c2140d;
                }
                C2140d c2140d2;
                if (compareTo < 0) {
                    c2140d2 = c2140d.f5112b;
                } else {
                    c2140d2 = c2140d.f5113c;
                }
                if (c2140d2 == null) {
                    break;
                }
                c2140d = c2140d2;
            }
        } else {
            compareTo = 0;
        }
        if (!z) {
            return null;
        }
        C2140d<K, V> c2140d3;
        z = this.f5125e;
        if (c2140d == null) {
            if (comparator == f5120g) {
                if (!(k instanceof Comparable)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(k.getClass().getName());
                    stringBuilder.append(" is not Comparable");
                    throw new ClassCastException(stringBuilder.toString());
                }
            }
            c2140d3 = new C2140d(c2140d, k, z, z.f5115e);
            this.f5122b = c2140d3;
        } else {
            c2140d3 = new C2140d(c2140d, k, z, z.f5115e);
            if (compareTo < 0) {
                c2140d.f5112b = c2140d3;
            } else {
                c2140d.f5113c = c2140d3;
            }
            m5871b(c2140d, true);
        }
        this.f5123c += 1;
        this.f5124d += 1;
        return c2140d3;
    }

    /* renamed from: a */
    com.google.p127a.p129b.C2141g.C2140d<K, V> m5872a(java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = 0;
        if (r3 == 0) goto L_0x000a;
    L_0x0003:
        r1 = 0;
        r3 = r2.m5873a(r3, r1);	 Catch:{ ClassCastException -> 0x0009 }
        goto L_0x000b;
    L_0x0009:
        return r0;
    L_0x000a:
        r3 = r0;
    L_0x000b:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.g.a(java.lang.Object):com.google.a.b.g$d<K, V>");
    }

    /* renamed from: a */
    C2140d<K, V> m5874a(Entry<?, ?> entry) {
        C2140d<K, V> a = m5872a(entry.getKey());
        entry = (a == null || m5869a(a.f5117g, entry.getValue()) == null) ? null : true;
        return entry != null ? a : null;
    }

    /* renamed from: a */
    private boolean m5869a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    void m5875a(C2140d<K, V> c2140d, boolean z) {
        if (z) {
            c2140d.f5115e.f5114d = c2140d.f5114d;
            c2140d.f5114d.f5115e = c2140d.f5115e;
        }
        C2140d c2140d2 = c2140d.f5112b;
        C2140d c2140d3 = c2140d.f5113c;
        C2140d c2140d4 = c2140d.f5111a;
        int i = 0;
        if (!c2140d2 != false || c2140d3 == null) {
            if (c2140d2 == true) {
                m5868a((C2140d) c2140d, c2140d2);
                c2140d.f5112b = null;
            } else if (c2140d3 != null) {
                m5868a((C2140d) c2140d, c2140d3);
                c2140d.f5113c = null;
            } else {
                m5868a((C2140d) c2140d, null);
            }
            m5871b(c2140d4, false);
            this.f5123c--;
            this.f5124d++;
            return;
        }
        int i2;
        c2140d2 = c2140d2.f5118h > c2140d3.f5118h ? c2140d2.m5866b() : c2140d3.m5865a();
        m5875a(c2140d2, false);
        c2140d3 = c2140d.f5112b;
        if (c2140d3 != null) {
            i2 = c2140d3.f5118h;
            c2140d2.f5112b = c2140d3;
            c2140d3.f5111a = c2140d2;
            c2140d.f5112b = null;
        } else {
            i2 = 0;
        }
        c2140d3 = c2140d.f5113c;
        if (c2140d3 != null) {
            i = c2140d3.f5118h;
            c2140d2.f5113c = c2140d3;
            c2140d3.f5111a = c2140d2;
            c2140d.f5113c = null;
        }
        c2140d2.f5118h = Math.max(i2, i) + 1;
        m5868a((C2140d) c2140d, c2140d2);
    }

    /* renamed from: b */
    C2140d<K, V> m5876b(Object obj) {
        C2140d a = m5872a(obj);
        if (a != null) {
            m5875a(a, true);
        }
        return a;
    }

    /* renamed from: a */
    private void m5868a(C2140d<K, V> c2140d, C2140d<K, V> c2140d2) {
        C2140d c2140d3 = c2140d.f5111a;
        c2140d.f5111a = null;
        if (c2140d2 != null) {
            c2140d2.f5111a = c2140d3;
        }
        if (c2140d3 == null) {
            this.f5122b = c2140d2;
        } else if (c2140d3.f5112b == c2140d) {
            c2140d3.f5112b = c2140d2;
        } else {
            if (!f5119f) {
                if (c2140d3.f5113c != c2140d) {
                    throw new AssertionError();
                }
            }
            c2140d3.f5113c = c2140d2;
        }
    }

    /* renamed from: b */
    private void m5871b(C2140d<K, V> c2140d, boolean z) {
        C2140d c2140d2;
        while (c2140d2 != null) {
            C2140d c2140d3 = c2140d2.f5112b;
            C2140d c2140d4 = c2140d2.f5113c;
            int i = 0;
            int i2 = c2140d3 != null ? c2140d3.f5118h : 0;
            int i3 = c2140d4 != null ? c2140d4.f5118h : 0;
            int i4 = i2 - i3;
            C2140d c2140d5;
            if (i4 == -2) {
                c2140d3 = c2140d4.f5112b;
                c2140d5 = c2140d4.f5113c;
                i2 = c2140d5 != null ? c2140d5.f5118h : 0;
                if (c2140d3 != null) {
                    i = c2140d3.f5118h;
                }
                i -= i2;
                if (i != -1) {
                    if (i != 0 || z) {
                        if (!f5119f) {
                            if (i != 1) {
                                throw new AssertionError();
                            }
                        }
                        m5870b(c2140d4);
                        m5867a(c2140d2);
                        if (z) {
                            return;
                        }
                    }
                }
                m5867a(c2140d2);
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                c2140d4 = c2140d3.f5112b;
                c2140d5 = c2140d3.f5113c;
                i2 = c2140d5 != null ? c2140d5.f5118h : 0;
                if (c2140d4 != null) {
                    i = c2140d4.f5118h;
                }
                i -= i2;
                if (i != 1) {
                    if (i != 0 || z) {
                        if (!f5119f) {
                            if (i != -1) {
                                throw new AssertionError();
                            }
                        }
                        m5867a(c2140d3);
                        m5870b(c2140d2);
                        if (z) {
                            return;
                        }
                    }
                }
                m5870b(c2140d2);
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                c2140d2.f5118h = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                if (!(f5119f || i4 == -1)) {
                    if (i4 != 1) {
                        throw new AssertionError();
                    }
                }
                c2140d2.f5118h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            c2140d2 = c2140d2.f5111a;
        }
    }

    /* renamed from: a */
    private void m5867a(C2140d<K, V> c2140d) {
        C2140d c2140d2 = c2140d.f5112b;
        C2140d c2140d3 = c2140d.f5113c;
        C2140d c2140d4 = c2140d3.f5112b;
        C2140d c2140d5 = c2140d3.f5113c;
        c2140d.f5113c = c2140d4;
        if (c2140d4 != null) {
            c2140d4.f5111a = c2140d;
        }
        m5868a((C2140d) c2140d, c2140d3);
        c2140d3.f5112b = c2140d;
        c2140d.f5111a = c2140d3;
        int i = 0;
        c2140d.f5118h = Math.max(c2140d2 != null ? c2140d2.f5118h : 0, c2140d4 != null ? c2140d4.f5118h : 0) + 1;
        c2140d = c2140d.f5118h;
        if (c2140d5 != null) {
            i = c2140d5.f5118h;
        }
        c2140d3.f5118h = Math.max(c2140d, i) + 1;
    }

    /* renamed from: b */
    private void m5870b(C2140d<K, V> c2140d) {
        C2140d c2140d2 = c2140d.f5112b;
        C2140d c2140d3 = c2140d.f5113c;
        C2140d c2140d4 = c2140d2.f5112b;
        C2140d c2140d5 = c2140d2.f5113c;
        c2140d.f5112b = c2140d5;
        if (c2140d5 != null) {
            c2140d5.f5111a = c2140d;
        }
        m5868a((C2140d) c2140d, c2140d2);
        c2140d2.f5113c = c2140d;
        c2140d.f5111a = c2140d2;
        int i = 0;
        c2140d.f5118h = Math.max(c2140d3 != null ? c2140d3.f5118h : 0, c2140d5 != null ? c2140d5.f5118h : 0) + 1;
        c2140d = c2140d.f5118h;
        if (c2140d4 != null) {
            i = c2140d4.f5118h;
        }
        c2140d2.f5118h = Math.max(c2140d, i) + 1;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.f5126h;
        if (set != null) {
            return set;
        }
        Set c2137a = new C2137a(this);
        this.f5126h = c2137a;
        return c2137a;
    }

    public Set<K> keySet() {
        Set<K> set = this.f5127i;
        if (set != null) {
            return set;
        }
        Set c2138b = new C2138b(this);
        this.f5127i = c2138b;
        return c2138b;
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }
}
