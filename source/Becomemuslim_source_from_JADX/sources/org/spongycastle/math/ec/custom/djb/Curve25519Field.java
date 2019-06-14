package org.spongycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

public class Curve25519Field {
    /* renamed from: a */
    static final int[] f23121a = new int[]{-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
    /* renamed from: b */
    private static final int[] f23122b = new int[]{361, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, 1073741823};

    /* renamed from: a */
    public static void m28509a(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat256.m28944a(iArr, iArr2, iArr3);
        if (Nat256.m28965c(iArr3, f23121a) != null) {
            m28511b(iArr3);
        }
    }

    /* renamed from: a */
    public static void m28508a(int[] iArr, int[] iArr2) {
        Nat.m29034d(8, iArr, iArr2);
        if (Nat256.m28965c(iArr2, f23121a) != null) {
            m28511b(iArr2);
        }
    }

    /* renamed from: a */
    public static int[] m28510a(BigInteger bigInteger) {
        bigInteger = Nat256.m28951a(bigInteger);
        while (Nat256.m28965c(bigInteger, f23121a)) {
            Nat256.m28971e(f23121a, bigInteger);
        }
        return bigInteger;
    }

    /* renamed from: b */
    public static void m28513b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] c = Nat256.m28966c();
        Nat256.m28964c(iArr, iArr2, c);
        m28515c(c, iArr3);
    }

    /* renamed from: c */
    public static void m28516c(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat256.m28967d(iArr, iArr2, iArr3);
        if (Nat.m29031c((int) 16, iArr3, f23122b) != null) {
            m28514c(iArr3);
        }
    }

    /* renamed from: b */
    public static void m28512b(int[] iArr, int[] iArr2) {
        if (Nat256.m28954b(iArr)) {
            Nat256.m28968d(iArr2);
        } else {
            Nat256.m28972e(f23121a, iArr, iArr2);
        }
    }

    /* renamed from: c */
    public static void m28515c(int[] iArr, int[] iArr2) {
        int i = iArr[7];
        Nat.m29006a(8, iArr, 8, i, iArr2, 0);
        iArr = Nat256.m28939a(19, iArr, iArr2) << 1;
        int i2 = iArr2[7];
        iArr2[7] = (i2 & Integer.MAX_VALUE) + Nat.m29018b(7, (iArr + ((i2 >>> 31) - (i >>> 31))) * 19, iArr2);
        if (Nat256.m28965c(iArr2, f23121a) != null) {
            m28511b(iArr2);
        }
    }

    /* renamed from: a */
    public static void m28506a(int i, int[] iArr) {
        int i2 = iArr[7];
        iArr[7] = (i2 & Integer.MAX_VALUE) + Nat.m29018b(7, ((i << 1) | (i2 >>> 31)) * 19, iArr);
        if (Nat256.m28965c(iArr, f23121a) != 0) {
            m28511b(iArr);
        }
    }

    /* renamed from: d */
    public static void m28517d(int[] iArr, int[] iArr2) {
        int[] c = Nat256.m28966c();
        Nat256.m28969d(iArr, c);
        m28515c(c, iArr2);
    }

    /* renamed from: a */
    public static void m28507a(int[] iArr, int i, int[] iArr2) {
        int[] c = Nat256.m28966c();
        Nat256.m28969d(iArr, c);
        m28515c(c, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat256.m28969d(iArr2, c);
                m28515c(c, iArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m28518d(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.m28972e(iArr, iArr2, iArr3) != null) {
            m28505a(iArr3);
        }
    }

    /* renamed from: e */
    public static void m28519e(int[] iArr, int[] iArr2) {
        Nat.m29007a(8, iArr, 0, iArr2);
        if (Nat256.m28965c(iArr2, f23121a) != null) {
            m28511b(iArr2);
        }
    }

    /* renamed from: a */
    private static int m28505a(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) - 19;
        iArr[0] = (int) j;
        j >>= 32;
        if (j != 0) {
            j = (long) Nat.m29002a(7, iArr, 1);
        }
        j += (4294967295L & ((long) iArr[7])) + 2147483648L;
        iArr[7] = (int) j;
        return (int) (j >> 32);
    }

    /* renamed from: b */
    private static int m28511b(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) + 19;
        iArr[0] = (int) j;
        j >>= 32;
        if (j != 0) {
            j = (long) Nat.m29020b(7, iArr, 1);
        }
        j += (4294967295L & ((long) iArr[7])) - 2147483648L;
        iArr[7] = (int) j;
        return (int) (j >> 32);
    }

    /* renamed from: c */
    private static int m28514c(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) - (((long) f23122b[0]) & 4294967295L);
        iArr[0] = (int) j;
        j >>= 32;
        if (j != 0) {
            j = (long) Nat.m29002a(8, iArr, 1);
        }
        j += (((long) iArr[8]) & 4294967295L) + 19;
        iArr[8] = (int) j;
        j >>= 32;
        if (j != 0) {
            j = (long) Nat.m29020b(15, iArr, 9);
        }
        j += (((long) iArr[15]) & 4294967295L) - (4294967295L & ((long) (f23122b[15] + 1)));
        iArr[15] = (int) j;
        return (int) (j >> 32);
    }
}
