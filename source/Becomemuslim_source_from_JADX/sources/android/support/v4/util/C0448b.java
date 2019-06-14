package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: ArraySet */
/* renamed from: android.support.v4.util.b */
public final class C0448b<E> implements Collection<E>, Set<E> {
    /* renamed from: a */
    private static final int[] f1146a = new int[0];
    /* renamed from: b */
    private static final Object[] f1147b = new Object[0];
    /* renamed from: c */
    private static Object[] f1148c;
    /* renamed from: d */
    private static int f1149d;
    /* renamed from: e */
    private static Object[] f1150e;
    /* renamed from: f */
    private static int f1151f;
    /* renamed from: g */
    private int[] f1152g;
    /* renamed from: h */
    private Object[] f1153h;
    /* renamed from: i */
    private int f1154i;
    /* renamed from: j */
    private C0459h<E, E> f1155j;

    /* compiled from: ArraySet */
    /* renamed from: android.support.v4.util.b$1 */
    class C32121 extends C0459h<E, E> {
        /* renamed from: a */
        final /* synthetic */ C0448b f8267a;

        C32121(C0448b c0448b) {
            this.f8267a = c0448b;
        }

        /* renamed from: a */
        protected int mo303a() {
            return this.f8267a.f1154i;
        }

        /* renamed from: a */
        protected Object mo305a(int i, int i2) {
            return this.f8267a.f1153h[i];
        }

        /* renamed from: a */
        protected int mo304a(Object obj) {
            return this.f8267a.m1398a(obj);
        }

        /* renamed from: b */
        protected int mo309b(Object obj) {
            return this.f8267a.m1398a(obj);
        }

        /* renamed from: b */
        protected Map<E, E> mo310b() {
            throw new UnsupportedOperationException("not a map");
        }

        /* renamed from: a */
        protected void mo308a(E e, E e2) {
            this.f8267a.add(e);
        }

        /* renamed from: a */
        protected E mo306a(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }

        /* renamed from: a */
        protected void mo307a(int i) {
            this.f8267a.m1401c(i);
        }

        /* renamed from: c */
        protected void mo311c() {
            this.f8267a.clear();
        }
    }

