package com.google.android.gms.internal.ads;

final class axi implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f15033a;
    /* renamed from: b */
    private final /* synthetic */ long f15034b;
    /* renamed from: c */
    private final /* synthetic */ awi f15035c;

    axi(awi awi, String str, long j) {
        this.f15035c = awi;
        this.f15033a = str;
        this.f15034b = j;
    }

    public final void run() {
        this.f15035c.f15016a.m19387a(this.f15033a, this.f15034b);
        this.f15035c.f15016a.m19386a(toString());
    }
}
