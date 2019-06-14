package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.p203b.C4940a;
import com.google.android.gms.internal.p203b.C4942c;

/* renamed from: com.google.android.gms.auth.api.signin.internal.x */
public final class C4319x extends C4940a implements C2749w {
    C4319x(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    /* renamed from: a */
    public final void mo2365a(C2748u c2748u, GoogleSignInOptions googleSignInOptions) {
        Parcel a = a();
        C4942c.a(a, c2748u);
        C4942c.a(a, googleSignInOptions);
        a(101, a);
    }

    /* renamed from: b */
    public final void mo2366b(C2748u c2748u, GoogleSignInOptions googleSignInOptions) {
        Parcel a = a();
        C4942c.a(a, c2748u);
        C4942c.a(a, googleSignInOptions);
        a(102, a);
    }

    /* renamed from: c */
    public final void mo2367c(C2748u c2748u, GoogleSignInOptions googleSignInOptions) {
        Parcel a = a();
        C4942c.a(a, c2748u);
        C4942c.a(a, googleSignInOptions);
        a(103, a);
    }
}
