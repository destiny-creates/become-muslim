package com.google.android.gms.internal.p213l;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.l.hb */
final class hb extends ContentObserver {
    /* renamed from: a */
    private final /* synthetic */ ha f17276a;

    hb(ha haVar, Handler handler) {
        this.f17276a = haVar;
        super(null);
    }

    public final void onChange(boolean z) {
        this.f17276a.m21404b();
        this.f17276a.m21402d();
    }
}
