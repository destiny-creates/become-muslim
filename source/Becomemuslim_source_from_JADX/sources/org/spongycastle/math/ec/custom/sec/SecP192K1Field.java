package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;

public class SecP192K1Field {
    /* renamed from: a */
    static final int[] f23132a = new int[]{-4553, -2, -1, -1, -1, -1};
    /* renamed from: b */
    static final int[] f23133b = new int[]{20729809, 9106, 1, 0, 0, 0, -9106, -3, -1, -1, -1, -1};
    /* renamed from: c */
    private static final int[] f23134c = new int[]{-20729809, -9107, -2, -1, -1, -1, 9105, 2};

    /* renamed from: a */
    public static void m28561a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat192.m28887a(iArr, iArr2, iArr3) != null || (iArr3[5] == -1 && Nat192.m28900b(iArr3, f23132a) != null)) {
            Nat.m28998a((int) 6, 4553, iArr3);
        }
    }

    /* renamed from: a */
    public static void m28560a(int[] iArr, int[] iArr2) {
        if (Nat.m29034d(6, iArr, iArr2) != null || (iArr2[5] == -1 && Nat192.m28900b(iArr2, f23132a) != null)) {
            Nat.m28998a(6, 4553, iArr2);
        }
    }

    /* renamed from: a */
    public static int[] m28562a(BigInteger bigInteger) {
        bigInteger = Nat192.m28895a(bigInteger);
        if (bigInteger[5] == -1 && Nat192.m28900b(bigInteger, f23132a)) {
            Nat192.m28911d(f23132a, bigInteger);
        }
        return bigInteger;
    }

    /* renamed from: b */
    public static void m28564b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] c = Nat192.m28910c();
        Nat192.m28909c(iArr, iArr2, c);
        m28565c(c, iArr3);
    }

    /* renamed from: c */
    public static void m28566c(int[] iArr, int[] iArr2, int[] iArr3) {
        if ((Nat192.m28912d(iArr, iArr2, iArr3) != null || (iArr3[11] == -1 && Nat.m29031c(12, iArr3, f23133b) != null)) && Nat.m29009a(f23134c.length, f23134c, iArr3) != null) {
            Nat.m29020b(12, iArr3, f23134c.length);
        }
    }

    /* renamed from: b */
    public static void m28563b(int[] iArr, int[] iArr2) {
        if (Nat192.m28898b(iArr)) {
            Nat192.m28913d(iArr2);
        } else {
            Nat192.m28915e(f23132a, iArr, iArr2);
        }
    }

    /* renamed from: c */
    public static void m28565c(int[] iArr, int[] iArr2) {
        if (Nat192.m28883a(4553, Nat192.m28888a(4553, iArr, 6, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[5] == -1 && Nat192.m28900b(iArr2, f23132a))) {
            Nat.m28998a(6, 4553, iArr2);
        }
    }

    /* renamed from: a */
    public static void m28558a(int i, int[] iArr) {
        if ((i != 0 && Nat192.m28882a(4553, i, iArr, 0) != 0) || (iArr[5] == -1 && Nat192.m28900b(iArr, f23132a) != 0)) {
            Nat.m28998a(6, 4553, iArr);
        }
    }

    /* renamed from: d */
    public static void m28567d(int[] iArr, int[] iArr2) {
        int[] c = Nat192.m28910c();
        Nat192.m28908c(iArr, c);
        m28565c(c, iArr2);
    }

    /* renamed from: a */
    public static void m28559a(int[] iArr, int i, int[] iArr2) {
        int[] c = Nat192.m28910c();
        Nat192.m28908c(iArr, c);
        m28565c(c, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat192.m28908c(iArr2, c);
                m28565c(c, iArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m28568d(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat192.m28915e(iArr, iArr2, iArr3) != null) {
            Nat.m29026c((int) 6, 4553, iArr3);
        }
    }

    /* renamed from: e */
    public static void m28569e(int[] iArr, int[] iArr2) {
        if (Nat.m29007a(6, iArr, 0, iArr2) != null || (iArr2[5] == -1 && Nat192.m28900b(iArr2, f23132a) != null)) {
            Nat.m28998a(6, 4553, iArr2);
        }
    }
}
