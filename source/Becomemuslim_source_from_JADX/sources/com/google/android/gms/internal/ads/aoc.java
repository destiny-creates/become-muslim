package com.google.android.gms.internal.ads;

public final class aoc extends afi<aoc> {
    /* renamed from: a */
    private Integer f28234a;

    public aoc() {
        this.f28234a = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.aoc m36885b(com.google.android.gms.internal.ads.afe r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
    L_0x0000:
        r0 = r7.m18324a();
        if (r0 == 0) goto L_0x0045;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0011;
    L_0x000a:
        r0 = super.m29903a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0010:
        return r6;
    L_0x0011:
        r1 = r7.m18341j();
        r2 = r7.m18338g();	 Catch:{ IllegalArgumentException -> 0x003e }
        if (r2 < 0) goto L_0x0025;	 Catch:{ IllegalArgumentException -> 0x003e }
    L_0x001b:
        r3 = 3;	 Catch:{ IllegalArgumentException -> 0x003e }
        if (r2 > r3) goto L_0x0025;	 Catch:{ IllegalArgumentException -> 0x003e }
    L_0x001e:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x003e }
        r6.f28234a = r2;	 Catch:{ IllegalArgumentException -> 0x003e }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x003e }
    L_0x0025:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x003e }
        r4 = 46;	 Catch:{ IllegalArgumentException -> 0x003e }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x003e }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x003e }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x003e }
        r2 = " is not a valid enum VideoErrorCode";	 Catch:{ IllegalArgumentException -> 0x003e }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x003e }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x003e }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x003e }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x003e }
    L_0x003e:
        r7.m18336e(r1);
        r6.m29903a(r7, r0);
        goto L_0x0000;
    L_0x0045:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aoc.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.aoc");
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        return this.f28234a != null ? a + afg.m18350b(1, this.f28234a.intValue()) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36885b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28234a != null) {
            afg.m18361a(1, this.f28234a.intValue());
        }
        super.mo3804a(afg);
    }
}
