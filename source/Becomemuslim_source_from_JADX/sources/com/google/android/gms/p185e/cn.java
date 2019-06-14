package com.google.android.gms.p185e;

/* renamed from: com.google.android.gms.e.cn */
final class cn implements eh {
    /* renamed from: a */
    private final /* synthetic */ cm f11663a;

    cn(cm cmVar) {
        this.f11663a = cmVar;
    }

    /* renamed from: a */
    public final void mo2542a(aw awVar) {
        this.f11663a.m14500a(awVar.m8560a());
    }

    /* renamed from: b */
    public final void mo2543b(aw awVar) {
        this.f11663a.m14500a(awVar.m8560a());
        long a = awVar.m8560a();
        awVar = new StringBuilder(57);
        awVar.append("Permanent failure dispatching hitId: ");
        awVar.append(a);
        bs.m8588e(awVar.toString());
    }

    /* renamed from: c */
    public final void mo2544c(aw awVar) {
        long b = awVar.m8562b();
        if (b == 0) {
            this.f11663a.m14501a(awVar.m8560a(), this.f11663a.f11661h.mo2482a());
            return;
        }
        if (b + 14400000 < this.f11663a.f11661h.mo2482a()) {
            this.f11663a.m14500a(awVar.m8560a());
            b = awVar.m8560a();
            StringBuilder stringBuilder = new StringBuilder(47);
            stringBuilder.append("Giving up on failed hitId: ");
            stringBuilder.append(b);
            bs.m8588e(stringBuilder.toString());
        }
    }
}
