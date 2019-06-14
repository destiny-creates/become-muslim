package com.google.android.gms.internal.p213l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p180d.C2829c;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C2906q;
import com.google.android.gms.internal.p213l.as.C5034a;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.google.android.gms.internal.l.aa */
public final class aa extends db {
    /* renamed from: a */
    private Boolean f28966a;
    /* renamed from: b */
    private ac f28967b = ab.f24568a;
    /* renamed from: c */
    private Boolean f28968c;

    aa(cg cgVar) {
        super(cgVar);
    }

    /* renamed from: e */
    static String m38031e() {
        return (String) as.f16941i.m21260b();
    }

    /* renamed from: j */
    public static long m38032j() {
        return ((Long) as.f16918L.m21260b()).longValue();
    }

    /* renamed from: k */
    public static long m38033k() {
        return ((Long) as.f16944l.m21260b()).longValue();
    }

    /* renamed from: w */
    public static boolean m38034w() {
        return ((Boolean) as.f16940h.m21260b()).booleanValue();
    }

    /* renamed from: a */
    public final int m38035a(String str) {
        return m38039b(str, as.f16955w);
    }

    /* renamed from: a */
    public final long m38036a(java.lang.String r3, com.google.android.gms.internal.p213l.as.C5034a<java.lang.Long> r4) {
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
        if (r3 != 0) goto L_0x000d;
    L_0x0002:
        r3 = r4.m21260b();
        r3 = (java.lang.Long) r3;
        r3 = r3.longValue();
        return r3;
    L_0x000d:
        r0 = r2.f28967b;
        r1 = r4.m21259a();
        r3 = r0.mo4733a(r3, r1);
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0002;
    L_0x001e:
        r0 = java.lang.Long.parseLong(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = java.lang.Long.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = r4.m21258a(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = (java.lang.Long) r3;	 Catch:{ NumberFormatException -> 0x0002 }
        r0 = r3.longValue();	 Catch:{ NumberFormatException -> 0x0002 }
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.aa.a(java.lang.String, com.google.android.gms.internal.l.as$a):long");
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    final void m38038a(ac acVar) {
        this.f28967b = acVar;
    }

    /* renamed from: b */
    public final int m38039b(java.lang.String r3, com.google.android.gms.internal.p213l.as.C5034a<java.lang.Integer> r4) {
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
        if (r3 != 0) goto L_0x000d;
    L_0x0002:
        r3 = r4.m21260b();
        r3 = (java.lang.Integer) r3;
        r3 = r3.intValue();
        return r3;
    L_0x000d:
        r0 = r2.f28967b;
        r1 = r4.m21259a();
        r3 = r0.mo4733a(r3, r1);
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0002;
    L_0x001e:
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = r4.m21258a(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = (java.lang.Integer) r3;	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = r3.intValue();	 Catch:{ NumberFormatException -> 0x0002 }
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.aa.b(java.lang.String, com.google.android.gms.internal.l.as$a):int");
    }

    /* renamed from: b */
    final Boolean m38040b(String str) {
        C2872v.a(str);
        try {
            if (mo4752n().getPackageManager() == null) {
                mo4754r().I_().m21307a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo a = C2829c.a(mo4752n()).a(mo4752n().getPackageName(), 128);
            if (a == null) {
                mo4754r().I_().m21307a("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (a.metaData != null) {
                return !a.metaData.containsKey(str) ? null : Boolean.valueOf(a.metaData.getBoolean(str));
            } else {
                mo4754r().I_().m21307a("Failed to load metadata: Metadata bundle is null");
                return null;
            }
        } catch (NameNotFoundException e) {
            mo4754r().I_().m21308a("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: c */
    public final double m38042c(java.lang.String r3, com.google.android.gms.internal.p213l.as.C5034a<java.lang.Double> r4) {
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
        if (r3 != 0) goto L_0x000d;
    L_0x0002:
        r3 = r4.m21260b();
        r3 = (java.lang.Double) r3;
        r3 = r3.doubleValue();
        return r3;
    L_0x000d:
        r0 = r2.f28967b;
        r1 = r4.m21259a();
        r3 = r0.mo4733a(r3, r1);
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0002;
    L_0x001e:
        r0 = java.lang.Double.parseDouble(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = java.lang.Double.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = r4.m21258a(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = (java.lang.Double) r3;	 Catch:{ NumberFormatException -> 0x0002 }
        r0 = r3.doubleValue();	 Catch:{ NumberFormatException -> 0x0002 }
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.aa.c(java.lang.String, com.google.android.gms.internal.l.as$a):double");
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: c */
    public final boolean m38044c(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.f28967b.mo4733a(str, "gaia_collection_enabled"));
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: d */
    public final boolean m38046d(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.f28967b.mo4733a(str, "measurement.event_sampling_enabled"));
    }

    /* renamed from: d */
    public final boolean m38047d(String str, C5034a<Boolean> c5034a) {
        Object a;
        if (str != null) {
            a = this.f28967b.mo4733a(str, c5034a.m21259a());
            if (!TextUtils.isEmpty(a)) {
                a = c5034a.m21258a(Boolean.valueOf(Boolean.parseBoolean(a)));
                return ((Boolean) a).booleanValue();
            }
        }
        a = c5034a.m21260b();
        return ((Boolean) a).booleanValue();
    }

    /* renamed from: e */
    final boolean m38048e(String str) {
        return m38047d(str, as.f16927U);
    }

    /* renamed from: f */
    public final long m38049f() {
        mo4755u();
        return 12780;
    }

    /* renamed from: f */
    final boolean m38050f(String str) {
        return m38047d(str, as.f16929W);
    }

    /* renamed from: g */
    public final boolean m38051g() {
        if (this.f28968c == null) {
            synchronized (this) {
                if (this.f28968c == null) {
                    ApplicationInfo applicationInfo = mo4752n().getApplicationInfo();
                    String a = C2906q.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(a);
                        this.f28968c = Boolean.valueOf(z);
                    }
                    if (this.f28968c == null) {
                        this.f28968c = Boolean.TRUE;
                        mo4754r().I_().m21307a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f28968c.booleanValue();
    }

    /* renamed from: g */
    final boolean m38052g(String str) {
        return m38047d(str, as.f16930X);
    }

    /* renamed from: h */
    public final boolean m38053h() {
        mo4755u();
        Boolean b = m38040b("firebase_analytics_collection_deactivated");
        return b != null && b.booleanValue();
    }

    /* renamed from: h */
    final boolean m38054h(String str) {
        return m38047d(str, as.f16922P);
    }

    /* renamed from: i */
    public final Boolean m38055i() {
        mo4755u();
        return m38040b("firebase_analytics_collection_enabled");
    }

    /* renamed from: i */
    final String m38056i(String str) {
        C5034a c5034a = as.f16923Q;
        return (String) (str == null ? c5034a.m21260b() : c5034a.m21258a(this.f28967b.mo4733a(str, c5034a.m21259a())));
    }

    /* renamed from: j */
    final boolean m38057j(String str) {
        return m38047d(str, as.f16931Y);
    }

    /* renamed from: k */
    final boolean m38058k(String str) {
        return m38047d(str, as.f16932Z);
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: l */
    final boolean m38060l(String str) {
        return m38047d(str, as.ac);
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

    /* renamed from: v */
    public final String m38070v() {
        Object e;
        bd I_;
        String str;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"debug.firebase.analytics.app", ""});
        } catch (ClassNotFoundException e2) {
            e = e2;
            I_ = mo4754r().I_();
            str = "Could not find SystemProperties class";
            I_.m21308a(str, e);
            return "";
        } catch (NoSuchMethodException e3) {
            e = e3;
            I_ = mo4754r().I_();
            str = "Could not find SystemProperties.get() method";
            I_.m21308a(str, e);
            return "";
        } catch (IllegalAccessException e4) {
            e = e4;
            I_ = mo4754r().I_();
            str = "Could not access SystemProperties.get()";
            I_.m21308a(str, e);
            return "";
        } catch (InvocationTargetException e5) {
            e = e5;
            I_ = mo4754r().I_();
            str = "SystemProperties.get() threw an exception";
            I_.m21308a(str, e);
            return "";
        }
    }

    /* renamed from: x */
    final boolean m38071x() {
        if (this.f28966a == null) {
            this.f28966a = m38040b("app_measurement_lite");
            if (this.f28966a == null) {
                this.f28966a = Boolean.valueOf(false);
            }
        }
        return this.f28966a.booleanValue();
    }
}
