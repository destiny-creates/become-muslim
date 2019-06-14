package com.google.p217b.p222b.p224b;

/* compiled from: ReedSolomonDecoder */
/* renamed from: com.google.b.b.b.c */
public final class C5199c {
    /* renamed from: a */
    private final C5197a f17533a;

    public C5199c(C5197a c5197a) {
        this.f17533a = c5197a;
    }

    /* renamed from: a */
    public void m21994a(int[] iArr, int i) {
        C5198b c5198b = new C5198b(this.f17533a, iArr);
        int[] iArr2 = new int[i];
        int i2 = 0;
        Object obj = 1;
        for (int i3 = 0; i3 < i; i3++) {
            C5197a c5197a = this.f17533a;
            int b = c5198b.m21986b(c5197a.m21972a(c5197a.m21980d() + i3));
            iArr2[(i - 1) - i3] = b;
            if (b != 0) {
                obj = null;
            }
        }
        if (obj == null) {
            i = m21993a(this.f17533a.m21974a(i, 1), new C5198b(this.f17533a, iArr2), i);
            c5198b = i[0];
            C5198b c5198b2 = i[1];
            int[] a = m21991a(c5198b);
            i = m21992a(c5198b2, a);
            while (i2 < a.length) {
                int length = (iArr.length - 1) - this.f17533a.m21975b(a[i2]);
                if (length >= 0) {
                    iArr[length] = C5197a.m21971b(iArr[length], i[i2]);
                    i2++;
                } else {
                    throw new C5201e("Bad error location");
                }
            }
        }
    }

    /* renamed from: a */
    private C5198b[] m21993a(C5198b c5198b, C5198b c5198b2, int i) {
        C5198b c5198b3;
        if (c5198b.m21985b() < c5198b2.m21985b()) {
            c5198b3 = c5198b2;
            c5198b2 = c5198b;
            c5198b = c5198b3;
        }
        C5198b a = this.f17533a.m21973a();
        C5198b b = this.f17533a.m21976b();
        c5198b3 = c5198b2;
        c5198b2 = c5198b;
        c5198b = c5198b3;
        while (c5198b.m21985b() >= i / 2) {
            if (c5198b.m21989c()) {
                throw new C5201e("r_{i-1} was zero");
            }
            C5198b a2 = this.f17533a.m21973a();
            int c = this.f17533a.m21978c(c5198b.m21981a(c5198b.m21985b()));
            while (c5198b2.m21985b() >= c5198b.m21985b() && !c5198b2.m21989c()) {
                int b2 = c5198b2.m21985b() - c5198b.m21985b();
                int c2 = this.f17533a.m21979c(c5198b2.m21981a(c5198b2.m21985b()), c);
                a2 = a2.m21983a(this.f17533a.m21974a(b2, c2));
                c5198b2 = c5198b2.m21983a(c5198b.m21982a(b2, c2));
            }
            a = a2.m21987b(b).m21983a(a);
            if (c5198b2.m21985b() < c5198b.m21985b()) {
                c5198b3 = c5198b2;
                c5198b2 = c5198b;
                c5198b = c5198b3;
                C5198b c5198b4 = b;
                b = a;
                a = c5198b4;
            } else {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
        }
        i = b.m21981a(0);
        if (i != 0) {
            i = this.f17533a.m21978c(i);
            a = b.m21988c(i);
            c5198b = c5198b.m21988c(i);
            return new C5198b[]{a, c5198b};
        }
        throw new C5201e("sigmaTilde(0) was zero");
    }

    /* renamed from: a */
    private int[] m21991a(C5198b c5198b) {
        int b = c5198b.m21985b();
        int i = 0;
        int i2 = 1;
        if (b == 1) {
            return new int[]{c5198b.m21981a(1)};
        }
        int[] iArr = new int[b];
        while (i2 < this.f17533a.m21977c() && i < b) {
            if (c5198b.m21986b(i2) == 0) {
                iArr[i] = this.f17533a.m21978c(i2);
                i++;
            }
            i2++;
        }
        if (i == b) {
            return iArr;
        }
        throw new C5201e("Error locator degree does not match number of roots");
    }

    /* renamed from: a */
    private int[] m21992a(C5198b c5198b, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int c = this.f17533a.m21978c(iArr[i]);
            int i2 = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i != i3) {
                    int c2 = this.f17533a.m21979c(iArr[i3], c);
                    i2 = this.f17533a.m21979c(i2, (c2 & 1) == 0 ? c2 | 1 : c2 & -2);
                }
            }
            iArr2[i] = this.f17533a.m21979c(c5198b.m21986b(c), this.f17533a.m21978c(i2));
            if (this.f17533a.m21980d() != 0) {
                iArr2[i] = this.f17533a.m21979c(iArr2[i], c);
            }
        }
        return iArr2;
    }
}
