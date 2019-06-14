package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat320;

public class SecT283Field {
    /* renamed from: a */
    public static void m28766a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr2[4] ^ jArr[4];
    }

    /* renamed from: b */
    public static void m28769b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr[7] ^ jArr2[7];
        jArr3[8] = jArr2[8] ^ jArr[8];
    }

    /* renamed from: a */
    public static void m28765a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
    }

    /* renamed from: a */
    public static long[] m28767a(BigInteger bigInteger) {
        long[] a = Nat320.m28976a(bigInteger);
        m28763a(a, 0);
        return a;
    }

    /* renamed from: b */
    public static void m28768b(long[] jArr, long[] jArr2) {
        if (Nat320.m28977b(jArr)) {
            throw new IllegalStateException();
        }
        long[] a = Nat320.m28975a();
        long[] a2 = Nat320.m28975a();
        m28772d(jArr, a);
        m28771c(a, jArr, a);
        m28764a(a, 2, a2);
        m28771c(a2, a, a2);
        m28764a(a2, 4, a);
        m28771c(a, a2, a);
        m28764a(a, 8, a2);
        m28771c(a2, a, a2);
        m28772d(a2, a2);
        m28771c(a2, jArr, a2);
        m28764a(a2, 17, a);
        m28771c(a, a2, a);
        m28772d(a, a);
        m28771c(a, jArr, a);
        m28764a(a, 35, a2);
        m28771c(a2, a, a2);
        m28764a(a2, 70, a);
        m28771c(a, a2, a);
        m28772d(a, a);
        m28771c(a, jArr, a);
        m28764a(a, (int) 141, a2);
        m28771c(a2, a, a2);
        m28772d(a2, jArr2);
    }

    /* renamed from: c */
    public static void m28771c(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b = Nat320.m28978b();
        m28775e(jArr, jArr2, b);
        m28770c(b, jArr3);
    }

    /* renamed from: d */
    public static void m28773d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b = Nat320.m28978b();
        m28775e(jArr, jArr2, b);
        m28769b(jArr3, b, jArr3);
    }

    /* renamed from: c */
    public static void m28770c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[8];
        j5 ^= (((j9 >>> 27) ^ (j9 >>> 22)) ^ (j9 >>> 20)) ^ (j9 >>> 15);
        j4 = (j4 ^ ((((j9 << 37) ^ (j9 << 42)) ^ (j9 << 44)) ^ (j9 << 49))) ^ ((((j8 >>> 27) ^ (j8 >>> 22)) ^ (j8 >>> 20)) ^ (j8 >>> 15));
        j3 = (j3 ^ ((((j8 << 37) ^ (j8 << 42)) ^ (j8 << 44)) ^ (j8 << 49))) ^ ((((j7 >>> 27) ^ (j7 >>> 22)) ^ (j7 >>> 20)) ^ (j7 >>> 15));
        j ^= (((j6 << 37) ^ (j6 << 42)) ^ (j6 << 44)) ^ (j6 << 49);
        j2 = (j2 ^ ((((j7 << 37) ^ (j7 << 42)) ^ (j7 << 44)) ^ (j7 << 49))) ^ ((((j6 >>> 27) ^ (j6 >>> 22)) ^ (j6 >>> 20)) ^ (j6 >>> 15));
        j6 = j5 >>> 27;
        jArr2[0] = (((j ^ j6) ^ (j6 << 5)) ^ (j6 << 7)) ^ (j6 << 12);
        jArr2[1] = j2;
        jArr2[2] = j3;
        jArr2[3] = j4;
        jArr2[4] = 134217727 & j5;
    }

    /* renamed from: a */
    public static void m28763a(long[] jArr, int i) {
        int i2 = i + 4;
        long j = jArr[i2];
        long j2 = j >>> 27;
        jArr[i] = ((j2 << 12) ^ (((j2 << 5) ^ j2) ^ (j2 << 7))) ^ jArr[i];
        jArr[i2] = j & 134217727;
    }

    /* renamed from: d */
    public static void m28772d(long[] jArr, long[] jArr2) {
        long[] b = Nat.m29025b(9);
        m28777g(jArr, b);
        m28770c(b, jArr2);
    }

    /* renamed from: e */
    public static void m28774e(long[] jArr, long[] jArr2) {
        long[] b = Nat.m29025b(9);
        m28777g(jArr, b);
        m28769b(jArr2, b, jArr2);
    }

    /* renamed from: a */
    public static void m28764a(long[] jArr, int i, long[] jArr2) {
        long[] b = Nat.m29025b(9);
        m28777g(jArr, b);
        m28770c(b, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                m28777g(jArr2, b);
                m28770c(b, jArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    protected static void m28762a(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[8];
        long j10 = jArr[9];
        jArr[0] = j ^ (j2 << 57);
        jArr[1] = (j2 >>> 7) ^ (j3 << 50);
        jArr[2] = (j3 >>> 14) ^ (j4 << 43);
        jArr[3] = (j4 >>> 21) ^ (j5 << 36);
        jArr[4] = (j5 >>> 28) ^ (j6 << 29);
        jArr[5] = (j6 >>> 35) ^ (j7 << 22);
        jArr[6] = (j7 >>> 42) ^ (j8 << 15);
        jArr[7] = (j8 >>> 49) ^ (j9 << 8);
        jArr[8] = (j9 >>> 56) ^ (j10 << 1);
        jArr[9] = j10 >>> 63;
    }

    /* renamed from: f */
    protected static void m28776f(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        jArr2[0] = j & 144115188075855871L;
        jArr2[1] = ((j >>> 57) ^ (j2 << 7)) & 144115188075855871L;
        jArr2[2] = ((j2 >>> 50) ^ (j3 << 14)) & 144115188075855871L;
        jArr2[3] = ((j3 >>> 43) ^ (j4 << 21)) & 144115188075855871L;
        jArr2[4] = (j4 >>> 36) ^ (j5 << 28);
    }

    /* renamed from: e */
    protected static void m28775e(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[5];
        m28776f(jArr, jArr4);
        m28776f(jArr2, jArr5);
        long[] jArr6 = new long[26];
        long[] jArr7 = jArr6;
        m28761a(jArr4[0], jArr5[0], jArr7, 0);
        m28761a(jArr4[1], jArr5[1], jArr7, 2);
        m28761a(jArr4[2], jArr5[2], jArr7, 4);
        m28761a(jArr4[3], jArr5[3], jArr7, 6);
        m28761a(jArr4[4], jArr5[4], jArr7, 8);
        long j = jArr4[0] ^ jArr4[1];
        long j2 = jArr5[0] ^ jArr5[1];
        long j3 = jArr4[0] ^ jArr4[2];
        long j4 = jArr5[0] ^ jArr5[2];
        long j5 = jArr4[2] ^ jArr4[4];
        long j6 = jArr5[2] ^ jArr5[4];
        long j7 = jArr4[3] ^ jArr4[4];
        long j8 = jArr5[3] ^ jArr5[4];
        m28761a(j3 ^ jArr4[3], j4 ^ jArr5[3], jArr7, 18);
        m28761a(j5 ^ jArr4[1], j6 ^ jArr5[1], jArr7, 20);
        long j9 = j ^ j7;
        long j10 = j2 ^ j8;
        long j11 = j9 ^ jArr4[2];
        long j12 = jArr5[2] ^ j10;
        jArr7 = jArr6;
        m28761a(j9, j10, jArr7, 22);
        m28761a(j11, j12, jArr7, 24);
        m28761a(j, j2, jArr7, 10);
        m28761a(j3, j4, jArr7, 12);
        m28761a(j5, j6, jArr7, 14);
        m28761a(j7, j8, jArr7, 16);
        jArr3[0] = jArr6[0];
        jArr3[9] = jArr6[9];
        j9 = jArr6[0] ^ jArr6[1];
        j10 = jArr6[2] ^ j9;
        long j13 = jArr6[10] ^ j10;
        jArr3[1] = j13;
        j = jArr6[3] ^ jArr6[4];
        j10 ^= j ^ (jArr6[11] ^ jArr6[12]);
        jArr3[2] = j10;
        long j14 = jArr6[5] ^ jArr6[6];
        j9 = ((j9 ^ j) ^ j14) ^ jArr6[8];
        long j15 = jArr6[13] ^ jArr6[14];
        jArr3[3] = (j9 ^ j15) ^ ((jArr6[18] ^ jArr6[22]) ^ jArr6[24]);
        long j16 = (jArr6[7] ^ jArr6[8]) ^ jArr6[9];
        j4 = j16 ^ jArr6[17];
        jArr3[8] = j4;
        j14 = (j16 ^ j14) ^ (jArr6[15] ^ jArr6[16]);
        jArr3[7] = j14;
        j13 ^= j14;
        j14 = (jArr6[19] ^ jArr6[20]) ^ (jArr6[25] ^ jArr6[24]);
        jArr3[4] = (j14 ^ (jArr6[18] ^ jArr6[23])) ^ j13;
        jArr3[5] = ((j10 ^ j4) ^ j14) ^ (jArr6[21] ^ jArr6[22]);
        jArr3[6] = ((((jArr6[9] ^ (j9 ^ jArr6[0])) ^ j15) ^ jArr6[21]) ^ jArr6[23]) ^ jArr6[25];
        m28762a(jArr3);
    }

    /* renamed from: a */
    protected static void m28761a(long j, long j2, long[] jArr, int i) {
        long j3 = j;
        long[] jArr2 = new long[8];
        jArr2[1] = j2;
        jArr2[2] = jArr2[1] << 1;
        jArr2[3] = jArr2[2] ^ j2;
        jArr2[4] = jArr2[2] << 1;
        jArr2[5] = jArr2[4] ^ j2;
        jArr2[6] = jArr2[3] << 1;
        jArr2[7] = jArr2[6] ^ j2;
        long j4 = 0;
        long j5 = jArr2[((int) j3) & 7];
        long j6 = 48;
        do {
            int i2 = (int) (j3 >>> j6);
            long j7 = (jArr2[i2 & 7] ^ (jArr2[(i2 >>> 3) & 7] << 3)) ^ (jArr2[(i2 >>> 6) & 7] << 6);
            j5 ^= j7 << j6;
            j4 ^= j7 >>> (-j6);
            j6 -= 9;
        } while (j6 > null);
        j3 = (((j3 & 72198606942111744L) & ((j2 << 7) >> 63)) >>> 8) ^ j4;
        jArr[i] = 144115188075855871L & j5;
        jArr[i + 1] = (j3 << 7) ^ (j5 >>> 57);
    }

    /* renamed from: g */
    protected static void m28777g(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 4; i++) {
            Interleave.m28829a(jArr[i], jArr2, i << 1);
        }
        jArr2[8] = Interleave.m28831c((int) jArr[4]);
    }
}
