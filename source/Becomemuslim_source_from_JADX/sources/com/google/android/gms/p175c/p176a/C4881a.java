package com.google.android.gms.p175c.p176a;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.internal.C2850d.C4367d;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C4785j;
import com.google.android.gms.p175c.C4764e;
import com.google.android.gms.p175c.C4882a;

/* renamed from: com.google.android.gms.c.a.a */
public class C4881a extends C4785j<C2767g> implements C4764e {
    /* renamed from: e */
    private final boolean f13962e;
    /* renamed from: f */
    private final C2853f f13963f;
    /* renamed from: g */
    private final Bundle f13964g;
    /* renamed from: h */
    private Integer f13965h;

    private C4881a(Context context, Looper looper, boolean z, C2853f c2853f, Bundle bundle, C2775b c2775b, C2776c c2776c) {
        super(context, looper, 44, c2853f, c2775b, c2776c);
        this.f13962e = true;
        this.f13963f = c2853f;
        this.f13964g = bundle;
        this.f13965h = c2853f.m8328j();
    }

    /* renamed from: b */
    protected String mo3449b() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* renamed from: f */
    public int mo3293f() {
        return C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    protected String q_() {
        return "com.google.android.gms.signin.service.START";
    }

    public C4881a(Context context, Looper looper, boolean z, C2853f c2853f, C4882a c4882a, C2775b c2775b, C2776c c2776c) {
        this(context, looper, true, c2853f, C4881a.m17472a(c2853f), c2775b, c2776c);
    }

    /* renamed from: j */
    public boolean mo3457j() {
        return this.f13962e;
    }

    /* renamed from: a */
    public final void mo3456a(com.google.android.gms.common.internal.C2862o r3, boolean r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.m8308w();	 Catch:{ RemoteException -> 0x0010 }
        r0 = (com.google.android.gms.p175c.p176a.C2767g) r0;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r2.f13965h;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r1.intValue();	 Catch:{ RemoteException -> 0x0010 }
        r0.mo2374a(r3, r1, r4);	 Catch:{ RemoteException -> 0x0010 }
        return;
    L_0x0010:
        r3 = "SignInClientImpl";
        r4 = "Remote service probably died when saveDefaultAccount is called";
        android.util.Log.w(r3, r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.c.a.a.a(com.google.android.gms.common.internal.o, boolean):void");
    }

    /* renamed from: e */
    public final void mo3452e() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.m8308w();	 Catch:{ RemoteException -> 0x0010 }
        r0 = (com.google.android.gms.p175c.p176a.C2767g) r0;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r2.f13965h;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r1.intValue();	 Catch:{ RemoteException -> 0x0010 }
        r0.mo2372a(r1);	 Catch:{ RemoteException -> 0x0010 }
        return;
    L_0x0010:
        r0 = "SignInClientImpl";
        r1 = "Remote service probably died when clearAccountFromSessionStore is called";
        android.util.Log.w(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.c.a.a.e():void");
    }

    /* renamed from: a */
    public final void mo3455a(com.google.android.gms.p175c.p176a.C2766e r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = "Expecting a valid ISignInCallbacks";
        com.google.android.gms.common.internal.C2872v.m8381a(r5, r0);
        r0 = r4.f13963f;	 Catch:{ RemoteException -> 0x003c }
        r0 = r0.m8321c();	 Catch:{ RemoteException -> 0x003c }
        r1 = 0;	 Catch:{ RemoteException -> 0x003c }
        r2 = "<<default account>>";	 Catch:{ RemoteException -> 0x003c }
        r3 = r0.name;	 Catch:{ RemoteException -> 0x003c }
        r2 = r2.equals(r3);	 Catch:{ RemoteException -> 0x003c }
        if (r2 == 0) goto L_0x0022;	 Catch:{ RemoteException -> 0x003c }
    L_0x0016:
        r1 = r4.m8303r();	 Catch:{ RemoteException -> 0x003c }
        r1 = com.google.android.gms.auth.api.signin.internal.C2742c.m7801a(r1);	 Catch:{ RemoteException -> 0x003c }
        r1 = r1.m7807a();	 Catch:{ RemoteException -> 0x003c }
    L_0x0022:
        r2 = new com.google.android.gms.common.internal.w;	 Catch:{ RemoteException -> 0x003c }
        r3 = r4.f13965h;	 Catch:{ RemoteException -> 0x003c }
        r3 = r3.intValue();	 Catch:{ RemoteException -> 0x003c }
        r2.<init>(r0, r3, r1);	 Catch:{ RemoteException -> 0x003c }
        r0 = r4.m8308w();	 Catch:{ RemoteException -> 0x003c }
        r0 = (com.google.android.gms.p175c.p176a.C2767g) r0;	 Catch:{ RemoteException -> 0x003c }
        r1 = new com.google.android.gms.c.a.i;	 Catch:{ RemoteException -> 0x003c }
        r1.<init>(r2);	 Catch:{ RemoteException -> 0x003c }
        r0.mo2373a(r1, r5);	 Catch:{ RemoteException -> 0x003c }
        return;
    L_0x003c:
        r0 = move-exception;
        r1 = "SignInClientImpl";
        r2 = "Remote service probably died when signIn is called";
        android.util.Log.w(r1, r2);
        r1 = new com.google.android.gms.c.a.k;	 Catch:{ RemoteException -> 0x004f }
        r2 = 8;	 Catch:{ RemoteException -> 0x004f }
        r1.<init>(r2);	 Catch:{ RemoteException -> 0x004f }
        r5.mo3273a(r1);	 Catch:{ RemoteException -> 0x004f }
        return;
    L_0x004f:
        r5 = "SignInClientImpl";
        r1 = "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.";
        android.util.Log.wtf(r5, r1, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.c.a.a.a(com.google.android.gms.c.a.e):void");
    }

    /* renamed from: u */
    protected Bundle mo3458u() {
        if (!m8303r().getPackageName().equals(this.f13963f.m8325g())) {
            this.f13964g.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f13963f.m8325g());
        }
        return this.f13964g;
    }

    /* renamed from: A */
    public final void mo3454A() {
        m8282a(new C4367d(this));
    }

    /* renamed from: a */
    public static Bundle m17472a(C2853f c2853f) {
        C4882a i = c2853f.m8327i();
        Integer j = c2853f.m8328j();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c2853f.m8320b());
        if (j != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", j.intValue());
        }
        if (i != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", i.m17482a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", i.m17483b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", i.m17484c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", i.m17485d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", i.m17486e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", i.m17487f());
            if (i.m17488g() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", i.m17488g().longValue());
            }
            if (i.m17489h() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", i.m17489h().longValue());
            }
        }
        return bundle;
    }

    /* renamed from: a */
    protected /* synthetic */ IInterface mo3448a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof C2767g) {
            return (C2767g) queryLocalInterface;
        }
        return new C4331h(iBinder);
    }
}
