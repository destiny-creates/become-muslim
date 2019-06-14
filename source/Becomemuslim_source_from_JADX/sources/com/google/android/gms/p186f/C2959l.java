package com.google.android.gms.p186f;

/* renamed from: com.google.android.gms.f.l */
final class C2959l implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C2954g f7595a;
    /* renamed from: b */
    private final /* synthetic */ C4406k f7596b;

    C2959l(C4406k c4406k, C2954g c2954g) {
        this.f7596b = c4406k;
        this.f7595a = c2954g;
    }

    public final void run() {
        if (this.f7595a.mo2590c()) {
            this.f7596b.f11761c.m14682f();
            return;
        }
        try {
            this.f7596b.f11761c.m14673a(this.f7596b.f11760b.m8764a(this.f7595a));
        } catch (Exception e) {
            if (e.getCause() instanceof Exception) {
                this.f7596b.f11761c.m14672a((Exception) e.getCause());
            } else {
                this.f7596b.f11761c.m14672a(e);
            }
        } catch (Exception e2) {
            this.f7596b.f11761c.m14672a(e2);
        }
    }
}
