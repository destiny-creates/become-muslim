package com.google.android.gms.internal.ads;

public final class aoe extends afi<aoe> {
    /* renamed from: a */
    private Integer f28239a;
    /* renamed from: b */
    private aoc f28240b;
    /* renamed from: c */
    private Integer f28241c;
    /* renamed from: d */
    private Integer f28242d;
    /* renamed from: e */
    private Integer f28243e;

    public aoe() {
        this.f28239a = null;
        this.f28240b = null;
        this.f28241c = null;
        this.f28242d = null;
        this.f28243e = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.aoe m36893b(com.google.android.gms.internal.ads.afe r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = r4.m18324a();
        if (r0 == 0) goto L_0x006d;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0053;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x0042;
    L_0x000e:
        r1 = 24;
        if (r0 == r1) goto L_0x0037;
    L_0x0012:
        r1 = 32;
        if (r0 == r1) goto L_0x002c;
    L_0x0016:
        r1 = 40;
        if (r0 == r1) goto L_0x0021;
    L_0x001a:
        r0 = super.m29903a(r4, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0020:
        return r3;
    L_0x0021:
        r0 = r4.m18338g();
        r0 = java.lang.Integer.valueOf(r0);
        r3.f28243e = r0;
        goto L_0x0000;
    L_0x002c:
        r0 = r4.m18338g();
        r0 = java.lang.Integer.valueOf(r0);
        r3.f28242d = r0;
        goto L_0x0000;
    L_0x0037:
        r0 = r4.m18338g();
        r0 = java.lang.Integer.valueOf(r0);
        r3.f28241c = r0;
        goto L_0x0000;
    L_0x0042:
        r0 = r3.f28240b;
        if (r0 != 0) goto L_0x004d;
    L_0x0046:
        r0 = new com.google.android.gms.internal.ads.aoc;
        r0.<init>();
        r3.f28240b = r0;
    L_0x004d:
        r0 = r3.f28240b;
        r4.m18326a(r0);
        goto L_0x0000;
    L_0x0053:
        r1 = r4.m18341j();
        r2 = r4.m18338g();	 Catch:{ IllegalArgumentException -> 0x0066 }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x0066 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0066 }
        r3.f28239a = r2;	 Catch:{ IllegalArgumentException -> 0x0066 }
        goto L_0x0000;
    L_0x0066:
        r4.m18336e(r1);
        r3.m29903a(r4, r0);
        goto L_0x0000;
    L_0x006d:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aoe.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.aoe");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28239a != null) {
            a += afg.m18350b(1, this.f28239a.intValue());
        }
        if (this.f28240b != null) {
            a += afg.m18351b(2, this.f28240b);
        }
        if (this.f28241c != null) {
            a += afg.m18350b(3, this.f28241c.intValue());
        }
        if (this.f28242d != null) {
            a += afg.m18350b(4, this.f28242d.intValue());
        }
        return this.f28243e != null ? a + afg.m18350b(5, this.f28243e.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36893b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28239a != null) {
            afg.m18361a(1, this.f28239a.intValue());
        }
        if (this.f28240b != null) {
            afg.m18363a(2, this.f28240b);
        }
        if (this.f28241c != null) {
            afg.m18361a(3, this.f28241c.intValue());
        }
        if (this.f28242d != null) {
            afg.m18361a(4, this.f28242d.intValue());
        }
        if (this.f28243e != null) {
            afg.m18361a(5, this.f28243e.intValue());
        }
        super.mo3804a(afg);
    }
}
