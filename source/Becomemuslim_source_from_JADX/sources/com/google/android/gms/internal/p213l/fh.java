package com.google.android.gms.internal.p213l;

import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;

/* renamed from: com.google.android.gms.internal.l.fh */
final class fh {
    /* renamed from: a */
    private final C2895e f17230a;
    /* renamed from: b */
    private long f17231b;

    public fh(C2895e c2895e) {
        C2872v.a(c2895e);
        this.f17230a = c2895e;
    }

    /* renamed from: a */
    public final void m21367a() {
        this.f17231b = this.f17230a.b();
    }

    /* renamed from: a */
    public final boolean m21368a(long j) {
        return this.f17231b == 0 || this.f17230a.b() - this.f17231b >= 3600000;
    }

    /* renamed from: b */
    public final void m21369b() {
        this.f17231b = 0;
    }
}
