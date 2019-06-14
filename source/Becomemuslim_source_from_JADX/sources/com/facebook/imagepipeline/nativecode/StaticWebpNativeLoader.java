package com.facebook.imagepipeline.nativecode;

public class StaticWebpNativeLoader {
    private static boolean sInitialized;

    public static synchronized void ensure() {
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
        r0 = com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader.class;
        monitor-enter(r0);
        r1 = sInitialized;	 Catch:{ all -> 0x001c }
        if (r1 != 0) goto L_0x001a;	 Catch:{ all -> 0x001c }
    L_0x0007:
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x001c }
        r2 = 16;
        if (r1 > r2) goto L_0x0012;
    L_0x000d:
        r1 = "fb_jpegturbo";	 Catch:{ UnsatisfiedLinkError -> 0x0012 }
        com.facebook.soloader.SoLoader.loadLibrary(r1);	 Catch:{ UnsatisfiedLinkError -> 0x0012 }
    L_0x0012:
        r1 = "static-webp";	 Catch:{ all -> 0x001c }
        com.facebook.soloader.SoLoader.loadLibrary(r1);	 Catch:{ all -> 0x001c }
        r1 = 1;	 Catch:{ all -> 0x001c }
        sInitialized = r1;	 Catch:{ all -> 0x001c }
    L_0x001a:
        monitor-exit(r0);
        return;
    L_0x001c:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader.ensure():void");
    }
}
