package com.google.android.gms.internal.ads;

import com.google.android.gms.p174b.C4757d;

final class gy implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ bdb f15514a;
    /* renamed from: b */
    private final /* synthetic */ aoq f15515b;
    /* renamed from: c */
    private final /* synthetic */ he f15516c;
    /* renamed from: d */
    private final /* synthetic */ gw f15517d;

    gy(gw gwVar, bdb bdb, aoq aoq, he heVar) {
        this.f15517d = gwVar;
        this.f15514a = bdb;
        this.f15515b = aoq;
        this.f15516c = heVar;
    }

    public final void run() {
        try {
            this.f15514a.mo4108a(C4757d.a(this.f15517d.f28667c), this.f15515b, null, this.f15516c, this.f15517d.f28671g);
        } catch (Throwable e) {
            String str = "Fail to initialize adapter ";
            String valueOf = String.valueOf(this.f15517d.f28665a);
            mt.m19921c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
            this.f15517d.mo6099a(this.f15517d.f28665a, 0);
        }
    }
}
