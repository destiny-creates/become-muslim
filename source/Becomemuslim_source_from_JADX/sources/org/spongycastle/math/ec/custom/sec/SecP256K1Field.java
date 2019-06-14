package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

public class SecP256K1Field {
    /* renamed from: a */
    static final int[] f23144a = new int[]{-977, -2, -1, -1, -1, -1, -1, -1};
    /* renamed from: b */
    static final int[] f23145b = new int[]{954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};
    /* renamed from: c */
    private static final int[] f23146c = new int[]{-954529, -1955, -2, -1, -1, -1, -1, -1, 1953, 2};

    /* renamed from: a */
    public static void m28613a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.m28944a(iArr, iArr2, iArr3) != null || (iArr3[7] == -1 && Nat256.m28965c(iArr3, f23144a) != null)) {
            Nat.m28998a((int) 8, 977, iArr3);
        }
    }

    /* renamed from: a */
    public static void m28612a(int[] iArr, int[] iArr2) {
        if (Nat.m29034d(8, iArr, iArr2) != null || (iArr2[7] == -1 && Nat256.m28965c(iArr2, f23144a) != null)) {
            Nat.m28998a(8, 977, iArr2);
        }
    }

    /* renamed from: a */
    public static int[] m28614a(BigInteger bigInteger) {
        bigInteger = Nat256.m28951a(bigInteger);
        if (bigInteger[7] == -1 && Nat256.m28965c(bigInteger, f23144a)) {
            Nat256.m28971e(f23144a, bigInteger);
        }
        return bigInteger;
    }

    /* renamed from: b */
    public static void m28616b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] c = Nat256.m28966c();
        Nat256.m28964c(iArr, iArr2, c);
        m28617c(c, iArr3);
    }

    /* renamed from: c */
    public static void m28618c(int[] iArr, int[] iArr2, int[] iArr3) {
        if ((Nat256.m28967d(iArr, iArr2, iArr3) != null || (iArr3[15] == -1 && Nat.m29031c(16, iArr3, f23145b) != null)) && Nat.m29009a(f23146c.length, f23146c, iArr3) != null) {
            Nat.m29020b(16, iArr3, f23146c.length);
        }
    }

    /* renamed from: b */
    public static void m28615b(int[] iArr, int[] iArr2) {
        if (Nat256.m28954b(iArr)) {
            Nat256.m28968d(iArr2);
        } else {
            Nat256.m28972e(f23144a, iArr, iArr2);
        }
    }

    /* renamed from: c */
    public static void m28617c(int[] iArr, int[] iArr2) {
        if (Nat256.m28938a(977, Nat256.m28945a(977, iArr, 8, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[7] == -1 && Nat256.m28965c(iArr2, f23144a))) {
            Nat.m28998a(8, 977, iArr2);
        }
    }

    /* renamed from: a */
    public static void m28610a(int i, int[] iArr) {
        if ((i != 0 && Nat256.m28937a(977, i, iArr, 0) != 0) || (iArr[7] == -1 && Nat256.m28965c(iArr, f23144a) != 0)) {
            Nat.m28998a(8, 977, iArr);
        }
    }

    /* renamed from: d */
    public static void m28619d(int[] iArr, int[] iArr2) {
        int[] c = Nat256.m28966c();
        Nat256.m28969d(iArr, c);
        m28617c(c, iArr2);
    }

    /* renamed from: a */
    public static void m28611a(int[] iArr, int i, int[] iArr2) {
        int[] c = Nat256.m28966c();
        Nat256.m28969d(iArr, c);
        m28617c(c, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat256.m28969d(iArr2, c);
                m28617c(c, iArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m28620d(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.m28972e(iArr, iArr2, iArr3) != null) {
            Nat.m29026c((int) 8, 977, iArr3);
        }
    }

    /* renamed from: e */
    public static void m28621e(int[] iArr, int[] iArr2) {
        if (Nat.m29007a(8, iArr, 0, iArr2) != null || (iArr2[7] == -1 && Nat256.m28965c(iArr2, f23144a) != null)) {
            Nat.m28998a(8, 977, iArr2);
        }
    }
}
