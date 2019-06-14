package com.google.android.gms.internal.ads;

import java.lang.Thread.UncaughtExceptionHandler;

final class ch implements UncaughtExceptionHandler {
    /* renamed from: a */
    private final /* synthetic */ UncaughtExceptionHandler f15266a;
    /* renamed from: b */
    private final /* synthetic */ cg f15267b;

    ch(cg cgVar, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f15267b = cgVar;
        this.f15266a = uncaughtExceptionHandler;
    }

    public final void uncaughtException(java.lang.Thread r3, java.lang.Throwable r4) {
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
        r0 = r2.f15267b;	 Catch:{ Throwable -> 0x0011 }
        r0.m30675a(r3, r4);	 Catch:{ Throwable -> 0x0011 }
        r0 = r2.f15266a;
        if (r0 == 0) goto L_0x001b;
    L_0x0009:
        r0 = r2.f15266a;
        r0.uncaughtException(r3, r4);
        return;
    L_0x000f:
        r0 = move-exception;
        goto L_0x001c;
    L_0x0011:
        r0 = "AdMob exception reporter failed reporting the exception.";	 Catch:{ all -> 0x000f }
        com.google.android.gms.internal.ads.mt.m19920c(r0);	 Catch:{ all -> 0x000f }
        r0 = r2.f15266a;
        if (r0 == 0) goto L_0x001b;
    L_0x001a:
        goto L_0x0009;
    L_0x001b:
        return;
    L_0x001c:
        r1 = r2.f15266a;
        if (r1 == 0) goto L_0x0025;
    L_0x0020:
        r1 = r2.f15266a;
        r1.uncaughtException(r3, r4);
    L_0x0025:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ch.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
