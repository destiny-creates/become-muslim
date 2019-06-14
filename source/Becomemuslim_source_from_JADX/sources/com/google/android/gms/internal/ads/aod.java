package com.google.android.gms.internal.ads;

public final class aod extends afi<aod> {
    /* renamed from: a */
    private anz f28235a;
    /* renamed from: b */
    private Integer f28236b;
    /* renamed from: c */
    private aoc f28237c;
    /* renamed from: d */
    private any f28238d;

    public aod() {
        this.f28235a = null;
        this.f28236b = null;
        this.f28237c = null;
        this.f28238d = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.aod m36889b(com.google.android.gms.internal.ads.afe r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = r4.m18324a();
        if (r0 == 0) goto L_0x0064;
    L_0x0006:
        r1 = 10;
        if (r0 == r1) goto L_0x0053;
    L_0x000a:
        r1 = 16;
        if (r0 == r1) goto L_0x0039;
    L_0x000e:
        r1 = 26;
        if (r0 == r1) goto L_0x002b;
    L_0x0012:
        r1 = 34;
        if (r0 == r1) goto L_0x001d;
    L_0x0016:
        r0 = super.m29903a(r4, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x001c:
        return r3;
    L_0x001d:
        r0 = r3.f28238d;
        if (r0 != 0) goto L_0x0028;
    L_0x0021:
        r0 = new com.google.android.gms.internal.ads.any;
        r0.<init>();
        r3.f28238d = r0;
    L_0x0028:
        r0 = r3.f28238d;
        goto L_0x0060;
    L_0x002b:
        r0 = r3.f28237c;
        if (r0 != 0) goto L_0x0036;
    L_0x002f:
        r0 = new com.google.android.gms.internal.ads.aoc;
        r0.<init>();
        r3.f28237c = r0;
    L_0x0036:
        r0 = r3.f28237c;
        goto L_0x0060;
    L_0x0039:
        r1 = r4.m18341j();
        r2 = r4.m18338g();	 Catch:{ IllegalArgumentException -> 0x004c }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x004c }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x004c }
        r3.f28236b = r2;	 Catch:{ IllegalArgumentException -> 0x004c }
        goto L_0x0000;
    L_0x004c:
        r4.m18336e(r1);
        r3.m29903a(r4, r0);
        goto L_0x0000;
    L_0x0053:
        r0 = r3.f28235a;
        if (r0 != 0) goto L_0x005e;
    L_0x0057:
        r0 = new com.google.android.gms.internal.ads.anz;
        r0.<init>();
        r3.f28235a = r0;
    L_0x005e:
        r0 = r3.f28235a;
    L_0x0060:
        r4.m18326a(r0);
        goto L_0x0000;
    L_0x0064:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aod.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.aod");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28235a != null) {
            a += afg.m18351b(1, this.f28235a);
        }
        if (this.f28236b != null) {
            a += afg.m18350b(2, this.f28236b.intValue());
        }
        if (this.f28237c != null) {
            a += afg.m18351b(3, this.f28237c);
        }
        return this.f28238d != null ? a + afg.m18351b(4, this.f28238d) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36889b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28235a != null) {
            afg.m18363a(1, this.f28235a);
        }
        if (this.f28236b != null) {
            afg.m18361a(2, this.f28236b.intValue());
        }
        if (this.f28237c != null) {
            afg.m18363a(3, this.f28237c);
        }
        if (this.f28238d != null) {
            afg.m18363a(4, this.f28238d);
        }
        super.mo3804a(afg);
    }
}
