package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.internal.C2796c.C4770a;
import java.util.Collections;

public final class am implements av {
    /* renamed from: a */
    private final aw f11432a;

    public am(aw awVar) {
        this.f11432a = awVar;
    }

    /* renamed from: a */
    public final void mo2387a(int i) {
    }

    /* renamed from: a */
    public final void mo2388a(Bundle bundle) {
    }

    /* renamed from: a */
    public final void mo2389a(C4775b c4775b, C2781a<?> c2781a, boolean z) {
    }

    /* renamed from: b */
    public final boolean mo2391b() {
        return true;
    }

    /* renamed from: a */
    public final void mo2386a() {
        for (C4340f g : this.f11432a.f13163a.values()) {
            g.m14045g();
        }
        this.f11432a.f13166d.f11435c = Collections.emptySet();
    }

    /* renamed from: a */
    public final <A extends C2777b, R extends C2814k, T extends C4770a<R, A>> T mo2385a(T t) {
        this.f11432a.f13166d.f11433a.add(t);
        return t;
    }

    /* renamed from: b */
    public final <A extends C2777b, T extends C4770a<? extends C2814k, A>> T mo2390b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* renamed from: c */
    public final void mo2392c() {
        this.f11432a.m16725d();
    }
}
