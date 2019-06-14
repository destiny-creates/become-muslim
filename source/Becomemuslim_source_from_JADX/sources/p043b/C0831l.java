package p043b;

import p043b.C0829j.C0828b;

/* compiled from: UnobservedErrorNotifier */
/* renamed from: b.l */
class C0831l {
    /* renamed from: a */
    private C0829j<?> f2318a;

    public C0831l(C0829j<?> c0829j) {
        this.f2318a = c0829j;
    }

    protected void finalize() {
        try {
            C0829j c0829j = this.f2318a;
            if (c0829j != null) {
                C0828b a = C0829j.m2977a();
                if (a != null) {
                    a.m2976a(c0829j, new C0832m(c0829j.m3002g()));
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    /* renamed from: a */
    public void m3011a() {
        this.f2318a = null;
    }
}
