package com.google.android.gms.internal.p213l;

import android.content.Intent;

/* renamed from: com.google.android.gms.internal.l.ey */
final /* synthetic */ class ey implements Runnable {
    /* renamed from: a */
    private final ex f17212a;
    /* renamed from: b */
    private final int f17213b;
    /* renamed from: c */
    private final bb f17214c;
    /* renamed from: d */
    private final Intent f17215d;

    ey(ex exVar, int i, bb bbVar, Intent intent) {
        this.f17212a = exVar;
        this.f17213b = i;
        this.f17214c = bbVar;
        this.f17215d = intent;
    }

    public final void run() {
        this.f17212a.m21351a(this.f17213b, this.f17214c, this.f17215d);
    }
}
