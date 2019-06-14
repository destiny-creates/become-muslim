package com.p064b.p065a.p067b;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p351a.C8179b;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6432m;
import io.p347a.p348a.p349a.p350a.p352b.C6436o;
import io.p347a.p348a.p349a.p350a.p352b.C6436o.C6435a;
import io.p347a.p348a.p349a.p350a.p352b.C7607s;
import io.p347a.p348a.p349a.p350a.p356e.C7615b;
import io.p347a.p348a.p349a.p350a.p357f.C7619d;
import io.p347a.p348a.p349a.p350a.p358g.C6495f;
import io.p347a.p348a.p349a.p350a.p358g.C6504q;
import io.p347a.p348a.p349a.p350a.p358g.C6507t;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Beta */
/* renamed from: com.b.a.b.c */
public class C3417c extends C6520i<Boolean> implements C6432m {
    /* renamed from: a */
    private final C8179b<String> f9093a = new C8179b();
    /* renamed from: b */
    private final C3419h f9094b = new C3419h();
    /* renamed from: c */
    private C1006j f9095c;

    /* renamed from: a */
    public String m10903a() {
        return "1.1.4.92";
    }

    /* renamed from: b */
    public String m10906b() {
        return "com.crashlytics.sdk.android:beta";
    }

    /* renamed from: f */
    protected /* synthetic */ Object m10909f() {
        return m10907d();
    }

    @TargetApi(14)
    protected boolean d_() {
        this.f9095c = m10902a(VERSION.SDK_INT, (Application) E().getApplicationContext());
        return true;
    }

    /* renamed from: d */
    protected Boolean m10907d() {
        C6514c.h().a("Beta", "Beta kit initializing...");
        Context E = E();
        C6436o D = D();
        if (TextUtils.isEmpty(m10900a(E, D.j()))) {
            C6514c.h().a("Beta", "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        C6514c.h().a("Beta", "Beta device token is present, checking for app updates.");
        C6495f h = m10901h();
        C1003d a = m10899a(E);
        if (m10904a(h, a)) {
            this.f9095c.mo746a(E, this, D, h, a, new C7619d(this), new C7607s(), new C7615b(C6514c.h()));
        }
        return Boolean.valueOf(true);
    }

    @TargetApi(14)
    /* renamed from: a */
    C1006j m10902a(int i, Application application) {
        if (i >= 14) {
            return new C4533b(F().e(), F().f());
        }
        return new C4534i();
    }

    /* renamed from: e */
    public Map<C6435a, String> m10908e() {
        CharSequence a = m10900a(E(), D().j());
        Map<C6435a, String> hashMap = new HashMap();
        if (!TextUtils.isEmpty(a)) {
            hashMap.put(C6435a.f20782c, a);
        }
        return hashMap;
    }

    @TargetApi(11)
    /* renamed from: a */
    boolean m10905a(String str, int i) {
        if (i >= 11) {
            return "io.crash.air".equals(str);
        }
        return str == null ? true : null;
    }

    /* renamed from: a */
    boolean m10904a(C6495f c6495f, C1003d c1003d) {
        return (c6495f == null || TextUtils.isEmpty(c6495f.f20934a) != null || c1003d == null) ? null : true;
    }

    /* renamed from: a */
    private String m10900a(Context context, String str) {
        if (m10905a(str, VERSION.SDK_INT) != null) {
            C6514c.h().a("Beta", "App was possibly installed by Beta. Getting device token");
            try {
                String str2 = (String) this.f9093a.a(context, this.f9094b);
                if ("".equals(str2) != null) {
                    return null;
                }
                return str2;
            } catch (Context context2) {
                C6514c.h().e("Beta", "Failed to load the Beta device token", context2);
                return null;
            }
        }
        C6514c.h().a("Beta", "App was not installed by Beta. Skipping device token");
        return null;
    }

    /* renamed from: h */
    private C6495f m10901h() {
        C6507t b = C6504q.a().b();
        return b != null ? b.f20971f : null;
    }

    /* renamed from: a */
    private C1003d m10899a(Context context) {
        C1003d a;
        Throwable th;
        C1003d c1003d = null;
        try {
            context = context.getAssets().open("crashlytics-build.properties");
            if (context != null) {
                try {
                    a = C1003d.m3447a((InputStream) context);
                } catch (Throwable e) {
                    Throwable th2 = e;
                    a = null;
                    th = th2;
                    try {
                        C6514c.h().e("Beta", "Error reading Beta build properties", th);
                        if (context != null) {
                            try {
                                context.close();
                            } catch (Context context2) {
                                C6514c.h().e("Beta", "Error closing Beta build properties asset", context2);
                            }
                        }
                        return a;
                    } catch (Throwable th3) {
                        th = th3;
                        if (context2 != null) {
                            try {
                                context2.close();
                            } catch (Context context22) {
                                C6514c.h().e("Beta", "Error closing Beta build properties asset", context22);
                            }
                        }
                        throw th;
                    }
                }
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a.f2810d);
                    stringBuilder.append(" build properties: ");
                    stringBuilder.append(a.f2808b);
                    stringBuilder.append(" (");
                    stringBuilder.append(a.f2807a);
                    stringBuilder.append(")");
                    stringBuilder.append(" - ");
                    stringBuilder.append(a.f2809c);
                    C6514c.h().a("Beta", stringBuilder.toString());
                    c1003d = a;
                } catch (Exception e2) {
                    th = e2;
                    C6514c.h().e("Beta", "Error reading Beta build properties", th);
                    if (context22 != null) {
                        context22.close();
                    }
                    return a;
                }
            }
            if (context22 == null) {
                return c1003d;
            }
            try {
                context22.close();
                return c1003d;
            } catch (Context context222) {
                C6514c.h().e("Beta", "Error closing Beta build properties asset", context222);
                return c1003d;
            }
        } catch (Context context2222) {
            a = null;
            th = context2222;
            context2222 = a;
            C6514c.h().e("Beta", "Error reading Beta build properties", th);
            if (context2222 != null) {
                context2222.close();
            }
            return a;
        } catch (Context context22222) {
            th = context22222;
            context22222 = null;
            if (context22222 != null) {
                context22222.close();
            }
            throw th;
        }
    }

    /* renamed from: g */
    String m10910g() {
        return C6428i.b(E(), "com.crashlytics.ApiEndpoint");
    }
}
