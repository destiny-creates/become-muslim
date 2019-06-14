package com.bugsnag.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.facebook.common.time.Clock;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* compiled from: DeviceData */
/* renamed from: com.bugsnag.android.r */
class C1099r {
    /* renamed from: f */
    private static final String[] f3089f = new String[]{"/system/xbin/su", "/system/bin/su", "/system/app/Superuser.apk", "/system/app/SuperSU.apk", "/system/app/Superuser", "/system/app/SuperSU", "/system/xbin/daemonsu", "/su/bin"};
    /* renamed from: a */
    Float f3090a;
    /* renamed from: b */
    Integer f3091b;
    /* renamed from: c */
    String f3092c;
    /* renamed from: d */
    String f3093d;
    /* renamed from: e */
    String[] f3094e;
    /* renamed from: g */
    private final C1089j f3095g;
    /* renamed from: h */
    private final boolean f3096h;
    /* renamed from: i */
    private final Context f3097i;
    /* renamed from: j */
    private final Resources f3098j = this.f3097i.getResources();
    /* renamed from: k */
    private final DisplayMetrics f3099k;
    /* renamed from: l */
    private final String f3100l;
    /* renamed from: m */
    private final boolean f3101m;

    /* compiled from: DeviceData */
    /* renamed from: com.bugsnag.android.r$a */
    static class C1097a {
        /* renamed from: a */
        static String[] m3878a() {
            return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
    }

    /* compiled from: DeviceData */
    /* renamed from: com.bugsnag.android.r$b */
    static class C1098b {
        /* renamed from: a */
        static String[] m3879a() {
            return Build.SUPPORTED_ABIS;
        }
    }

    C1099r(C1089j c1089j) {
        this.f3095g = c1089j;
        this.f3097i = c1089j.f3049b;
        if (this.f3098j != null) {
            this.f3099k = this.f3098j.getDisplayMetrics();
        } else {
            this.f3099k = null;
        }
        this.f3090a = m3883h();
        this.f3091b = m3884i();
        this.f3092c = m3885j();
        this.f3093d = m3886k();
        this.f3094e = m3888m();
        this.f3096h = m3882g();
        this.f3100l = m3887l();
        this.f3101m = m3881f();
    }

    /* renamed from: a */
    Map<String, Object> m3897a() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("manufacturer", Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("jailbroken", Boolean.valueOf(this.f3101m));
        hashMap.put("osName", "android");
        hashMap.put("osVersion", VERSION.RELEASE);
        hashMap.put("cpuAbi", this.f3094e);
        return hashMap;
    }

    /* renamed from: b */
    Map<String, Object> m3898b() {
        Map<String, Object> a = m3897a();
        a.put("id", this.f3100l);
        a.put("freeMemory", Long.valueOf(m3890o()));
        a.put("totalMemory", Long.valueOf(C1099r.m3880e()));
        a.put("freeDisk", m3889n());
        a.put("orientation", m3891p());
        return a;
    }

    /* renamed from: c */
    Map<String, Object> m3899c() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("batteryLevel", m3892q());
        hashMap.put("charging", m3893r());
        hashMap.put("locationStatus", m3894s());
        hashMap.put("networkAccess", m3895t());
        hashMap.put("time", m3896u());
        hashMap.put("brand", Build.BRAND);
        hashMap.put("apiLevel", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("osBuild", Build.DISPLAY);
        hashMap.put("locale", this.f3093d);
        hashMap.put("screenDensity", this.f3090a);
        hashMap.put("dpi", this.f3091b);
        hashMap.put("emulator", Boolean.valueOf(this.f3096h));
        hashMap.put("screenResolution", this.f3092c);
        return hashMap;
    }

    /* renamed from: d */
    String m3900d() {
        return this.f3100l;
    }

