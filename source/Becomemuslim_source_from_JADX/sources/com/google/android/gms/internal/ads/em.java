package com.google.android.gms.internal.ads;

final class em implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ eh f15341a;

    em(eh ehVar) {
        this.f15341a = ehVar;
    }

    public final void run() {
        if (this.f15341a.f28647l != null) {
            this.f15341a.f28647l.m37254c();
            this.f15341a.f28647l = null;
        }
    }
}
