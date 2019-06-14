package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat448;

public class SecT409Field {
    /* renamed from: a */
    public static void m28783a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr2[6] ^ jArr[6];
    }

    /* renamed from: b */
    public static void m28786b(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 13; i++) {
            jArr3[i] = jArr[i] ^ jArr2[i];
        }
    }

    /* renamed from: a */
    public static void m28782a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
    }

    /* renamed from: a */
    public static long[] m28784a(BigInteger bigInteger) {
        long[] a = Nat448.m28985a(bigInteger);
        m28779a(a, 0);
        return a;
    }

    /* renamed from: b */
    public static void m28785b(long[] jArr, long[] jArr2) {
        if (Nat448.m28986b(jArr)) {
            throw new IllegalStateException();
        }
        long[] a = Nat448.m28984a();
        long[] a2 = Nat448.m28984a();
        long[] a3 = Nat448.m28984a();
        m28789d(jArr, a);
        m28780a(a, 1, a2);
        m28788c(a, a2, a);
        m28780a(a2, 1, a2);
        m28788c(a, a2, a);
        m28780a(a, (int) 3, a2);
        m28788c(a, a2, a);
        m28780a(a, (int) 6, a2);
        m28788c(a, a2, a);
        m28780a(a, (int) 12, a2);
        m28788c(a, a2, a3);
        m28780a(a3, 24, a);
        m28780a(a, 24, a2);
        m28788c(a, a2, a);
        m28780a(a, (int) 48, a2);
        m28788c(a, a2, a);
        m28780a(a, (int) 96, a2);
        m28788c(a, a2, a);
        m28780a(a, (int) 192, a2);
        m28788c(a, a2, a);
        m28788c(a, a3, jArr2);
    }

    /* renamed from: c */
    public static void m28788c(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b = Nat448.m28987b();
        m28792e(jArr, jArr2, b);
        m28787c(b, jArr3);
    }

    /* renamed from: d */
    public static void m28790d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b = Nat448.m28987b();
        m28792e(jArr, jArr2, b);
        m28786b(jArr3, b, jArr3);
    }

    /* renamed from: c */
    public static void m28787c(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[12];
        j6 ^= j9 << 39;
        j7 ^= (j9 >>> 25) ^ (j9 << 62);
        j8 ^= j9 >>> 2;
        j9 = jArr[11];
        j5 ^= j9 << 39;
        j6 ^= (j9 >>> 25) ^ (j9 << 62);
        j7 ^= j9 >>> 2;
        j9 = jArr[10];
        j4 ^= j9 << 39;
        j5 ^= (j9 >>> 25) ^ (j9 << 62);
        j6 ^= j9 >>> 2;
        j9 = jArr[9];
        j3 ^= j9 << 39;
        j4 ^= (j9 >>> 25) ^ (j9 << 62);
        j5 ^= j9 >>> 2;
        j9 = jArr[8];
        j4 ^= j9 >>> 2;
        j ^= j8 << 39;
        j2 = (j2 ^ (j9 << 39)) ^ ((j8 >>> 25) ^ (j8 << 62));
        j3 = (j3 ^ ((j9 >>> 25) ^ (j9 << 62))) ^ (j8 >>> 2);
        j8 = j7 >>> 25;
        jArr2[0] = j ^ j8;
        jArr2[1] = (j8 << 23) ^ j2;
        jArr2[2] = j3;
        jArr2[3] = j4;
        jArr2[4] = j5;
        jArr2[5] = j6;
        jArr2[6] = j7 & 33554431;
    }

    /* renamed from: a */
    public static void m28779a(long[] jArr, int i) {
        int i2 = i + 6;
        long j = jArr[i2];
        long j2 = j >>> 25;
        jArr[i] = jArr[i] ^ j2;
        i++;
        jArr[i] = (j2 << 23) ^ jArr[i];
        jArr[i2] = j & 33554431;
    }

    /* renamed from: d */
    public static void m28789d(long[] jArr, long[] jArr2) {
        long[] b = Nat.m29025b(13);
        m28794g(jArr, b);
        m28787c(b, jArr2);
    }

    /* renamed from: e */
    public static void m28791e(long[] jArr, long[] jArr2) {
        long[] b = Nat.m29025b(13);
        m28794g(jArr, b);
        m28786b(jArr2, b, jArr2);
    }

    /* renamed from: a */
    public static void m28780a(long[] jArr, int i, long[] jArr2) {
        long[] b = Nat.m29025b(13);
        m28794g(jArr, b);
        m28787c(b, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                m28794g(jArr2, b);
                m28787c(b, jArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    protected static void m28778a(long[] jArr) {
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
        long j11 = jArr[10];
        long j12 = jArr[11];
        long j13 = jArr[12];
        long j14 = jArr[13];
        jArr[0] = j ^ (j2 << 59);
        jArr[1] = (j2 >>> 5) ^ (j3 << 54);
        jArr[2] = (j3 >>> 10) ^ (j4 << 49);
        jArr[3] = (j4 >>> 15) ^ (j5 << 44);
        jArr[4] = (j5 >>> 20) ^ (j6 << 39);
        jArr[5] = (j6 >>> 25) ^ (j7 << 34);
        jArr[6] = (j7 >>> 30) ^ (j8 << 29);
        jArr[7] = (j8 >>> 35) ^ (j9 << 24);
        jArr[8] = (j9 >>> 40) ^ (j10 << 19);
        jArr[9] = (j10 >>> 45) ^ (j11 << 14);
        jArr[10] = (j11 >>> 50) ^ (j12 << 9);
        jArr[11] = ((j12 >>> 55) ^ (j13 << 4)) ^ (j14 << 63);
        jArr[12] = (j13 >>> 60) ^ (j14 >>> 1);
        jArr[13] = 0;
    }

    /* renamed from: f */
    protected static void m28793f(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        jArr2[0] = j & 576460752303423487L;
        jArr2[1] = ((j >>> 59) ^ (j2 << 5)) & 576460752303423487L;
        jArr2[2] = ((j2 >>> 54) ^ (j3 << 10)) & 576460752303423487L;
        jArr2[3] = ((j3 >>> 49) ^ (j4 << 15)) & 576460752303423487L;
        jArr2[4] = ((j4 >>> 44) ^ (j5 << 20)) & 576460752303423487L;
        jArr2[5] = ((j5 >>> 39) ^ (j6 << 25)) & 576460752303423487L;
        jArr2[6] = (j6 >>> 34) ^ (j7 << 30);
    }

    /* renamed from: e */
    protected static void m28792e(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[7];
        long[] jArr5 = new long[7];
        m28793f(jArr, jArr4);
        m28793f(jArr2, jArr5);
        for (jArr = null; jArr < 7; jArr++) {
            m28781a(jArr4, jArr5[jArr], jArr3, jArr);
        }
        m28778a(jArr3);
    }

    /* renamed from: a */
    protected static void m28781a(long[] jArr, long j, long[] jArr2, int i) {
        long[] jArr3 = new long[8];
        jArr3[1] = j;
        jArr3[2] = jArr3[1] << 1;
        jArr3[3] = jArr3[2] ^ j;
        jArr3[4] = jArr3[2] << 1;
        jArr3[5] = jArr3[4] ^ j;
        jArr3[6] = jArr3[3] << 1;
        int i2 = 7;
        jArr3[7] = jArr3[6] ^ j;
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = jArr[i3];
            int i4 = (int) j2;
            long j3 = 0;
            long j4 = jArr3[i4 & 7] ^ (jArr3[(i4 >>> 3) & i2] << 3);
            long j5 = 54;
            do {
                int i5 = (int) (j2 >>> j5);
                i2 = 7;
                long j6 = jArr3[i5 & 7] ^ (jArr3[(i5 >>> 3) & 7] << 3);
                j4 ^= j6 << j5;
                j3 ^= j6 >>> (-j5);
                j5 -= 6;
            } while (j5 > null);
            i4 = i + i3;
            jArr2[i4] = jArr2[i4] ^ (576460752303423487L & j4);
            i4++;
            jArr2[i4] = jArr2[i4] ^ ((j3 << 5) ^ (j4 >>> 59));
        }
    }

    /* renamed from: g */
    protected static void m28794g(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 6; i++) {
            Interleave.m28829a(jArr[i], jArr2, i << 1);
        }
        jArr2[12] = Interleave.m28831c((int) jArr[6]);
    }
}
