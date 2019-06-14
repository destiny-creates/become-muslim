package com.google.p217b.p240g.p243c;

/* compiled from: MaskUtil */
/* renamed from: com.google.b.g.c.d */
final class C5306d {
    /* renamed from: a */
    static int m22530a(C5303b c5303b) {
        return C5306d.m22531a(c5303b, true) + C5306d.m22531a(c5303b, false);
    }

    /* renamed from: b */
    static int m22535b(C5303b c5303b) {
        byte[][] c = c5303b.m22507c();
        int b = c5303b.m22506b();
        c5303b = c5303b.m22502a();
        int i = 0;
        int i2 = 0;
        while (i < c5303b - 1) {
            byte[] bArr = c[i];
            int i3 = i2;
            i2 = 0;
            while (i2 < b - 1) {
                byte b2 = bArr[i2];
                int i4 = i2 + 1;
                if (b2 == bArr[i4]) {
                    int i5 = i + 1;
                    if (b2 == c[i5][i2] && b2 == c[i5][i4]) {
                        i3++;
                    }
                }
                i2 = i4;
            }
            i++;
            i2 = i3;
        }
        return i2 * 3;
    }

    /* renamed from: c */
    static int m22536c(C5303b c5303b) {
        byte[][] c = c5303b.m22507c();
        int b = c5303b.m22506b();
        c5303b = c5303b.m22502a();
        int i = 0;
        int i2 = 0;
        while (i < c5303b) {
            int i3 = i2;
            i2 = 0;
            while (i2 < b) {
                byte[] bArr = c[i];
                int i4 = i2 + 6;
                if (i4 < b && bArr[i2] == (byte) 1 && bArr[i2 + 1] == (byte) 0 && bArr[i2 + 2] == (byte) 1 && bArr[i2 + 3] == (byte) 1 && bArr[i2 + 4] == (byte) 1 && bArr[i2 + 5] == (byte) 0 && bArr[i4] == (byte) 1 && (C5306d.m22533a(bArr, i2 - 4, i2) || C5306d.m22533a(bArr, i2 + 7, i2 + 11))) {
                    i3++;
                }
                int i5 = i + 6;
                if (i5 < c5303b && c[i][i2] == (byte) 1 && c[i + 1][i2] == (byte) 0 && c[i + 2][i2] == (byte) 1 && c[i + 3][i2] == (byte) 1 && c[i + 4][i2] == (byte) 1 && c[i + 5][i2] == (byte) 0 && c[i5][i2] == (byte) 1 && (C5306d.m22534a(c, i2, i - 4, i) || C5306d.m22534a(c, i2, i + 7, i + 11))) {
                    i3++;
                }
                i2++;
            }
            i++;
            i2 = i3;
        }
        return i2 * 40;
    }

    /* renamed from: a */
    private static boolean m22533a(byte[] bArr, int i, int i2) {
        i2 = Math.min(i2, bArr.length);
        for (i = Math.max(i, 0); i < i2; i++) {
            if (bArr[i] == (byte) 1) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m22534a(byte[][] bArr, int i, int i2, int i3) {
        i3 = Math.min(i3, bArr.length);
        for (i2 = Math.max(i2, 0); i2 < i3; i2++) {
            if (bArr[i2][i] == (byte) 1) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    static int m22537d(C5303b c5303b) {
        byte[][] c = c5303b.m22507c();
        int b = c5303b.m22506b();
        int a = c5303b.m22502a();
        int i = 0;
        int i2 = 0;
        while (i < a) {
            byte[] bArr = c[i];
            int i3 = i2;
            for (i2 = 0; i2 < b; i2++) {
                if (bArr[i2] == (byte) 1) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        int a2 = c5303b.m22502a() * c5303b.m22506b();
        return ((Math.abs((i2 << 1) - a2) * 10) / a2) * 10;
    }

    /* renamed from: a */
    static boolean m22532a(int i, int i2, int i3) {
        switch (i) {
            case 0:
                i = (i3 + i2) & 1;
                break;
            case 1:
                i = i3 & 1;
                break;
            case 2:
                i = i2 % 3;
                break;
            case 3:
                i = (i3 + i2) % 3;
                break;
            case 4:
                i = ((i3 / 2) + (i2 / 3)) & 1;
                break;
            case 5:
                i3 *= i2;
                i = (i3 & 1) + (i3 % 3);
                break;
            case 6:
                i3 *= i2;
                i = ((i3 & 1) + (i3 % 3)) & 1;
                break;
            case 7:
                i = (((i3 * i2) % 3) + ((i3 + i2) & 1)) & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i)));
        }
        if (i == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static int m22531a(C5303b c5303b, boolean z) {
        int a = z ? c5303b.m22502a() : c5303b.m22506b();
        int b = z ? c5303b.m22506b() : c5303b.m22502a();
        c5303b = c5303b.m22507c();
        int i = 0;
        int i2 = 0;
        while (i < a) {
            int i3 = i2;
            i2 = 0;
            int i4 = 0;
            byte b2 = (byte) -1;
            while (i2 < b) {
                byte b3 = z ? c5303b[i][i2] : c5303b[i2][i];
                if (b3 == b2) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i3 += (i4 - 5) + 3;
                    }
                    i4 = 1;
                    b2 = b3;
                }
                i2++;
            }
            if (i4 >= 5) {
                i3 += (i4 - 5) + 3;
            }
            i2 = i3;
            i++;
        }
        return i2;
    }
}
