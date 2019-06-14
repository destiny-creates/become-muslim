package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.bw */
final class bw implements ay {
    /* renamed from: a */
    private final /* synthetic */ Runnable f24453a;
    /* renamed from: b */
    private final /* synthetic */ bt f24454b;

    bw(bt btVar, Runnable runnable) {
        this.f24454b = btVar;
        this.f24453a = runnable;
    }

    /* renamed from: a */
    public final void mo4413a(Throwable th) {
        this.f24454b.f16439a.post(this.f24453a);
    }
}
