package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class beo extends ajm implements ben {
    public beo() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    /* renamed from: a */
    public static ben m30620a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return queryLocalInterface instanceof ben ? (ben) queryLocalInterface : new bep(iBinder);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean dispatchTransaction(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) {
        /*
        r8 = this;
        r12 = 0;
        switch(r9) {
            case 1: goto L_0x00b6;
            case 2: goto L_0x00ab;
            case 3: goto L_0x00a6;
            case 4: goto L_0x005b;
            case 5: goto L_0x004f;
            case 6: goto L_0x000e;
            case 7: goto L_0x0006;
            default: goto L_0x0004;
        };
    L_0x0004:
        r9 = 0;
        return r9;
    L_0x0006:
        r8.mo4215d();
    L_0x0009:
        r11.writeNoException();
        goto L_0x00e8;
    L_0x000e:
        r1 = r10.createByteArray();
        r2 = r10.readString();
        r9 = android.os.Bundle.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r3 = r9;
        r3 = (android.os.Bundle) r3;
        r9 = r10.readStrongBinder();
        r4 = com.google.android.gms.p174b.C2758b.C4325a.a(r9);
        r9 = r10.readStrongBinder();
        if (r9 != 0) goto L_0x002f;
    L_0x002d:
        r5 = r12;
        goto L_0x0042;
    L_0x002f:
        r12 = "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback";
        r12 = r9.queryLocalInterface(r12);
        r0 = r12 instanceof com.google.android.gms.internal.ads.bel;
        if (r0 == 0) goto L_0x003c;
    L_0x0039:
        r12 = (com.google.android.gms.internal.ads.bel) r12;
        goto L_0x002d;
    L_0x003c:
        r12 = new com.google.android.gms.internal.ads.bem;
        r12.<init>(r9);
        goto L_0x002d;
    L_0x0042:
        r9 = r10.readStrongBinder();
        r6 = com.google.android.gms.internal.ads.bdf.m30505a(r9);
        r0 = r8;
        r0.mo4212a(r1, r2, r3, r4, r5, r6);
        goto L_0x0009;
    L_0x004f:
        r9 = r8.mo4214c();
        r11.writeNoException();
        com.google.android.gms.internal.ads.ajn.m18502a(r11, r9);
        goto L_0x00e8;
    L_0x005b:
        r1 = r10.createByteArray();
        r2 = r10.readString();
        r9 = android.os.Bundle.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r3 = r9;
        r3 = (android.os.Bundle) r3;
        r9 = r10.readStrongBinder();
        r4 = com.google.android.gms.p174b.C2758b.C4325a.a(r9);
        r9 = r10.readStrongBinder();
        if (r9 != 0) goto L_0x007c;
    L_0x007a:
        r5 = r12;
        goto L_0x008f;
    L_0x007c:
        r12 = "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback";
        r12 = r9.queryLocalInterface(r12);
        r0 = r12 instanceof com.google.android.gms.internal.ads.bej;
        if (r0 == 0) goto L_0x0089;
    L_0x0086:
        r12 = (com.google.android.gms.internal.ads.bej) r12;
        goto L_0x007a;
    L_0x0089:
        r12 = new com.google.android.gms.internal.ads.bek;
        r12.<init>(r9);
        goto L_0x007a;
    L_0x008f:
        r9 = r10.readStrongBinder();
        r6 = com.google.android.gms.internal.ads.bdf.m30505a(r9);
        r9 = com.google.android.gms.internal.ads.aou.CREATOR;
        r9 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r9);
        r7 = r9;
        r7 = (com.google.android.gms.internal.ads.aou) r7;
        r0 = r8;
        r0.mo4211a(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x0009;
    L_0x00a6:
        r9 = r8.mo4213b();
        goto L_0x00af;
    L_0x00ab:
        r9 = r8.mo4209a();
    L_0x00af:
        r11.writeNoException();
        com.google.android.gms.internal.ads.ajn.m18507b(r11, r9);
        goto L_0x00e8;
    L_0x00b6:
        r9 = r10.readStrongBinder();
        r9 = com.google.android.gms.p174b.C2758b.C4325a.a(r9);
        r0 = r10.readString();
        r1 = android.os.Bundle.CREATOR;
        r1 = com.google.android.gms.internal.ads.ajn.m18501a(r10, r1);
        r1 = (android.os.Bundle) r1;
        r10 = r10.readStrongBinder();
        if (r10 != 0) goto L_0x00d1;
    L_0x00d0:
        goto L_0x00e3;
    L_0x00d1:
        r12 = "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback";
        r12 = r10.queryLocalInterface(r12);
        r2 = r12 instanceof com.google.android.gms.internal.ads.beq;
        if (r2 == 0) goto L_0x00de;
    L_0x00db:
        r12 = (com.google.android.gms.internal.ads.beq) r12;
        goto L_0x00e3;
    L_0x00de:
        r12 = new com.google.android.gms.internal.ads.ber;
        r12.<init>(r10);
    L_0x00e3:
        r8.mo4210a(r9, r0, r1, r12);
        goto L_0x0009;
    L_0x00e8:
        r9 = 1;
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.beo.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
