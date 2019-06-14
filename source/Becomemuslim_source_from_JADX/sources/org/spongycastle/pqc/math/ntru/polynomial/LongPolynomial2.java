package org.spongycastle.pqc.math.ntru.polynomial;

import org.spongycastle.util.Arrays;

public class LongPolynomial2 {
    /* renamed from: a */
    private long[] f23417a;
    /* renamed from: b */
    private int f23418b;

    public LongPolynomial2(IntegerPolynomial integerPolynomial) {
        this.f23418b = integerPolynomial.f27879a.length;
        this.f23417a = new long[((this.f23418b + 1) / 2)];
        int i = 0;
        int i2;
        for (int i3 = 0; i3 < this.f23418b; i3 = i2) {
            long j;
            int i4 = i3 + 1;
            i3 = integerPolynomial.f27879a[i3];
            while (i3 < 0) {
                i3 += 2048;
            }
            if (i4 < this.f23418b) {
                i2 = i4 + 1;
                j = (long) integerPolynomial.f27879a[i4];
            } else {
                i2 = i4;
                j = 0;
            }
            while (j < 0) {
                j += 2048;
            }
            this.f23417a[i] = ((long) i3) + (j << 24);
            i++;
        }
    }

    private LongPolynomial2(long[] jArr) {
        this.f23417a = jArr;
    }

    private LongPolynomial2(int i) {
        this.f23417a = new long[i];
    }

    /* renamed from: a */
    public LongPolynomial2 m29322a(LongPolynomial2 longPolynomial2) {
        int length = this.f23417a.length;
        if (longPolynomial2.f23417a.length == length && this.f23418b == longPolynomial2.f23418b) {
            longPolynomial2 = m29318b(longPolynomial2);
            if (longPolynomial2.f23417a.length > length) {
                int i;
                if (this.f23418b % 2 == 0) {
                    for (i = length; i < longPolynomial2.f23417a.length; i++) {
                        int i2 = i - length;
                        longPolynomial2.f23417a[i2] = (longPolynomial2.f23417a[i2] + longPolynomial2.f23417a[i]) & 34342963199L;
                    }
                    longPolynomial2.f23417a = Arrays.m29365a(longPolynomial2.f23417a, length);
                } else {
                    for (i = length; i < longPolynomial2.f23417a.length; i++) {
                        int i3 = i - length;
                        longPolynomial2.f23417a[i3] = longPolynomial2.f23417a[i3] + (longPolynomial2.f23417a[i - 1] >> 24);
                        longPolynomial2.f23417a[i3] = longPolynomial2.f23417a[i3] + ((2047 & longPolynomial2.f23417a[i]) << 24);
                        long[] jArr = longPolynomial2.f23417a;
                        jArr[i3] = jArr[i3] & 34342963199L;
                    }
                    longPolynomial2.f23417a = Arrays.m29365a(longPolynomial2.f23417a, length);
                    long[] jArr2 = longPolynomial2.f23417a;
                    i = longPolynomial2.f23417a.length - 1;
                    jArr2[i] = jArr2[i] & 2047;
                }
            }
            LongPolynomial2 longPolynomial22 = new LongPolynomial2(longPolynomial2.f23417a);
            longPolynomial22.f23418b = this.f23418b;
            return longPolynomial22;
        }
        throw new IllegalArgumentException("Number of coefficients must be the same");
    }

    /* renamed from: a */
    public IntegerPolynomial m29321a() {
        int[] iArr = new int[this.f23418b];
        int i = 0;
        for (int i2 = 0; i2 < this.f23417a.length; i2++) {
            int i3 = i + 1;
            iArr[i] = (int) (this.f23417a[i2] & 2047);
            if (i3 < this.f23418b) {
                i = i3 + 1;
                iArr[i3] = (int) ((this.f23417a[i2] >> 24) & 2047);
            } else {
                i = i3;
            }
        }
        return new IntegerPolynomial(iArr);
    }

