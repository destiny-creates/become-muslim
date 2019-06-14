package com.google.android.gms.internal.ads;

final class gx implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ aoq f15511a;
    /* renamed from: b */
    private final /* synthetic */ bdb f15512b;
    /* renamed from: c */
    private final /* synthetic */ gw f15513c;

    gx(gw gwVar, aoq aoq, bdb bdb) {
        this.f15513c = gwVar;
        this.f15511a = aoq;
        this.f15512b = bdb;
    }

    public final void run() {
        this.f15513c.m37511a(this.f15511a, this.f15512b);
    }
}
