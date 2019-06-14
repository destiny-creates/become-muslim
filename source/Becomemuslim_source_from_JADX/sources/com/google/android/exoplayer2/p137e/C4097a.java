package com.google.android.exoplayer2.p137e;

import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: ChunkIndex */
/* renamed from: com.google.android.exoplayer2.e.a */
public final class C4097a implements C2327l {
    /* renamed from: a */
    public final int f10379a;
    /* renamed from: b */
    public final int[] f10380b;
    /* renamed from: c */
    public final long[] f10381c;
    /* renamed from: d */
    public final long[] f10382d;
    /* renamed from: e */
    public final long[] f10383e;
    /* renamed from: f */
    private final long f10384f;

    /* renamed from: a */
    public boolean mo2167a() {
        return true;
    }

    public C4097a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f10380b = iArr;
        this.f10381c = jArr;
        this.f10382d = jArr2;
        this.f10383e = jArr3;
        this.f10379a = iArr.length;
        if (this.f10379a > null) {
            this.f10384f = jArr2[this.f10379a - 1] + jArr3[this.f10379a - 1];
        } else {
            this.f10384f = null;
        }
    }

    /* renamed from: a */
    public int m12824a(long j) {
        return C2541v.m7167a(this.f10383e, j, true, true);
    }

    /* renamed from: b */
    public long mo2168b() {
        return this.f10384f;
    }

    /* renamed from: b */
    public long mo2169b(long j) {
        return this.f10381c[m12824a(j)];
    }
}
