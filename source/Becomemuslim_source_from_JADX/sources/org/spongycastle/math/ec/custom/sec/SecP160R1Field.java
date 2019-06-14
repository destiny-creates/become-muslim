package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat160;

public class SecP160R1Field {
    /* renamed from: a */
    static final int[] f23126a = new int[]{Integer.MAX_VALUE, -1, -1, -1, -1};
    /* renamed from: b */
    static final int[] f23127b = new int[]{1, 1073741825, 0, 0, 0, -2, -2, -1, -1, -1};
    /* renamed from: c */
    private static final int[] f23128c = new int[]{-1, -1073741826, -1, -1, -1, 1, 1};

    /* renamed from: a */
    public static void m28537a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat160.m28864a(iArr, iArr2, iArr3) != null || (iArr3[4] == -1 && Nat160.m28873b(iArr3, f23126a) != null)) {
            Nat.m29018b((int) 5, -2147483647, iArr3);
        }
    }

    /* renamed from: a */
    public static void m28536a(int[] iArr, int[] iArr2) {
        if (Nat.m29034d(5, iArr, iArr2) != null || (iArr2[4] == -1 && Nat160.m28873b(iArr2, f23126a) != null)) {
            Nat.m29018b(5, -2147483647, iArr2);
        }
    }

    /* renamed from: a */
    public static int[] m28538a(BigInteger bigInteger) {
        bigInteger = Nat160.m28869a(bigInteger);
        if (bigInteger[4] == -1 && Nat160.m28873b(bigInteger, f23126a)) {
            Nat160.m28878d(f23126a, bigInteger);
        }
        return bigInteger;
    }

    /* renamed from: b */
    public static void m28540b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] b = Nat160.m28874b();
        Nat160.m28877c(iArr, iArr2, b);
        m28541c(b, iArr3);
    }

    /* renamed from: c */
    public static void m28542c(int[] iArr, int[] iArr2, int[] iArr3) {
        if ((Nat160.m28879d(iArr, iArr2, iArr3) != null || (iArr3[9] == -1 && Nat.m29031c(10, iArr3, f23127b) != null)) && Nat.m29009a(f23128c.length, f23128c, iArr3) != null) {
            Nat.m29020b(10, iArr3, f23128c.length);
        }
    }

    /* renamed from: b */
    public static void m28539b(int[] iArr, int[] iArr2) {
        if (Nat160.m28872b(iArr)) {
            Nat160.m28880d(iArr2);
        } else {
            Nat160.m28881e(f23126a, iArr, iArr2);
        }
    }

    /* renamed from: c */
    public static void m28541c(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[5]) & 4294967295L;
        long j2 = ((long) iArr[6]) & 4294967295L;
        long j3 = ((long) iArr[7]) & 4294967295L;
        long j4 = ((long) iArr[8]) & 4294967295L;
        long j5 = ((long) iArr[9]) & 4294967295L;
        long j6 = (((((long) iArr[0]) & 4294967295L) + j) + (j << 31)) + 0;
        iArr3[0] = (int) j6;
        long j7 = j5;
        j6 = (j6 >>> 32) + (((((long) iArr[1]) & 4294967295L) + j2) + (j2 << 31));
        iArr3[1] = (int) j6;
        j2 = (j6 >>> 32) + (((((long) iArr[2]) & 4294967295L) + j3) + (j3 << 31));
        iArr3[2] = (int) j2;
        j2 = (j2 >>> 32) + (((((long) iArr[3]) & 4294967295L) + j4) + (j4 << 31));
        iArr3[3] = (int) j2;
        j2 = (j2 >>> 32) + (((4294967295L & ((long) iArr[4])) + j7) + (j7 << 31));
        iArr3[4] = (int) j2;
        m28534a((int) (j2 >>> 32), iArr3);
    }

    /* renamed from: a */
    public static void m28534a(int i, int[] iArr) {
        if ((i != 0 && Nat160.m28870b(-2147483647, i, iArr, 0) != 0) || (iArr[4] == -1 && Nat160.m28873b(iArr, f23126a) != 0)) {
            Nat.m29018b(5, -2147483647, iArr);
        }
    }

    /* renamed from: d */
    public static void m28543d(int[] iArr, int[] iArr2) {
        int[] b = Nat160.m28874b();
        Nat160.m28876c(iArr, b);
        m28541c(b, iArr2);
    }

    /* renamed from: a */
    public static void m28535a(int[] iArr, int i, int[] iArr2) {
        int[] b = Nat160.m28874b();
        Nat160.m28876c(iArr, b);
        m28541c(b, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat160.m28876c(iArr2, b);
                m28541c(b, iArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m28544d(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat160.m28881e(iArr, iArr2, iArr3) != null) {
            Nat.m29032d((int) 5, -2147483647, iArr3);
        }
    }

    /* renamed from: e */
    public static void m28545e(int[] iArr, int[] iArr2) {
        if (Nat.m29007a(5, iArr, 0, iArr2) != null || (iArr2[4] == -1 && Nat160.m28873b(iArr2, f23126a) != null)) {
            Nat.m29018b(5, -2147483647, iArr2);
        }
    }
}
