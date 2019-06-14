package com.google.android.gms.internal.ads;

public final class anj extends afi<anj> {
    /* renamed from: a */
    private String f28139a;
    /* renamed from: b */
    private ani[] f28140b;
    /* renamed from: c */
    private Integer f28141c;

    public anj() {
        this.f28139a = null;
        this.f28140b = ani.m36808b();
        this.f28141c = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.anj m36812b(com.google.android.gms.internal.ads.afe r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
    L_0x0000:
        r0 = r5.m18324a();
        if (r0 == 0) goto L_0x0078;
    L_0x0006:
        r1 = 10;
        if (r0 == r1) goto L_0x0071;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x0033;
    L_0x000e:
        r1 = 24;
        if (r0 == r1) goto L_0x0019;
    L_0x0012:
        r0 = super.m29903a(r5, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0018:
        return r4;
    L_0x0019:
        r1 = r5.m18341j();
        r2 = r5.m18338g();	 Catch:{ IllegalArgumentException -> 0x002c }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x002c }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x002c }
        r4.f28141c = r2;	 Catch:{ IllegalArgumentException -> 0x002c }
        goto L_0x0000;
    L_0x002c:
        r5.m18336e(r1);
        r4.m29903a(r5, r0);
        goto L_0x0000;
    L_0x0033:
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r5, r1);
        r1 = r4.f28140b;
        r2 = 0;
        if (r1 != 0) goto L_0x003e;
    L_0x003c:
        r1 = 0;
        goto L_0x0041;
    L_0x003e:
        r1 = r4.f28140b;
        r1 = r1.length;
    L_0x0041:
        r0 = r0 + r1;
        r0 = new com.google.android.gms.internal.ads.ani[r0];
        if (r1 == 0) goto L_0x004b;
    L_0x0046:
        r3 = r4.f28140b;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x004b:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0062;
    L_0x0050:
        r2 = new com.google.android.gms.internal.ads.ani;
        r2.<init>();
        r0[r1] = r2;
        r2 = r0[r1];
        r5.m18326a(r2);
        r5.m18324a();
        r1 = r1 + 1;
        goto L_0x004b;
    L_0x0062:
        r2 = new com.google.android.gms.internal.ads.ani;
        r2.<init>();
        r0[r1] = r2;
        r1 = r0[r1];
        r5.m18326a(r1);
        r4.f28140b = r0;
        goto L_0x0000;
    L_0x0071:
        r0 = r5.m18335e();
        r4.f28139a = r0;
        goto L_0x0000;
    L_0x0078:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.anj.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.anj");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28139a != null) {
            a += afg.m18352b(1, this.f28139a);
        }
        if (this.f28140b != null && this.f28140b.length > 0) {
            for (afo afo : this.f28140b) {
                if (afo != null) {
                    a += afg.m18351b(2, afo);
                }
            }
        }
        return this.f28141c != null ? a + afg.m18350b(3, this.f28141c.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36812b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28139a != null) {
            afg.m18364a(1, this.f28139a);
        }
        if (this.f28140b != null && this.f28140b.length > 0) {
            for (afo afo : this.f28140b) {
                if (afo != null) {
                    afg.m18363a(2, afo);
                }
            }
        }
        if (this.f28141c != null) {
            afg.m18361a(3, this.f28141c.intValue());
        }
        super.mo3804a(afg);
    }
}
