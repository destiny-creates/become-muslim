package com.google.android.gms.internal.ads;

public final class ano extends afi<ano> {
    /* renamed from: a */
    public String f28165a;
    /* renamed from: b */
    public long[] f28166b;
    /* renamed from: c */
    public anm f28167c;
    /* renamed from: d */
    public anh f28168d;
    /* renamed from: e */
    private Integer f28169e;
    /* renamed from: f */
    private Integer f28170f;
    /* renamed from: g */
    private Integer f28171g;
    /* renamed from: h */
    private anz f28172h;
    /* renamed from: i */
    private ann f28173i;
    /* renamed from: j */
    private ans f28174j;

    public ano() {
        this.f28169e = null;
        this.f28165a = null;
        this.f28170f = null;
        this.f28171g = null;
        this.f28172h = null;
        this.f28166b = afr.f14435b;
        this.f28167c = null;
        this.f28173i = null;
        this.f28174j = null;
        this.f28168d = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.ano m36831b(com.google.android.gms.internal.ads.afe r7) {
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
        r1 = 0;
        switch(r0) {
            case 0: goto L_0x010f;
            case 72: goto L_0x0103;
            case 82: goto L_0x00fb;
            case 88: goto L_0x00ef;
            case 96: goto L_0x00d3;
            case 106: goto L_0x00c1;
            case 112: goto L_0x008d;
            case 114: goto L_0x004b;
            case 122: goto L_0x003c;
            case 130: goto L_0x002d;
            case 138: goto L_0x001e;
            case 146: goto L_0x000f;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = super.m29903a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x000e:
        return r6;
    L_0x000f:
        r0 = r6.f28168d;
        if (r0 != 0) goto L_0x001a;
    L_0x0013:
        r0 = new com.google.android.gms.internal.ads.anh;
        r0.<init>();
        r6.f28168d = r0;
    L_0x001a:
        r0 = r6.f28168d;
        goto L_0x00ce;
    L_0x001e:
        r0 = r6.f28174j;
        if (r0 != 0) goto L_0x0029;
    L_0x0022:
        r0 = new com.google.android.gms.internal.ads.ans;
        r0.<init>();
        r6.f28174j = r0;
    L_0x0029:
        r0 = r6.f28174j;
        goto L_0x00ce;
    L_0x002d:
        r0 = r6.f28173i;
        if (r0 != 0) goto L_0x0038;
    L_0x0031:
        r0 = new com.google.android.gms.internal.ads.ann;
        r0.<init>();
        r6.f28173i = r0;
    L_0x0038:
        r0 = r6.f28173i;
        goto L_0x00ce;
    L_0x003c:
        r0 = r6.f28167c;
        if (r0 != 0) goto L_0x0047;
    L_0x0040:
        r0 = new com.google.android.gms.internal.ads.anm;
        r0.<init>();
        r6.f28167c = r0;
    L_0x0047:
        r0 = r6.f28167c;
        goto L_0x00ce;
    L_0x004b:
        r0 = r7.m18338g();
        r0 = r7.m18332c(r0);
        r2 = r7.m18341j();
        r3 = 0;
    L_0x0058:
        r4 = r7.m18340i();
        if (r4 <= 0) goto L_0x0064;
    L_0x005e:
        r7.m18339h();
        r3 = r3 + 1;
        goto L_0x0058;
    L_0x0064:
        r7.m18336e(r2);
        r2 = r6.f28166b;
        if (r2 != 0) goto L_0x006d;
    L_0x006b:
        r2 = 0;
        goto L_0x0070;
    L_0x006d:
        r2 = r6.f28166b;
        r2 = r2.length;
    L_0x0070:
        r3 = r3 + r2;
        r3 = new long[r3];
        if (r2 == 0) goto L_0x007a;
    L_0x0075:
        r4 = r6.f28166b;
        java.lang.System.arraycopy(r4, r1, r3, r1, r2);
    L_0x007a:
        r1 = r3.length;
        if (r2 >= r1) goto L_0x0086;
    L_0x007d:
        r4 = r7.m18339h();
        r3[r2] = r4;
        r2 = r2 + 1;
        goto L_0x007a;
    L_0x0086:
        r6.f28166b = r3;
        r7.m18333d(r0);
        goto L_0x0000;
    L_0x008d:
        r0 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r7, r0);
        r2 = r6.f28166b;
        if (r2 != 0) goto L_0x0099;
    L_0x0097:
        r2 = 0;
        goto L_0x009c;
    L_0x0099:
        r2 = r6.f28166b;
        r2 = r2.length;
    L_0x009c:
        r0 = r0 + r2;
        r0 = new long[r0];
        if (r2 == 0) goto L_0x00a6;
    L_0x00a1:
        r3 = r6.f28166b;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x00a6:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x00b7;
    L_0x00ab:
        r3 = r7.m18339h();
        r0[r2] = r3;
        r7.m18324a();
        r2 = r2 + 1;
        goto L_0x00a6;
    L_0x00b7:
        r3 = r7.m18339h();
        r0[r2] = r3;
        r6.f28166b = r0;
        goto L_0x0000;
    L_0x00c1:
        r0 = r6.f28172h;
        if (r0 != 0) goto L_0x00cc;
    L_0x00c5:
        r0 = new com.google.android.gms.internal.ads.anz;
        r0.<init>();
        r6.f28172h = r0;
    L_0x00cc:
        r0 = r6.f28172h;
    L_0x00ce:
        r7.m18326a(r0);
        goto L_0x0000;
    L_0x00d3:
        r1 = r7.m18341j();
        r2 = r7.m18338g();	 Catch:{ IllegalArgumentException -> 0x00e7 }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x00e7 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x00e7 }
        r6.f28171g = r2;	 Catch:{ IllegalArgumentException -> 0x00e7 }
        goto L_0x0000;
    L_0x00e7:
        r7.m18336e(r1);
        r6.m29903a(r7, r0);
        goto L_0x0000;
    L_0x00ef:
        r0 = r7.m18338g();
        r0 = java.lang.Integer.valueOf(r0);
        r6.f28170f = r0;
        goto L_0x0000;
    L_0x00fb:
        r0 = r7.m18335e();
        r6.f28165a = r0;
        goto L_0x0000;
    L_0x0103:
        r0 = r7.m18338g();
        r0 = java.lang.Integer.valueOf(r0);
        r6.f28169e = r0;
        goto L_0x0000;
    L_0x010f:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ano.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.ano");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28169e != null) {
            a += afg.m18350b(9, this.f28169e.intValue());
        }
        if (this.f28165a != null) {
            a += afg.m18352b(10, this.f28165a);
        }
        if (this.f28170f != null) {
            a += afg.m18349b(11) + afg.m18357d(this.f28170f.intValue());
        }
        if (this.f28171g != null) {
            a += afg.m18350b(12, this.f28171g.intValue());
        }
        if (this.f28172h != null) {
            a += afg.m18351b(13, this.f28172h);
        }
        if (this.f28166b != null && this.f28166b.length > 0) {
            int i = 0;
            for (long a2 : this.f28166b) {
                i += afg.m18343a(a2);
            }
            a = (a + i) + (this.f28166b.length * 1);
        }
        if (this.f28167c != null) {
            a += afg.m18351b(15, this.f28167c);
        }
        if (this.f28173i != null) {
            a += afg.m18351b(16, this.f28173i);
        }
        if (this.f28174j != null) {
            a += afg.m18351b(17, this.f28174j);
        }
        return this.f28168d != null ? a + afg.m18351b(18, this.f28168d) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36831b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28169e != null) {
            afg.m18361a(9, this.f28169e.intValue());
        }
        if (this.f28165a != null) {
            afg.m18364a(10, this.f28165a);
        }
        int i = 0;
        if (this.f28170f != null) {
            int intValue = this.f28170f.intValue();
            afg.m18369c(11, 0);
            afg.m18368c(intValue);
        }
        if (this.f28171g != null) {
            afg.m18361a(12, this.f28171g.intValue());
        }
        if (this.f28172h != null) {
            afg.m18363a(13, this.f28172h);
        }
        if (this.f28166b != null && this.f28166b.length > 0) {
            while (i < this.f28166b.length) {
                afg.m18362a(14, this.f28166b[i]);
                i++;
            }
        }
        if (this.f28167c != null) {
            afg.m18363a(15, this.f28167c);
        }
        if (this.f28173i != null) {
            afg.m18363a(16, this.f28173i);
        }
        if (this.f28174j != null) {
            afg.m18363a(17, this.f28174j);
        }
        if (this.f28168d != null) {
            afg.m18363a(18, this.f28168d);
        }
        super.mo3804a(afg);
    }
}
