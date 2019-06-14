package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.C2850d.C2844a;
import com.google.android.gms.common.internal.C2850d.C2845b;
import java.util.concurrent.LinkedBlockingQueue;

final class tk implements C2844a, C2845b {
    /* renamed from: a */
    private tl f24322a;
    /* renamed from: b */
    private final String f24323b;
    /* renamed from: c */
    private final String f24324c;
    /* renamed from: d */
    private final LinkedBlockingQueue<aaa> f24325d;
    /* renamed from: e */
    private final HandlerThread f24326e = new HandlerThread("GassClient");

    public tk(Context context, String str, String str2) {
        this.f24323b = str;
        this.f24324c = str2;
        this.f24326e.start();
        this.f24322a = new tl(context, this.f24326e.getLooper(), this, this);
        this.f24325d = new LinkedBlockingQueue();
        this.f24322a.q();
    }

    /* renamed from: a */
    private final com.google.android.gms.internal.ads.tq m31119a() {
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
        r1 = this;
        r0 = r1.f24322a;	 Catch:{ IllegalStateException -> 0x0007, IllegalStateException -> 0x0007 }
        r0 = r0.m31128e();	 Catch:{ IllegalStateException -> 0x0007, IllegalStateException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.tk.a():com.google.android.gms.internal.ads.tq");
    }

    /* renamed from: b */
    private final void m31120b() {
        if (this.f24322a == null) {
            return;
        }
        if (this.f24322a.h() || this.f24322a.i()) {
            this.f24322a.g();
        }
    }

    /* renamed from: c */
    private static aaa m31121c() {
        aaa aaa = new aaa();
        aaa.f27962k = Long.valueOf(32768);
        return aaa;
    }

    /* renamed from: a */
    public final void m31122a(int r2) {
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
        r1 = this;
        r2 = r1.f24325d;	 Catch:{ InterruptedException -> 0x0009 }
        r0 = m31121c();	 Catch:{ InterruptedException -> 0x0009 }
        r2.put(r0);	 Catch:{ InterruptedException -> 0x0009 }
    L_0x0009:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.tk.a(int):void");
    }

    /* renamed from: a */
    public final void m31123a(android.os.Bundle r4) {
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
        r4 = r3.m31119a();
        if (r4 == 0) goto L_0x003a;
    L_0x0006:
        r0 = new com.google.android.gms.internal.ads.tm;	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r1 = r3.f24323b;	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r2 = r3.f24324c;	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r4 = r4.mo4377a(r0);	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r4 = r4.m37662a();	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r0 = r3.f24325d;	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        r0.put(r4);	 Catch:{ Throwable -> 0x0027, all -> 0x0025 }
    L_0x001c:
        r3.m31120b();
        r4 = r3.f24326e;
        r4.quit();
        return;
    L_0x0025:
        r4 = move-exception;
        goto L_0x0031;
    L_0x0027:
        r4 = r3.f24325d;	 Catch:{ InterruptedException -> 0x001c, all -> 0x0025 }
        r0 = m31121c();	 Catch:{ InterruptedException -> 0x001c, all -> 0x0025 }
        r4.put(r0);	 Catch:{ InterruptedException -> 0x001c, all -> 0x0025 }
        goto L_0x001c;
    L_0x0031:
        r3.m31120b();
        r0 = r3.f24326e;
        r0.quit();
        throw r4;
    L_0x003a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.tk.a(android.os.Bundle):void");
    }

    /* renamed from: a */
    public final void m31124a(com.google.android.gms.common.C4775b r2) {
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
        r1 = this;
        r2 = r1.f24325d;	 Catch:{ InterruptedException -> 0x0009 }
        r0 = m31121c();	 Catch:{ InterruptedException -> 0x0009 }
        r2.put(r0);	 Catch:{ InterruptedException -> 0x0009 }
    L_0x0009:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.tk.a(com.google.android.gms.common.b):void");
    }

    /* renamed from: b */
    public final com.google.android.gms.internal.ads.aaa m31125b(int r4) {
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
        r4 = r3.f24325d;	 Catch:{ InterruptedException -> 0x000d }
        r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;	 Catch:{ InterruptedException -> 0x000d }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x000d }
        r4 = r4.poll(r0, r2);	 Catch:{ InterruptedException -> 0x000d }
        r4 = (com.google.android.gms.internal.ads.aaa) r4;	 Catch:{ InterruptedException -> 0x000d }
        goto L_0x000e;
    L_0x000d:
        r4 = 0;
    L_0x000e:
        if (r4 != 0) goto L_0x0014;
    L_0x0010:
        r4 = m31121c();
    L_0x0014:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.tk.b(int):com.google.android.gms.internal.ads.aaa");
    }
}
