package com.google.android.gms.internal.ads;

final class bcu implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ no f15229a;
    /* renamed from: b */
    private final /* synthetic */ bcs f15230b;

    bcu(bcs bcs, no noVar) {
        this.f15230b = bcs;
        this.f15229a = noVar;
    }

    public final void run() {
        for (no noVar : this.f15230b.f23929k.keySet()) {
            if (noVar != this.f15229a) {
                ((bcm) this.f15230b.f23929k.get(noVar)).m30457a();
            }
        }
    }
}
