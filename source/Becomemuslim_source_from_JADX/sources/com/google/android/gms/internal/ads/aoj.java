package com.google.android.gms.internal.ads;

public final class aoj extends afi<aoj> {
    /* renamed from: a */
    private Integer f28256a;
    /* renamed from: b */
    private aoc f28257b;

    public aoj() {
        this.f28256a = null;
        this.f28257b = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.aoj m36909b(com.google.android.gms.internal.ads.afe r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = r4.m18324a();
        if (r0 == 0) goto L_0x0040;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0026;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x0015;
    L_0x000e:
        r0 = super.m29903a(r4, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0014:
        return r3;
    L_0x0015:
        r0 = r3.f28257b;
        if (r0 != 0) goto L_0x0020;
    L_0x0019:
        r0 = new com.google.android.gms.internal.ads.aoc;
        r0.<init>();
        r3.f28257b = r0;
    L_0x0020:
        r0 = r3.f28257b;
        r4.m18326a(r0);
        goto L_0x0000;
    L_0x0026:
        r1 = r4.m18341j();
        r2 = r4.m18338g();	 Catch:{ IllegalArgumentException -> 0x0039 }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x0039 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0039 }
        r3.f28256a = r2;	 Catch:{ IllegalArgumentException -> 0x0039 }
        goto L_0x0000;
    L_0x0039:
        r4.m18336e(r1);
        r3.m29903a(r4, r0);
        goto L_0x0000;
    L_0x0040:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aoj.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.aoj");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28256a != null) {
            a += afg.m18350b(1, this.f28256a.intValue());
        }
        return this.f28257b != null ? a + afg.m18351b(2, this.f28257b) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36909b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28256a != null) {
            afg.m18361a(1, this.f28256a.intValue());
        }
        if (this.f28257b != null) {
            afg.m18363a(2, this.f28257b);
        }
        super.mo3804a(afg);
    }
}
