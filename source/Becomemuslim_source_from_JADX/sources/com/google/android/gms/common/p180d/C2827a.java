package com.google.android.gms.common.p180d;

import android.content.Context;

/* renamed from: com.google.android.gms.common.d.a */
public class C2827a {
    /* renamed from: a */
    private static Context f7227a;
    /* renamed from: b */
    private static Boolean f7228b;

    /* renamed from: a */
    public static synchronized boolean m8121a(android.content.Context r3) {
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
        r0 = com.google.android.gms.common.p180d.C2827a.class;
        monitor-enter(r0);
        r1 = r3.getApplicationContext();	 Catch:{ all -> 0x0055 }
        r2 = f7227a;	 Catch:{ all -> 0x0055 }
        if (r2 == 0) goto L_0x001b;	 Catch:{ all -> 0x0055 }
    L_0x000b:
        r2 = f7228b;	 Catch:{ all -> 0x0055 }
        if (r2 == 0) goto L_0x001b;	 Catch:{ all -> 0x0055 }
    L_0x000f:
        r2 = f7227a;	 Catch:{ all -> 0x0055 }
        if (r2 != r1) goto L_0x001b;	 Catch:{ all -> 0x0055 }
    L_0x0013:
        r3 = f7228b;	 Catch:{ all -> 0x0055 }
        r3 = r3.booleanValue();	 Catch:{ all -> 0x0055 }
        monitor-exit(r0);
        return r3;
    L_0x001b:
        r2 = 0;
        f7228b = r2;	 Catch:{ all -> 0x0055 }
        r2 = com.google.android.gms.common.util.C2904o.m8466l();	 Catch:{ all -> 0x0055 }
        if (r2 == 0) goto L_0x0033;	 Catch:{ all -> 0x0055 }
    L_0x0024:
        r3 = r1.getPackageManager();	 Catch:{ all -> 0x0055 }
        r3 = r3.isInstantApp();	 Catch:{ all -> 0x0055 }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x0055 }
        f7228b = r3;	 Catch:{ all -> 0x0055 }
        goto L_0x004b;
    L_0x0033:
        r3 = r3.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0044 }
        r2 = "com.google.android.instantapps.supervisor.InstantAppsRuntime";	 Catch:{ ClassNotFoundException -> 0x0044 }
        r3.loadClass(r2);	 Catch:{ ClassNotFoundException -> 0x0044 }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x0044 }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ ClassNotFoundException -> 0x0044 }
        f7228b = r3;	 Catch:{ ClassNotFoundException -> 0x0044 }
        goto L_0x004b;
    L_0x0044:
        r3 = 0;
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x0055 }
        f7228b = r3;	 Catch:{ all -> 0x0055 }
    L_0x004b:
        f7227a = r1;	 Catch:{ all -> 0x0055 }
        r3 = f7228b;	 Catch:{ all -> 0x0055 }
        r3 = r3.booleanValue();	 Catch:{ all -> 0x0055 }
        monitor-exit(r0);
        return r3;
    L_0x0055:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.d.a.a(android.content.Context):boolean");
    }
}
