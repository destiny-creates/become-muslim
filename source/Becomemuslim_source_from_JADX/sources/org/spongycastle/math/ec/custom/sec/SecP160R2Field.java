package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat160;

public class SecP160R2Field {
    /* renamed from: a */
    static final int[] f23129a = new int[]{-21389, -2, -1, -1, -1};
    /* renamed from: b */
    static final int[] f23130b = new int[]{457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};
    /* renamed from: c */
    private static final int[] f23131c = new int[]{-457489321, -42779, -2, -1, -1, 42777, 2};

    /* renamed from: a */
    public static void m28549a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat160.m28864a(iArr, iArr2, iArr3) != null || (iArr3[4] == -1 && Nat160.m28873b(iArr3, f23129a) != null)) {
            Nat.m28998a((int) 5, 21389, iArr3);
        }
    }

    /* renamed from: a */
    public static void m28548a(int[] iArr, int[] iArr2) {
        if (Nat.m29034d(5, iArr, iArr2) != null || (iArr2[4] == -1 && Nat160.m28873b(iArr2, f23129a) != null)) {
            Nat.m28998a(5, 21389, iArr2);
        }
    }

    /* renamed from: a */
    public static int[] m28550a(BigInteger bigInteger) {
        bigInteger = Nat160.m28869a(bigInteger);
        if (bigInteger[4] == -1 && Nat160.m28873b(bigInteger, f23129a)) {
            Nat160.m28878d(f23129a, bigInteger);
        }
        return bigInteger;
    }

    /* renamed from: b */
    public static void m28552b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] b = Nat160.m28874b();
        Nat160.m28877c(iArr, iArr2, b);
        m28553c(b, iArr3);
    }

    /* renamed from: c */
    public static void m28554c(int[] iArr, int[] iArr2, int[] iArr3) {
        if ((Nat160.m28879d(iArr, iArr2, iArr3) != null || (iArr3[9] == -1 && Nat.m29031c(10, iArr3, f23130b) != null)) && Nat.m29009a(f23131c.length, f23131c, iArr3) != null) {
            Nat.m29020b(10, iArr3, f23131c.length);
        }
    }

    /* renamed from: b */
    public static void m28551b(int[] iArr, int[] iArr2) {
        if (Nat160.m28872b(iArr)) {
            Nat160.m28880d(iArr2);
        } else {
            Nat160.m28881e(f23129a, iArr, iArr2);
        }
    }

    /* renamed from: c */
    public static void m28553c(int[] iArr, int[] iArr2) {
        if (Nat160.m28862a(21389, Nat160.m28865a(21389, iArr, 5, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[4] == -1 && Nat160.m28873b(iArr2, f23129a))) {
            Nat.m28998a(5, 21389, iArr2);
        }
    }

    /* renamed from: a */
    public static void m28546a(int i, int[] iArr) {
        if ((i != 0 && Nat160.m28861a(21389, i, iArr, 0) != 0) || (iArr[4] == -1 && Nat160.m28873b(iArr, f23129a) != 0)) {
            Nat.m28998a(5, 21389, iArr);
        }
    }

    /* renamed from: d */
    public static void m28555d(int[] iArr, int[] iArr2) {
        int[] b = Nat160.m28874b();
        Nat160.m28876c(iArr, b);
        m28553c(b, iArr2);
    }

    /* renamed from: a */
    public static void m28547a(int[] iArr, int i, int[] iArr2) {
        int[] b = Nat160.m28874b();
        Nat160.m28876c(iArr, b);
        m28553c(b, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat160.m28876c(iArr2, b);
                m28553c(b, iArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public static void m28556d(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat160.m28881e(iArr, iArr2, iArr3) != null) {
            Nat.m29026c((int) 5, 21389, iArr3);
        }
    }

    /* renamed from: e */
    public static void m28557e(int[] iArr, int[] iArr2) {
        if (Nat.m29007a(5, iArr, 0, iArr2) != null || (iArr2[4] == -1 && Nat160.m28873b(iArr2, f23129a) != null)) {
            Nat.m28998a(5, 21389, iArr2);
        }
    }
}
