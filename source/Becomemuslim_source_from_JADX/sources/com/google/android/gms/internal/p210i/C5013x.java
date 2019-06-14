package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.x */
final class C5013x implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ bh f16843a;
    /* renamed from: b */
    private final /* synthetic */ C5012w f16844b;

    C5013x(C5012w c5012w, bh bhVar) {
        this.f16844b = c5012w;
        this.f16843a = bhVar;
    }

    public final void run() {
        if (!this.f16844b.f16840a.m37984b()) {
            this.f16844b.f16840a.m21038f("Connected to service after a timeout");
            this.f16844b.f16840a.m37976a(this.f16843a);
        }
    }
}
