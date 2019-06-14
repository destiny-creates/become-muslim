package org.spongycastle.pqc.math.linearalgebra;

public final class PolynomialRingGF2 {
    /* renamed from: a */
    public static int m29282a(int i) {
        int i2 = -1;
        while (i != 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    private PolynomialRingGF2() {
    }

    /* renamed from: a */
    public static int m29284a(int i, int i2, int i3) {
        i = m29283a(i, i3);
        i2 = m29283a(i2, i3);
        int i4 = 0;
        if (i2 != 0) {
            int a = 1 << m29282a(i3);
            while (i != 0) {
                if (((byte) (i & 1)) == (byte) 1) {
                    i4 ^= i2;
                }
                i >>>= 1;
                i2 <<= 1;
                if (i2 >= a) {
                    i2 ^= i3;
                }
            }
        }
        return i4;
    }

    /* renamed from: a */
    public static int m29283a(int i, int i2) {
        if (i2 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (m29282a(i) >= m29282a(i2)) {
            i ^= i2 << (m29282a(i) - m29282a(i2));
        }
        return i;
    }

    /* renamed from: b */
    public static int m29285b(int i, int i2) {
        while (true) {
            int i3 = i2;
            i2 = i;
            i = i3;
            if (i == 0) {
                return i2;
            }
            i2 = m29283a(i2, i);
        }
    }

    /* renamed from: b */
    public static boolean m29286b(int i) {
        if (i == 0) {
            return false;
        }
        int a = m29282a(i) >>> 1;
        int i2 = 2;
        for (int i3 = 0; i3 < a; i3++) {
            i2 = m29284a(i2, i2, i);
            if (m29285b(i2 ^ 2, i) != 1) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static int m29287c(int i) {
        if (i < 0) {
            System.err.println("The Degree is negative");
            return 0;
        } else if (i > 31) {
            System.err.println("The Degree is more then 31");
            return 0;
        } else if (i == 0) {
            return 1;
        } else {
            i = 1 << (i + 1);
            for (int i2 = (1 << i) + 1; i2 < i; i2 += 2) {
                if (m29286b(i2)) {
                    return i2;
                }
            }
            return 0;
        }
    }
}
