package com.google.android.exoplayer2.p149h.p153c;

import android.util.SparseArray;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.p164l.C2537s;

/* compiled from: TimestampAdjusterProvider */
/* renamed from: com.google.android.exoplayer2.h.c.m */
public final class C2409m {
    /* renamed from: a */
    private final SparseArray<C2537s> f5940a = new SparseArray();

    /* renamed from: a */
    public C2537s m6629a(int i) {
        C2537s c2537s = (C2537s) this.f5940a.get(i);
        if (c2537s != null) {
            return c2537s;
        }
        c2537s = new C2537s(Clock.MAX_TIME);
        this.f5940a.put(i, c2537s);
        return c2537s;
    }

    /* renamed from: a */
    public void m6630a() {
        this.f5940a.clear();
    }
}
