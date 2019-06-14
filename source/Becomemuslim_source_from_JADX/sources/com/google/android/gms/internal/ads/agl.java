package com.google.android.gms.internal.ads;

final class agl implements Runnable {
    private agl() {
    }

    public final void run() {
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
        r0 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x0009, all -> 0x000f }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0009, all -> 0x000f }
        com.google.android.gms.internal.ads.agj.m18409a(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0009, all -> 0x000f }
    L_0x0009:
        r0 = com.google.android.gms.internal.ads.agj.f14448a;
        r0.countDown();
        return;
    L_0x000f:
        r0 = move-exception;
        r1 = com.google.android.gms.internal.ads.agj.f14448a;
        r1.countDown();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agl.run():void");
    }
}
