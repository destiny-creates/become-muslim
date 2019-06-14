package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.be */
final class be implements ar<bf> {
    /* renamed from: a */
    private final C5008q f24446a;
    /* renamed from: b */
    private final bf f24447b = new bf();

    public be(C5008q c5008q) {
        this.f24446a = c5008q;
    }

    /* renamed from: a */
    public final void mo4417a(String str, String str2) {
    }

    /* renamed from: b */
    public final void mo4419b(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.f24447b.f24448a = str2;
        } else if ("ga_appVersion".equals(str)) {
            this.f24447b.f24449b = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.f24447b.f24450c = str2;
        } else {
            this.f24446a.m21063e().m21034d("String xml configuration name not recognized", str);
        }
    }

    /* renamed from: a */
    public final void mo4418a(String str, boolean z) {
        if ("ga_dryRun".equals(str)) {
            this.f24447b.f24452e = z;
        } else {
            this.f24446a.m21063e().m21034d("Bool xml configuration name not recognized", str);
        }
    }

    /* renamed from: a */
    public final void mo4416a(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.f24447b.f24451d = i;
        } else {
            this.f24446a.m21063e().m21034d("Int xml configuration name not recognized", str);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ ap mo4415a() {
        return this.f24447b;
    }
}
