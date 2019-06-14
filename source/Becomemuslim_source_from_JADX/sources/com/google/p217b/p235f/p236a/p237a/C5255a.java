package com.google.p217b.p235f.p236a.p237a;

import com.google.p217b.C6866d;

/* compiled from: ErrorCorrection */
/* renamed from: com.google.b.f.a.a.a */
public final class C5255a {
    /* renamed from: a */
    private final C5256b f17733a = C5256b.f17734a;

    /* renamed from: a */
    public int m22247a(int[] iArr, int i, int[] iArr2) {
        C5257c c5257c = new C5257c(this.f17733a, iArr);
        int[] iArr3 = new int[i];
        int i2 = 0;
        Object obj = null;
        for (int i3 = i; i3 > 0; i3--) {
            int b = c5257c.m22262b(this.f17733a.m22248a(i3));
            iArr3[i - i3] = b;
            if (b != 0) {
                obj = 1;
            }
        }
        if (obj == null) {
            return 0;
        }
        c5257c = this.f17733a.m22253b();
        if (iArr2 != null) {
            C5257c c5257c2 = c5257c;
            for (int b2 : iArr2) {
                b2 = this.f17733a.m22248a((iArr.length - 1) - b2);
                c5257c2 = c5257c2.m22267c(new C5257c(this.f17733a, new int[]{this.f17733a.m22256c(0, b2), 1}));
            }
        }
        i = m22246a(this.f17733a.m22250a(i, 1), new C5257c(this.f17733a, iArr3), i);
        C5257c c5257c3 = i[0];
        C5257c c5257c4 = i[1];
        int[] a = m22244a(c5257c3);
        i = m22245a(c5257c4, c5257c3, a);
        while (i2 < a.length) {
            iArr2 = (iArr.length - 1) - this.f17733a.m22251b(a[i2]);
            if (iArr2 >= null) {
                iArr[iArr2] = this.f17733a.m22256c(iArr[iArr2], i[i2]);
                i2++;
            } else {
                throw C6866d.m32277a();
            }
        }
        return a.length;
    }

    /* renamed from: a */
    private C5257c[] m22246a(C5257c c5257c, C5257c c5257c2, int i) {
        C5257c c5257c3;
        if (c5257c.m22258a() < c5257c2.m22258a()) {
            c5257c3 = c5257c2;
            c5257c2 = c5257c;
            c5257c = c5257c3;
        }
        C5257c a = this.f17733a.m22249a();
        C5257c b = this.f17733a.m22253b();
        c5257c3 = c5257c2;
        c5257c2 = c5257c;
        c5257c = c5257c3;
        while (c5257c.m22258a() >= i / 2) {
            if (c5257c.m22264b()) {
                throw C6866d.m32277a();
            }
            C5257c a2 = this.f17733a.m22249a();
            int c = this.f17733a.m22255c(c5257c.m22259a(c5257c.m22258a()));
            while (c5257c2.m22258a() >= c5257c.m22258a() && !c5257c2.m22264b()) {
                int a3 = c5257c2.m22258a() - c5257c.m22258a();
                int d = this.f17733a.m22257d(c5257c2.m22259a(c5257c2.m22258a()), c);
                a2 = a2.m22261a(this.f17733a.m22250a(a3, d));
                c5257c2 = c5257c2.m22263b(c5257c.m22260a(a3, d));
            }
            c5257c3 = c5257c2;
            c5257c2 = c5257c;
            c5257c = c5257c3;
            C5257c c5257c4 = b;
            b = a2.m22267c(b).m22263b(a).m22265c();
            a = c5257c4;
        }
        i = b.m22259a(0);
        if (i != 0) {
            i = this.f17733a.m22255c(i);
            a = b.m22266c(i);
            c5257c = c5257c.m22266c(i);
            return new C5257c[]{a, c5257c};
        }
        throw C6866d.m32277a();
    }

    /* renamed from: a */
    private int[] m22244a(C5257c c5257c) {
        int a = c5257c.m22258a();
        int[] iArr = new int[a];
        int i = 0;
        for (int i2 = 1; i2 < this.f17733a.m22254c() && i < a; i2++) {
            if (c5257c.m22262b(i2) == 0) {
                iArr[i] = this.f17733a.m22255c(i2);
                i++;
            }
        }
        if (i == a) {
            return iArr;
        }
        throw C6866d.m32277a();
    }

    /* renamed from: a */
    private int[] m22245a(C5257c c5257c, C5257c c5257c2, int[] iArr) {
        int a = c5257c2.m22258a();
        int[] iArr2 = new int[a];
        for (int i = 1; i <= a; i++) {
            iArr2[a - i] = this.f17733a.m22257d(i, c5257c2.m22259a(i));
        }
        c5257c2 = new C5257c(this.f17733a, iArr2);
        a = iArr.length;
        iArr2 = new int[a];
        for (int i2 = 0; i2 < a; i2++) {
            int c = this.f17733a.m22255c(iArr[i2]);
            iArr2[i2] = this.f17733a.m22257d(this.f17733a.m22256c(0, c5257c.m22262b(c)), this.f17733a.m22255c(c5257c2.m22262b(c)));
        }
        return iArr2;
    }
}
