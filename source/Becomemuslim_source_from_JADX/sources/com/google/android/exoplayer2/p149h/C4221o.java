package com.google.android.exoplayer2.p149h;

import com.google.android.exoplayer2.C2589y;
import com.google.android.exoplayer2.C2589y.C2587a;
import com.google.android.exoplayer2.C2589y.C2588b;
import com.google.android.exoplayer2.p164l.C2516a;

/* compiled from: SinglePeriodTimeline */
/* renamed from: com.google.android.exoplayer2.h.o */
public final class C4221o extends C2589y {
    /* renamed from: b */
    private static final Object f11113b = new Object();
    /* renamed from: c */
    private final long f11114c;
    /* renamed from: d */
    private final long f11115d;
    /* renamed from: e */
    private final long f11116e;
    /* renamed from: f */
    private final long f11117f;
    /* renamed from: g */
    private final long f11118g;
    /* renamed from: h */
    private final long f11119h;
    /* renamed from: i */
    private final boolean f11120i;
    /* renamed from: j */
    private final boolean f11121j;

    /* renamed from: b */
    public int mo2259b() {
        return 1;
    }

    /* renamed from: c */
    public int mo2260c() {
        return 1;
    }

    public C4221o(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    public C4221o(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2);
    }

    public C4221o(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.f11114c = j;
        this.f11115d = j2;
        this.f11116e = j3;
        this.f11117f = j4;
        this.f11118g = j5;
        this.f11119h = j6;
        this.f11120i = z;
        this.f11121j = z2;
    }

    /* renamed from: a */
    public C2588b mo2258a(int i, C2588b c2588b, boolean z, long j) {
        C4221o c4221o = this;
        C2516a.m7014a(i, 0, 1);
        Object obj = z ? f11113b : null;
        long j2 = c4221o.f11119h;
        if (c4221o.f11121j) {
            j2 += j;
            if (j2 > c4221o.f11117f) {
                j2 = -9223372036854775807L;
            }
        }
        return c2588b.m7317a(obj, c4221o.f11114c, c4221o.f11115d, c4221o.f11120i, c4221o.f11121j, j2, c4221o.f11117f, 0, 0, c4221o.f11118g);
    }

    /* renamed from: a */
    public C2587a mo2257a(int i, C2587a c2587a, boolean z) {
        C2516a.m7014a(i, 0, 1);
        Object obj = z ? f11113b : 0;
        return c2587a.m7305a(obj, obj, 0, this.f11116e, -this.f11118g);
    }

    /* renamed from: a */
    public int mo2256a(Object obj) {
        return f11113b.equals(obj) != null ? null : -1;
    }
}
