package com.google.android.gms.common.util;

import android.content.Context;

/* renamed from: com.google.android.gms.common.util.d */
public class C2894d {
    /* renamed from: a */
    public static boolean m8424a() {
        return false;
    }

    /* renamed from: a */
    public static int m8423a(Context context, String str) {
        context = C2894d.m8426c(context, str);
        if (context != null) {
            if (context.applicationInfo != null) {
                context = context.applicationInfo.metaData;
                if (context == null) {
                    return -1;
                }
                return context.getInt("com.google.android.gms.version", -1);
            }
        }
        return -1;
    }

    /* renamed from: c */
    private static android.content.pm.PackageInfo m8426c(android.content.Context r1, java.lang.String r2) {
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
        r1 = com.google.android.gms.common.p180d.C2829c.m8131a(r1);	 Catch:{ NameNotFoundException -> 0x000b }
        r0 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x000b }
        r1 = r1.m8129b(r2, r0);	 Catch:{ NameNotFoundException -> 0x000b }
        return r1;
    L_0x000b:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.d.c(android.content.Context, java.lang.String):android.content.pm.PackageInfo");
    }

    /* renamed from: b */
    public static boolean m8425b(android.content.Context r1, java.lang.String r2) {
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
        r0 = "com.google.android.gms";
        r0.equals(r2);
        r0 = 0;
        r1 = com.google.android.gms.common.p180d.C2829c.m8131a(r1);	 Catch:{ NameNotFoundException -> 0x0018 }
        r1 = r1.m8124a(r2, r0);	 Catch:{ NameNotFoundException -> 0x0018 }
        r1 = r1.flags;	 Catch:{ NameNotFoundException -> 0x0018 }
        r2 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        r1 = r1 & r2;
        if (r1 == 0) goto L_0x0017;
    L_0x0015:
        r1 = 1;
        return r1;
    L_0x0017:
        return r0;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.d.b(android.content.Context, java.lang.String):boolean");
    }
}
