package com.google.android.gms.internal.ads;

public final class agf extends afi<agf> {
    /* renamed from: a */
    public byte[][] f28097a;
    /* renamed from: b */
    public byte[] f28098b;
    /* renamed from: c */
    public Integer f28099c;
    /* renamed from: d */
    private Integer f28100d;

    public agf() {
        this.f28097a = afr.f14437d;
        this.f28098b = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.agf m36781b(com.google.android.gms.internal.ads.afe r5) {
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
        if (r0 == 0) goto L_0x0084;
    L_0x0006:
        r1 = 10;
        if (r0 == r1) goto L_0x0051;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x004a;
    L_0x000e:
        r1 = 24;
        if (r0 == r1) goto L_0x0030;
    L_0x0012:
        r1 = 32;
        if (r0 == r1) goto L_0x001d;
    L_0x0016:
        r0 = super.m29903a(r5, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x001c:
        return r4;
    L_0x001d:
        r1 = r5.m18341j();
        r2 = r5.m18338g();	 Catch:{ IllegalArgumentException -> 0x0043 }
        r2 = com.google.android.gms.internal.ads.yy.m20188c(r2);	 Catch:{ IllegalArgumentException -> 0x0043 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0043 }
        r4.f28099c = r2;	 Catch:{ IllegalArgumentException -> 0x0043 }
        goto L_0x0000;
    L_0x0030:
        r1 = r5.m18341j();
        r2 = r5.m18338g();	 Catch:{ IllegalArgumentException -> 0x0043 }
        r2 = com.google.android.gms.internal.ads.yy.m20187b(r2);	 Catch:{ IllegalArgumentException -> 0x0043 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0043 }
        r4.f28100d = r2;	 Catch:{ IllegalArgumentException -> 0x0043 }
        goto L_0x0000;
    L_0x0043:
        r5.m18336e(r1);
        r4.m29903a(r5, r0);
        goto L_0x0000;
    L_0x004a:
        r0 = r5.m18337f();
        r4.f28098b = r0;
        goto L_0x0000;
    L_0x0051:
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r5, r1);
        r1 = r4.f28097a;
        r2 = 0;
        if (r1 != 0) goto L_0x005c;
    L_0x005a:
        r1 = 0;
        goto L_0x005f;
    L_0x005c:
        r1 = r4.f28097a;
        r1 = r1.length;
    L_0x005f:
        r0 = r0 + r1;
        r0 = new byte[r0][];
        if (r1 == 0) goto L_0x0069;
    L_0x0064:
        r3 = r4.f28097a;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x0069:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x007a;
    L_0x006e:
        r2 = r5.m18337f();
        r0[r1] = r2;
        r5.m18324a();
        r1 = r1 + 1;
        goto L_0x0069;
    L_0x007a:
        r2 = r5.m18337f();
        r0[r1] = r2;
        r4.f28097a = r0;
        goto L_0x0000;
    L_0x0084:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agf.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.agf");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28097a != null && this.f28097a.length > 0) {
            int i = 0;
            int i2 = 0;
            for (byte[] bArr : this.f28097a) {
                if (bArr != null) {
                    i2++;
                    i += afg.m18354b(bArr);
                }
            }
            a = (a + i) + (i2 * 1);
        }
        if (this.f28098b != null) {
            a += afg.m18353b(2, this.f28098b);
        }
        if (this.f28100d != null) {
            a += afg.m18350b(3, this.f28100d.intValue());
        }
        return this.f28099c != null ? a + afg.m18350b(4, this.f28099c.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36781b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28097a != null && this.f28097a.length > 0) {
            for (byte[] bArr : this.f28097a) {
                if (bArr != null) {
                    afg.m18366a(1, bArr);
                }
            }
        }
        if (this.f28098b != null) {
            afg.m18366a(2, this.f28098b);
        }
        if (this.f28100d != null) {
            afg.m18361a(3, this.f28100d.intValue());
        }
        if (this.f28099c != null) {
            afg.m18361a(4, this.f28099c.intValue());
        }
        super.mo3804a(afg);
    }
}
