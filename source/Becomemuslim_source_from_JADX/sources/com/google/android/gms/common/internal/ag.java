package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.C2801g;

final class ag extends C2855h {
    /* renamed from: a */
    private final /* synthetic */ Intent f11574a;
    /* renamed from: b */
    private final /* synthetic */ C2801g f11575b;
    /* renamed from: c */
    private final /* synthetic */ int f11576c;

    ag(Intent intent, C2801g c2801g, int i) {
        this.f11574a = intent;
        this.f11575b = c2801g;
        this.f11576c = i;
    }

    /* renamed from: a */
    public final void mo2461a() {
        if (this.f11574a != null) {
            this.f11575b.startActivityForResult(this.f11574a, this.f11576c);
        }
    }
}
