package com.google.android.gms.internal.ads;

public final class anm extends afi<anm> {
    /* renamed from: a */
    public String f28153a;
    /* renamed from: b */
    public anz f28154b;
    /* renamed from: c */
    private any f28155c;
    /* renamed from: d */
    private Integer f28156d;
    /* renamed from: e */
    private Integer f28157e;
    /* renamed from: f */
    private Integer f28158f;
    /* renamed from: g */
    private Integer f28159g;
    /* renamed from: h */
    private Integer f28160h;

    public anm() {
        this.f28153a = null;
        this.f28155c = null;
        this.f28156d = null;
        this.f28154b = null;
        this.f28157e = null;
        this.f28158f = null;
        this.f28159g = null;
        this.f28160h = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.anm m36823b(com.google.android.gms.internal.ads.afe r4) {
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
    L_0x0000:
        r0 = r4.m18324a();
        if (r0 == 0) goto L_0x00ac;
    L_0x0006:
        r1 = 10;
        if (r0 == r1) goto L_0x00a4;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x0092;
    L_0x000e:
        r1 = 24;
        if (r0 == r1) goto L_0x0086;
    L_0x0012:
        r1 = 34;
        if (r0 == r1) goto L_0x0078;
    L_0x0016:
        r1 = 40;
        if (r0 == r1) goto L_0x006d;
    L_0x001a:
        r1 = 48;
        if (r0 == r1) goto L_0x0053;
    L_0x001e:
        r1 = 56;
        if (r0 == r1) goto L_0x0040;
    L_0x0022:
        r1 = 64;
        if (r0 == r1) goto L_0x002d;
    L_0x0026:
        r0 = super.m29903a(r4, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x002c:
        return r3;
    L_0x002d:
        r1 = r4.m18341j();
        r2 = r4.m18338g();	 Catch:{ IllegalArgumentException -> 0x0066 }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x0066 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0066 }
        r3.f28160h = r2;	 Catch:{ IllegalArgumentException -> 0x0066 }
        goto L_0x0000;
    L_0x0040:
        r1 = r4.m18341j();
        r2 = r4.m18338g();	 Catch:{ IllegalArgumentException -> 0x0066 }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x0066 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0066 }
        r3.f28159g = r2;	 Catch:{ IllegalArgumentException -> 0x0066 }
        goto L_0x0000;
    L_0x0053:
        r1 = r4.m18341j();
        r2 = r4.m18338g();	 Catch:{ IllegalArgumentException -> 0x0066 }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x0066 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0066 }
        r3.f28158f = r2;	 Catch:{ IllegalArgumentException -> 0x0066 }
        goto L_0x0000;
    L_0x0066:
        r4.m18336e(r1);
        r3.m29903a(r4, r0);
        goto L_0x0000;
    L_0x006d:
        r0 = r4.m18338g();
        r0 = java.lang.Integer.valueOf(r0);
        r3.f28157e = r0;
        goto L_0x0000;
    L_0x0078:
        r0 = r3.f28154b;
        if (r0 != 0) goto L_0x0083;
    L_0x007c:
        r0 = new com.google.android.gms.internal.ads.anz;
        r0.<init>();
        r3.f28154b = r0;
    L_0x0083:
        r0 = r3.f28154b;
        goto L_0x009f;
    L_0x0086:
        r0 = r4.m18338g();
        r0 = java.lang.Integer.valueOf(r0);
        r3.f28156d = r0;
        goto L_0x0000;
    L_0x0092:
        r0 = r3.f28155c;
        if (r0 != 0) goto L_0x009d;
    L_0x0096:
        r0 = new com.google.android.gms.internal.ads.any;
        r0.<init>();
        r3.f28155c = r0;
    L_0x009d:
        r0 = r3.f28155c;
    L_0x009f:
        r4.m18326a(r0);
        goto L_0x0000;
    L_0x00a4:
        r0 = r4.m18335e();
        r3.f28153a = r0;
        goto L_0x0000;
    L_0x00ac:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.anm.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.anm");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28153a != null) {
            a += afg.m18352b(1, this.f28153a);
        }
        if (this.f28155c != null) {
            a += afg.m18351b(2, this.f28155c);
        }
        if (this.f28156d != null) {
            a += afg.m18350b(3, this.f28156d.intValue());
        }
        if (this.f28154b != null) {
            a += afg.m18351b(4, this.f28154b);
        }
        if (this.f28157e != null) {
            a += afg.m18350b(5, this.f28157e.intValue());
        }
        if (this.f28158f != null) {
            a += afg.m18350b(6, this.f28158f.intValue());
        }
        if (this.f28159g != null) {
            a += afg.m18350b(7, this.f28159g.intValue());
        }
        return this.f28160h != null ? a + afg.m18350b(8, this.f28160h.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36823b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28153a != null) {
            afg.m18364a(1, this.f28153a);
        }
        if (this.f28155c != null) {
            afg.m18363a(2, this.f28155c);
        }
        if (this.f28156d != null) {
            afg.m18361a(3, this.f28156d.intValue());
        }
        if (this.f28154b != null) {
            afg.m18363a(4, this.f28154b);
        }
        if (this.f28157e != null) {
            afg.m18361a(5, this.f28157e.intValue());
        }
        if (this.f28158f != null) {
            afg.m18361a(6, this.f28158f.intValue());
        }
        if (this.f28159g != null) {
            afg.m18361a(7, this.f28159g.intValue());
        }
        if (this.f28160h != null) {
            afg.m18361a(8, this.f28160h.intValue());
        }
        super.mo3804a(afg);
    }
}
