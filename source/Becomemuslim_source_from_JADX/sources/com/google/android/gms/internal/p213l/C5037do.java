package com.google.android.gms.internal.p213l;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.do */
final class C5037do implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17110a;
    /* renamed from: b */
    private final /* synthetic */ String f17111b;
    /* renamed from: c */
    private final /* synthetic */ String f17112c;
    /* renamed from: d */
    private final /* synthetic */ String f17113d;
    /* renamed from: e */
    private final /* synthetic */ df f17114e;

    C5037do(df dfVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f17114e = dfVar;
        this.f17110a = atomicReference;
        this.f17111b = str;
        this.f17112c = str2;
        this.f17113d = str3;
    }

    public final void run() {
        this.f17114e.q.m31978t().m44199a(this.f17110a, this.f17111b, this.f17112c, this.f17113d);
    }
}
