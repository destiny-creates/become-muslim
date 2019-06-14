package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.auth.api.signin.d */
public class C4313d implements C2814k {
    /* renamed from: a */
    private Status f11364a;
    /* renamed from: b */
    private GoogleSignInAccount f11365b;

    public C4313d(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f11365b = googleSignInAccount;
        this.f11364a = status;
    }

    /* renamed from: a */
    public GoogleSignInAccount m14007a() {
        return this.f11365b;
    }

    /* renamed from: b */
    public Status mo2360b() {
        return this.f11364a;
    }
}
