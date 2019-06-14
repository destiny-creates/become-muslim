package com.google.android.gms.internal.ads;

public final class anx extends afi<anx> {
    /* renamed from: a */
    private static volatile anx[] f28204a;
    /* renamed from: b */
    private String f28205b;
    /* renamed from: c */
    private Integer f28206c;
    /* renamed from: d */
    private any f28207d;

    public anx() {
        this.f28205b = null;
        this.f28206c = null;
        this.f28207d = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.anx m36865b(com.google.android.gms.internal.ads.afe r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = r4.m18324a();
        if (r0 == 0) goto L_0x004b;
    L_0x0006:
        r1 = 10;
        if (r0 == r1) goto L_0x0044;
    L_0x000a:
        r1 = 16;
        if (r0 == r1) goto L_0x002a;
    L_0x000e:
        r1 = 26;
        if (r0 == r1) goto L_0x0019;
    L_0x0012:
        r0 = super.m29903a(r4, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0018:
        return r3;
    L_0x0019:
        r0 = r3.f28207d;
        if (r0 != 0) goto L_0x0024;
    L_0x001d:
        r0 = new com.google.android.gms.internal.ads.any;
        r0.<init>();
        r3.f28207d = r0;
    L_0x0024:
        r0 = r3.f28207d;
        r4.m18326a(r0);
        goto L_0x0000;
    L_0x002a:
        r1 = r4.m18341j();
        r2 = r4.m18338g();	 Catch:{ IllegalArgumentException -> 0x003d }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x003d }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x003d }
        r3.f28206c = r2;	 Catch:{ IllegalArgumentException -> 0x003d }
        goto L_0x0000;
    L_0x003d:
        r4.m18336e(r1);
        r3.m29903a(r4, r0);
        goto L_0x0000;
    L_0x0044:
        r0 = r4.m18335e();
        r3.f28205b = r0;
        goto L_0x0000;
    L_0x004b:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.anx.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.anx");
    }

    /* renamed from: b */
    public static anx[] m36866b() {
        if (f28204a == null) {
            synchronized (afm.f14429b) {
                if (f28204a == null) {
                    f28204a = new anx[0];
                }
            }
        }
        return f28204a;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28205b != null) {
            a += afg.m18352b(1, this.f28205b);
        }
        if (this.f28206c != null) {
            a += afg.m18350b(2, this.f28206c.intValue());
        }
        return this.f28207d != null ? a + afg.m18351b(3, this.f28207d) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36865b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28205b != null) {
            afg.m18364a(1, this.f28205b);
        }
        if (this.f28206c != null) {
            afg.m18361a(2, this.f28206c.intValue());
        }
        if (this.f28207d != null) {
            afg.m18363a(3, this.f28207d);
        }
        super.mo3804a(afg);
    }
}
