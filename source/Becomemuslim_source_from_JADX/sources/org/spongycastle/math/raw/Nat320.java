package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

public abstract class Nat320 {
    /* renamed from: a */
    public static long[] m28975a() {
        return new long[5];
    }

    /* renamed from: b */
    public static long[] m28978b() {
        return new long[10];
    }

    /* renamed from: a */
    public static boolean m28974a(long[] jArr, long[] jArr2) {
        for (int i = 4; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return null;
            }
        }
        return 1;
    }

    /* renamed from: a */
    public static long[] m28976a(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 320) {
            throw new IllegalArgumentException();
        }
        long[] a = m28975a();
        int i = 0;
        while (bigInteger.signum() != 0) {
            int i2 = i + 1;
            a[i] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i = i2;
        }
        return a;
    }

    /* renamed from: a */
    public static boolean m28973a(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 5; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m28977b(long[] jArr) {
        for (int i = 0; i < 5; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return 1;
    }

    /* renamed from: c */
    public static BigInteger m28979c(long[] jArr) {
        byte[] bArr = new byte[40];
        for (int i = 0; i < 5; i++) {
            long j = jArr[i];
            if (j != 0) {
                Pack.m29401a(j, bArr, (4 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }
}
