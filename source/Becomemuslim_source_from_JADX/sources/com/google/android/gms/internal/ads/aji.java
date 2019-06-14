package com.google.android.gms.internal.ads;

import com.facebook.stetho.common.Utf8Charset;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

public class aji {
    /* renamed from: a */
    private static final String f14587a = "aji";
    /* renamed from: b */
    private final ahz f14588b;
    /* renamed from: c */
    private final String f14589c;
    /* renamed from: d */
    private final String f14590d;
    /* renamed from: e */
    private final int f14591e = 2;
    /* renamed from: f */
    private volatile Method f14592f = null;
    /* renamed from: g */
    private final Class<?>[] f14593g;
    /* renamed from: h */
    private CountDownLatch f14594h = new CountDownLatch(1);

    public aji(ahz ahz, String str, String str2, Class<?>... clsArr) {
        this.f14588b = ahz;
        this.f14589c = str;
        this.f14590d = str2;
        this.f14593g = clsArr;
        this.f14588b.m18460c().submit(new ajj(this));
    }

    /* renamed from: a */
    private final String m18493a(byte[] bArr, String str) {
        return new String(this.f14588b.m18462e().m18439a(bArr, str), Utf8Charset.NAME);
    }

    /* renamed from: b */
    private final void m18495b() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = r3.f14588b;	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r0 = r0.m18461d();	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r1 = r3.f14588b;	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r1 = r1.m18463f();	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r2 = r3.f14589c;	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r1 = r3.m18493a(r1, r2);	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r0 = r0.loadClass(r1);	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        if (r0 != 0) goto L_0x001e;
    L_0x0018:
        r0 = r3.f14594h;
        r0.countDown();
        return;
    L_0x001e:
        r1 = r3.f14588b;	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r1 = r1.m18463f();	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r2 = r3.f14590d;	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r1 = r3.m18493a(r1, r2);	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r2 = r3.f14593g;	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r0 = r0.getMethod(r1, r2);	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r3.f14592f = r0;	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        r0 = r3.f14592f;	 Catch:{ ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, ahl -> 0x0018, all -> 0x0035 }
        goto L_0x0018;
    L_0x0035:
        r0 = move-exception;
        r1 = r3.f14594h;
        r1.countDown();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aji.b():void");
    }

    /* renamed from: a */
    public final java.lang.reflect.Method m18496a() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = r5.f14592f;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0 = r5.f14592f;
        return r0;
    L_0x0007:
        r0 = 0;
        r1 = r5.f14594h;	 Catch:{ InterruptedException -> 0x0018 }
        r2 = 2;	 Catch:{ InterruptedException -> 0x0018 }
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0018 }
        r1 = r1.await(r2, r4);	 Catch:{ InterruptedException -> 0x0018 }
        if (r1 != 0) goto L_0x0015;	 Catch:{ InterruptedException -> 0x0018 }
    L_0x0014:
        return r0;	 Catch:{ InterruptedException -> 0x0018 }
    L_0x0015:
        r1 = r5.f14592f;	 Catch:{ InterruptedException -> 0x0018 }
        return r1;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aji.a():java.lang.reflect.Method");
    }
}
