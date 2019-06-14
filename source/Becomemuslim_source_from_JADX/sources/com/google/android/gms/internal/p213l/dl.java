package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.dl */
final class dl implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ long f17104a;
    /* renamed from: b */
    private final /* synthetic */ df f17105b;

    dl(df dfVar, long j) {
        this.f17105b = dfVar;
        this.f17104a = j;
    }

    public final void run() {
        db dbVar = this.f17105b;
        long j = this.f17104a;
        dbVar.mo6210d();
        dbVar.mo6208b();
        dbVar.m42728w();
        dbVar.mo4754r().m42578v().m21307a("Resetting analytics data (FE)");
        dbVar.mo6747k().m44230B();
        if (dbVar.mo6215t().m38060l(dbVar.mo6743g().m43958C())) {
            dbVar.mo6214s().f32331h.m21319a(j);
        }
        boolean y = dbVar.q.m31983y();
        if (!dbVar.mo6215t().m38053h()) {
            dbVar.mo6214s().m42590d(y ^ 1);
        }
        dbVar.mo6744h().m44186D();
        dbVar.f32809b = y ^ 1;
    }
}
