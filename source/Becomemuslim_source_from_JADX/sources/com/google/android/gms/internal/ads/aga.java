package com.google.android.gms.internal.ads;

public final class aga extends afi<aga> {
    /* renamed from: f */
    private static volatile aga[] f28084f;
    /* renamed from: a */
    public Integer f28085a;
    /* renamed from: b */
    public String f28086b;
    /* renamed from: c */
    public afv f28087c;
    /* renamed from: d */
    public Integer f28088d;
    /* renamed from: e */
    public String[] f28089e;
    /* renamed from: g */
    private afx f28090g;
    /* renamed from: h */
    private Integer f28091h;
    /* renamed from: i */
    private int[] f28092i;
    /* renamed from: j */
    private String f28093j;

    public aga() {
        this.f28085a = null;
        this.f28086b = null;
        this.f28087c = null;
        this.f28090g = null;
        this.f28091h = null;
        this.f28092i = afr.f14434a;
        this.f28093j = null;
        this.f28088d = null;
        this.f28089e = afr.f14436c;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.aga m36773b(com.google.android.gms.internal.ads.afe r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
    L_0x0000:
        r0 = r7.m18324a();
        r1 = 0;
        switch(r0) {
            case 0: goto L_0x0133;
            case 8: goto L_0x0127;
            case 18: goto L_0x011f;
            case 26: goto L_0x010d;
            case 34: goto L_0x00ff;
            case 40: goto L_0x00f3;
            case 48: goto L_0x00bf;
            case 50: goto L_0x007d;
            case 58: goto L_0x0076;
            case 64: goto L_0x0042;
            case 74: goto L_0x000f;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = super.m29903a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x000e:
        return r6;
    L_0x000f:
        r0 = 74;
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r7, r0);
        r2 = r6.f28089e;
        if (r2 != 0) goto L_0x001b;
    L_0x0019:
        r2 = 0;
        goto L_0x001e;
    L_0x001b:
        r2 = r6.f28089e;
        r2 = r2.length;
    L_0x001e:
        r0 = r0 + r2;
        r0 = new java.lang.String[r0];
        if (r2 == 0) goto L_0x0028;
    L_0x0023:
        r3 = r6.f28089e;
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
        r6.f28089e = r0;
        goto L_0x0000;
    L_0x0042:
        r1 = r7.m18341j();
        r2 = r7.m18331c();	 Catch:{ IllegalArgumentException -> 0x006f }
        if (r2 < 0) goto L_0x0056;	 Catch:{ IllegalArgumentException -> 0x006f }
    L_0x004c:
        r3 = 3;	 Catch:{ IllegalArgumentException -> 0x006f }
        if (r2 > r3) goto L_0x0056;	 Catch:{ IllegalArgumentException -> 0x006f }
    L_0x004f:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x006f }
        r6.f28088d = r2;	 Catch:{ IllegalArgumentException -> 0x006f }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x006f }
    L_0x0056:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x006f }
        r4 = 46;	 Catch:{ IllegalArgumentException -> 0x006f }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x006f }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x006f }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x006f }
        r2 = " is not a valid enum AdResourceType";	 Catch:{ IllegalArgumentException -> 0x006f }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x006f }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x006f }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x006f }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x006f }
    L_0x006f:
        r7.m18336e(r1);
        r6.m29903a(r7, r0);
        goto L_0x0000;
    L_0x0076:
        r0 = r7.m18335e();
        r6.f28093j = r0;
        goto L_0x0000;
    L_0x007d:
        r0 = r7.m18338g();
        r0 = r7.m18332c(r0);
        r2 = r7.m18341j();
        r3 = 0;
    L_0x008a:
        r4 = r7.m18340i();
        if (r4 <= 0) goto L_0x0096;
    L_0x0090:
        r7.m18331c();
        r3 = r3 + 1;
        goto L_0x008a;
    L_0x0096:
        r7.m18336e(r2);
        r2 = r6.f28092i;
        if (r2 != 0) goto L_0x009f;
    L_0x009d:
        r2 = 0;
        goto L_0x00a2;
    L_0x009f:
        r2 = r6.f28092i;
        r2 = r2.length;
    L_0x00a2:
        r3 = r3 + r2;
        r3 = new int[r3];
        if (r2 == 0) goto L_0x00ac;
    L_0x00a7:
        r4 = r6.f28092i;
        java.lang.System.arraycopy(r4, r1, r3, r1, r2);
    L_0x00ac:
        r1 = r3.length;
        if (r2 >= r1) goto L_0x00b8;
    L_0x00af:
        r1 = r7.m18331c();
        r3[r2] = r1;
        r2 = r2 + 1;
        goto L_0x00ac;
    L_0x00b8:
        r6.f28092i = r3;
        r7.m18333d(r0);
        goto L_0x0000;
    L_0x00bf:
        r0 = 48;
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r7, r0);
        r2 = r6.f28092i;
        if (r2 != 0) goto L_0x00cb;
    L_0x00c9:
        r2 = 0;
        goto L_0x00ce;
    L_0x00cb:
        r2 = r6.f28092i;
        r2 = r2.length;
    L_0x00ce:
        r0 = r0 + r2;
        r0 = new int[r0];
        if (r2 == 0) goto L_0x00d8;
    L_0x00d3:
        r3 = r6.f28092i;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x00d8:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x00e9;
    L_0x00dd:
        r1 = r7.m18331c();
        r0[r2] = r1;
        r7.m18324a();
        r2 = r2 + 1;
        goto L_0x00d8;
    L_0x00e9:
        r1 = r7.m18331c();
        r0[r2] = r1;
        r6.f28092i = r0;
        goto L_0x0000;
    L_0x00f3:
        r0 = r7.m18331c();
        r0 = java.lang.Integer.valueOf(r0);
        r6.f28091h = r0;
        goto L_0x0000;
    L_0x00ff:
        r0 = r6.f28090g;
        if (r0 != 0) goto L_0x010a;
    L_0x0103:
        r0 = new com.google.android.gms.internal.ads.afx;
        r0.<init>();
        r6.f28090g = r0;
    L_0x010a:
        r0 = r6.f28090g;
        goto L_0x011a;
    L_0x010d:
        r0 = r6.f28087c;
        if (r0 != 0) goto L_0x0118;
    L_0x0111:
        r0 = new com.google.android.gms.internal.ads.afv;
        r0.<init>();
        r6.f28087c = r0;
    L_0x0118:
        r0 = r6.f28087c;
    L_0x011a:
        r7.m18326a(r0);
        goto L_0x0000;
    L_0x011f:
        r0 = r7.m18335e();
        r6.f28086b = r0;
        goto L_0x0000;
    L_0x0127:
        r0 = r7.m18331c();
        r0 = java.lang.Integer.valueOf(r0);
        r6.f28085a = r0;
        goto L_0x0000;
    L_0x0133:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aga.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.aga");
    }

    /* renamed from: b */
    public static aga[] m36774b() {
        if (f28084f == null) {
            synchronized (afm.f14429b) {
                if (f28084f == null) {
                    f28084f = new aga[0];
                }
            }
        }
        return f28084f;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int i;
        int i2;
        int a = super.mo3803a() + afg.m18350b(1, this.f28085a.intValue());
        if (this.f28086b != null) {
            a += afg.m18352b(2, this.f28086b);
        }
        if (this.f28087c != null) {
            a += afg.m18351b(3, this.f28087c);
        }
        if (this.f28090g != null) {
            a += afg.m18351b(4, this.f28090g);
        }
        if (this.f28091h != null) {
            a += afg.m18350b(5, this.f28091h.intValue());
        }
        if (this.f28092i != null && this.f28092i.length > 0) {
            i = 0;
            for (int a2 : this.f28092i) {
                i += afg.m18342a(a2);
            }
            a = (a + i) + (this.f28092i.length * 1);
        }
        if (this.f28093j != null) {
            a += afg.m18352b(7, this.f28093j);
        }
        if (this.f28088d != null) {
            a += afg.m18350b(8, this.f28088d.intValue());
        }
        if (this.f28089e == null || this.f28089e.length <= 0) {
            return a;
        }
        i2 = 0;
        i = 0;
        for (String str : this.f28089e) {
            if (str != null) {
                i++;
                i2 += afg.m18345a(str);
            }
        }
        return (a + i2) + (i * 1);
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36773b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        afg.m18361a(1, this.f28085a.intValue());
        if (this.f28086b != null) {
            afg.m18364a(2, this.f28086b);
        }
        if (this.f28087c != null) {
            afg.m18363a(3, this.f28087c);
        }
        if (this.f28090g != null) {
            afg.m18363a(4, this.f28090g);
        }
        if (this.f28091h != null) {
            afg.m18361a(5, this.f28091h.intValue());
        }
        if (this.f28092i != null && this.f28092i.length > 0) {
            for (int a : this.f28092i) {
                afg.m18361a(6, a);
            }
        }
        if (this.f28093j != null) {
            afg.m18364a(7, this.f28093j);
        }
        if (this.f28088d != null) {
            afg.m18361a(8, this.f28088d.intValue());
        }
        if (this.f28089e != null && this.f28089e.length > 0) {
            for (String str : this.f28089e) {
                if (str != null) {
                    afg.m18364a(9, str);
                }
            }
        }
        super.mo3804a(afg);
    }
}
