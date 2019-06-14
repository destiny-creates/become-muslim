package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;

public class SecP224K1Field {
    /* renamed from: a */
    static final int[] f23138a = new int[]{-6803, -2, -1, -1, -1, -1, -1};
    /* renamed from: b */
    static final int[] f23139b = new int[]{46280809, 13606, 1, 0, 0, 0, 0, -13606, -3, -1, -1, -1, -1, -1};
    /* renamed from: c */
    private static final int[] f23140c = new int[]{-46280809, -13607, -2, -1, -1, -1, -1, 13605, 2};

    /* renamed from: a */
    public static void m28587a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat224.m28919a(iArr, iArr2, iArr3) != null || (iArr3[6] == -1 && Nat224.m28931c(iArr3, f23138a) != null)) {
            Nat.m28998a((int) 7, 6803, iArr3);
        }
    }

    /* renamed from: a */
    public static void m28586a(int[] iArr, int[] iArr2) {
        if (Nat.m29034d(7, iArr, iArr2) != null || (iArr2[6] == -1 && Nat224.m28931c(iArr2, f23138a) != null)) {
            Nat.m28998a(7, 6803, iArr2);
        }
    }

    /* renamed from: a */
    public static int[] m28588a(BigInteger bigInteger) {
        int[] a = Nat224.m28924a(bigInteger);
        if (a[6] == -1 && Nat224.m28931c(a, f23138a)) {
            Nat.m28998a(7, 6803, a);
        }
        return a;
    }

    /* renamed from: b */
    public static void m28590b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] b = Nat224.m28928b();
        Nat224.m28930c(iArr, iArr2, b);
        m28591c(b, iArr3);
    }

    /* renamed from: c */
    public static void m28592c(int[] iArr, int[] iArr2, int[] iArr3) {
        if ((Nat224.m28932d(iArr, iArr2, iArr3) != null || (iArr3[13] == -1 && Nat.m29031c(14, iArr3, f23139b) != null)) && Nat.m29009a(f23140c.length, f23140c, iArr3) != null) {
            Nat.m29020b(14, iArr3, f23140c.length);
        }
    }

    /* renamed from: b */
    public static void m28589b(int[] iArr, int[] iArr2) {
        if (Nat224.m28926b(iArr)) {
            Nat224.m28933d(iArr2);
        } else {
            Nat224.m28936e(f23138a, iArr, iArr2);
        }
    }

    /* renamed from: c */
    public static void m28591c(int[] iArr, int[] iArr2) {
        if (Nat224.m28917a(6803, Nat224.m28920a(6803, iArr, 7, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[6] == -1 && Nat224.m28931c(iArr2, f23138a))) {
            Nat.m28998a(7, 6803, iArr2);
        }
    }

    /* renamed from: a */
    public static void m28584a(int i, int[] iArr) {
        if ((i != 0 && Nat224.m28916a(6803, i, iArr, 0) != 0) || (iArr[6] == -1 && Nat224.m28931c(iArr, f23138a) != 0)) {
            Nat.m28998a(7, 6803, iArr);
        }
    }

    /* renamed from: d */
    public static void m28593d(int[] iArr, int[] iArr2) {
        int[] b = Nat224.m28928b();
        Nat224.m28934d(iArr, b);
        m28591c(b, iArr2);
    }

    /* renamed from: a */
    public static void m28585a(int[] iArr, int i, int[] iArr2) {
        int[] b = Nat224.m28928b();
        Nat224.m28934d(iArr, b);
        m28591c(b, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat224.m28934d(iArr2, b);
                m28591c(b, iArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m28594d(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat224.m28936e(iArr, iArr2, iArr3) != null) {
            Nat.m29026c((int) 7, 6803, iArr3);
        }
    }

    /* renamed from: e */
    public static void m28595e(int[] iArr, int[] iArr2) {
        if (Nat.m29007a(7, iArr, 0, iArr2) != null || (iArr2[6] == -1 && Nat224.m28931c(iArr2, f23138a) != null)) {
            Nat.m28998a(7, 6803, iArr2);
        }
    }
}
