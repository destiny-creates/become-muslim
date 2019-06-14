package org.spongycastle.pqc.math.linearalgebra;

public final class ByteUtils {
    /* renamed from: a */
    private static final char[] f23363a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private ByteUtils() {
    }

    /* renamed from: a */
    public static boolean m29182a(byte[] bArr, byte[] bArr2) {
        boolean z = false;
        if (bArr == null) {
            if (bArr2 == null) {
                z = true;
            }
            return z;
        } else if (bArr2 == null || bArr.length != bArr2.length) {
            return false;
        } else {
            boolean z2 = true;
            for (int length = bArr.length - 1; length >= 0; length--) {
                z2 &= bArr[length] == bArr2[length] ? 1 : 0;
            }
            return z2;
        }
    }

    /* renamed from: b */
    public static byte[] m29185b(byte[] bArr, byte[] bArr2) {
        Object obj = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        System.arraycopy(bArr2, 0, obj, bArr.length, bArr2.length);
        return obj;
    }

    /* renamed from: a */
    public static byte[][] m29184a(byte[] bArr, int i) {
        if (i <= bArr.length) {
            byte[][] bArr2 = new byte[][]{new byte[i], new byte[(bArr.length - i)]};
            System.arraycopy(bArr, 0, bArr2[0], 0, i);
            System.arraycopy(bArr, i, bArr2[1], 0, bArr.length - i);
            return bArr2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /* renamed from: a */
    public static byte[] m29183a(byte[] bArr, int i, int i2) {
        i2 -= i;
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return obj;
    }
}
