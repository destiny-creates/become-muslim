package com.google.android.gms.internal.ads;

final class aad {
    /* renamed from: a */
    private static final Class<?> f14127a = m17812a("libcore.io.Memory");
    /* renamed from: b */
    private static final boolean f14128b = (m17812a("org.robolectric.Robolectric") != null);

    /* renamed from: a */
    private static <T> java.lang.Class<T> m17812a(java.lang.String r0) {
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
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aad.a(java.lang.String):java.lang.Class<T>");
    }

    /* renamed from: a */
    static boolean m17813a() {
        return (f14127a == null || f14128b) ? false : true;
    }

    /* renamed from: b */
    static Class<?> m17814b() {
        return f14127a;
    }
}
