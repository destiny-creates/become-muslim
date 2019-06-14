package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;

public class SecP224R1Field {
    /* renamed from: a */
    static final int[] f23141a = new int[]{1, 0, 0, -1, -1, -1, -1};
    /* renamed from: b */
    static final int[] f23142b = new int[]{1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};
    /* renamed from: c */
    private static final int[] f23143c = new int[]{-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    /* renamed from: a */
    public static void m28600a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat224.m28919a(iArr, iArr2, iArr3) != null || (iArr3[6] == -1 && Nat224.m28931c(iArr3, f23141a) != null)) {
            m28597a(iArr3);
        }
    }

    /* renamed from: a */
    public static void m28599a(int[] iArr, int[] iArr2) {
        if (Nat.m29034d(7, iArr, iArr2) != null || (iArr2[6] == -1 && Nat224.m28931c(iArr2, f23141a) != null)) {
            m28597a(iArr2);
        }
    }

    /* renamed from: a */
    public static int[] m28601a(BigInteger bigInteger) {
        bigInteger = Nat224.m28924a(bigInteger);
        if (bigInteger[6] == -1 && Nat224.m28931c(bigInteger, f23141a)) {
            Nat224.m28935e(f23141a, bigInteger);
        }
        return bigInteger;
    }

    /* renamed from: b */
    public static void m28604b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] b = Nat224.m28928b();
        Nat224.m28930c(iArr, iArr2, b);
        m28605c(b, iArr3);
    }

    /* renamed from: c */
    public static void m28606c(int[] iArr, int[] iArr2, int[] iArr3) {
        if ((Nat224.m28932d(iArr, iArr2, iArr3) != null || (iArr3[13] == -1 && Nat.m29031c(14, iArr3, f23142b) != null)) && Nat.m29009a(f23143c.length, f23143c, iArr3) != null) {
            Nat.m29020b(14, iArr3, f23143c.length);
        }
    }

    /* renamed from: b */
    public static void m28603b(int[] iArr, int[] iArr2) {
        if (Nat224.m28926b(iArr)) {
            Nat224.m28933d(iArr2);
        } else {
            Nat224.m28936e(f23141a, iArr, iArr2);
        }
    }

    /* renamed from: c */
    public static void m28605c(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[10]) & 4294967295L;
        long j2 = ((long) iArr[11]) & 4294967295L;
        long j3 = ((long) iArr[12]) & 4294967295L;
        long j4 = ((long) iArr[13]) & 4294967295L;
        long j5 = ((((long) iArr[7]) & 4294967295L) + j2) - 1;
        long j6 = j2;
        j2 = (((long) iArr[8]) & 4294967295L) + j3;
        long j7 = j3;
        j3 = (((long) iArr[9]) & 4294967295L) + j4;
        long j8 = j4;
        j4 = ((((long) iArr[0]) & 4294967295L) - j5) + 0;
        long j9 = j4 & 4294967295L;
        long j10 = j5;
        j4 = (j4 >> 32) + ((((long) iArr[1]) & 4294967295L) - j2);
        iArr3[1] = (int) j4;
        j4 = (j4 >> 32) + ((((long) iArr[2]) & 4294967295L) - j3);
        iArr3[2] = (int) j4;
        j4 = (j4 >> 32) + (((((long) iArr[3]) & 4294967295L) + j10) - j);
        long j11 = j4 & 4294967295L;
        j4 = (j4 >> 32) + (((((long) iArr[4]) & 4294967295L) + j2) - j6);
        iArr3[4] = (int) j4;
        j2 = (j4 >> 32) + (((((long) iArr[5]) & 4294967295L) + j3) - j7);
        iArr3[5] = (int) j2;
        j2 = (j2 >> 32) + (((((long) iArr[6]) & 4294967295L) + j) - j8);
        iArr3[6] = (int) j2;
        j = (j2 >> 32) + 1;
        long j12 = j11 + j;
        j = j9 - j;
        iArr3[0] = (int) j;
        j >>= 32;
        if (j != 0) {
            j += ((long) iArr3[1]) & 4294967295L;
            iArr3[1] = (int) j;
            j = (j >> 32) + (4294967295L & ((long) iArr3[2]));
            iArr3[2] = (int) j;
            j12 += j >> 32;
        }
        iArr3[3] = (int) j12;
        if (((j12 >> 32) != 0 && Nat.m29020b(7, iArr3, 4) != 0) || (iArr3[6] == -1 && Nat224.m28931c(iArr3, f23141a))) {
            m28597a(iArr2);
        }
    }

    /* renamed from: a */
    public static void m28596a(int i, int[] iArr) {
        long j;
        if (i != 0) {
            j = ((long) i) & 4294967295L;
            long j2 = ((((long) iArr[0]) & 4294967295L) - j) + 0;
            iArr[0] = (int) j2;
            j2 >>= 32;
            if (j2 != 0) {
                j2 += ((long) iArr[1]) & 4294967295L;
                iArr[1] = (int) j2;
                j2 = (j2 >> 32) + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j2;
                j2 >>= 32;
            }
            j2 += (4294967295L & ((long) iArr[3])) + j;
            iArr[3] = (int) j2;
            j = j2 >> 32;
        } else {
            j = 0;
        }
        if ((j != 0 && Nat.m29020b(7, iArr, 4) != 0) || (iArr[6] == -1 && Nat224.m28931c(iArr, f23141a) != 0)) {
            m28597a(iArr);
        }
    }

    /* renamed from: d */
    public static void m28607d(int[] iArr, int[] iArr2) {
        int[] b = Nat224.m28928b();
        Nat224.m28934d(iArr, b);
        m28605c(b, iArr2);
    }

    /* renamed from: a */
    public static void m28598a(int[] iArr, int i, int[] iArr2) {
        int[] b = Nat224.m28928b();
        Nat224.m28934d(iArr, b);
        m28605c(b, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat224.m28934d(iArr2, b);
                m28605c(b, iArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m28608d(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat224.m28936e(iArr, iArr2, iArr3) != null) {
            m28602b(iArr3);
        }
    }

    /* renamed from: e */
    public static void m28609e(int[] iArr, int[] iArr2) {
        if (Nat.m29007a(7, iArr, 0, iArr2) != null || (iArr2[6] == -1 && Nat224.m28931c(iArr2, f23141a) != null)) {
            m28597a(iArr2);
        }
    }

    /* renamed from: a */
    private static void m28597a(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j;
        j >>= 32;
        if (j != 0) {
            j += ((long) iArr[1]) & 4294967295L;
            iArr[1] = (int) j;
            j = (j >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j;
            j >>= 32;
        }
        j += (4294967295L & ((long) iArr[3])) + 1;
        iArr[3] = (int) j;
        if ((j >> 32) != 0) {
            Nat.m29020b(7, iArr, 4);
        }
    }

    /* renamed from: b */
    private static void m28602b(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j;
        j >>= 32;
        if (j != 0) {
            j += ((long) iArr[1]) & 4294967295L;
            iArr[1] = (int) j;
            j = (j >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j;
            j >>= 32;
        }
        j += (4294967295L & ((long) iArr[3])) - 1;
        iArr[3] = (int) j;
        if ((j >> 32) != 0) {
            Nat.m29002a(7, iArr, 4);
        }
    }
}
