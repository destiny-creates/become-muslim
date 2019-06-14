package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class cm extends bj {
    /* renamed from: a */
    private final /* synthetic */ Dialog f11496a;
    /* renamed from: b */
    private final /* synthetic */ cl f11497b;

    cm(cl clVar, Dialog dialog) {
        this.f11497b = clVar;
        this.f11496a = dialog;
    }

    /* renamed from: a */
    public final void mo2423a() {
        this.f11497b.f7167a.m14209h();
        if (this.f11496a.isShowing()) {
            this.f11496a.dismiss();
        }
    }
}
