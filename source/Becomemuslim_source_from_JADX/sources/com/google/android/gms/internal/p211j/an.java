package com.google.android.gms.internal.p211j;

import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2796c.C2795b;
import com.google.android.gms.location.C5082m.C8225a;
import com.google.android.gms.location.C7836n;
import com.google.android.gms.location.C7837o;

/* renamed from: com.google.android.gms.internal.j.an */
final class an extends C8225a<C7837o> {
    /* renamed from: a */
    private final /* synthetic */ C7836n f32778a;
    /* renamed from: b */
    private final /* synthetic */ String f32779b = null;

    an(am amVar, GoogleApiClient googleApiClient, C7836n c7836n, String str) {
        this.f32778a = c7836n;
        super(googleApiClient);
    }

    /* renamed from: a */
    public final /* synthetic */ C2814k m43891a(Status status) {
        return new C7837o(status);
    }

    /* renamed from: a */
    protected final /* synthetic */ void m43892a(C2777b c2777b) {
        ((aa) c2777b).m43888a(this.f32778a, (C2795b) this, this.f32779b);
    }
}
