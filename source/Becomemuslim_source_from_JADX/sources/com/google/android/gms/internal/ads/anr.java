package com.google.android.gms.internal.ads;

public final class anr extends afi<anr> {
    /* renamed from: a */
    private anp f28181a;
    /* renamed from: b */
    private anx[] f28182b;
    /* renamed from: c */
    private Integer f28183c;
    /* renamed from: d */
    private any f28184d;

    public anr() {
        this.f28181a = null;
        this.f28182b = anx.m36866b();
        this.f28183c = null;
        this.f28184d = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.anr m36843b(com.google.android.gms.internal.ads.afe r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
    L_0x0000:
        r0 = r5.m18324a();
        if (r0 == 0) goto L_0x0096;
    L_0x0006:
        r1 = 10;
        if (r0 == r1) goto L_0x0084;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x0045;
    L_0x000e:
        r1 = 24;
        if (r0 == r1) goto L_0x002b;
    L_0x0012:
        r1 = 34;
        if (r0 == r1) goto L_0x001d;
    L_0x0016:
        r0 = super.m29903a(r5, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x001c:
        return r4;
    L_0x001d:
        r0 = r4.f28184d;
        if (r0 != 0) goto L_0x0028;
    L_0x0021:
        r0 = new com.google.android.gms.internal.ads.any;
        r0.<init>();
        r4.f28184d = r0;
    L_0x0028:
        r0 = r4.f28184d;
        goto L_0x0091;
    L_0x002b:
        r1 = r5.m18341j();
        r2 = r5.m18338g();	 Catch:{ IllegalArgumentException -> 0x003e }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x003e }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x003e }
        r4.f28183c = r2;	 Catch:{ IllegalArgumentException -> 0x003e }
        goto L_0x0000;
    L_0x003e:
        r5.m18336e(r1);
        r4.m29903a(r5, r0);
        goto L_0x0000;
    L_0x0045:
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r5, r1);
        r1 = r4.f28182b;
        r2 = 0;
        if (r1 != 0) goto L_0x0050;
    L_0x004e:
        r1 = 0;
        goto L_0x0053;
    L_0x0050:
        r1 = r4.f28182b;
        r1 = r1.length;
    L_0x0053:
        r0 = r0 + r1;
        r0 = new com.google.android.gms.internal.ads.anx[r0];
        if (r1 == 0) goto L_0x005d;
    L_0x0058:
        r3 = r4.f28182b;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x005d:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0074;
    L_0x0062:
        r2 = new com.google.android.gms.internal.ads.anx;
        r2.<init>();
        r0[r1] = r2;
        r2 = r0[r1];
        r5.m18326a(r2);
        r5.m18324a();
        r1 = r1 + 1;
        goto L_0x005d;
    L_0x0074:
        r2 = new com.google.android.gms.internal.ads.anx;
        r2.<init>();
        r0[r1] = r2;
        r1 = r0[r1];
        r5.m18326a(r1);
        r4.f28182b = r0;
        goto L_0x0000;
    L_0x0084:
        r0 = r4.f28181a;
        if (r0 != 0) goto L_0x008f;
    L_0x0088:
        r0 = new com.google.android.gms.internal.ads.anp;
        r0.<init>();
        r4.f28181a = r0;
    L_0x008f:
        r0 = r4.f28181a;
    L_0x0091:
        r5.m18326a(r0);
        goto L_0x0000;
    L_0x0096:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.anr.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.anr");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28181a != null) {
            a += afg.m18351b(1, this.f28181a);
        }
        if (this.f28182b != null && this.f28182b.length > 0) {
            for (afo afo : this.f28182b) {
                if (afo != null) {
                    a += afg.m18351b(2, afo);
                }
            }
        }
        if (this.f28183c != null) {
            a += afg.m18350b(3, this.f28183c.intValue());
        }
        return this.f28184d != null ? a + afg.m18351b(4, this.f28184d) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36843b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28181a != null) {
            afg.m18363a(1, this.f28181a);
        }
        if (this.f28182b != null && this.f28182b.length > 0) {
            for (afo afo : this.f28182b) {
                if (afo != null) {
                    afg.m18363a(2, afo);
                }
            }
        }
        if (this.f28183c != null) {
            afg.m18361a(3, this.f28183c.intValue());
        }
        if (this.f28184d != null) {
            afg.m18363a(4, this.f28184d);
        }
        super.mo3804a(afg);
    }
}
