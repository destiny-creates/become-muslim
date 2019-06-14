package com.google.p217b.p235f.p236a.p237a;

/* compiled from: ModulusPoly */
/* renamed from: com.google.b.f.a.a.c */
final class C5257c {
    /* renamed from: a */
    private final C5256b f17740a;
    /* renamed from: b */
    private final int[] f17741b;

    C5257c(C5256b c5256b, int[] iArr) {
        if (iArr.length != 0) {
            this.f17740a = c5256b;
            c5256b = iArr.length;
            if (c5256b <= 1 || iArr[0] != 0) {
                this.f17741b = iArr;
                return;
            }
            int i = 1;
            while (i < c5256b && iArr[i] == 0) {
                i++;
            }
            if (i == c5256b) {
                this.f17741b = new int[]{null};
                return;
            }
            this.f17741b = new int[(c5256b - i)];
            System.arraycopy(iArr, i, this.f17741b, 0, this.f17741b.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    int m22258a() {
        return this.f17741b.length - 1;
    }

    /* renamed from: b */
    boolean m22264b() {
        return this.f17741b[0] == 0;
    }

    /* renamed from: a */
    int m22259a(int i) {
        return this.f17741b[(this.f17741b.length - 1) - i];
    }

    /* renamed from: b */
    int m22262b(int i) {
        int i2 = 0;
        if (i == 0) {
            return m22259a(0);
        }
        int i3 = 1;
        int i4;
        if (i == 1) {
            i = this.f17741b;
            i3 = i.length;
            i4 = 0;
            while (i2 < i3) {
                i4 = this.f17740a.m22252b(i4, i[i2]);
                i2++;
            }
            return i4;
        }
        i2 = this.f17741b[0];
        i4 = this.f17741b.length;
        while (i3 < i4) {
            i2 = this.f17740a.m22252b(this.f17740a.m22257d(i, i2), this.f17741b[i3]);
            i3++;
        }
        return i2;
    }

    /* renamed from: a */
    C5257c m22261a(C5257c c5257c) {
        if (!this.f17740a.equals(c5257c.f17740a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (m22264b()) {
            return c5257c;
        } else {
            if (c5257c.m22264b()) {
                return this;
            }
            int[] iArr = this.f17741b;
            c5257c = c5257c.f17741b;
            if (iArr.length > c5257c.length) {
                int[] iArr2 = iArr;
                iArr = c5257c;
                c5257c = iArr2;
            }
            Object obj = new int[c5257c.length];
            int length = c5257c.length - iArr.length;
            System.arraycopy(c5257c, 0, obj, 0, length);
            for (int i = length; i < c5257c.length; i++) {
                obj[i] = this.f17740a.m22252b(iArr[i - length], c5257c[i]);
            }
            return new C5257c(this.f17740a, obj);
        }
    }

    /* renamed from: b */
    C5257c m22263b(C5257c c5257c) {
        if (!this.f17740a.equals(c5257c.f17740a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (c5257c.m22264b()) {
            return this;
        } else {
            return m22261a(c5257c.m22265c());
        }
    }

    /* renamed from: c */
    C5257c m22267c(C5257c c5257c) {
        if (this.f17740a.equals(c5257c.f17740a)) {
            if (!m22264b()) {
                if (!c5257c.m22264b()) {
                    int[] iArr = this.f17741b;
                    int length = iArr.length;
                    c5257c = c5257c.f17741b;
                    int length2 = c5257c.length;
                    int[] iArr2 = new int[((length + length2) - 1)];
                    for (int i = 0; i < length; i++) {
                        int i2 = iArr[i];
                        for (int i3 = 0; i3 < length2; i3++) {
                            int i4 = i + i3;
                            iArr2[i4] = this.f17740a.m22252b(iArr2[i4], this.f17740a.m22257d(i2, c5257c[i3]));
                        }
                    }
                    return new C5257c(this.f17740a, iArr2);
                }
            }
            return this.f17740a.m22249a();
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    /* renamed from: c */
    C5257c m22265c() {
        int length = this.f17741b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f17740a.m22256c(0, this.f17741b[i]);
        }
        return new C5257c(this.f17740a, iArr);
    }

    /* renamed from: c */
    C5257c m22266c(int i) {
        if (i == 0) {
            return this.f17740a.m22249a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f17741b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f17740a.m22257d(this.f17741b[i2], i);
        }
        return new C5257c(this.f17740a, iArr);
    }

    /* renamed from: a */
    C5257c m22260a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f17740a.m22249a();
        } else {
            int length = this.f17741b.length;
            i = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                i[i3] = this.f17740a.m22257d(this.f17741b[i3], i2);
            }
            return new C5257c(this.f17740a, i);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(m22258a() * 8);
        for (int a = m22258a(); a >= 0; a--) {
            int a2 = m22259a(a);
            if (a2 != 0) {
                if (a2 < 0) {
                    stringBuilder.append(" - ");
                    a2 = -a2;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (a == 0 || a2 != 1) {
                    stringBuilder.append(a2);
                }
                if (a != 0) {
                    if (a == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(a);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
