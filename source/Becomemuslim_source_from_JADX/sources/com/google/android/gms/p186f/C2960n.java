package com.google.android.gms.p186f;

/* renamed from: com.google.android.gms.f.n */
final class C2960n implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C2954g f7597a;
    /* renamed from: b */
    private final /* synthetic */ C4407m f7598b;

    C2960n(C4407m c4407m, C2954g c2954g) {
        this.f7598b = c4407m;
        this.f7597a = c2954g;
    }

    public final void run() {
        try {
            C2954g c2954g = (C2954g) this.f7598b.f11763b.m8764a(this.f7597a);
            if (c2954g == null) {
                this.f7598b.mo2576a(new NullPointerException("Continuation returned null"));
                return;
            }
            c2954g.mo2585a(C2957i.f7594b, this.f7598b);
            c2954g.mo2584a(C2957i.f7594b, this.f7598b);
            c2954g.mo2582a(C2957i.f7594b, this.f7598b);
        } catch (Exception e) {
            if (e.getCause() instanceof Exception) {
                this.f7598b.f11764c.m14672a((Exception) e.getCause());
            } else {
                this.f7598b.f11764c.m14672a(e);
            }
        } catch (Exception e2) {
            this.f7598b.f11764c.m14672a(e2);
        }
    }
}
