package org.spongycastle.pqc.math.ntru.util;

import com.facebook.imageutils.JfifUtil;

public class ArrayEncoder {
    /* renamed from: a */
    private static final int[] f23423a = new int[]{0, 0, 0, 1, 1, 1, -1, -1};
    /* renamed from: b */
    private static final int[] f23424b = new int[]{0, 1, -1, 0, 1, -1, 0, 1};
    /* renamed from: c */
    private static final int[] f23425c = new int[]{1, 1, 1, 0, 0, 0, 1, 0, 1};
    /* renamed from: d */
    private static final int[] f23426d = new int[]{1, 1, 1, 1, 0, 0, 0, 1, 0};
    /* renamed from: e */
    private static final int[] f23427e = new int[]{1, 0, 1, 0, 0, 1, 1, 1, 0};

    /* renamed from: a */
    public static byte[] m29332a(int[] iArr, int i) {
        i = 31 - Integer.numberOfLeadingZeros(i);
        byte[] bArr = new byte[(((iArr.length * i) + 7) / 8)];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < iArr.length) {
            int i5 = i3;
            for (i3 = 0; i3 < i; i3++) {
                bArr[i4] = (byte) ((((iArr[i2] >> i3) & 1) << i5) | bArr[i4]);
                if (i5 == 7) {
                    i4++;
                    i5 = 0;
                } else {
                    i5++;
                }
            }
            i2++;
            i3 = i5;
        }
        return bArr;
    }

    /* renamed from: a */
    public static int[] m29334a(byte[] bArr, int i, int i2) {
        int[] iArr = new int[i];
        i2 = 31 - Integer.numberOfLeadingZeros(i2);
        i *= i2;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (i3 > 0 && i3 % i2 == 0) {
                i4++;
            }
            iArr[i4] = iArr[i4] + (m29335b(bArr, i3) << (i3 % i2));
            i3++;
        }
        return iArr;
    }

    /* renamed from: a */
    public static int[] m29333a(byte[] bArr, int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length * 8) {
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            i2 = ((m29335b(bArr, i2) * 4) + (m29335b(bArr, i4) * 2)) + m29335b(bArr, i5);
            i4 = i3 + 1;
            iArr[i3] = f23423a[i2];
            i3 = i4 + 1;
            iArr[i4] = f23424b[i2];
            if (i3 > i - 2) {
                break;
            }
            i2 = i6;
        }
        return iArr;
    }

    /* renamed from: a */
    public static byte[] m29331a(int[] iArr) {
        byte[] bArr = new byte[(((((iArr.length * 3) + 1) / 2) + 7) / 8)];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < (iArr.length / 2) * 2) {
            int i4 = i + 1;
            i = iArr[i] + 1;
            int i5 = i4 + 1;
            i4 = iArr[i4] + 1;
            if (i == 0) {
                if (i4 == 0) {
                    throw new IllegalStateException("Illegal encoding!");
                }
            }
            i = (i * 3) + i4;
            int[] iArr2 = new int[]{f23425c[i], f23426d[i], f23427e[i]};
            for (i = 0; i < 3; i++) {
                bArr[i3] = (byte) (bArr[i3] | (iArr2[i] << i2));
                if (i2 == 7) {
                    i3++;
                    i2 = 0;
                } else {
                    i2++;
                }
            }
            i = i5;
        }
        return bArr;
    }

    /* renamed from: b */
    private static int m29335b(byte[] bArr, int i) {
        return ((bArr[i / 8] & JfifUtil.MARKER_FIRST_BYTE) >> (i % 8)) & 1;
    }
}
