package com.google.android.exoplayer2.p137e.p196c;

import com.google.android.exoplayer2.p137e.C2325j;
import com.google.android.exoplayer2.p137e.p196c.C4105b.C4104a;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: ConstantBitrateSeeker */
/* renamed from: com.google.android.exoplayer2.e.c.a */
final class C4692a implements C4104a {
    /* renamed from: a */
    private final long f12667a;
    /* renamed from: b */
    private final int f12668b;
    /* renamed from: c */
    private final long f12669c;
    /* renamed from: d */
    private final int f12670d;
    /* renamed from: e */
    private final long f12671e;

    public C4692a(long j, long j2, C2325j c2325j) {
        this.f12667a = j2;
        this.f12668b = c2325j.f5771c;
        this.f12670d = c2325j.f5774f;
        if (j == -1) {
            this.f12669c = -1;
            this.f12671e = -9223372036854775807L;
            return;
        }
        this.f12669c = j - j2;
        this.f12671e = mo3195a(j);
    }

    /* renamed from: a */
    public boolean mo2167a() {
        return this.f12669c != -1;
    }

    /* renamed from: b */
    public long mo2169b(long j) {
        if (this.f12669c == -1) {
            return this.f12667a;
        }
        return this.f12667a + C2541v.m7169a((((j * ((long) this.f12670d)) / 8000000) / ((long) this.f12668b)) * ((long) this.f12668b), 0, this.f12669c - ((long) this.f12668b));
    }

    /* renamed from: a */
    public long mo3195a(long j) {
        return ((Math.max(0, j - this.f12667a) * 1000000) * 8) / ((long) this.f12670d);
    }

    /* renamed from: b */
    public long mo2168b() {
        return this.f12671e;
    }
}
