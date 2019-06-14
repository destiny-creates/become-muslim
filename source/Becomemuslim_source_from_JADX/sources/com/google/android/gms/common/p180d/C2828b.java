package com.google.android.gms.common.p180d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.C2904o;

/* renamed from: com.google.android.gms.common.d.b */
public class C2828b {
    /* renamed from: a */
    private final Context f7229a;

    public C2828b(Context context) {
        this.f7229a = context;
    }

    /* renamed from: a */
    public ApplicationInfo m8124a(String str, int i) {
        return this.f7229a.getPackageManager().getApplicationInfo(str, i);
    }

    /* renamed from: b */
    public PackageInfo m8129b(String str, int i) {
        return this.f7229a.getPackageManager().getPackageInfo(str, i);
    }

    /* renamed from: a */
    public final PackageInfo m8125a(String str, int i, int i2) {
        return this.f7229a.getPackageManager().getPackageInfo(str, 64);
    }

    /* renamed from: a */
    public final String[] m8128a(int i) {
        return this.f7229a.getPackageManager().getPackagesForUid(i);
    }

    @android.annotation.TargetApi(19)
    /* renamed from: a */
    public final boolean m8127a(int r5, java.lang.String r6) {
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
        r4 = this;
        r0 = com.google.android.gms.common.util.C2904o.m8461g();
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0017;
    L_0x0008:
        r0 = r4.f7229a;	 Catch:{ SecurityException -> 0x0016 }
        r3 = "appops";	 Catch:{ SecurityException -> 0x0016 }
        r0 = r0.getSystemService(r3);	 Catch:{ SecurityException -> 0x0016 }
        r0 = (android.app.AppOpsManager) r0;	 Catch:{ SecurityException -> 0x0016 }
        r0.checkPackage(r5, r6);	 Catch:{ SecurityException -> 0x0016 }
        return r1;
    L_0x0016:
        return r2;
    L_0x0017:
        r0 = r4.f7229a;
        r0 = r0.getPackageManager();
        r5 = r0.getPackagesForUid(r5);
        if (r6 == 0) goto L_0x0035;
    L_0x0023:
        if (r5 == 0) goto L_0x0035;
    L_0x0025:
        r0 = 0;
    L_0x0026:
        r3 = r5.length;
        if (r0 >= r3) goto L_0x0035;
    L_0x0029:
        r3 = r5[r0];
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x0032;
    L_0x0031:
        return r1;
    L_0x0032:
        r0 = r0 + 1;
        goto L_0x0026;
    L_0x0035:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.d.b.a(int, java.lang.String):boolean");
    }

    /* renamed from: a */
    public int m8122a(String str) {
        return this.f7229a.checkCallingOrSelfPermission(str);
    }

    /* renamed from: a */
    public int m8123a(String str, String str2) {
        return this.f7229a.getPackageManager().checkPermission(str, str2);
    }

    /* renamed from: b */
    public CharSequence m8130b(String str) {
        return this.f7229a.getPackageManager().getApplicationLabel(this.f7229a.getPackageManager().getApplicationInfo(str, 0));
    }

    /* renamed from: a */
    public boolean m8126a() {
        if (Binder.getCallingUid() == Process.myUid()) {
            return C2827a.m8121a(this.f7229a);
        }
        if (C2904o.m8466l()) {
            String nameForUid = this.f7229a.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (nameForUid != null) {
                return this.f7229a.getPackageManager().isInstantApp(nameForUid);
            }
        }
        return false;
    }
}
