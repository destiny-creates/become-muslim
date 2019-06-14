package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.dv */
final class dv {
    /* renamed from: a */
    private static final Class<?> f16511a = dv.m20446a("libcore.io.Memory");
    /* renamed from: b */
    private static final boolean f16512b = (dv.m20446a("org.robolectric.Robolectric") != null);

    /* renamed from: a */
    static boolean m20447a() {
        return (f16511a == null || f16512b) ? false : true;
    }

    /* renamed from: b */
    static Class<?> m20448b() {
        return f16511a;
    }

    /* renamed from: a */
    private static <T> java.lang.Class<T> m20446a(java.lang.String r0) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.dv.a(java.lang.String):java.lang.Class<T>");
    }
}
