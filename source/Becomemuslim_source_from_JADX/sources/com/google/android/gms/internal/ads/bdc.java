package com.google.android.gms.internal.ads;

public abstract class bdc extends ajm implements bdb {
    public bdc() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean dispatchTransaction(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) {
        /*
        r8 = this;
        r12 = 0;
        switch(r9) {
            case 1: goto L_0x01e3;
            case 2: goto L_0x01d8;
            case 3: goto L_0x01a7;
            case 4: goto L_0x019f;
            case 5: goto L_0x019b;
            case 6: goto L_0x0158;
            case 7: goto L_0x011e;
            case 8: goto L_0x0119;
            case 9: goto L_0x0114;
            case 10: goto L_0x00ed;
            case 11: goto L_0x00dc;
            case 12: goto L_0x00d7;
            case 13: goto L_0x00cb;
            case 14: goto L_0x0084;
            case 15: goto L_0x007e;
            case 16: goto L_0x0078;
            case 17: goto L_0x006c;
            case 18: goto L_0x0067;
            case 19: goto L_0x0062;
            case 20: goto L_0x004d;
            case 21: goto L_0x0040;
            case 22: goto L_0x003a;
            case 23: goto L_0x0021;
            case 24: goto L_0x001b;
            case 25: goto L_0x0012;
            case 26: goto L_0x000c;
            case 27: goto L_0x0006;
            default: goto L_0x0004;
        };
    L_0x0004:
        r9 = 0;
        return r9;
    L_0x0006:
        r9 = r8.mo4131p();
        goto L_0x01dc;
    L_0x000c:
        r9 = r8.mo4130o();
        goto L_0x01dc;
    L_0x0012:
        r9 = com.google.android.gms.internal.ads.ajn.m18505a(r10);
        r8.mo4116a(r9);
        goto L_0x01a2;
    L_0x001b:
        r9 = r8.mo4129n();
        goto L_0x01dc;
    L_0x0021:
        r9 = r10.readStrongBinder();
        r9 = com.google.android.gms.p174b.C2758b.C4325a.a(r9);
        r12 = r10.readStrongBinder();
        r12 = com.google.android.gms.internal.ads.hn.m30767a(r12);
        r10 = r10.createStringArrayList();
        r8.mo4113a(r9, r12, r10);
        goto L_0x01a2;
    L_0x003a:
        r9 = r8.mo4128m();
        goto L_0x00cf;
    L_0x0040:
        r9 = r10.readStrongBinder();
        r9 = com.google.android.gms.p174b.C2758b.C4325a.a(r9);
        r8.mo4106a(r9);
        goto L_0x01a2;
    L_0x004d:
        r9 = com.google.android.gms.internal.ads.aoq.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r9 = (com.google.android.gms.internal.ads.aoq) r9;
        r12 = r10.readString();
        r10 = r10.readString();
        r8.mo4115a(r9, r12, r10);
        goto L_0x01a2;
    L_0x0062:
        r9 = r8.mo4127l();
        goto L_0x0070;
    L_0x0067:
        r9 = r8.mo4126k();
        goto L_0x0070;
    L_0x006c:
        r9 = r8.mo4125j();
    L_0x0070:
        r11.writeNoException();
        com.google.android.gms.internal.ads.ajn.m18507b(r11, r9);
        goto L_0x0222;
    L_0x0078:
        r9 = r8.mo4124i();
        goto L_0x01dc;
    L_0x007e:
        r9 = r8.mo4123h();
        goto L_0x01dc;
    L_0x0084:
        r9 = r10.readStrongBinder();
        r1 = com.google.android.gms.p174b.C2758b.C4325a.a(r9);
        r9 = com.google.android.gms.internal.ads.aoq.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r2 = r9;
        r2 = (com.google.android.gms.internal.ads.aoq) r2;
        r3 = r10.readString();
        r4 = r10.readString();
        r9 = r10.readStrongBinder();
        if (r9 != 0) goto L_0x00a5;
    L_0x00a3:
        r5 = r12;
        goto L_0x00b8;
    L_0x00a5:
        r12 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener";
        r12 = r9.queryLocalInterface(r12);
        r0 = r12 instanceof com.google.android.gms.internal.ads.bde;
        if (r0 == 0) goto L_0x00b2;
    L_0x00af:
        r12 = (com.google.android.gms.internal.ads.bde) r12;
        goto L_0x00a3;
    L_0x00b2:
        r12 = new com.google.android.gms.internal.ads.bdg;
        r12.<init>(r9);
        goto L_0x00a3;
    L_0x00b8:
        r9 = com.google.android.gms.internal.ads.aus.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r6 = r9;
        r6 = (com.google.android.gms.internal.ads.aus) r6;
        r7 = r10.createStringArrayList();
        r0 = r8;
        r0.mo4110a(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x01a2;
    L_0x00cb:
        r9 = r8.mo4122g();
    L_0x00cf:
        r11.writeNoException();
        com.google.android.gms.internal.ads.ajn.m18504a(r11, r9);
        goto L_0x0222;
    L_0x00d7:
        r8.mo4121f();
        goto L_0x01a2;
    L_0x00dc:
        r9 = com.google.android.gms.internal.ads.aoq.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r9 = (com.google.android.gms.internal.ads.aoq) r9;
        r10 = r10.readString();
        r8.mo4114a(r9, r10);
        goto L_0x01a2;
    L_0x00ed:
        r9 = r10.readStrongBinder();
        r1 = com.google.android.gms.p174b.C2758b.C4325a.a(r9);
        r9 = com.google.android.gms.internal.ads.aoq.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r2 = r9;
        r2 = (com.google.android.gms.internal.ads.aoq) r2;
        r3 = r10.readString();
        r9 = r10.readStrongBinder();
        r4 = com.google.android.gms.internal.ads.hn.m30767a(r9);
        r5 = r10.readString();
        r0 = r8;
        r0.mo4108a(r1, r2, r3, r4, r5);
        goto L_0x01a2;
    L_0x0114:
        r8.mo4120e();
        goto L_0x01a2;
    L_0x0119:
        r8.mo4119d();
        goto L_0x01a2;
    L_0x011e:
        r9 = r10.readStrongBinder();
        r1 = com.google.android.gms.p174b.C2758b.C4325a.a(r9);
        r9 = com.google.android.gms.internal.ads.aoq.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r2 = r9;
        r2 = (com.google.android.gms.internal.ads.aoq) r2;
        r3 = r10.readString();
        r4 = r10.readString();
        r9 = r10.readStrongBinder();
        if (r9 != 0) goto L_0x013f;
    L_0x013d:
        r5 = r12;
        goto L_0x0153;
    L_0x013f:
        r10 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener";
        r10 = r9.queryLocalInterface(r10);
        r12 = r10 instanceof com.google.android.gms.internal.ads.bde;
        if (r12 == 0) goto L_0x014d;
    L_0x0149:
        r12 = r10;
        r12 = (com.google.android.gms.internal.ads.bde) r12;
        goto L_0x013d;
    L_0x014d:
        r12 = new com.google.android.gms.internal.ads.bdg;
        r12.<init>(r9);
        goto L_0x013d;
    L_0x0153:
        r0 = r8;
        r0.mo4109a(r1, r2, r3, r4, r5);
        goto L_0x01a2;
    L_0x0158:
        r9 = r10.readStrongBinder();
        r1 = com.google.android.gms.p174b.C2758b.C4325a.a(r9);
        r9 = com.google.android.gms.internal.ads.aou.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r2 = r9;
        r2 = (com.google.android.gms.internal.ads.aou) r2;
        r9 = com.google.android.gms.internal.ads.aoq.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r3 = r9;
        r3 = (com.google.android.gms.internal.ads.aoq) r3;
        r4 = r10.readString();
        r5 = r10.readString();
        r9 = r10.readStrongBinder();
        if (r9 != 0) goto L_0x0182;
    L_0x0180:
        r6 = r12;
        goto L_0x0196;
    L_0x0182:
        r10 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener";
        r10 = r9.queryLocalInterface(r10);
        r12 = r10 instanceof com.google.android.gms.internal.ads.bde;
        if (r12 == 0) goto L_0x0190;
    L_0x018c:
        r12 = r10;
        r12 = (com.google.android.gms.internal.ads.bde) r12;
        goto L_0x0180;
    L_0x0190:
        r12 = new com.google.android.gms.internal.ads.bdg;
        r12.<init>(r9);
        goto L_0x0180;
    L_0x0196:
        r0 = r8;
        r0.mo4112a(r1, r2, r3, r4, r5, r6);
        goto L_0x01a2;
    L_0x019b:
        r8.mo4118c();
        goto L_0x01a2;
    L_0x019f:
        r8.mo4117b();
    L_0x01a2:
        r11.writeNoException();
        goto L_0x0222;
    L_0x01a7:
        r9 = r10.readStrongBinder();
        r9 = com.google.android.gms.p174b.C2758b.C4325a.a(r9);
        r0 = com.google.android.gms.internal.ads.aoq.CREATOR;
        r0 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r0);
        r0 = (com.google.android.gms.internal.ads.aoq) r0;
        r1 = r10.readString();
        r10 = r10.readStrongBinder();
        if (r10 != 0) goto L_0x01c2;
    L_0x01c1:
        goto L_0x01d4;
    L_0x01c2:
        r12 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener";
        r12 = r10.queryLocalInterface(r12);
        r2 = r12 instanceof com.google.android.gms.internal.ads.bde;
        if (r2 == 0) goto L_0x01cf;
    L_0x01cc:
        r12 = (com.google.android.gms.internal.ads.bde) r12;
        goto L_0x01d4;
    L_0x01cf:
        r12 = new com.google.android.gms.internal.ads.bdg;
        r12.<init>(r10);
    L_0x01d4:
        r8.mo4107a(r9, r0, r1, r12);
        goto L_0x01a2;
    L_0x01d8:
        r9 = r8.mo4105a();
    L_0x01dc:
        r11.writeNoException();
        com.google.android.gms.internal.ads.ajn.m18502a(r11, r9);
        goto L_0x0222;
    L_0x01e3:
        r9 = r10.readStrongBinder();
        r1 = com.google.android.gms.p174b.C2758b.C4325a.a(r9);
        r9 = com.google.android.gms.internal.ads.aou.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r2 = r9;
        r2 = (com.google.android.gms.internal.ads.aou) r2;
        r9 = com.google.android.gms.internal.ads.aoq.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r3 = r9;
        r3 = (com.google.android.gms.internal.ads.aoq) r3;
        r4 = r10.readString();
        r9 = r10.readStrongBinder();
        if (r9 != 0) goto L_0x0209;
    L_0x0207:
        r5 = r12;
        goto L_0x021d;
    L_0x0209:
        r10 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener";
        r10 = r9.queryLocalInterface(r10);
        r12 = r10 instanceof com.google.android.gms.internal.ads.bde;
        if (r12 == 0) goto L_0x0217;
    L_0x0213:
        r12 = r10;
        r12 = (com.google.android.gms.internal.ads.bde) r12;
        goto L_0x0207;
    L_0x0217:
        r12 = new com.google.android.gms.internal.ads.bdg;
        r12.<init>(r9);
        goto L_0x0207;
    L_0x021d:
        r0 = r8;
        r0.mo4111a(r1, r2, r3, r4, r5);
        goto L_0x01a2;
    L_0x0222:
        r9 = 1;
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bdc.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
