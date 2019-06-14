package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class ae extends C2855h {
    /* renamed from: a */
    private final /* synthetic */ Intent f11568a;
    /* renamed from: b */
    private final /* synthetic */ Activity f11569b;
    /* renamed from: c */
    private final /* synthetic */ int f11570c;

    ae(Intent intent, Activity activity, int i) {
        this.f11568a = intent;
        this.f11569b = activity;
        this.f11570c = i;
    }

    /* renamed from: a */
    public final void mo2461a() {
        if (this.f11568a != null) {
            this.f11569b.startActivityForResult(this.f11568a, this.f11570c);
        }
    }
}
