package com.google.android.exoplayer2.p157i.p158a;

import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p164l.C2516a;
import java.util.Collections;
import java.util.List;

/* compiled from: CeaSubtitle */
/* renamed from: com.google.android.exoplayer2.i.a.f */
final class C4224f implements C2464e {
    /* renamed from: a */
    private final List<C2458b> f11124a;

    /* renamed from: a */
    public int mo2291a(long j) {
        return j < 0 ? 0 : -1;
    }

    /* renamed from: b */
    public int mo2293b() {
        return 1;
    }

    public C4224f(List<C2458b> list) {
        this.f11124a = list;
    }

    /* renamed from: a */
    public long mo2292a(int i) {
        C2516a.m7017a(i == 0);
        return 0;
    }

    /* renamed from: b */
    public List<C2458b> mo2294b(long j) {
        return j >= 0 ? this.f11124a : Collections.emptyList();
    }
}
