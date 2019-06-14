package com.google.android.gms.internal.ads;

public final class aoi extends afi<aoi> {
    /* renamed from: a */
    private Integer f28253a;
    /* renamed from: b */
    private aoc f28254b;
    /* renamed from: c */
    private any f28255c;

    public aoi() {
        this.f28253a = null;
        this.f28254b = null;
        this.f28255c = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.aoi m36905b(com.google.android.gms.internal.ads.afe r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = r4.m18324a();
        if (r0 == 0) goto L_0x0052;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0038;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x0027;
    L_0x000e:
        r1 = 26;
        if (r0 == r1) goto L_0x0019;
    L_0x0012:
        r0 = super.m29903a(r4, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0018:
        return r3;
    L_0x0019:
        r0 = r3.f28255c;
        if (r0 != 0) goto L_0x0024;
    L_0x001d:
        r0 = new com.google.android.gms.internal.ads.any;
        r0.<init>();
        r3.f28255c = r0;
    L_0x0024:
        r0 = r3.f28255c;
        goto L_0x0034;
    L_0x0027:
        r0 = r3.f28254b;
        if (r0 != 0) goto L_0x0032;
    L_0x002b:
        r0 = new com.google.android.gms.internal.ads.aoc;
        r0.<init>();
        r3.f28254b = r0;
    L_0x0032:
        r0 = r3.f28254b;
    L_0x0034:
        r4.m18326a(r0);
        goto L_0x0000;
    L_0x0038:
        r1 = r4.m18341j();
        r2 = r4.m18338g();	 Catch:{ IllegalArgumentException -> 0x004b }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x004b }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x004b }
        r3.f28253a = r2;	 Catch:{ IllegalArgumentException -> 0x004b }
        goto L_0x0000;
    L_0x004b:
        r4.m18336e(r1);
        r3.m29903a(r4, r0);
        goto L_0x0000;
    L_0x0052:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aoi.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.aoi");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28253a != null) {
            a += afg.m18350b(1, this.f28253a.intValue());
        }
        if (this.f28254b != null) {
            a += afg.m18351b(2, this.f28254b);
        }
        return this.f28255c != null ? a + afg.m18351b(3, this.f28255c) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36905b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28253a != null) {
            afg.m18361a(1, this.f28253a.intValue());
        }
        if (this.f28254b != null) {
            afg.m18363a(2, this.f28254b);
        }
        if (this.f28255c != null) {
            afg.m18363a(3, this.f28255c);
        }
        super.mo3804a(afg);
    }
}
