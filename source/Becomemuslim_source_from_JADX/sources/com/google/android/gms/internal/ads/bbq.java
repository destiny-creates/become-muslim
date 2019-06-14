package com.google.android.gms.internal.ads;

import android.content.Context;

@cm
public final class bbq {
    /* renamed from: a */
    private final Object f15165a = new Object();
    /* renamed from: b */
    private bbx f15166b;

    /* renamed from: a */
    public final bbx m19211a(Context context, mv mvVar) {
        bbx bbx;
        synchronized (this.f15165a) {
            if (this.f15166b == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                this.f15166b = new bbx(context, mvVar, (String) aph.m18688f().m18889a(asp.f14936a));
            }
            bbx = this.f15166b;
        }
        return bbx;
    }
}
