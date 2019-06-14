package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat512;

public class SecP521R1Field {
    /* renamed from: a */
    static final int[] f23152a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 511};

    /* renamed from: a */
    public static void m28653a(int[] iArr, int[] iArr2, int[] iArr3) {
        int a = (Nat.m29010a(16, iArr, iArr2, iArr3) + iArr[16]) + iArr2[16];
        if (a > 511 || (a == 511 && Nat.m29024b(16, iArr3, f23152a) != null)) {
            a = (a + Nat.m29027c(16, iArr3)) & 511;
        }
        iArr3[16] = a;
    }

    /* renamed from: a */
    public static void m28652a(int[] iArr, int[] iArr2) {
        int d = Nat.m29034d(16, iArr, iArr2) + iArr[16];
        if (d > 511 || (d == 511 && Nat.m29024b(16, iArr2, f23152a))) {
            d = (d + Nat.m29027c(16, iArr2)) & 511;
        }
        iArr2[16] = d;
    }

    /* renamed from: a */
    public static int[] m28654a(BigInteger bigInteger) {
        int[] a = Nat.m29016a(521, bigInteger);
        if (Nat.m29024b(17, a, f23152a)) {
            Nat.m29039g(17, a);
        }
        return a;
    }

    /* renamed from: b */
    public static void m28656b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] a = Nat.m29015a(33);
        m28660d(iArr, iArr2, a);
        m28657c(a, iArr3);
    }

    /* renamed from: b */
    public static void m28655b(int[] iArr, int[] iArr2) {
        if (Nat.m29037e(17, iArr)) {
            Nat.m29039g(17, iArr2);
        } else {
            Nat.m29030c(17, f23152a, iArr, iArr2);
        }
    }

    /* renamed from: c */
    public static void m28657c(int[] iArr, int[] iArr2) {
        int i = iArr[32];
        int a = ((Nat.m29004a(16, iArr, 16, 9, i, iArr2, 0) >>> 23) + (i >>> 9)) + Nat.m29009a(16, iArr, iArr2);
        if (a > 511 || (a == 511 && Nat.m29024b(16, iArr2, f23152a))) {
            a = (a + Nat.m29027c(16, iArr2)) & 511;
        }
        iArr2[16] = a;
    }

    /* renamed from: a */
    public static void m28650a(int[] iArr) {
        int i = iArr[16];
        int b = Nat.m29018b(16, i >>> 9, iArr) + (i & 511);
        if (b > 511 || (b == 511 && Nat.m29024b(16, iArr, f23152a))) {
            b = (b + Nat.m29027c(16, iArr)) & 511;
        }
        iArr[16] = b;
    }

    /* renamed from: d */
    public static void m28659d(int[] iArr, int[] iArr2) {
        int[] a = Nat.m29015a(33);
        m28662f(iArr, a);
        m28657c(a, iArr2);
    }

    /* renamed from: a */
    public static void m28651a(int[] iArr, int i, int[] iArr2) {
        int[] a = Nat.m29015a(33);
        m28662f(iArr, a);
        m28657c(a, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                m28662f(iArr2, a);
                m28657c(a, iArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    public static void m28658c(int[] iArr, int[] iArr2, int[] iArr3) {
        int c = (Nat.m29030c(16, iArr, iArr2, iArr3) + iArr[16]) - iArr2[16];
        if (c < 0) {
            c = (c + Nat.m29019b(16, iArr3)) & 511;
        }
        iArr3[16] = c;
    }

    /* renamed from: e */
    public static void m28661e(int[] iArr, int[] iArr2) {
        int i = iArr[16];
        iArr2[16] = (Nat.m29007a(16, iArr, i << 23, iArr2) | (i << 1)) & 511;
    }

    /* renamed from: d */
    protected static void m28660d(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat512.m28990a(iArr, iArr2, iArr3);
        int i = iArr[16];
        int i2 = iArr2[16];
        iArr3[32] = Nat.m29001a(16, i, iArr2, i2, iArr, iArr3, 16) + (i * i2);
    }

    /* renamed from: f */
    protected static void m28662f(int[] iArr, int[] iArr2) {
        Nat512.m28989a(iArr, iArr2);
        int i = iArr[16];
        iArr2[32] = Nat.m29000a(16, i << 1, iArr, 0, iArr2, 16) + (i * i);
    }
}
