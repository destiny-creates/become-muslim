package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat256;

public class SecT233Field {
    /* renamed from: a */
    public static void m28732a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    /* renamed from: b */
    public static void m28735b(long[] jArr, long[] jArr2, long[] jArr3) {
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
    public static void m28731a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    /* renamed from: a */
    public static long[] m28733a(BigInteger bigInteger) {
        long[] b = Nat256.m28959b(bigInteger);
        m28729a(b, 0);
        return b;
    }

    /* renamed from: b */
    public static void m28734b(long[] jArr, long[] jArr2) {
        if (Nat256.m28957b(jArr)) {
            throw new IllegalStateException();
        }
        long[] b = Nat256.m28958b();
        long[] b2 = Nat256.m28958b();
        m28738d(jArr, b);
        m28737c(b, jArr, b);
        m28738d(b, b);
        m28737c(b, jArr, b);
        m28730a(b, 3, b2);
        m28737c(b2, b, b2);
        m28738d(b2, b2);
        m28737c(b2, jArr, b2);
        m28730a(b2, 7, b);
        m28737c(b, b2, b);
        m28730a(b, 14, b2);
        m28737c(b2, b, b2);
        m28738d(b2, b2);
        m28737c(b2, jArr, b2);
        m28730a(b2, (int) 29, b);
        m28737c(b, b2, b);
        m28730a(b, (int) 58, b2);
        m28737c(b2, b, b2);
        m28730a(b2, (int) 116, b);
        m28737c(b, b2, b);
        m28738d(b, jArr2);
    }

    /* renamed from: c */
    public static void m28737c(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] d = Nat256.m28970d();
        m28741e(jArr, jArr2, d);
        m28736c(d, jArr3);
    }

    /* renamed from: d */
    public static void m28739d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] d = Nat256.m28970d();
        m28741e(jArr, jArr2, d);
        m28735b(jArr3, d, jArr3);
    }

    /* renamed from: c */
    public static void m28736c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        j6 ^= j8 >>> 31;
        j5 = (j5 ^ ((j8 >>> 41) ^ (j8 << 33))) ^ (j7 >>> 31);
        j4 = ((j4 ^ (j8 << 23)) ^ ((j7 >>> 41) ^ (j7 << 33))) ^ (j6 >>> 31);
        j ^= j5 << 23;
        j2 = (j2 ^ (j6 << 23)) ^ ((j5 >>> 41) ^ (j5 << 33));
        j3 = ((j3 ^ (j7 << 23)) ^ ((j6 >>> 41) ^ (j6 << 33))) ^ (j5 >>> 31);
        j5 = j4 >>> 41;
        jArr2[0] = j ^ j5;
        jArr2[1] = (j5 << 10) ^ j2;
        jArr2[2] = j3;
        jArr2[3] = 2199023255551L & j4;
    }

    /* renamed from: a */
    public static void m28729a(long[] jArr, int i) {
        int i2 = i + 3;
        long j = jArr[i2];
        long j2 = j >>> 41;
        jArr[i] = jArr[i] ^ j2;
        i++;
        jArr[i] = (j2 << 10) ^ jArr[i];
        jArr[i2] = j & 2199023255551L;
    }

    /* renamed from: d */
    public static void m28738d(long[] jArr, long[] jArr2) {
        long[] d = Nat256.m28970d();
        m28743g(jArr, d);
        m28736c(d, jArr2);
    }

    /* renamed from: e */
    public static void m28740e(long[] jArr, long[] jArr2) {
        long[] d = Nat256.m28970d();
        m28743g(jArr, d);
        m28735b(jArr2, d, jArr2);
    }

    /* renamed from: a */
    public static void m28730a(long[] jArr, int i, long[] jArr2) {
        long[] d = Nat256.m28970d();
        m28743g(jArr, d);
        m28736c(d, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                m28743g(jArr2, d);
                m28736c(d, jArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    protected static void m28728a(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        jArr[0] = j ^ (j2 << 59);
        jArr[1] = (j2 >>> 5) ^ (j3 << 54);
        jArr[2] = (j3 >>> 10) ^ (j4 << 49);
        jArr[3] = (j4 >>> 15) ^ (j5 << 44);
        jArr[4] = (j5 >>> 20) ^ (j6 << 39);
        jArr[5] = (j6 >>> 25) ^ (j7 << 34);
        jArr[6] = (j7 >>> 30) ^ (j8 << 29);
        jArr[7] = j8 >>> 35;
    }

    /* renamed from: f */
    protected static void m28742f(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        jArr2[0] = j & 576460752303423487L;
        jArr2[1] = ((j >>> 59) ^ (j2 << 5)) & 576460752303423487L;
        jArr2[2] = ((j2 >>> 54) ^ (j3 << 10)) & 576460752303423487L;
        jArr2[3] = (j3 >>> 49) ^ (j4 << 15);
    }

    /* renamed from: e */
    protected static void m28741e(long[] jArr, long[] jArr2, long[] jArr3) {
        int i;
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        m28742f(jArr, jArr4);
        m28742f(jArr2, jArr5);
        long[] jArr6 = jArr3;
        m28727a(jArr4[0], jArr5[0], jArr6, 0);
        m28727a(jArr4[1], jArr5[1], jArr6, 1);
        m28727a(jArr4[2], jArr5[2], jArr6, 2);
        m28727a(jArr4[3], jArr5[3], jArr6, 3);
        for (i = 5; i > 0; i--) {
            jArr3[i] = jArr3[i] ^ jArr3[i - 1];
        }
        m28727a(jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        m28727a(jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (i = 7; i > 1; i--) {
            jArr3[i] = jArr3[i] ^ jArr3[i - 2];
        }
        long j = jArr4[0] ^ jArr4[2];
        long j2 = jArr4[1] ^ jArr4[3];
        long j3 = jArr5[0] ^ jArr5[2];
        long j4 = jArr5[1] ^ jArr5[3];
        m28727a(j ^ j2, j3 ^ j4, jArr3, 3);
        long[] jArr7 = new long[3];
        m28727a(j, j3, jArr7, 0);
        m28727a(j2, j4, jArr7, 1);
        long j5 = jArr7[0];
        long j6 = jArr7[1];
        j4 = jArr7[2];
        jArr3[2] = jArr3[2] ^ j5;
        jArr3[3] = (j5 ^ j6) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j4 ^ j6);
        jArr3[5] = jArr3[5] ^ j4;
        m28728a(jArr3);
    }

    /* renamed from: a */
    protected static void m28727a(long j, long j2, long[] jArr, int i) {
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
        long j6 = 54;
        while (true) {
            int i4 = (int) (j3 >>> j6);
            long j7 = jArr2[i4 & 7] ^ (jArr2[(i4 >>> 3) & i2] << 3);
            j4 ^= j7 << j6;
            j5 ^= j7 >>> (-j6);
            j6 -= 6;
            if (j6 <= null) {
                jArr[i] = jArr[i] ^ (576460752303423487L & j4);
                int i5 = i + 1;
                jArr[i5] = ((j4 >>> 59) ^ (j5 << 5)) ^ jArr[i5];
                return;
            }
            i2 = 7;
        }
    }

    /* renamed from: g */
    protected static void m28743g(long[] jArr, long[] jArr2) {
        Interleave.m28829a(jArr[0], jArr2, 0);
        Interleave.m28829a(jArr[1], jArr2, 2);
        Interleave.m28829a(jArr[2], jArr2, 4);
        long j = jArr[3];
        jArr2[6] = Interleave.m28831c((int) j);
        jArr2[7] = ((long) Interleave.m28830b((int) (j >>> 32))) & 4294967295L;
    }
}
