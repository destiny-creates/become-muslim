package com.google.p217b.p240g.p243c;

import com.google.p217b.C5319v;
import com.google.p217b.p222b.C5196a;
import com.google.p217b.p240g.p241a.C5288f;
import com.google.p217b.p240g.p241a.C5294j;

/* compiled from: MatrixUtil */
/* renamed from: com.google.b.g.c.e */
final class C5307e {
    /* renamed from: a */
    private static final int[][] f17914a = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    /* renamed from: b */
    private static final int[][] f17915b = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    /* renamed from: c */
    private static final int[][] f17916c = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    /* renamed from: d */
    private static final int[][] f17917d = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* renamed from: b */
    private static boolean m22551b(int i) {
        return i == -1;
    }

    /* renamed from: a */
    static void m22547a(C5303b c5303b) {
        c5303b.m22503a((byte) -1);
    }

    /* renamed from: a */
    static void m22542a(C5196a c5196a, C5288f c5288f, C5294j c5294j, int i, C5303b c5303b) {
        C5307e.m22547a(c5303b);
        C5307e.m22546a(c5294j, c5303b);
        C5307e.m22544a(c5288f, i, c5303b);
        C5307e.m22549b(c5294j, c5303b);
        C5307e.m22541a(c5196a, i, c5303b);
    }

    /* renamed from: a */
    static void m22546a(C5294j c5294j, C5303b c5303b) {
        C5307e.m22556d(c5303b);
        C5307e.m22554c(c5303b);
        C5307e.m22553c(c5294j, c5303b);
        C5307e.m22550b(c5303b);
    }

    /* renamed from: a */
    static void m22544a(C5288f c5288f, int i, C5303b c5303b) {
        C5196a c5196a = new C5196a();
        C5307e.m22543a(c5288f, i, c5196a);
        for (i = 0; i < c5196a.m21954a(); i++) {
            boolean a = c5196a.m21959a((c5196a.m21954a() - 1) - i);
            int[] iArr = f17917d[i];
            c5303b.m22505a(iArr[null], iArr[1], a);
            if (i < 8) {
                c5303b.m22505a((c5303b.m22506b() - i) - 1, 8, a);
            } else {
                c5303b.m22505a(8, (c5303b.m22502a() - 7) + (i - 8), a);
            }
        }
    }

    /* renamed from: b */
    static void m22549b(C5294j c5294j, C5303b c5303b) {
        if (c5294j.m22459a() >= 7) {
            C5196a c5196a = new C5196a();
            C5307e.m22545a(c5294j, c5196a);
            int i = null;
            int i2 = 17;
            while (i < 6) {
                int i3 = i2;
                for (i2 = 0; i2 < 3; i2++) {
                    boolean a = c5196a.m21959a(i3);
                    i3--;
                    c5303b.m22505a(i, (c5303b.m22502a() - 11) + i2, a);
                    c5303b.m22505a((c5303b.m22502a() - 11) + i2, i, a);
                }
                i++;
                i2 = i3;
            }
        }
    }

    /* renamed from: a */
    static void m22541a(C5196a c5196a, int i, C5303b c5303b) {
        int b = c5303b.m22506b() - 1;
        int a = c5303b.m22502a() - 1;
        int i2 = 0;
        int i3 = -1;
        while (b > 0) {
            if (b == 6) {
                b--;
            }
            while (a >= 0 && a < c5303b.m22502a()) {
                int i4 = i2;
                for (i2 = 0; i2 < 2; i2++) {
                    int i5 = b - i2;
                    if (C5307e.m22551b(c5303b.m22501a(i5, a))) {
                        boolean a2;
                        if (i4 < c5196a.m21954a()) {
                            a2 = c5196a.m21959a(i4);
                            i4++;
                        } else {
                            a2 = false;
                        }
                        if (i != -1 && C5306d.m22532a(i, i5, a)) {
                            a2 = !a2;
                        }
                        c5303b.m22505a(i5, a, a2);
                    }
                }
                a += i3;
                i2 = i4;
            }
            i3 = -i3;
            a += i3;
            b -= 2;
        }
        if (i2 != c5196a.m21954a()) {
            c5303b = new StringBuilder("Not all bits consumed: ");
            c5303b.append(i2);
            c5303b.append('/');
            c5303b.append(c5196a.m21954a());
            throw new C5319v(c5303b.toString());
        }
    }

