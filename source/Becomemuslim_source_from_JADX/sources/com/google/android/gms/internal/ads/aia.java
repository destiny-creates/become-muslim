package com.google.android.gms.internal.ads;

import java.util.concurrent.BlockingQueue;

public final class aia extends Thread {
    /* renamed from: a */
    private static final boolean f14552a = eg.f15334a;
    /* renamed from: b */
    private final BlockingQueue<awi<?>> f14553b;
    /* renamed from: c */
    private final BlockingQueue<awi<?>> f14554c;
    /* renamed from: d */
    private final zz f14555d;
    /* renamed from: e */
    private final C4922b f14556e;
    /* renamed from: f */
    private volatile boolean f14557f = false;
    /* renamed from: g */
    private final akc f14558g;

    public aia(BlockingQueue<awi<?>> blockingQueue, BlockingQueue<awi<?>> blockingQueue2, zz zzVar, C4922b c4922b) {
        this.f14553b = blockingQueue;
        this.f14554c = blockingQueue2;
        this.f14555d = zzVar;
        this.f14556e = c4922b;
        this.f14558g = new akc(this);
    }

    /* renamed from: b */
    private final void m18474b() {
        awi awi = (awi) this.f14553b.take();
        awi.m19061b("cache-queue-take");
        awi.m19067g();
        agz a = this.f14555d.mo4311a(awi.m19065e());
        if (a == null) {
            awi.m19061b("cache-miss");
            if (!this.f14558g.m30009b(awi)) {
                this.f14554c.put(awi);
            }
        } else if (a.m18416a()) {
            awi.m19061b("cache-hit-expired");
            awi.m19052a(a);
            if (!this.f14558g.m30009b(awi)) {
                this.f14554c.put(awi);
            }
        } else {
            awi.m19061b("cache-hit");
            bck a2 = awi.mo4314a(new aug(a.f14505a, a.f14511g));
            awi.m19061b("cache-hit-parsed");
            if ((a.f14510f < System.currentTimeMillis() ? 1 : null) != null) {
                awi.m19061b("cache-hit-refresh-needed");
                awi.m19052a(a);
                a2.f15217d = true;
                if (!this.f14558g.m30009b(awi)) {
                    this.f14556e.mo3852a(awi, a2, new ajb(this, awi));
                    return;
                }
            }
            this.f14556e.mo3851a(awi, a2);
        }
    }

    /* renamed from: a */
    public final void m18475a() {
        this.f14557f = true;
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
        r2 = this;
        r0 = f14552a;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = "start new dispatcher";
        r1 = 0;
        r1 = new java.lang.Object[r1];
        com.google.android.gms.internal.ads.eg.m19388a(r0, r1);
    L_0x000c:
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
        r0 = r2.f14555d;
        r0.mo4312a();
    L_0x0016:
        r2.m18474b();	 Catch:{ InterruptedException -> 0x001a }
        goto L_0x0016;
    L_0x001a:
        r0 = r2.f14557f;
        if (r0 == 0) goto L_0x0016;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aia.run():void");
    }
}
