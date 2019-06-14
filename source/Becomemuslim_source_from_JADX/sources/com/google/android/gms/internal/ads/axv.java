package com.google.android.gms.internal.ads;

final /* synthetic */ class axv implements Runnable {
    /* renamed from: a */
    private final axu f15036a;
    /* renamed from: b */
    private final axl f15037b;
    /* renamed from: c */
    private final nz f15038c;
    /* renamed from: d */
    private final axm f15039d;

    axv(axu axu, axl axl, nz nzVar, axm axm) {
        this.f15036a = axu;
        this.f15037b = axl;
        this.f15038c = nzVar;
        this.f15039d = axm;
    }

    public final void run() {
        axu axu = this.f15036a;
        axl axl = this.f15037b;
        nz nzVar = this.f15038c;
        try {
            nzVar.m30915b(axl.m30372e().mo4083a(this.f15039d));
        } catch (Throwable e) {
            mt.m19919b("Unable to obtain a cache service instance.", e);
            nzVar.m30914a(e);
            axu.f23848a.m30375a();
        }
    }
}
