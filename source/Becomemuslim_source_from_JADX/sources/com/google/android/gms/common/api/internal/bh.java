package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2781a.C2779d;
import com.google.android.gms.common.api.C2787e;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.internal.C2796c.C4770a;

public final class bh<O extends C2779d> extends C4354x {
    /* renamed from: a */
    private final C2787e<O> f13178a;

    public bh(C2787e<O> c2787e) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f13178a = c2787e;
    }

    /* renamed from: a */
    public final void mo2404a(bv bvVar) {
    }

    /* renamed from: b */
    public final void mo2411b(bv bvVar) {
    }

    /* renamed from: a */
    public final <A extends C2777b, R extends C2814k, T extends C4770a<R, A>> T mo2399a(T t) {
        return this.f13178a.m7945a((C4770a) t);
    }

    /* renamed from: b */
    public final <A extends C2777b, T extends C4770a<? extends C2814k, A>> T mo2409b(T t) {
        return this.f13178a.m7947b((C4770a) t);
    }

    /* renamed from: c */
    public final Looper mo2412c() {
        return this.f13178a.m7954j();
    }

    /* renamed from: b */
    public final Context mo2408b() {
        return this.f13178a.m7955k();
    }
}
