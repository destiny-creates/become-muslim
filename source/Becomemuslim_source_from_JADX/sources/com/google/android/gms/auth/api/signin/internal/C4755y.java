package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.C2730a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.api.C2781a.C2779d.C4338c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.C2774a;

/* renamed from: com.google.android.gms.auth.api.signin.internal.y */
public final class C4755y extends C4317t {
    /* renamed from: a */
    private final Context f13138a;

    public C4755y(Context context) {
        this.f13138a = context;
    }

    /* renamed from: a */
    public final void mo3271a() {
        m16681c();
        C2742c a = C2742c.m7801a(this.f13138a);
        GoogleSignInAccount a2 = a.m7807a();
        C4338c c4338c = GoogleSignInOptions.f13945f;
        if (a2 != null) {
            c4338c = a.m7809b();
        }
        GoogleApiClient b = new C2774a(this.f13138a).m7907a(C2730a.f7005e, c4338c).m7909b();
        try {
            if (b.mo2416e().m16826b()) {
                if (a2 != null) {
                    C2730a.f7008h.mo2364a(b);
                } else {
                    b.mo2418g();
                }
            }
            b.disconnect();
        } catch (Throwable th) {
            b.disconnect();
        }
    }

    /* renamed from: b */
    public final void mo3272b() {
        m16681c();
        C2746r.m7822a(this.f13138a).m7824a();
    }

    /* renamed from: c */
    private final void m16681c() {
        if (!C2832i.isGooglePlayServicesUid(this.f13138a, Binder.getCallingUid())) {
            int callingUid = Binder.getCallingUid();
            StringBuilder stringBuilder = new StringBuilder(52);
            stringBuilder.append("Calling UID ");
            stringBuilder.append(callingUid);
            stringBuilder.append(" is not Google Play services.");
            throw new SecurityException(stringBuilder.toString());
        }
    }
}
