package com.google.android.gms.internal.ads;

final /* synthetic */ class nf implements Runnable {
    /* renamed from: a */
    private final nz f15822a;
    /* renamed from: b */
    private final mz f15823b;
    /* renamed from: c */
    private final no f15824c;

    nf(nz nzVar, mz mzVar, no noVar) {
        this.f15822a = nzVar;
        this.f15823b = mzVar;
        this.f15824c = noVar;
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
        r3 = this;
        r0 = r3.f15822a;
        r1 = r3.f15823b;
        r2 = r3.f15824c;
        r2 = r2.get();	 Catch:{ CancellationException -> 0x0030, ExecutionException -> 0x0023, InterruptedException -> 0x0017, Exception -> 0x0012 }
        r1 = r1.mo4206a(r2);	 Catch:{ CancellationException -> 0x0030, ExecutionException -> 0x0023, InterruptedException -> 0x0017, Exception -> 0x0012 }
        r0.m30915b(r1);	 Catch:{ CancellationException -> 0x0030, ExecutionException -> 0x0023, InterruptedException -> 0x0017, Exception -> 0x0012 }
        return;
    L_0x0012:
        r1 = move-exception;
        r0.m30914a(r1);
        return;
    L_0x0017:
        r1 = move-exception;
        r2 = java.lang.Thread.currentThread();
        r2.interrupt();
        r0.m30914a(r1);
        return;
    L_0x0023:
        r1 = move-exception;
        r2 = r1.getCause();
        if (r2 != 0) goto L_0x002b;
    L_0x002a:
        goto L_0x002c;
    L_0x002b:
        r1 = r2;
    L_0x002c:
        r0.m30914a(r1);
        return;
    L_0x0030:
        r1 = 1;
        r0.cancel(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.nf.run():void");
    }
}
