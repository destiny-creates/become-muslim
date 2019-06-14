package org.spongycastle.math.raw;

import android.support.v7.widget.LinearLayoutManager;
import java.math.BigInteger;
import org.spongycastle.util.Pack;

public abstract class Nat {
    /* renamed from: a */
    public static int m29010a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (((long) iArr[i2]) & 4294967295L) + (4294967295L & ((long) iArr2[i2]));
            iArr3[i2] = (int) j;
            j >>>= 32;
        }
        return (int) j;
    }

    /* renamed from: a */
    public static int m28998a(int i, int i2, int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) i2) & 4294967295L);
        iArr[0] = (int) j;
        j = (j >>> 32) + ((4294967295L & ((long) iArr[1])) + 1);
        iArr[1] = (int) j;
        if ((j >>> 32) == 0) {
            return 0;
        }
        return m29020b(i, iArr, 2);
    }

    /* renamed from: b */
    public static int m29023b(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += ((((long) iArr[i2]) & 4294967295L) + (((long) iArr2[i2]) & 4294967295L)) + (4294967295L & ((long) iArr3[i2]));
            iArr3[i2] = (int) j;
            j >>>= 32;
        }
        return (int) j;
    }

    /* renamed from: a */
    public static int m29009a(int i, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (((long) iArr[i2]) & 4294967295L) + (4294967295L & ((long) iArr2[i2]));
            iArr2[i2] = (int) j;
            j >>>= 32;
        }
        return (int) j;
    }

    /* renamed from: a */
    public static int m29008a(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + i4;
            j += (((long) iArr[i2 + i4]) & 4294967295L) + (4294967295L & ((long) iArr2[i5]));
            iArr2[i5] = (int) j;
            j >>>= 32;
        }
        return (int) j;
    }

    /* renamed from: a */
    public static int m28999a(int i, int i2, int[] iArr, int i3) {
        long j = (((long) i2) & 4294967295L) + (4294967295L & ((long) iArr[i3]));
        iArr[i3] = (int) j;
        if ((j >>> 32) == 0) {
            return 0;
        }
        return m29020b(i, iArr, i3 + 1);
    }

    /* renamed from: b */
    public static int m29018b(int i, int i2, int[] iArr) {
        long j = (((long) i2) & 4294967295L) + (4294967295L & ((long) iArr[0]));
        iArr[0] = (int) j;
        if ((j >>> 32) == 0) {
            return 0;
        }
        return m29020b(i, iArr, 1);
    }

    /* renamed from: a */
    public static int[] m29017a(int i, int[] iArr) {
        Object obj = new int[i];
        System.arraycopy(iArr, 0, obj, 0, i);
        return obj;
    }

    /* renamed from: a */
    public static int[] m29015a(int i) {
        return new int[i];
    }

    /* renamed from: b */
    public static long[] m29025b(int i) {
        return new long[i];
    }

    /* renamed from: b */
    public static int m29019b(int i, int[] iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2] - 1;
            iArr[i2] = i3;
            if (i3 != -1) {
                return 0;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static int m29002a(int i, int[] iArr, int i2) {
        while (i2 < i) {
            int i3 = iArr[i2] - 1;
            iArr[i2] = i3;
            if (i3 != -1) {
                return 0;
            }
            i2++;
        }
        return -1;
    }

    /* renamed from: b */
    public static boolean m29024b(int i, int[] iArr, int[] iArr2) {
        for (i--; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static int[] m29016a(int i, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
            throw new IllegalArgumentException();
        }
        i = m29015a((i + 31) >> 5);
        int i2 = 0;
        while (bigInteger.signum() != 0) {
            int i3 = i2 + 1;
            i[i2] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i2 = i3;
        }
        return i;
    }

    /* renamed from: a */
    public static int m29011a(int[] iArr, int i) {
        if (i == 0) {
            return iArr[0] & 1;
        }
        int i2 = i >> 5;
        if (i2 >= 0) {
            if (i2 < iArr.length) {
                return (iArr[i2] >>> (i & 31)) & 1;
            }
        }
        return 0;
    }

    /* renamed from: c */
    public static boolean m29031c(int i, int[] iArr, int[] iArr2) {
        for (i--; i >= 0; i--) {
            int i2 = iArr[i] ^ LinearLayoutManager.INVALID_OFFSET;
            int i3 = LinearLayoutManager.INVALID_OFFSET ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static int m29027c(int i, int[] iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2] + 1;
            iArr[i2] = i3;
            if (i3 != 0) {
                return 0;
            }
        }
        return 1;
    }

    /* renamed from: d */
    public static int m29034d(int i, int[] iArr, int[] iArr2) {
        int i2 = 0;
        while (i2 < i) {
            int i3 = iArr[i2] + 1;
            iArr2[i2] = i3;
            i2++;
            if (i3 != 0) {
                while (i2 < i) {
                    iArr2[i2] = iArr[i2];
                    i2++;
                }
                return 0;
            }
        }
        return 1;
    }

    /* renamed from: b */
    public static int m29020b(int i, int[] iArr, int i2) {
        while (i2 < i) {
            int i3 = iArr[i2] + 1;
            iArr[i2] = i3;
            if (i3 != 0) {
                return 0;
            }
            i2++;
        }
        return 1;
    }

    /* renamed from: a */
    public static int m29003a(int i, int[] iArr, int i2, int i3) {
        while (i3 < i) {
            int i4 = i2 + i3;
            int i5 = iArr[i4] + 1;
            iArr[i4] = i5;
            if (i5 != 0) {
                return 0;
            }
            i3++;
        }
        return 1;
    }

    /* renamed from: d */
    public static boolean m29035d(int i, int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < i; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public static boolean m29037e(int i, int[] iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static int m29001a(int i, int i2, int[] iArr, int i3, int[] iArr2, int[] iArr3, int i4) {
        long j = ((long) i2) & 4294967295L;
        long j2 = ((long) i3) & 4294967295L;
        long j3 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i4 + i5;
            long j4 = j;
            j3 += (((((long) iArr[i5]) & 4294967295L) * j) + ((((long) iArr2[i5]) & 4294967295L) * j2)) + (((long) iArr3[i6]) & 4294967295L);
            iArr3[i6] = (int) j3;
            j3 >>>= 32;
            i5++;
            if (i5 >= i) {
                return (int) j3;
            }
            j = j4;
        }
    }

    /* renamed from: a */
    public static int m29000a(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        long j = ((long) i2) & 4294967295L;
        long j2 = 0;
        int i5 = 0;
        do {
            int i6 = i4 + i5;
            j2 += ((((long) iArr[i3 + i5]) & 4294967295L) * j) + (((long) iArr2[i6]) & 4294967295L);
            iArr2[i6] = (int) j2;
            j2 >>>= 32;
            i5++;
        } while (i5 < i);
        return (int) j2;
    }

    /* renamed from: c */
    public static int m29028c(int i, int[] iArr, int i2) {
        while (true) {
            i--;
            if (i < 0) {
                return i2 << 31;
            }
            int i3 = iArr[i];
            iArr[i] = (i2 << 31) | (i3 >>> 1);
            i2 = i3;
        }
    }

    /* renamed from: b */
    public static int m29021b(int i, int[] iArr, int i2, int i3) {
        while (true) {
            i--;
            if (i < 0) {
                return i3 << (-i2);
            }
            int i4 = iArr[i];
            iArr[i] = (i3 << (-i2)) | (i4 >>> i2);
            i3 = i4;
        }
    }

    /* renamed from: a */
    public static int m29004a(int i, int[] iArr, int i2, int i3, int i4, int[] iArr2, int i5) {
        while (true) {
            i--;
            if (i < 0) {
                return i4 << (-i3);
            }
            int i6 = iArr[i2 + i];
            iArr2[i5 + i] = (i4 << (-i3)) | (i6 >>> i3);
            i4 = i6;
        }
    }

    /* renamed from: d */
    public static int m29033d(int i, int[] iArr, int i2) {
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            int i3 = iArr[i];
            iArr[i] = i2;
            i2 = i3;
        }
    }

    /* renamed from: a */
    public static int m29007a(int i, int[] iArr, int i2, int[] iArr2) {
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            iArr2[i3] = (i2 >>> 31) | (i4 << 1);
            i3++;
            i2 = i4;
        }
        return i2 >>> 31;
    }

    /* renamed from: a */
    public static int m29006a(int i, int[] iArr, int i2, int i3, int[] iArr2, int i4) {
        int i5 = 0;
        while (i5 < i) {
            int i6 = iArr[i2 + i5];
            iArr2[i4 + i5] = (i3 >>> 31) | (i6 << 1);
            i5++;
            i3 = i6;
        }
        return i3 >>> 31;
    }

    /* renamed from: a */
    public static long m29014a(int i, long[] jArr, int i2, long j, long[] jArr2, int i3) {
        int i4 = 0;
        while (i4 < i) {
            long j2 = jArr[i2 + i4];
            jArr2[i3 + i4] = (j >>> 63) | (j2 << 1);
            i4++;
            j = j2;
        }
        return j >>> 63;
    }

    /* renamed from: c */
    public static int m29029c(int i, int[] iArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i) {
            int i5 = iArr[i4];
            iArr[i4] = (i3 >>> (-i2)) | (i5 << i2);
            i4++;
            i3 = i5;
        }
        return i3 >>> (-i2);
    }

    /* renamed from: a */
    public static long m29012a(int i, long[] jArr, int i2, int i3, long j) {
        int i4 = 0;
        while (i4 < i) {
            int i5 = i2 + i4;
            long j2 = jArr[i5];
            jArr[i5] = (j >>> (-i3)) | (j2 << i3);
            i4++;
            j = j2;
        }
        return j >>> (-i3);
    }

    /* renamed from: a */
    public static int m29005a(int i, int[] iArr, int i2, int i3, int[] iArr2) {
        int i4 = 0;
        while (i4 < i) {
            int i5 = iArr[i4];
            iArr2[i4] = (i3 >>> (-i2)) | (i5 << i2);
            i4++;
            i3 = i5;
        }
        return i3 >>> (-i2);
    }

    /* renamed from: a */
    public static long m29013a(int i, long[] jArr, int i2, int i3, long j, long[] jArr2, int i4) {
        int i5 = 0;
        while (i5 < i) {
            long j2 = jArr[i2 + i5];
            jArr2[i4 + i5] = (j >>> (-i3)) | (j2 << i3);
            i5++;
            j = j2;
        }
        return j >>> (-i3);
    }

    /* renamed from: c */
    public static int m29030c(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (((long) iArr[i2]) & 4294967295L) - (4294967295L & ((long) iArr2[i2]));
            iArr3[i2] = (int) j;
            j >>= 32;
        }
        return (int) j;
    }

    /* renamed from: c */
    public static int m29026c(int i, int i2, int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) - (((long) i2) & 4294967295L);
        iArr[0] = (int) j;
        j = (j >> 32) + ((4294967295L & ((long) iArr[1])) - 1);
        iArr[1] = (int) j;
        if ((j >> 32) == 0) {
            return 0;
        }
        return m29002a(i, iArr, 2);
    }

    /* renamed from: e */
    public static int m29036e(int i, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (((long) iArr2[i2]) & 4294967295L) - (4294967295L & ((long) iArr[i2]));
            iArr2[i2] = (int) j;
            j >>= 32;
        }
        return (int) j;
    }

    /* renamed from: b */
    public static int m29022b(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + i4;
            j += (((long) iArr2[i5]) & 4294967295L) - (4294967295L & ((long) iArr[i2 + i4]));
            iArr2[i5] = (int) j;
            j >>= 32;
        }
        return (int) j;
    }

    /* renamed from: d */
    public static int m29032d(int i, int i2, int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) - (4294967295L & ((long) i2));
        iArr[0] = (int) j;
        if ((j >> 32) == 0) {
            return 0;
        }
        return m29002a(i, iArr, 1);
    }

    /* renamed from: f */
    public static BigInteger m29038f(int i, int[] iArr) {
        byte[] bArr = new byte[(i << 2)];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                Pack.m29400a(i3, bArr, ((i - 1) - i2) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: g */
    public static void m29039g(int i, int[] iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = 0;
        }
    }
}
