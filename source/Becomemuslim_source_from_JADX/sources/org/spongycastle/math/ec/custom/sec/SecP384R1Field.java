package org.spongycastle.math.ec.custom.sec;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat384;

public class SecP384R1Field {
    /* renamed from: a */
    static final int[] f23149a = new int[]{-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};
    /* renamed from: b */
    static final int[] f23150b = new int[]{1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};
    /* renamed from: c */
    private static final int[] f23151c = new int[]{-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    /* renamed from: a */
    public static void m28640a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.m29010a(12, iArr, iArr2, iArr3) != null || (iArr3[11] == -1 && Nat.m29031c(12, iArr3, f23149a) != null)) {
            m28637a(iArr3);
        }
    }

    /* renamed from: b */
    public static void m28644b(int[] iArr, int[] iArr2, int[] iArr3) {
        if ((Nat.m29010a(24, iArr, iArr2, iArr3) != null || (iArr3[23] == -1 && Nat.m29031c(24, iArr3, f23150b) != null)) && Nat.m29009a(f23151c.length, f23151c, iArr3) != null) {
            Nat.m29020b(24, iArr3, f23151c.length);
        }
    }

    /* renamed from: a */
    public static void m28639a(int[] iArr, int[] iArr2) {
        if (Nat.m29034d(12, iArr, iArr2) != null || (iArr2[11] == -1 && Nat.m29031c(12, iArr2, f23149a) != null)) {
            m28637a(iArr2);
        }
    }

    /* renamed from: a */
    public static int[] m28641a(BigInteger bigInteger) {
        int[] a = Nat.m29016a((int) BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, bigInteger);
        if (a[11] == -1 && Nat.m29031c(12, a, f23149a)) {
            Nat.m29036e(12, f23149a, a);
        }
        return a;
    }

    /* renamed from: c */
    public static void m28646c(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] a = Nat.m29015a(24);
        Nat384.m28981a(iArr, iArr2, a);
        m28645c(a, iArr3);
    }

    /* renamed from: b */
    public static void m28643b(int[] iArr, int[] iArr2) {
        if (Nat.m29037e(12, iArr)) {
            Nat.m29039g(12, iArr2);
        } else {
            Nat.m29030c(12, f23149a, iArr, iArr2);
        }
    }

    /* renamed from: c */
    public static void m28645c(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[17]) & 4294967295L;
        long j2 = ((long) iArr[20]) & 4294967295L;
        long j3 = ((long) iArr[21]) & 4294967295L;
        long j4 = ((long) iArr[19]) & 4294967295L;
        long j5 = ((long) iArr[22]) & 4294967295L;
        long j6 = ((long) iArr[18]) & 4294967295L;
        long j7 = ((long) iArr[23]) & 4294967295L;
        long j8 = ((long) iArr[16]) & 4294967295L;
        long j9 = ((((long) iArr[12]) & 4294967295L) + j2) - 1;
        long j10 = j2;
        long j11 = (((long) iArr[13]) & 4294967295L) + j5;
        long j12 = ((((long) iArr[14]) & 4294967295L) + j5) + j7;
        j2 = (((long) iArr[15]) & 4294967295L) + j7;
        long j13 = j + j3;
        long j14 = j3 - j7;
        long j15 = j5 - j7;
        j5 = (((((long) iArr[0]) & 4294967295L) + j9) + j14) + 0;
        iArr3[0] = (int) j5;
        long j16 = j;
        j5 = (j5 >> 32) + ((((((long) iArr[1]) & 4294967295L) + j7) - j9) + j11);
        iArr3[1] = (int) j5;
        long j17 = (j5 >> 32) + ((((((long) iArr[2]) & 4294967295L) - j3) - j11) + j12);
        iArr3[2] = (int) j17;
        j17 = (j17 >> 32) + (((((((long) iArr[3]) & 4294967295L) + j9) - j12) + j2) + j14);
        iArr3[3] = (int) j17;
        j17 = (j17 >> 32) + (((((((((long) iArr[4]) & 4294967295L) + j8) + j3) + j9) + j11) - j2) + j14);
        iArr3[4] = (int) j17;
        long j18 = (j17 >> 32) + (((((((long) iArr[5]) & 4294967295L) - j8) + j11) + j12) + j13);
        iArr3[5] = (int) j18;
        j18 = (j18 >> 32) + (((((((long) iArr[6]) & 4294967295L) + j6) - j16) + j12) + j2);
        iArr3[6] = (int) j18;
        j18 = (j18 >> 32) + (((((((long) iArr[7]) & 4294967295L) + j8) + j4) - j6) + j2);
        iArr3[7] = (int) j18;
        j18 = (j18 >> 32) + (((((((long) iArr[8]) & 4294967295L) + j8) + j16) + j10) - j4);
        iArr3[8] = (int) j18;
        j18 = (j18 >> 32) + ((((((long) iArr[9]) & 4294967295L) + j6) - j10) + j13);
        iArr3[9] = (int) j18;
        j18 = (j18 >> 32) + (((((((long) iArr[10]) & 4294967295L) + j6) + j4) - j14) + j15);
        iArr3[10] = (int) j18;
        j18 = (j18 >> 32) + ((((((long) iArr[11]) & 4294967295L) + j4) + j10) - j15);
        iArr3[11] = (int) j18;
        m28636a((int) ((j18 >> 32) + 1), iArr3);
    }

    /* renamed from: a */
    public static void m28636a(int i, int[] iArr) {
        long j;
        if (i != 0) {
            j = ((long) i) & 4294967295L;
            long j2 = ((((long) iArr[0]) & 4294967295L) + j) + 0;
            iArr[0] = (int) j2;
            j2 = (j2 >> 32) + ((((long) iArr[1]) & 4294967295L) - j);
            iArr[1] = (int) j2;
            j2 >>= 32;
            if (j2 != 0) {
                j2 += ((long) iArr[2]) & 4294967295L;
                iArr[2] = (int) j2;
                j2 >>= 32;
            }
            j2 += (((long) iArr[3]) & 4294967295L) + j;
            iArr[3] = (int) j2;
            j2 = (j2 >> 32) + ((4294967295L & ((long) iArr[4])) + j);
            iArr[4] = (int) j2;
            j = j2 >> 32;
        } else {
            j = 0;
        }
        if ((j != 0 && Nat.m29020b(12, iArr, 5) != 0) || (iArr[11] == -1 && Nat.m29031c(12, iArr, f23149a) != 0)) {
            m28637a(iArr);
        }
    }

    /* renamed from: d */
    public static void m28647d(int[] iArr, int[] iArr2) {
        int[] a = Nat.m29015a(24);
        Nat384.m28980a(iArr, a);
        m28645c(a, iArr2);
    }

    /* renamed from: a */
    public static void m28638a(int[] iArr, int i, int[] iArr2) {
        int[] a = Nat.m29015a(24);
        Nat384.m28980a(iArr, a);
        m28645c(a, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat384.m28980a(iArr2, a);
                m28645c(a, iArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m28648d(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.m29030c(12, iArr, iArr2, iArr3) != null) {
            m28642b(iArr3);
        }
    }

    /* renamed from: e */
    public static void m28649e(int[] iArr, int[] iArr2) {
        if (Nat.m29007a(12, iArr, 0, iArr2) != null || (iArr2[11] == -1 && Nat.m29031c(12, iArr2, f23149a) != null)) {
            m28637a(iArr2);
        }
    }

    /* renamed from: a */
    private static void m28637a(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j;
        j = (j >> 32) + ((((long) iArr[1]) & 4294967295L) - 1);
        iArr[1] = (int) j;
        j >>= 32;
        if (j != 0) {
            j += ((long) iArr[2]) & 4294967295L;
            iArr[2] = (int) j;
            j >>= 32;
        }
        j += (((long) iArr[3]) & 4294967295L) + 1;
        iArr[3] = (int) j;
        j = (j >> 32) + ((4294967295L & ((long) iArr[4])) + 1);
        iArr[4] = (int) j;
        if ((j >> 32) != 0) {
            Nat.m29020b(12, iArr, 5);
        }
    }

    /* renamed from: b */
    private static void m28642b(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j;
        j = (j >> 32) + ((((long) iArr[1]) & 4294967295L) + 1);
        iArr[1] = (int) j;
        j >>= 32;
        if (j != 0) {
            j += ((long) iArr[2]) & 4294967295L;
            iArr[2] = (int) j;
            j >>= 32;
        }
        j += (((long) iArr[3]) & 4294967295L) - 1;
        iArr[3] = (int) j;
        j = (j >> 32) + ((4294967295L & ((long) iArr[4])) - 1);
        iArr[4] = (int) j;
        if ((j >> 32) != 0) {
            Nat.m29002a(12, iArr, 5);
        }
    }
}
