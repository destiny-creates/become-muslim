package com.google.android.gms.internal.ads;

public final class anh extends afi<anh> {
    /* renamed from: a */
    public Integer f28125a;
    /* renamed from: b */
    public ank f28126b;
    /* renamed from: c */
    private Integer f28127c;
    /* renamed from: d */
    private anj f28128d;
    /* renamed from: e */
    private ani[] f28129e;
    /* renamed from: f */
    private anl f28130f;
    /* renamed from: g */
    private anu f28131g;
    /* renamed from: h */
    private ant f28132h;
    /* renamed from: i */
    private anq f28133i;
    /* renamed from: j */
    private anr f28134j;
    /* renamed from: k */
    private aoa[] f28135k;

    public anh() {
        this.f28125a = null;
        this.f28127c = null;
        this.f28128d = null;
        this.f28126b = null;
        this.f28129e = ani.m36808b();
        this.f28130f = null;
        this.f28131g = null;
        this.f28132h = null;
        this.f28133i = null;
        this.f28134j = null;
        this.f28135k = aoa.m36877b();
        this.Y = null;
        this.Z = -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final com.google.android.gms.internal.ads.anh m36803b(com.google.android.gms.internal.ads.afe r7) {
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
            case 0: goto L_0x0142;
            case 56: goto L_0x010b;
            case 64: goto L_0x00f7;
            case 74: goto L_0x00e5;
            case 82: goto L_0x00d7;
            case 90: goto L_0x0097;
            case 98: goto L_0x0089;
            case 106: goto L_0x007b;
            case 114: goto L_0x006c;
            case 122: goto L_0x005d;
            case 130: goto L_0x004e;
            case 138: goto L_0x000f;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = super.m29903a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x000e:
        return r6;
    L_0x000f:
        r0 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r7, r0);
        r2 = r6.f28135k;
        if (r2 != 0) goto L_0x001b;
    L_0x0019:
        r2 = 0;
        goto L_0x001e;
    L_0x001b:
        r2 = r6.f28135k;
        r2 = r2.length;
    L_0x001e:
        r0 = r0 + r2;
        r0 = new com.google.android.gms.internal.ads.aoa[r0];
        if (r2 == 0) goto L_0x0028;
    L_0x0023:
        r3 = r6.f28135k;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x0028:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x003f;
    L_0x002d:
        r1 = new com.google.android.gms.internal.ads.aoa;
        r1.<init>();
        r0[r2] = r1;
        r1 = r0[r2];
        r7.m18326a(r1);
        r7.m18324a();
        r2 = r2 + 1;
        goto L_0x0028;
    L_0x003f:
        r1 = new com.google.android.gms.internal.ads.aoa;
        r1.<init>();
        r0[r2] = r1;
        r1 = r0[r2];
        r7.m18326a(r1);
        r6.f28135k = r0;
        goto L_0x0000;
    L_0x004e:
        r0 = r6.f28134j;
        if (r0 != 0) goto L_0x0059;
    L_0x0052:
        r0 = new com.google.android.gms.internal.ads.anr;
        r0.<init>();
        r6.f28134j = r0;
    L_0x0059:
        r0 = r6.f28134j;
        goto L_0x00f2;
    L_0x005d:
        r0 = r6.f28133i;
        if (r0 != 0) goto L_0x0068;
    L_0x0061:
        r0 = new com.google.android.gms.internal.ads.anq;
        r0.<init>();
        r6.f28133i = r0;
    L_0x0068:
        r0 = r6.f28133i;
        goto L_0x00f2;
    L_0x006c:
        r0 = r6.f28132h;
        if (r0 != 0) goto L_0x0077;
    L_0x0070:
        r0 = new com.google.android.gms.internal.ads.ant;
        r0.<init>();
        r6.f28132h = r0;
    L_0x0077:
        r0 = r6.f28132h;
        goto L_0x00f2;
    L_0x007b:
        r0 = r6.f28131g;
        if (r0 != 0) goto L_0x0086;
    L_0x007f:
        r0 = new com.google.android.gms.internal.ads.anu;
        r0.<init>();
        r6.f28131g = r0;
    L_0x0086:
        r0 = r6.f28131g;
        goto L_0x00f2;
    L_0x0089:
        r0 = r6.f28130f;
        if (r0 != 0) goto L_0x0094;
    L_0x008d:
        r0 = new com.google.android.gms.internal.ads.anl;
        r0.<init>();
        r6.f28130f = r0;
    L_0x0094:
        r0 = r6.f28130f;
        goto L_0x00f2;
    L_0x0097:
        r0 = 90;
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r7, r0);
        r2 = r6.f28129e;
        if (r2 != 0) goto L_0x00a3;
    L_0x00a1:
        r2 = 0;
        goto L_0x00a6;
    L_0x00a3:
        r2 = r6.f28129e;
        r2 = r2.length;
    L_0x00a6:
        r0 = r0 + r2;
        r0 = new com.google.android.gms.internal.ads.ani[r0];
        if (r2 == 0) goto L_0x00b0;
    L_0x00ab:
        r3 = r6.f28129e;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x00b0:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x00c7;
    L_0x00b5:
        r1 = new com.google.android.gms.internal.ads.ani;
        r1.<init>();
        r0[r2] = r1;
        r1 = r0[r2];
        r7.m18326a(r1);
        r7.m18324a();
        r2 = r2 + 1;
        goto L_0x00b0;
    L_0x00c7:
        r1 = new com.google.android.gms.internal.ads.ani;
        r1.<init>();
        r0[r2] = r1;
        r1 = r0[r2];
        r7.m18326a(r1);
        r6.f28129e = r0;
        goto L_0x0000;
    L_0x00d7:
        r0 = r6.f28126b;
        if (r0 != 0) goto L_0x00e2;
    L_0x00db:
        r0 = new com.google.android.gms.internal.ads.ank;
        r0.<init>();
        r6.f28126b = r0;
    L_0x00e2:
        r0 = r6.f28126b;
        goto L_0x00f2;
    L_0x00e5:
        r0 = r6.f28128d;
        if (r0 != 0) goto L_0x00f0;
    L_0x00e9:
        r0 = new com.google.android.gms.internal.ads.anj;
        r0.<init>();
        r6.f28128d = r0;
    L_0x00f0:
        r0 = r6.f28128d;
    L_0x00f2:
        r7.m18326a(r0);
        goto L_0x0000;
    L_0x00f7:
        r1 = r7.m18341j();
        r2 = r7.m18338g();	 Catch:{ IllegalArgumentException -> 0x013a }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x013a }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x013a }
        r6.f28127c = r2;	 Catch:{ IllegalArgumentException -> 0x013a }
        goto L_0x0000;
    L_0x010b:
        r1 = r7.m18341j();
        r2 = r7.m18338g();	 Catch:{ IllegalArgumentException -> 0x013a }
        if (r2 < 0) goto L_0x0121;	 Catch:{ IllegalArgumentException -> 0x013a }
    L_0x0115:
        r3 = 9;	 Catch:{ IllegalArgumentException -> 0x013a }
        if (r2 > r3) goto L_0x0121;	 Catch:{ IllegalArgumentException -> 0x013a }
    L_0x0119:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x013a }
        r6.f28125a = r2;	 Catch:{ IllegalArgumentException -> 0x013a }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x013a }
    L_0x0121:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x013a }
        r4 = 43;	 Catch:{ IllegalArgumentException -> 0x013a }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x013a }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x013a }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x013a }
        r2 = " is not a valid enum AdInitiater";	 Catch:{ IllegalArgumentException -> 0x013a }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x013a }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x013a }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x013a }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x013a }
    L_0x013a:
        r7.m18336e(r1);
        r6.m29903a(r7, r0);
        goto L_0x0000;
    L_0x0142:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.anh.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.anh");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28125a != null) {
            a += afg.m18350b(7, this.f28125a.intValue());
        }
        if (this.f28127c != null) {
            a += afg.m18350b(8, this.f28127c.intValue());
        }
        if (this.f28128d != null) {
            a += afg.m18351b(9, this.f28128d);
        }
        if (this.f28126b != null) {
            a += afg.m18351b(10, this.f28126b);
        }
        if (this.f28129e != null && this.f28129e.length > 0) {
            int i = a;
            for (afo afo : this.f28129e) {
                if (afo != null) {
                    i += afg.m18351b(11, afo);
                }
            }
            a = i;
        }
        if (this.f28130f != null) {
            a += afg.m18351b(12, this.f28130f);
        }
        if (this.f28131g != null) {
            a += afg.m18351b(13, this.f28131g);
        }
        if (this.f28132h != null) {
            a += afg.m18351b(14, this.f28132h);
        }
        if (this.f28133i != null) {
            a += afg.m18351b(15, this.f28133i);
        }
        if (this.f28134j != null) {
            a += afg.m18351b(16, this.f28134j);
        }
        if (this.f28135k != null && this.f28135k.length > 0) {
            for (afo afo2 : this.f28135k) {
                if (afo2 != null) {
                    a += afg.m18351b(17, afo2);
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36803b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28125a != null) {
            afg.m18361a(7, this.f28125a.intValue());
        }
        if (this.f28127c != null) {
            afg.m18361a(8, this.f28127c.intValue());
        }
        if (this.f28128d != null) {
            afg.m18363a(9, this.f28128d);
        }
        if (this.f28126b != null) {
            afg.m18363a(10, this.f28126b);
        }
        if (this.f28129e != null && this.f28129e.length > 0) {
            for (afo afo : this.f28129e) {
                if (afo != null) {
                    afg.m18363a(11, afo);
                }
            }
        }
        if (this.f28130f != null) {
            afg.m18363a(12, this.f28130f);
        }
        if (this.f28131g != null) {
            afg.m18363a(13, this.f28131g);
        }
        if (this.f28132h != null) {
            afg.m18363a(14, this.f28132h);
        }
        if (this.f28133i != null) {
            afg.m18363a(15, this.f28133i);
        }
        if (this.f28134j != null) {
            afg.m18363a(16, this.f28134j);
        }
        if (this.f28135k != null && this.f28135k.length > 0) {
            for (afo afo2 : this.f28135k) {
                if (afo2 != null) {
                    afg.m18363a(17, afo2);
                }
            }
        }
        super.mo3804a(afg);
    }
}
