package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.C2789g.C2788a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2871u.C2869a;
import com.google.android.gms.common.internal.C2871u.C2870b;
import com.google.android.gms.p186f.C2955h;
import java.util.concurrent.TimeUnit;

final class al implements C2788a {
    /* renamed from: a */
    private final /* synthetic */ C2789g f11579a;
    /* renamed from: b */
    private final /* synthetic */ C2955h f11580b;
    /* renamed from: c */
    private final /* synthetic */ C2869a f11581c;
    /* renamed from: d */
    private final /* synthetic */ C2870b f11582d;

    al(C2789g c2789g, C2955h c2955h, C2869a c2869a, C2870b c2870b) {
        this.f11579a = c2789g;
        this.f11580b = c2955h;
        this.f11581c = c2869a;
        this.f11582d = c2870b;
    }

    /* renamed from: a */
    public final void mo2453a(Status status) {
        if (status.m16705d()) {
            this.f11580b.m8785a(this.f11581c.mo2359a(this.f11579a.mo2376a(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.f11580b.m8784a(this.f11582d.mo2466a(status));
    }
}
