package com.bugsnag.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.facebook.internal.ServerProtocol;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AppData */
/* renamed from: com.bugsnag.android.a */
class C1070a {
    /* renamed from: b */
    private static final long f2993b = SystemClock.elapsedRealtime();
    /* renamed from: a */
    final String f2994a;
    /* renamed from: c */
    private final C1089j f2995c;
    /* renamed from: d */
    private final Context f2996d;
    /* renamed from: e */
    private final String f2997e;
    /* renamed from: f */
    private String f2998f = null;
    /* renamed from: g */
    private PackageInfo f2999g;
    /* renamed from: h */
    private ApplicationInfo f3000h;
    /* renamed from: i */
    private PackageManager f3001i;

    C1070a(com.bugsnag.android.C1089j r3) {
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
        r2.<init>();
        r0 = 0;
        r2.f2998f = r0;
        r2.f2995c = r3;
        r3 = r3.f3049b;
        r2.f2996d = r3;
        r3 = r2.f2996d;
        r3 = r3.getPackageName();
        r2.f2997e = r3;
        r3 = r2.f2996d;	 Catch:{ NameNotFoundException -> 0x0032 }
        r3 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0032 }
        r2.f3001i = r3;	 Catch:{ NameNotFoundException -> 0x0032 }
        r3 = r2.f3001i;	 Catch:{ NameNotFoundException -> 0x0032 }
        r0 = r2.f2997e;	 Catch:{ NameNotFoundException -> 0x0032 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0032 }
        r3 = r3.getPackageInfo(r0, r1);	 Catch:{ NameNotFoundException -> 0x0032 }
        r2.f2999g = r3;	 Catch:{ NameNotFoundException -> 0x0032 }
        r3 = r2.f3001i;	 Catch:{ NameNotFoundException -> 0x0032 }
        r0 = r2.f2997e;	 Catch:{ NameNotFoundException -> 0x0032 }
        r3 = r3.getApplicationInfo(r0, r1);	 Catch:{ NameNotFoundException -> 0x0032 }
        r2.f3000h = r3;	 Catch:{ NameNotFoundException -> 0x0032 }
        goto L_0x0048;
    L_0x0032:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = "Could not retrieve package/application information for ";
        r3.append(r0);
        r0 = r2.f2997e;
        r3.append(r0);
        r3 = r3.toString();
        com.bugsnag.android.ad.m3736b(r3);
    L_0x0048:
        r3 = r2.m3698j();
        r2.f2994a = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.a.<init>(com.bugsnag.android.j):void");
    }

    /* renamed from: a */
    Map<String, Object> m3701a() {
        Map<String, Object> hashMap = new HashMap();
        C1091l c1091l = this.f2995c.f3048a;
        hashMap.put("type", m3693a(c1091l));
        hashMap.put("releaseStage", m3706f());
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, m3697i());
        hashMap.put("versionCode", m3696h());
        hashMap.put("codeBundleId", c1091l.m3866s());
        return hashMap;
    }

    /* renamed from: b */
    Map<String, Object> m3703b() {
        Map<String, Object> a = m3701a();
        a.put("id", this.f2997e);
        a.put("buildUUID", this.f2995c.f3048a.m3849f());
        a.put("duration", Long.valueOf(C1070a.m3694d()));
        a.put("durationInForeground", Long.valueOf(m3695g()));
        a.put("inForeground", Boolean.valueOf(this.f2995c.f3056i.m3758h()));
        a.put("packageName", this.f2997e);
        a.put("binaryArch", this.f2998f);
        return a;
    }

    /* renamed from: c */
    Map<String, Object> m3704c() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("name", this.f2994a);
        hashMap.put("packageName", this.f2997e);
        hashMap.put("versionName", m3697i());
        hashMap.put("activeScreen", m3705e());
        hashMap.put("memoryUsage", Long.valueOf(m3699k()));
        hashMap.put("lowMemory", m3700l());
        return hashMap;
    }

    /* renamed from: a */
    void m3702a(String str) {
        this.f2998f = str;
    }

    /* renamed from: d */
    static long m3694d() {
        return SystemClock.elapsedRealtime() - f2993b;
    }

    /* renamed from: g */
    private long m3695g() {
        return this.f2995c.f3056i.m3746a(System.currentTimeMillis());
    }

    /* renamed from: e */
    String m3705e() {
        return this.f2995c.f3056i.m3759i();
    }

    /* renamed from: a */
    private String m3693a(C1091l c1091l) {
        c1091l = c1091l.m3867t();
        return c1091l != null ? c1091l : "android";
    }

    /* renamed from: h */
    private Integer m3696h() {
        return this.f2999g != null ? Integer.valueOf(this.f2999g.versionCode) : null;
    }

    /* renamed from: i */
    private String m3697i() {
        String b = this.f2995c.f3048a.m3835b();
        if (b != null) {
            return b;
        }
        return this.f2999g != null ? this.f2999g.versionName : null;
    }

    /* renamed from: f */
    String m3706f() {
        String i = this.f2995c.f3048a.m3855i();
        if (i != null) {
            return i;
        }
        return (this.f3000h == null || (this.f3000h.flags & 2) == 0) ? "production" : "development";
    }

    /* renamed from: j */
    private String m3698j() {
        return (this.f3001i == null || this.f3000h == null) ? null : this.f3001i.getApplicationLabel(this.f3000h).toString();
    }

    /* renamed from: k */
    private long m3699k() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    /* renamed from: l */
    private java.lang.Boolean m3700l() {
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
        r0 = r2.f2996d;	 Catch:{ Exception -> 0x001b }
        r1 = "activity";	 Catch:{ Exception -> 0x001b }
        r0 = r0.getSystemService(r1);	 Catch:{ Exception -> 0x001b }
        r0 = (android.app.ActivityManager) r0;	 Catch:{ Exception -> 0x001b }
        if (r0 == 0) goto L_0x0020;	 Catch:{ Exception -> 0x001b }
    L_0x000c:
        r1 = new android.app.ActivityManager$MemoryInfo;	 Catch:{ Exception -> 0x001b }
        r1.<init>();	 Catch:{ Exception -> 0x001b }
        r0.getMemoryInfo(r1);	 Catch:{ Exception -> 0x001b }
        r0 = r1.lowMemory;	 Catch:{ Exception -> 0x001b }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x001b }
        return r0;
    L_0x001b:
        r0 = "Could not check lowMemory status";
        com.bugsnag.android.ad.m3736b(r0);
    L_0x0020:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.a.l():java.lang.Boolean");
    }
}
