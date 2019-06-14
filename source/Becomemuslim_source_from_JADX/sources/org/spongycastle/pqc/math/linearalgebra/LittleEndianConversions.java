package org.spongycastle.pqc.math.linearalgebra;

import com.facebook.imageutils.JfifUtil;

public final class LittleEndianConversions {
    private LittleEndianConversions() {
    }

    /* renamed from: a */
    public static int m29237a(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        i = (bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i2] & JfifUtil.MARKER_FIRST_BYTE) << 8);
        return ((bArr[i3 + 1] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (i | ((bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 16));
    }

    /* renamed from: a */
    public static int m29238a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (i2--; i2 >= 0; i2--) {
            i3 |= (bArr[i + i2] & JfifUtil.MARKER_FIRST_BYTE) << (i2 * 8);
        }
        return i3;
    }

    /* renamed from: a */
    public static byte[] m29241a(int i) {
        return new byte[]{(byte) i, (byte) (i >>> 8), (byte) (i >>> 16), (byte) (i >>> 24)};
    }

    /* renamed from: a */
    public static void m29239a(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) i;
        i2 = i3 + 1;
        bArr[i3] = (byte) (i >>> 8);
        i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 16);
        bArr[i3] = (byte) (i >>> 24);
    }

    /* renamed from: a */
    public static void m29240a(int i, byte[] bArr, int i2, int i3) {
        for (i3--; i3 >= 0; i3--) {
            bArr[i2 + i3] = (byte) (i >>> (i3 * 8));
        }
    }

    /* renamed from: a */
    public static byte[] m29242a(int[] iArr, int i) {
        int length = iArr.length;
        byte[] bArr = new byte[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 <= length - 2) {
            m29239a(iArr[i2], bArr, i3);
            i2++;
            i3 += 4;
        }
        m29240a(iArr[length - 1], bArr, i3, i - i3);
        return bArr;
    }

    /* renamed from: a */
    public static int[] m29243a(byte[] bArr) {
        int length = (bArr.length + 3) / 4;
        int length2 = bArr.length & 3;
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (i <= length - 2) {
            iArr[i] = m29237a(bArr, i2);
            i++;
            i2 += 4;
        }
        if (length2 != 0) {
            iArr[length - 1] = m29238a(bArr, i2, length2);
        } else {
            iArr[length - 1] = m29237a(bArr, i2);
        }
        return iArr;
    }
}
