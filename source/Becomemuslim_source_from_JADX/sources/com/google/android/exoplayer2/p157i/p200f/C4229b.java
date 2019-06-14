package com.google.android.exoplayer2.p157i.p200f;

import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p164l.C2516a;
import java.util.Collections;
import java.util.List;

/* compiled from: Tx3gSubtitle */
/* renamed from: com.google.android.exoplayer2.i.f.b */
final class C4229b implements C2464e {
    /* renamed from: a */
    public static final C4229b f11134a = new C4229b();
    /* renamed from: b */
    private final List<C2458b> f11135b;

    /* renamed from: a */
    public int mo2291a(long j) {
        return j < 0 ? 0 : -1;
    }

    /* renamed from: b */
    public int mo2293b() {
        return 1;
    }

    public C4229b(C2458b c2458b) {
        this.f11135b = Collections.singletonList(c2458b);
    }

    private C4229b() {
        this.f11135b = Collections.emptyList();
    }

    /* renamed from: a */
    public long mo2292a(int i) {
        C2516a.m7017a(i == 0);
        return 0;
    }

    /* renamed from: b */
    public List<C2458b> mo2294b(long j) {
        return j >= 0 ? this.f11135b : Collections.emptyList();
    }
}
