package android.support.v4.util;

/* compiled from: SparseArrayCompat */
/* renamed from: android.support.v4.util.m */
public class C0464m<E> implements Cloneable {
    /* renamed from: a */
    private static final Object f1198a = new Object();
    /* renamed from: b */
    private boolean f1199b;
    /* renamed from: c */
    private int[] f1200c;
    /* renamed from: d */
    private Object[] f1201d;
    /* renamed from: e */
    private int f1202e;

    public /* synthetic */ Object clone() {
        return m1466a();
    }

    public C0464m() {
        this(10);
    }

    public C0464m(int i) {
        this.f1199b = false;
        if (i == 0) {
            this.f1200c = C0449c.f1156a;
            this.f1201d = C0449c.f1158c;
        } else {
            i = C0449c.m1402a(i);
            this.f1200c = new int[i];
            this.f1201d = new Object[i];
        }
        this.f1202e = 0;
    }

    /* renamed from: a */
    public android.support.v4.util.C0464m<E> m1466a() {
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
        r1 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (android.support.v4.util.C0464m) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r0 = r2.f1200c;	 Catch:{ CloneNotSupportedException -> 0x001d }
        r0 = r0.clone();	 Catch:{ CloneNotSupportedException -> 0x001d }
        r0 = (int[]) r0;	 Catch:{ CloneNotSupportedException -> 0x001d }
        r1.f1200c = r0;	 Catch:{ CloneNotSupportedException -> 0x001d }
        r0 = r2.f1201d;	 Catch:{ CloneNotSupportedException -> 0x001d }
        r0 = r0.clone();	 Catch:{ CloneNotSupportedException -> 0x001d }
        r0 = (java.lang.Object[]) r0;	 Catch:{ CloneNotSupportedException -> 0x001d }
        r1.f1201d = r0;	 Catch:{ CloneNotSupportedException -> 0x001d }
        goto L_0x001d;
    L_0x001c:
        r1 = r0;
    L_0x001d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.m.a():android.support.v4.util.m<E>");
    }

    /* renamed from: a */
    public E m1467a(int i) {
        return m1468a(i, null);
    }

    /* renamed from: a */
    public E m1468a(int i, E e) {
        i = C0449c.m1403a(this.f1200c, this.f1202e, i);
        if (i >= 0) {
            if (this.f1201d[i] != f1198a) {
                return this.f1201d[i];
            }
        }
        return e;
    }

    /* renamed from: b */
    public void m1470b(int i) {
        i = C0449c.m1403a(this.f1200c, this.f1202e, i);
        if (i >= 0 && this.f1201d[i] != f1198a) {
            this.f1201d[i] = f1198a;
            this.f1199b = true;
        }
    }

    /* renamed from: c */
    public void m1473c(int i) {
        m1470b(i);
    }

    /* renamed from: d */
    private void m1465d() {
        int i = this.f1202e;
        int[] iArr = this.f1200c;
        Object[] objArr = this.f1201d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1198a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1199b = false;
        this.f1202e = i2;
    }

    /* renamed from: b */
    public void m1471b(int i, E e) {
        int a = C0449c.m1403a(this.f1200c, this.f1202e, i);
        if (a >= 0) {
            this.f1201d[a] = e;
        } else {
            a = ~a;
            if (a >= this.f1202e || this.f1201d[a] != f1198a) {
                if (this.f1199b && this.f1202e >= this.f1200c.length) {
                    m1465d();
                    a = ~C0449c.m1403a(this.f1200c, this.f1202e, i);
                }
                if (this.f1202e >= this.f1200c.length) {
                    int a2 = C0449c.m1402a(this.f1202e + 1);
                    Object obj = new int[a2];
                    Object obj2 = new Object[a2];
                    System.arraycopy(this.f1200c, 0, obj, 0, this.f1200c.length);
                    System.arraycopy(this.f1201d, 0, obj2, 0, this.f1201d.length);
                    this.f1200c = obj;
                    this.f1201d = obj2;
                }
                if (this.f1202e - a != 0) {
                    int i2 = a + 1;
                    System.arraycopy(this.f1200c, a, this.f1200c, i2, this.f1202e - a);
                    System.arraycopy(this.f1201d, a, this.f1201d, i2, this.f1202e - a);
                }
                this.f1200c[a] = i;
                this.f1201d[a] = e;
                this.f1202e++;
            } else {
                this.f1200c[a] = i;
                this.f1201d[a] = e;
            }
        }
    }

    /* renamed from: b */
    public int m1469b() {
        if (this.f1199b) {
            m1465d();
        }
        return this.f1202e;
    }

    /* renamed from: d */
    public int m1475d(int i) {
        if (this.f1199b) {
            m1465d();
        }
        return this.f1200c[i];
    }

    /* renamed from: e */
    public E m1476e(int i) {
        if (this.f1199b) {
            m1465d();
        }
        return this.f1201d[i];
    }

    /* renamed from: f */
    public int m1477f(int i) {
        if (this.f1199b) {
            m1465d();
        }
        return C0449c.m1403a(this.f1200c, this.f1202e, i);
    }

    /* renamed from: c */
    public void m1472c() {
        int i = this.f1202e;
        Object[] objArr = this.f1201d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1202e = 0;
        this.f1199b = false;
    }

    /* renamed from: c */
    public void m1474c(int i, E e) {
        if (this.f1202e == 0 || i > this.f1200c[this.f1202e - 1]) {
            if (this.f1199b && this.f1202e >= this.f1200c.length) {
                m1465d();
            }
            int i2 = this.f1202e;
            if (i2 >= this.f1200c.length) {
                int a = C0449c.m1402a(i2 + 1);
                Object obj = new int[a];
                Object obj2 = new Object[a];
                System.arraycopy(this.f1200c, 0, obj, 0, this.f1200c.length);
                System.arraycopy(this.f1201d, 0, obj2, 0, this.f1201d.length);
                this.f1200c = obj;
                this.f1201d = obj2;
            }
            this.f1200c[i2] = i;
            this.f1201d[i2] = e;
            this.f1202e = i2 + 1;
            return;
        }
        m1471b(i, e);
    }

    public String toString() {
        if (m1469b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1202e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1202e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1475d(i));
            stringBuilder.append('=');
            C0464m e = m1476e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
