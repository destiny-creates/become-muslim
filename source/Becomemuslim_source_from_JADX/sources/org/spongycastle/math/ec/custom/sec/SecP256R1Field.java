package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

public class SecP256R1Field {
    /* renamed from: a */
    static final int[] f23147a = new int[]{-1, -1, -1, 0, 0, 0, 1, -1};
    /* renamed from: b */
    static final int[] f23148b = new int[]{1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};

    /* renamed from: a */
    public static void m28626a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.m28944a(iArr, iArr2, iArr3) != null || (iArr3[7] == -1 && Nat256.m28965c(iArr3, f23147a) != null)) {
            m28623a(iArr3);
        }
    }

    /* renamed from: a */
    public static void m28625a(int[] iArr, int[] iArr2) {
        if (Nat.m29034d(8, iArr, iArr2) != null || (iArr2[7] == -1 && Nat256.m28965c(iArr2, f23147a) != null)) {
            m28623a(iArr2);
        }
    }

    /* renamed from: a */
    public static int[] m28627a(BigInteger bigInteger) {
        bigInteger = Nat256.m28951a(bigInteger);
        if (bigInteger[7] == -1 && Nat256.m28965c(bigInteger, f23147a)) {
            Nat256.m28971e(f23147a, bigInteger);
        }
        return bigInteger;
    }

    /* renamed from: b */
    public static void m28630b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] c = Nat256.m28966c();
        Nat256.m28964c(iArr, iArr2, c);
        m28631c(c, iArr3);
    }

    /* renamed from: c */
    public static void m28632c(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.m28967d(iArr, iArr2, iArr3) != null || (iArr3[15] == -1 && Nat.m29031c(16, iArr3, f23148b) != null)) {
            Nat.m29036e(16, f23148b, iArr3);
        }
    }

    /* renamed from: b */
    public static void m28629b(int[] iArr, int[] iArr2) {
        if (Nat256.m28954b(iArr)) {
            Nat256.m28968d(iArr2);
        } else {
            Nat256.m28972e(f23147a, iArr, iArr2);
        }
    }

    /* renamed from: c */
    public static void m28631c(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[9]) & 4294967295L;
        long j2 = ((long) iArr[10]) & 4294967295L;
        long j3 = ((long) iArr[11]) & 4294967295L;
        long j4 = ((long) iArr[12]) & 4294967295L;
        long j5 = ((long) iArr[13]) & 4294967295L;
        long j6 = ((long) iArr[14]) & 4294967295L;
        long j7 = ((long) iArr[15]) & 4294967295L;
        long j8 = (((long) iArr[8]) & 4294967295L) - 6;
        long j9 = j8 + j;
        j += j2;
        j2 = (j2 + j3) - j7;
        j3 += j4;
        j4 += j5;
        long j10 = j5 + j6;
        long j11 = j6 + j7;
        long j12 = j8;
        j8 = ((((((long) iArr[0]) & 4294967295L) + j9) - j3) - j10) + 0;
        int[] iArr4 = iArr2;
        iArr4[0] = (int) j8;
        long j13 = j6;
        j8 = (j8 >> 32) + ((((((long) iArr[1]) & 4294967295L) + j) - j4) - j11);
        iArr4[1] = (int) j8;
        j8 = (j8 >> 32) + (((((long) iArr[2]) & 4294967295L) + j2) - j10);
        iArr4 = iArr2;
        iArr4[2] = (int) j8;
        j8 = (j8 >> 32) + (((((((long) iArr[3]) & 4294967295L) + (j3 << 1)) + j5) - j7) - j9);
        iArr4[3] = (int) j8;
        j8 = (j8 >> 32) + ((((((long) iArr[4]) & 4294967295L) + (j4 << 1)) + j13) - j);
        iArr4[4] = (int) j8;
        j8 = (j8 >> 32) + (((((long) iArr[5]) & 4294967295L) + (j10 << 1)) - j2);
        iArr4[5] = (int) j8;
        j8 = (j8 >> 32) + ((((((long) iArr[6]) & 4294967295L) + (j11 << 1)) + j10) - j9);
        iArr4[6] = (int) j8;
        j8 = (j8 >> 32) + (((((((long) iArr[7]) & 4294967295L) + (j7 << 1)) + j12) - j2) - j4);
        iArr4[7] = (int) j8;
        m28622a((int) ((j8 >> 32) + 6), iArr4);
    }

    /* renamed from: a */
    public static void m28622a(int i, int[] iArr) {
        long j;
        if (i != 0) {
            j = ((long) i) & 4294967295L;
            long j2 = ((((long) iArr[0]) & 4294967295L) + j) + 0;
            iArr[0] = (int) j2;
            j2 >>= 32;
            if (j2 != 0) {
                j2 += ((long) iArr[1]) & 4294967295L;
                iArr[1] = (int) j2;
                j2 = (j2 >> 32) + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j2;
                j2 >>= 32;
            }
            j2 += (((long) iArr[3]) & 4294967295L) - j;
            iArr[3] = (int) j2;
            j2 >>= 32;
            if (j2 != 0) {
                j2 += ((long) iArr[4]) & 4294967295L;
                iArr[4] = (int) j2;
                j2 = (j2 >> 32) + (((long) iArr[5]) & 4294967295L);
                iArr[5] = (int) j2;
                j2 >>= 32;
            }
            j2 += (((long) iArr[6]) & 4294967295L) - j;
            iArr[6] = (int) j2;
            j2 = (j2 >> 32) + ((4294967295L & ((long) iArr[7])) + j);
            iArr[7] = (int) j2;
            j = j2 >> 32;
        } else {
            j = 0;
        }
        if (j != 0 || (iArr[7] == -1 && Nat256.m28965c(iArr, f23147a) != 0)) {
            m28623a(iArr);
        }
    }

    /* renamed from: d */
    public static void m28633d(int[] iArr, int[] iArr2) {
        int[] c = Nat256.m28966c();
        Nat256.m28969d(iArr, c);
        m28631c(c, iArr2);
    }

    /* renamed from: a */
    public static void m28624a(int[] iArr, int i, int[] iArr2) {
        int[] c = Nat256.m28966c();
        Nat256.m28969d(iArr, c);
        m28631c(c, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat256.m28969d(iArr2, c);
                m28631c(c, iArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m28634d(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.m28972e(iArr, iArr2, iArr3) != null) {
            m28628b(iArr3);
        }
    }

    /* renamed from: e */
    public static void m28635e(int[] iArr, int[] iArr2) {
        if (Nat.m29007a(8, iArr, 0, iArr2) != null || (iArr2[7] == -1 && Nat256.m28965c(iArr2, f23147a) != null)) {
            m28623a(iArr2);
        }
    }

    /* renamed from: a */
    private static void m28623a(int[] iArr) {
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
        j += (((long) iArr[3]) & 4294967295L) - 1;
        iArr[3] = (int) j;
        j >>= 32;
        if (j != 0) {
            j += ((long) iArr[4]) & 4294967295L;
            iArr[4] = (int) j;
            j = (j >> 32) + (((long) iArr[5]) & 4294967295L);
            iArr[5] = (int) j;
            j >>= 32;
        }
        j += (((long) iArr[6]) & 4294967295L) - 1;
        iArr[6] = (int) j;
        iArr[7] = (int) ((j >> 32) + ((4294967295L & ((long) iArr[7])) + 1));
    }

    /* renamed from: b */
    private static void m28628b(int[] iArr) {
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
        j += (((long) iArr[3]) & 4294967295L) + 1;
        iArr[3] = (int) j;
        j >>= 32;
        if (j != 0) {
            j += ((long) iArr[4]) & 4294967295L;
            iArr[4] = (int) j;
            j = (j >> 32) + (((long) iArr[5]) & 4294967295L);
            iArr[5] = (int) j;
            j >>= 32;
        }
        j += (((long) iArr[6]) & 4294967295L) + 1;
        iArr[6] = (int) j;
        iArr[7] = (int) ((j >> 32) + ((4294967295L & ((long) iArr[7])) - 1));
    }
}
