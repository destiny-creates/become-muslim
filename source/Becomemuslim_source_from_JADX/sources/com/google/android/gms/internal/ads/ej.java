package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final class ej implements Runnable {
    /* renamed from: a */
    final /* synthetic */ JSONObject f15338a;
    /* renamed from: b */
    final /* synthetic */ String f15339b;
    /* renamed from: c */
    private final /* synthetic */ eh f15340c;

    ej(eh ehVar, JSONObject jSONObject, String str) {
        this.f15340c = ehVar;
        this.f15338a = jSONObject;
        this.f15339b = str;
    }

    public final void run() {
        this.f15340c.f28647l = eh.f28639d.m19207b(null);
        this.f15340c.f28647l.mo4320a(new ek(this), new el(this));
    }
}
