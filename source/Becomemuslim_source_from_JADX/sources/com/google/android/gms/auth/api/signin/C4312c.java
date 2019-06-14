package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.C2730a;
import com.google.android.gms.auth.api.signin.internal.C2745j;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.C4361e;
import com.google.android.gms.common.api.C2781a.C2779d;
import com.google.android.gms.common.api.C2787e;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.internal.C4347a;
import com.google.android.gms.common.internal.C2871u;
import com.google.android.gms.common.internal.C2871u.C2869a;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.p186f.C2954g;

/* renamed from: com.google.android.gms.auth.api.signin.c */
public class C4312c extends C2787e<GoogleSignInOptions> {
    /* renamed from: b */
    private static final C4311a f11362b = new C4311a();
    /* renamed from: c */
    private static int f11363c = C2736b.f7023a;

    /* renamed from: com.google.android.gms.auth.api.signin.c$b */
    enum C2736b {
        /* renamed from: a */
        public static final int f7023a = 1;
        /* renamed from: b */
        public static final int f7024b = 2;
        /* renamed from: c */
        public static final int f7025c = 3;
        /* renamed from: d */
        public static final int f7026d = 4;
        /* renamed from: e */
        private static final /* synthetic */ int[] f7027e = new int[]{f7023a, f7024b, f7025c, f7026d};

        /* renamed from: a */
        public static int[] m7796a() {
            return (int[]) f7027e.clone();
        }
    }

    /* renamed from: com.google.android.gms.auth.api.signin.c$a */
    private static class C4311a implements C2869a<C4313d, GoogleSignInAccount> {
        private C4311a() {
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo2359a(C2814k c2814k) {
            return ((C4313d) c2814k).m14007a();
        }
    }

    C4312c(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, C2730a.f7005e, (C2779d) googleSignInOptions, new C4347a());
    }

    /* renamed from: m */
    private final synchronized int m14002m() {
        if (f11363c == C2736b.f7023a) {
            Context k = m7955k();
            C4361e a = C4361e.m14332a();
            int b = a.mo2459b(k, C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (b == 0) {
                f11363c = C2736b.f7026d;
            } else if (a.mo2457a(k, b, null) != null || DynamiteModule.m8505a(k, "com.google.android.gms.auth.api.fallback") == 0) {
                f11363c = C2736b.f7024b;
            } else {
                f11363c = C2736b.f7025c;
            }
        }
        return f11363c;
    }

    /* renamed from: a */
    public Intent m14003a() {
        Context k = m7955k();
        switch (C2751j.f7043a[m14002m() - 1]) {
            case 1:
                return C2745j.m7819b(k, (GoogleSignInOptions) m7950f());
            case 2:
                return C2745j.m7814a(k, (GoogleSignInOptions) m7950f());
            default:
                return C2745j.m7821c(k, (GoogleSignInOptions) m7950f());
        }
    }

    /* renamed from: b */
    public C2954g<GoogleSignInAccount> m14004b() {
        return C2871u.m8378a(C2745j.m7816a(m7953i(), m7955k(), (GoogleSignInOptions) m7950f(), m14002m() == C2736b.f7025c), f11362b);
    }

    /* renamed from: c */
    public C2954g<Void> m14005c() {
        return C2871u.m8377a(C2745j.m7817a(m7953i(), m7955k(), m14002m() == C2736b.f7025c));
    }

    /* renamed from: d */
    public C2954g<Void> m14006d() {
        return C2871u.m8377a(C2745j.m7820b(m7953i(), m7955k(), m14002m() == C2736b.f7025c));
    }
}
