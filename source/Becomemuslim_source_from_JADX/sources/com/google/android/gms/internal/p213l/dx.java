package com.google.android.gms.internal.p213l;

import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.l.dx */
final class dx implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f17135a;
    /* renamed from: b */
    private final /* synthetic */ String f17136b;
    /* renamed from: c */
    private final /* synthetic */ long f17137c;
    /* renamed from: d */
    private final /* synthetic */ Bundle f17138d;
    /* renamed from: e */
    private final /* synthetic */ boolean f17139e;
    /* renamed from: f */
    private final /* synthetic */ boolean f17140f;
    /* renamed from: g */
    private final /* synthetic */ boolean f17141g;
    /* renamed from: h */
    private final /* synthetic */ String f17142h;
    /* renamed from: i */
    private final /* synthetic */ df f17143i;

    dx(df dfVar, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.f17143i = dfVar;
        this.f17135a = str;
        this.f17136b = str2;
        this.f17137c = j;
        this.f17138d = bundle;
        this.f17139e = z;
        this.f17140f = z2;
        this.f17141g = z3;
        this.f17142h = str3;
    }

    public final void run() {
        this.f17143i.m44067a(this.f17135a, this.f17136b, this.f17137c, this.f17138d, this.f17139e, this.f17140f, this.f17141g, this.f17142h);
    }
}
