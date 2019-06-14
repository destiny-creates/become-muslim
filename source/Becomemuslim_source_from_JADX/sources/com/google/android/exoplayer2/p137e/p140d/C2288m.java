package com.google.android.exoplayer2.p137e.p140d;

import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: TrackSampleTable */
/* renamed from: com.google.android.exoplayer2.e.d.m */
final class C2288m {
    /* renamed from: a */
    public final int f5608a;
    /* renamed from: b */
    public final long[] f5609b;
    /* renamed from: c */
    public final int[] f5610c;
    /* renamed from: d */
    public final int f5611d;
    /* renamed from: e */
    public final long[] f5612e;
    /* renamed from: f */
    public final int[] f5613f;

    public C2288m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = false;
        C2516a.m7017a(iArr.length == jArr2.length);
        C2516a.m7017a(jArr.length == jArr2.length);
        if (iArr2.length == jArr2.length) {
            z = true;
        }
        C2516a.m7017a(z);
        this.f5609b = jArr;
        this.f5610c = iArr;
        this.f5611d = i;
        this.f5612e = jArr2;
        this.f5613f = iArr2;
        this.f5608a = jArr.length;
    }

    /* renamed from: a */
    public int m6331a(long j) {
        for (j = C2541v.m7167a(this.f5612e, j, true, false); j >= null; j--) {
            if ((this.f5613f[j] & 1) != 0) {
                return j;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public int m6332b(long j) {
        for (j = C2541v.m7184b(this.f5612e, j, true, false); j < this.f5612e.length; j++) {
            if ((this.f5613f[j] & 1) != 0) {
                return j;
            }
        }
        return -1;
    }
}
