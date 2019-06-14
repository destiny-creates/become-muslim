package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.p172a.C2729a;
import com.google.android.gms.auth.api.p173b.C2731a;
import com.google.android.gms.auth.api.signin.C2735b;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.C4316h;
import com.google.android.gms.auth.api.signin.internal.C4876i;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C2779d.C4767e;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.C2781a.C4341g;
import com.google.android.gms.internal.p203b.C6774e;
import com.google.android.gms.internal.p203b.C8212f;

/* renamed from: com.google.android.gms.auth.api.a */
public final class C2730a {
    /* renamed from: a */
    public static final C4341g<C8212f> f7001a = new C4341g();
    /* renamed from: b */
    public static final C4341g<C4876i> f7002b = new C4341g();
    @Deprecated
    /* renamed from: c */
    public static final C2781a<C4875c> f7003c = C2732b.f7011a;
    /* renamed from: d */
    public static final C2781a<C4874a> f7004d = new C2781a("Auth.CREDENTIALS_API", f7009i, f7001a);
    /* renamed from: e */
    public static final C2781a<GoogleSignInOptions> f7005e = new C2781a("Auth.GOOGLE_SIGN_IN_API", f7010j, f7002b);
    @Deprecated
    /* renamed from: f */
    public static final C2731a f7006f = C2732b.f7012b;
    /* renamed from: g */
    public static final C2729a f7007g = new C6774e();
    /* renamed from: h */
    public static final C2735b f7008h = new C4316h();
    /* renamed from: i */
    private static final C4337a<C8212f, C4874a> f7009i = new C4750e();
    /* renamed from: j */
    private static final C4337a<C4876i, GoogleSignInOptions> f7010j = new C4751f();

    @Deprecated
    /* renamed from: com.google.android.gms.auth.api.a$a */
    public static class C4874a implements C4767e {
        /* renamed from: a */
        private static final C4874a f13937a = new C2728a().m7781a();
        /* renamed from: b */
        private final String f13938b = null;
        /* renamed from: c */
        private final boolean f13939c;

        @Deprecated
        /* renamed from: com.google.android.gms.auth.api.a$a$a */
        public static class C2728a {
            /* renamed from: a */
            protected Boolean f7000a = Boolean.valueOf(false);

            /* renamed from: a */
            public C4874a m7781a() {
                return new C4874a(this);
            }
        }

        public C4874a(C2728a c2728a) {
            this.f13939c = c2728a.f7000a.booleanValue();
        }

        /* renamed from: a */
        public final Bundle m17442a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putBoolean("force_save_dialog", this.f13939c);
            return bundle;
        }
    }
}