    /* renamed from: f */
    private boolean m3881f() {
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
        r7 = this;
        r0 = android.os.Build.TAGS;
        r1 = 1;
        if (r0 == 0) goto L_0x0010;
    L_0x0005:
        r0 = android.os.Build.TAGS;
        r2 = "test-keys";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = 0;
        r2 = f3089f;	 Catch:{ Exception -> 0x0029 }
        r3 = r2.length;	 Catch:{ Exception -> 0x0029 }
        r4 = 0;	 Catch:{ Exception -> 0x0029 }
    L_0x0015:
        if (r4 >= r3) goto L_0x0028;	 Catch:{ Exception -> 0x0029 }
    L_0x0017:
        r5 = r2[r4];	 Catch:{ Exception -> 0x0029 }
        r6 = new java.io.File;	 Catch:{ Exception -> 0x0029 }
        r6.<init>(r5);	 Catch:{ Exception -> 0x0029 }
        r5 = r6.exists();	 Catch:{ Exception -> 0x0029 }
        if (r5 == 0) goto L_0x0025;
    L_0x0024:
        return r1;
    L_0x0025:
        r4 = r4 + 1;
        goto L_0x0015;
    L_0x0028:
        return r0;
    L_0x0029:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.r.f():boolean");
    }

    /* renamed from: g */
    private boolean m3882g() {
        String str = Build.FINGERPRINT;
        if (!(str.startsWith("unknown") || str.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE))) {
            if (!str.contains("vbox")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    private Float m3883h() {
        return this.f3099k != null ? Float.valueOf(this.f3099k.density) : null;
    }

    /* renamed from: i */
    private Integer m3884i() {
        return this.f3099k != null ? Integer.valueOf(this.f3099k.densityDpi) : null;
    }

    /* renamed from: j */
    private String m3885j() {
        if (this.f3099k == null) {
            return null;
        }
        int max = Math.max(this.f3099k.widthPixels, this.f3099k.heightPixels);
        int min = Math.min(this.f3099k.widthPixels, this.f3099k.heightPixels);
        return String.format(Locale.US, "%dx%d", new Object[]{Integer.valueOf(max), Integer.valueOf(min)});
    }

    /* renamed from: e */
    static long m3880e() {
        Runtime runtime = Runtime.getRuntime();
        if (runtime.maxMemory() != Clock.MAX_TIME) {
            return runtime.maxMemory();
        }
        return runtime.totalMemory();
    }

    /* renamed from: k */
    private String m3886k() {
        return Locale.getDefault().toString();
    }

    /* renamed from: l */
    private String m3887l() {
        SharedPreferences sharedPreferences = this.f3095g.f3057j;
        String string = sharedPreferences.getString("install.iud", null);
        if (string != null) {
            return string;
        }
        string = UUID.randomUUID().toString();
        sharedPreferences.edit().putString("install.iud", string).apply();
        return string;
    }

    /* renamed from: m */
    private String[] m3888m() {
        if (VERSION.SDK_INT >= 21) {
            return C1098b.m3879a();
        }
        return C1097a.m3878a();
    }

    /* renamed from: n */
    private java.lang.Long m3889n() {
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
        r7 = this;
        r0 = new android.os.StatFs;	 Catch:{ Exception -> 0x003b }
        r1 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x003b }
        r1 = r1.getPath();	 Catch:{ Exception -> 0x003b }
        r0.<init>(r1);	 Catch:{ Exception -> 0x003b }
        r1 = r0.getBlockSize();	 Catch:{ Exception -> 0x003b }
        r1 = (long) r1;	 Catch:{ Exception -> 0x003b }
        r0 = r0.getBlockCount();	 Catch:{ Exception -> 0x003b }
        r3 = (long) r0;	 Catch:{ Exception -> 0x003b }
        r1 = r1 * r3;	 Catch:{ Exception -> 0x003b }
        r0 = new android.os.StatFs;	 Catch:{ Exception -> 0x003b }
        r3 = android.os.Environment.getDataDirectory();	 Catch:{ Exception -> 0x003b }
        r3 = r3.getPath();	 Catch:{ Exception -> 0x003b }
        r0.<init>(r3);	 Catch:{ Exception -> 0x003b }
        r3 = r0.getBlockSize();	 Catch:{ Exception -> 0x003b }
        r3 = (long) r3;	 Catch:{ Exception -> 0x003b }
        r0 = r0.getBlockCount();	 Catch:{ Exception -> 0x003b }
        r5 = (long) r0;	 Catch:{ Exception -> 0x003b }
        r3 = r3 * r5;	 Catch:{ Exception -> 0x003b }
        r0 = java.lang.Math.min(r3, r1);	 Catch:{ Exception -> 0x003b }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x003b }
        return r0;
    L_0x003b:
        r0 = "Could not get freeDisk";
        com.bugsnag.android.ad.m3736b(r0);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.r.n():java.lang.Long");
    }

