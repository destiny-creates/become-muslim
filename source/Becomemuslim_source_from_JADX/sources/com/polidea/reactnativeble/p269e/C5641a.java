package com.polidea.reactnativeble.p269e;

import android.util.Base64;

/* compiled from: Base64Converter */
/* renamed from: com.polidea.reactnativeble.e.a */
public class C5641a {
    /* renamed from: a */
    public static String m23969a(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    /* renamed from: a */
    public static byte[] m23970a(String str) {
        return Base64.decode(str, 2);
    }
}
