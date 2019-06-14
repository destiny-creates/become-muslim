package com.google.p217b.p222b;

import com.facebook.imageutils.JfifUtil;
import com.google.p217b.C5210b;
import com.google.p217b.C5310i;
import java.lang.reflect.Array;

/* compiled from: HybridBinarizer */
/* renamed from: com.google.b.b.j */
public final class C7893j extends C6857h {
    /* renamed from: a */
    private C5202b f29483a;

    /* renamed from: a */
    private static int m38421a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public C7893j(C5310i c5310i) {
        super(c5310i);
    }

    /* renamed from: b */
    public C5202b mo4865b() {
        if (this.f29483a != null) {
            return this.f29483a;
        }
        C5310i a = m22048a();
        int b = a.m22566b();
        int c = a.m22567c();
        if (b < 40 || c < 40) {
            this.f29483a = super.mo4865b();
        } else {
            byte[] a2 = a.mo4872a();
            int i = b >> 3;
            if ((b & 7) != 0) {
                i++;
            }
            int i2 = i;
            i = c >> 3;
            if ((c & 7) != 0) {
                i++;
            }
            int i3 = i;
            int[][] a3 = C7893j.m38424a(a2, i2, i3, b, c);
            C5202b c5202b = new C5202b(b, c);
            C7893j.m38423a(a2, i2, i3, b, c, a3, c5202b);
            this.f29483a = c5202b;
        }
        return this.f29483a;
    }

    /* renamed from: a */
    public C5210b mo4864a(C5310i c5310i) {
        return new C7893j(c5310i);
    }

    /* renamed from: a */
    private static void m38423a(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, C5202b c5202b) {
        int i5 = i;
        int i6 = i2;
        int i7 = i4 - 8;
        int i8 = i3 - 8;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = i9 << 3;
            int i11 = i10 > i7 ? i7 : i10;
            int a = C7893j.m38421a(i9, 2, i6 - 3);
            int i12 = 0;
            while (i12 < i5) {
                i10 = i12 << 3;
                int i13 = i10 > i8 ? i8 : i10;
                i10 = C7893j.m38421a(i12, 2, i5 - 3);
                int i14 = 0;
                for (int i15 = -2; i15 <= 2; i15++) {
                    int[] iArr2 = iArr[a + i15];
                    i14 += (((iArr2[i10 - 2] + iArr2[i10 - 1]) + iArr2[i10]) + iArr2[i10 + 1]) + iArr2[i10 + 2];
                }
                int i16 = i12;
                C7893j.m38422a(bArr, i13, i11, i14 / 25, i3, c5202b);
                i12 = i16 + 1;
            }
        }
    }

    /* renamed from: a */
    private static void m38422a(byte[] bArr, int i, int i2, int i3, int i4, C5202b c5202b) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & JfifUtil.MARKER_FIRST_BYTE) <= i3) {
                    c5202b.m22004b(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    /* renamed from: a */
    private static int[][] m38424a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = 8;
        int i8 = i4 - 8;
        int i9 = i3 - 8;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i6, i5});
        int i10 = 0;
        while (i10 < i6) {
            int i11 = i10 << 3;
            if (i11 > i8) {
                i11 = i8;
            }
            int i12 = 0;
            while (i12 < i5) {
                int i13 = i12 << 3;
                if (i13 > i9) {
                    i13 = i9;
                }
                int i14 = (i11 * i3) + i13;
                int i15 = JfifUtil.MARKER_FIRST_BYTE;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                while (i16 < i7) {
                    i13 = i18;
                    i18 = i15;
                    i15 = 0;
                    while (i15 < i7) {
                        i7 = bArr[i14 + i15] & JfifUtil.MARKER_FIRST_BYTE;
                        i17 += i7;
                        if (i7 < i18) {
                            i18 = i7;
                        }
                        if (i7 > i13) {
                            i13 = i7;
                        }
                        i15++;
                        i5 = i;
                        i7 = 8;
                    }
                    if (i13 - i18 > 24) {
                        while (true) {
                            i16++;
                            i14 += i3;
                            i5 = 8;
                            if (i16 >= 8) {
                                break;
                            }
                            i7 = 0;
                            while (i7 < i5) {
                                i17 += bArr[i14 + i7] & JfifUtil.MARKER_FIRST_BYTE;
                                i7++;
                                i5 = 8;
                            }
                        }
                    }
                    i16++;
                    i14 += i3;
                    i15 = i18;
                    i5 = i;
                    i7 = 8;
                    i18 = i13;
                }
                i5 = i17 >> 6;
                if (i18 - i15 <= 24) {
                    i5 = i15 / 2;
                    if (i10 > 0 && i12 > 0) {
                        i7 = i10 - 1;
                        i17 = i12 - 1;
                        i7 = ((iArr[i7][i12] + (iArr[i10][i17] * 2)) + iArr[i7][i17]) / 4;
                        if (i15 < i7) {
                            i5 = i7;
                        }
                    }
                }
                iArr[i10][i12] = i5;
                i12++;
                i5 = i;
                i7 = 8;
            }
            i10++;
            i5 = i;
            i7 = 8;
        }
        return iArr;
    }
}
