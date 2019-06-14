package org.spongycastle.math.ec.custom.sec;

import com.facebook.imagepipeline.common.RotationOptions;
import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat576;

public class SecT571Field {
    /* renamed from: a */
    public static void m28799a(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 9; i++) {
            jArr3[i] = jArr[i] ^ jArr2[i];
        }
    }

    /* renamed from: a */
    private static void m28797a(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3) {
        for (int i4 = 0; i4 < 9; i4++) {
            jArr3[i3 + i4] = jArr[i + i4] ^ jArr2[i2 + i4];
        }
    }

    /* renamed from: b */
    private static void m28801b(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3) {
        for (int i4 = 0; i4 < 9; i4++) {
            int i5 = i3 + i4;
            jArr3[i5] = jArr3[i5] ^ (jArr[i + i4] ^ jArr2[i2 + i4]);
        }
    }

    /* renamed from: b */
    public static void m28803b(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 18; i++) {
            jArr3[i] = jArr[i] ^ jArr2[i];
        }
    }

    /* renamed from: a */
    public static void m28798a(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        for (int i = 1; i < 9; i++) {
            jArr2[i] = jArr[i];
        }
    }

    /* renamed from: a */
    public static long[] m28800a(BigInteger bigInteger) {
        long[] a = Nat576.m28994a(bigInteger);
        m28795a(a, 0);
        return a;
    }

    /* renamed from: b */
    public static void m28802b(long[] jArr, long[] jArr2) {
        if (Nat576.m28995b(jArr)) {
            throw new IllegalStateException();
        }
        long[] a = Nat576.m28993a();
        long[] a2 = Nat576.m28993a();
        long[] a3 = Nat576.m28993a();
        m28806d(jArr, a3);
        m28806d(a3, a);
        m28806d(a, a2);
        m28805c(a, a2, a);
        m28796a(a, (int) 2, a2);
        m28805c(a, a2, a);
        m28805c(a, a3, a);
        m28796a(a, 5, a2);
        m28805c(a, a2, a);
        m28796a(a2, 5, a2);
        m28805c(a, a2, a);
        m28796a(a, (int) 15, a2);
        m28805c(a, a2, a3);
        m28796a(a3, 30, a);
        m28796a(a, 30, a2);
        m28805c(a, a2, a);
        m28796a(a, 60, a2);
        m28805c(a, a2, a);
        m28796a(a2, 60, a2);
        m28805c(a, a2, a);
        m28796a(a, (int) RotationOptions.ROTATE_180, a2);
        m28805c(a, a2, a);
        m28796a(a2, (int) RotationOptions.ROTATE_180, a2);
        m28805c(a, a2, a);
        m28805c(a, a3, jArr2);
    }

    /* renamed from: c */
    public static void m28805c(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b = Nat576.m28996b();
        m28809e(jArr, jArr2, b);
        m28804c(b, jArr3);
    }

    /* renamed from: d */
    public static void m28807d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] b = Nat576.m28996b();
        m28809e(jArr, jArr2, b);
        m28803b(jArr3, b, jArr3);
    }

    /* renamed from: c */
    public static void m28804c(long[] jArr, long[] jArr2) {
        long j = jArr[9];
        long j2 = jArr[17];
        j = (((j ^ (j2 >>> 59)) ^ (j2 >>> 57)) ^ (j2 >>> 54)) ^ (j2 >>> 49);
        j2 = (j2 << 15) ^ (((jArr[8] ^ (j2 << 5)) ^ (j2 << 7)) ^ (j2 << 10));
        for (int i = 16; i >= 10; i--) {
            long j3 = jArr[i];
            jArr2[i - 8] = (((j2 ^ (j3 >>> 59)) ^ (j3 >>> 57)) ^ (j3 >>> 54)) ^ (j3 >>> 49);
            j2 = (((jArr[i - 9] ^ (j3 << 5)) ^ (j3 << 7)) ^ (j3 << 10)) ^ (j3 << 15);
        }
        jArr2[1] = (((j2 ^ (j >>> 59)) ^ (j >>> 57)) ^ (j >>> 54)) ^ (j >>> 49);
        j = (j << 15) ^ (((jArr[0] ^ (j << 5)) ^ (j << 7)) ^ (j << 10));
        long j4 = jArr2[8];
        long j5 = j4 >>> 59;
        jArr2[0] = (((j ^ j5) ^ (j5 << 2)) ^ (j5 << 5)) ^ (j5 << 10);
        jArr2[8] = 576460752303423487L & j4;
    }

    /* renamed from: a */
    public static void m28795a(long[] jArr, int i) {
        int i2 = i + 8;
        long j = jArr[i2];
        long j2 = j >>> 59;
        jArr[i] = ((j2 << 10) ^ (((j2 << 2) ^ j2) ^ (j2 << 5))) ^ jArr[i];
        jArr[i2] = j & 576460752303423487L;
    }

    /* renamed from: d */
    public static void m28806d(long[] jArr, long[] jArr2) {
        long[] b = Nat576.m28996b();
        m28810f(jArr, b);
        m28804c(b, jArr2);
    }

    /* renamed from: e */
    public static void m28808e(long[] jArr, long[] jArr2) {
        long[] b = Nat576.m28996b();
        m28810f(jArr, b);
        m28803b(jArr2, b, jArr2);
    }

    /* renamed from: a */
    public static void m28796a(long[] jArr, int i, long[] jArr2) {
        long[] b = Nat576.m28996b();
        m28810f(jArr, b);
        m28804c(b, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                m28810f(jArr2, b);
                m28804c(b, jArr2);
            } else {
                return;
            }
        }
    }

    /* renamed from: e */
    protected static void m28809e(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[144];
        System.arraycopy(jArr2, 0, jArr4, 9, 9);
        jArr2 = 7;
        int i = 0;
        while (jArr2 > null) {
            int i2 = i + 18;
            Nat.m29014a(9, jArr4, i2 >>> 1, 0, jArr4, i2);
            m28795a(jArr4, i2);
            m28797a(jArr4, 9, jArr4, i2, jArr4, i2 + 9);
            jArr2--;
            i = i2;
        }
        jArr2 = new long[jArr4.length];
        Nat.m29013a(jArr4.length, jArr4, 0, 4, 0, jArr2, 0);
        for (i2 = 56; i2 >= 0; i2 -= 8) {
            for (int i3 = 1; i3 < 9; i3 += 2) {
                i = (int) (jArr[i3] >>> i2);
                int i4 = i & 15;
                m28801b(jArr4, i4 * 9, jArr2, ((i >>> 4) & 15) * 9, jArr3, i3 - 1);
            }
            Nat.m29012a(16, jArr3, 0, 8, 0);
        }
        for (int i5 = 56; i5 >= 0; i5 -= 8) {
            for (i2 = 0; i2 < 9; i2 += 2) {
                i = (int) (jArr[i2] >>> i5);
                i4 = i & 15;
                int i6 = ((i >>> 4) & 15) * 9;
                m28801b(jArr4, i4 * 9, jArr2, i6, jArr3, i2);
            }
            if (i5 > 0) {
                Nat.m29012a(18, jArr3, 0, 8, 0);
            }
        }
    }

    /* renamed from: f */
    protected static void m28810f(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 9; i++) {
            Interleave.m28829a(jArr[i], jArr2, i << 1);
        }
    }
}
