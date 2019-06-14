package com.google.android.gms.internal.p213l;

import android.content.Context;
import com.google.android.gms.common.util.C2895e;
import java.math.BigInteger;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.l.aw */
public final class aw extends C8220s {
    /* renamed from: a */
    private String f32788a;
    /* renamed from: b */
    private String f32789b;
    /* renamed from: c */
    private int f32790c;
    /* renamed from: d */
    private String f32791d;
    /* renamed from: e */
    private String f32792e;
    /* renamed from: f */
    private long f32793f;
    /* renamed from: g */
    private long f32794g;
    /* renamed from: h */
    private int f32795h;
    /* renamed from: i */
    private String f32796i;

    aw(cg cgVar) {
        super(cgVar);
    }

    /* renamed from: G */
    private final java.lang.String m43955G() {
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
        r3 = this;
        r3.mo6210d();
        r3.mo6208b();
        r0 = r3.mo6215t();
        r1 = r3.f32788a;
        r0 = r0.m38057j(r1);
        r1 = 0;
        if (r0 == 0) goto L_0x001c;
    L_0x0013:
        r0 = r3.q;
        r0 = r0.m31983y();
        if (r0 != 0) goto L_0x001c;
    L_0x001b:
        return r1;
    L_0x001c:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m22665a();	 Catch:{ IllegalStateException -> 0x0025 }
        r0 = r0.m22685c();	 Catch:{ IllegalStateException -> 0x0025 }
        return r0;
    L_0x0025:
        r0 = r3.mo4754r();
        r0 = r0.m42565i();
        r2 = "Failed to retrieve Firebase Instance Id";
        r0.m21307a(r2);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.aw.G():java.lang.String");
    }

