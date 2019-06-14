package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.C2733a;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C4785j;

/* renamed from: com.google.android.gms.auth.api.signin.internal.i */
public final class C4876i extends C4785j<C2749w> {
    /* renamed from: e */
    private final GoogleSignInOptions f13958e;

    public C4876i(Context context, Looper looper, C2853f c2853f, GoogleSignInOptions googleSignInOptions, C2775b c2775b, C2776c c2776c) {
        super(context, looper, 91, c2853f, c2775b, c2776c);
        if (googleSignInOptions == null) {
            googleSignInOptions = new C2733a().m7791d();
        }
        if (c2853f.m8323e().isEmpty() == null) {
            context = new C2733a(googleSignInOptions);
            for (Scope a : c2853f.m8323e()) {
                context.m7784a(a, new Scope[null]);
            }
            googleSignInOptions = context.m7791d();
        }
        this.f13958e = googleSignInOptions;
    }

    /* renamed from: b */
    protected final String mo3449b() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    /* renamed from: c */
    public final boolean mo3450c() {
        return true;
    }

    /* renamed from: f */
    public final int mo3293f() {
        return C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    protected final String q_() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    /* renamed from: d */
    public final Intent mo3451d() {
        return C2745j.m7814a(m8303r(), this.f13958e);
    }

    /* renamed from: e */
    public final GoogleSignInOptions mo3452e() {
        return this.f13958e;
    }

    /* renamed from: a */
    protected final /* synthetic */ IInterface mo3448a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        if (queryLocalInterface instanceof C2749w) {
            return (C2749w) queryLocalInterface;
        }
        return new C4319x(iBinder);
    }
}
