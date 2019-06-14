package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.common.util.p183a.C2888b;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.p186f.C2955h;
import com.google.firebase.C5324a;
import com.google.firebase.C5335b;
import com.google.firebase.p244a.C5321b;
import com.google.firebase.p244a.C5323d;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseInstanceId {
    /* renamed from: a */
    private static final long f18032a = TimeUnit.HOURS.toSeconds(8);
    /* renamed from: b */
    private static C5371z f18033b;
    /* renamed from: c */
    private static ScheduledThreadPoolExecutor f18034c;
    /* renamed from: d */
    private final Executor f18035d;
    /* renamed from: e */
    private final C5335b f18036e;
    /* renamed from: f */
    private final C5366q f18037f;
    /* renamed from: g */
    private C5353b f18038g;
    /* renamed from: h */
    private final C5367t f18039h;
    /* renamed from: i */
    private final ae f18040i;
    /* renamed from: j */
    private boolean f18041j;
    /* renamed from: k */
    private final C5349a f18042k;

    /* renamed from: com.google.firebase.iid.FirebaseInstanceId$a */
    private class C5349a {
        /* renamed from: a */
        final /* synthetic */ FirebaseInstanceId f18027a;
        /* renamed from: b */
        private final boolean f18028b = m22662c();
        /* renamed from: c */
        private final C5323d f18029c;
        /* renamed from: d */
        private C5321b<C5324a> f18030d;
        /* renamed from: e */
        private Boolean f18031e = m22661b();

        C5349a(FirebaseInstanceId firebaseInstanceId, C5323d c5323d) {
            this.f18027a = firebaseInstanceId;
            this.f18029c = c5323d;
            if (this.f18031e == null && this.f18028b != null) {
                this.f18030d = new at(this);
                c5323d.mo4880a(C5324a.class, this.f18030d);
            }
        }

        /* renamed from: a */
        final synchronized boolean m22663a() {
            if (this.f18031e == null) {
                return this.f18028b && this.f18027a.f18036e.m22615e();
            } else {
                return this.f18031e.booleanValue();
            }
        }

        /* renamed from: b */
        private final java.lang.Boolean m22661b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r4.f18027a;
            r0 = r0.f18036e;
            r0 = r0.m22611a();
            r1 = "com.google.firebase.messaging";
            r2 = 0;
            r1 = r0.getSharedPreferences(r1, r2);
            r3 = "auto_init";
            r3 = r1.contains(r3);
            if (r3 == 0) goto L_0x0024;
        L_0x0019:
            r0 = "auto_init";
            r0 = r1.getBoolean(r0, r2);
            r0 = java.lang.Boolean.valueOf(r0);
            return r0;
        L_0x0024:
            r1 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0051 }
            if (r1 == 0) goto L_0x0051;	 Catch:{ NameNotFoundException -> 0x0051 }
        L_0x002a:
            r0 = r0.getPackageName();	 Catch:{ NameNotFoundException -> 0x0051 }
            r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0051 }
            r0 = r1.getApplicationInfo(r0, r2);	 Catch:{ NameNotFoundException -> 0x0051 }
            if (r0 == 0) goto L_0x0051;	 Catch:{ NameNotFoundException -> 0x0051 }
        L_0x0036:
            r1 = r0.metaData;	 Catch:{ NameNotFoundException -> 0x0051 }
            if (r1 == 0) goto L_0x0051;	 Catch:{ NameNotFoundException -> 0x0051 }
        L_0x003a:
            r1 = r0.metaData;	 Catch:{ NameNotFoundException -> 0x0051 }
            r2 = "firebase_messaging_auto_init_enabled";	 Catch:{ NameNotFoundException -> 0x0051 }
            r1 = r1.containsKey(r2);	 Catch:{ NameNotFoundException -> 0x0051 }
            if (r1 == 0) goto L_0x0051;	 Catch:{ NameNotFoundException -> 0x0051 }
        L_0x0044:
            r0 = r0.metaData;	 Catch:{ NameNotFoundException -> 0x0051 }
            r1 = "firebase_messaging_auto_init_enabled";	 Catch:{ NameNotFoundException -> 0x0051 }
            r0 = r0.getBoolean(r1);	 Catch:{ NameNotFoundException -> 0x0051 }
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ NameNotFoundException -> 0x0051 }
            return r0;
        L_0x0051:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceId.a.b():java.lang.Boolean");
        }

        /* renamed from: c */
        private final boolean m22662c() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = 1;
            r1 = "com.google.firebase.messaging.a";	 Catch:{ ClassNotFoundException -> 0x0007 }
            java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0007 }
            return r0;
        L_0x0007:
            r1 = r4.f18027a;
            r1 = r1.f18036e;
            r1 = r1.m22611a();
            r2 = new android.content.Intent;
            r3 = "com.google.firebase.MESSAGING_EVENT";
            r2.<init>(r3);
            r3 = r1.getPackageName();
            r2.setPackage(r3);
            r1 = r1.getPackageManager();
            r3 = 0;
            r1 = r1.resolveService(r2, r3);
            if (r1 == 0) goto L_0x002f;
        L_0x002a:
            r1 = r1.serviceInfo;
            if (r1 == 0) goto L_0x002f;
        L_0x002e:
            return r0;
        L_0x002f:
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceId.a.c():boolean");
        }
    }

    /* renamed from: a */
    public static FirebaseInstanceId m22665a() {
        return getInstance(C5335b.m22606d());
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(C5335b c5335b) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) c5335b.m22612a(FirebaseInstanceId.class);
        }
        return firebaseInstanceId;
    }

    FirebaseInstanceId(C5335b c5335b, C5323d c5323d) {
        this(c5335b, new C5366q(c5335b.m22611a()), al.m22723b(), al.m22723b(), c5323d);
    }

    private FirebaseInstanceId(C5335b c5335b, C5366q c5366q, Executor executor, Executor executor2, C5323d c5323d) {
        this.f18041j = false;
        if (C5366q.m22779a(c5335b) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f18033b == null) {
                    f18033b = new C5371z(c5335b.m22611a());
                }
            }
            this.f18036e = c5335b;
            this.f18037f = c5366q;
            if (this.f18038g == null) {
                C5353b c5353b = (C5353b) c5335b.m22612a(C5353b.class);
                if (c5353b == null || !c5353b.mo4891b()) {
                    this.f18038g = new au(c5335b, c5366q, executor);
                } else {
                    this.f18038g = c5353b;
                }
            }
            this.f18038g = this.f18038g;
            this.f18035d = executor2;
            this.f18040i = new ae(f18033b);
            this.f18042k = new C5349a(this, c5323d);
            this.f18039h = new C5367t(executor);
            if (this.f18042k.m22663a() != null) {
                m22673n();
                return;
            }
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    /* renamed from: n */
    private final void m22673n() {
        aa f = m22688f();
        if (!m22692k() || f == null || f.m22699b(this.f18037f.m22783b()) || this.f18040i.m22713a()) {
            m22674o();
        }
    }

    /* renamed from: b */
    final C5335b m22683b() {
        return this.f18036e;
    }

    /* renamed from: a */
    final synchronized void m22682a(boolean z) {
        this.f18041j = z;
    }

    /* renamed from: o */
    private final synchronized void m22674o() {
        if (!this.f18041j) {
            m22678a(0);
        }
    }

    /* renamed from: a */
    final synchronized void m22678a(long j) {
        m22667a(new ab(this, this.f18037f, this.f18040i, Math.min(Math.max(30, j << 1), f18032a)), j);
        this.f18041j = true;
    }

    /* renamed from: a */
    static void m22667a(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (f18034c == null) {
                f18034c = new ScheduledThreadPoolExecutor(1, new C2888b("FirebaseInstanceId"));
            }
            f18034c.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    /* renamed from: c */
    public String m22685c() {
        m22673n();
        return m22675p();
    }

    /* renamed from: p */
    private static String m22675p() {
        return C5366q.m22780a(f18033b.m22812b("").m22756a());
    }

    /* renamed from: d */
    public C2954g<C5351a> m22686d() {
        return m22668b(C5366q.m22779a(this.f18036e), "*");
    }

    /* renamed from: b */
    private final C2954g<C5351a> m22668b(String str, String str2) {
        String c = m22671c(str2);
        C2955h c2955h = new C2955h();
        this.f18035d.execute(new aq(this, str, str2, c2955h, c));
        return c2955h.a();
    }

    @Deprecated
    /* renamed from: e */
    public String m22687e() {
        aa f = m22688f();
        if (f == null || f.m22699b(this.f18037f.m22783b())) {
            m22674o();
        }
        return f != null ? f.f18044a : null;
    }

    /* renamed from: f */
    final aa m22688f() {
        return m22670c(C5366q.m22779a(this.f18036e), "*");
    }

    /* renamed from: c */
    private static aa m22670c(String str, String str2) {
        return f18033b.m22808a("", str, str2);
    }

    /* renamed from: g */
    final String m22689g() {
        return m22677a(C5366q.m22779a(this.f18036e), "*");
    }

    /* renamed from: a */
    public String m22677a(String str, String str2) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((C5351a) m22666a(m22668b(str, str2))).mo4893a();
        }
        throw new IOException("MAIN_THREAD");
    }

    /* renamed from: a */
    private final <T> T m22666a(com.google.android.gms.p186f.C2954g<T> r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ ExecutionException -> 0x0011, InterruptedException -> 0x0009, InterruptedException -> 0x0009 }
        r4 = com.google.android.gms.p186f.C2958j.a(r4, r0, r2);	 Catch:{ ExecutionException -> 0x0011, InterruptedException -> 0x0009, InterruptedException -> 0x0009 }
        return r4;
    L_0x0009:
        r4 = new java.io.IOException;
        r0 = "SERVICE_NOT_AVAILABLE";
        r4.<init>(r0);
        throw r4;
    L_0x0011:
        r4 = move-exception;
        r0 = r4.getCause();
        r1 = r0 instanceof java.io.IOException;
        if (r1 == 0) goto L_0x002c;
    L_0x001a:
        r4 = "INSTANCE_ID_RESET";
        r1 = r0.getMessage();
        r4 = r4.equals(r1);
        if (r4 == 0) goto L_0x0029;
    L_0x0026:
        r3.m22690i();
    L_0x0029:
        r0 = (java.io.IOException) r0;
        throw r0;
    L_0x002c:
        r1 = r0 instanceof java.lang.RuntimeException;
        if (r1 == 0) goto L_0x0033;
    L_0x0030:
        r0 = (java.lang.RuntimeException) r0;
        throw r0;
    L_0x0033:
        r0 = new java.io.IOException;
        r0.<init>(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceId.a(com.google.android.gms.f.g):T");
    }

    /* renamed from: a */
    final void m22679a(String str) {
        aa f = m22688f();
        if (f == null || f.m22699b(this.f18037f.m22783b())) {
            throw new IOException("token not available");
        }
        m22666a(this.f18038g.mo4887a(m22675p(), f.f18044a, str));
    }

    /* renamed from: b */
    final void m22684b(String str) {
        aa f = m22688f();
        if (f == null || f.m22699b(this.f18037f.m22783b())) {
            throw new IOException("token not available");
        }
        m22666a(this.f18038g.mo4890b(m22675p(), f.f18044a, str));
    }

    /* renamed from: h */
    static boolean m22672h() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            if (VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseInstanceId", 3)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: i */
    final synchronized void m22690i() {
        f18033b.m22813b();
        if (this.f18042k.m22663a()) {
            m22674o();
        }
    }

    /* renamed from: j */
    final boolean m22691j() {
        return this.f18038g.mo4891b();
    }

    /* renamed from: k */
    final boolean m22692k() {
        return this.f18038g.mo4889a();
    }

    /* renamed from: l */
    final void m22693l() {
        m22666a(this.f18038g.mo4886a(m22675p(), aa.m22697a(m22688f())));
    }

    /* renamed from: m */
    final void m22694m() {
        f18033b.m22814c("");
        m22674o();
    }

    /* renamed from: c */
    private static String m22671c(String str) {
        if (!(str.isEmpty() || str.equalsIgnoreCase(AppMeasurement.FCM_ORIGIN))) {
            if (!str.equalsIgnoreCase("gcm")) {
                return str;
            }
        }
        return "*";
    }

    /* renamed from: a */
    final /* synthetic */ void m22680a(String str, String str2, C2955h c2955h, String str3) {
        String p = m22675p();
        aa c = m22670c(str, str2);
        if (c == null || c.m22699b(this.f18037f.m22783b())) {
            this.f18039h.m22787a(str, str3, new ar(this, p, aa.m22697a(c), str, str3)).a(this.f18035d, new as(this, str, str3, c2955h, p));
            return;
        }
        c2955h.a(new ba(p, c.f18044a));
    }

    /* renamed from: a */
    final /* synthetic */ void m22681a(String str, String str2, C2955h c2955h, String str3, C2954g c2954g) {
        if (c2954g.b()) {
            String str4 = (String) c2954g.d();
            f18033b.m22811a("", str, str2, str4, this.f18037f.m22783b());
            c2955h.a(new ba(str3, str4));
            return;
        }
        c2955h.a(c2954g.e());
    }

    /* renamed from: a */
    final /* synthetic */ C2954g m22676a(String str, String str2, String str3, String str4) {
        return this.f18038g.mo4888a(str, str2, str3, str4);
    }
}
