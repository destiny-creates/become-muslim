package com.google.android.gms.internal.p213l;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.l.fq */
final class fq implements Callable<String> {
    /* renamed from: a */
    private final /* synthetic */ C7826u f17234a;
    /* renamed from: b */
    private final /* synthetic */ fm f17235b;

    fq(fm fmVar, C7826u c7826u) {
        this.f17235b = fmVar;
        this.f17234a = c7826u;
    }

    public final /* synthetic */ Object call() {
        C5050t a = this.f17235b.m32055b().m38058k(this.f17234a.f29107a) ? this.f17235b.m32034e(this.f17234a) : this.f17235b.m32063d().m43930b(this.f17234a.f29107a);
        if (a != null) {
            return a.m21460c();
        }
        this.f17235b.mo4754r().m42565i().m21307a("App info was null when attempting to get app instance id");
        return null;
    }
}
