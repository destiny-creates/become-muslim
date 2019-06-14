package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat128;

public class SecT113Field {
    /* renamed from: a */
    public static void m28667a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }

    /* renamed from: b */
    public static void m28670b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    /* renamed from: a */
    public static void m28666a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
    }

    /* renamed from: a */
    public static long[] m28668a(BigInteger bigInteger) {
        long[] b = Nat128.m28850b(bigInteger);
        m28664a(b, 0);
        return b;
    }

    /* renamed from: b */
    public static void m28669b(long[] jArr, long[] jArr2) {
        if (Nat128.m28848b(jArr)) {
            throw new IllegalStateException();
        }
        long[] b = Nat128.m28849b();
        long[] b2 = Nat128.m28849b();
        m28673d(jArr, b);
        m28672c(b, jArr, b);
        m28673d(b, b);
        m28672c(b, jArr, b);
        m28665a(b, 3, b2);
        m28672c(b2, b, b2);
        m28673d(b2, b2);
        m28672c(b2, jArr, b2);
        m28665a(b2, (int) 7, b);
        m28672c(b, b2, b);
        m28665a(b, (int) 14, b2);
        m28672c(b2, b, b2);
        m28665a(b2, (int) 28, b);
        m28672c(b, b2, b);
        m28665a(b, (int) 56, b2);
        m28672c(b2, b, b2);
        m28673d(b2, jArr2);
    }

    /* renamed from: c */
    public static void m28672c(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] d = Nat128.m28859d();
        m28676e(jArr, jArr2, d);
        m28671c(d, jArr3);
    }

    /* renamed from: d */
    public static void m28674d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] d = Nat128.m28859d();
        m28676e(jArr, jArr2, d);
        m28670b(jArr3, d, jArr3);
    }

    /* renamed from: c */
    public static void m28671c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        j3 ^= (j4 >>> 40) ^ (j4 >>> 49);
        j ^= (j3 << 15) ^ (j3 << 24);
        j2 = (j2 ^ ((j4 << 15) ^ (j4 << 24))) ^ ((j3 >>> 40) ^ (j3 >>> 49));
        j3 = j2 >>> 49;
        jArr2[0] = (j ^ j3) ^ (j3 << 9);
        jArr2[1] = 562949953421311L & j2;
    }

    /* renamed from: a */
    public static void m28664a(long[] jArr, int i) {
        int i2 = i + 1;
        long j = jArr[i2];
        long j2 = j >>> 49;
        jArr[i] = (j2 ^ (j2 << 9)) ^ jArr[i];
        jArr[i2] = j & 562949953421311L;
    }

    /* renamed from: d */
    public static void m28673d(long[] jArr, long[] jArr2) {
        long[] d = Nat128.m28859d();
        m28677f(jArr, d);
        m28671c(d, jArr2);
    }

    /* renamed from: e */
    public static void m28675e(long[] jArr, long[] jArr2) {
        long[] d = Nat128.m28859d();
        m28677f(jArr, d);
        m28670b(jArr2, d, jArr2);
    }

    /* renamed from: a */
    public static void m28665a(long[] jArr, int i, long[] jArr2) {
        long[] d = Nat128.m28859d();
        m28677f(jArr, d);
        m28671c(d, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                m28677f(jArr2, d);
                m28671c(d, jArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: e */
    protected static void m28676e(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr[0];
        long j2 = ((jArr[1] << 7) ^ (j >>> 57)) & 144115188075855871L;
        j &= 144115188075855871L;
        long j3 = jArr2[0];
        long j4 = ((jArr2[1] << 7) ^ (j3 >>> 57)) & 144115188075855871L;
        long j5 = 144115188075855871L & j3;
        long[] jArr4 = new long[6];
        long[] jArr5 = jArr4;
        m28663a(j, j5, jArr5, 0);
        m28663a(j2, j4, jArr5, 2);
        m28663a(j ^ j2, j5 ^ j4, jArr5, 4);
        j = jArr4[1] ^ jArr4[2];
        long j6 = jArr4[0];
        j3 = jArr4[3];
        long j7 = (jArr4[4] ^ j6) ^ j;
        j ^= jArr4[5] ^ j3;
        jArr3[0] = (j7 << 57) ^ j6;
        jArr3[1] = (j7 >>> 7) ^ (j << 50);
        jArr3[2] = (j >>> 14) ^ (j3 << 43);
        jArr3[3] = j3 >>> 21;
    }

    /* renamed from: a */
    protected static void m28663a(long j, long j2, long[] jArr, int i) {
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

    /* renamed from: f */
    protected static void m28677f(long[] jArr, long[] jArr2) {
        Interleave.m28829a(jArr[0], jArr2, 0);
        Interleave.m28829a(jArr[1], jArr2, 2);
    }
}
