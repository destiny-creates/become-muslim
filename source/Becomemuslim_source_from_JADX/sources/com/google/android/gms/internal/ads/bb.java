package com.google.android.gms.internal.ads;

final class bb implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ nz f15160a;
    /* renamed from: b */
    private final /* synthetic */ String f15161b;
    /* renamed from: c */
    private final /* synthetic */ ay f15162c;

    bb(ay ayVar, nz nzVar, String str) {
        this.f15162c = ayVar;
        this.f15160a = nzVar;
        this.f15161b = str;
    }

    public final void run() {
        this.f15160a.m30915b((awo) this.f15162c.f15050d.N().get(this.f15161b));
    }
}
