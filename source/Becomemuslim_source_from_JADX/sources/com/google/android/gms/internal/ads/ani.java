package com.google.android.gms.internal.ads;

public final class ani extends afi<ani> {
    /* renamed from: a */
    private static volatile ani[] f28136a;
    /* renamed from: b */
    private Integer f28137b;
    /* renamed from: c */
    private anw f28138c;

    public ani() {
        this.f28137b = null;
        this.f28138c = null;
        this.Y = null;
        this.Z = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.ads.ani m36807b(com.google.android.gms.internal.ads.afe r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
    L_0x0000:
        r0 = r7.m18324a();
        if (r0 == 0) goto L_0x005b;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0026;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x0015;
    L_0x000e:
        r0 = super.m29903a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0014:
        return r6;
    L_0x0015:
        r0 = r6.f28138c;
        if (r0 != 0) goto L_0x0020;
    L_0x0019:
        r0 = new com.google.android.gms.internal.ads.anw;
        r0.<init>();
        r6.f28138c = r0;
    L_0x0020:
        r0 = r6.f28138c;
        r7.m18326a(r0);
        goto L_0x0000;
    L_0x0026:
        r1 = r7.m18341j();
        r2 = r7.m18338g();	 Catch:{ IllegalArgumentException -> 0x0054 }
        if (r2 < 0) goto L_0x003b;	 Catch:{ IllegalArgumentException -> 0x0054 }
    L_0x0030:
        r3 = 10;	 Catch:{ IllegalArgumentException -> 0x0054 }
        if (r2 > r3) goto L_0x003b;	 Catch:{ IllegalArgumentException -> 0x0054 }
    L_0x0034:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0054 }
        r6.f28137b = r2;	 Catch:{ IllegalArgumentException -> 0x0054 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0054 }
    L_0x003b:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0054 }
        r4 = 44;	 Catch:{ IllegalArgumentException -> 0x0054 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0054 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0054 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0054 }
        r2 = " is not a valid enum AdFormatType";	 Catch:{ IllegalArgumentException -> 0x0054 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0054 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0054 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0054 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0054 }
    L_0x0054:
        r7.m18336e(r1);
        r6.m29903a(r7, r0);
        goto L_0x0000;
    L_0x005b:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ani.b(com.google.android.gms.internal.ads.afe):com.google.android.gms.internal.ads.ani");
    }

    /* renamed from: b */
    public static ani[] m36808b() {
        if (f28136a == null) {
            synchronized (afm.f14429b) {
                if (f28136a == null) {
                    f28136a = new ani[0];
                }
            }
        }
        return f28136a;
    }

    /* renamed from: a */
    protected final int mo3803a() {
        int a = super.mo3803a();
        if (this.f28137b != null) {
            a += afg.m18350b(1, this.f28137b.intValue());
        }
        return this.f28138c != null ? a + afg.m18351b(2, this.f28138c) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ afo mo6026a(afe afe) {
        return m36807b(afe);
    }

    /* renamed from: a */
    public final void mo3804a(afg afg) {
        if (this.f28137b != null) {
            afg.m18361a(1, this.f28137b.intValue());
        }
        if (this.f28138c != null) {
            afg.m18363a(2, this.f28138c);
        }
        super.mo3804a(afg);
    }
}
