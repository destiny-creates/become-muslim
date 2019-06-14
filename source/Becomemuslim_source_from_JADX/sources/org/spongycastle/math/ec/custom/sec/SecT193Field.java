package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat256;

public class SecT193Field {
    /* renamed from: a */
    public static void m28715a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    /* renamed from: b */
    public static void m28718b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr2[6] ^ jArr[6];
    }

    /* renamed from: a */
    public static void m28714a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    /* renamed from: a */
    public static long[] m28716a(BigInteger bigInteger) {
        long[] b = Nat256.m28959b(bigInteger);
        m28712a(b, 0);
        return b;
    }

    /* renamed from: b */
    public static void m28717b(long[] jArr, long[] jArr2) {
        if (Nat256.m28957b(jArr)) {
            throw new IllegalStateException();
        }
        long[] b = Nat256.m28958b();
        long[] b2 = Nat256.m28958b();
        m28721d(jArr, b);
        m28713a(b, 1, b2);
        m28720c(b, b2, b);
        m28713a(b2, 1, b2);
        m28720c(b, b2, b);
        m28713a(b, (int) 3, b2);
        m28720c(b, b2, b);
        m28713a(b, (int) 6, b2);
        m28720c(b, b2, b);
        m28713a(b, (int) 12, b2);
        m28720c(b, b2, b);
        m28713a(b, (int) 24, b2);
        m28720c(b, b2, b);
        m28713a(b, (int) 48, b2);
        m28720c(b, b2, b);
        m28713a(b, (int) 96, b2);
        m28720c(b, b2, jArr2);
    }

    /* renamed from: c */
    public static void m28720c(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] d = Nat256.m28970d();
        m28724e(jArr, jArr2, d);
        m28719c(d, jArr3);
    }

    /* renamed from: d */
    public static void m28722d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] d = Nat256.m28970d();
        m28724e(jArr, jArr2, d);
        m28718b(jArr3, d, jArr3);
    }

    /* renamed from: c */
    public static void m28719c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        j5 ^= j7 >>> 50;
        j4 = (j4 ^ ((j7 >>> 1) ^ (j7 << 14))) ^ (j6 >>> 50);
        j ^= j5 << 63;
        j2 = (j2 ^ (j6 << 63)) ^ ((j5 >>> 1) ^ (j5 << 14));
        j3 = ((j3 ^ (j7 << 63)) ^ ((j6 >>> 1) ^ (j6 << 14))) ^ (j5 >>> 50);
        j5 = j4 >>> 1;
        jArr2[0] = (j ^ j5) ^ (j5 << 15);
        jArr2[1] = (j5 >>> 49) ^ j2;
        jArr2[2] = j3;
        jArr2[3] = 1 & j4;
    }

    /* renamed from: a */
    public static void m28712a(long[] jArr, int i) {
        int i2 = i + 3;
        long j = jArr[i2];
        long j2 = j >>> 1;
        jArr[i] = jArr[i] ^ ((j2 << 15) ^ j2);
        i++;
        jArr[i] = (j2 >>> 49) ^ jArr[i];
        jArr[i2] = j & 1;
    }

    /* renamed from: d */
    public static void m28721d(long[] jArr, long[] jArr2) {
        long[] d = Nat256.m28970d();
        m28726g(jArr, d);
        m28719c(d, jArr2);
    }

    /* renamed from: e */
    public static void m28723e(long[] jArr, long[] jArr2) {
        long[] d = Nat256.m28970d();
        m28726g(jArr, d);
        m28718b(jArr2, d, jArr2);
    }

    /* renamed from: a */
    public static void m28713a(long[] jArr, int i, long[] jArr2) {
        long[] d = Nat256.m28970d();
        m28726g(jArr, d);
        m28719c(d, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                m28726g(jArr2, d);
                m28719c(d, jArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    protected static void m28711a(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        jArr[0] = j ^ (j2 << 49);
        jArr[1] = (j2 >>> 15) ^ (j3 << 34);
        jArr[2] = (j3 >>> 30) ^ (j4 << 19);
        jArr[3] = ((j4 >>> 45) ^ (j5 << 4)) ^ (j6 << 53);
        jArr[4] = ((j5 >>> 60) ^ (j7 << 38)) ^ (j6 >>> 11);
        jArr[5] = (j7 >>> 26) ^ (j8 << 23);
        jArr[6] = j8 >>> 41;
        jArr[7] = 0;
    }

    /* renamed from: f */
    protected static void m28725f(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        jArr2[0] = j & 562949953421311L;
        jArr2[1] = ((j >>> 49) ^ (j2 << 15)) & 562949953421311L;
        jArr2[2] = ((j2 >>> 34) ^ (j3 << 30)) & 562949953421311L;
        jArr2[3] = (j3 >>> 19) ^ (j4 << 45);
    }

    /* renamed from: e */
    protected static void m28724e(long[] jArr, long[] jArr2, long[] jArr3) {
        int i;
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        m28725f(jArr, jArr4);
        m28725f(jArr2, jArr5);
        long[] jArr6 = jArr3;
        m28710a(jArr4[0], jArr5[0], jArr6, 0);
        m28710a(jArr4[1], jArr5[1], jArr6, 1);
        m28710a(jArr4[2], jArr5[2], jArr6, 2);
        m28710a(jArr4[3], jArr5[3], jArr6, 3);
        for (i = 5; i > 0; i--) {
            jArr3[i] = jArr3[i] ^ jArr3[i - 1];
        }
        m28710a(jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        m28710a(jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (i = 7; i > 1; i--) {
            jArr3[i] = jArr3[i] ^ jArr3[i - 2];
        }
        long j = jArr4[0] ^ jArr4[2];
        long j2 = jArr4[1] ^ jArr4[3];
        long j3 = jArr5[0] ^ jArr5[2];
        long j4 = jArr5[1] ^ jArr5[3];
        m28710a(j ^ j2, j3 ^ j4, jArr3, 3);
        long[] jArr7 = new long[3];
        m28710a(j, j3, jArr7, 0);
        m28710a(j2, j4, jArr7, 1);
        long j5 = jArr7[0];
        long j6 = jArr7[1];
        j4 = jArr7[2];
        jArr3[2] = jArr3[2] ^ j5;
        jArr3[3] = (j5 ^ j6) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j4 ^ j6);
        jArr3[5] = jArr3[5] ^ j4;
        m28711a(jArr3);
    }

    /* renamed from: a */
    protected static void m28710a(long j, long j2, long[] jArr, int i) {
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
        long j4 = (jArr2[(i3 >>> 3) & 7] << 3) ^ jArr2[i3 & 7];
        long j5 = 0;
        long j6 = 36;
        while (true) {
            int i4 = (int) (j3 >>> j6);
            long j7 = (((jArr2[i4 & 7] ^ (jArr2[(i4 >>> 3) & 7] << 3)) ^ (jArr2[(i4 >>> 6) & 7] << 6)) ^ (jArr2[(i4 >>> 9) & 7] << 9)) ^ (jArr2[(i4 >>> 12) & i2] << 12);
            j4 ^= j7 << j6;
            j5 ^= j7 >>> (-j6);
            j6 -= 15;
            if (j6 <= null) {
                jArr[i] = jArr[i] ^ (562949953421311L & j4);
                int i5 = i + 1;
                jArr[i5] = ((j4 >>> 49) ^ (j5 << 15)) ^ jArr[i5];
                return;
            }
            i2 = 7;
        }
    }

    /* renamed from: g */
    protected static void m28726g(long[] jArr, long[] jArr2) {
        Interleave.m28829a(jArr[0], jArr2, 0);
        Interleave.m28829a(jArr[1], jArr2, 2);
        Interleave.m28829a(jArr[2], jArr2, 4);
        jArr2[6] = jArr[3] & 1;
    }
}
