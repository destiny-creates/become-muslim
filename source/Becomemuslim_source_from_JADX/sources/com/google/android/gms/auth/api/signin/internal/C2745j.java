package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.C4313d;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.C2790h;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.C4345f;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2798d;
import com.google.android.gms.common.api.internal.C4772j;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p178b.C2823a;
import java.util.HashSet;

/* renamed from: com.google.android.gms.auth.api.signin.internal.j */
public final class C2745j {
    /* renamed from: a */
    private static C2823a f7038a = new C2823a("GoogleSignInCommon", new String[0]);

    /* renamed from: a */
    public static Intent m7814a(Context context, GoogleSignInOptions googleSignInOptions) {
        f7038a.m8113a("getSignInIntent()", new Object[0]);
        Parcelable signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        googleSignInOptions = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        googleSignInOptions.setPackage(context.getPackageName());
        googleSignInOptions.setClass(context, SignInHubActivity.class);
        context = new Bundle();
        context.putParcelable("config", signInConfiguration);
        googleSignInOptions.putExtra("config", context);
        return googleSignInOptions;
    }

    /* renamed from: b */
    public static Intent m7819b(Context context, GoogleSignInOptions googleSignInOptions) {
        f7038a.m8113a("getFallbackSignInIntent()", new Object[0]);
        context = C2745j.m7814a(context, googleSignInOptions);
        context.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return context;
    }

    /* renamed from: c */
    public static Intent m7821c(Context context, GoogleSignInOptions googleSignInOptions) {
        f7038a.m8113a("getNoImplementationSignInIntent()", new Object[0]);
        context = C2745j.m7814a(context, googleSignInOptions);
        context.setAction("com.google.android.gms.auth.NO_IMPL");
        return context;
    }

    /* renamed from: a */
    public static C4345f<C4313d> m7816a(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions, boolean z) {
        C2814k c4313d;
        f7038a.m8113a("silentSignIn()", new Object[0]);
        f7038a.m8113a("getEligibleSavedSignInResult()", new Object[0]);
        C2872v.m8380a((Object) googleSignInOptions);
        GoogleSignInOptions c = C2746r.m7822a(context).m7827c();
        if (c != null) {
            Account b = c.m17456b();
            Account b2 = googleSignInOptions.m17456b();
            boolean equals = b == null ? b2 == null : b.equals(b2);
            if (equals && !googleSignInOptions.m17458d() && ((!googleSignInOptions.m17457c() || (c.m17457c() && googleSignInOptions.m17460f().equals(c.m17460f()))) && new HashSet(c.m17455a()).containsAll(new HashSet(googleSignInOptions.m17455a())))) {
                GoogleSignInAccount b3 = C2746r.m7822a(context).m7826b();
                if (!(b3 == null || b3.m16666j())) {
                    c4313d = new C4313d(b3, Status.f13151a);
                    if (c4313d != null) {
                        f7038a.m8113a("Eligible saved sign in result found", new Object[0]);
                        return C2790h.m7967b(c4313d, googleApiClient);
                    } else if (z) {
                        return C2790h.m7967b(new C4313d(null, new Status(true)), googleApiClient);
                    } else {
                        f7038a.m8113a("trySilentSignIn()", new Object[0]);
                        return new C4772j(googleApiClient.mo2399a(new C4900k(googleApiClient, context, googleSignInOptions)));
                    }
                }
            }
        }
        c4313d = null;
        if (c4313d != null) {
            f7038a.m8113a("Eligible saved sign in result found", new Object[0]);
            return C2790h.m7967b(c4313d, googleApiClient);
        } else if (z) {
            return C2790h.m7967b(new C4313d(null, new Status(true)), googleApiClient);
        } else {
            f7038a.m8113a("trySilentSignIn()", new Object[0]);
            return new C4772j(googleApiClient.mo2399a(new C4900k(googleApiClient, context, googleSignInOptions)));
        }
    }

    /* renamed from: a */
    public static C2789g<Status> m7817a(GoogleApiClient googleApiClient, Context context, boolean z) {
        f7038a.m8113a("Signing out", new Object[0]);
        C2745j.m7818a(context);
        if (z) {
            return C2790h.m7965a(Status.f13151a, googleApiClient);
        }
        return googleApiClient.mo2409b(new C4901m(googleApiClient));
    }

    /* renamed from: b */
    public static C2789g<Status> m7820b(GoogleApiClient googleApiClient, Context context, boolean z) {
        f7038a.m8113a("Revoking access", new Object[0]);
        String c = C2742c.m7801a(context).m7810c();
        C2745j.m7818a(context);
        if (z) {
            return C2744f.m7813a(c);
        }
        return googleApiClient.mo2409b(new C4902o(googleApiClient));
    }

    /* renamed from: a */
    private static void m7818a(Context context) {
        C2746r.m7822a(context).m7824a();
        for (GoogleApiClient d : GoogleApiClient.m7910a()) {
            d.mo2414d();
        }
        C2798d.m8043b();
    }

    /* renamed from: a */
    public static C4313d m7815a(Intent intent) {
        if (intent != null) {
            if (intent.hasExtra("googleSignInStatus") || intent.hasExtra("googleSignInAccount")) {
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
                intent = (Status) intent.getParcelableExtra("googleSignInStatus");
                if (googleSignInAccount != null) {
                    intent = Status.f13151a;
                }
                return new C4313d(googleSignInAccount, intent);
            }
        }
        return null;
    }
}