    /* renamed from: o */
    private long m3890o() {
        Runtime runtime = Runtime.getRuntime();
        if (runtime.maxMemory() != Clock.MAX_TIME) {
            return (runtime.maxMemory() - runtime.totalMemory()) + runtime.freeMemory();
        }
        return runtime.freeMemory();
    }

    /* renamed from: p */
    private String m3891p() {
        if (this.f3098j != null) {
            switch (this.f3098j.getConfiguration().orientation) {
                case 1:
                    return "portrait";
                case 2:
                    return "landscape";
                default:
                    break;
            }
        }
        return null;
    }

    /* renamed from: q */
    private java.lang.Float m3892q() {
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
        r5 = this;
        r0 = 0;
        r1 = new android.content.IntentFilter;	 Catch:{ Exception -> 0x0023 }
        r2 = "android.intent.action.BATTERY_CHANGED";	 Catch:{ Exception -> 0x0023 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0023 }
        r2 = r5.f3097i;	 Catch:{ Exception -> 0x0023 }
        r1 = r2.registerReceiver(r0, r1);	 Catch:{ Exception -> 0x0023 }
        r2 = "level";	 Catch:{ Exception -> 0x0023 }
        r3 = -1;	 Catch:{ Exception -> 0x0023 }
        r2 = r1.getIntExtra(r2, r3);	 Catch:{ Exception -> 0x0023 }
        r2 = (float) r2;	 Catch:{ Exception -> 0x0023 }
        r4 = "scale";	 Catch:{ Exception -> 0x0023 }
        r1 = r1.getIntExtra(r4, r3);	 Catch:{ Exception -> 0x0023 }
        r1 = (float) r1;	 Catch:{ Exception -> 0x0023 }
        r2 = r2 / r1;	 Catch:{ Exception -> 0x0023 }
        r1 = java.lang.Float.valueOf(r2);	 Catch:{ Exception -> 0x0023 }
        return r1;
    L_0x0023:
        r1 = "Could not get batteryLevel";
        com.bugsnag.android.ad.m3736b(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.r.q():java.lang.Float");
    }

    /* renamed from: r */
    private java.lang.Boolean m3893r() {
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
        r0 = 0;
        r1 = new android.content.IntentFilter;	 Catch:{ Exception -> 0x0024 }
        r2 = "android.intent.action.BATTERY_CHANGED";	 Catch:{ Exception -> 0x0024 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0024 }
        r2 = r4.f3097i;	 Catch:{ Exception -> 0x0024 }
        r1 = r2.registerReceiver(r0, r1);	 Catch:{ Exception -> 0x0024 }
        r2 = "status";	 Catch:{ Exception -> 0x0024 }
        r3 = -1;	 Catch:{ Exception -> 0x0024 }
        r1 = r1.getIntExtra(r2, r3);	 Catch:{ Exception -> 0x0024 }
        r2 = 2;	 Catch:{ Exception -> 0x0024 }
        if (r1 == r2) goto L_0x001e;	 Catch:{ Exception -> 0x0024 }
    L_0x0018:
        r2 = 5;	 Catch:{ Exception -> 0x0024 }
        if (r1 != r2) goto L_0x001c;	 Catch:{ Exception -> 0x0024 }
    L_0x001b:
        goto L_0x001e;	 Catch:{ Exception -> 0x0024 }
    L_0x001c:
        r1 = 0;	 Catch:{ Exception -> 0x0024 }
        goto L_0x001f;	 Catch:{ Exception -> 0x0024 }
    L_0x001e:
        r1 = 1;	 Catch:{ Exception -> 0x0024 }
    L_0x001f:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0024 }
        return r1;
    L_0x0024:
        r1 = "Could not get charging status";
        com.bugsnag.android.ad.m3736b(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.r.r():java.lang.Boolean");
    }

    /* renamed from: s */
    private java.lang.String m3894s() {
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
        r0 = r2.f3097i;	 Catch:{ Exception -> 0x001a }
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x001a }
        r1 = "location_providers_allowed";	 Catch:{ Exception -> 0x001a }
        r0 = android.provider.Settings.Secure.getString(r0, r1);	 Catch:{ Exception -> 0x001a }
        if (r0 == 0) goto L_0x0017;	 Catch:{ Exception -> 0x001a }
    L_0x000e:
        r0 = r0.length();	 Catch:{ Exception -> 0x001a }
        if (r0 <= 0) goto L_0x0017;	 Catch:{ Exception -> 0x001a }
    L_0x0014:
        r0 = "allowed";	 Catch:{ Exception -> 0x001a }
        return r0;	 Catch:{ Exception -> 0x001a }
    L_0x0017:
        r0 = "disallowed";	 Catch:{ Exception -> 0x001a }
        return r0;
    L_0x001a:
        r0 = "Could not get locationStatus";
        com.bugsnag.android.ad.m3736b(r0);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.r.s():java.lang.String");
    }

