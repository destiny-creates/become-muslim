package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat192;

public class SecT163Field {
    /* renamed from: a */
    public static void m28699a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr2[2] ^ jArr[2];
    }

    /* renamed from: b */
    public static void m28702b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr2[5] ^ jArr[5];
    }

    /* renamed from: a */
    public static void m28698a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    /* renamed from: a */
    public static long[] m28700a(BigInteger bigInteger) {
        long[] b = Nat192.m28903b(bigInteger);
        m28696a(b, 0);
        return b;
    }

    /* renamed from: b */
    public static void m28701b(long[] jArr, long[] jArr2) {
        if (Nat192.m28901b(jArr)) {
            throw new IllegalStateException();
        }
        long[] b = Nat192.m28902b();
        long[] b2 = Nat192.m28902b();
        m28705d(jArr, b);
        m28697a(b, 1, b2);
        m28704c(b, b2, b);
        m28697a(b2, 1, b2);
        m28704c(b, b2, b);
        m28697a(b, 3, b2);
        m28704c(b, b2, b);
        m28697a(b2, 3, b2);
        m28704c(b, b2, b);
        m28697a(b, 9, b2);
        m28704c(b, b2, b);
        m28697a(b2, 9, b2);
        m28704c(b, b2, b);
        m28697a(b, 27, b2);
        m28704c(b, b2, b);
        m28697a(b2, 27, b2);
        m28704c(b, b2, b);
        m28697a(b, (int) 81, b2);
        m28704c(b, b2, jArr2);
    }

    /* renamed from: c */
    public static void m28704c(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] d = Nat192.m28914d();
        m28708e(jArr, jArr2, d);
        m28703c(d, jArr3);
    }

    /* renamed from: d */
    public static void m28706d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] d = Nat192.m28914d();
        m28708e(jArr, jArr2, d);
        m28702b(jArr3, d, jArr3);
    }

    /* renamed from: c */
    public static void m28703c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        j4 ^= (((j6 >>> 35) ^ (j6 >>> 32)) ^ (j6 >>> 29)) ^ (j6 >>> 28);
        j2 ^= (((j5 << 29) ^ (j5 << 32)) ^ (j5 << 35)) ^ (j5 << 36);
        j3 = (j3 ^ ((((j6 << 29) ^ (j6 << 32)) ^ (j6 << 35)) ^ (j6 << 36))) ^ ((j5 >>> 28) ^ (((j5 >>> 35) ^ (j5 >>> 32)) ^ (j5 >>> 29)));
        j ^= (((j4 << 29) ^ (j4 << 32)) ^ (j4 << 35)) ^ (j4 << 36);
        j2 ^= (j4 >>> 28) ^ (((j4 >>> 35) ^ (j4 >>> 32)) ^ (j4 >>> 29));
        j4 = j3 >>> 35;
        jArr2[0] = (((j ^ j4) ^ (j4 << 3)) ^ (j4 << 6)) ^ (j4 << 7);
        jArr2[1] = j2;
        jArr2[2] = 34359738367L & j3;
    }

    /* renamed from: a */
    public static void m28696a(long[] jArr, int i) {
        int i2 = i + 2;
        long j = jArr[i2];
        long j2 = j >>> 35;
        jArr[i] = ((j2 << 7) ^ (((j2 << 3) ^ j2) ^ (j2 << 6))) ^ jArr[i];
        jArr[i2] = j & 34359738367L;
    }

    /* renamed from: d */
    public static void m28705d(long[] jArr, long[] jArr2) {
        long[] d = Nat192.m28914d();
        m28709f(jArr, d);
        m28703c(d, jArr2);
    }

    /* renamed from: e */
    public static void m28707e(long[] jArr, long[] jArr2) {
        long[] d = Nat192.m28914d();
        m28709f(jArr, d);
        m28702b(jArr2, d, jArr2);
    }

    /* renamed from: a */
    public static void m28697a(long[] jArr, int i, long[] jArr2) {
        long[] d = Nat192.m28914d();
        m28709f(jArr, d);
        m28703c(d, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                m28709f(jArr2, d);
                m28703c(d, jArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    protected static void m28695a(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        jArr[0] = j ^ (j2 << 55);
        jArr[1] = (j2 >>> 9) ^ (j3 << 46);
        jArr[2] = (j3 >>> 18) ^ (j4 << 37);
        jArr[3] = (j4 >>> 27) ^ (j5 << 28);
        jArr[4] = (j5 >>> 36) ^ (j6 << 19);
        jArr[5] = j6 >>> 45;
    }

    /* renamed from: e */
    protected static void m28708e(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = (jArr[2] << 18) ^ (j2 >>> 46);
        j2 = ((j2 << 9) ^ (j >>> 55)) & 36028797018963967L;
        j &= 36028797018963967L;
        long j4 = jArr2[0];
        long j5 = jArr2[1];
        long j6 = (j5 >>> 46) ^ (jArr2[2] << 18);
        long j7 = ((j4 >>> 55) ^ (j5 << 9)) & 36028797018963967L;
        long j8 = j4 & 36028797018963967L;
        long[] jArr4 = new long[10];
        long[] jArr5 = jArr4;
        m28694a(j, j8, jArr5, 0);
        m28694a(j3, j6, jArr5, 2);
        long j9 = (j ^ j2) ^ j3;
        long j10 = (j8 ^ j7) ^ j6;
        m28694a(j9, j10, jArr5, 4);
        j2 = (j2 << 1) ^ (j3 << 2);
        j6 = (j6 << 2) ^ (j7 << 1);
        m28694a(j ^ j2, j8 ^ j6, jArr5, 6);
        m28694a(j9 ^ j2, j10 ^ j6, jArr5, 8);
        j = jArr4[6] ^ jArr4[8];
        j2 = jArr4[7] ^ jArr4[9];
        j3 = (j << 1) ^ jArr4[6];
        j = (j ^ (j2 << 1)) ^ jArr4[7];
        j4 = jArr4[0];
        j5 = (jArr4[1] ^ jArr4[0]) ^ jArr4[4];
        long j11 = jArr4[1] ^ jArr4[5];
        j3 = ((j3 ^ j4) ^ (jArr4[2] << 4)) ^ (jArr4[2] << 1);
        j = (((j5 ^ j) ^ (jArr4[3] << 4)) ^ (jArr4[3] << 1)) ^ (j3 >>> 55);
        j2 = (j11 ^ j2) ^ (j >>> 55);
        j &= 36028797018963967L;
        j3 = ((j3 & 36028797018963967L) >>> 1) ^ ((j & 1) << 54);
        j3 ^= j3 << 1;
        j3 ^= j3 << 2;
        j3 ^= j3 << 4;
        j3 ^= j3 << 8;
        j3 ^= j3 << 16;
        j3 = (j3 ^ (j3 << 32)) & 36028797018963967L;
        j = ((j >>> 1) ^ ((j2 & 1) << 54)) ^ (j3 >>> 54);
        j ^= j << 1;
        j ^= j << 2;
        j ^= j << 4;
        j ^= j << 8;
        j ^= j << 16;
        j = (j ^ (j << 32)) & 36028797018963967L;
        j2 = (j2 >>> 1) ^ (j >>> 54);
        j2 ^= j2 << 1;
        j2 ^= j2 << 2;
        j2 ^= j2 << 4;
        j2 ^= j2 << 8;
        j2 ^= j2 << 16;
        j2 ^= j2 << 32;
        jArr3[0] = j4;
        jArr3[1] = (j5 ^ j3) ^ jArr4[2];
        jArr3[2] = (j3 ^ (j11 ^ j)) ^ jArr4[3];
        jArr3[3] = j2 ^ j;
        jArr3[4] = jArr4[2] ^ j2;
        jArr3[5] = jArr4[3];
        m28695a(jArr3);
    }

    /* renamed from: a */
    protected static void m28694a(long j, long j2, long[] jArr, int i) {
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
        long j4 = jArr2[((int) j3) & 3];
        long j5 = 0;
        long j6 = 47;
        while (true) {
            int i3 = (int) (j3 >>> j6);
            long j7 = (jArr2[i3 & 7] ^ (jArr2[(i3 >>> 3) & 7] << 3)) ^ (jArr2[(i3 >>> 6) & i2] << 6);
            j4 ^= j7 << j6;
            j5 ^= j7 >>> (-j6);
            j6 -= 9;
            if (j6 <= null) {
                jArr[i] = 36028797018963967L & j4;
                jArr[i + 1] = (j4 >>> 55) ^ (j5 << 9);
                return;
            }
            i2 = 7;
        }
    }

    /* renamed from: f */
    protected static void m28709f(long[] jArr, long[] jArr2) {
        Interleave.m28829a(jArr[0], jArr2, 0);
        Interleave.m28829a(jArr[1], jArr2, 2);
        long j = jArr[2];
        jArr2[4] = Interleave.m28831c((int) j);
        jArr2[5] = ((long) Interleave.m28828a((int) (j >>> 32))) & 4294967295L;
    }
}
