package com.google.android.gms.internal.ads;

import android.util.Base64;

public final class agh {
    /* renamed from: a */
    public static String m18405a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, z ? 11 : 2);
    }

    /* renamed from: a */
    public static byte[] m18406a(String str, boolean z) {
        byte[] decode = Base64.decode(str, z ? 11 : 2);
        if (decode.length != 0 || str.length() <= 0) {
            return decode;
        }
        String str2 = "Unable to decode ";
        str = String.valueOf(str);
        throw new IllegalArgumentException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }
}
