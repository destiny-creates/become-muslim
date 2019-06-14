package com.google.android.gms.internal.ads;

public final class afk implements Cloneable {
    /* renamed from: a */
    private static final afl f14420a = new afl();
    /* renamed from: b */
    private boolean f14421b;
    /* renamed from: c */
    private int[] f14422c;
    /* renamed from: d */
    private afl[] f14423d;
    /* renamed from: e */
    private int f14424e;

    afk() {
        this(10);
    }

    private afk(int i) {
        this.f14421b = false;
        i = m18371c(i);
        this.f14422c = new int[i];
        this.f14423d = new afl[i];
        this.f14424e = 0;
    }

    /* renamed from: c */
    private static int m18371c(int i) {
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
    private final int m18372d(int i) {
        int i2 = this.f14424e - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.f14422c[i4];
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
    final int m18373a() {
        return this.f14424e;
    }

    /* renamed from: a */
    final afl m18374a(int i) {
        i = m18372d(i);
        if (i >= 0) {
            if (this.f14423d[i] != f14420a) {
                return this.f14423d[i];
            }
        }
        return null;
    }

    /* renamed from: a */
    final void m18375a(int i, afl afl) {
        int d = m18372d(i);
        if (d >= 0) {
            this.f14423d[d] = afl;
            return;
        }
        d = ~d;
        if (d >= this.f14424e || this.f14423d[d] != f14420a) {
            if (this.f14424e >= this.f14422c.length) {
                int c = m18371c(this.f14424e + 1);
                Object obj = new int[c];
                Object obj2 = new afl[c];
                System.arraycopy(this.f14422c, 0, obj, 0, this.f14422c.length);
                System.arraycopy(this.f14423d, 0, obj2, 0, this.f14423d.length);
                this.f14422c = obj;
                this.f14423d = obj2;
            }
            if (this.f14424e - d != 0) {
                int i2 = d + 1;
                System.arraycopy(this.f14422c, d, this.f14422c, i2, this.f14424e - d);
                System.arraycopy(this.f14423d, d, this.f14423d, i2, this.f14424e - d);
            }
            this.f14422c[d] = i;
            this.f14423d[d] = afl;
            this.f14424e++;
            return;
        }
        this.f14422c[d] = i;
        this.f14423d[d] = afl;
    }

    /* renamed from: b */
    final afl m18376b(int i) {
        return this.f14423d[i];
    }

    public final /* synthetic */ Object clone() {
        int i = this.f14424e;
        afk afk = new afk(i);
        int i2 = 0;
        System.arraycopy(this.f14422c, 0, afk.f14422c, 0, i);
        while (i2 < i) {
            if (this.f14423d[i2] != null) {
                afk.f14423d[i2] = (afl) this.f14423d[i2].clone();
            }
            i2++;
        }
        afk.f14424e = i;
        return afk;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof afk)) {
            return false;
        }
        afk afk = (afk) obj;
        if (this.f14424e != afk.f14424e) {
            return false;
        }
        Object obj2;
        int[] iArr = this.f14422c;
        int[] iArr2 = afk.f14422c;
        int i = this.f14424e;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                obj2 = null;
                break;
            }
        }
        obj2 = 1;
        if (obj2 != null) {
            afl[] aflArr = this.f14423d;
            afl[] aflArr2 = afk.f14423d;
            int i3 = this.f14424e;
            for (i = 0; i < i3; i++) {
                if (!aflArr[i].equals(aflArr2[i])) {
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
        for (int i2 = 0; i2 < this.f14424e; i2++) {
            i = (((i * 31) + this.f14422c[i2]) * 31) + this.f14423d[i2].hashCode();
        }
        return i;
    }
}
