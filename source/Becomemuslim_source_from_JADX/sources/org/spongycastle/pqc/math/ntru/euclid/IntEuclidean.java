package org.spongycastle.pqc.math.ntru.euclid;

public class IntEuclidean {
    /* renamed from: a */
    public int f23402a;
    /* renamed from: b */
    public int f23403b;
    /* renamed from: c */
    public int f23404c;

    private IntEuclidean() {
    }

    /* renamed from: a */
    public static IntEuclidean m29296a(int i, int i2) {
        int i3 = 0;
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        int i7 = i2;
        i2 = i;
        i = i7;
        while (i != 0) {
            int i8 = i2 / i;
            i7 = i2 % i;
            i2 = i;
            i = i7;
            int i9 = i4 - (i8 * i3);
            i4 = i3;
            i3 = i9;
            int i10 = i6 - (i8 * i5);
            i6 = i5;
            i5 = i10;
        }
        i = new IntEuclidean();
        i.f23402a = i4;
        i.f23403b = i6;
        i.f23404c = i2;
        return i;
    }
}
