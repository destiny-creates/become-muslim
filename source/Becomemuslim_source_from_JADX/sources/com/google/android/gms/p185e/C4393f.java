package com.google.android.gms.p185e;

/* renamed from: com.google.android.gms.e.f */
final class C4393f implements C2940g {
    /* renamed from: a */
    private Long f11723a;
    /* renamed from: b */
    private final /* synthetic */ boolean f11724b;
    /* renamed from: c */
    private final /* synthetic */ fq f11725c;

    C4393f(fq fqVar, boolean z) {
        this.f11725c = fqVar;
        this.f11724b = z;
    }

    /* renamed from: a */
    public final boolean mo2565a(C2929a c2929a) {
        if (!this.f11724b) {
            return c2929a.m8539c() == null;
        } else {
            long b = c2929a.m8537b();
            if (this.f11723a == null) {
                this.f11723a = Long.valueOf(this.f11725c.f13314j.m8755a());
            }
            return b + this.f11723a.longValue() >= this.f11725c.f13306a.mo2482a();
        }
    }
}
