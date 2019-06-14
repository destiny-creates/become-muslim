package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class ase extends Thread {
    /* renamed from: a */
    private final BlockingQueue<awi<?>> f14892a;
    /* renamed from: b */
    private final arh f14893b;
    /* renamed from: c */
    private final zz f14894c;
    /* renamed from: d */
    private final C4922b f14895d;
    /* renamed from: e */
    private volatile boolean f14896e = false;

    public ase(BlockingQueue<awi<?>> blockingQueue, arh arh, zz zzVar, C4922b c4922b) {
        this.f14892a = blockingQueue;
        this.f14893b = arh;
        this.f14894c = zzVar;
        this.f14895d = c4922b;
    }

    /* renamed from: b */
    private final void m18867b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        awi awi = (awi) this.f14892a.take();
        try {
            awi.m19061b("network-queue-take");
            awi.m19067g();
            TrafficStats.setThreadStatsTag(awi.m19064d());
            aug a = this.f14893b.mo4084a(awi);
            awi.m19061b("network-http-complete");
            if (a.f15008e && awi.m19072l()) {
                awi.m19063c("not-modified");
                awi.m19073m();
                return;
            }
            bck a2 = awi.mo4314a(a);
            awi.m19061b("network-parse-complete");
            if (awi.m19068h() && a2.f15215b != null) {
                this.f14894c.mo4313a(awi.m19065e(), a2.f15215b);
                awi.m19061b("network-cache-written");
            }
            awi.m19071k();
            this.f14895d.mo3851a(awi, a2);
            awi.m19056a(a2);
        } catch (df e) {
            e.m19380a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f14895d.mo3853a(awi, e);
            awi.m19073m();
        } catch (Throwable e2) {
            eg.m19389a(e2, "Unhandled exception %s", e2.toString());
            df dfVar = new df(e2);
            dfVar.m19380a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f14895d.mo3853a(awi, dfVar);
            awi.m19073m();
        }
    }

    /* renamed from: a */
    public final void m18868a() {
        this.f14896e = true;
        interrupt();
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
        r1 = this;
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x0005:
        r1.m18867b();	 Catch:{ InterruptedException -> 0x0009 }
        goto L_0x0005;
    L_0x0009:
        r0 = r1.f14896e;
        if (r0 == 0) goto L_0x0005;
    L_0x000d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ase.run():void");
    }
}
