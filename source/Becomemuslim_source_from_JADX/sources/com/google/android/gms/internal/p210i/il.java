package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.il */
final class il {
    /* renamed from: d */
    private static boolean m20878d(byte b) {
        return b >= (byte) 0;
    }

    /* renamed from: e */
    private static boolean m20879e(byte b) {
        return b < (byte) -32;
    }

    /* renamed from: f */
    private static boolean m20880f(byte b) {
        return b < (byte) -16;
    }

    /* renamed from: g */
    private static boolean m20881g(byte b) {
        return b > (byte) -65;
    }

    /* renamed from: b */
    private static void m20875b(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    /* renamed from: b */
    private static void m20874b(byte b, byte b2, char[] cArr, int i) {
        if (b < (byte) -62 || il.m20881g(b2)) {
            throw fs.m20575h();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    /* renamed from: b */
    private static void m20873b(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (il.m20881g(b2) || ((b == (byte) -32 && b2 < (byte) -96) || ((b == (byte) -19 && b2 >= (byte) -96) || il.m20881g(b3)))) {
            throw fs.m20575h();
        }
        cArr[i] = (char) ((((b & 15) << 12) | ((b2 & 63) << 6)) | (b3 & 63));
    }

    /* renamed from: b */
    private static void m20872b(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (il.m20881g(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || il.m20881g(b3) || il.m20881g(b4)) {
            throw fs.m20575h();
        }
        b = ((((b & 7) << 18) | ((b2 & 63) << 12)) | ((b3 & 63) << 6)) | (b4 & 63);
        cArr[i] = (char) ((b >>> 10) + (byte) -64);
        cArr[i + 1] = (char) ((b & 1023) + (byte) 0);
    }
}
