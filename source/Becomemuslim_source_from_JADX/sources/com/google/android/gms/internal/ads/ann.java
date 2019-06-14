package com.google.android.gms.internal.ads;

public final class ann extends afi<ann> {
    /* renamed from: a */
    private Integer f28161a;
    /* renamed from: b */
    private anz f28162b;
    /* renamed from: c */
    private String f28163c;
    /* renamed from: d */
    private String f28164d;

    public ann() {
        this.f28161a = null;
        this.f28162b = null;
        this.f28163c = null;
        this.f28164d = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.ann m36827b(com.google.android.gms.internal.ads.afe r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
    L_0x0000:
        r0 = r7.m18324a();
        if (r0 == 0) goto L_0x006e;
    L_0x0006:
        r1 = 40;
        if (r0 == r1) goto L_0x003c;
    L_0x000a:
        r1 = 50;
        if (r0 == r1) goto L_0x002b;
    L_0x000e:
        r1 = 58;
        if (r0 == r1) goto L_0x0024;
    L_0x0012:
        r1 = 66;
        if (r0 == r1) goto L_0x001d;
    L_0x0016:
        r0 = super.m29903a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x001c:
        return r6;
    L_0x001d:
        r0 = r7.m18335e();
        r6.f28164d = r0;
        goto L_0x0000;
    L_0x0024:
        r0 = r7.m18335e();
        r6.f28163c = r0;
        goto L_0x0000;
    L_0x002b:
        r0 = r6.f28162b;
        if (r0 != 0) goto L_0x0036;
    L_0x002f:
        r0 = new com.google.android.gms.internal.ads.anz;
        r0.<init>();
        r6.f28162b = r0;
    L_0x0036:
        r0 = r6.f28162b;
        r7.m18326a(r0);
        goto L_0x0000;
    L_0x003c:
        r2 = r7.m18341j();
        r3 = r7.m18338g();	 Catch:{ IllegalArgumentException -> 0x0067 }
        if (r3 < 0) goto L_0x0050;	 Catch:{ IllegalArgumentException -> 0x0067 }
    L_0x0046:
        r4 = 2;	 Catch:{ IllegalArgumentException -> 0x0067 }
        if (r3 > r4) goto L_0x0050;	 Catch:{ IllegalArgumentException -> 0x0067 }
    L_0x0049:
        r1 = java.lang.Integer.valueOf(r3);	 Catch:{ IllegalArgumentException -> 0x0067 }
        r6.f28161a = r1;	 Catch:{ IllegalArgumentException -> 0x0067 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0067 }
    L_0x0050:
        r4 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0067 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0067 }
        r5.<init>(r1);	 Catch:{ IllegalArgumentException -> 0x0067 }
        r5.append(r3);	 Catch:{ IllegalArgumentException -> 0x0067 }
        r1 = " is not a valid enum Platform";	 Catch:{ IllegalArgumentException -> 0x0067 }
        r5.append(r1);	 Catch:{ IllegalArgumentException -> 0x0067 }
        r1 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0067 }
        r4.<init>(r1);	 Catch:{ IllegalArgumentException -> 0x0067 }
        throw r4;	 Catch:{ IllegalArgumentException -> 0x0067 }
    L_0x0067:
        r7.m18336e(r2);
        r6.m29903a(r7, r0);
        goto L_0x0000;
    L_0x006e:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ann.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.ann");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28161a != null) {
            a += afg.m18350b(5, this.f28161a.intValue());
        }
        if (this.f28162b != null) {
            a += afg.m18351b(6, this.f28162b);
        }
        if (this.f28163c != null) {
            a += afg.m18352b(7, this.f28163c);
        }
        return this.f28164d != null ? a + afg.m18352b(8, this.f28164d) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36827b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28161a != null) {
            afg.m18361a(5, this.f28161a.intValue());
        }
        if (this.f28162b != null) {
            afg.m18363a(6, this.f28162b);
        }
        if (this.f28163c != null) {
            afg.m18364a(7, this.f28163c);
        }
        if (this.f28164d != null) {
            afg.m18364a(8, this.f28164d);
        }
        super.mo3804a(afg);
    }
}
