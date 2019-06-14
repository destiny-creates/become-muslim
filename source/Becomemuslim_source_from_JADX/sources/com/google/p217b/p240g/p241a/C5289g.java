package com.google.p217b.p240g.p241a;

/* compiled from: FormatInformation */
/* renamed from: com.google.b.g.a.g */
final class C5289g {
    /* renamed from: a */
    private static final int[][] f17859a = new int[][]{new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};
    /* renamed from: b */
    private final C5288f f17860b;
    /* renamed from: c */
    private final byte f17861c;

    private C5289g(int i) {
        this.f17860b = C5288f.m22438a((i >> 3) & 3);
        this.f17861c = (byte) (i & 7);
    }

    /* renamed from: a */
    static int m22440a(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    /* renamed from: b */
    static C5289g m22441b(int i, int i2) {
        C5289g c = C5289g.m22442c(i, i2);
        if (c != null) {
            return c;
        }
        return C5289g.m22442c(i ^ 21522, i2 ^ 21522);
    }

    /* renamed from: c */
    private static C5289g m22442c(int i, int i2) {
        int[][] iArr = f17859a;
        int length = iArr.length;
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        while (i3 < length) {
            int[] iArr2 = iArr[i3];
            int i6 = iArr2[0];
            if (i6 != i) {
                if (i6 != i2) {
                    int a = C5289g.m22440a(i, i6);
                    if (a < i4) {
                        i5 = iArr2[1];
                        i4 = a;
                    }
                    if (i != i2) {
                        i6 = C5289g.m22440a(i2, i6);
                        if (i6 < i4) {
                            i5 = iArr2[1];
                            i4 = i6;
                        }
                    }
                    i3++;
                }
            }
            return new C5289g(iArr2[1]);
        }
        return i4 <= 3 ? new C5289g(i5) : 0;
    }

    /* renamed from: a */
    C5288f m22443a() {
        return this.f17860b;
    }

    /* renamed from: b */
    byte m22444b() {
        return this.f17861c;
    }

    public int hashCode() {
        return (this.f17860b.ordinal() << 3) | this.f17861c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5289g)) {
            return false;
        }
        C5289g c5289g = (C5289g) obj;
        if (this.f17860b == c5289g.f17860b && this.f17861c == c5289g.f17861c) {
            return true;
        }
        return false;
    }
}
