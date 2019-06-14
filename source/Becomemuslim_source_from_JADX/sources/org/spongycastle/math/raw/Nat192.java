package org.spongycastle.math.raw;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.imageutils.JfifUtil;
import java.math.BigInteger;
import org.spongycastle.util.Pack;

public abstract class Nat192 {
    /* renamed from: a */
    public static int m28887a(int[] iArr, int[] iArr2, int[] iArr3) {
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
        j = (j >>> 32) + ((((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295));
        iArr3[5] = (int) j;
        return (int) (j >>> 32);
    }

    /* renamed from: b */
    public static int m28896b(int[] iArr, int[] iArr2, int[] iArr3) {
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
        j = (j >>> 32) + (((((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295)) + (((long) iArr3[5]) & 4294967295));
        iArr3[5] = (int) j;
        return (int) (j >>> 32);
    }

    /* renamed from: a */
    public static int m28886a(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        i3 = i2 + 0;
        long j = (((long) i3) & 4294967295L) + ((((long) iArr[i + 0]) & 4294967295L) + (((long) iArr2[i3]) & 4294967295L));
        iArr2[i3] = (int) j;
        int i4 = i2 + 1;
        j = (j >>> 32) + ((((long) iArr[i + 1]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L));
        iArr2[i4] = (int) j;
        i4 = i2 + 2;
        j = (j >>> 32) + ((((long) iArr[i + 2]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L));
        iArr2[i4] = (int) j;
        i4 = i2 + 3;
        j = (j >>> 32) + ((((long) iArr[i + 3]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L));
        iArr2[i4] = (int) j;
        i4 = i2 + 4;
        j = (j >>> 32) + ((((long) iArr[i + 4]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L));
        iArr2[i4] = (int) j;
        i2 += 5;
        j = (j >>> 32) + ((((long) iArr[i + 5]) & 4294967295) + (4294967295L & ((long) iArr2[i2])));
        iArr2[i2] = (int) j;
        return (int) (j >>> 32);
    }

    /* renamed from: a */
    public static int m28885a(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i + 0;
        int i4 = i2 + 0;
        long j = ((((long) iArr[i3]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L)) + 0;
        int i5 = (int) j;
        iArr[i3] = i5;
        iArr2[i4] = i5;
        i4 = i + 1;
        int i6 = i2 + 1;
        j = (j >>> 32) + ((((long) iArr[i4]) & 4294967295L) + (((long) iArr2[i6]) & 4294967295L));
        i5 = (int) j;
        iArr[i4] = i5;
        iArr2[i6] = i5;
        i4 = i + 2;
        i6 = i2 + 2;
        j = (j >>> 32) + ((((long) iArr[i4]) & 4294967295L) + (((long) iArr2[i6]) & 4294967295L));
        i5 = (int) j;
        iArr[i4] = i5;
        iArr2[i6] = i5;
        i4 = i + 3;
        i6 = i2 + 3;
        j = (j >>> 32) + ((((long) iArr[i4]) & 4294967295L) + (((long) iArr2[i6]) & 4294967295L));
        i5 = (int) j;
        iArr[i4] = i5;
        iArr2[i6] = i5;
        i4 = i + 4;
        i6 = i2 + 4;
        j = (j >>> 32) + ((((long) iArr[i4]) & 4294967295L) + (((long) iArr2[i6]) & 4294967295L));
        i5 = (int) j;
        iArr[i4] = i5;
        iArr2[i6] = i5;
        i += 5;
        i2 += 5;
        j = (j >>> 32) + ((((long) iArr[i]) & 4294967295L) + (4294967295L & ((long) iArr2[i2])));
        int i7 = (int) j;
        iArr[i] = i7;
        iArr2[i2] = i7;
        return (int) (j >>> 32);
    }

    /* renamed from: a */
    public static int[] m28894a() {
        return new int[6];
    }

    /* renamed from: b */
    public static long[] m28902b() {
        return new long[3];
    }

    /* renamed from: c */
    public static int[] m28910c() {
        return new int[12];
    }

    /* renamed from: d */
    public static long[] m28914d() {
        return new long[6];
    }

    /* renamed from: a */
    public static boolean m28890a(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        boolean b = m28899b(iArr, i, iArr2, i2);
        if (b) {
            m28904c(iArr, i, iArr2, i2, iArr3, i3);
        } else {
            m28904c(iArr2, i2, iArr, i, iArr3, i3);
        }
        return b;
    }

    /* renamed from: a */
    public static boolean m28891a(int[] iArr, int[] iArr2) {
        for (int i = 5; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return null;
            }
        }
        return 1;
    }

    /* renamed from: a */
    public static boolean m28893a(long[] jArr, long[] jArr2) {
        for (int i = 2; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return null;
            }
        }
        return 1;
    }

    /* renamed from: a */
    public static int[] m28895a(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > JfifUtil.MARKER_SOFn) {
            throw new IllegalArgumentException();
        }
        int[] a = m28894a();
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
    public static long[] m28903b(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > JfifUtil.MARKER_SOFn) {
            throw new IllegalArgumentException();
        }
        long[] b = m28902b();
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
    public static int m28884a(int[] iArr, int i) {
        if (i == 0) {
            return iArr[0] & 1;
        }
        int i2 = i >> 5;
        if (i2 >= 0) {
            if (i2 < 6) {
                return (iArr[i2] >>> (i & 31)) & 1;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public static boolean m28900b(int[] iArr, int[] iArr2) {
        for (int i = 5; i >= 0; i--) {
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

    /* renamed from: b */
    public static boolean m28899b(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 5; i3 >= 0; i3--) {
            int i4 = iArr[i + i3] ^ LinearLayoutManager.INVALID_OFFSET;
            int i5 = LinearLayoutManager.INVALID_OFFSET ^ iArr2[i2 + i3];
            if (i4 < i5) {
                return null;
            }
            if (i4 > i5) {
                return true;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m28889a(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 6; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m28892a(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 3; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m28898b(int[] iArr) {
        for (int i = 0; i < 6; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return 1;
    }

    /* renamed from: b */
    public static boolean m28901b(long[] jArr) {
        for (int i = 0; i < 3; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return 1;
    }

    /* renamed from: c */
    public static void m28909c(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        long j2 = ((long) iArr2[2]) & 4294967295L;
        long j3 = ((long) iArr2[3]) & 4294967295L;
        long j4 = ((long) iArr2[1]) & 4294967295L;
        long j5 = ((long) iArr2[4]) & 4294967295L;
        long j6 = ((long) iArr2[5]) & 4294967295L;
        long j7 = ((long) iArr[0]) & 4294967295L;
        long j8 = (j7 * j) + 0;
        long j9 = j;
        iArr3[0] = (int) j8;
        j = (j8 >>> 32) + (j7 * j4);
        int i = 1;
        iArr3[1] = (int) j;
        j = (j >>> 32) + (j7 * j2);
        iArr3[2] = (int) j;
        j = (j >>> 32) + (j7 * j3);
        iArr3[3] = (int) j;
        j = (j >>> 32) + (j7 * j5);
        iArr3[4] = (int) j;
        j = (j >>> 32) + (j7 * j6);
        iArr3[5] = (int) j;
        int i2 = 6;
        iArr3[6] = (int) (j >>> 32);
        while (i < i2) {
            j = ((long) iArr[i]) & 4294967295L;
            int i3 = i + 0;
            long j10 = j;
            long j11 = ((j * j9) + (((long) iArr3[i3]) & 4294967295L)) + 0;
            iArr3[i3] = (int) j11;
            int i4 = i + 1;
            j11 = (j11 >>> 32) + ((j10 * j4) + (((long) iArr3[i4]) & 4294967295L));
            iArr3[i4] = (int) j11;
            i2 = i + 2;
            long j12 = j2;
            j11 = (j11 >>> 32) + ((j10 * j2) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j11;
            i2 = i + 3;
            j11 = (j11 >>> 32) + ((j10 * j3) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j11;
            i2 = i + 4;
            j11 = (j11 >>> 32) + ((j10 * j5) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j11;
            i2 = i + 5;
            j11 = (j11 >>> 32) + ((j10 * j6) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j11;
            iArr3[i + 6] = (int) (j11 >>> 32);
            i = i4;
            j2 = j12;
            i2 = 6;
        }
    }

    /* renamed from: b */
    public static void m28897b(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2 + 0]) & 4294967295L;
        long j2 = ((long) iArr2[i2 + 1]) & 4294967295L;
        long j3 = ((long) iArr2[i2 + 2]) & 4294967295L;
        long j4 = ((long) iArr2[i2 + 3]) & 4294967295L;
        long j5 = ((long) iArr2[i2 + 4]) & 4294967295L;
        long j6 = ((long) iArr2[i2 + 5]) & 4294967295L;
        long j7 = ((long) iArr[i + 0]) & 4294967295L;
        long j8 = (j7 * j) + 0;
        long j9 = j;
        iArr3[i3 + 0] = (int) j8;
        long j10 = (j8 >>> 32) + (j7 * j2);
        long j11 = j2;
        iArr3[i3 + 1] = (int) j10;
        j10 = (j10 >>> 32) + (j7 * j3);
        iArr3[i3 + 2] = (int) j10;
        j10 = (j10 >>> 32) + (j7 * j4);
        iArr3[i3 + 3] = (int) j10;
        j10 = (j10 >>> 32) + (j7 * j5);
        iArr3[i3 + 4] = (int) j10;
        j10 = (j10 >>> 32) + (j7 * j6);
        iArr3[i3 + 5] = (int) j10;
        iArr3[i3 + 6] = (int) (j10 >>> 32);
        int i4 = 1;
        int i5 = i3;
        int i6 = 1;
        while (i6 < 6) {
            i5 += i4;
            j2 = ((long) iArr[i + i6]) & 4294967295L;
            int i7 = i5 + 0;
            j = ((j2 * j9) + (((long) iArr3[i7]) & 4294967295L)) + 0;
            iArr3[i7] = (int) j;
            i7 = i5 + 1;
            int i8 = i6;
            j = (j >>> 32) + ((j2 * j11) + (((long) iArr3[i7]) & 4294967295L));
            iArr3[i7] = (int) j;
            i6 = i5 + 2;
            j = (j >>> 32) + ((j2 * j3) + (((long) iArr3[i6]) & 4294967295L));
            iArr3[i6] = (int) j;
            i6 = i5 + 3;
            j = (j >>> 32) + ((j2 * j4) + (((long) iArr3[i6]) & 4294967295L));
            iArr3[i6] = (int) j;
            i6 = i5 + 4;
            j = (j >>> 32) + ((j2 * j5) + (((long) iArr3[i6]) & 4294967295L));
            iArr3[i6] = (int) j;
            i6 = i5 + 5;
            j = (j >>> 32) + ((j2 * j6) + (((long) iArr3[i6]) & 4294967295L));
            iArr3[i6] = (int) j;
            iArr3[i5 + 6] = (int) (j >>> 32);
            i6 = i8 + 1;
            i4 = 1;
        }
    }

    /* renamed from: d */
    public static int m28912d(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[1]) & 4294967295L;
        long j2 = ((long) iArr2[2]) & 4294967295L;
        long j3 = ((long) iArr2[3]) & 4294967295L;
        long j4 = ((long) iArr2[4]) & 4294967295L;
        long j5 = ((long) iArr2[0]) & 4294967295L;
        long j6 = ((long) iArr2[5]) & 4294967295L;
        long j7 = 0;
        int i = 0;
        while (i < 6) {
            long j8 = j6;
            j6 = ((long) iArr[i]) & 4294967295L;
            int i2 = i + 0;
            long j9 = j4;
            j4 = ((j6 * j5) + (((long) iArr3[i2]) & 4294967295L)) + 0;
            iArr3[i2] = (int) j4;
            i2 = i + 1;
            long j10 = j;
            j4 = (j4 >>> 32) + ((j6 * j) + (((long) iArr3[i2]) & 4294967295L));
            iArr3[i2] = (int) j4;
            int i3 = i + 2;
            long j11 = j2;
            j = (j4 >>> 32) + ((j6 * j2) + (((long) iArr3[i3]) & 4294967295L));
            iArr3[i3] = (int) j;
            int i4 = i + 3;
            j = (j >>> 32) + ((j6 * j3) + (((long) iArr3[i4]) & 4294967295L));
            iArr3[i4] = (int) j;
            int i5 = i + 4;
            long j12 = j3;
            j = (j >>> 32) + ((j6 * j9) + (((long) iArr3[i5]) & 4294967295L));
            iArr3[i5] = (int) j;
            i5 = i + 5;
            j = (j >>> 32) + ((j6 * j8) + (((long) iArr3[i5]) & 4294967295L));
            iArr3[i5] = (int) j;
            i += 6;
            j6 = (j >>> 32) + (j7 + (((long) iArr3[i]) & 4294967295L));
            iArr3[i] = (int) j6;
            j7 = j6 >>> 32;
            j6 = j8;
            i = i2;
            j4 = j9;
            j = j10;
            j2 = j11;
            j3 = j12;
        }
        return (int) j7;
    }

    /* renamed from: a */
    public static long m28888a(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
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
        long j9 = ((long) iArr[i2 + 5]) & 4294967295L;
        j2 = (j2 >>> 32) + (((j * j9) + j8) + (((long) iArr2[i3 + 5]) & 4294967295L));
        iArr3[i4 + 5] = (int) j2;
        return (j2 >>> 32) + j9;
    }

    /* renamed from: a */
    public static int m28883a(int i, long j, int[] iArr, int i2) {
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
        return Nat.m29003a(6, iArr2, i3, 4);
    }

    /* renamed from: a */
    public static int m28882a(int i, int i2, int[] iArr, int i3) {
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
        return Nat.m29003a(6, iArr, i3, 3);
    }

    /* renamed from: c */
    public static void m28908c(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 5;
        int i2 = 12;
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
                iArr2[4] = (i8 << 1) | i6;
                j5 = j16 + ((j5 >>> 32) + (j10 * j6));
                j13 += (j5 >>> 32) + (j10 * j11);
                j15 += (j13 >>> 32) + (j10 * j14);
                j13 &= 4294967295L;
                j2 += j15 >>> 32;
                j15 &= 4294967295L;
                long j17 = j10;
                j10 = ((long) iArr[5]) & 4294967295L;
                long j18 = ((long) iArr2[9]) & 4294967295L;
                long j19 = ((long) iArr2[10]) & 4294967295L;
                j5 = (j5 & 4294967295L) + (j10 * j9);
                int i9 = (int) j5;
                iArr2[5] = (i8 >>> 31) | (i9 << 1);
                i8 = i9 >>> 31;
                j13 += (j5 >>> 32) + (j10 * j6);
                j15 += (j13 >>> 32) + (j10 * j11);
                j2 += (j15 >>> 32) + (j10 * j14);
                j10 = j18 + ((j2 >>> 32) + (j10 * j17));
                j19 += j10 >>> 32;
                i9 = (int) j13;
                iArr2[6] = i8 | (i9 << 1);
                i8 = i9 >>> 31;
                i9 = (int) j15;
                iArr2[7] = i8 | (i9 << 1);
                i8 = i9 >>> 31;
                i9 = (int) j2;
                iArr2[8] = i8 | (i9 << 1);
                int i10 = (int) j10;
                iArr2[9] = (i10 << 1) | (i9 >>> 31);
                int i11 = (int) j19;
                iArr2[10] = (i10 >>> 31) | (i11 << 1);
                iArr2[11] = ((iArr2[11] + ((int) (j19 >> 32))) << 1) | (i11 >>> 31);
                return;
            }
            i = i4;
            i3 = i5;
        }
    }

    /* renamed from: c */
    public static void m28907c(int[] iArr, int i, int[] iArr2, int i2) {
        long j = 4294967295L;
        long j2 = ((long) iArr[i + 0]) & 4294967295L;
        int i3 = 12;
        int i4 = 5;
        int i5 = 0;
        while (true) {
            int i6 = i4 - 1;
            long j3 = ((long) iArr[i + i4]) & j;
            j3 *= j3;
            i3--;
            iArr2[i2 + i3] = ((int) (j3 >>> 33)) | (i5 << 31);
            i3--;
            iArr2[i2 + i3] = (int) (j3 >>> 1);
            i5 = (int) j3;
            if (i6 <= 0) {
                long j4 = j2 * j2;
                long j5 = (((long) (i5 << 31)) & 4294967295L) | (j4 >>> 33);
                iArr2[i2 + 0] = (int) j4;
                long j6 = ((long) iArr[i + 1]) & 4294967295L;
                i4 = i2 + 2;
                j = ((long) iArr2[i4]) & 4294967295L;
                j5 += j6 * j2;
                int i7 = (int) j5;
                iArr2[i2 + 1] = (i7 << 1) | (((int) (j4 >>> 32)) & 1);
                j += j5 >>> 32;
                j5 = ((long) iArr[i + 2]) & 4294967295L;
                int i8 = i2 + 3;
                int i9 = i2 + 4;
                long j7 = ((long) iArr2[i8]) & 4294967295L;
                long j8 = ((long) iArr2[i9]) & 4294967295L;
                j += j5 * j2;
                int i10 = (int) j;
                iArr2[i4] = (i7 >>> 31) | (i10 << 1);
                j = j7 + ((j >>> 32) + (j5 * j6));
                j8 += j >>> 32;
                long j9 = ((long) iArr[i + 3]) & 4294967295L;
                int i11 = i2 + 5;
                long j10 = j5;
                int i12 = i2 + 6;
                long j11 = ((long) iArr2[i11]) & 4294967295L;
                j5 = ((long) iArr2[i12]) & 4294967295L;
                j = (j & 4294967295L) + (j9 * j2);
                int i13 = (int) j;
                iArr2[i8] = (i10 >>> 31) | (i13 << 1);
                i10 = i13 >>> 31;
                j8 += (j >>> 32) + (j9 * j6);
                j = j11 + ((j8 >>> 32) + (j9 * j10));
                j5 += j >>> 32;
                j &= 4294967295L;
                j4 = ((long) iArr[i + 4]) & 4294967295L;
                i8 = i2 + 7;
                long j12 = j9;
                int i14 = i2 + 8;
                long j13 = ((long) iArr2[i8]) & 4294967295L;
                j9 = ((long) iArr2[i14]) & 4294967295L;
                j8 = (j8 & 4294967295L) + (j4 * j2);
                long j14 = j2;
                int i15 = (int) j8;
                iArr2[i9] = i10 | (i15 << 1);
                i10 = i15 >>> 31;
                j += (j8 >>> 32) + (j4 * j6);
                j5 += (j >>> 32) + (j4 * j10);
                long j15 = j13 + ((j5 >>> 32) + (j4 * j12));
                j5 &= 4294967295L;
                j9 += j15 >>> 32;
                j15 &= 4294967295L;
                long j16 = j4;
                long j17 = ((long) iArr[i + 5]) & 4294967295L;
                i15 = i2 + 9;
                long j18 = j9;
                i4 = i2 + 10;
                int i16 = i15;
                long j19 = ((long) iArr2[i15]) & 4294967295L;
                j8 = 4294967295L & ((long) iArr2[i4]);
                long j20 = (j & 4294967295L) + (j17 * j14);
                i15 = (int) j20;
                iArr2[i11] = i10 | (i15 << 1);
                i10 = i15 >>> 31;
                j5 += (j20 >>> 32) + (j6 * j17);
                j20 = ((j5 >>> 32) + (j17 * j10)) + j15;
                j9 = j18 + ((j20 >>> 32) + (j17 * j12));
                j17 = j19 + ((j9 >>> 32) + (j17 * j16));
                j8 += j17 >>> 32;
                i15 = (int) j5;
                iArr2[i12] = i10 | (i15 << 1);
                i10 = i15 >>> 31;
                i15 = (int) j20;
                iArr2[i8] = i10 | (i15 << 1);
                i10 = i15 >>> 31;
                i15 = (int) j9;
                iArr2[i14] = i10 | (i15 << 1);
                i10 = i15 >>> 31;
                i15 = (int) j17;
                iArr2[i16] = i10 | (i15 << 1);
                i10 = i15 >>> 31;
                i15 = (int) j8;
                iArr2[i4] = i10 | (i15 << 1);
                i10 = i15 >>> 31;
                i15 = i2 + 11;
                iArr2[i15] = ((iArr2[i15] + ((int) (j8 >> 32))) << 1) | i10;
                return;
            }
            i4 = i6;
            j = 4294967295L;
        }
    }

    /* renamed from: e */
    public static int m28915e(int[] iArr, int[] iArr2, int[] iArr3) {
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
        j = (j >> 32) + ((((long) iArr[5]) & 4294967295L) - (((long) iArr2[5]) & 4294967295));
        iArr3[5] = (int) j;
        return (int) (j >> 32);
    }

    /* renamed from: c */
    public static int m28904c(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((((long) iArr[i + 0]) & 4294967295L) - (((long) iArr2[i2 + 0]) & 4294967295L)) + 0;
        iArr3[i3 + 0] = (int) j;
        j = (j >> 32) + ((((long) iArr[i + 1]) & 4294967295L) - (((long) iArr2[i2 + 1]) & 4294967295L));
        iArr3[i3 + 1] = (int) j;
        j = (j >> 32) + ((((long) iArr[i + 2]) & 4294967295L) - (((long) iArr2[i2 + 2]) & 4294967295L));
        iArr3[i3 + 2] = (int) j;
        j = (j >> 32) + ((((long) iArr[i + 3]) & 4294967295L) - (((long) iArr2[i2 + 3]) & 4294967295L));
        iArr3[i3 + 3] = (int) j;
        j = (j >> 32) + ((((long) iArr[i + 4]) & 4294967295L) - (((long) iArr2[i2 + 4]) & 4294967295L));
        iArr3[i3 + 4] = (int) j;
        j = (j >> 32) + ((((long) iArr[i + 5]) & 4294967295) - (((long) iArr2[i2 + 5]) & 4294967295));
        iArr3[i3 + 5] = (int) j;
        return (int) (j >> 32);
    }

    /* renamed from: d */
    public static int m28911d(int[] iArr, int[] iArr2) {
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
        j = (j >> 32) + ((((long) iArr2[5]) & 4294967295L) - (4294967295L & ((long) iArr[5])));
        iArr2[5] = (int) j;
        return (int) (j >> 32);
    }

    /* renamed from: c */
    public static BigInteger m28905c(int[] iArr) {
        byte[] bArr = new byte[24];
        for (int i = 0; i < 6; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.m29400a(i2, bArr, (5 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: c */
    public static BigInteger m28906c(long[] jArr) {
        byte[] bArr = new byte[24];
        for (int i = 0; i < 3; i++) {
            long j = jArr[i];
            if (j != 0) {
                Pack.m29401a(j, bArr, (2 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: d */
    public static void m28913d(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
    }
}