    /* renamed from: b */
    private LongPolynomial2 m29318b(LongPolynomial2 longPolynomial2) {
        LongPolynomial2 longPolynomial22 = longPolynomial2;
        long[] jArr = this.f23417a;
        long[] jArr2 = longPolynomial22.f23417a;
        int length = longPolynomial22.f23417a.length;
        int i = 0;
        LongPolynomial2 longPolynomial23;
        int i2;
        if (length <= 32) {
            int i3 = length * 2;
            longPolynomial23 = new LongPolynomial2(new long[i3]);
            i2 = 0;
            while (i2 < i3) {
                for (int max = Math.max(i, (i2 - length) + 1); max <= Math.min(i2, length - 1); max++) {
                    long j = jArr[i2 - max] * jArr2[max];
                    long j2 = j & ((j & 2047) + 34342961152L);
                    j = (j >>> 48) & 2047;
                    longPolynomial23.f23417a[i2] = (longPolynomial23.f23417a[i2] + j2) & 34342963199L;
                    int i4 = i2 + 1;
                    longPolynomial23.f23417a[i4] = (longPolynomial23.f23417a[i4] + j) & 34342963199L;
                }
                i2++;
                i = 0;
            }
            return longPolynomial23;
        }
        i = length / 2;
        LongPolynomial2 longPolynomial24 = new LongPolynomial2(Arrays.m29365a(jArr, i));
        longPolynomial23 = new LongPolynomial2(Arrays.m29378b(jArr, i, length));
        LongPolynomial2 longPolynomial25 = new LongPolynomial2(Arrays.m29365a(jArr2, i));
        LongPolynomial2 longPolynomial26 = new LongPolynomial2(Arrays.m29378b(jArr2, i, length));
        LongPolynomial2 longPolynomial27 = (LongPolynomial2) longPolynomial24.clone();
        longPolynomial27.m29319c(longPolynomial23);
        LongPolynomial2 longPolynomial28 = (LongPolynomial2) longPolynomial25.clone();
        longPolynomial28.m29319c(longPolynomial26);
        longPolynomial25 = longPolynomial24.m29318b(longPolynomial25);
        longPolynomial24 = longPolynomial23.m29318b(longPolynomial26);
        longPolynomial27 = longPolynomial27.m29318b(longPolynomial28);
        longPolynomial27.m29320d(longPolynomial25);
        longPolynomial27.m29320d(longPolynomial24);
        longPolynomial23 = new LongPolynomial2(length * 2);
        for (length = 0; length < longPolynomial25.f23417a.length; length++) {
            longPolynomial23.f23417a[length] = longPolynomial25.f23417a[length] & 34342963199L;
        }
        for (length = 0; length < longPolynomial27.f23417a.length; length++) {
            i2 = i + length;
            longPolynomial23.f23417a[i2] = (longPolynomial23.f23417a[i2] + longPolynomial27.f23417a[length]) & 34342963199L;
        }
        for (length = 0; length < longPolynomial24.f23417a.length; length++) {
            int i5 = (i * 2) + length;
            longPolynomial23.f23417a[i5] = (longPolynomial23.f23417a[i5] + longPolynomial24.f23417a[length]) & 34342963199L;
        }
        return longPolynomial23;
    }

    /* renamed from: c */
    private void m29319c(LongPolynomial2 longPolynomial2) {
        if (longPolynomial2.f23417a.length > this.f23417a.length) {
            this.f23417a = Arrays.m29365a(this.f23417a, longPolynomial2.f23417a.length);
        }
        for (int i = 0; i < longPolynomial2.f23417a.length; i++) {
            this.f23417a[i] = (this.f23417a[i] + longPolynomial2.f23417a[i]) & 34342963199L;
        }
    }

    /* renamed from: d */
    private void m29320d(LongPolynomial2 longPolynomial2) {
        if (longPolynomial2.f23417a.length > this.f23417a.length) {
            this.f23417a = Arrays.m29365a(this.f23417a, longPolynomial2.f23417a.length);
        }
        for (int i = 0; i < longPolynomial2.f23417a.length; i++) {
            this.f23417a[i] = 34342963199L & ((this.f23417a[i] + 140737496743936L) - longPolynomial2.f23417a[i]);
        }
    }

    /* renamed from: a */
    public void m29324a(LongPolynomial2 longPolynomial2, int i) {
        long j = (long) i;
        long j2 = (j << 24) + j;
        for (i = 0; i < longPolynomial2.f23417a.length; i++) {
            this.f23417a[i] = ((this.f23417a[i] + 140737496743936L) - longPolynomial2.f23417a[i]) & j2;
        }
    }

    /* renamed from: a */
    public void m29323a(int i) {
        long j = (long) i;
        long j2 = (j << 24) + j;
        for (i = 0; i < this.f23417a.length; i++) {
            this.f23417a[i] = (this.f23417a[i] << 1) & j2;
        }
    }

    public Object clone() {
        LongPolynomial2 longPolynomial2 = new LongPolynomial2((long[]) this.f23417a.clone());
        longPolynomial2.f23418b = this.f23418b;
        return longPolynomial2;
    }

    public boolean equals(Object obj) {
        return obj instanceof LongPolynomial2 ? Arrays.m29357a(this.f23417a, ((LongPolynomial2) obj).f23417a) : null;
    }
}
