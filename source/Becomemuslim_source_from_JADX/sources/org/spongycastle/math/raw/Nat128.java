package org.spongycastle.math.raw;

import android.support.v7.widget.LinearLayoutManager;
import java.math.BigInteger;
import org.spongycastle.util.Pack;

public abstract class Nat128 {
    /* renamed from: a */
    public static int m28838a(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        j = (j >>> 32) + ((((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j;
        j = (j >>> 32) + ((((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j;
        j = (j >>> 32) + ((((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295));
        iArr3[3] = (int) j;
        return (int) (j >>> 32);
    }

    /* renamed from: b */
    public static int m28845b(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L)) + (((long) iArr3[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        j = (j >>> 32) + (((((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L)) + (((long) iArr3[1]) & 4294967295L));
        iArr3[1] = (int) j;
        j = (j >>> 32) + (((((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L)) + (((long) iArr3[2]) & 4294967295L));
        iArr3[2] = (int) j;
        j = (j >>> 32) + (((((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295)) + (((long) iArr3[3]) & 4294967295));
        iArr3[3] = (int) j;
        return (int) (j >>> 32);
    }

    /* renamed from: a */
    public static int[] m28843a() {
        return new int[4];
    }

    /* renamed from: b */
    public static long[] m28849b() {
        return new long[2];
    }

    /* renamed from: c */
    public static int[] m28855c() {
        return new int[8];
    }

    /* renamed from: d */
    public static long[] m28859d() {
        return new long[4];
    }

    /* renamed from: a */
    public static boolean m28840a(int[] iArr, int[] iArr2) {
        for (int i = 3; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return null;
            }
        }
        return 1;
    }

    /* renamed from: a */
    public static boolean m28842a(long[] jArr, long[] jArr2) {
        for (int i = 1; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static int[] m28844a(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        int[] a = m28843a();
        int i = 0;
        while (bigInteger.signum() != 0) {
            int i2 = i + 1;
            a[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i = i2;
        }
        return a;
    }

    /* renamed from: b */
    public static long[] m28850b(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        long[] b = m28849b();
        int i = 0;
        while (bigInteger.signum() != 0) {
            int i2 = i + 1;
            b[i] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i = i2;
        }
        return b;
    }

    /* renamed from: a */
    public static int m28837a(int[] iArr, int i) {
        if (i == 0) {
            return iArr[0] & 1;
        }
        int i2 = i >> 5;
        if (i2 >= 0) {
            if (i2 < 4) {
                return (iArr[i2] >>> (i & 31)) & 1;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public static boolean m28847b(int[] iArr, int[] iArr2) {
        for (int i = 3; i >= 0; i--) {
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
    public static boolean m28839a(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 4; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m28841a(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 2; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m28846b(int[] iArr) {
        for (int i = 0; i < 4; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return 1;
    }

    /* renamed from: b */
    public static boolean m28848b(long[] jArr) {
        for (int i = 0; i < 2; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return 1;
    }

    /* renamed from: c */
    public static void m28854c(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        int i = 1;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[3]) & 4294967295L;
        long j4 = ((long) iArr2[2]) & 4294967295L;
        long j5 = ((long) iArr[0]) & 4294967295L;
        long j6 = (j5 * j) + 0;
        iArr3[0] = (int) j6;
        long j7 = 32;
        j6 = (j6 >>> 32) + (j5 * j2);
        iArr3[1] = (int) j6;
        j6 = (j6 >>> 32) + (j5 * j4);
        iArr3[2] = (int) j6;
        j6 = (j6 >>> 32) + (j5 * j3);
        iArr3[3] = (int) j6;
        int i2 = (int) (j6 >>> 32);
        int i3 = 4;
        iArr3[4] = i2;
        while (i < i3) {
            j5 = ((long) iArr[i]) & 4294967295L;
            i2 = i + 0;
            j6 = ((j5 * j) + (((long) iArr3[i2]) & 4294967295L)) + 0;
            iArr3[i2] = (int) j6;
            i2 = i + 1;
            j6 = (j6 >>> j7) + ((j5 * j2) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j6;
            int i4 = i + 2;
            j6 = (j6 >>> 32) + ((j5 * j4) + (((long) iArr3[i4]) & 4294967295L));
            iArr3[i4] = (int) j6;
            int i5 = i + 3;
            j6 = (j6 >>> 32) + ((j5 * j3) + (((long) iArr3[i5]) & 4294967295L));
            iArr3[i5] = (int) j6;
            iArr3[i + 4] = (int) (j6 >>> 32);
            i = i2;
            j7 = 32;
            i3 = 4;
        }
    }

    /* renamed from: d */
    public static int m28857d(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = 4294967295L;
        long j2 = ((long) iArr2[0]) & 4294967295L;
        long j3 = ((long) iArr2[1]) & 4294967295L;
        long j4 = ((long) iArr2[2]) & 4294967295L;
        long j5 = ((long) iArr2[3]) & 4294967295L;
        long j6 = 0;
        while (i < 4) {
            long j7 = ((long) iArr[i]) & j;
            int i2 = i + 0;
            long j8 = j2;
            j = ((j7 * j2) + (((long) iArr3[i2]) & j)) + 0;
            iArr3[i2] = (int) j;
            int i3 = i + 1;
            j = (j >>> 32) + ((j7 * j3) + (((long) iArr3[i3]) & 4294967295L));
            iArr3[i3] = (int) j;
            int i4 = i + 2;
            long j9 = j3;
            j2 = (j >>> 32) + ((j7 * j4) + (((long) iArr3[i4]) & 4294967295L));
            iArr3[i4] = (int) j2;
            int i5 = i + 3;
            j2 = (j2 >>> 32) + ((j7 * j5) + (((long) iArr3[i5]) & 4294967295L));
            iArr3[i5] = (int) j2;
            i += 4;
            j2 = (j2 >>> 32) + (j6 + (((long) iArr3[i]) & 4294967295L));
            iArr3[i] = (int) j2;
            j6 = j2 >>> 32;
            i = i3;
            j = 4294967295L;
            j2 = j8;
            j3 = j9;
        }
        return (int) j6;
    }

    /* renamed from: c */
    public static void m28853c(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 3;
        int i2 = 8;
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
                long j6 = j;
                long j7 = ((long) iArr2[3]) & 4294967295L;
                long j8 = ((long) iArr2[4]) & 4294967295L;
                j5 += j4 * j6;
                i = (int) j5;
                iArr2[2] = (i6 >>> 31) | (i << 1);
                i6 = i >>> 31;
                j5 = j7 + ((j5 >>> 32) + (j4 * j2));
                j8 += j5 >>> 32;
                long j9 = j4;
                long j10 = ((long) iArr[3]) & 4294967295L;
                long j11 = ((long) iArr2[5]) & 4294967295L;
                long j12 = ((long) iArr2[6]) & 4294967295L;
                j5 = (j5 & 4294967295L) + (j10 * j6);
                int i7 = (int) j5;
                iArr2[3] = (i7 << 1) | i6;
                j8 += (j5 >>> 32) + (j2 * j10);
                j10 = j11 + ((j8 >>> 32) + (j10 * j9));
                j12 += j10 >>> 32;
                long j13 = 4294967295L & j10;
                int i8 = (int) j8;
                iArr2[4] = (i7 >>> 31) | (i8 << 1);
                i7 = i8 >>> 31;
                i8 = (int) j13;
                iArr2[5] = i7 | (i8 << 1);
                i7 = i8 >>> 31;
                i8 = (int) j12;
                iArr2[6] = i7 | (i8 << 1);
                iArr2[7] = (i8 >>> 31) | ((iArr2[7] + ((int) (j12 >> 32))) << 1);
                return;
            }
            i = i4;
            i3 = i5;
        }
    }

    /* renamed from: e */
    public static int m28860e(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        j = (j >> 32) + ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j;
        j = (j >> 32) + ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j;
        j = (j >> 32) + ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295));
        iArr3[3] = (int) j;
        return (int) (j >> 32);
    }

    /* renamed from: d */
    public static int m28856d(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
        iArr2[0] = (int) j;
        j = (j >> 32) + ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L));
        iArr2[1] = (int) j;
        j = (j >> 32) + ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L));
        iArr2[2] = (int) j;
        j = (j >> 32) + ((((long) iArr2[3]) & 4294967295L) - (4294967295L & ((long) iArr[3])));
        iArr2[3] = (int) j;
        return (int) (j >> 32);
    }

    /* renamed from: c */
    public static BigInteger m28851c(int[] iArr) {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 4; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.m29400a(i2, bArr, (3 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: c */
    public static BigInteger m28852c(long[] jArr) {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 2; i++) {
            long j = jArr[i];
            if (j != 0) {
                Pack.m29401a(j, bArr, (1 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: d */
    public static void m28858d(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
    }
}