    /* renamed from: a */
    static int m22538a(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    /* renamed from: a */
    static int m22539a(int i, int i2) {
        if (i2 != 0) {
            int a = C5307e.m22538a(i2);
            i <<= a - 1;
            while (C5307e.m22538a(i) >= a) {
                i ^= i2 << (C5307e.m22538a(i) - a);
            }
            return i;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    /* renamed from: a */
    static void m22543a(C5288f c5288f, int i, C5196a c5196a) {
        if (C5308f.m22557b(i)) {
            int a = (c5288f.m22439a() << 3) | i;
            c5196a.m21963b(a, 5);
            c5196a.m21963b(C5307e.m22539a(a, 1335), 10);
            C5196a c5196a2 = new C5196a();
            c5196a2.m21963b(21522, 15);
            c5196a.m21964b(c5196a2);
            if (c5196a.m21954a() != 15) {
                i = new StringBuilder("should not happen but we got: ");
                i.append(c5196a.m21954a());
                throw new C5319v(i.toString());
            }
            return;
        }
        throw new C5319v("Invalid mask pattern");
    }

    /* renamed from: a */
    static void m22545a(C5294j c5294j, C5196a c5196a) {
        c5196a.m21963b(c5294j.m22459a(), 6);
        c5196a.m21963b(C5307e.m22539a(c5294j.m22459a(), 7973), 12);
        if (c5196a.m21954a() != 18) {
            StringBuilder stringBuilder = new StringBuilder("should not happen but we got: ");
            stringBuilder.append(c5196a.m21954a());
            throw new C5319v(stringBuilder.toString());
        }
    }

    /* renamed from: b */
    private static void m22550b(C5303b c5303b) {
        int i = 8;
        while (i < c5303b.m22506b() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (C5307e.m22551b(c5303b.m22501a(i, 6))) {
                c5303b.m22504a(i, 6, i3);
            }
            if (C5307e.m22551b(c5303b.m22501a(6, i))) {
                c5303b.m22504a(6, i, i3);
            }
            i = i2;
        }
    }

    /* renamed from: c */
    private static void m22554c(C5303b c5303b) {
        if (c5303b.m22501a(8, c5303b.m22502a() - 8) != (byte) 0) {
            c5303b.m22504a(8, c5303b.m22502a() - 8, 1);
            return;
        }
        throw new C5319v();
    }

    /* renamed from: a */
    private static void m22540a(int i, int i2, C5303b c5303b) {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i + i3;
            if (C5307e.m22551b(c5303b.m22501a(i4, i2))) {
                c5303b.m22504a(i4, i2, 0);
                i3++;
            } else {
                throw new C5319v();
            }
        }
    }

    /* renamed from: b */
    private static void m22548b(int i, int i2, C5303b c5303b) {
        int i3 = 0;
        while (i3 < 7) {
            int i4 = i2 + i3;
            if (C5307e.m22551b(c5303b.m22501a(i, i4))) {
                c5303b.m22504a(i, i4, 0);
                i3++;
            } else {
                throw new C5319v();
            }
        }
    }

    /* renamed from: c */
    private static void m22552c(int i, int i2, C5303b c5303b) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = f17915b[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                c5303b.m22504a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    /* renamed from: d */
    private static void m22555d(int i, int i2, C5303b c5303b) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = f17914a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                c5303b.m22504a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    /* renamed from: d */
    private static void m22556d(C5303b c5303b) {
        int length = f17914a[0].length;
        C5307e.m22555d(0, 0, c5303b);
        C5307e.m22555d(c5303b.m22506b() - length, 0, c5303b);
        C5307e.m22555d(0, c5303b.m22506b() - length, c5303b);
        C5307e.m22540a(0, 7, c5303b);
        C5307e.m22540a(c5303b.m22506b() - 8, 7, c5303b);
        C5307e.m22540a(0, c5303b.m22506b() - 8, c5303b);
        C5307e.m22548b(7, 0, c5303b);
        C5307e.m22548b((c5303b.m22502a() - 7) - 1, 0, c5303b);
        C5307e.m22548b(7, c5303b.m22502a() - 7, c5303b);
    }

    /* renamed from: c */
    private static void m22553c(C5294j c5294j, C5303b c5303b) {
        if (c5294j.m22459a() >= 2) {
            c5294j = f17916c[c5294j.m22459a() - 1];
            for (int i : c5294j) {
                if (i >= 0) {
                    for (int i2 : c5294j) {
                        if (i2 >= 0 && C5307e.m22551b(c5303b.m22501a(i2, i))) {
                            C5307e.m22552c(i2 - 2, i - 2, c5303b);
                        }
                    }
                }
            }
        }
    }
}
