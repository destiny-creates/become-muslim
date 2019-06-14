package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.C2872v;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.auth.api.signin.internal.c */
public class C2742c {
    /* renamed from: a */
    private static final Lock f7031a = new ReentrantLock();
    /* renamed from: b */
    private static C2742c f7032b;
    /* renamed from: c */
    private final Lock f7033c = new ReentrantLock();
    /* renamed from: d */
    private final SharedPreferences f7034d;

    /* renamed from: a */
    public static C2742c m7801a(Context context) {
        C2872v.m8380a((Object) context);
        f7031a.lock();
        try {
            if (f7032b == null) {
                f7032b = new C2742c(context.getApplicationContext());
            }
            context = f7032b;
            return context;
        } finally {
            f7031a.unlock();
        }
    }

    private C2742c(Context context) {
        this.f7034d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    /* renamed from: a */
    public void m7808a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        C2872v.m8380a((Object) googleSignInAccount);
        C2872v.m8380a((Object) googleSignInOptions);
        m7802a("defaultGoogleSignInAccount", googleSignInAccount.m16667k());
        C2872v.m8380a((Object) googleSignInAccount);
        C2872v.m8380a((Object) googleSignInOptions);
        String k = googleSignInAccount.m16667k();
        m7802a(C2742c.m7804b("googleSignInAccount", k), googleSignInAccount.m16670n());
        m7802a(C2742c.m7804b("googleSignInOptions", k), googleSignInOptions.m17462h());
    }

    /* renamed from: a */
    private final void m7802a(String str, String str2) {
        this.f7033c.lock();
        try {
            this.f7034d.edit().putString(str, str2).apply();
        } finally {
            this.f7033c.unlock();
        }
    }

    /* renamed from: a */
    public GoogleSignInAccount m7807a() {
        return m7800a(m7805c("defaultGoogleSignInAccount"));
    }

    /* renamed from: a */
    private final com.google.android.gms.auth.api.signin.GoogleSignInAccount m7800a(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "googleSignInAccount";
        r3 = com.google.android.gms.auth.api.signin.internal.C2742c.m7804b(r0, r3);
        r3 = r2.m7805c(r3);
        if (r3 == 0) goto L_0x001a;
    L_0x0014:
        r3 = com.google.android.gms.auth.api.signin.GoogleSignInAccount.m16654a(r3);	 Catch:{ JSONException -> 0x0019 }
        return r3;
    L_0x0019:
        return r1;
    L_0x001a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.c.a(java.lang.String):com.google.android.gms.auth.api.signin.GoogleSignInAccount");
    }

    /* renamed from: b */
    public GoogleSignInOptions m7809b() {
        return m7803b(m7805c("defaultGoogleSignInAccount"));
    }

    /* renamed from: b */
    private final com.google.android.gms.auth.api.signin.GoogleSignInOptions m7803b(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "googleSignInOptions";
        r3 = com.google.android.gms.auth.api.signin.internal.C2742c.m7804b(r0, r3);
        r3 = r2.m7805c(r3);
        if (r3 == 0) goto L_0x001a;
    L_0x0014:
        r3 = com.google.android.gms.auth.api.signin.GoogleSignInOptions.m17443a(r3);	 Catch:{ JSONException -> 0x0019 }
        return r3;
    L_0x0019:
        return r1;
    L_0x001a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.c.b(java.lang.String):com.google.android.gms.auth.api.signin.GoogleSignInOptions");
    }

    /* renamed from: c */
    public String m7810c() {
        return m7805c("refreshToken");
    }

    /* renamed from: c */
    private final String m7805c(String str) {
        this.f7033c.lock();
        try {
            str = this.f7034d.getString(str, null);
            return str;
        } finally {
            this.f7033c.unlock();
        }
    }

    /* renamed from: d */
    public final void m7811d() {
        String c = m7805c("defaultGoogleSignInAccount");
        m7806d("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(c)) {
            m7806d(C2742c.m7804b("googleSignInAccount", c));
            m7806d(C2742c.m7804b("googleSignInOptions", c));
        }
    }

    /* renamed from: d */
    private final void m7806d(String str) {
        this.f7033c.lock();
        try {
            this.f7034d.edit().remove(str).apply();
        } finally {
            this.f7033c.unlock();
        }
    }

    /* renamed from: e */
    public void m7812e() {
        this.f7033c.lock();
        try {
            this.f7034d.edit().clear().apply();
        } finally {
            this.f7033c.unlock();
        }
    }

    /* renamed from: b */
    private static String m7804b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
