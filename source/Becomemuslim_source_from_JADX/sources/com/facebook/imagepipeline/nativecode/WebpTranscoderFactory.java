package com.facebook.imagepipeline.nativecode;

public class WebpTranscoderFactory {
    private static WebpTranscoder sWebpTranscoder = null;
    public static boolean sWebpTranscoderPresent = false;

    static {
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
        r0 = "com.facebook.imagepipeline.nativecode.WebpTranscoderImpl";	 Catch:{ Throwable -> 0x0012 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0012 }
        r0 = r0.newInstance();	 Catch:{ Throwable -> 0x0012 }
        r0 = (com.facebook.imagepipeline.nativecode.WebpTranscoder) r0;	 Catch:{ Throwable -> 0x0012 }
        sWebpTranscoder = r0;	 Catch:{ Throwable -> 0x0012 }
        r0 = 1;	 Catch:{ Throwable -> 0x0012 }
        sWebpTranscoderPresent = r0;	 Catch:{ Throwable -> 0x0012 }
        goto L_0x0015;
    L_0x0012:
        r0 = 0;
        sWebpTranscoderPresent = r0;
    L_0x0015:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.nativecode.WebpTranscoderFactory.<clinit>():void");
    }

    public static WebpTranscoder getWebpTranscoder() {
        return sWebpTranscoder;
    }
}
