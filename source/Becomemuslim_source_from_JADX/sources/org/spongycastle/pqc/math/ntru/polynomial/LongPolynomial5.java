package org.spongycastle.pqc.math.ntru.polynomial;

import java.lang.reflect.Array;
import org.spongycastle.util.Arrays;

public class LongPolynomial5 {
    /* renamed from: a */
    private long[] f23419a;
    /* renamed from: b */
    private int f23420b;

    public LongPolynomial5(IntegerPolynomial integerPolynomial) {
        this.f23420b = integerPolynomial.f27879a.length;
        this.f23419a = new long[((this.f23420b + 4) / 5)];
        int i = 0;
        long j = null;
        for (int i2 = 0; i2 < this.f23420b; i2++) {
            long[] jArr = this.f23419a;
            jArr[i] = jArr[i] | (((long) integerPolynomial.f27879a[i2]) << j);
            j += 12;
            if (j >= 60) {
                i++;
                j = null;
            }
        }
    }

    private LongPolynomial5(long[] jArr, int i) {
        this.f23419a = jArr;
        this.f23420b = i;
    }

    /* renamed from: a */
    public LongPolynomial5 m29326a(TernaryPolynomial ternaryPolynomial) {
        int i;
        long[][] jArr = (long[][]) Array.newInstance(long.class, new int[]{5, (this.f23419a.length + ((ternaryPolynomial.mo6593c() + 4) / 5)) - 1});
        int[] a = ternaryPolynomial.mo6591a();
        for (i = 0; i != a.length; i++) {
            int i2 = a[i];
            int i3 = i2 / 5;
            i2 -= i3 * 5;
            int i4 = i3;
            for (long j : r0.f23419a) {
                jArr[i2][i4] = (jArr[i2][i4] + j) & 576319980446939135L;
                i4++;
            }
        }
        a = ternaryPolynomial.mo6592b();
        for (i = 0; i != a.length; i++) {
            i2 = a[i];
            i3 = i2 / 5;
            i2 -= i3 * 5;
            i4 = i3;
            for (long j2 : r0.f23419a) {
                jArr[i2][i4] = ((jArr[i2][i4] + 576601524159907840L) - j2) & 576319980446939135L;
                i4++;
            }
        }
        long[] a2 = Arrays.m29365a(jArr[0], jArr[0].length + 1);
        for (i = 1; i <= 4; i++) {
            i2 = i * 12;
            i3 = 60 - i2;
            long j3 = (1 << i3) - 1;
            i4 = jArr[i].length;
            int i5 = 0;
            while (i5 < i4) {
                long j4 = jArr[i][i5] >> i3;
                a2[i5] = (a2[i5] + ((jArr[i][i5] & j3) << i2)) & 576319980446939135L;
                i5++;
                a2[i5] = (a2[i5] + j4) & 576319980446939135L;
            }
        }
        int i6 = (r0.f23420b % 5) * 12;
        for (int length = r0.f23419a.length - 1; length < a2.length; length++) {
            long j5;
            if (length == r0.f23419a.length - 1) {
                j5 = r0.f23420b == 5 ? 0 : a2[length] >> i6;
                i3 = 0;
            } else {
                j5 = a2[length];
                i3 = (length * 5) - r0.f23420b;
            }
            i4 = i3 / 5;
            i3 -= i4 * 5;
            long j6 = j5 << (i3 * 12);
            j5 >>= (5 - i3) * 12;
            a2[i4] = (a2[i4] + j6) & 576319980446939135L;
            i4++;
            if (i4 < r0.f23419a.length) {
                a2[i4] = (a2[i4] + j5) & 576319980446939135L;
            }
        }
        return new LongPolynomial5(a2, r0.f23420b);
    }

    /* renamed from: a */
    public IntegerPolynomial m29325a() {
        int[] iArr = new int[this.f23420b];
        int i = 0;
        long j = null;
        for (int i2 = 0; i2 < this.f23420b; i2++) {
            iArr[i2] = (int) ((this.f23419a[i] >> j) & 2047);
            j += 12;
            if (j >= 60) {
                i++;
                j = null;
            }
        }
        return new IntegerPolynomial(iArr);
    }
}
