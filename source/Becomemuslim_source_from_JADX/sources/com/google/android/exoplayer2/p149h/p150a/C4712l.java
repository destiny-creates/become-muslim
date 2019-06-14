package com.google.android.exoplayer2.p149h.p150a;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p164l.C2516a;

/* compiled from: MediaChunk */
/* renamed from: com.google.android.exoplayer2.h.a.l */
public abstract class C4712l extends C4168c {
    /* renamed from: i */
    public final int f12735i;

    /* renamed from: h */
    public abstract boolean mo3423h();

    public C4712l(C2498g c2498g, C2501j c2501j, C2515k c2515k, int i, Object obj, long j, long j2, int i2) {
        super(c2498g, c2501j, 1, c2515k, i, obj, j, j2);
        C2516a.m7015a((Object) c2515k);
        this.f12735i = i2;
    }

    /* renamed from: g */
    public int mo3525g() {
        return this.f12735i + 1;
    }
}
