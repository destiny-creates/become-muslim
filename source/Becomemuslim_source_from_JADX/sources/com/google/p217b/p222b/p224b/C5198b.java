package com.google.p217b.p222b.p224b;

/* compiled from: GenericGFPoly */
/* renamed from: com.google.b.b.b.b */
final class C5198b {
    /* renamed from: a */
    private final C5197a f17531a;
    /* renamed from: b */
    private final int[] f17532b;

    C5198b(C5197a c5197a, int[] iArr) {
        if (iArr.length != 0) {
            this.f17531a = c5197a;
            c5197a = iArr.length;
            if (c5197a <= 1 || iArr[0] != 0) {
                this.f17532b = iArr;
                return;
            }
            int i = 1;
            while (i < c5197a && iArr[i] == 0) {
                i++;
            }
            if (i == c5197a) {
                this.f17532b = new int[]{null};
                return;
            }
            this.f17532b = new int[(c5197a - i)];
            System.arraycopy(iArr, i, this.f17532b, 0, this.f17532b.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    int[] m21984a() {
        return this.f17532b;
    }

    /* renamed from: b */
    int m21985b() {
        return this.f17532b.length - 1;
    }

    /* renamed from: c */
    boolean m21989c() {
        return this.f17532b[0] == 0;
    }

    /* renamed from: a */
    int m21981a(int i) {
        return this.f17532b[(this.f17532b.length - 1) - i];
    }

    /* renamed from: b */
    int m21986b(int i) {
        int i2 = 0;
        if (i == 0) {
            return m21981a(0);
        }
        int i3 = 1;
        int i4;
        if (i == 1) {
            i = this.f17532b;
            i3 = i.length;
            i4 = 0;
            while (i2 < i3) {
                i4 = C5197a.m21971b(i4, i[i2]);
                i2++;
            }
            return i4;
        }
        i2 = this.f17532b[0];
        i4 = this.f17532b.length;
        while (i3 < i4) {
            i2 = C5197a.m21971b(this.f17531a.m21979c(i, i2), this.f17532b[i3]);
            i3++;
        }
        return i2;
    }

    /* renamed from: a */
    C5198b m21983a(C5198b c5198b) {
        if (!this.f17531a.equals(c5198b.f17531a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (m21989c()) {
            return c5198b;
        } else {
            if (c5198b.m21989c()) {
                return this;
            }
            int[] iArr = this.f17532b;
            c5198b = c5198b.f17532b;
            if (iArr.length > c5198b.length) {
                int[] iArr2 = iArr;
                iArr = c5198b;
                c5198b = iArr2;
            }
            Object obj = new int[c5198b.length];
            int length = c5198b.length - iArr.length;
            System.arraycopy(c5198b, 0, obj, 0, length);
            for (int i = length; i < c5198b.length; i++) {
                obj[i] = C5197a.m21971b(iArr[i - length], c5198b[i]);
            }
            return new C5198b(this.f17531a, obj);
        }
    }

    /* renamed from: b */
    C5198b m21987b(C5198b c5198b) {
        if (this.f17531a.equals(c5198b.f17531a)) {
            if (!m21989c()) {
                if (!c5198b.m21989c()) {
                    int[] iArr = this.f17532b;
                    int length = iArr.length;
                    c5198b = c5198b.f17532b;
                    int length2 = c5198b.length;
                    int[] iArr2 = new int[((length + length2) - 1)];
                    for (int i = 0; i < length; i++) {
                        int i2 = iArr[i];
                        for (int i3 = 0; i3 < length2; i3++) {
                            int i4 = i + i3;
                            iArr2[i4] = C5197a.m21971b(iArr2[i4], this.f17531a.m21979c(i2, c5198b[i3]));
                        }
                    }
                    return new C5198b(this.f17531a, iArr2);
                }
            }
            return this.f17531a.m21973a();
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* renamed from: c */
    C5198b m21988c(int i) {
        if (i == 0) {
            return this.f17531a.m21973a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f17532b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f17531a.m21979c(this.f17532b[i2], i);
        }
        return new C5198b(this.f17531a, iArr);
    }

    /* renamed from: a */
    C5198b m21982a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f17531a.m21973a();
        } else {
            int length = this.f17532b.length;
            i = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                i[i3] = this.f17531a.m21979c(this.f17532b[i3], i2);
            }
            return new C5198b(this.f17531a, i);
        }
    }

    /* renamed from: c */
    C5198b[] m21990c(C5198b c5198b) {
        if (!this.f17531a.equals(c5198b.f17531a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (c5198b.m21989c()) {
            throw new IllegalArgumentException("Divide by 0");
        } else {
            C5198b a = this.f17531a.m21973a();
            int c = this.f17531a.m21978c(c5198b.m21981a(c5198b.m21985b()));
            C5198b c5198b2 = a;
            a = this;
            while (a.m21985b() >= c5198b.m21985b() && !a.m21989c()) {
                int b = a.m21985b() - c5198b.m21985b();
                int c2 = this.f17531a.m21979c(a.m21981a(a.m21985b()), c);
                C5198b a2 = c5198b.m21982a(b, c2);
                c5198b2 = c5198b2.m21983a(this.f17531a.m21974a(b, c2));
                a = a.m21983a(a2);
            }
            return new C5198b[]{c5198b2, a};
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(m21985b() * 8);
        for (int b = m21985b(); b >= 0; b--) {
            int a = m21981a(b);
            if (a != 0) {
                if (a < 0) {
                    stringBuilder.append(" - ");
                    a = -a;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (b == 0 || a != 1) {
                    a = this.f17531a.m21975b(a);
                    if (a == 0) {
                        stringBuilder.append('1');
                    } else if (a == 1) {
                        stringBuilder.append('a');
                    } else {
                        stringBuilder.append("a^");
                        stringBuilder.append(a);
                    }
                }
                if (b != 0) {
                    if (b == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(b);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
