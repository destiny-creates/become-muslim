package org.spongycastle.pqc.crypto.rainbow.util;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Array;

public class RainbowUtil {
    /* renamed from: a */
    public static int[] m29133a(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            iArr[i] = bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
        }
        return iArr;
    }

    /* renamed from: b */
    public static short[] m29138b(byte[] bArr) {
        short[] sArr = new short[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            sArr[i] = (short) (bArr[i] & JfifUtil.MARKER_FIRST_BYTE);
        }
        return sArr;
    }

    /* renamed from: a */
    public static short[][] m29135a(byte[][] bArr) {
        short[][] sArr = (short[][]) Array.newInstance(short.class, new int[]{bArr.length, bArr[0].length});
        for (int i = 0; i < bArr.length; i++) {
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                sArr[i][i2] = (short) (bArr[i][i2] & JfifUtil.MARKER_FIRST_BYTE);
            }
        }
        return sArr;
    }

    /* renamed from: a */
    public static short[][][] m29137a(byte[][][] bArr) {
        short[][][] sArr = (short[][][]) Array.newInstance(short.class, new int[]{bArr.length, bArr[0].length, bArr[0][0].length});
        for (int i = 0; i < bArr.length; i++) {
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                for (int i3 = 0; i3 < bArr[0][0].length; i3++) {
                    sArr[i][i2][i3] = (short) (bArr[i][i2][i3] & JfifUtil.MARKER_FIRST_BYTE);
                }
            }
        }
        return sArr;
    }

    /* renamed from: a */
    public static byte[] m29131a(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = (byte) iArr[i];
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m29132a(short[] sArr) {
        byte[] bArr = new byte[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            bArr[i] = (byte) sArr[i];
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[][] m29134a(short[][] sArr) {
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, new int[]{sArr.length, sArr[0].length});
        for (int i = 0; i < sArr.length; i++) {
            for (int i2 = 0; i2 < sArr[0].length; i2++) {
                bArr[i][i2] = (byte) sArr[i][i2];
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[][][] m29136a(short[][][] sArr) {
        byte[][][] bArr = (byte[][][]) Array.newInstance(byte.class, new int[]{sArr.length, sArr[0].length, sArr[0][0].length});
        for (int i = 0; i < sArr.length; i++) {
            for (int i2 = 0; i2 < sArr[0].length; i2++) {
                for (int i3 = 0; i3 < sArr[0][0].length; i3++) {
                    bArr[i][i2][i3] = (byte) sArr[i][i2][i3];
                }
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static boolean m29128a(short[] sArr, short[] sArr2) {
        if (sArr.length != sArr2.length) {
            return false;
        }
        boolean z = true;
        for (int length = sArr.length - 1; length >= 0; length--) {
            z &= sArr[length] == sArr2[length] ? 1 : 0;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m29129a(short[][] sArr, short[][] sArr2) {
        if (sArr.length != sArr2.length) {
            return null;
        }
        boolean z = true;
        for (int length = sArr.length - 1; length >= 0; length--) {
            z &= m29128a(sArr[length], sArr2[length]);
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m29130a(short[][][] sArr, short[][][] sArr2) {
        if (sArr.length != sArr2.length) {
            return null;
        }
        boolean z = true;
        for (int length = sArr.length - 1; length >= 0; length--) {
            z &= m29129a(sArr[length], sArr2[length]);
        }
        return z;
    }
}
