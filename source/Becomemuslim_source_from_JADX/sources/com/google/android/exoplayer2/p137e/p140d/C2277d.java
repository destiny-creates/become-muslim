package com.google.android.exoplayer2.p137e.p140d;

import com.facebook.internal.Utility;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: FixedSampleSizeRechunker */
/* renamed from: com.google.android.exoplayer2.e.d.d */
final class C2277d {

    /* compiled from: FixedSampleSizeRechunker */
    /* renamed from: com.google.android.exoplayer2.e.d.d$a */
    public static final class C2276a {
        /* renamed from: a */
        public final long[] f5521a;
        /* renamed from: b */
        public final int[] f5522b;
        /* renamed from: c */
        public final int f5523c;
        /* renamed from: d */
        public final long[] f5524d;
        /* renamed from: e */
        public final int[] f5525e;

        private C2276a(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
            this.f5521a = jArr;
            this.f5522b = iArr;
            this.f5523c = i;
            this.f5524d = jArr2;
            this.f5525e = iArr2;
        }
    }

    /* renamed from: a */
    public static C2276a m6301a(int i, long[] jArr, int[] iArr, long j) {
        int[] iArr2 = iArr;
        int i2 = Utility.DEFAULT_STREAM_BUFFER_SIZE / i;
        int i3 = 0;
        int i4 = 0;
        for (int a : iArr2) {
            i4 += C2541v.m7163a(a, i2);
        }
        long[] jArr2 = new long[i4];
        int[] iArr3 = new int[i4];
        long[] jArr3 = new long[i4];
        int[] iArr4 = new int[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i3 < iArr2.length) {
            i4 = iArr2[i3];
            long j2 = jArr[i3];
            while (i4 > 0) {
                int min = Math.min(i2, i4);
                jArr2[i5] = j2;
                iArr3[i5] = i * min;
                i7 = Math.max(i7, iArr3[i5]);
                jArr3[i5] = ((long) i6) * j;
                iArr4[i5] = 1;
                j2 += (long) iArr3[i5];
                i6 += min;
                i4 -= min;
                i5++;
                iArr2 = iArr;
            }
            i3++;
            iArr2 = iArr;
        }
        return new C2276a(jArr2, iArr3, i7, jArr3, iArr4);
    }
}
