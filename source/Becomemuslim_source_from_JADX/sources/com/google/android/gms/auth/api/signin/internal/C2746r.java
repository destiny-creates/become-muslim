package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* renamed from: com.google.android.gms.auth.api.signin.internal.r */
public final class C2746r {
    /* renamed from: a */
    private static C2746r f7039a;
    /* renamed from: b */
    private C2742c f7040b;
    /* renamed from: c */
    private GoogleSignInAccount f7041c = this.f7040b.m7807a();
    /* renamed from: d */
    private GoogleSignInOptions f7042d = this.f7040b.m7809b();

    private C2746r(Context context) {
        this.f7040b = C2742c.m7801a(context);
    }

    /* renamed from: a */
    public static synchronized C2746r m7822a(Context context) {
        synchronized (C2746r.class) {
            context = C2746r.m7823b(context.getApplicationContext());
        }
        return context;
    }

    /* renamed from: b */
    private static synchronized C2746r m7823b(Context context) {
        synchronized (C2746r.class) {
            if (f7039a == null) {
                f7039a = new C2746r(context);
            }
            context = f7039a;
        }
        return context;
    }

    /* renamed from: a */
    public final synchronized void m7824a() {
        this.f7040b.m7812e();
        this.f7041c = null;
        this.f7042d = null;
    }

    /* renamed from: a */
    public final synchronized void m7825a(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f7040b.m7808a(googleSignInAccount, googleSignInOptions);
        this.f7041c = googleSignInAccount;
        this.f7042d = googleSignInOptions;
    }

    /* renamed from: b */
    public final synchronized GoogleSignInAccount m7826b() {
        return this.f7041c;
    }

    /* renamed from: c */
    public final synchronized GoogleSignInOptions m7827c() {
        return this.f7042d;
    }
}
