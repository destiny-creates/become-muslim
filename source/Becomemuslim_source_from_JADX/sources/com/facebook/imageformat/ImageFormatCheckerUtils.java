package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;

public class ImageFormatCheckerUtils {
    public static byte[] asciiBytes(String str) {
        Preconditions.checkNotNull(str);
        try {
            return str.getBytes("ASCII");
        } catch (String str2) {
            throw new RuntimeException("ASCII not found!", str2);
        }
    }

    public static boolean startsWithPattern(byte[] bArr, byte[] bArr2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkNotNull(bArr2);
        if (bArr2.length > bArr.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return 1;
    }

    public static int indexOfPattern(byte[] bArr, int i, byte[] bArr2, int i2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkNotNull(bArr2);
        if (i2 > i) {
            return -1;
        }
        int i3 = 0;
        byte b = bArr2[0];
        i -= i2;
        while (i3 <= i) {
            int i4 = 1;
            if (bArr[i3] != b) {
                while (true) {
                    i3++;
                    if (i3 > i || bArr[i3] == b) {
                        break;
                    }
                }
            }
            if (i3 <= i) {
                int i5 = i3 + 1;
                int i6 = (i5 + i2) - 1;
                while (i5 < i6 && bArr[i5] == bArr2[i4]) {
                    i5++;
                    i4++;
                }
                if (i5 == i6) {
                    return i3;
                }
            }
            i3++;
        }
        return -1;
    }

    private ImageFormatCheckerUtils() {
    }
}
