package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class ajk implements Callable {
    /* renamed from: a */
    protected final ahz f14596a;
    /* renamed from: b */
    protected final aaa f14597b;
    /* renamed from: c */
    protected Method f14598c;
    /* renamed from: d */
    private final String f14599d = getClass().getSimpleName();
    /* renamed from: e */
    private final String f14600e;
    /* renamed from: f */
    private final String f14601f;
    /* renamed from: g */
    private final int f14602g;
    /* renamed from: h */
    private final int f14603h;

    public ajk(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        this.f14596a = ahz;
        this.f14600e = str;
        this.f14601f = str2;
        this.f14597b = aaa;
        this.f14602g = i;
        this.f14603h = i2;
    }

    /* renamed from: a */
    protected abstract void mo3820a();

    /* renamed from: b */
    public java.lang.Void mo3821b() {
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
        r9 = this;
        r0 = 0;
        r1 = java.lang.System.nanoTime();	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r3 = r9.f14596a;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r4 = r9.f14600e;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r5 = r9.f14601f;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r3 = r3.m18455a(r4, r5);	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r9.f14598c = r3;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r3 = r9.f14598c;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        if (r3 != 0) goto L_0x0016;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
    L_0x0015:
        return r0;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
    L_0x0016:
        r9.mo3820a();	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r3 = r9.f14596a;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r3 = r3.m18465h();	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        if (r3 == 0) goto L_0x0037;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
    L_0x0021:
        r4 = r9.f14602g;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r5 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        if (r4 == r5) goto L_0x0037;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
    L_0x0027:
        r4 = r9.f14603h;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r5 = r9.f14602g;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r6 = java.lang.System.nanoTime();	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r8 = 0;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r6 = r6 - r1;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r6 = r6 / r1;	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
        r3.m18421a(r4, r5, r6);	 Catch:{ IllegalAccessException -> 0x0037, IllegalAccessException -> 0x0037 }
    L_0x0037:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ajk.b():java.lang.Void");
    }

    public /* synthetic */ Object call() {
        return mo3821b();
    }
}
