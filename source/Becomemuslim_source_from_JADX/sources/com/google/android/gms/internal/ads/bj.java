package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class bj implements Runnable {
    /* renamed from: a */
    private final bi f15258a;
    /* renamed from: b */
    private final JSONObject f15259b;
    /* renamed from: c */
    private final nz f15260c;

    bj(bi biVar, JSONObject jSONObject, nz nzVar) {
        this.f15258a = biVar;
        this.f15259b = jSONObject;
        this.f15260c = nzVar;
    }

    public final void run() {
        this.f15258a.m19363a(this.f15259b, this.f15260c);
    }
}
