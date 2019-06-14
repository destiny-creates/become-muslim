package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import java.util.Random;

public class ahc {
    /* renamed from: a */
    protected static volatile anc f14513a = null;
    /* renamed from: d */
    private static final ConditionVariable f14514d = new ConditionVariable();
    /* renamed from: e */
    private static volatile Random f14515e = null;
    /* renamed from: b */
    protected volatile Boolean f14516b;
    /* renamed from: c */
    private ahz f14517c;

    public ahc(ahz ahz) {
        this.f14517c = ahz;
        ahz.m18460c().execute(new ahd(this));
    }

    /* renamed from: a */
    public static int m18417a() {
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
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ RuntimeException -> 0x0018 }
        r1 = 21;	 Catch:{ RuntimeException -> 0x0018 }
        if (r0 < r1) goto L_0x000f;	 Catch:{ RuntimeException -> 0x0018 }
    L_0x0006:
        r0 = java.util.concurrent.ThreadLocalRandom.current();	 Catch:{ RuntimeException -> 0x0018 }
        r0 = r0.nextInt();	 Catch:{ RuntimeException -> 0x0018 }
        return r0;	 Catch:{ RuntimeException -> 0x0018 }
    L_0x000f:
        r0 = m18420c();	 Catch:{ RuntimeException -> 0x0018 }
        r0 = r0.nextInt();	 Catch:{ RuntimeException -> 0x0018 }
        return r0;
    L_0x0018:
        r0 = m18420c();
        r0 = r0.nextInt();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahc.a():int");
    }

    /* renamed from: c */
    private static Random m18420c() {
        if (f14515e == null) {
            synchronized (ahc.class) {
                if (f14515e == null) {
                    f14515e = new Random();
                }
            }
        }
        return f14515e;
    }

    /* renamed from: a */
    public final void m18421a(int r3, int r4, long r5) {
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
        r0 = f14514d;	 Catch:{ Exception -> 0x0039 }
        r0.block();	 Catch:{ Exception -> 0x0039 }
        r0 = r2.f14516b;	 Catch:{ Exception -> 0x0039 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0039 }
        if (r0 == 0) goto L_0x0039;	 Catch:{ Exception -> 0x0039 }
    L_0x000d:
        r0 = f14513a;	 Catch:{ Exception -> 0x0039 }
        if (r0 == 0) goto L_0x0039;	 Catch:{ Exception -> 0x0039 }
    L_0x0011:
        r0 = new com.google.android.gms.internal.ads.vv;	 Catch:{ Exception -> 0x0039 }
        r0.<init>();	 Catch:{ Exception -> 0x0039 }
        r1 = r2.f14517c;	 Catch:{ Exception -> 0x0039 }
        r1 = r1.f14534a;	 Catch:{ Exception -> 0x0039 }
        r1 = r1.getPackageName();	 Catch:{ Exception -> 0x0039 }
        r0.f28763a = r1;	 Catch:{ Exception -> 0x0039 }
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ Exception -> 0x0039 }
        r0.f28764b = r5;	 Catch:{ Exception -> 0x0039 }
        r5 = f14513a;	 Catch:{ Exception -> 0x0039 }
        r6 = com.google.android.gms.internal.ads.afo.m18388a(r0);	 Catch:{ Exception -> 0x0039 }
        r5 = r5.m18652a(r6);	 Catch:{ Exception -> 0x0039 }
        r5.m18653a(r4);	 Catch:{ Exception -> 0x0039 }
        r5.m18655b(r3);	 Catch:{ Exception -> 0x0039 }
        r5.m18654a();	 Catch:{ Exception -> 0x0039 }
    L_0x0039:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahc.a(int, int, long):void");
    }
}
