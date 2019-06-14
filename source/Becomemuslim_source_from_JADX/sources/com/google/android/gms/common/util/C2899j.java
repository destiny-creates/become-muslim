package com.google.android.gms.common.util;

import com.facebook.imageutils.JfifUtil;

/* renamed from: com.google.android.gms.common.util.j */
public class C2899j {
    /* renamed from: a */
    private static final char[] f7388a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: b */
    private static final char[] f7389b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    public static String m8446a(byte[] bArr) {
        char[] cArr = new char[(bArr.length << 1)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & JfifUtil.MARKER_FIRST_BYTE;
            int i3 = i + 1;
            cArr[i] = f7389b[i2 >>> 4];
            i = i3 + 1;
            cArr[i3] = f7389b[i2 & 15];
        }
        return new String(cArr);
    }
}
