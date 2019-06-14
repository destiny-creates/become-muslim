package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat128;
import org.spongycastle.math.raw.Nat256;

public class SecP128R1Field {
    /* renamed from: a */
    static final int[] f23123a = new int[]{-1, -1, -1, -3};
    /* renamed from: b */
    static final int[] f23124b = new int[]{1, 0, 0, 4, -2, -1, 3, -4};
    /* renamed from: c */
    private static final int[] f23125c = new int[]{-1, -1, -1, -5, 1, 0, -4, 3};

    /* renamed from: a */
    public static void m28524a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat128.m28838a(iArr, iArr2, iArr3) != null || (iArr3[3] == -3 && Nat128.m28847b(iArr3, f23123a) != null)) {
            m28521a(iArr3);
        }
    }

    /* renamed from: a */
    public static void m28523a(int[] iArr, int[] iArr2) {
        if (Nat.m29034d(4, iArr, iArr2) != null || (iArr2[3] == -3 && Nat128.m28847b(iArr2, f23123a) != null)) {
            m28521a(iArr2);
        }
    }

    /* renamed from: a */
    public static int[] m28525a(BigInteger bigInteger) {
        bigInteger = Nat128.m28844a(bigInteger);
        if (bigInteger[3] == -3 && Nat128.m28847b(bigInteger, f23123a)) {
            Nat128.m28856d(f23123a, bigInteger);
        }
        return bigInteger;
    }

    /* renamed from: b */
    public static void m28528b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] c = Nat128.m28855c();
        Nat128.m28854c(iArr, iArr2, c);
        m28529c(c, iArr3);
    }

    /* renamed from: c */
    public static void m28530c(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat128.m28857d(iArr, iArr2, iArr3) != null || (iArr3[7] == -4 && Nat256.m28965c(iArr3, f23124b) != null)) {
            Nat.m29009a(f23125c.length, f23125c, iArr3);
        }
    }

    /* renamed from: b */
    public static void m28527b(int[] iArr, int[] iArr2) {
        if (Nat128.m28846b(iArr)) {
            Nat128.m28858d(iArr2);
        } else {
            Nat128.m28860e(f23123a, iArr, iArr2);
        }
    }

    /* renamed from: c */
    public static void m28529c(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[7]) & 4294967295L;
        long j2 = (((long) iArr[3]) & 4294967295L) + j;
        long j3 = (((long) iArr[6]) & 4294967295L) + (j << 1);
        j = (((long) iArr[2]) & 4294967295L) + j3;
        long j4 = (((long) iArr[5]) & 4294967295L) + (j3 << 1);
        long j5 = (((long) iArr[1]) & 4294967295L) + j4;
        long j6 = (((long) iArr[4]) & 4294967295L) + (j4 << 1);
        long j7 = (((long) iArr[0]) & 4294967295L) + j6;
        j2 += j6 << 1;
        iArr3[0] = (int) j7;
        j5 += j7 >>> 32;
        iArr3[1] = (int) j5;
        j += j5 >>> 32;
        iArr3[2] = (int) j;
        j2 += j >>> 32;
        iArr3[3] = (int) j2;
        m28520a((int) (j2 >>> 32), iArr3);
    }

    /* renamed from: a */
    public static void m28520a(int i, int[] iArr) {
        while (i != 0) {
            long j = ((long) i) & 4294967295L;
            long j2 = (((long) iArr[0]) & 4294967295L) + j;
            iArr[0] = (int) j2;
            j2 >>= 32;
            if (j2 != 0) {
                j2 += ((long) iArr[1]) & 4294967295L;
                iArr[1] = (int) j2;
                j2 = (j2 >> 32) + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j2;
                j2 >>= 32;
            }
            j2 += (4294967295L & ((long) iArr[3])) + (j << 1);
            iArr[3] = (int) j2;
            i = (int) (j2 >> 32);
        }
    }

    /* renamed from: d */
    public static void m28531d(int[] iArr, int[] iArr2) {
        int[] c = Nat128.m28855c();
        Nat128.m28853c(iArr, c);
        m28529c(c, iArr2);
    }

    /* renamed from: a */
    public static void m28522a(int[] iArr, int i, int[] iArr2) {
        int[] c = Nat128.m28855c();
        Nat128.m28853c(iArr, c);
        m28529c(c, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat128.m28853c(iArr2, c);
                m28529c(c, iArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m28532d(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat128.m28860e(iArr, iArr2, iArr3) != null) {
            m28526b(iArr3);
        }
    }

    /* renamed from: e */
    public static void m28533e(int[] iArr, int[] iArr2) {
        if (Nat.m29007a(4, iArr, 0, iArr2) != null || (iArr2[3] == -3 && Nat128.m28847b(iArr2, f23123a) != null)) {
            m28521a(iArr2);
        }
    }

    /* renamed from: a */
    private static void m28521a(int[] iArr) {
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
        iArr[3] = (int) (j + ((4294967295L & ((long) iArr[3])) + 2));
    }

    /* renamed from: b */
    private static void m28526b(int[] iArr) {
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
        iArr[3] = (int) (j + ((4294967295L & ((long) iArr[3])) - 2));
    }
}
