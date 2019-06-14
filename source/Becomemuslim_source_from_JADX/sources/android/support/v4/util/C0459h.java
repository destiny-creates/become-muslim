package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: MapCollections */
/* renamed from: android.support.v4.util.h */
abstract class C0459h<K, V> {
    /* renamed from: b */
    C0455b f1186b;
    /* renamed from: c */
    C0456c f1187c;
    /* renamed from: d */
    C0458e f1188d;

    /* compiled from: MapCollections */
    /* renamed from: android.support.v4.util.h$a */
    final class C0454a<T> implements Iterator<T> {
        /* renamed from: a */
        final int f1174a;
        /* renamed from: b */
        int f1175b;
        /* renamed from: c */
        int f1176c;
        /* renamed from: d */
        boolean f1177d = false;
        /* renamed from: e */
        final /* synthetic */ C0459h f1178e;

        C0454a(C0459h c0459h, int i) {
            this.f1178e = c0459h;
            this.f1174a = i;
            this.f1175b = c0459h.mo303a();
        }

        public boolean hasNext() {
            return this.f1176c < this.f1175b;
        }

        public T next() {
            if (hasNext()) {
                T a = this.f1178e.mo305a(this.f1176c, this.f1174a);
                this.f1176c++;
                this.f1177d = true;
                return a;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f1177d) {
                this.f1176c--;
                this.f1175b--;
                this.f1177d = false;
                this.f1178e.mo307a(this.f1176c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MapCollections */
    /* renamed from: android.support.v4.util.h$b */
    final class C0455b implements Set<Entry<K, V>> {
        /* renamed from: a */
        final /* synthetic */ C0459h f1179a;

        C0455b(C0459h c0459h) {
            this.f1179a = c0459h;
        }

        public /* synthetic */ boolean add(Object obj) {
            return m1429a((Entry) obj);
        }

        /* renamed from: a */
        public boolean m1429a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f1179a.mo303a();
            for (Entry entry : collection) {
                this.f1179a.mo308a(entry.getKey(), entry.getValue());
            }
            return a != this.f1179a.mo303a() ? true : null;
        }

        public void clear() {
            this.f1179a.mo311c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f1179a.mo304a(entry.getKey());
            if (a < 0) {
                return false;
            }
            return C0449c.m1405a(this.f1179a.mo305a(a, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return null;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f1179a.mo303a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C0457d(this.f1179a);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.f1179a.mo303a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return C0459h.m1432a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f1179a.mo303a() - 1; a >= 0; a--) {
                int i2;
                int i3;
                Object a2 = this.f1179a.mo305a(a, 0);
                Object a3 = this.f1179a.mo305a(a, 1);
                if (a2 == null) {
                    i2 = 0;
                } else {
                    i2 = a2.hashCode();
                }
                if (a3 == null) {
                    i3 = 0;
                } else {
                    i3 = a3.hashCode();
                }
                i += i2 ^ i3;
            }
            return i;
        }
    }

    /* compiled from: MapCollections */
    /* renamed from: android.support.v4.util.h$c */
    final class C0456c implements Set<K> {
        /* renamed from: a */
        final /* synthetic */ C0459h f1180a;

        C0456c(C0459h c0459h) {
            this.f1180a = c0459h;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f1180a.mo311c();
        }

        public boolean contains(Object obj) {
            return this.f1180a.mo304a(obj) >= null ? true : null;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0459h.m1431a(this.f1180a.mo310b(), (Collection) collection);
        }

        public boolean isEmpty() {
            return this.f1180a.mo303a() == 0;
        }

        public Iterator<K> iterator() {
            return new C0454a(this.f1180a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f1180a.mo304a(obj);
            if (a < null) {
                return null;
            }
            this.f1180a.mo307a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0459h.m1433b(this.f1180a.mo310b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0459h.m1434c(this.f1180a.mo310b(), collection);
        }

        public int size() {
            return this.f1180a.mo303a();
        }

        public Object[] toArray() {
            return this.f1180a.m1444b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f1180a.m1441a((Object[]) tArr, 0);
        }

        public boolean equals(Object obj) {
            return C0459h.m1432a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f1180a.mo303a() - 1; a >= 0; a--) {
                int i2;
                Object a2 = this.f1180a.mo305a(a, 0);
                if (a2 == null) {
                    i2 = 0;
                } else {
                    i2 = a2.hashCode();
                }
                i += i2;
            }
            return i;
        }
    }

    /* compiled from: MapCollections */
    /* renamed from: android.support.v4.util.h$d */
    final class C0457d implements Iterator<Entry<K, V>>, Entry<K, V> {
        /* renamed from: a */
        int f1181a;
        /* renamed from: b */
        int f1182b;
        /* renamed from: c */
        boolean f1183c = false;
        /* renamed from: d */
        final /* synthetic */ C0459h f1184d;

        public /* synthetic */ Object next() {
            return m1430a();
        }

        C0457d(C0459h c0459h) {
            this.f1184d = c0459h;
            this.f1181a = c0459h.mo303a() - 1;
            this.f1182b = -1;
        }

        public boolean hasNext() {
            return this.f1182b < this.f1181a;
        }

        /* renamed from: a */
        public Entry<K, V> m1430a() {
            if (hasNext()) {
                this.f1182b++;
                this.f1183c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f1183c) {
                this.f1184d.mo307a(this.f1182b);
                this.f1182b--;
                this.f1181a--;
                this.f1183c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.f1183c) {
                return this.f1184d.mo305a(this.f1182b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f1183c) {
                return this.f1184d.mo305a(this.f1182b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.f1183c) {
                return this.f1184d.mo306a(this.f1182b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean equals(Object obj) {
            if (this.f1183c) {
                boolean z = false;
                if (!(obj instanceof Entry)) {
                    return false;
                }
                Entry entry = (Entry) obj;
                if (C0449c.m1405a(entry.getKey(), this.f1184d.mo305a(this.f1182b, 0)) && C0449c.m1405a(entry.getValue(), this.f1184d.mo305a(this.f1182b, 1)) != null) {
                    z = true;
                }
                return z;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public int hashCode() {
            if (this.f1183c) {
                int i;
                int i2 = 0;
                Object a = this.f1184d.mo305a(this.f1182b, 0);
                Object a2 = this.f1184d.mo305a(this.f1182b, 1);
                if (a == null) {
                    i = 0;
                } else {
                    i = a.hashCode();
                }
                if (a2 != null) {
                    i2 = a2.hashCode();
                }
                return i ^ i2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getKey());
            stringBuilder.append("=");
            stringBuilder.append(getValue());
            return stringBuilder.toString();
        }
    }

    /* compiled from: MapCollections */
    /* renamed from: android.support.v4.util.h$e */
    final class C0458e implements Collection<V> {
        /* renamed from: a */
        final /* synthetic */ C0459h f1185a;

        C0458e(C0459h c0459h) {
            this.f1185a = c0459h;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f1185a.mo311c();
        }

        public boolean contains(Object obj) {
            return this.f1185a.mo309b(obj) >= null ? true : null;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return null;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f1185a.mo303a() == 0;
        }

        public Iterator<V> iterator() {
            return new C0454a(this.f1185a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f1185a.mo309b(obj);
            if (b < null) {
                return null;
            }
            this.f1185a.mo307a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int a = this.f1185a.mo303a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f1185a.mo305a(i, 1))) {
                    this.f1185a.mo307a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int a = this.f1185a.mo303a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f1185a.mo305a(i, 1))) {
                    this.f1185a.mo307a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f1185a.mo303a();
        }

        public Object[] toArray() {
            return this.f1185a.m1444b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f1185a.m1441a((Object[]) tArr, 1);
        }
    }

    /* renamed from: a */
    protected abstract int mo303a();

    /* renamed from: a */
    protected abstract int mo304a(Object obj);

    /* renamed from: a */
    protected abstract Object mo305a(int i, int i2);

    /* renamed from: a */
    protected abstract V mo306a(int i, V v);

    /* renamed from: a */
    protected abstract void mo307a(int i);

    /* renamed from: a */
    protected abstract void mo308a(K k, V v);

    /* renamed from: b */
    protected abstract int mo309b(Object obj);

    /* renamed from: b */
    protected abstract Map<K, V> mo310b();

    /* renamed from: c */
    protected abstract void mo311c();

    C0459h() {
    }

    /* renamed from: a */
    public static <K, V> boolean m1431a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static <K, V> boolean m1433b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size() ? true : null;
    }

    /* renamed from: c */
    public static <K, V> boolean m1434c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size() ? true : null;
    }

    /* renamed from: b */
    public Object[] m1444b(int i) {
        int a = mo303a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo305a(i2, i);
        }
        return objArr;
    }

    /* renamed from: a */
    public <T> T[] m1441a(T[] tArr, int i) {
        int a = mo303a();
        if (tArr.length < a) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr[i2] = mo305a(i2, i);
        }
        if (tArr.length > a) {
            tArr[a] = 0;
        }
        return tArr;
    }

    /* renamed from: a */
    public static <T> boolean m1432a(java.util.Set<T> r4, java.lang.Object r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Set;
        r2 = 0;
        if (r1 == 0) goto L_0x0020;
    L_0x0009:
        r5 = (java.util.Set) r5;
        r1 = r4.size();	 Catch:{ NullPointerException -> 0x001f, ClassCastException -> 0x001e }
        r3 = r5.size();	 Catch:{ NullPointerException -> 0x001f, ClassCastException -> 0x001e }
        if (r1 != r3) goto L_0x001c;	 Catch:{ NullPointerException -> 0x001f, ClassCastException -> 0x001e }
    L_0x0015:
        r4 = r4.containsAll(r5);	 Catch:{ NullPointerException -> 0x001f, ClassCastException -> 0x001e }
        if (r4 == 0) goto L_0x001c;
    L_0x001b:
        goto L_0x001d;
    L_0x001c:
        r0 = 0;
    L_0x001d:
        return r0;
    L_0x001e:
        return r2;
    L_0x001f:
        return r2;
    L_0x0020:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.h.a(java.util.Set, java.lang.Object):boolean");
    }

    /* renamed from: d */
    public Set<Entry<K, V>> m1446d() {
        if (this.f1186b == null) {
            this.f1186b = new C0455b(this);
        }
        return this.f1186b;
    }

    /* renamed from: e */
    public Set<K> m1447e() {
        if (this.f1187c == null) {
            this.f1187c = new C0456c(this);
        }
        return this.f1187c;
    }

    /* renamed from: f */
    public Collection<V> m1448f() {
        if (this.f1188d == null) {
            this.f1188d = new C0458e(this);
        }
        return this.f1188d;
    }
}
