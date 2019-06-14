package com.google.android.gms.internal.ads;

public final class afz extends afi<afz> {
    /* renamed from: a */
    public Integer f28081a;
    /* renamed from: b */
    public String f28082b;
    /* renamed from: c */
    public byte[] f28083c;

    public afz() {
        this.f28081a = null;
        this.f28082b = null;
        this.f28083c = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.afz m36769b(com.google.android.gms.internal.ads.afe r7) {
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
        r6 = this;
    L_0x0000:
        r0 = r7.m18324a();
        if (r0 == 0) goto L_0x005b;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0027;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x0020;
    L_0x000e:
        r1 = 26;
        if (r0 == r1) goto L_0x0019;
    L_0x0012:
        r0 = super.m29903a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0018:
        return r6;
    L_0x0019:
        r0 = r7.m18337f();
        r6.f28083c = r0;
        goto L_0x0000;
    L_0x0020:
        r0 = r7.m18335e();
        r6.f28082b = r0;
        goto L_0x0000;
    L_0x0027:
        r1 = r7.m18341j();
        r2 = r7.m18331c();	 Catch:{ IllegalArgumentException -> 0x0054 }
        if (r2 < 0) goto L_0x003b;	 Catch:{ IllegalArgumentException -> 0x0054 }
    L_0x0031:
        r3 = 1;	 Catch:{ IllegalArgumentException -> 0x0054 }
        if (r2 > r3) goto L_0x003b;	 Catch:{ IllegalArgumentException -> 0x0054 }
    L_0x0034:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0054 }
        r6.f28081a = r2;	 Catch:{ IllegalArgumentException -> 0x0054 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0054 }
    L_0x003b:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0054 }
        r4 = 36;	 Catch:{ IllegalArgumentException -> 0x0054 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0054 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0054 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0054 }
        r2 = " is not a valid enum Type";	 Catch:{ IllegalArgumentException -> 0x0054 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0054 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0054 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0054 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0054 }
    L_0x0054:
        r7.m18336e(r1);
        r6.m29903a(r7, r0);
        goto L_0x0000;
    L_0x005b:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.afz.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.afz");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28081a != null) {
            a += afg.m18350b(1, this.f28081a.intValue());
        }
        if (this.f28082b != null) {
            a += afg.m18352b(2, this.f28082b);
        }
        return this.f28083c != null ? a + afg.m18353b(3, this.f28083c) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36769b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28081a != null) {
            afg.m18361a(1, this.f28081a.intValue());
        }
        if (this.f28082b != null) {
            afg.m18364a(2, this.f28082b);
        }
        if (this.f28083c != null) {
            afg.m18366a(3, this.f28083c);
        }
        super.mo3804a(afg);
    }
}
