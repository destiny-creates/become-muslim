package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.util.C2898i;

/* renamed from: com.google.android.gms.common.f */
public class C2830f {
    /* renamed from: a */
    private static final C2830f f7232a = new C2830f();
    /* renamed from: b */
    public static final int f7233b = C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    /* renamed from: b */
    public static C2830f m8133b() {
        return f7232a;
    }

    C2830f() {
    }

    /* renamed from: a */
    public int mo2455a(Context context) {
        return mo2459b(context, f7233b);
    }

    /* renamed from: b */
    public int mo2459b(Context context, int i) {
        i = C2832i.isGooglePlayServicesAvailable(context, i);
        return C2832i.isPlayServicesPossiblyUpdating(context, i) != null ? 18 : i;
    }

    /* renamed from: a */
    public boolean mo2458a(int i) {
        return C2832i.isUserRecoverableError(i);
    }

    @Deprecated
    /* renamed from: c */
    public Intent m8143c(int i) {
        return mo2457a(null, i, null);
    }

    /* renamed from: a */
    public Intent mo2457a(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                if (context == null || C2898i.m8443b(context) == 0) {
                    return av.m8229a("com.google.android.gms", C2830f.m8134b(context, str));
                }
                return av.m8227a();
            case 3:
                return av.m8228a("com.google.android.gms");
            default:
                return null;
        }
    }

    /* renamed from: a */
    public PendingIntent mo2456a(Context context, int i, int i2) {
        return m8137a(context, i, i2, null);
    }

    /* renamed from: a */
    public PendingIntent m8137a(Context context, int i, int i2, String str) {
        i = mo2457a(context, i, str);
        if (i == 0) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, i, 134217728);
    }

    /* renamed from: c */
    public void m8144c(Context context) {
        C2832i.cancelAvailabilityErrorNotifications(context);
    }

    /* renamed from: d */
    public int m8146d(Context context) {
        return C2832i.getApkVersion(context);
    }

    /* renamed from: c */
    public boolean m8145c(Context context, int i) {
        return C2832i.isPlayServicesPossiblyUpdating(context, i);
    }

    /* renamed from: a */
    public boolean m8140a(Context context, String str) {
        return C2832i.isUninstalledAppPossiblyUpdating(context, str);
    }

    /* renamed from: b */
    public String mo2460b(int i) {
        return C2832i.getErrorString(i);
    }

    /* renamed from: b */
    private static java.lang.String m8134b(android.content.Context r2, java.lang.String r3) {
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
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "gcore_";
        r0.append(r1);
        r1 = f7233b;
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r1 = android.text.TextUtils.isEmpty(r3);
        if (r1 != 0) goto L_0x001d;
    L_0x001a:
        r0.append(r3);
    L_0x001d:
        r3 = "-";
        r0.append(r3);
        if (r2 == 0) goto L_0x002b;
    L_0x0024:
        r3 = r2.getPackageName();
        r0.append(r3);
    L_0x002b:
        r3 = "-";
        r0.append(r3);
        if (r2 == 0) goto L_0x0044;
    L_0x0032:
        r3 = com.google.android.gms.common.p180d.C2829c.m8131a(r2);	 Catch:{ NameNotFoundException -> 0x0044 }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0044 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0044 }
        r2 = r3.m8129b(r2, r1);	 Catch:{ NameNotFoundException -> 0x0044 }
        r2 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x0044 }
        r0.append(r2);	 Catch:{ NameNotFoundException -> 0x0044 }
    L_0x0044:
        r2 = r0.toString();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.f.b(android.content.Context, java.lang.String):java.lang.String");
    }
}
