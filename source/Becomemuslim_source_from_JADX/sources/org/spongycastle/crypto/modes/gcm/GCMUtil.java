package org.spongycastle.crypto.modes.gcm;

import android.support.v7.widget.LinearLayoutManager;
import org.spongycastle.util.Pack;

public abstract class GCMUtil {
    /* renamed from: a */
    private static final int[] f22411a = m27489b();

    /* renamed from: b */
    private static int[] m27489b() {
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            int i2 = 0;
            for (int i3 = 7; i3 >= 0; i3--) {
                if (((1 << i3) & i) != 0) {
                    i2 ^= -520093696 >>> (7 - i3);
                }
            }
            iArr[i] = i2;
        }
        return iArr;
    }

    /* renamed from: a */
    public static int[] m27485a() {
        int[] iArr = new int[4];
        iArr[0] = LinearLayoutManager.INVALID_OFFSET;
        return iArr;
    }

    /* renamed from: a */
    public static void m27482a(int[] iArr, byte[] bArr) {
        Pack.m29403a(iArr, bArr, 0);
    }

    /* renamed from: a */
    public static int[] m27486a(byte[] bArr) {
        int[] iArr = new int[4];
        Pack.m29402a(bArr, 0, iArr);
        return iArr;
    }

    /* renamed from: a */
    public static void m27481a(byte[] bArr, int[] iArr) {
        Pack.m29402a(bArr, 0, iArr);
    }

    /* renamed from: a */
    public static void m27479a(byte[] bArr, byte[] bArr2) {
        int[] a = m27486a(bArr);
        m27483a(a, m27486a(bArr2));
        m27482a(a, bArr);
    }

    /* renamed from: a */
    public static void m27483a(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = i;
        int i4 = i2;
        int i5 = iArr[2];
        int i6 = iArr[3];
        i = 0;
        i2 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i < 4) {
            int i10 = iArr2[i];
            int i11 = i6;
            i6 = i9;
            i9 = i8;
            i8 = i7;
            i7 = i2;
            for (i2 = 0; i2 < 32; i2++) {
                int i12 = i10 >> 31;
                i10 <<= 1;
                i7 ^= i3 & i12;
                i8 ^= i4 & i12;
                i9 ^= i5 & i12;
                i6 ^= i12 & i11;
                i11 = (i11 >>> 1) | (i5 << 31);
                i5 = (i5 >>> 1) | (i4 << 31);
                i4 = (i4 >>> 1) | (i3 << 31);
                i3 = (i3 >>> 1) ^ (((i11 << 31) >> 8) & -520093696);
            }
            i++;
            i2 = i7;
            i7 = i8;
            i8 = i9;
            i9 = i6;
            i6 = i11;
        }
        iArr[0] = i2;
        iArr[1] = i7;
        iArr[2] = i8;
        iArr[3] = i9;
    }

    /* renamed from: b */
    public static void m27488b(int[] iArr, int[] iArr2) {
        iArr2[0] = ((m27491d(iArr, iArr2) >> 8) & -520093696) ^ iArr2[0];
    }

    /* renamed from: c */
    public static void m27490c(int[] iArr, int[] iArr2) {
        iArr = m27478a(iArr, 8, iArr2);
        iArr2[0] = f22411a[iArr >>> 24] ^ iArr2[0];
    }

    /* renamed from: d */
    static int m27491d(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        iArr2[0] = i >>> 1;
        int i2 = i << 31;
        int i3 = iArr[1];
        iArr2[1] = i2 | (i3 >>> 1);
        i2 = i3 << 31;
        i3 = iArr[2];
        iArr2[2] = i2 | (i3 >>> 1);
        i2 = i3 << 31;
        iArr = iArr[3];
        iArr2[3] = i2 | (iArr >>> 1);
        return iArr << 31;
    }

    /* renamed from: a */
    static int m27478a(int[] iArr, int i, int[] iArr2) {
        int i2 = iArr[0];
        int i3 = 32 - i;
        iArr2[0] = i2 >>> i;
        int i4 = i2 << i3;
        int i5 = iArr[1];
        iArr2[1] = i4 | (i5 >>> i);
        i4 = i5 << i3;
        i5 = iArr[2];
        iArr2[2] = i4 | (i5 >>> i);
        i4 = i5 << i3;
        iArr = iArr[3];
        iArr2[3] = (iArr >>> i) | i4;
        return iArr << i3;
    }

    /* renamed from: b */
    public static void m27487b(byte[] bArr, byte[] bArr2) {
        int i = 0;
        do {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
            i++;
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
            i++;
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
            i++;
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
            i++;
        } while (i < 16);
    }

    /* renamed from: a */
    public static void m27480a(byte[] bArr, byte[] bArr2, int i, int i2) {
        while (true) {
            i2--;
            if (i2 >= 0) {
                bArr[i2] = (byte) (bArr[i2] ^ bArr2[i + i2]);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m27484a(int[] iArr, int[] iArr2, int[] iArr3) {
        iArr3[0] = iArr[0] ^ iArr2[0];
        iArr3[1] = iArr[1] ^ iArr2[1];
        iArr3[2] = iArr[2] ^ iArr2[2];
        iArr3[3] = iArr[3] ^ iArr2[3];
    }
}
