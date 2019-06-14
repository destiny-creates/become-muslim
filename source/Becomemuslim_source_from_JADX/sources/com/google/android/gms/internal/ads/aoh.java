package com.google.android.gms.internal.ads;

public final class aoh extends afi<aoh> {
    /* renamed from: a */
    private Integer f28247a;
    /* renamed from: b */
    private aoc f28248b;
    /* renamed from: c */
    private Integer f28249c;
    /* renamed from: d */
    private Integer f28250d;
    /* renamed from: e */
    private Integer f28251e;
    /* renamed from: f */
    private Long f28252f;

    public aoh() {
        this.f28247a = null;
        this.f28248b = null;
        this.f28249c = null;
        this.f28250d = null;
        this.f28251e = null;
        this.f28252f = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.aoh m36901b(com.google.android.gms.internal.ads.afe r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = r4.m18324a();
        if (r0 == 0) goto L_0x007c;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0062;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x0051;
    L_0x000e:
        r1 = 24;
        if (r0 == r1) goto L_0x0046;
    L_0x0012:
        r1 = 32;
        if (r0 == r1) goto L_0x003b;
    L_0x0016:
        r1 = 40;
        if (r0 == r1) goto L_0x0030;
    L_0x001a:
        r1 = 48;
        if (r0 == r1) goto L_0x0025;
    L_0x001e:
        r0 = super.m29903a(r4, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0024:
        return r3;
    L_0x0025:
        r0 = r4.m18339h();
        r0 = java.lang.Long.valueOf(r0);
        r3.f28252f = r0;
        goto L_0x0000;
    L_0x0030:
        r0 = r4.m18338g();
        r0 = java.lang.Integer.valueOf(r0);
        r3.f28251e = r0;
        goto L_0x0000;
    L_0x003b:
        r0 = r4.m18338g();
        r0 = java.lang.Integer.valueOf(r0);
        r3.f28250d = r0;
        goto L_0x0000;
    L_0x0046:
        r0 = r4.m18338g();
        r0 = java.lang.Integer.valueOf(r0);
        r3.f28249c = r0;
        goto L_0x0000;
    L_0x0051:
        r0 = r3.f28248b;
        if (r0 != 0) goto L_0x005c;
    L_0x0055:
        r0 = new com.google.android.gms.internal.ads.aoc;
        r0.<init>();
        r3.f28248b = r0;
    L_0x005c:
        r0 = r3.f28248b;
        r4.m18326a(r0);
        goto L_0x0000;
    L_0x0062:
        r1 = r4.m18341j();
        r2 = r4.m18338g();	 Catch:{ IllegalArgumentException -> 0x0075 }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x0075 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0075 }
        r3.f28247a = r2;	 Catch:{ IllegalArgumentException -> 0x0075 }
        goto L_0x0000;
    L_0x0075:
        r4.m18336e(r1);
        r3.m29903a(r4, r0);
        goto L_0x0000;
    L_0x007c:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aoh.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.aoh");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28247a != null) {
            a += afg.m18350b(1, this.f28247a.intValue());
        }
        if (this.f28248b != null) {
            a += afg.m18351b(2, this.f28248b);
        }
        if (this.f28249c != null) {
            a += afg.m18350b(3, this.f28249c.intValue());
        }
        if (this.f28250d != null) {
            a += afg.m18350b(4, this.f28250d.intValue());
        }
        if (this.f28251e != null) {
            a += afg.m18350b(5, this.f28251e.intValue());
        }
        return this.f28252f != null ? a + afg.m18356c(6, this.f28252f.longValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36901b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28247a != null) {
            afg.m18361a(1, this.f28247a.intValue());
        }
        if (this.f28248b != null) {
            afg.m18363a(2, this.f28248b);
        }
        if (this.f28249c != null) {
            afg.m18361a(3, this.f28249c.intValue());
        }
        if (this.f28250d != null) {
            afg.m18361a(4, this.f28250d.intValue());
        }
        if (this.f28251e != null) {
            afg.m18361a(5, this.f28251e.intValue());
        }
        if (this.f28252f != null) {
            afg.m18362a(6, this.f28252f.longValue());
        }
        super.mo3804a(afg);
    }
}
