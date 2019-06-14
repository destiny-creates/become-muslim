package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2781a.C2779d;
import com.google.android.gms.common.api.C2781a.C2779d.C4765a;
import com.google.android.gms.common.api.C2781a.C2779d.C4766b;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.internal.C2796c.C4770a;
import com.google.android.gms.common.api.internal.C2798d;
import com.google.android.gms.common.api.internal.C2798d.C4771a;
import com.google.android.gms.common.api.internal.C2808m;
import com.google.android.gms.common.api.internal.C2809o;
import com.google.android.gms.common.api.internal.C4347a;
import com.google.android.gms.common.api.internal.C4774v;
import com.google.android.gms.common.api.internal.bh;
import com.google.android.gms.common.api.internal.br;
import com.google.android.gms.common.api.internal.cg;
import com.google.android.gms.common.internal.C2853f.C2851a;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.p186f.C2955h;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.google.android.gms.common.api.e */
public class C2787e<O extends C2779d> {
    /* renamed from: a */
    protected final C2798d f7110a;
    /* renamed from: b */
    private final Context f7111b;
    /* renamed from: c */
    private final C2781a<O> f7112c;
    /* renamed from: d */
    private final O f7113d;
    /* renamed from: e */
    private final cg<O> f7114e;
    /* renamed from: f */
    private final Looper f7115f;
    /* renamed from: g */
    private final int f7116g;
    /* renamed from: h */
    private final GoogleApiClient f7117h;
    /* renamed from: i */
    private final C2808m f7118i;

    /* renamed from: com.google.android.gms.common.api.e$a */
    public static class C2786a {
        /* renamed from: a */
        public static final C2786a f7107a = new C2785a().m7940a();
        /* renamed from: b */
        public final C2808m f7108b;
        /* renamed from: c */
        public final Looper f7109c;

        /* renamed from: com.google.android.gms.common.api.e$a$a */
        public static class C2785a {
            /* renamed from: a */
            private C2808m f7105a;
            /* renamed from: b */
            private Looper f7106b;

            /* renamed from: a */
            public C2785a m7939a(C2808m c2808m) {
                C2872v.m8381a((Object) c2808m, (Object) "StatusExceptionMapper must not be null.");
                this.f7105a = c2808m;
                return this;
            }

            /* renamed from: a */
            public C2786a m7940a() {
                if (this.f7105a == null) {
                    this.f7105a = new C4347a();
                }
                if (this.f7106b == null) {
                    this.f7106b = Looper.getMainLooper();
                }
                return new C2786a(this.f7105a, this.f7106b);
            }
        }

        private C2786a(C2808m c2808m, Account account, Looper looper) {
            this.f7108b = c2808m;
            this.f7109c = looper;
        }
    }

    protected C2787e(Context context, C2781a<O> c2781a, Looper looper) {
        C2872v.m8381a((Object) context, (Object) "Null context is not permitted.");
        C2872v.m8381a((Object) c2781a, (Object) "Api must not be null.");
        C2872v.m8381a((Object) looper, (Object) "Looper must not be null.");
        this.f7111b = context.getApplicationContext();
        this.f7112c = c2781a;
        this.f7113d = null;
        this.f7115f = looper;
        this.f7114e = cg.m8029a(c2781a);
        this.f7117h = new bh(this);
        this.f7110a = C2798d.m8041a(this.f7111b);
        this.f7116g = this.f7110a.m8064c();
        this.f7118i = new C4347a();
    }

