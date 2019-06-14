package com.google.android.gms.internal.ads;

public final class anq extends afi<anq> {
    /* renamed from: a */
    private Integer f28179a;
    /* renamed from: b */
    private int[] f28180b;

    public anq() {
        this.f28179a = null;
        this.f28180b = afr.f14434a;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.anq m36839b(com.google.android.gms.internal.ads.afe r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
    L_0x0000:
        r0 = r6.m18324a();
        if (r0 == 0) goto L_0x00a9;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x008d;
    L_0x000a:
        r1 = 16;
        r2 = 0;
        if (r0 == r1) goto L_0x005b;
    L_0x000f:
        r1 = 18;
        if (r0 == r1) goto L_0x001a;
    L_0x0013:
        r0 = super.m29903a(r6, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0019:
        return r5;
    L_0x001a:
        r0 = r6.m18338g();
        r0 = r6.m18332c(r0);
        r1 = r6.m18341j();
        r3 = 0;
    L_0x0027:
        r4 = r6.m18340i();
        if (r4 <= 0) goto L_0x0033;
    L_0x002d:
        r6.m18338g();
        r3 = r3 + 1;
        goto L_0x0027;
    L_0x0033:
        r6.m18336e(r1);
        r1 = r5.f28180b;
        if (r1 != 0) goto L_0x003c;
    L_0x003a:
        r1 = 0;
        goto L_0x003f;
    L_0x003c:
        r1 = r5.f28180b;
        r1 = r1.length;
    L_0x003f:
        r3 = r3 + r1;
        r3 = new int[r3];
        if (r1 == 0) goto L_0x0049;
    L_0x0044:
        r4 = r5.f28180b;
        java.lang.System.arraycopy(r4, r2, r3, r2, r1);
    L_0x0049:
        r2 = r3.length;
        if (r1 >= r2) goto L_0x0055;
    L_0x004c:
        r2 = r6.m18338g();
        r3[r1] = r2;
        r1 = r1 + 1;
        goto L_0x0049;
    L_0x0055:
        r5.f28180b = r3;
        r6.m18333d(r0);
        goto L_0x0000;
    L_0x005b:
        r0 = com.google.android.gms.internal.ads.afr.m18397a(r6, r1);
        r1 = r5.f28180b;
        if (r1 != 0) goto L_0x0065;
    L_0x0063:
        r1 = 0;
        goto L_0x0068;
    L_0x0065:
        r1 = r5.f28180b;
        r1 = r1.length;
    L_0x0068:
        r0 = r0 + r1;
        r0 = new int[r0];
        if (r1 == 0) goto L_0x0072;
    L_0x006d:
        r3 = r5.f28180b;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x0072:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0083;
    L_0x0077:
        r2 = r6.m18338g();
        r0[r1] = r2;
        r6.m18324a();
        r1 = r1 + 1;
        goto L_0x0072;
    L_0x0083:
        r2 = r6.m18338g();
        r0[r1] = r2;
        r5.f28180b = r0;
        goto L_0x0000;
    L_0x008d:
        r1 = r6.m18341j();
        r2 = r6.m18338g();	 Catch:{ IllegalArgumentException -> 0x00a1 }
        r2 = com.google.android.gms.internal.ads.ang.m18656a(r2);	 Catch:{ IllegalArgumentException -> 0x00a1 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x00a1 }
        r5.f28179a = r2;	 Catch:{ IllegalArgumentException -> 0x00a1 }
        goto L_0x0000;
    L_0x00a1:
        r6.m18336e(r1);
        r5.m29903a(r6, r0);
        goto L_0x0000;
    L_0x00a9:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.anq.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.anq");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28179a != null) {
            a += afg.m18350b(1, this.f28179a.intValue());
        }
        if (this.f28180b == null || this.f28180b.length <= 0) {
            return a;
        }
        int i = 0;
        for (int a2 : this.f28180b) {
            i += afg.m18342a(a2);
        }
        return (a + i) + (this.f28180b.length * 1);
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36839b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28179a != null) {
            afg.m18361a(1, this.f28179a.intValue());
        }
        if (this.f28180b != null && this.f28180b.length > 0) {
            for (int a : this.f28180b) {
                afg.m18361a(2, a);
            }
        }
        super.mo3804a(afg);
    }
}
