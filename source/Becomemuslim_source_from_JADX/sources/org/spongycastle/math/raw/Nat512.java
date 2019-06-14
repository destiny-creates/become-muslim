package org.spongycastle.math.raw;

public abstract class Nat512 {
    /* renamed from: a */
    public static void m28990a(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat256.m28964c(iArr, iArr2, iArr3);
        Nat256.m28953b(iArr, 8, iArr2, 8, iArr3, 16);
        int a = Nat256.m28941a(iArr3, 8, iArr3, 16);
        a += Nat256.m28942a(iArr3, 24, iArr3, 16, Nat256.m28942a(iArr3, 0, iArr3, 8, 0) + a);
        int[] a2 = Nat256.m28950a();
        int[] a3 = Nat256.m28950a();
        iArr = Nat256.m28947a(iArr, 8, iArr, 0, a2, 0) != Nat256.m28947a(iArr2, 8, iArr2, 0, a3, 0) ? 1 : null;
        iArr2 = Nat256.m28966c();
        Nat256.m28964c(a2, a3, iArr2);
        Nat.m28999a(32, a + (iArr != null ? Nat.m29008a(16, iArr2, 0, iArr3, 8) : Nat.m29022b(16, iArr2, 0, iArr3, 8)), iArr3, 24);
    }

    /* renamed from: a */
    public static void m28989a(int[] iArr, int[] iArr2) {
        Nat256.m28969d(iArr, iArr2);
        Nat256.m28963c(iArr, 8, iArr2, 16);
        int a = Nat256.m28941a(iArr2, 8, iArr2, 16);
        a += Nat256.m28942a(iArr2, 24, iArr2, 16, Nat256.m28942a(iArr2, 0, iArr2, 8, 0) + a);
        int[] a2 = Nat256.m28950a();
        Nat256.m28947a(iArr, 8, iArr, 0, a2, 0);
        iArr = Nat256.m28966c();
        Nat256.m28969d(a2, iArr);
        Nat.m28999a(32, a + Nat.m29022b(16, iArr, 0, iArr2, 8), iArr2, 24);
    }
}