    /* renamed from: t */
    private java.lang.String m3895t() {
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
        r0 = 0;
        r1 = r4.f3097i;	 Catch:{ Exception -> 0x0035 }
        r2 = "connectivity";	 Catch:{ Exception -> 0x0035 }
        r1 = r1.getSystemService(r2);	 Catch:{ Exception -> 0x0035 }
        r1 = (android.net.ConnectivityManager) r1;	 Catch:{ Exception -> 0x0035 }
        if (r1 != 0) goto L_0x000e;	 Catch:{ Exception -> 0x0035 }
    L_0x000d:
        return r0;	 Catch:{ Exception -> 0x0035 }
    L_0x000e:
        r1 = r1.getActiveNetworkInfo();	 Catch:{ Exception -> 0x0035 }
        if (r1 == 0) goto L_0x0032;	 Catch:{ Exception -> 0x0035 }
    L_0x0014:
        r2 = r1.isConnectedOrConnecting();	 Catch:{ Exception -> 0x0035 }
        if (r2 == 0) goto L_0x0032;	 Catch:{ Exception -> 0x0035 }
    L_0x001a:
        r2 = r1.getType();	 Catch:{ Exception -> 0x0035 }
        r3 = 1;	 Catch:{ Exception -> 0x0035 }
        if (r2 != r3) goto L_0x0024;	 Catch:{ Exception -> 0x0035 }
    L_0x0021:
        r1 = "wifi";	 Catch:{ Exception -> 0x0035 }
        return r1;	 Catch:{ Exception -> 0x0035 }
    L_0x0024:
        r1 = r1.getType();	 Catch:{ Exception -> 0x0035 }
        r2 = 9;	 Catch:{ Exception -> 0x0035 }
        if (r1 != r2) goto L_0x002f;	 Catch:{ Exception -> 0x0035 }
    L_0x002c:
        r1 = "ethernet";	 Catch:{ Exception -> 0x0035 }
        return r1;	 Catch:{ Exception -> 0x0035 }
    L_0x002f:
        r1 = "cellular";	 Catch:{ Exception -> 0x0035 }
        return r1;	 Catch:{ Exception -> 0x0035 }
    L_0x0032:
        r1 = "none";	 Catch:{ Exception -> 0x0035 }
        return r1;
    L_0x0035:
        r1 = "Could not get network access information, we recommend granting the 'android.permission.ACCESS_NETWORK_STATE' permission";
        com.bugsnag.android.ad.m3736b(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.r.t():java.lang.String");
    }

    /* renamed from: u */
    private String m3896u() {
        return C1093m.m3874a(new Date());
    }
}
