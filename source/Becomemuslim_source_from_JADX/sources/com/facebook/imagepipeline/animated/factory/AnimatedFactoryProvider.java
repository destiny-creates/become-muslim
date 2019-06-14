package com.facebook.imagepipeline.animated.factory;

public class AnimatedFactoryProvider {
    private static AnimatedFactory sImpl;
    private static boolean sImplLoaded;

    public static com.facebook.imagepipeline.animated.factory.AnimatedFactory getAnimatedFactory(com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r7, com.facebook.imagepipeline.core.ExecutorSupplier r8, com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> r9) {
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
        r0 = sImplLoaded;
        if (r0 != 0) goto L_0x0036;
    L_0x0004:
        r0 = 1;
        r1 = "com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl";	 Catch:{ Throwable -> 0x0030 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0030 }
        r2 = 3;	 Catch:{ Throwable -> 0x0030 }
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0030 }
        r4 = com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.class;	 Catch:{ Throwable -> 0x0030 }
        r5 = 0;	 Catch:{ Throwable -> 0x0030 }
        r3[r5] = r4;	 Catch:{ Throwable -> 0x0030 }
        r4 = com.facebook.imagepipeline.core.ExecutorSupplier.class;	 Catch:{ Throwable -> 0x0030 }
        r3[r0] = r4;	 Catch:{ Throwable -> 0x0030 }
        r4 = com.facebook.imagepipeline.cache.CountingMemoryCache.class;	 Catch:{ Throwable -> 0x0030 }
        r6 = 2;	 Catch:{ Throwable -> 0x0030 }
        r3[r6] = r4;	 Catch:{ Throwable -> 0x0030 }
        r1 = r1.getConstructor(r3);	 Catch:{ Throwable -> 0x0030 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0030 }
        r2[r5] = r7;	 Catch:{ Throwable -> 0x0030 }
        r2[r0] = r8;	 Catch:{ Throwable -> 0x0030 }
        r2[r6] = r9;	 Catch:{ Throwable -> 0x0030 }
        r7 = r1.newInstance(r2);	 Catch:{ Throwable -> 0x0030 }
        r7 = (com.facebook.imagepipeline.animated.factory.AnimatedFactory) r7;	 Catch:{ Throwable -> 0x0030 }
        sImpl = r7;	 Catch:{ Throwable -> 0x0030 }
    L_0x0030:
        r7 = sImpl;
        if (r7 == 0) goto L_0x0036;
    L_0x0034:
        sImplLoaded = r0;
    L_0x0036:
        r7 = sImpl;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider.getAnimatedFactory(com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory, com.facebook.imagepipeline.core.ExecutorSupplier, com.facebook.imagepipeline.cache.CountingMemoryCache):com.facebook.imagepipeline.animated.factory.AnimatedFactory");
    }
}
