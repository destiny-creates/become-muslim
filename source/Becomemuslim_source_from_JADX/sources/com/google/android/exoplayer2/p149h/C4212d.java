package com.google.android.exoplayer2.p149h;

import com.facebook.common.time.Clock;

/* compiled from: CompositeSequenceableLoader */
/* renamed from: com.google.android.exoplayer2.h.d */
public final class C4212d implements C2437n {
    /* renamed from: a */
    private final C2437n[] f11072a;

    public C4212d(C2437n[] c2437nArr) {
        this.f11072a = c2437nArr;
    }

    /* renamed from: d */
    public final long mo2242d() {
        long j = Clock.MAX_TIME;
        for (C2437n d : this.f11072a) {
            long d2 = d.mo2242d();
            if (d2 != Long.MIN_VALUE) {
                j = Math.min(j, d2);
            }
        }
        return j == Clock.MAX_TIME ? Long.MIN_VALUE : j;
    }

    /* renamed from: e */
    public final long mo2243e() {
        long j = Clock.MAX_TIME;
        for (C2437n e : this.f11072a) {
            long e2 = e.mo2243e();
            if (e2 != Long.MIN_VALUE) {
                j = Math.min(j, e2);
            }
        }
        return j == Clock.MAX_TIME ? Long.MIN_VALUE : j;
    }

    /* renamed from: c */
    public final boolean mo2241c(long j) {
        long j2 = j;
        boolean z = false;
        int i;
        do {
            long e = mo2243e();
            if (e == Long.MIN_VALUE) {
                C4212d c4212d = this;
                break;
            }
            i = 0;
            for (C2437n c2437n : this.f11072a) {
                long e2 = c2437n.mo2243e();
                Object obj = (e2 == Long.MIN_VALUE || e2 > j2) ? null : 1;
                if (e2 == e || obj != null) {
                    i |= c2437n.mo2241c(j2);
                }
            }
            z |= i;
        } while (i != 0);
        return z;
    }
}
