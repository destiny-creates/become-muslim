package com.google.android.gms.internal.ads;

public final class ank extends afi<ank> {
    /* renamed from: a */
    private String f28142a;
    /* renamed from: b */
    private ani[] f28143b;
    /* renamed from: c */
    private Integer f28144c;
    /* renamed from: d */
    private Integer f28145d;
    /* renamed from: e */
    private Integer f28146e;

    public ank() {
        this.f28142a = null;
        this.f28143b = ani.m36808b();
        this.f28144c = null;
        this.f28145d = null;
        this.f28146e = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.ank m36816b(com.google.android.gms.internal.ads.afe r5) {
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
        r4 = this;
    L_0x0000:
        r0 = r5.m18324a();
        if (r0 == 0) goto L_0x00a8;
    L_0x0006:
        r1 = 10;
        if (r0 == r1) goto L_0x00a0;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x0061;
    L_0x000e:
        r1 = 24;
        if (r0 == r1) goto L_0x0047;
    L_0x0012:
        r1 = 32;
        if (r0 == r1) goto L_0x0034;
    L_0x0016:
        r1 = 40;
        if (r0 == r1) goto L_0x0021;
    L_0x001a:
        r0 = super.m29903a(r5, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0020:
        return r4;
    L_0x0021:
        r1 = r5.m18341j();
        r2 = r5.m18338g();	 Catch:{ IllegalArgumentException -> 0x005a }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x005a }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x005a }
        r4.f28146e = r2;	 Catch:{ IllegalArgumentException -> 0x005a }
        goto L_0x0000;
    L_0x0034:
        r1 = r5.m18341j();
        r2 = r5.m18338g();	 Catch:{ IllegalArgumentException -> 0x005a }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x005a }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x005a }
        r4.f28145d = r2;	 Catch:{ IllegalArgumentException -> 0x005a }
        goto L_0x0000;
    L_0x0047:
        r1 = r5.m18341j();
        r2 = r5.m18338g();	 Catch:{ IllegalArgumentException -> 0x005a }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x005a }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x005a }
        r4.f28144c = r2;	 Catch:{ IllegalArgumentException -> 0x005a }
        goto L_0x0000;
    L_0x005a:
        r5.m18336e(r1);
        r4.m29903a(r5, r0);
        goto L_0x0000;
    L_0x0061:
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r5, r1);
        r1 = r4.f28143b;
        r2 = 0;
        if (r1 != 0) goto L_0x006c;
    L_0x006a:
        r1 = 0;
        goto L_0x006f;
    L_0x006c:
        r1 = r4.f28143b;
        r1 = r1.length;
    L_0x006f:
        r0 = r0 + r1;
        r0 = new com.google.android.gms.internal.ads.ani[r0];
        if (r1 == 0) goto L_0x0079;
    L_0x0074:
        r3 = r4.f28143b;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x0079:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0090;
    L_0x007e:
        r2 = new com.google.android.gms.internal.ads.ani;
        r2.<init>();
        r0[r1] = r2;
        r2 = r0[r1];
        r5.m18326a(r2);
        r5.m18324a();
        r1 = r1 + 1;
        goto L_0x0079;
    L_0x0090:
        r2 = new com.google.android.gms.internal.ads.ani;
        r2.<init>();
        r0[r1] = r2;
        r1 = r0[r1];
        r5.m18326a(r1);
        r4.f28143b = r0;
        goto L_0x0000;
    L_0x00a0:
        r0 = r5.m18335e();
        r4.f28142a = r0;
        goto L_0x0000;
    L_0x00a8:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ank.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.ank");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28142a != null) {
            a += afg.m18352b(1, this.f28142a);
        }
        if (this.f28143b != null && this.f28143b.length > 0) {
            for (afo afo : this.f28143b) {
                if (afo != null) {
                    a += afg.m18351b(2, afo);
                }
            }
        }
        if (this.f28144c != null) {
            a += afg.m18350b(3, this.f28144c.intValue());
        }
        if (this.f28145d != null) {
            a += afg.m18350b(4, this.f28145d.intValue());
        }
        return this.f28146e != null ? a + afg.m18350b(5, this.f28146e.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36816b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28142a != null) {
            afg.m18364a(1, this.f28142a);
        }
        if (this.f28143b != null && this.f28143b.length > 0) {
            for (afo afo : this.f28143b) {
                if (afo != null) {
                    afg.m18363a(2, afo);
                }
            }
        }
        if (this.f28144c != null) {
            afg.m18361a(3, this.f28144c.intValue());
        }
        if (this.f28145d != null) {
            afg.m18361a(4, this.f28145d.intValue());
        }
        if (this.f28146e != null) {
            afg.m18361a(5, this.f28146e.intValue());
        }
        super.mo3804a(afg);
    }
}
