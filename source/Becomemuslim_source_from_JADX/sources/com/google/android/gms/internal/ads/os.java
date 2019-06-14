package com.google.android.gms.internal.ads;

final class os implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ int f15862a;
    /* renamed from: b */
    private final /* synthetic */ int f15863b;
    /* renamed from: c */
    private final /* synthetic */ ol f15864c;

    os(ol olVar, int i, int i2) {
        this.f15864c = olVar;
        this.f15862a = i;
        this.f15863b = i2;
    }

    public final void run() {
        if (this.f15864c.f28731r != null) {
            this.f15864c.f28731r.mo4326a(this.f15862a, this.f15863b);
        }
    }
}
