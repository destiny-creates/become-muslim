package org.spongycastle.crypto.params;

public class DESParameters extends KeyParameter {
    /* renamed from: a */
    private static byte[] f31746a = new byte[]{(byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 31, (byte) 31, (byte) 31, (byte) 31, (byte) 14, (byte) 14, (byte) 14, (byte) 14, (byte) -32, (byte) -32, (byte) -32, (byte) -32, (byte) -15, (byte) -15, (byte) -15, (byte) -15, (byte) -2, (byte) -2, (byte) -2, (byte) -2, (byte) -2, (byte) -2, (byte) -2, (byte) -2, (byte) 1, (byte) -2, (byte) 1, (byte) -2, (byte) 1, (byte) -2, (byte) 1, (byte) -2, (byte) 31, (byte) -32, (byte) 31, (byte) -32, (byte) 14, (byte) -15, (byte) 14, (byte) -15, (byte) 1, (byte) -32, (byte) 1, (byte) -32, (byte) 1, (byte) -15, (byte) 1, (byte) -15, (byte) 31, (byte) -2, (byte) 31, (byte) -2, (byte) 14, (byte) -2, (byte) 14, (byte) -2, (byte) 1, (byte) 31, (byte) 1, (byte) 31, (byte) 1, (byte) 14, (byte) 1, (byte) 14, (byte) -32, (byte) -2, (byte) -32, (byte) -2, (byte) -15, (byte) -2, (byte) -15, (byte) -2, (byte) -2, (byte) 1, (byte) -2, (byte) 1, (byte) -2, (byte) 1, (byte) -2, (byte) 1, (byte) -32, (byte) 31, (byte) -32, (byte) 31, (byte) -15, (byte) 14, (byte) -15, (byte) 14, (byte) -32, (byte) 1, (byte) -32, (byte) 1, (byte) -15, (byte) 1, (byte) -15, (byte) 1, (byte) -2, (byte) 31, (byte) -2, (byte) 31, (byte) -2, (byte) 14, (byte) -2, (byte) 14, (byte) 31, (byte) 1, (byte) 31, (byte) 1, (byte) 14, (byte) 1, (byte) 14, (byte) 1, (byte) -2, (byte) -32, (byte) -2, (byte) -32, (byte) -2, (byte) -15, (byte) -2, (byte) -15};

    /* renamed from: a */
    public static boolean m40789a(byte[] bArr, int i) {
        if (bArr.length - i >= 8) {
            int i2 = 0;
            while (i2 < 16) {
                int i3 = 0;
                while (i3 < 8) {
                    if (bArr[i3 + i] != f31746a[(i2 * 8) + i3]) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                return 1;
            }
            return false;
        }
        throw new IllegalArgumentException("key material too short.");
    }

    /* renamed from: a */
    public static void m40788a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            bArr[i] = (byte) (((((b >> 7) ^ ((((((b >> 1) ^ (b >> 2)) ^ (b >> 3)) ^ (b >> 4)) ^ (b >> 5)) ^ (b >> 6))) ^ 1) & 1) | (b & 254));
        }
    }
}
