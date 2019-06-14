package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

public abstract class Nat448 {
    /* renamed from: a */
    public static long[] m28984a() {
        return new long[7];
    }

    /* renamed from: b */
    public static long[] m28987b() {
        return new long[14];
    }

    /* renamed from: a */
    public static boolean m28983a(long[] jArr, long[] jArr2) {
        for (int i = 6; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return null;
            }
        }
        return 1;
    }

    /* renamed from: a */
    public static long[] m28985a(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 448) {
            throw new IllegalArgumentException();
        }
        long[] a = m28984a();
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
    public static boolean m28982a(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 7; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m28986b(long[] jArr) {
        for (int i = 0; i < 7; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return 1;
    }

    /* renamed from: c */
    public static BigInteger m28988c(long[] jArr) {
        byte[] bArr = new byte[56];
        for (int i = 0; i < 7; i++) {
            long j = jArr[i];
            if (j != 0) {
                Pack.m29401a(j, bArr, (6 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }
}
