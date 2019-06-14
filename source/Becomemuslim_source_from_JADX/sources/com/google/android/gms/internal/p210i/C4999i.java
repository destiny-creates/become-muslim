package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.i */
final class C4999i implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f16686a;
    /* renamed from: b */
    private final /* synthetic */ Runnable f16687b;
    /* renamed from: c */
    private final /* synthetic */ C7816f f16688c;

    C4999i(C7816f c7816f, String str, Runnable runnable) {
        this.f16688c = c7816f;
        this.f16686a = str;
        this.f16687b = runnable;
    }

    public final void run() {
        this.f16688c.f28902a.m37724a(this.f16686a);
        if (this.f16687b != null) {
            this.f16687b.run();
        }
    }
}
