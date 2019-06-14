package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat256;

public class SecT239Field {
    /* renamed from: a */
    public static void m28749a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    /* renamed from: b */
    public static void m28752b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr2[7] ^ jArr[7];
    }

    /* renamed from: a */
    public static void m28748a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    /* renamed from: a */
    public static long[] m28750a(BigInteger bigInteger) {
        long[] b = Nat256.m28959b(bigInteger);
        m28746a(b, 0);
        return b;
    }

    /* renamed from: b */
    public static void m28751b(long[] jArr, long[] jArr2) {
        if (Nat256.m28957b(jArr)) {
            throw new IllegalStateException();
        }
        long[] b = Nat256.m28958b();
        long[] b2 = Nat256.m28958b();
        m28755d(jArr, b);
        m28754c(b, jArr, b);
        m28755d(b, b);
        m28754c(b, jArr, b);
        m28747a(b, 3, b2);
        m28754c(b2, b, b2);
        m28755d(b2, b2);
        m28754c(b2, jArr, b2);
        m28747a(b2, 7, b);
        m28754c(b, b2, b);
        m28747a(b, 14, b2);
        m28754c(b2, b, b2);
        m28755d(b2, b2);
        m28754c(b2, jArr, b2);
        m28747a(b2, 29, b);
        m28754c(b, b2, b);
        m28755d(b, b);
        m28754c(b, jArr, b);
        m28747a(b, 59, b2);
        m28754c(b2, b, b2);
        m28755d(b2, b2);
        m28754c(b2, jArr, b2);
        m28747a(b2, (int) 119, b);
        m28754c(b, b2, b);
        m28755d(b, jArr2);
    }

    /* renamed from: c */
    public static void m28754c(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] d = Nat256.m28970d();
        m28758e(jArr, jArr2, d);
        m28753c(d, jArr3);
    }

    /* renamed from: d */
    public static void m28756d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] d = Nat256.m28970d();
        m28758e(jArr, jArr2, d);
        m28752b(jArr3, d, jArr3);
    }

    /* renamed from: c */
    public static void m28753c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        j7 ^= j8 >>> 17;
        j6 = (j6 ^ (j8 << 47)) ^ (j7 >>> 17);
        j5 = ((j5 ^ (j8 >>> 47)) ^ (j7 << 47)) ^ (j6 >>> 17);
        j ^= j5 << 17;
        j2 = (j2 ^ (j6 << 17)) ^ (j5 >>> 47);
        j3 = ((j3 ^ (j7 << 17)) ^ (j6 >>> 47)) ^ (j5 << 47);
        j4 = (((j4 ^ (j8 << 17)) ^ (j7 >>> 47)) ^ (j6 << 47)) ^ (j5 >>> 17);
        j5 = j4 >>> 47;
        jArr2[0] = j ^ j5;
        jArr2[1] = j2;
        jArr2[2] = (j5 << 30) ^ j3;
        jArr2[3] = 140737488355327L & j4;
    }

    /* renamed from: a */
    public static void m28746a(long[] jArr, int i) {
        int i2 = i + 3;
        long j = jArr[i2];
        long j2 = j >>> 47;
        jArr[i] = jArr[i] ^ j2;
        i += 2;
        jArr[i] = (j2 << 30) ^ jArr[i];
        jArr[i2] = j & 140737488355327L;
    }

    /* renamed from: d */
    public static void m28755d(long[] jArr, long[] jArr2) {
        long[] d = Nat256.m28970d();
        m28760g(jArr, d);
        m28753c(d, jArr2);
    }

    /* renamed from: e */
    public static void m28757e(long[] jArr, long[] jArr2) {
        long[] d = Nat256.m28970d();
        m28760g(jArr, d);
        m28752b(jArr2, d, jArr2);
    }

    /* renamed from: a */
    public static void m28747a(long[] jArr, int i, long[] jArr2) {
        long[] d = Nat256.m28970d();
        m28760g(jArr, d);
        m28753c(d, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                m28760g(jArr2, d);
                m28753c(d, jArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    protected static void m28745a(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        jArr[0] = j ^ (j2 << 60);
        jArr[1] = (j2 >>> 4) ^ (j3 << 56);
        jArr[2] = (j3 >>> 8) ^ (j4 << 52);
        jArr[3] = (j4 >>> 12) ^ (j5 << 48);
        jArr[4] = (j5 >>> 16) ^ (j6 << 44);
        jArr[5] = (j6 >>> 20) ^ (j7 << 40);
        jArr[6] = (j7 >>> 24) ^ (j8 << 36);
        jArr[7] = j8 >>> 28;
    }

    /* renamed from: f */
    protected static void m28759f(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        jArr2[0] = j & 1152921504606846975L;
        jArr2[1] = ((j >>> 60) ^ (j2 << 4)) & 1152921504606846975L;
        jArr2[2] = ((j2 >>> 56) ^ (j3 << 8)) & 1152921504606846975L;
        jArr2[3] = (j3 >>> 52) ^ (j4 << 12);
    }

    /* renamed from: e */
    protected static void m28758e(long[] jArr, long[] jArr2, long[] jArr3) {
        int i;
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        m28759f(jArr, jArr4);
        m28759f(jArr2, jArr5);
        long[] jArr6 = jArr3;
        m28744a(jArr4[0], jArr5[0], jArr6, 0);
        m28744a(jArr4[1], jArr5[1], jArr6, 1);
        m28744a(jArr4[2], jArr5[2], jArr6, 2);
        m28744a(jArr4[3], jArr5[3], jArr6, 3);
        for (i = 5; i > 0; i--) {
            jArr3[i] = jArr3[i] ^ jArr3[i - 1];
        }
        m28744a(jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        m28744a(jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (i = 7; i > 1; i--) {
            jArr3[i] = jArr3[i] ^ jArr3[i - 2];
        }
        long j = jArr4[0] ^ jArr4[2];
        long j2 = jArr4[1] ^ jArr4[3];
        long j3 = jArr5[0] ^ jArr5[2];
        long j4 = jArr5[1] ^ jArr5[3];
        m28744a(j ^ j2, j3 ^ j4, jArr3, 3);
        long[] jArr7 = new long[3];
        m28744a(j, j3, jArr7, 0);
        m28744a(j2, j4, jArr7, 1);
        long j5 = jArr7[0];
        long j6 = jArr7[1];
        j4 = jArr7[2];
        jArr3[2] = jArr3[2] ^ j5;
        jArr3[3] = (j5 ^ j6) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j4 ^ j6);
        jArr3[5] = jArr3[5] ^ j4;
        m28745a(jArr3);
    }

    /* renamed from: a */
    protected static void m28744a(long j, long j2, long[] jArr, int i) {
        long j3 = j;
        long[] jArr2 = new long[8];
        jArr2[1] = j2;
        jArr2[2] = jArr2[1] << 1;
        jArr2[3] = jArr2[2] ^ j2;
        jArr2[4] = jArr2[2] << 1;
        jArr2[5] = jArr2[4] ^ j2;
        jArr2[6] = jArr2[3] << 1;
        jArr2[7] = jArr2[6] ^ j2;
        int i2 = (int) j3;
        long j4 = 0;
        long j5 = (jArr2[(i2 >>> 3) & 7] << 3) ^ jArr2[i2 & 7];
        long j6 = 54;
        do {
            int i3 = (int) (j3 >>> j6);
            long j7 = jArr2[i3 & 7] ^ (jArr2[(i3 >>> 3) & 7] << 3);
            j5 ^= j7 << j6;
            j4 ^= j7 >>> (-j6);
            j6 -= 6;
        } while (j6 > null);
        j3 = (((j3 & 585610922974906400L) & ((j2 << 4) >> 63)) >>> 5) ^ j4;
        jArr[i] = jArr[i] ^ (1152921504606846975L & j5);
        int i4 = i + 1;
        jArr[i4] = ((j3 << 4) ^ (j5 >>> 60)) ^ jArr[i4];
    }

    /* renamed from: g */
    protected static void m28760g(long[] jArr, long[] jArr2) {
        Interleave.m28829a(jArr[0], jArr2, 0);
        Interleave.m28829a(jArr[1], jArr2, 2);
        Interleave.m28829a(jArr[2], jArr2, 4);
        long j = jArr[3];
        jArr2[6] = Interleave.m28831c((int) j);
        jArr2[7] = ((long) Interleave.m28830b((int) (j >>> 32))) & 4294967295L;
    }
}