    /* renamed from: a */
    private int m1393a(Object obj, int i) {
        int i2 = this.f1154i;
        if (i2 == 0) {
            return -1;
        }
        int a = C0449c.m1403a(this.f1152g, i2, i);
        if (a < 0 || obj.equals(this.f1153h[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f1152g[i3] == i) {
            if (obj.equals(this.f1153h[i3])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f1152g[a] == i) {
            if (obj.equals(this.f1153h[a])) {
                return a;
            }
            a--;
        }
        return ~i3;
    }

    /* renamed from: a */
    private int m1391a() {
        int i = this.f1154i;
        if (i == 0) {
            return -1;
        }
        int a = C0449c.m1403a(this.f1152g, i, 0);
        if (a < 0 || this.f1153h[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f1152g[i2] == 0) {
            if (this.f1153h[i2] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f1152g[a] == 0) {
            if (this.f1153h[a] == null) {
                return a;
            }
            a--;
        }
        return ~i2;
    }

    /* renamed from: d */
    private void m1397d(int i) {
        if (i == 8) {
            synchronized (C0448b.class) {
                if (f1150e != null) {
                    i = f1150e;
                    this.f1153h = i;
                    f1150e = (Object[]) i[0];
                    this.f1152g = (int[]) i[1];
                    i[1] = null;
                    i[0] = null;
                    f1151f--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0448b.class) {
                if (f1148c != null) {
                    i = f1148c;
                    this.f1153h = i;
                    f1148c = (Object[]) i[0];
                    this.f1152g = (int[]) i[1];
                    i[1] = null;
                    i[0] = null;
                    f1149d--;
                    return;
                }
            }
        }
        this.f1152g = new int[i];
        this.f1153h = new Object[i];
    }

    /* renamed from: a */
    private static void m1394a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0448b.class) {
                if (f1151f < 10) {
                    objArr[0] = f1150e;
                    objArr[1] = iArr;
                    for (i--; i >= 2; i--) {
                        objArr[i] = null;
                    }
                    f1150e = objArr;
                    f1151f += 1;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0448b.class) {
                if (f1149d < 10) {
                    objArr[0] = f1148c;
                    objArr[1] = iArr;
                    for (i--; i >= 2; i--) {
                        objArr[i] = null;
                    }
                    f1148c = objArr;
                    f1149d += 1;
                }
            }
        }
    }

    public C0448b() {
        this(0);
    }

    public C0448b(int i) {
        if (i == 0) {
            this.f1152g = f1146a;
            this.f1153h = f1147b;
        } else {
            m1397d(i);
        }
        this.f1154i = 0;
    }

    public void clear() {
        if (this.f1154i != 0) {
            C0448b.m1394a(this.f1152g, this.f1153h, this.f1154i);
            this.f1152g = f1146a;
            this.f1153h = f1147b;
            this.f1154i = 0;
        }
    }

    /* renamed from: a */
    public void m1399a(int i) {
        if (this.f1152g.length < i) {
            Object obj = this.f1152g;
            Object obj2 = this.f1153h;
            m1397d(i);
            if (this.f1154i > 0) {
                System.arraycopy(obj, 0, this.f1152g, 0, this.f1154i);
                System.arraycopy(obj2, 0, this.f1153h, 0, this.f1154i);
            }
            C0448b.m1394a(obj, obj2, this.f1154i);
        }
    }

    public boolean contains(Object obj) {
        return m1398a(obj) >= null ? true : null;
    }

    /* renamed from: a */
    public int m1398a(Object obj) {
        return obj == null ? m1391a() : m1393a(obj, obj.hashCode());
    }

    /* renamed from: b */
    public E m1400b(int i) {
        return this.f1153h[i];
    }

    public boolean isEmpty() {
        return this.f1154i <= 0;
    }

    public boolean add(E e) {
        int a;
        int i;
        if (e == null) {
            a = m1391a();
            i = 0;
        } else {
            a = e.hashCode();
            i = a;
            a = m1393a(e, a);
        }
        if (a >= 0) {
            return false;
        }
        int i2;
        a = ~a;
        if (this.f1154i >= this.f1152g.length) {
            i2 = 4;
            if (this.f1154i >= 8) {
                i2 = (this.f1154i >> 1) + this.f1154i;
            } else if (this.f1154i >= 4) {
                i2 = 8;
            }
            Object obj = this.f1152g;
            Object obj2 = this.f1153h;
            m1397d(i2);
            if (this.f1152g.length > 0) {
                System.arraycopy(obj, 0, this.f1152g, 0, obj.length);
                System.arraycopy(obj2, 0, this.f1153h, 0, obj2.length);
            }
            C0448b.m1394a(obj, obj2, this.f1154i);
        }
        if (a < this.f1154i) {
            i2 = a + 1;
            System.arraycopy(this.f1152g, a, this.f1152g, i2, this.f1154i - a);
            System.arraycopy(this.f1153h, a, this.f1153h, i2, this.f1154i - a);
        }
        this.f1152g[a] = i;
        this.f1153h[a] = e;
        this.f1154i += 1;
        return true;
    }

    public boolean remove(Object obj) {
        obj = m1398a(obj);
        if (obj < null) {
            return null;
        }
        m1401c(obj);
        return true;
    }

    /* renamed from: c */
    public E m1401c(int i) {
        E e = this.f1153h[i];
        if (this.f1154i <= 1) {
            C0448b.m1394a(this.f1152g, this.f1153h, this.f1154i);
            this.f1152g = f1146a;
            this.f1153h = f1147b;
            this.f1154i = 0;
        } else {
            int i2 = 8;
            int i3;
            if (this.f1152g.length <= 8 || this.f1154i >= this.f1152g.length / 3) {
                this.f1154i--;
                if (i < this.f1154i) {
                    i3 = i + 1;
                    System.arraycopy(this.f1152g, i3, this.f1152g, i, this.f1154i - i);
                    System.arraycopy(this.f1153h, i3, this.f1153h, i, this.f1154i - i);
                }
                this.f1153h[this.f1154i] = null;
            } else {
                if (this.f1154i > 8) {
                    i2 = (this.f1154i >> 1) + this.f1154i;
                }
                Object obj = this.f1152g;
                Object obj2 = this.f1153h;
                m1397d(i2);
                this.f1154i--;
                if (i > 0) {
                    System.arraycopy(obj, 0, this.f1152g, 0, i);
                    System.arraycopy(obj2, 0, this.f1153h, 0, i);
                }
                if (i < this.f1154i) {
                    i3 = i + 1;
                    System.arraycopy(obj, i3, this.f1152g, i, this.f1154i - i);
                    System.arraycopy(obj2, i3, this.f1153h, i, this.f1154i - i);
                }
            }
        }
        return e;
    }

    public int size() {
        return this.f1154i;
    }

    public Object[] toArray() {
        Object obj = new Object[this.f1154i];
        System.arraycopy(this.f1153h, 0, obj, 0, this.f1154i);
        return obj;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1154i) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1154i);
        }
        System.arraycopy(this.f1153h, 0, tArr, 0, this.f1154i);
        if (tArr.length > this.f1154i) {
            tArr[this.f1154i] = null;
        }
        return tArr;
    }

    public boolean equals(java.lang.Object r5) {
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
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Set;
        r2 = 0;
        if (r1 == 0) goto L_0x002c;
    L_0x0009:
        r5 = (java.util.Set) r5;
        r1 = r4.size();
        r3 = r5.size();
        if (r1 == r3) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = 0;
    L_0x0017:
        r3 = r4.f1154i;	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
        if (r1 >= r3) goto L_0x0029;	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
    L_0x001b:
        r3 = r4.m1400b(r1);	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
        r3 = r5.contains(r3);	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
        if (r3 != 0) goto L_0x0026;
    L_0x0025:
        return r2;
    L_0x0026:
        r1 = r1 + 1;
        goto L_0x0017;
    L_0x0029:
        return r0;
    L_0x002a:
        return r2;
    L_0x002b:
        return r2;
    L_0x002c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int[] iArr = this.f1152g;
        int i = 0;
        for (int i2 = 0; i2 < this.f1154i; i2++) {
            i += iArr[i2];
        }
        return i;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1154i * 14);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1154i; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0448b b = m1400b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Set)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private C0459h<E, E> m1395b() {
        if (this.f1155j == null) {
            this.f1155j = new C32121(this);
        }
        return this.f1155j;
    }

    public Iterator<E> iterator() {
        return m1395b().m1447e().iterator();
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return null;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        m1399a(this.f1154i + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f1154i - 1; i >= 0; i--) {
            if (!collection.contains(this.f1153h[i])) {
                m1401c(i);
                z = true;
            }
        }
        return z;
    }
}
