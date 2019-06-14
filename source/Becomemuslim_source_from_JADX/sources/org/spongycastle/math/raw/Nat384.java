package org.spongycastle.math.raw;

public abstract class Nat384 {
    /* renamed from: a */
    public static void m28981a(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat192.m28909c(iArr, iArr2, iArr3);
        Nat192.m28897b(iArr, 6, iArr2, 6, iArr3, 12);
        int a = Nat192.m28885a(iArr3, 6, iArr3, 12);
        a += Nat192.m28886a(iArr3, 18, iArr3, 12, Nat192.m28886a(iArr3, 0, iArr3, 6, 0) + a);
        int[] a2 = Nat192.m28894a();
        int[] a3 = Nat192.m28894a();
        iArr = Nat192.m28890a(iArr, 6, iArr, 0, a2, 0) != Nat192.m28890a(iArr2, 6, iArr2, 0, a3, 0) ? 1 : null;
        iArr2 = Nat192.m28910c();
        Nat192.m28909c(a2, a3, iArr2);
        Nat.m28999a(24, a + (iArr != null ? Nat.m29008a(12, iArr2, 0, iArr3, 6) : Nat.m29022b(12, iArr2, 0, iArr3, 6)), iArr3, 18);
    }

    /* renamed from: a */
    public static void m28980a(int[] iArr, int[] iArr2) {
        Nat192.m28908c(iArr, iArr2);
        Nat192.m28907c(iArr, 6, iArr2, 12);
        int a = Nat192.m28885a(iArr2, 6, iArr2, 12);
        a += Nat192.m28886a(iArr2, 18, iArr2, 12, Nat192.m28886a(iArr2, 0, iArr2, 6, 0) + a);
        int[] a2 = Nat192.m28894a();
        Nat192.m28890a(iArr, 6, iArr, 0, a2, 0);
        iArr = Nat192.m28910c();
        Nat192.m28908c(a2, iArr);
        Nat.m28999a(24, a + Nat.m29022b(12, iArr, 0, iArr2, 6), iArr2, 18);
    }
}