    public C2787e(Activity activity, C2781a<O> c2781a, O o, C2786a c2786a) {
        C2872v.m8381a((Object) activity, (Object) "Null activity is not permitted.");
        C2872v.m8381a((Object) c2781a, (Object) "Api must not be null.");
        C2872v.m8381a((Object) c2786a, (Object) "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f7111b = activity.getApplicationContext();
        this.f7112c = c2781a;
        this.f7113d = o;
        this.f7115f = c2786a.f7109c;
        this.f7114e = cg.m8030a(this.f7112c, this.f7113d);
        this.f7117h = new bh(this);
        this.f7110a = C2798d.m8041a(this.f7111b);
        this.f7116g = this.f7110a.m8064c();
        this.f7118i = c2786a.f7108b;
        if ((activity instanceof GoogleApiActivity) == null) {
            C4774v.m16816a(activity, this.f7110a, this.f7114e);
        }
        this.f7110a.m8057a(this);
    }

    public C2787e(Context context, C2781a<O> c2781a, O o, C2786a c2786a) {
        C2872v.m8381a((Object) context, (Object) "Null context is not permitted.");
        C2872v.m8381a((Object) c2781a, (Object) "Api must not be null.");
        C2872v.m8381a((Object) c2786a, (Object) "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f7111b = context.getApplicationContext();
        this.f7112c = c2781a;
        this.f7113d = o;
        this.f7115f = c2786a.f7109c;
        this.f7114e = cg.m8030a(this.f7112c, this.f7113d);
        this.f7117h = new bh(this);
        this.f7110a = C2798d.m8041a(this.f7111b);
        this.f7116g = this.f7110a.m8064c();
        this.f7118i = c2786a.f7108b;
        this.f7110a.m8057a(this);
    }

    @Deprecated
    public C2787e(Context context, C2781a<O> c2781a, O o, C2808m c2808m) {
        this(context, (C2781a) c2781a, (C2779d) o, new C2785a().m7939a(c2808m).m7940a());
    }

    /* renamed from: a */
    private final <A extends C2777b, T extends C4770a<? extends C2814k, A>> T m7941a(int i, T t) {
        t.m14075h();
        this.f7110a.m8058a(this, i, t);
        return t;
    }

    /* renamed from: a */
    private final <TResult, A extends C2777b> C2954g<TResult> m7942a(int i, C2809o<A, TResult> c2809o) {
        C2955h c2955h = new C2955h();
        this.f7110a.m8059a(this, i, c2809o, c2955h, this.f7118i);
        return c2955h.m8783a();
    }

    /* renamed from: a */
    public <A extends C2777b, T extends C4770a<? extends C2814k, A>> T m7945a(T t) {
        return m7941a(0, (C4770a) t);
    }

    /* renamed from: a */
    public <TResult, A extends C2777b> C2954g<TResult> m7946a(C2809o<A, TResult> c2809o) {
        return m7942a(0, (C2809o) c2809o);
    }

    /* renamed from: b */
    public <A extends C2777b, T extends C4770a<? extends C2814k, A>> T m7947b(T t) {
        return m7941a(1, (C4770a) t);
    }

    /* renamed from: b */
    public <TResult, A extends C2777b> C2954g<TResult> m7948b(C2809o<A, TResult> c2809o) {
        return m7942a(1, (C2809o) c2809o);
    }

    /* renamed from: a */
    public C4340f mo2446a(Looper looper, C4771a<O> c4771a) {
        return this.f7112c.m7932b().mo3263a(this.f7111b, looper, m7956l().m8314a(), this.f7113d, c4771a, c4771a);
    }

    /* renamed from: e */
    public final C2781a<O> m7949e() {
        return this.f7112c;
    }

    /* renamed from: f */
    public O m7950f() {
        return this.f7113d;
    }

    /* renamed from: g */
    public final cg<O> m7951g() {
        return this.f7114e;
    }

    /* renamed from: h */
    public final int m7952h() {
        return this.f7116g;
    }

    /* renamed from: i */
    public GoogleApiClient m7953i() {
        return this.f7117h;
    }

    /* renamed from: j */
    public Looper m7954j() {
        return this.f7115f;
    }

    /* renamed from: k */
    public Context m7955k() {
        return this.f7111b;
    }

    /* renamed from: l */
    protected C2851a m7956l() {
        GoogleSignInAccount a;
        Account d;
        Collection m;
        C2851a c2851a = new C2851a();
        if (this.f7113d instanceof C4766b) {
            a = ((C4766b) this.f7113d).m16709a();
            if (a != null) {
                d = a.m16660d();
                c2851a = c2851a.m8311a(d);
                if (this.f7113d instanceof C4766b) {
                    a = ((C4766b) this.f7113d).m16709a();
                    if (a != null) {
                        m = a.m16669m();
                        return c2851a.m8313a(m).m8315b(this.f7111b.getClass().getName()).m8312a(this.f7111b.getPackageName());
                    }
                }
                m = Collections.emptySet();
                return c2851a.m8313a(m).m8315b(this.f7111b.getClass().getName()).m8312a(this.f7111b.getPackageName());
            }
        }
        d = this.f7113d instanceof C4765a ? ((C4765a) this.f7113d).m16708a() : null;
        c2851a = c2851a.m8311a(d);
        if (this.f7113d instanceof C4766b) {
            a = ((C4766b) this.f7113d).m16709a();
            if (a != null) {
                m = a.m16669m();
                return c2851a.m8313a(m).m8315b(this.f7111b.getClass().getName()).m8312a(this.f7111b.getPackageName());
            }
        }
        m = Collections.emptySet();
        return c2851a.m8313a(m).m8315b(this.f7111b.getClass().getName()).m8312a(this.f7111b.getPackageName());
    }

    /* renamed from: a */
    public br mo2447a(Context context, Handler handler) {
        return new br(context, handler, m7956l().m8314a());
    }
}
