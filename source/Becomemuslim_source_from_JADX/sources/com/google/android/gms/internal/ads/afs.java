package com.google.android.gms.internal.ads;

public final class afs extends afi<afs> {
    /* renamed from: a */
    public Integer f28042a;
    /* renamed from: b */
    public String f28043b;
    /* renamed from: c */
    public String f28044c;
    /* renamed from: d */
    public aft f28045d;
    /* renamed from: e */
    public aga[] f28046e;
    /* renamed from: f */
    public String f28047f;
    /* renamed from: g */
    public afz f28048g;
    /* renamed from: h */
    public agb f28049h;
    /* renamed from: i */
    public String[] f28050i;
    /* renamed from: j */
    public String[] f28051j;
    /* renamed from: k */
    private Integer f28052k;
    /* renamed from: l */
    private String f28053l;
    /* renamed from: m */
    private Boolean f28054m;
    /* renamed from: n */
    private String[] f28055n;
    /* renamed from: o */
    private String f28056o;
    /* renamed from: p */
    private Boolean f28057p;
    /* renamed from: q */
    private Boolean f28058q;
    /* renamed from: r */
    private byte[] f28059r;

    public afs() {
        this.f28042a = null;
        this.f28052k = null;
        this.f28043b = null;
        this.f28044c = null;
        this.f28053l = null;
        this.f28045d = null;
        this.f28046e = aga.m36774b();
        this.f28047f = null;
        this.f28048g = null;
        this.f28054m = null;
        this.f28055n = afr.f14436c;
        this.f28056o = null;
        this.f28057p = null;
        this.f28058q = null;
        this.f28059r = null;
        this.f28049h = null;
        this.f28050i = afr.f14436c;
        this.f28051j = afr.f14436c;
        this.Y = null;
        this.Z = -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final com.google.android.gms.internal.ads.afs m36746b(com.google.android.gms.internal.ads.afe r7) {
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
            case 0: goto L_0x01d0;
            case 10: goto L_0x01c8;
            case 18: goto L_0x01c0;
            case 26: goto L_0x01b8;
            case 34: goto L_0x0178;
            case 40: goto L_0x016c;
            case 50: goto L_0x0138;
            case 58: goto L_0x0130;
            case 64: goto L_0x0124;
            case 72: goto L_0x0118;
            case 80: goto L_0x00e1;
            case 88: goto L_0x00b3;
            case 98: goto L_0x00a1;
            case 106: goto L_0x0099;
            case 114: goto L_0x008b;
            case 122: goto L_0x0083;
            case 138: goto L_0x0075;
            case 162: goto L_0x0042;
            case 170: goto L_0x000f;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = super.m29903a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x000e:
        return r6;
    L_0x000f:
        r0 = 170; // 0xaa float:2.38E-43 double:8.4E-322;
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r7, r0);
        r2 = r6.f28051j;
        if (r2 != 0) goto L_0x001b;
    L_0x0019:
        r2 = 0;
        goto L_0x001e;
    L_0x001b:
        r2 = r6.f28051j;
        r2 = r2.length;
    L_0x001e:
        r0 = r0 + r2;
        r0 = new java.lang.String[r0];
        if (r2 == 0) goto L_0x0028;
    L_0x0023:
        r3 = r6.f28051j;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x0028:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x0039;
    L_0x002d:
        r1 = r7.m18335e();
        r0[r2] = r1;
        r7.m18324a();
        r2 = r2 + 1;
        goto L_0x0028;
    L_0x0039:
        r1 = r7.m18335e();
        r0[r2] = r1;
        r6.f28051j = r0;
        goto L_0x0000;
    L_0x0042:
        r0 = 162; // 0xa2 float:2.27E-43 double:8.0E-322;
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r7, r0);
        r2 = r6.f28050i;
        if (r2 != 0) goto L_0x004e;
    L_0x004c:
        r2 = 0;
        goto L_0x0051;
    L_0x004e:
        r2 = r6.f28050i;
        r2 = r2.length;
    L_0x0051:
        r0 = r0 + r2;
        r0 = new java.lang.String[r0];
        if (r2 == 0) goto L_0x005b;
    L_0x0056:
        r3 = r6.f28050i;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x005b:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x006c;
    L_0x0060:
        r1 = r7.m18335e();
        r0[r2] = r1;
        r7.m18324a();
        r2 = r2 + 1;
        goto L_0x005b;
    L_0x006c:
        r1 = r7.m18335e();
        r0[r2] = r1;
        r6.f28050i = r0;
        goto L_0x0000;
    L_0x0075:
        r0 = r6.f28049h;
        if (r0 != 0) goto L_0x0080;
    L_0x0079:
        r0 = new com.google.android.gms.internal.ads.agb;
        r0.<init>();
        r6.f28049h = r0;
    L_0x0080:
        r0 = r6.f28049h;
        goto L_0x00ae;
    L_0x0083:
        r0 = r7.m18337f();
        r6.f28059r = r0;
        goto L_0x0000;
    L_0x008b:
        r0 = r6.f28048g;
        if (r0 != 0) goto L_0x0096;
    L_0x008f:
        r0 = new com.google.android.gms.internal.ads.afz;
        r0.<init>();
        r6.f28048g = r0;
    L_0x0096:
        r0 = r6.f28048g;
        goto L_0x00ae;
    L_0x0099:
        r0 = r7.m18335e();
        r6.f28047f = r0;
        goto L_0x0000;
    L_0x00a1:
        r0 = r6.f28045d;
        if (r0 != 0) goto L_0x00ac;
    L_0x00a5:
        r0 = new com.google.android.gms.internal.ads.aft;
        r0.<init>();
        r6.f28045d = r0;
    L_0x00ac:
        r0 = r6.f28045d;
    L_0x00ae:
        r7.m18326a(r0);
        goto L_0x0000;
    L_0x00b3:
        r1 = r7.m18341j();
        r2 = r7.m18331c();	 Catch:{ IllegalArgumentException -> 0x0110 }
        if (r2 < 0) goto L_0x00c8;	 Catch:{ IllegalArgumentException -> 0x0110 }
    L_0x00bd:
        r3 = 4;	 Catch:{ IllegalArgumentException -> 0x0110 }
        if (r2 > r3) goto L_0x00c8;	 Catch:{ IllegalArgumentException -> 0x0110 }
    L_0x00c0:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0110 }
        r6.f28052k = r2;	 Catch:{ IllegalArgumentException -> 0x0110 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0110 }
    L_0x00c8:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0110 }
        r4 = 39;	 Catch:{ IllegalArgumentException -> 0x0110 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0110 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0110 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0110 }
        r2 = " is not a valid enum Verdict";	 Catch:{ IllegalArgumentException -> 0x0110 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0110 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0110 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0110 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0110 }
    L_0x00e1:
        r1 = r7.m18341j();
        r2 = r7.m18331c();	 Catch:{ IllegalArgumentException -> 0x0110 }
        if (r2 < 0) goto L_0x00f7;	 Catch:{ IllegalArgumentException -> 0x0110 }
    L_0x00eb:
        r3 = 9;	 Catch:{ IllegalArgumentException -> 0x0110 }
        if (r2 > r3) goto L_0x00f7;	 Catch:{ IllegalArgumentException -> 0x0110 }
    L_0x00ef:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0110 }
        r6.f28042a = r2;	 Catch:{ IllegalArgumentException -> 0x0110 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0110 }
    L_0x00f7:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0110 }
        r4 = 42;	 Catch:{ IllegalArgumentException -> 0x0110 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0110 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0110 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0110 }
        r2 = " is not a valid enum ReportType";	 Catch:{ IllegalArgumentException -> 0x0110 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0110 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0110 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0110 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0110 }
    L_0x0110:
        r7.m18336e(r1);
        r6.m29903a(r7, r0);
        goto L_0x0000;
    L_0x0118:
        r0 = r7.m18334d();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.f28058q = r0;
        goto L_0x0000;
    L_0x0124:
        r0 = r7.m18334d();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.f28057p = r0;
        goto L_0x0000;
    L_0x0130:
        r0 = r7.m18335e();
        r6.f28056o = r0;
        goto L_0x0000;
    L_0x0138:
        r0 = 50;
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r7, r0);
        r2 = r6.f28055n;
        if (r2 != 0) goto L_0x0144;
    L_0x0142:
        r2 = 0;
        goto L_0x0147;
    L_0x0144:
        r2 = r6.f28055n;
        r2 = r2.length;
    L_0x0147:
        r0 = r0 + r2;
        r0 = new java.lang.String[r0];
        if (r2 == 0) goto L_0x0151;
    L_0x014c:
        r3 = r6.f28055n;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x0151:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x0162;
    L_0x0156:
        r1 = r7.m18335e();
        r0[r2] = r1;
        r7.m18324a();
        r2 = r2 + 1;
        goto L_0x0151;
    L_0x0162:
        r1 = r7.m18335e();
        r0[r2] = r1;
        r6.f28055n = r0;
        goto L_0x0000;
    L_0x016c:
        r0 = r7.m18334d();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.f28054m = r0;
        goto L_0x0000;
    L_0x0178:
        r0 = 34;
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r7, r0);
        r2 = r6.f28046e;
        if (r2 != 0) goto L_0x0184;
    L_0x0182:
        r2 = 0;
        goto L_0x0187;
    L_0x0184:
        r2 = r6.f28046e;
        r2 = r2.length;
    L_0x0187:
        r0 = r0 + r2;
        r0 = new com.google.android.gms.internal.ads.aga[r0];
        if (r2 == 0) goto L_0x0191;
    L_0x018c:
        r3 = r6.f28046e;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x0191:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x01a8;
    L_0x0196:
        r1 = new com.google.android.gms.internal.ads.aga;
        r1.<init>();
        r0[r2] = r1;
        r1 = r0[r2];
        r7.m18326a(r1);
        r7.m18324a();
        r2 = r2 + 1;
        goto L_0x0191;
    L_0x01a8:
        r1 = new com.google.android.gms.internal.ads.aga;
        r1.<init>();
        r0[r2] = r1;
        r1 = r0[r2];
        r7.m18326a(r1);
        r6.f28046e = r0;
        goto L_0x0000;
    L_0x01b8:
        r0 = r7.m18335e();
        r6.f28053l = r0;
        goto L_0x0000;
    L_0x01c0:
        r0 = r7.m18335e();
        r6.f28044c = r0;
        goto L_0x0000;
    L_0x01c8:
        r0 = r7.m18335e();
        r6.f28043b = r0;
        goto L_0x0000;
    L_0x01d0:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.afs.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.afs");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int i;
        int i2;
        int i3;
        int a = super.mo3803a();
        if (this.f28043b != null) {
            a += afg.m18352b(1, this.f28043b);
        }
        if (this.f28044c != null) {
            a += afg.m18352b(2, this.f28044c);
        }
        if (this.f28053l != null) {
            a += afg.m18352b(3, this.f28053l);
        }
        if (this.f28046e != null && this.f28046e.length > 0) {
            i = a;
            for (afo afo : this.f28046e) {
                if (afo != null) {
                    i += afg.m18351b(4, afo);
                }
            }
            a = i;
        }
        if (this.f28054m != null) {
            this.f28054m.booleanValue();
            a += afg.m18349b(5) + 1;
        }
        if (this.f28055n != null && this.f28055n.length > 0) {
            i2 = 0;
            int i4 = 0;
            for (String str : this.f28055n) {
                if (str != null) {
                    i4++;
                    i2 += afg.m18345a(str);
                }
            }
            a = (a + i2) + (i4 * 1);
        }
        if (this.f28056o != null) {
            a += afg.m18352b(7, this.f28056o);
        }
        if (this.f28057p != null) {
            this.f28057p.booleanValue();
            a += afg.m18349b(8) + 1;
        }
        if (this.f28058q != null) {
            this.f28058q.booleanValue();
            a += afg.m18349b(9) + 1;
        }
        if (this.f28042a != null) {
            a += afg.m18350b(10, this.f28042a.intValue());
        }
        if (this.f28052k != null) {
            a += afg.m18350b(11, this.f28052k.intValue());
        }
        if (this.f28045d != null) {
            a += afg.m18351b(12, this.f28045d);
        }
        if (this.f28047f != null) {
            a += afg.m18352b(13, this.f28047f);
        }
        if (this.f28048g != null) {
            a += afg.m18351b(14, this.f28048g);
        }
        if (this.f28059r != null) {
            a += afg.m18353b(15, this.f28059r);
        }
        if (this.f28049h != null) {
            a += afg.m18351b(17, this.f28049h);
        }
        if (this.f28050i != null && this.f28050i.length > 0) {
            i3 = 0;
            i2 = 0;
            for (String str2 : this.f28050i) {
                if (str2 != null) {
                    i2++;
                    i3 += afg.m18345a(str2);
                }
            }
            a = (a + i3) + (i2 * 2);
        }
        if (this.f28051j == null || this.f28051j.length <= 0) {
            return a;
        }
        i = 0;
        i3 = 0;
        for (String str3 : this.f28051j) {
            if (str3 != null) {
                i3++;
                i += afg.m18345a(str3);
            }
        }
        return (a + i) + (i3 * 2);
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36746b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28043b != null) {
            afg.m18364a(1, this.f28043b);
        }
        if (this.f28044c != null) {
            afg.m18364a(2, this.f28044c);
        }
        if (this.f28053l != null) {
            afg.m18364a(3, this.f28053l);
        }
        if (this.f28046e != null && this.f28046e.length > 0) {
            for (afo afo : this.f28046e) {
                if (afo != null) {
                    afg.m18363a(4, afo);
                }
            }
        }
        if (this.f28054m != null) {
            afg.m18365a(5, this.f28054m.booleanValue());
        }
        if (this.f28055n != null && this.f28055n.length > 0) {
            for (String str : this.f28055n) {
                if (str != null) {
                    afg.m18364a(6, str);
                }
            }
        }
        if (this.f28056o != null) {
            afg.m18364a(7, this.f28056o);
        }
        if (this.f28057p != null) {
            afg.m18365a(8, this.f28057p.booleanValue());
        }
        if (this.f28058q != null) {
            afg.m18365a(9, this.f28058q.booleanValue());
        }
        if (this.f28042a != null) {
            afg.m18361a(10, this.f28042a.intValue());
        }
        if (this.f28052k != null) {
            afg.m18361a(11, this.f28052k.intValue());
        }
        if (this.f28045d != null) {
            afg.m18363a(12, this.f28045d);
        }
        if (this.f28047f != null) {
            afg.m18364a(13, this.f28047f);
        }
        if (this.f28048g != null) {
            afg.m18363a(14, this.f28048g);
        }
        if (this.f28059r != null) {
            afg.m18366a(15, this.f28059r);
        }
        if (this.f28049h != null) {
            afg.m18363a(17, this.f28049h);
        }
        if (this.f28050i != null && this.f28050i.length > 0) {
            for (String str2 : this.f28050i) {
                if (str2 != null) {
                    afg.m18364a(20, str2);
                }
            }
        }
        if (this.f28051j != null && this.f28051j.length > 0) {
            for (String str3 : this.f28051j) {
                if (str3 != null) {
                    afg.m18364a(21, str3);
                }
            }
        }
        super.mo3804a(afg);
    }
}
