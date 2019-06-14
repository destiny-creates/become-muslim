package org.spongycastle.crypto.params;

public class DESedeParameters extends DESParameters {
    /* renamed from: a */
    public static boolean m43361a(byte[] bArr, int i, int i2) {
        while (i < i2) {
            if (DESParameters.m40789a(bArr, i)) {
                return 1;
            }
            i += 8;
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m43362b(byte[] bArr, int i) {
        return bArr.length == 16 ? m43363c(bArr, i) : m43364d(bArr, i);
    }

    /* renamed from: c */
    public static boolean m43363c(byte[] bArr, int i) {
        boolean z = false;
        for (int i2 = i; i2 != i + 8; i2++) {
            if (bArr[i2] != bArr[i2 + 8]) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: d */
    public static boolean m43364d(byte[] bArr, int i) {
        boolean z = false;
        for (int i2 = i; i2 != i + 8; i2++) {
            int i3 = i2 + 8;
            if (bArr[i2] != bArr[i3]) {
                int i4 = i2 + 16;
                if (!(bArr[i2] == bArr[i4] || bArr[i3] == bArr[i4])) {
                    z = true;
                }
            }
        }
        return z;
    }
}
