package android.support.v4.util;

/* compiled from: LongSparseArray */
/* renamed from: android.support.v4.util.f */
public class C0452f<E> implements Cloneable {
    /* renamed from: a */
    private static final Object f1161a = new Object();
    /* renamed from: b */
    private boolean f1162b;
    /* renamed from: c */
    private long[] f1163c;
    /* renamed from: d */
    private Object[] f1164d;
    /* renamed from: e */
    private int f1165e;

    public /* synthetic */ Object clone() {
        return m1411a();
    }

    public C0452f() {
        this(10);
    }

    public C0452f(int i) {
        this.f1162b = false;
        if (i == 0) {
            this.f1163c = C0449c.f1157b;
            this.f1164d = C0449c.f1158c;
        } else {
            i = C0449c.m1406b(i);
            this.f1163c = new long[i];
            this.f1164d = new Object[i];
        }
        this.f1165e = 0;
    }

    /* renamed from: a */
    public android.support.v4.util.C0452f<E> m1411a() {
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
        r2 = this;
        r0 = 0;
        r1 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (android.support.v4.util.C0452f) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r0 = r2.f1163c;	 Catch:{ CloneNotSupportedException -> 0x001d }
        r0 = r0.clone();	 Catch:{ CloneNotSupportedException -> 0x001d }
        r0 = (long[]) r0;	 Catch:{ CloneNotSupportedException -> 0x001d }
        r1.f1163c = r0;	 Catch:{ CloneNotSupportedException -> 0x001d }
        r0 = r2.f1164d;	 Catch:{ CloneNotSupportedException -> 0x001d }
        r0 = r0.clone();	 Catch:{ CloneNotSupportedException -> 0x001d }
        r0 = (java.lang.Object[]) r0;	 Catch:{ CloneNotSupportedException -> 0x001d }
        r1.f1164d = r0;	 Catch:{ CloneNotSupportedException -> 0x001d }
        goto L_0x001d;
    L_0x001c:
        r1 = r0;
    L_0x001d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.f.a():android.support.v4.util.f<E>");
    }

    /* renamed from: a */
    public E m1412a(long j) {
        return m1413a(j, null);
    }

    /* renamed from: a */
    public E m1413a(long j, E e) {
        j = C0449c.m1404a(this.f1163c, this.f1165e, j);
        if (j >= null) {
            if (this.f1164d[j] != f1161a) {
                return this.f1164d[j];
            }
        }
        return e;
    }

    /* renamed from: b */
    public void m1417b(long j) {
        j = C0449c.m1404a(this.f1163c, this.f1165e, j);
        if (j >= null && this.f1164d[j] != f1161a) {
            this.f1164d[j] = f1161a;
            this.f1162b = 1;
        }
    }

    /* renamed from: a */
    public void m1414a(int i) {
        if (this.f1164d[i] != f1161a) {
            this.f1164d[i] = f1161a;
            this.f1162b = true;
        }
    }

    /* renamed from: d */
    private void m1410d() {
        int i = this.f1165e;
        long[] jArr = this.f1163c;
        Object[] objArr = this.f1164d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1161a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1162b = false;
        this.f1165e = i2;
    }

    /* renamed from: b */
    public void m1418b(long j, E e) {
        int a = C0449c.m1404a(this.f1163c, this.f1165e, j);
        if (a >= 0) {
            this.f1164d[a] = e;
        } else {
            a = ~a;
            if (a >= this.f1165e || this.f1164d[a] != f1161a) {
                if (this.f1162b && this.f1165e >= this.f1163c.length) {
                    m1410d();
                    a = ~C0449c.m1404a(this.f1163c, this.f1165e, j);
                }
                if (this.f1165e >= this.f1163c.length) {
                    int b = C0449c.m1406b(this.f1165e + 1);
                    Object obj = new long[b];
                    Object obj2 = new Object[b];
                    System.arraycopy(this.f1163c, 0, obj, 0, this.f1163c.length);
                    System.arraycopy(this.f1164d, 0, obj2, 0, this.f1164d.length);
                    this.f1163c = obj;
                    this.f1164d = obj2;
                }
                if (this.f1165e - a != 0) {
                    int i = a + 1;
                    System.arraycopy(this.f1163c, a, this.f1163c, i, this.f1165e - a);
                    System.arraycopy(this.f1164d, a, this.f1164d, i, this.f1165e - a);
                }
                this.f1163c[a] = j;
                this.f1164d[a] = e;
                this.f1165e++;
            } else {
                this.f1163c[a] = j;
                this.f1164d[a] = e;
            }
        }
    }

    /* renamed from: b */
    public int m1415b() {
        if (this.f1162b) {
            m1410d();
        }
        return this.f1165e;
    }

    /* renamed from: b */
    public long m1416b(int i) {
        if (this.f1162b) {
            m1410d();
        }
        return this.f1163c[i];
    }

    /* renamed from: c */
    public E m1420c(int i) {
        if (this.f1162b) {
            m1410d();
        }
        return this.f1164d[i];
    }

    /* renamed from: c */
    public int m1419c(long j) {
        if (this.f1162b) {
            m1410d();
        }
        return C0449c.m1404a(this.f1163c, this.f1165e, j);
    }

    /* renamed from: c */
    public void m1421c() {
        int i = this.f1165e;
        Object[] objArr = this.f1164d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1165e = 0;
        this.f1162b = false;
    }

    public String toString() {
        if (m1415b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1165e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1165e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1416b(i));
            stringBuilder.append('=');
            C0452f c = m1420c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
