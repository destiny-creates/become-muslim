package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.fz */
public class fz {
    /* renamed from: a */
    private static final ew f16639a = ew.m20505a();
    /* renamed from: b */
    private dy f16640b;
    /* renamed from: c */
    private volatile gt f16641c;
    /* renamed from: d */
    private volatile dy f16642d;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fz)) {
            return null;
        }
        fz fzVar = (fz) obj;
        gt gtVar = this.f16641c;
        gt gtVar2 = fzVar.f16641c;
        if (gtVar == null && gtVar2 == null) {
            return m20582c().equals(fzVar.m20582c());
        }
        if (gtVar != null && gtVar2 != null) {
            return gtVar.equals(gtVar2);
        }
        if (gtVar != null) {
            return gtVar.equals(fzVar.m20579b(gtVar.mo6732v()));
        }
        return m20579b(gtVar2.mo6732v()).equals(gtVar2);
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.p210i.gt m20579b(com.google.android.gms.internal.p210i.gt r2) {
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
        r0 = r1.f16641c;
        if (r0 != 0) goto L_0x001d;
    L_0x0004:
        monitor-enter(r1);
        r0 = r1.f16641c;	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x000b;	 Catch:{ all -> 0x001a }
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x001d;
    L_0x000b:
        r1.f16641c = r2;	 Catch:{ fs -> 0x0012 }
        r0 = com.google.android.gms.internal.p210i.dy.f16513a;	 Catch:{ fs -> 0x0012 }
        r1.f16642d = r0;	 Catch:{ fs -> 0x0012 }
        goto L_0x0018;
    L_0x0012:
        r1.f16641c = r2;	 Catch:{ all -> 0x001a }
        r2 = com.google.android.gms.internal.p210i.dy.f16513a;	 Catch:{ all -> 0x001a }
        r1.f16642d = r2;	 Catch:{ all -> 0x001a }
    L_0x0018:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x001d;	 Catch:{ all -> 0x001a }
    L_0x001a:
        r2 = move-exception;	 Catch:{ all -> 0x001a }
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        throw r2;
    L_0x001d:
        r2 = r1.f16641c;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.fz.b(com.google.android.gms.internal.i.gt):com.google.android.gms.internal.i.gt");
    }

    /* renamed from: a */
    public final gt m20580a(gt gtVar) {
        gt gtVar2 = this.f16641c;
        this.f16640b = null;
        this.f16642d = null;
        this.f16641c = gtVar;
        return gtVar2;
    }

    /* renamed from: b */
    public final int m20581b() {
        if (this.f16642d != null) {
            return this.f16642d.mo6160a();
        }
        return this.f16641c != null ? this.f16641c.mo6736r() : 0;
    }

    /* renamed from: c */
    public final dy m20582c() {
        if (this.f16642d != null) {
            return this.f16642d;
        }
        synchronized (this) {
            if (this.f16642d != null) {
                dy dyVar = this.f16642d;
                return dyVar;
            }
            if (this.f16641c == null) {
                this.f16642d = dy.f16513a;
            } else {
                this.f16642d = this.f16641c.mo6148m();
            }
            dyVar = this.f16642d;
            return dyVar;
        }
    }
}
