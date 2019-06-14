package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.C4313d;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.auth.api.signin.internal.l */
final class C4877l extends C4753e {
    /* renamed from: a */
    private final /* synthetic */ C4900k f13959a;

    C4877l(C4900k c4900k) {
        this.f13959a = c4900k;
    }

    /* renamed from: a */
    public final void mo3265a(GoogleSignInAccount googleSignInAccount, Status status) {
        if (googleSignInAccount != null) {
            C2746r.m7822a(this.f13959a.f14100a).m7825a(this.f13959a.f14101b, googleSignInAccount);
        }
        this.f13959a.m14069b(new C4313d(googleSignInAccount, status));
    }
}
