package com.google.android.gms.internal.p210i;

import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;

/* renamed from: com.google.android.gms.internal.i.by */
final class by {
    /* renamed from: a */
    private final C2895e f16447a;
    /* renamed from: b */
    private long f16448b;

    public by(C2895e c2895e) {
        C2872v.a(c2895e);
        this.f16447a = c2895e;
    }

    public by(C2895e c2895e, long j) {
        C2872v.a(c2895e);
        this.f16447a = c2895e;
        this.f16448b = j;
    }

    /* renamed from: a */
    public final void m20365a() {
        this.f16448b = this.f16447a.b();
    }

    /* renamed from: b */
    public final void m20367b() {
        this.f16448b = 0;
    }

    /* renamed from: a */
    public final boolean m20366a(long j) {
        if (this.f16448b != 0 && this.f16447a.b() - this.f16448b <= j) {
            return 0;
        }
        return true;
    }
}
