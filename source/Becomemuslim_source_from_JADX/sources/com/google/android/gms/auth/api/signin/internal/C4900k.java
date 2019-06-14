package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.C4313d;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.auth.api.signin.internal.k */
final class C4900k extends C4880q<C4313d> {
    /* renamed from: a */
    final /* synthetic */ Context f14100a;
    /* renamed from: b */
    final /* synthetic */ GoogleSignInOptions f14101b;

    C4900k(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions) {
        this.f14100a = context;
        this.f14101b = googleSignInOptions;
        super(googleApiClient);
    }

    /* renamed from: a */
    protected final /* synthetic */ void mo3553a(C2777b c2777b) {
        ((C2749w) ((C4876i) c2777b).m8308w()).mo2365a(new C4877l(this), this.f14101b);
    }

    /* renamed from: a */
    protected final /* synthetic */ C2814k mo3278a(Status status) {
        return new C4313d(null, status);
    }
}
