package org.spongycastle.math.raw;

import android.support.v7.widget.LinearLayoutManager;
import java.math.BigInteger;
import org.spongycastle.util.Pack;

public abstract class Nat160 {
    /* renamed from: a */
    public static int m28864a(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        j = (j >>> 32) + ((((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j;
        j = (j >>> 32) + ((((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j;
        j = (j >>> 32) + ((((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j;
        j = (j >>> 32) + ((((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295));
        iArr3[4] = (int) j;
        return (int) (j >>> 32);
    }

    /* renamed from: b */
    public static int m28871b(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L)) + (((long) iArr3[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        j = (j >>> 32) + (((((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L)) + (((long) iArr3[1]) & 4294967295L));
        iArr3[1] = (int) j;
        j = (j >>> 32) + (((((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L)) + (((long) iArr3[2]) & 4294967295L));
        iArr3[2] = (int) j;
        j = (j >>> 32) + (((((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L)) + (((long) iArr3[3]) & 4294967295L));
        iArr3[3] = (int) j;
        j = (j >>> 32) + (((((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295)) + (((long) iArr3[4]) & 4294967295));
        iArr3[4] = (int) j;
        return (int) (j >>> 32);
    }

    /* renamed from: a */
    public static int[] m28868a() {
        return new int[5];
    }

    /* renamed from: b */
    public static int[] m28874b() {
        return new int[10];
    }

    /* renamed from: a */
    public static boolean m28867a(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return null;
            }
        }
        return 1;
    }

    /* renamed from: a */
    public static int[] m28869a(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 160) {
            throw new IllegalArgumentException();
        }
        int[] a = m28868a();
        int i = 0;
        while (bigInteger.signum() != 0) {
            int i2 = i + 1;
            a[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i = i2;
        }
        return a;
    }

    /* renamed from: a */
    public static int m28863a(int[] iArr, int i) {
        if (i == 0) {
            return iArr[0] & 1;
        }
        int i2 = i >> 5;
        if (i2 >= 0) {
            if (i2 < 5) {
                return (iArr[i2] >>> (i & 31)) & 1;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public static boolean m28873b(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
            int i2 = iArr[i] ^ LinearLayoutManager.INVALID_OFFSET;
            int i3 = LinearLayoutManager.INVALID_OFFSET ^ iArr2[i];
            if (i2 < i3) {
                return null;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m28866a(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m28872b(int[] iArr) {
        for (int i = 0; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return 1;
    }

    /* renamed from: c */
    public static void m28877c(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        long j2 = ((long) iArr2[3]) & 4294967295L;
        long j3 = ((long) iArr2[2]) & 4294967295L;
        long j4 = ((long) iArr2[4]) & 4294967295L;
        long j5 = ((long) iArr2[1]) & 4294967295L;
        long j6 = ((long) iArr[0]) & 4294967295L;
        long j7 = (j6 * j) + 0;
        iArr3[0] = (int) j7;
        long j8 = 32;
        j7 = (j7 >>> 32) + (j6 * j5);
        int i = 1;
        iArr3[1] = (int) j7;
        j7 = (j7 >>> 32) + (j6 * j3);
        iArr3[2] = (int) j7;
        j7 = (j7 >>> 32) + (j6 * j2);
        iArr3[3] = (int) j7;
        j7 = (j7 >>> 32) + (j6 * j4);
        iArr3[4] = (int) j7;
        int i2 = (int) (j7 >>> 32);
        int i3 = 5;
        iArr3[5] = i2;
        while (i < i3) {
            long j9 = ((long) iArr[i]) & 4294967295L;
            i2 = i + 0;
            long j10 = j9;
            j7 = ((j9 * j) + (((long) iArr3[i2]) & 4294967295L)) + 0;
            iArr3[i2] = (int) j7;
            i2 = i + 1;
            j7 = (j7 >>> j8) + ((j10 * j5) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j7;
            int i4 = i + 2;
            j7 = (j7 >>> 32) + ((j10 * j3) + (((long) iArr3[i4]) & 4294967295L));
            iArr3[i4] = (int) j7;
            int i5 = i + 3;
            j7 = (j7 >>> 32) + ((j10 * j2) + (((long) iArr3[i5]) & 4294967295L));
            iArr3[i5] = (int) j7;
            i5 = i + 4;
            j7 = (j7 >>> 32) + ((j10 * j4) + (((long) iArr3[i5]) & 4294967295L));
            iArr3[i5] = (int) j7;
            iArr3[i + 5] = (int) (j7 >>> 32);
            i = i2;
            j8 = 32;
            i3 = 5;
        }
    }

    /* renamed from: d */
    public static int m28879d(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = 4294967295L;
        long j2 = ((long) iArr2[0]) & 4294967295L;
        long j3 = ((long) iArr2[1]) & 4294967295L;
        long j4 = ((long) iArr2[2]) & 4294967295L;
        long j5 = ((long) iArr2[3]) & 4294967295L;
        long j6 = ((long) iArr2[4]) & 4294967295L;
        long j7 = 0;
        while (i < 5) {
            long j8 = j6;
            j6 = ((long) iArr[i]) & j;
            int i2 = i + 0;
            long j9 = j2;
            j = ((j6 * j2) + (((long) iArr3[i2]) & j)) + 0;
            iArr3[i2] = (int) j;
            int i3 = i + 1;
            j = (j >>> 32) + ((j6 * j3) + (((long) iArr3[i3]) & 4294967295L));
            iArr3[i3] = (int) j;
            int i4 = i + 2;
            long j10 = j3;
            j2 = (j >>> 32) + ((j6 * j4) + (((long) iArr3[i4]) & 4294967295L));
            iArr3[i4] = (int) j2;
            int i5 = i + 3;
            j2 = (j2 >>> 32) + ((j6 * j5) + (((long) iArr3[i5]) & 4294967295L));
            iArr3[i5] = (int) j2;
            int i6 = i + 4;
            j2 = (j2 >>> 32) + ((j6 * j8) + (((long) iArr3[i6]) & 4294967295L));
            iArr3[i6] = (int) j2;
            i += 5;
            j2 = (j2 >>> 32) + (j7 + (((long) iArr3[i]) & 4294967295L));
            iArr3[i] = (int) j2;
            j7 = j2 >>> 32;
            i = i3;
            j6 = j8;
            j2 = j9;
            j = 4294967295L;
            j3 = j10;
        }
        return (int) j7;
    }

    /* renamed from: a */
    public static long m28865a(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = ((long) i) & 4294967295L;
        long j2 = ((long) iArr[i2 + 0]) & 4294967295L;
        long j3 = ((j * j2) + (((long) iArr2[i3 + 0]) & 4294967295L)) + 0;
        iArr3[i4 + 0] = (int) j3;
        long j4 = ((long) iArr[i2 + 1]) & 4294967295L;
        j3 = (j3 >>> 32) + (((j * j4) + j2) + (((long) iArr2[i3 + 1]) & 4294967295L));
        iArr3[i4 + 1] = (int) j3;
        long j5 = ((long) iArr[i2 + 2]) & 4294967295L;
        long j6 = (j3 >>> 32) + (((j * j5) + j4) + (((long) iArr2[i3 + 2]) & 4294967295L));
        iArr3[i4 + 2] = (int) j6;
        j4 = ((long) iArr[i2 + 3]) & 4294967295L;
        long j7 = j4;
        j2 = (j6 >>> 32) + (((j * j4) + j5) + (((long) iArr2[i3 + 3]) & 4294967295L));
        iArr3[i4 + 3] = (int) j2;
        long j8 = ((long) iArr[i2 + 4]) & 4294967295L;
        j2 = (j2 >>> 32) + (((j * j8) + j7) + (((long) iArr2[i3 + 4]) & 4294967295L));
        iArr3[i4 + 4] = (int) j2;
        return (j2 >>> 32) + j8;
    }

    /* renamed from: a */
    public static int m28862a(int i, long j, int[] iArr, int i2) {
        int[] iArr2 = iArr;
        int i3 = i2;
        long j2 = ((long) i) & 4294967295L;
        long j3 = j & 4294967295L;
        int i4 = i3 + 0;
        long j4 = ((j2 * j3) + (((long) iArr2[i4]) & 4294967295L)) + 0;
        iArr2[i4] = (int) j4;
        long j5 = j >>> 32;
        j2 = (j2 * j5) + j3;
        int i5 = i3 + 1;
        j4 = (j4 >>> 32) + (j2 + (((long) iArr2[i5]) & 4294967295L));
        iArr2[i5] = (int) j4;
        i5 = i3 + 2;
        j2 = (j4 >>> 32) + (j5 + (((long) iArr2[i5]) & 4294967295L));
        iArr2[i5] = (int) j2;
        j5 = j2 >>> 32;
        int i6 = i3 + 3;
        j5 += ((long) iArr2[i6]) & 4294967295L;
        iArr2[i6] = (int) j5;
        if ((j5 >>> 32) == 0) {
            return 0;
        }
        return Nat.m29003a(5, iArr2, i3, 4);
    }

    /* renamed from: a */
    public static int m28861a(int i, int i2, int[] iArr, int i3) {
        i = ((long) i2) & -1;
        int i4 = i3 + 0;
        long j = (((((long) i) & 4294967295L) * i) + (((long) iArr[i4]) & 4294967295L)) + 0;
        iArr[i4] = (int) j;
        int i5 = i3 + 1;
        j = (j >>> 32) + (i + (((long) iArr[i5]) & 4294967295L));
        iArr[i5] = (int) j;
        i = j >>> 32;
        int i6 = i3 + 2;
        i += ((long) iArr[i6]) & 4294967295L;
        iArr[i6] = (int) i;
        if ((i >>> 32) == 0) {
            return 0;
        }
        return Nat.m29003a(5, iArr, i3, 3);
    }

    /* renamed from: b */
    public static int m28870b(int i, int i2, int[] iArr, int i3) {
        int i4 = i3 + 0;
        i = (((((long) i2) & -1) * (((long) i) & 4294967295L)) + (((long) iArr[i4]) & 4294967295L)) + 0;
        iArr[i4] = (int) i;
        int i5 = i3 + 1;
        i = (i >>> 32) + (4294967295L & ((long) iArr[i5]));
        iArr[i5] = (int) i;
        if ((i >>> 32) == 0) {
            return 0;
        }
        return Nat.m29003a(5, iArr, i3, 2);
    }

    /* renamed from: c */
    public static void m28876c(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 4;
        int i2 = 10;
        int i3 = 0;
        while (true) {
            int i4 = i - 1;
            long j2 = ((long) iArr[i]) & 4294967295L;
            j2 *= j2;
            i2--;
            iArr2[i2] = (i3 << 31) | ((int) (j2 >>> 33));
            i2--;
            iArr2[i2] = (int) (j2 >>> 1);
            int i5 = (int) j2;
            if (i4 <= 0) {
                long j3 = j * j;
                long j4 = (j3 >>> 33) | (((long) (i5 << 31)) & 4294967295L);
                iArr2[0] = (int) j3;
                j2 = ((long) iArr[1]) & 4294967295L;
                long j5 = ((long) iArr2[2]) & 4294967295L;
                j4 += j2 * j;
                int i6 = (int) j4;
                iArr2[1] = (i6 << 1) | (((int) (j3 >>> 32)) & 1);
                j5 += j4 >>> 32;
                j4 = ((long) iArr[2]) & 4294967295L;
                long j6 = j2;
                long j7 = ((long) iArr2[3]) & 4294967295L;
                long j8 = ((long) iArr2[4]) & 4294967295L;
                j5 += j4 * j;
                i = (int) j5;
                iArr2[2] = (i6 >>> 31) | (i << 1);
                i6 = i >>> 31;
                j3 = j7 + ((j5 >>> 32) + (j4 * j6));
                j8 += j3 >>> 32;
                long j9 = j;
                long j10 = ((long) iArr[3]) & 4294967295L;
                long j11 = j4;
                long j12 = ((long) iArr2[5]) & 4294967295L;
                long j13 = j8;
                long j14 = ((long) iArr2[6]) & 4294967295L;
                j3 = (j3 & 4294967295L) + (j10 * j9);
                i5 = (int) j3;
                iArr2[3] = i6 | (i5 << 1);
                j3 = j13 + ((j3 >>> 32) + (j10 * j6));
                j12 += (j3 >>> 32) + (j10 * j11);
                j14 += j12 >>> 32;
                j12 &= 4294967295L;
                long j15 = j10;
                j10 = ((long) iArr[4]) & 4294967295L;
                long j16 = ((long) iArr2[7]) & 4294967295L;
                long j17 = ((long) iArr2[8]) & 4294967295L;
                j3 = (j3 & 4294967295L) + (j10 * j9);
                int i7 = (int) j3;
                iArr2[4] = (i5 >>> 31) | (i7 << 1);
                j12 += (j3 >>> 32) + (j10 * j6);
                j14 += (j12 >>> 32) + (j10 * j11);
                j16 += (j14 >>> 32) + (j10 * j15);
                j17 += j16 >>> 32;
                int i8 = (int) j12;
                iArr2[5] = (i8 << 1) | (i7 >>> 31);
                int i9 = (int) j14;
                iArr2[6] = (i8 >>> 31) | (i9 << 1);
                int i10 = (int) j16;
                iArr2[7] = (i10 << 1) | (i9 >>> 31);
                int i11 = (int) j17;
                iArr2[8] = (i10 >>> 31) | (i11 << 1);
                iArr2[9] = (i11 >>> 31) | ((iArr2[9] + ((int) (j17 >> 32))) << 1);
                return;
            }
            i = i4;
            i3 = i5;
        }
    }

    /* renamed from: e */
    public static int m28881e(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        j = (j >> 32) + ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j;
        j = (j >> 32) + ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j;
        j = (j >> 32) + ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j;
        j = (j >> 32) + ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295));
        iArr3[4] = (int) j;
        return (int) (j >> 32);
    }

    /* renamed from: d */
    public static int m28878d(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
        iArr2[0] = (int) j;
        j = (j >> 32) + ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L));
        iArr2[1] = (int) j;
        j = (j >> 32) + ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L));
        iArr2[2] = (int) j;
        j = (j >> 32) + ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L));
        iArr2[3] = (int) j;
        j = (j >> 32) + ((((long) iArr2[4]) & 4294967295L) - (4294967295L & ((long) iArr[4])));
        iArr2[4] = (int) j;
        return (int) (j >> 32);
    }

    /* renamed from: c */
    public static BigInteger m28875c(int[] iArr) {
        byte[] bArr = new byte[20];
        for (int i = 0; i < 5; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.m29400a(i2, bArr, (4 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: d */
    public static void m28880d(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
    }
}
