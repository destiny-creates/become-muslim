package com.facebook.ads.internal.p092g;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.facebook.ads.internal.p105q.p106a.C1499e;
import com.facebook.places.model.PlaceFields;

/* renamed from: com.facebook.ads.internal.g.b */
public class C1385b {
    /* renamed from: a */
    public static final String f4027a = VERSION.RELEASE;
    /* renamed from: b */
    private final Context f4028b;

    public C1385b(Context context) {
        this.f4028b = context.getApplicationContext();
    }

    /* renamed from: a */
    public String m4743a() {
        return (Build.MANUFACTURER == null || Build.MANUFACTURER.length() <= 0) ? "" : Build.MANUFACTURER;
    }

    /* renamed from: b */
    public String m4744b() {
        return (Build.MODEL == null || Build.MODEL.length() <= 0) ? "" : Build.MODEL;
    }

    /* renamed from: c */
    public String m4745c() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f4028b.getSystemService(PlaceFields.PHONE);
        if (telephonyManager != null) {
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (networkOperatorName != null && networkOperatorName.length() > 0) {
                return networkOperatorName;
            }
        }
        return "";
    }

    /* renamed from: d */
    public java.lang.String m4746d() {
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
        r3 = this;
        r0 = r3.f4028b;	 Catch:{ NameNotFoundException -> 0x0026 }
        r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0026 }
        r1 = r3.m4748f();	 Catch:{ NameNotFoundException -> 0x0026 }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x0026 }
        r0 = r0.getApplicationInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0026 }
        r1 = r3.f4028b;	 Catch:{ NameNotFoundException -> 0x0026 }
        r1 = r1.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0026 }
        r0 = r1.getApplicationLabel(r0);	 Catch:{ NameNotFoundException -> 0x0026 }
        if (r0 == 0) goto L_0x0026;	 Catch:{ NameNotFoundException -> 0x0026 }
    L_0x001b:
        r1 = r0.length();	 Catch:{ NameNotFoundException -> 0x0026 }
        if (r1 <= 0) goto L_0x0026;	 Catch:{ NameNotFoundException -> 0x0026 }
    L_0x0021:
        r0 = r0.toString();	 Catch:{ NameNotFoundException -> 0x0026 }
        return r0;
    L_0x0026:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.g.b.d():java.lang.String");
    }

    /* renamed from: e */
    public java.lang.String m4747e() {
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
        r0 = r2.m4748f();	 Catch:{ Exception -> 0x001f }
        if (r0 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x001f }
    L_0x0006:
        r1 = r0.length();	 Catch:{ Exception -> 0x001f }
        if (r1 < 0) goto L_0x001f;	 Catch:{ Exception -> 0x001f }
    L_0x000c:
        r1 = r2.f4028b;	 Catch:{ Exception -> 0x001f }
        r1 = r1.getPackageManager();	 Catch:{ Exception -> 0x001f }
        r0 = r1.getInstallerPackageName(r0);	 Catch:{ Exception -> 0x001f }
        if (r0 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x001f }
    L_0x0018:
        r1 = r0.length();	 Catch:{ Exception -> 0x001f }
        if (r1 <= 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.g.b.e():java.lang.String");
    }

    /* renamed from: f */
    public String m4748f() {
        PendingIntent activity = PendingIntent.getActivity(this.f4028b, 0, new Intent(), 0);
        return VERSION.SDK_INT >= 17 ? activity.getCreatorPackage() : activity.getTargetPackage();
    }

    /* renamed from: g */
    public String m4749g() {
        try {
            return this.f4028b.getPackageManager().getPackageInfo(m4748f(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: h */
    public int m4750h() {
        try {
            return this.f4028b.getPackageManager().getPackageInfo(m4748f(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: i */
    public boolean m4751i() {
        return this.f4028b.checkCallingOrSelfPermission("android.permission.BIND_ACCESSIBILITY_SERVICE") == 0;
    }

    /* renamed from: j */
    public int m4752j() {
        return C1499e.m5276b(this.f4028b);
    }
}
