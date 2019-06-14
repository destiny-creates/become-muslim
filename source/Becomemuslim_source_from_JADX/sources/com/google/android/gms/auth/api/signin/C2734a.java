package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.C2745j;
import com.google.android.gms.auth.api.signin.internal.C2746r;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2842b;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.p186f.C2958j;

/* renamed from: com.google.android.gms.auth.api.signin.a */
public final class C2734a {
    /* renamed from: a */
    public static C4312c m7793a(Context context, GoogleSignInOptions googleSignInOptions) {
        return new C4312c(context, (GoogleSignInOptions) C2872v.m8380a((Object) googleSignInOptions));
    }

    /* renamed from: a */
    public static C2954g<GoogleSignInAccount> m7794a(Intent intent) {
        intent = C2745j.m7815a(intent);
        if (intent == null) {
            return C2958j.m8788a(C2842b.m8238a(Status.f13153c));
        }
        if (intent.mo2360b().m16705d()) {
            if (intent.m14007a() != null) {
                return C2958j.m8789a(intent.m14007a());
            }
        }
        return C2958j.m8788a(C2842b.m8238a(intent.mo2360b()));
    }

    /* renamed from: a */
    public static GoogleSignInAccount m7792a(Context context) {
        return C2746r.m7822a(context).m7826b();
    }
}
