package com.google.android.gms.internal.ads;

public final class ans extends afi<ans> {
    /* renamed from: a */
    private Integer f28185a;
    /* renamed from: b */
    private Integer f28186b;

    public ans() {
        this.f28185a = null;
        this.f28186b = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.ans m36847b(com.google.android.gms.internal.ads.afe r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
    L_0x0000:
        r0 = r7.m18324a();
        if (r0 == 0) goto L_0x007b;
    L_0x0006:
        r1 = 8;
        r2 = 2;
        if (r0 == r1) goto L_0x0048;
    L_0x000b:
        r1 = 16;
        if (r0 == r1) goto L_0x0016;
    L_0x000f:
        r0 = super.m29903a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0015:
        return r6;
    L_0x0016:
        r1 = r7.m18341j();
        r3 = r7.m18338g();	 Catch:{ IllegalArgumentException -> 0x0074 }
        if (r3 < 0) goto L_0x0023;	 Catch:{ IllegalArgumentException -> 0x0074 }
    L_0x0020:
        if (r3 > r2) goto L_0x0023;	 Catch:{ IllegalArgumentException -> 0x0074 }
    L_0x0022:
        goto L_0x0028;	 Catch:{ IllegalArgumentException -> 0x0074 }
    L_0x0023:
        r2 = 4;	 Catch:{ IllegalArgumentException -> 0x0074 }
        if (r3 < r2) goto L_0x002f;	 Catch:{ IllegalArgumentException -> 0x0074 }
    L_0x0026:
        if (r3 > r2) goto L_0x002f;	 Catch:{ IllegalArgumentException -> 0x0074 }
    L_0x0028:
        r2 = java.lang.Integer.valueOf(r3);	 Catch:{ IllegalArgumentException -> 0x0074 }
        r6.f28186b = r2;	 Catch:{ IllegalArgumentException -> 0x0074 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0074 }
    L_0x002f:
        r2 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0074 }
        r4 = 51;	 Catch:{ IllegalArgumentException -> 0x0074 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0074 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0074 }
        r5.append(r3);	 Catch:{ IllegalArgumentException -> 0x0074 }
        r3 = " is not a valid enum CellularNetworkType";	 Catch:{ IllegalArgumentException -> 0x0074 }
        r5.append(r3);	 Catch:{ IllegalArgumentException -> 0x0074 }
        r3 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0074 }
        r2.<init>(r3);	 Catch:{ IllegalArgumentException -> 0x0074 }
        throw r2;	 Catch:{ IllegalArgumentException -> 0x0074 }
    L_0x0048:
        r1 = r7.m18341j();
        r3 = r7.m18338g();	 Catch:{ IllegalArgumentException -> 0x0074 }
        if (r3 < 0) goto L_0x005b;	 Catch:{ IllegalArgumentException -> 0x0074 }
    L_0x0052:
        if (r3 > r2) goto L_0x005b;	 Catch:{ IllegalArgumentException -> 0x0074 }
    L_0x0054:
        r2 = java.lang.Integer.valueOf(r3);	 Catch:{ IllegalArgumentException -> 0x0074 }
        r6.f28185a = r2;	 Catch:{ IllegalArgumentException -> 0x0074 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0074 }
    L_0x005b:
        r2 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0074 }
        r4 = 43;	 Catch:{ IllegalArgumentException -> 0x0074 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0074 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0074 }
        r5.append(r3);	 Catch:{ IllegalArgumentException -> 0x0074 }
        r3 = " is not a valid enum NetworkType";	 Catch:{ IllegalArgumentException -> 0x0074 }
        r5.append(r3);	 Catch:{ IllegalArgumentException -> 0x0074 }
        r3 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0074 }
        r2.<init>(r3);	 Catch:{ IllegalArgumentException -> 0x0074 }
        throw r2;	 Catch:{ IllegalArgumentException -> 0x0074 }
    L_0x0074:
        r7.m18336e(r1);
        r6.m29903a(r7, r0);
        goto L_0x0000;
    L_0x007b:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ans.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.ans");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28185a != null) {
            a += afg.m18350b(1, this.f28185a.intValue());
        }
        return this.f28186b != null ? a + afg.m18350b(2, this.f28186b.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36847b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28185a != null) {
            afg.m18361a(1, this.f28185a.intValue());
        }
        if (this.f28186b != null) {
            afg.m18361a(2, this.f28186b.intValue());
        }
        super.mo3804a(afg);
    }
}
