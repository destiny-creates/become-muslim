package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final class bct implements Callable<bcp> {
    /* renamed from: a */
    private final /* synthetic */ bcm f15227a;
    /* renamed from: b */
    private final /* synthetic */ bcs f15228b;

    bct(bcs bcs, bcm bcm) {
        this.f15228b = bcs;
        this.f15227a = bcm;
    }

    /* renamed from: a */
    private final bcp m19239a() {
        synchronized (this.f15228b.f23927i) {
            if (this.f15228b.f23928j) {
                return null;
            }
            return this.f15227a.m30456a(this.f15228b.f23924f, this.f15228b.f23925g);
        }
    }

    public final /* synthetic */ Object call() {
        return m19239a();
    }
}
