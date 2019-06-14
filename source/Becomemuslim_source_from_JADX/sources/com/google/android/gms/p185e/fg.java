package com.google.android.gms.p185e;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.imageutils.JfifUtil;

/* renamed from: com.google.android.gms.e.fg */
public final class fg {
    /* renamed from: a */
    public static String m8746a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            if ((b & 240) == 0) {
                stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            stringBuilder.append(Integer.toHexString(b & JfifUtil.MARKER_FIRST_BYTE));
        }
        return stringBuilder.toString().toUpperCase();
    }

    /* renamed from: a */
    public static byte[] m8747a(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[(length / 2)];
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 16);
                int digit2 = Character.digit(str.charAt(i + 1), 16);
                if (digit == -1 || digit2 == -1) {
                    throw new IllegalArgumentException("purported base16 string has illegal char");
                }
                bArr[i / 2] = (byte) ((digit << 4) + digit2);
            }
            return bArr;
        }
        throw new IllegalArgumentException("purported base16 string has odd number of characters");
    }
}
