package com.facebook.common.util;

import com.facebook.imageutils.JfifUtil;

public class Hex {
    private static final byte[] DIGITS = new byte[103];
    private static final char[] FIRST_CHAR = new char[256];
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] SECOND_CHAR = new char[256];

    static {
        for (int i = 0; i < 256; i++) {
            FIRST_CHAR[i] = HEX_DIGITS[(i >> 4) & 15];
            SECOND_CHAR[i] = HEX_DIGITS[i & 15];
        }
        for (int i2 = 0; i2 <= 70; i2++) {
            DIGITS[i2] = (byte) -1;
        }
        for (byte b = (byte) 0; b < (byte) 10; b = (byte) (b + 1)) {
            DIGITS[b + 48] = b;
        }
        for (int i3 = 0; i3 < 6; i3 = (byte) (i3 + 1)) {
            byte b2 = (byte) (i3 + 10);
            DIGITS[i3 + 65] = b2;
            DIGITS[i3 + 97] = b2;
        }
    }

    public static String byte2Hex(int i) {
        if (i > JfifUtil.MARKER_FIRST_BYTE || i < 0) {
            throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(FIRST_CHAR[i]));
        stringBuilder.append(String.valueOf(SECOND_CHAR[i]));
        return stringBuilder.toString();
    }

    public static String encodeHex(byte[] bArr, boolean z) {
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & JfifUtil.MARKER_FIRST_BYTE;
            if (i2 == 0 && z) {
                break;
            }
            int i3 = i + 1;
            cArr[i] = FIRST_CHAR[i2];
            i = i3 + 1;
            cArr[i3] = SECOND_CHAR[i2];
        }
        return new String(cArr, 0, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] decodeHex(java.lang.String r10) {
        /*
        r0 = r10.length();
        r1 = r0 & 1;
        if (r1 != 0) goto L_0x0059;
    L_0x0008:
        r1 = r0 >> 1;
        r1 = new byte[r1];
        r2 = 0;
        r3 = 0;
        r4 = 0;
    L_0x000f:
        r5 = 1;
        if (r3 >= r0) goto L_0x003e;
    L_0x0012:
        r6 = r3 + 1;
        r3 = r10.charAt(r3);
        r7 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r3 <= r7) goto L_0x001d;
    L_0x001c:
        goto L_0x003f;
    L_0x001d:
        r8 = DIGITS;
        r3 = r8[r3];
        r8 = -1;
        if (r3 != r8) goto L_0x0025;
    L_0x0024:
        goto L_0x003f;
    L_0x0025:
        r9 = r6 + 1;
        r6 = r10.charAt(r6);
        if (r6 <= r7) goto L_0x002e;
    L_0x002d:
        goto L_0x003f;
    L_0x002e:
        r7 = DIGITS;
        r6 = r7[r6];
        if (r6 != r8) goto L_0x0035;
    L_0x0034:
        goto L_0x003f;
    L_0x0035:
        r3 = r3 << 4;
        r3 = r3 | r6;
        r3 = (byte) r3;
        r1[r4] = r3;
        r4 = r4 + r5;
        r3 = r9;
        goto L_0x000f;
    L_0x003e:
        r5 = 0;
    L_0x003f:
        if (r5 != 0) goto L_0x0042;
    L_0x0041:
        return r1;
    L_0x0042:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Invalid hexadecimal digit: ";
        r1.append(r2);
        r1.append(r10);
        r10 = r1.toString();
        r0.<init>(r10);
        throw r0;
    L_0x0059:
        r10 = new java.lang.IllegalArgumentException;
        r0 = "Odd number of characters.";
        r10.<init>(r0);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.util.Hex.decodeHex(java.lang.String):byte[]");
    }

    public static byte[] hexStringToByteArray(String str) {
        return decodeHex(str.replaceAll(" ", ""));
    }
}
