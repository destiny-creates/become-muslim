package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;

public class SecT131Field {
    /* renamed from: a */
    public static void m28683a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr2[2] ^ jArr[2];
    }

    /* renamed from: b */
    public static void m28686b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr2[4] ^ jArr[4];
    }

    /* renamed from: a */
    public static void m28682a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    /* renamed from: a */
    public static long[] m28684a(BigInteger bigInteger) {
        long[] b = Nat192.m28903b(bigInteger);
        m28680a(b, 0);
        return b;
    }

    /* renamed from: b */
    public static void m28685b(long[] jArr, long[] jArr2) {
        if (Nat192.m28901b(jArr)) {
            throw new IllegalStateException();
        }
        long[] b = Nat192.m28902b();
        long[] b2 = Nat192.m28902b();
        m28689d(jArr, b);
        m28688c(b, jArr, b);
        m28681a(b, 2, b2);
        m28688c(b2, b, b2);
        m28681a(b2, 4, b);
        m28688c(b, b2, b);
        m28681a(b, 8, b2);
        m28688c(b2, b, b2);
        m28681a(b2, 16, b);
        m28688c(b, b2, b);
        m28681a(b, 32, b2);
        m28688c(b2, b, b2);
        m28689d(b2, b2);
        m28688c(b2, jArr, b2);
        m28681a(b2, (int) 65, b);
        m28688c(b, b2, b);
        m28689d(b, jArr2);
    }

    /* renamed from: c */
    public static void m28688c(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] d = Nat192.m28914d();
        m28692e(jArr, jArr2, d);
        m28687c(d, jArr3);
    }

    /* renamed from: d */
    public static void m28690d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] d = Nat192.m28914d();
        m28692e(jArr, jArr2, d);
        m28686b(jArr3, d, jArr3);
    }

    /* renamed from: c */
    public static void m28687c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        j4 ^= j5 >>> 59;
        j ^= (j4 << 61) ^ (j4 << 63);
        j2 = (j2 ^ ((j5 << 61) ^ (j5 << 63))) ^ ((((j4 >>> 3) ^ (j4 >>> 1)) ^ j4) ^ (j4 << 5));
        j3 = (j3 ^ ((((j5 >>> 3) ^ (j5 >>> 1)) ^ j5) ^ (j5 << 5))) ^ (j4 >>> 59);
        j4 = j3 >>> 3;
        jArr2[0] = (((j ^ j4) ^ (j4 << 2)) ^ (j4 << 3)) ^ (j4 << 8);
        jArr2[1] = (j4 >>> 56) ^ j2;
        jArr2[2] = 7 & j3;
    }

    /* renamed from: a */
    public static void m28680a(long[] jArr, int i) {
        int i2 = i + 2;
        long j = jArr[i2];
        long j2 = j >>> 3;
        jArr[i] = jArr[i] ^ ((((j2 << 2) ^ j2) ^ (j2 << 3)) ^ (j2 << 8));
        i++;
        jArr[i] = (j2 >>> 56) ^ jArr[i];
        jArr[i2] = j & 7;
    }

    /* renamed from: d */
    public static void m28689d(long[] jArr, long[] jArr2) {
        long[] b = Nat.m29025b(5);
        m28693f(jArr, b);
        m28687c(b, jArr2);
    }

    /* renamed from: e */
    public static void m28691e(long[] jArr, long[] jArr2) {
        long[] b = Nat.m29025b(5);
        m28693f(jArr, b);
        m28686b(jArr2, b, jArr2);
    }

    /* renamed from: a */
    public static void m28681a(long[] jArr, int i, long[] jArr2) {
        long[] b = Nat.m29025b(5);
        m28693f(jArr, b);
        m28687c(b, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                m28693f(jArr2, b);
                m28687c(b, jArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    protected static void m28679a(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        jArr[0] = j ^ (j2 << 44);
        jArr[1] = (j2 >>> 20) ^ (j3 << 24);
        jArr[2] = ((j3 >>> 40) ^ (j4 << 4)) ^ (j5 << 48);
        jArr[3] = ((j4 >>> 60) ^ (j6 << 28)) ^ (j5 >>> 16);
        jArr[4] = j6 >>> 36;
        jArr[5] = 0;
    }

    /* renamed from: e */
    protected static void m28692e(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = ((jArr[2] << 40) ^ (j2 >>> 24)) & 17592186044415L;
        j2 = ((j2 << 20) ^ (j >>> 44)) & 17592186044415L;
        j &= 17592186044415L;
        long j4 = jArr2[0];
        long j5 = jArr2[1];
        long j6 = ((j5 >>> 24) ^ (jArr2[2] << 40)) & 17592186044415L;
        long j7 = ((j4 >>> 44) ^ (j5 << 20)) & 17592186044415L;
        long j8 = j4 & 17592186044415L;
        long[] jArr4 = new long[10];
        m28678a(j, j8, jArr4, 0);
        long[] jArr5 = jArr4;
        m28678a(j3, j6, jArr5, 2);
        long j9 = (j ^ j2) ^ j3;
        long j10 = (j8 ^ j7) ^ j6;
        m28678a(j9, j10, jArr5, 4);
        j2 = (j2 << 1) ^ (j3 << 2);
        j6 = (j6 << 2) ^ (j7 << 1);
        m28678a(j ^ j2, j8 ^ j6, jArr5, 6);
        m28678a(j9 ^ j2, j10 ^ j6, jArr5, 8);
        j = jArr4[6] ^ jArr4[8];
        j2 = jArr4[7] ^ jArr4[9];
        j3 = (j << 1) ^ jArr4[6];
        j = (j ^ (j2 << 1)) ^ jArr4[7];
        j4 = jArr4[0];
        long j11 = (jArr4[1] ^ jArr4[0]) ^ jArr4[4];
        long j12 = jArr4[1] ^ jArr4[5];
        j3 = ((j3 ^ j4) ^ (jArr4[2] << 4)) ^ (jArr4[2] << 1);
        j = (((j11 ^ j) ^ (jArr4[3] << 4)) ^ (jArr4[3] << 1)) ^ (j3 >>> 44);
        j2 = (j12 ^ j2) ^ (j >>> 44);
        j &= 17592186044415L;
        j3 = ((j3 & 17592186044415L) >>> 1) ^ ((j & 1) << 43);
        j3 ^= j3 << 1;
        j3 ^= j3 << 2;
        j3 ^= j3 << 4;
        j3 ^= j3 << 8;
        j3 ^= j3 << 16;
        j3 = (j3 ^ (j3 << 32)) & 17592186044415L;
        j = ((j >>> 1) ^ ((j2 & 1) << 43)) ^ (j3 >>> 43);
        j ^= j << 1;
        j ^= j << 2;
        j ^= j << 4;
        j ^= j << 8;
        j ^= j << 16;
        j = (j ^ (j << 32)) & 17592186044415L;
        j2 = (j2 >>> 1) ^ (j >>> 43);
        j2 ^= j2 << 1;
        j2 ^= j2 << 2;
        j2 ^= j2 << 4;
        j2 ^= j2 << 8;
        j2 ^= j2 << 16;
        j2 ^= j2 << 32;
        jArr3[0] = j4;
        jArr3[1] = (j11 ^ j3) ^ jArr4[2];
        jArr3[2] = (j3 ^ (j12 ^ j)) ^ jArr4[3];
        jArr3[3] = j2 ^ j;
        jArr3[4] = jArr4[2] ^ j2;
        jArr3[5] = jArr4[3];
        m28679a(jArr3);
    }

    /* renamed from: a */
    protected static void m28678a(long j, long j2, long[] jArr, int i) {
        long j3 = j;
        long[] jArr2 = new long[8];
        jArr2[1] = j2;
        jArr2[2] = jArr2[1] << 1;
        jArr2[3] = jArr2[2] ^ j2;
        jArr2[4] = jArr2[2] << 1;
        jArr2[5] = jArr2[4] ^ j2;
        jArr2[6] = jArr2[3] << 1;
        int i2 = 7;
        jArr2[7] = jArr2[6] ^ j2;
        int i3 = (int) j3;
        long j4 = (jArr2[(i3 >>> 6) & 7] << 6) ^ (jArr2[i3 & 7] ^ (jArr2[(i3 >>> 3) & 7] << 3));
        long j5 = 0;
        long j6 = 33;
        while (true) {
            int i4 = (int) (j3 >>> j6);
            long j7 = ((jArr2[i4 & 7] ^ (jArr2[(i4 >>> 3) & 7] << 3)) ^ (jArr2[(i4 >>> 6) & 7] << 6)) ^ (jArr2[(i4 >>> 9) & i2] << 9);
            j4 ^= j7 << j6;
            j5 ^= j7 >>> (-j6);
            j6 -= 12;
            if (j6 <= null) {
                jArr[i] = 17592186044415L & j4;
                jArr[i + 1] = (j4 >>> 44) ^ (j5 << 20);
                return;
            }
            i2 = 7;
        }
    }

    /* renamed from: f */
    protected static void m28693f(long[] jArr, long[] jArr2) {
        Interleave.m28829a(jArr[0], jArr2, 0);
        Interleave.m28829a(jArr[1], jArr2, 2);
        jArr2[4] = ((long) Interleave.m28828a((int) jArr[2])) & 4294967295L;
    }
}
