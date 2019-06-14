package org.spongycastle.math.raw;

import android.support.v7.widget.LinearLayoutManager;
import java.math.BigInteger;
import org.spongycastle.util.Pack;

public abstract class Nat224 {
    /* renamed from: a */
    public static int m28919a(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        j = (j >>> 32) + ((((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j;
        j = (j >>> 32) + ((((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j;
        j = (j >>> 32) + ((((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j;
        j = (j >>> 32) + ((((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j;
        j = (j >>> 32) + ((((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L));
        iArr3[5] = (int) j;
        j = (j >>> 32) + ((((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295));
        iArr3[6] = (int) j;
        return (int) (j >>> 32);
    }

    /* renamed from: b */
    public static int m28925b(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L)) + (((long) iArr3[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        j = (j >>> 32) + (((((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L)) + (((long) iArr3[1]) & 4294967295L));
        iArr3[1] = (int) j;
        j = (j >>> 32) + (((((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L)) + (((long) iArr3[2]) & 4294967295L));
        iArr3[2] = (int) j;
        j = (j >>> 32) + (((((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L)) + (((long) iArr3[3]) & 4294967295L));
        iArr3[3] = (int) j;
        j = (j >>> 32) + (((((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L)) + (((long) iArr3[4]) & 4294967295L));
        iArr3[4] = (int) j;
        j = (j >>> 32) + (((((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L)) + (((long) iArr3[5]) & 4294967295L));
        iArr3[5] = (int) j;
        j = (j >>> 32) + (((((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295)) + (((long) iArr3[6]) & 4294967295));
        iArr3[6] = (int) j;
        return (int) (j >>> 32);
    }

    /* renamed from: a */
    public static void m28921a(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
    }

    /* renamed from: a */
    public static int[] m28923a() {
        return new int[7];
    }

    /* renamed from: b */
    public static int[] m28928b() {
        return new int[14];
    }

    /* renamed from: b */
    public static boolean m28927b(int[] iArr, int[] iArr2) {
        for (int i = 6; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return null;
            }
        }
        return 1;
    }

    /* renamed from: a */
    public static int[] m28924a(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 224) {
            throw new IllegalArgumentException();
        }
        int[] a = m28923a();
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
    public static int m28918a(int[] iArr, int i) {
        if (i == 0) {
            return iArr[0] & 1;
        }
        int i2 = i >> 5;
        if (i2 >= 0) {
            if (i2 < 7) {
                return (iArr[i2] >>> (i & 31)) & 1;
            }
        }
        return 0;
    }

    /* renamed from: c */
    public static boolean m28931c(int[] iArr, int[] iArr2) {
        for (int i = 6; i >= 0; i--) {
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
    public static boolean m28922a(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 7; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m28926b(int[] iArr) {
        for (int i = 0; i < 7; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return 1;
    }

    /* renamed from: c */
    public static void m28930c(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        long j2 = ((long) iArr2[2]) & 4294967295L;
        long j3 = ((long) iArr2[3]) & 4294967295L;
        long j4 = ((long) iArr2[1]) & 4294967295L;
        long j5 = ((long) iArr2[4]) & 4294967295L;
        long j6 = ((long) iArr2[5]) & 4294967295L;
        long j7 = ((long) iArr2[6]) & 4294967295L;
        long j8 = ((long) iArr[0]) & 4294967295L;
        long j9 = (j8 * j) + 0;
        long j10 = j;
        iArr3[0] = (int) j9;
        j = (j9 >>> 32) + (j8 * j4);
        int i = 1;
        iArr3[1] = (int) j;
        j = (j >>> 32) + (j8 * j2);
        iArr3[2] = (int) j;
        j = (j >>> 32) + (j8 * j3);
        iArr3[3] = (int) j;
        j = (j >>> 32) + (j8 * j5);
        iArr3[4] = (int) j;
        j = (j >>> 32) + (j8 * j6);
        iArr3[5] = (int) j;
        j = (j >>> 32) + (j8 * j7);
        iArr3[6] = (int) j;
        int i2 = 7;
        iArr3[7] = (int) (j >>> 32);
        while (i < i2) {
            j = ((long) iArr[i]) & 4294967295L;
            int i3 = i + 0;
            long j11 = j;
            long j12 = ((j * j10) + (((long) iArr3[i3]) & 4294967295L)) + 0;
            iArr3[i3] = (int) j12;
            int i4 = i + 1;
            j12 = (j12 >>> 32) + ((j11 * j4) + (((long) iArr3[i4]) & 4294967295L));
            iArr3[i4] = (int) j12;
            i2 = i + 2;
            long j13 = j2;
            j12 = (j12 >>> 32) + ((j11 * j2) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j12;
            i2 = i + 3;
            j12 = (j12 >>> 32) + ((j11 * j3) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j12;
            i2 = i + 4;
            j12 = (j12 >>> 32) + ((j11 * j5) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j12;
            i2 = i + 5;
            j12 = (j12 >>> 32) + ((j11 * j6) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j12;
            i2 = i + 6;
            j12 = (j12 >>> 32) + ((j11 * j7) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j12;
            iArr3[i + 7] = (int) (j12 >>> 32);
            i = i4;
            j2 = j13;
            i2 = 7;
        }
    }

    /* renamed from: d */
    public static int m28932d(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[1]) & 4294967295L;
        long j2 = ((long) iArr2[2]) & 4294967295L;
        long j3 = ((long) iArr2[3]) & 4294967295L;
        long j4 = ((long) iArr2[4]) & 4294967295L;
        long j5 = ((long) iArr2[0]) & 4294967295L;
        long j6 = ((long) iArr2[5]) & 4294967295L;
        long j7 = ((long) iArr2[6]) & 4294967295L;
        long j8 = 0;
        int i = 0;
        while (i < 7) {
            long j9 = j7;
            j7 = ((long) iArr[i]) & 4294967295L;
            int i2 = i + 0;
            long j10 = j4;
            j4 = ((j7 * j5) + (((long) iArr3[i2]) & 4294967295L)) + 0;
            iArr3[i2] = (int) j4;
            i2 = i + 1;
            long j11 = j;
            j4 = (j4 >>> 32) + ((j7 * j) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j4;
            int i3 = i + 2;
            long j12 = j2;
            j = (j4 >>> 32) + ((j7 * j2) + (((long) iArr3[i3]) & 4294967295L));
            iArr3[i3] = (int) j;
            int i4 = i + 3;
            j = (j >>> 32) + ((j7 * j3) + (((long) iArr3[i4]) & 4294967295L));
            iArr3[i4] = (int) j;
            int i5 = i + 4;
            long j13 = j3;
            j = (j >>> 32) + ((j7 * j10) + (((long) iArr3[i5]) & 4294967295L));
            iArr3[i5] = (int) j;
            int i6 = i + 5;
            j = (j >>> 32) + ((j7 * j6) + (((long) iArr3[i6]) & 4294967295L));
            iArr3[i6] = (int) j;
            i5 = i + 6;
            j = (j >>> 32) + ((j7 * j9) + (((long) iArr3[i5]) & 4294967295L));
            iArr3[i5] = (int) j;
            i += 7;
            j7 = (j >>> 32) + (j8 + (((long) iArr3[i]) & 4294967295L));
            iArr3[i] = (int) j7;
            j8 = j7 >>> 32;
            j7 = j9;
            i = i2;
            j4 = j10;
            j = j11;
            j2 = j12;
            j3 = j13;
        }
        return (int) j8;
    }

    /* renamed from: a */
    public static long m28920a(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
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
        j4 = ((long) iArr[i2 + 4]) & 4294967295L;
        long j8 = j4;
        j2 = (j2 >>> 32) + (((j * j4) + j7) + (((long) iArr2[i3 + 4]) & 4294967295L));
        iArr3[i4 + 4] = (int) j2;
        j4 = ((long) iArr[i2 + 5]) & 4294967295L;
        long j9 = j4;
        j2 = (j2 >>> 32) + (((j * j4) + j8) + (((long) iArr2[i3 + 5]) & 4294967295L));
        iArr3[i4 + 5] = (int) j2;
        long j10 = ((long) iArr[i2 + 6]) & 4294967295L;
        j2 = (j2 >>> 32) + (((j * j10) + j9) + (((long) iArr2[i3 + 6]) & 4294967295L));
        iArr3[i4 + 6] = (int) j2;
        return (j2 >>> 32) + j10;
    }

    /* renamed from: a */
    public static int m28917a(int i, long j, int[] iArr, int i2) {
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
        return Nat.m29003a(7, iArr2, i3, 4);
    }

    /* renamed from: a */
    public static int m28916a(int i, int i2, int[] iArr, int i3) {
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
        return Nat.m29003a(7, iArr, i3, 3);
    }

    /* renamed from: d */
    public static void m28934d(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 6;
        int i2 = 14;
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
                int i7 = (int) j5;
                iArr2[2] = (i7 << 1) | (i6 >>> 31);
                i6 = i7 >>> 31;
                j3 = j7 + ((j5 >>> 32) + (j4 * j6));
                j8 += j3 >>> 32;
                long j9 = j;
                long j10 = ((long) iArr[3]) & 4294967295L;
                long j11 = j4;
                long j12 = ((long) iArr2[5]) & 4294967295L;
                long j13 = ((long) iArr2[6]) & 4294967295L;
                j3 = (j3 & 4294967295L) + (j10 * j9);
                i3 = (int) j3;
                iArr2[3] = i6 | (i3 << 1);
                i6 = i3 >>> 31;
                j8 += (j3 >>> 32) + (j10 * j6);
                j3 = j12 + ((j8 >>> 32) + (j10 * j11));
                j13 += j3 >>> 32;
                long j14 = j10;
                j10 = ((long) iArr[4]) & 4294967295L;
                long j15 = ((long) iArr2[7]) & 4294967295L;
                long j16 = j3 & 4294967295L;
                j2 = ((long) iArr2[8]) & 4294967295L;
                j5 = (j8 & 4294967295L) + (j10 * j9);
                int i8 = (int) j5;
                iArr2[4] = i6 | (i8 << 1);
                j5 = j16 + ((j5 >>> 32) + (j10 * j6));
                j13 += (j5 >>> 32) + (j10 * j11);
                j15 += (j13 >>> 32) + (j10 * j14);
                j2 += j15 >>> 32;
                j15 &= 4294967295L;
                long j17 = j10;
                j10 = ((long) iArr[5]) & 4294967295L;
                long j18 = j13 & 4294967295L;
                long j19 = ((long) iArr2[9]) & 4294967295L;
                long j20 = ((long) iArr2[10]) & 4294967295L;
                j5 = (j5 & 4294967295L) + (j10 * j9);
                int i9 = (int) j5;
                iArr2[5] = (i8 >>> 31) | (i9 << 1);
                j5 = j18 + ((j5 >>> 32) + (j10 * j6));
                j15 += (j5 >>> 32) + (j10 * j11);
                j2 += (j15 >>> 32) + (j10 * j14);
                j4 = j15 & 4294967295L;
                long j21 = j19 + ((j2 >>> 32) + (j10 * j17));
                j8 = j2 & 4294967295L;
                j20 += j21 >>> 32;
                j21 &= 4294967295L;
                long j22 = j10;
                j10 = ((long) iArr[6]) & 4294967295L;
                long j23 = j20;
                long j24 = ((long) iArr2[11]) & 4294967295L;
                long j25 = ((long) iArr2[12]) & 4294967295L;
                j5 = (j5 & 4294967295L) + (j10 * j9);
                int i10 = (int) j5;
                iArr2[6] = (i9 >>> 31) | (i10 << 1);
                i9 = i10 >>> 31;
                j4 += (j5 >>> 32) + (j10 * j6);
                j8 += (j4 >>> 32) + (j10 * j11);
                j20 = ((j8 >>> 32) + (j10 * j14)) + j21;
                j3 = j23 + ((j20 >>> 32) + (j10 * j17));
                j10 = j24 + ((j3 >>> 32) + (j10 * j22));
                j25 += j10 >>> 32;
                i10 = (int) j4;
                iArr2[7] = i9 | (i10 << 1);
                i9 = i10 >>> 31;
                i10 = (int) j8;
                iArr2[8] = i9 | (i10 << 1);
                i9 = i10 >>> 31;
                i10 = (int) j20;
                iArr2[9] = i9 | (i10 << 1);
                i9 = i10 >>> 31;
                i10 = (int) j3;
                iArr2[10] = i9 | (i10 << 1);
                int i11 = (int) j10;
                iArr2[11] = (i10 >>> 31) | (i11 << 1);
                i9 = i11 >>> 31;
                i11 = (int) j25;
                iArr2[12] = i9 | (i11 << 1);
                iArr2[13] = (i11 >>> 31) | ((iArr2[13] + ((int) (j25 >> 32))) << 1);
                return;
            }
            i = i4;
            i3 = i5;
        }
    }

    /* renamed from: e */
    public static int m28936e(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        j = (j >> 32) + ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j;
        j = (j >> 32) + ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j;
        j = (j >> 32) + ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j;
        j = (j >> 32) + ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j;
        j = (j >> 32) + ((((long) iArr[5]) & 4294967295L) - (((long) iArr2[5]) & 4294967295L));
        iArr3[5] = (int) j;
        j = (j >> 32) + ((((long) iArr[6]) & 4294967295L) - (((long) iArr2[6]) & 4294967295));
        iArr3[6] = (int) j;
        return (int) (j >> 32);
    }

    /* renamed from: e */
    public static int m28935e(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
        iArr2[0] = (int) j;
        j = (j >> 32) + ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L));
        iArr2[1] = (int) j;
        j = (j >> 32) + ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L));
        iArr2[2] = (int) j;
        j = (j >> 32) + ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L));
        iArr2[3] = (int) j;
        j = (j >> 32) + ((((long) iArr2[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L));
        iArr2[4] = (int) j;
        j = (j >> 32) + ((((long) iArr2[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L));
        iArr2[5] = (int) j;
        j = (j >> 32) + ((((long) iArr2[6]) & 4294967295L) - (4294967295L & ((long) iArr[6])));
        iArr2[6] = (int) j;
        return (int) (j >> 32);
    }

    /* renamed from: c */
    public static BigInteger m28929c(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i = 0; i < 7; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.m29400a(i2, bArr, (6 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: d */
    public static void m28933d(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
    }
}
