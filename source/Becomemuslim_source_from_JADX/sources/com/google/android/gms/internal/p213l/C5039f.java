package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.f */
public final class C5039f implements Cloneable {
    /* renamed from: a */
    private static final C5040g f17219a = new C5040g();
    /* renamed from: b */
    private boolean f17220b;
    /* renamed from: c */
    private int[] f17221c;
    /* renamed from: d */
    private C5040g[] f17222d;
    /* renamed from: e */
    private int f17223e;

    C5039f() {
        this(10);
    }

    private C5039f(int i) {
        this.f17220b = false;
        i = C5039f.m21357c(i);
        this.f17221c = new int[i];
        this.f17222d = new C5040g[i];
        this.f17223e = 0;
    }

    /* renamed from: c */
    private static int m21357c(int i) {
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
    private final int m21358d(int i) {
        int i2 = this.f17223e - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.f17221c[i4];
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

    /* renamed from: a */
    final int m21359a() {
        return this.f17223e;
    }

    /* renamed from: a */
    final C5040g m21360a(int i) {
        i = m21358d(i);
        if (i >= 0) {
            if (this.f17222d[i] != f17219a) {
                return this.f17222d[i];
            }
        }
        return null;
    }

    /* renamed from: a */
    final void m21361a(int i, C5040g c5040g) {
        int d = m21358d(i);
        if (d >= 0) {
            this.f17222d[d] = c5040g;
            return;
        }
        d = ~d;
        if (d >= this.f17223e || this.f17222d[d] != f17219a) {
            if (this.f17223e >= this.f17221c.length) {
                int c = C5039f.m21357c(this.f17223e + 1);
                Object obj = new int[c];
                Object obj2 = new C5040g[c];
                System.arraycopy(this.f17221c, 0, obj, 0, this.f17221c.length);
                System.arraycopy(this.f17222d, 0, obj2, 0, this.f17222d.length);
                this.f17221c = obj;
                this.f17222d = obj2;
            }
            if (this.f17223e - d != 0) {
                int i2 = d + 1;
                System.arraycopy(this.f17221c, d, this.f17221c, i2, this.f17223e - d);
                System.arraycopy(this.f17222d, d, this.f17222d, i2, this.f17223e - d);
            }
            this.f17221c[d] = i;
            this.f17222d[d] = c5040g;
            this.f17223e++;
            return;
        }
        this.f17221c[d] = i;
        this.f17222d[d] = c5040g;
    }

    /* renamed from: b */
    final C5040g m21362b(int i) {
        return this.f17222d[i];
    }

    /* renamed from: b */
    public final boolean m21363b() {
        return this.f17223e == 0;
    }

    public final /* synthetic */ Object clone() {
        int i = this.f17223e;
        C5039f c5039f = new C5039f(i);
        int i2 = 0;
        System.arraycopy(this.f17221c, 0, c5039f.f17221c, 0, i);
        while (i2 < i) {
            if (this.f17222d[i2] != null) {
                c5039f.f17222d[i2] = (C5040g) this.f17222d[i2].clone();
            }
            i2++;
        }
        c5039f.f17223e = i;
        return c5039f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5039f)) {
            return false;
        }
        C5039f c5039f = (C5039f) obj;
        if (this.f17223e != c5039f.f17223e) {
            return false;
        }
        Object obj2;
        int[] iArr = this.f17221c;
        int[] iArr2 = c5039f.f17221c;
        int i = this.f17223e;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                obj2 = null;
                break;
            }
        }
        obj2 = 1;
        if (obj2 != null) {
            C5040g[] c5040gArr = this.f17222d;
            C5040g[] c5040gArr2 = c5039f.f17222d;
            int i3 = this.f17223e;
            for (i = 0; i < i3; i++) {
                if (!c5040gArr[i].equals(c5040gArr2[i])) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f17223e; i2++) {
            i = (((i * 31) + this.f17221c[i2]) * 31) + this.f17222d[i2].hashCode();
        }
        return i;
    }
}
