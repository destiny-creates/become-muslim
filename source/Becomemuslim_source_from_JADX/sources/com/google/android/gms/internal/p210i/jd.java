package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.jd */
public final class jd implements Cloneable {
    /* renamed from: a */
    private static final je f16782a = new je();
    /* renamed from: b */
    private boolean f16783b;
    /* renamed from: c */
    private int[] f16784c;
    /* renamed from: d */
    private je[] f16785d;
    /* renamed from: e */
    private int f16786e;

    jd() {
        this(10);
    }

    private jd(int i) {
        this.f16783b = false;
        i = jd.m20987c(i);
        this.f16784c = new int[i];
        this.f16785d = new je[i];
        this.f16786e = 0;
    }

    /* renamed from: a */
    final je m20990a(int i) {
        i = m20988d(i);
        if (i >= 0) {
            if (this.f16785d[i] != f16782a) {
                return this.f16785d[i];
            }
        }
        return 0;
    }

    /* renamed from: a */
    final void m20991a(int i, je jeVar) {
        int d = m20988d(i);
        if (d >= 0) {
            this.f16785d[d] = jeVar;
            return;
        }
        d = ~d;
        if (d >= this.f16786e || this.f16785d[d] != f16782a) {
            if (this.f16786e >= this.f16784c.length) {
                int c = jd.m20987c(this.f16786e + 1);
                Object obj = new int[c];
                Object obj2 = new je[c];
                System.arraycopy(this.f16784c, 0, obj, 0, this.f16784c.length);
                System.arraycopy(this.f16785d, 0, obj2, 0, this.f16785d.length);
                this.f16784c = obj;
                this.f16785d = obj2;
            }
            if (this.f16786e - d != 0) {
                int i2 = d + 1;
                System.arraycopy(this.f16784c, d, this.f16784c, i2, this.f16786e - d);
                System.arraycopy(this.f16785d, d, this.f16785d, i2, this.f16786e - d);
            }
            this.f16784c[d] = i;
            this.f16785d[d] = jeVar;
            this.f16786e++;
            return;
        }
        this.f16784c[d] = i;
        this.f16785d[d] = jeVar;
    }

    /* renamed from: a */
    final int m20989a() {
        return this.f16786e;
    }

    /* renamed from: b */
    public final boolean m20993b() {
        return this.f16786e == 0;
    }

    /* renamed from: b */
    final je m20992b(int i) {
        return this.f16785d[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof jd)) {
            return false;
        }
        jd jdVar = (jd) obj;
        if (this.f16786e != jdVar.f16786e) {
            return false;
        }
        Object obj2;
        int[] iArr = this.f16784c;
        int[] iArr2 = jdVar.f16784c;
        int i = this.f16786e;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                obj2 = null;
                break;
            }
        }
        obj2 = 1;
        if (obj2 != null) {
            je[] jeVarArr = this.f16785d;
            obj = jdVar.f16785d;
            int i3 = this.f16786e;
            for (i = 0; i < i3; i++) {
                if (!jeVarArr[i].equals(obj[i])) {
                    obj = null;
                    break;
                }
            }
            obj = true;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f16786e; i2++) {
            i = (((i * 31) + this.f16784c[i2]) * 31) + this.f16785d[i2].hashCode();
        }
        return i;
    }

    /* renamed from: c */
    private static int m20987c(int i) {
        i <<= 2;
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                i = i3;
                break;
            }
        }
        return i / 4;
    }

    /* renamed from: d */
    private final int m20988d(int i) {
        int i2 = this.f16786e - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.f16784c[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    public final /* synthetic */ Object clone() {
        int i = this.f16786e;
        jd jdVar = new jd(i);
        int i2 = 0;
        System.arraycopy(this.f16784c, 0, jdVar.f16784c, 0, i);
        while (i2 < i) {
            if (this.f16785d[i2] != null) {
                jdVar.f16785d[i2] = (je) this.f16785d[i2].clone();
            }
            i2++;
        }
        jdVar.f16786e = i;
        return jdVar;
    }
}
