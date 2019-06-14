package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;

public class SecP192R1Field {
    /* renamed from: a */
    static final int[] f23135a = new int[]{-1, -1, -2, -1, -1, -1};
    /* renamed from: b */
    static final int[] f23136b = new int[]{1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};
    /* renamed from: c */
    private static final int[] f23137c = new int[]{-1, -1, -3, -1, -2, -1, 1, 0, 2};

    /* renamed from: a */
    public static void m28574a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat192.m28887a(iArr, iArr2, iArr3) != null || (iArr3[5] == -1 && Nat192.m28900b(iArr3, f23135a) != null)) {
            m28571a(iArr3);
        }
    }

    /* renamed from: a */
    public static void m28573a(int[] iArr, int[] iArr2) {
        if (Nat.m29034d(6, iArr, iArr2) != null || (iArr2[5] == -1 && Nat192.m28900b(iArr2, f23135a) != null)) {
            m28571a(iArr2);
        }
    }

    /* renamed from: a */
    public static int[] m28575a(BigInteger bigInteger) {
        bigInteger = Nat192.m28895a(bigInteger);
        if (bigInteger[5] == -1 && Nat192.m28900b(bigInteger, f23135a)) {
            Nat192.m28911d(f23135a, bigInteger);
        }
        return bigInteger;
    }

    /* renamed from: b */
    public static void m28578b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] c = Nat192.m28910c();
        Nat192.m28909c(iArr, iArr2, c);
        m28579c(c, iArr3);
    }

    /* renamed from: c */
    public static void m28580c(int[] iArr, int[] iArr2, int[] iArr3) {
        if ((Nat192.m28912d(iArr, iArr2, iArr3) != null || (iArr3[11] == -1 && Nat.m29031c(12, iArr3, f23136b) != null)) && Nat.m29009a(f23137c.length, f23137c, iArr3) != null) {
            Nat.m29020b(12, iArr3, f23137c.length);
        }
    }

    /* renamed from: b */
    public static void m28577b(int[] iArr, int[] iArr2) {
        if (Nat192.m28898b(iArr)) {
            Nat192.m28913d(iArr2);
        } else {
            Nat192.m28915e(f23135a, iArr, iArr2);
        }
    }

    /* renamed from: c */
    public static void m28579c(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[6]) & 4294967295L;
        long j2 = ((long) iArr[7]) & 4294967295L;
        long j3 = ((long) iArr[8]) & 4294967295L;
        long j4 = ((long) iArr[9]) & 4294967295L;
        long j5 = (((long) iArr[10]) & 4294967295L) + j;
        long j6 = (((long) iArr[11]) & 4294967295L) + j2;
        long j7 = j2;
        j2 = ((((long) iArr[0]) & 4294967295L) + j5) + 0;
        int i = (int) j2;
        long j8 = j;
        j2 = (j2 >> 32) + ((((long) iArr[1]) & 4294967295L) + j6);
        iArr3[1] = (int) j2;
        j5 += j3;
        j6 += j4;
        long j9 = (j2 >> 32) + ((((long) iArr[2]) & 4294967295L) + j5);
        j2 = j9 & 4294967295L;
        j9 = (j9 >> 32) + ((((long) iArr[3]) & 4294967295L) + j6);
        iArr3[3] = (int) j9;
        j6 -= j7;
        j9 = (j9 >> 32) + ((((long) iArr[4]) & 4294967295L) + (j5 - j8));
        iArr3[4] = (int) j9;
        j9 = (j9 >> 32) + ((((long) iArr[5]) & 4294967295L) + j6);
        iArr3[5] = (int) j9;
        j9 >>= 32;
        j2 += j9;
        j9 += ((long) i) & 4294967295L;
        iArr3[0] = (int) j9;
        j9 >>= 32;
        if (j9 != 0) {
            j9 += 4294967295L & ((long) iArr3[1]);
            iArr3[1] = (int) j9;
            j2 += j9 >> 32;
        }
        iArr3[2] = (int) j2;
        if (((j2 >> 32) != 0 && Nat.m29020b(6, iArr3, 3) != 0) || (iArr3[5] == -1 && Nat192.m28900b(iArr3, f23135a))) {
            m28571a(iArr2);
        }
    }

    /* renamed from: a */
    public static void m28570a(int i, int[] iArr) {
        long j;
        if (i != 0) {
            j = ((long) i) & 4294967295L;
            long j2 = ((((long) iArr[0]) & 4294967295L) + j) + 0;
            iArr[0] = (int) j2;
            j2 >>= 32;
            if (j2 != 0) {
                j2 += ((long) iArr[1]) & 4294967295L;
                iArr[1] = (int) j2;
                j2 >>= 32;
            }
            j2 += (4294967295L & ((long) iArr[2])) + j;
            iArr[2] = (int) j2;
            j = j2 >> 32;
        } else {
            j = 0;
        }
        if ((j != 0 && Nat.m29020b(6, iArr, 3) != 0) || (iArr[5] == -1 && Nat192.m28900b(iArr, f23135a) != 0)) {
            m28571a(iArr);
        }
    }

    /* renamed from: d */
    public static void m28581d(int[] iArr, int[] iArr2) {
        int[] c = Nat192.m28910c();
        Nat192.m28908c(iArr, c);
        m28579c(c, iArr2);
    }

    /* renamed from: a */
    public static void m28572a(int[] iArr, int i, int[] iArr2) {
        int[] c = Nat192.m28910c();
        Nat192.m28908c(iArr, c);
        m28579c(c, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat192.m28908c(iArr2, c);
                m28579c(c, iArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m28582d(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat192.m28915e(iArr, iArr2, iArr3) != null) {
            m28576b(iArr3);
        }
    }

    /* renamed from: e */
    public static void m28583e(int[] iArr, int[] iArr2) {
        if (Nat.m29007a(6, iArr, 0, iArr2) != null || (iArr2[5] == -1 && Nat192.m28900b(iArr2, f23135a) != null)) {
            m28571a(iArr2);
        }
    }

    /* renamed from: a */
    private static void m28571a(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j;
        j >>= 32;
        if (j != 0) {
            j += ((long) iArr[1]) & 4294967295L;
            iArr[1] = (int) j;
            j >>= 32;
        }
        j += (4294967295L & ((long) iArr[2])) + 1;
        iArr[2] = (int) j;
        if ((j >> 32) != 0) {
            Nat.m29020b(6, iArr, 3);
        }
    }

    /* renamed from: b */
    private static void m28576b(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j;
        j >>= 32;
        if (j != 0) {
            j += ((long) iArr[1]) & 4294967295L;
            iArr[1] = (int) j;
            j >>= 32;
        }
        j += (4294967295L & ((long) iArr[2])) - 1;
        iArr[2] = (int) j;
        if ((j >> 32) != 0) {
            Nat.m29002a(6, iArr, 3);
        }
    }
}
