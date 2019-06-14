package com.google.android.exoplayer2.p149h.p150a;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p163k.C4251s.C2508c;
import com.google.android.exoplayer2.p164l.C2516a;

/* compiled from: Chunk */
/* renamed from: com.google.android.exoplayer2.h.a.c */
public abstract class C4168c implements C2508c {
    /* renamed from: a */
    public final C2501j f10804a;
    /* renamed from: b */
    public final int f10805b;
    /* renamed from: c */
    public final C2515k f10806c;
    /* renamed from: d */
    public final int f10807d;
    /* renamed from: e */
    public final Object f10808e;
    /* renamed from: f */
    public final long f10809f;
    /* renamed from: g */
    public final long f10810g;
    /* renamed from: h */
    protected final C2498g f10811h;

    /* renamed from: f */
    public abstract long mo3197f();

    public C4168c(C2498g c2498g, C2501j c2501j, int i, C2515k c2515k, int i2, Object obj, long j, long j2) {
        this.f10811h = (C2498g) C2516a.m7015a((Object) c2498g);
        this.f10804a = (C2501j) C2516a.m7015a((Object) c2501j);
        this.f10805b = i;
        this.f10806c = c2515k;
        this.f10807d = i2;
        this.f10808e = obj;
        this.f10809f = j;
        this.f10810g = j2;
    }

    /* renamed from: e */
    public final long m13261e() {
        return this.f10810g - this.f10809f;
    }
}
