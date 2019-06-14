package com.google.android.gms.internal.ads;

public class ace {
    /* renamed from: a */
    private static final abd f14258a = abd.m17883a();
    /* renamed from: b */
    private aai f14259b;
    /* renamed from: c */
    private volatile acx f14260c;
    /* renamed from: d */
    private volatile aai f14261d;

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.acx m17959b(com.google.android.gms.internal.ads.acx r2) {
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
        r0 = r1.f14260c;
        if (r0 != 0) goto L_0x001c;
    L_0x0004:
        monitor-enter(r1);
        r0 = r1.f14260c;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x000b;	 Catch:{ all -> 0x0019 }
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        goto L_0x001c;
    L_0x000b:
        r1.f14260c = r2;	 Catch:{ abw -> 0x0012 }
        r0 = com.google.android.gms.internal.ads.aai.f14132a;	 Catch:{ abw -> 0x0012 }
        r1.f14261d = r0;	 Catch:{ abw -> 0x0012 }
        goto L_0x0009;
    L_0x0012:
        r1.f14260c = r2;	 Catch:{ all -> 0x0019 }
        r2 = com.google.android.gms.internal.ads.aai.f14132a;	 Catch:{ all -> 0x0019 }
        r1.f14261d = r2;	 Catch:{ all -> 0x0019 }
        goto L_0x0009;	 Catch:{ all -> 0x0019 }
    L_0x0019:
        r2 = move-exception;	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r2;
    L_0x001c:
        r2 = r1.f14260c;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ace.b(com.google.android.gms.internal.ads.acx):com.google.android.gms.internal.ads.acx");
    }

    /* renamed from: a */
    public final acx m17960a(acx acx) {
        acx acx2 = this.f14260c;
        this.f14259b = null;
        this.f14261d = null;
        this.f14260c = acx;
        return acx2;
    }

    /* renamed from: b */
    public final int m17961b() {
        return this.f14261d != null ? this.f14261d.mo6036a() : this.f14260c != null ? this.f14260c.mo6637l() : 0;
    }

    /* renamed from: c */
    public final aai m17962c() {
        if (this.f14261d != null) {
            return this.f14261d;
        }
        synchronized (this) {
            if (this.f14261d != null) {
                aai aai = this.f14261d;
                return aai;
            }
            this.f14261d = this.f14260c == null ? aai.f14132a : this.f14260c.mo6142h();
            aai = this.f14261d;
            return aai;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ace)) {
            return false;
        }
        ace ace = (ace) obj;
        acx acx = this.f14260c;
        acx acx2 = ace.f14260c;
        return (acx == null && acx2 == null) ? m17962c().equals(ace.m17962c()) : (acx == null || acx2 == null) ? acx != null ? acx.equals(ace.m17959b(acx.mo6633p())) : m17959b(acx2.mo6633p()).equals(acx2) : acx.equals(acx2);
    }

    public int hashCode() {
        return 1;
    }
}