    /* renamed from: A */
    protected final void mo6851A() {
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
        r10 = this;
        r0 = "unknown";
        r1 = "Unknown";
        r2 = "Unknown";
        r3 = r10.mo4752n();
        r3 = r3.getPackageName();
        r4 = r10.mo4752n();
        r4 = r4.getPackageManager();
        r5 = 0;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r4 != 0) goto L_0x002d;
    L_0x001b:
        r4 = r10.mo4754r();
        r4 = r4.I_();
        r7 = "PackageManager is null, app identity information might be inaccurate. appId";
        r8 = com.google.android.gms.internal.p213l.bb.m42550a(r3);
        r4.m21308a(r7, r8);
        goto L_0x008b;
    L_0x002d:
        r7 = r4.getInstallerPackageName(r3);	 Catch:{ IllegalArgumentException -> 0x0033 }
        r0 = r7;
        goto L_0x0044;
    L_0x0033:
        r7 = r10.mo4754r();
        r7 = r7.I_();
        r8 = "Error retrieving app installer package name. appId";
        r9 = com.google.android.gms.internal.p213l.bb.m42550a(r3);
        r7.m21308a(r8, r9);
    L_0x0044:
        if (r0 != 0) goto L_0x0049;
    L_0x0046:
        r0 = "manual_install";
        goto L_0x0053;
    L_0x0049:
        r7 = "com.android.vending";
        r7 = r7.equals(r0);
        if (r7 == 0) goto L_0x0053;
    L_0x0051:
        r0 = "";
    L_0x0053:
        r7 = r10.mo4752n();	 Catch:{ NameNotFoundException -> 0x007a }
        r7 = r7.getPackageName();	 Catch:{ NameNotFoundException -> 0x007a }
        r7 = r4.getPackageInfo(r7, r5);	 Catch:{ NameNotFoundException -> 0x007a }
        if (r7 == 0) goto L_0x008b;	 Catch:{ NameNotFoundException -> 0x007a }
    L_0x0061:
        r8 = r7.applicationInfo;	 Catch:{ NameNotFoundException -> 0x007a }
        r4 = r4.getApplicationLabel(r8);	 Catch:{ NameNotFoundException -> 0x007a }
        r8 = android.text.TextUtils.isEmpty(r4);	 Catch:{ NameNotFoundException -> 0x007a }
        if (r8 != 0) goto L_0x0072;	 Catch:{ NameNotFoundException -> 0x007a }
    L_0x006d:
        r4 = r4.toString();	 Catch:{ NameNotFoundException -> 0x007a }
        r2 = r4;	 Catch:{ NameNotFoundException -> 0x007a }
    L_0x0072:
        r4 = r7.versionName;	 Catch:{ NameNotFoundException -> 0x007a }
        r1 = r7.versionCode;	 Catch:{ NameNotFoundException -> 0x0079 }
        r6 = r1;
        r1 = r4;
        goto L_0x008b;
    L_0x0079:
        r1 = r4;
    L_0x007a:
        r4 = r10.mo4754r();
        r4 = r4.I_();
        r7 = "Error retrieving package info. appId, appName";
        r8 = com.google.android.gms.internal.p213l.bb.m42550a(r3);
        r4.m21309a(r7, r8, r2);
    L_0x008b:
        r10.f32788a = r3;
        r10.f32791d = r0;
        r10.f32789b = r1;
        r10.f32790c = r6;
        r10.f32792e = r2;
        r0 = 0;
        r10.f32793f = r0;
        r10.mo4755u();
        r2 = r10.mo4752n();
        r2 = com.google.android.gms.common.api.internal.C2799e.a(r2);
        r4 = 1;
        if (r2 == 0) goto L_0x00af;
    L_0x00a7:
        r6 = r2.d();
        if (r6 == 0) goto L_0x00af;
    L_0x00ad:
        r6 = 1;
        goto L_0x00b0;
    L_0x00af:
        r6 = 0;
    L_0x00b0:
        if (r6 != 0) goto L_0x00db;
    L_0x00b2:
        if (r2 != 0) goto L_0x00c2;
    L_0x00b4:
        r2 = r10.mo4754r();
        r2 = r2.I_();
        r7 = "GoogleService failed to initialize (no status)";
        r2.m21307a(r7);
        goto L_0x00db;
    L_0x00c2:
        r7 = r10.mo4754r();
        r7 = r7.I_();
        r8 = "GoogleService failed to initialize, status";
        r9 = r2.e();
        r9 = java.lang.Integer.valueOf(r9);
        r2 = r2.a();
        r7.m21309a(r8, r9, r2);
    L_0x00db:
        if (r6 == 0) goto L_0x0131;
    L_0x00dd:
        r2 = r10.mo6215t();
        r2 = r2.m38055i();
        r6 = r10.mo6215t();
        r6 = r6.m38053h();
        if (r6 == 0) goto L_0x00fd;
    L_0x00ef:
        r2 = r10.mo4754r();
        r2 = r2.m42567k();
        r4 = "Collection disabled with firebase_analytics_collection_deactivated=1";
    L_0x00f9:
        r2.m21307a(r4);
        goto L_0x0131;
    L_0x00fd:
        if (r2 == 0) goto L_0x0110;
    L_0x00ff:
        r6 = r2.booleanValue();
        if (r6 != 0) goto L_0x0110;
    L_0x0105:
        r2 = r10.mo4754r();
        r2 = r2.m42567k();
        r4 = "Collection disabled with firebase_analytics_collection_enabled=0";
        goto L_0x00f9;
    L_0x0110:
        if (r2 != 0) goto L_0x0123;
    L_0x0112:
        r2 = com.google.android.gms.common.api.internal.C2799e.b();
        if (r2 == 0) goto L_0x0123;
    L_0x0118:
        r2 = r10.mo4754r();
        r2 = r2.m42567k();
        r4 = "Collection disabled with google_app_measurement_enable=0";
        goto L_0x00f9;
    L_0x0123:
        r2 = r10.mo4754r();
        r2 = r2.m42579w();
        r6 = "Collection enabled";
        r2.m21307a(r6);
        goto L_0x0132;
    L_0x0131:
        r4 = 0;
    L_0x0132:
        r2 = "";
        r10.f32796i = r2;
        r10.f32794g = r0;
        r10.mo4755u();
        r0 = r10.q;
        r0 = r0.m31974p();
        if (r0 == 0) goto L_0x014c;
    L_0x0143:
        r0 = r10.q;
        r0 = r0.m31974p();
        r10.f32796i = r0;
        goto L_0x0180;
    L_0x014c:
        r0 = com.google.android.gms.common.api.internal.C2799e.a();	 Catch:{ IllegalStateException -> 0x016e }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ IllegalStateException -> 0x016e }
        if (r1 == 0) goto L_0x0158;	 Catch:{ IllegalStateException -> 0x016e }
    L_0x0156:
        r0 = "";	 Catch:{ IllegalStateException -> 0x016e }
    L_0x0158:
        r10.f32796i = r0;	 Catch:{ IllegalStateException -> 0x016e }
        if (r4 == 0) goto L_0x0180;	 Catch:{ IllegalStateException -> 0x016e }
    L_0x015c:
        r0 = r10.mo4754r();	 Catch:{ IllegalStateException -> 0x016e }
        r0 = r0.m42579w();	 Catch:{ IllegalStateException -> 0x016e }
        r1 = "App package, google app id";	 Catch:{ IllegalStateException -> 0x016e }
        r2 = r10.f32788a;	 Catch:{ IllegalStateException -> 0x016e }
        r4 = r10.f32796i;	 Catch:{ IllegalStateException -> 0x016e }
        r0.m21309a(r1, r2, r4);	 Catch:{ IllegalStateException -> 0x016e }
        goto L_0x0180;
    L_0x016e:
        r0 = move-exception;
        r1 = r10.mo4754r();
        r1 = r1.I_();
        r2 = "getGoogleAppId or isMeasurementEnabled failed with exception. appId";
        r3 = com.google.android.gms.internal.p213l.bb.m42550a(r3);
        r1.m21309a(r2, r3, r0);
    L_0x0180:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x0191;
    L_0x0186:
        r0 = r10.mo4752n();
        r0 = com.google.android.gms.common.p180d.C2827a.a(r0);
        r10.f32795h = r0;
        return;
    L_0x0191:
        r10.f32795h = r5;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.aw.A():void");
    }

    /* renamed from: B */
    final String m43957B() {
        mo6213p().m42681h().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    /* renamed from: C */
    final String m43958C() {
        m42728w();
        return this.f32788a;
    }

    /* renamed from: D */
    final String m43959D() {
        m42728w();
        return this.f32796i;
    }

    /* renamed from: E */
    final int m43960E() {
        m42728w();
        return this.f32790c;
    }

    /* renamed from: F */
    final int m43961F() {
        m42728w();
        return this.f32795h;
    }

    /* renamed from: a */
    final C7826u m43962a(String str) {
        boolean z;
        boolean booleanValue;
        boolean z2;
        long j;
        mo6210d();
        mo6208b();
        String C = m43958C();
        String D = m43959D();
        m42728w();
        String str2 = this.f32789b;
        long E = (long) m43960E();
        m42728w();
        String str3 = this.f32791d;
        long f = mo6215t().m38049f();
        m42728w();
        mo6210d();
        if (this.f32793f == 0) {
            r0.f32793f = r0.q.m31969k().m42655a(mo4752n(), mo4752n().getPackageName());
        }
        long j2 = r0.f32793f;
        boolean y = r0.q.m31983y();
        boolean z3 = mo6214s().f32339p ^ 1;
        String G = m43955G();
        m42728w();
        boolean z4 = z3;
        String str4 = G;
        long j3 = r0.f32794g;
        long z5 = r0.q.m31984z();
        int F = m43961F();
        db t = mo6215t();
        t.mo6208b();
        Boolean b = t.m38040b("google_analytics_adid_collection_enabled");
        if (b != null) {
            if (!b.booleanValue()) {
                z = false;
                booleanValue = Boolean.valueOf(z).booleanValue();
                t = mo6215t();
                t.mo6208b();
                b = t.m38040b("google_analytics_ssaid_collection_enabled");
                if (b != null) {
                    if (b.booleanValue()) {
                        z2 = false;
                        j = j3;
                        return new C7826u(C, D, str2, E, str3, f, j2, str, y, z4, str4, j, z5, F, booleanValue, Boolean.valueOf(z2).booleanValue(), mo6214s().m42598v());
                    }
                }
                z2 = true;
                j = j3;
                return new C7826u(C, D, str2, E, str3, f, j2, str, y, z4, str4, j, z5, F, booleanValue, Boolean.valueOf(z2).booleanValue(), mo6214s().m42598v());
            }
        }
        z = true;
        booleanValue = Boolean.valueOf(z).booleanValue();
        t = mo6215t();
        t.mo6208b();
        b = t.m38040b("google_analytics_ssaid_collection_enabled");
        if (b != null) {
            if (b.booleanValue()) {
                z2 = false;
                j = j3;
                return new C7826u(C, D, str2, E, str3, f, j2, str, y, z4, str4, j, z5, F, booleanValue, Boolean.valueOf(z2).booleanValue(), mo6214s().m42598v());
            }
        }
        z2 = true;
        j = j3;
        return new C7826u(C, D, str2, E, str3, f, j2, str, y, z4, str4, j, z5, F, booleanValue, Boolean.valueOf(z2).booleanValue(), mo6214s().m42598v());
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: e */
    public final /* bridge */ /* synthetic */ C8219n mo6741e() {
        return super.mo6741e();
    }

    /* renamed from: f */
    public final /* bridge */ /* synthetic */ df mo6742f() {
        return super.mo6742f();
    }

    /* renamed from: g */
    public final /* bridge */ /* synthetic */ aw mo6743g() {
        return super.mo6743g();
    }

    /* renamed from: h */
    public final /* bridge */ /* synthetic */ ed mo6744h() {
        return super.mo6744h();
    }

    /* renamed from: i */
    public final /* bridge */ /* synthetic */ ea mo6745i() {
        return super.mo6745i();
    }

    /* renamed from: j */
    public final /* bridge */ /* synthetic */ ax mo6746j() {
        return super.mo6746j();
    }

    /* renamed from: k */
    public final /* bridge */ /* synthetic */ fc mo6747k() {
        return super.mo6747k();
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: m */
    public final /* bridge */ /* synthetic */ C2895e mo4751m() {
        return super.mo4751m();
    }

    /* renamed from: n */
    public final /* bridge */ /* synthetic */ Context mo4752n() {
        return super.mo4752n();
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ az mo6212o() {
        return super.mo6212o();
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ fw mo6213p() {
        return super.mo6213p();
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ cb mo4753q() {
        return super.mo4753q();
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ bb mo4754r() {
        return super.mo4754r();
    }

    /* renamed from: s */
    public final /* bridge */ /* synthetic */ bm mo6214s() {
        return super.mo6214s();
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ aa mo6215t() {
        return super.mo6215t();
    }

    /* renamed from: u */
    public final /* bridge */ /* synthetic */ C5052x mo4755u() {
        return super.mo4755u();
    }

    /* renamed from: z */
    protected final boolean mo6852z() {
        return true;
    }
}
