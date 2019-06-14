package com.stripe.android;

import com.facebook.imageutils.JfifUtil;

/* compiled from: StripeTextUtils */
/* renamed from: com.stripe.android.u */
public class C5775u {
    /* renamed from: a */
    private static final char[] f19158a = "0123456789ABCDEF".toCharArray();

    /* renamed from: a */
    public static String m24416a(String str) {
        return C5775u.m24419b(str) ? null : str;
    }

    /* renamed from: b */
    public static boolean m24419b(String str) {
        if (str != null) {
            if (str.trim().length() != null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static String m24420c(String str) {
        if (C5775u.m24419b(str)) {
            return null;
        }
        return str.replaceAll("\\s|-", "");
    }

    /* renamed from: a */
    static boolean m24418a(String str, String... strArr) {
        if (str == null) {
            return false;
        }
        for (String startsWith : strArr) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    static java.lang.String m24421d(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.stripe.android.C5775u.m24419b(r4);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "SHA-1";	 Catch:{ NoSuchAlgorithmException -> 0x0023, UnsupportedEncodingException -> 0x0022 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0023, UnsupportedEncodingException -> 0x0022 }
        r2 = "UTF-8";	 Catch:{ NoSuchAlgorithmException -> 0x0023, UnsupportedEncodingException -> 0x0022 }
        r4 = r4.getBytes(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0023, UnsupportedEncodingException -> 0x0022 }
        r2 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x0023, UnsupportedEncodingException -> 0x0022 }
        r3 = r4.length;	 Catch:{ NoSuchAlgorithmException -> 0x0023, UnsupportedEncodingException -> 0x0022 }
        r0.update(r4, r2, r3);	 Catch:{ NoSuchAlgorithmException -> 0x0023, UnsupportedEncodingException -> 0x0022 }
        r4 = r0.digest();	 Catch:{ NoSuchAlgorithmException -> 0x0023, UnsupportedEncodingException -> 0x0022 }
        r4 = com.stripe.android.C5775u.m24417a(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0023, UnsupportedEncodingException -> 0x0022 }
        return r4;
    L_0x0022:
        return r1;
    L_0x0023:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.u.d(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static String m24417a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
            int i3 = i * 2;
            cArr[i3] = f19158a[i2 >>> 4];
            cArr[i3 + 1] = f19158a[i2 & 15];
        }
        return new String(cArr);
    }
}
