package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class apz extends ajm implements apy {
    public apz() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    /* renamed from: a */
    public static apy m30098a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return queryLocalInterface instanceof apy ? (apy) queryLocalInterface : new aqa(iBinder);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean dispatchTransaction(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) {
        /*
        r0 = this;
        r4 = 0;
        switch(r1) {
            case 1: goto L_0x0190;
            case 2: goto L_0x0189;
            case 3: goto L_0x017e;
            case 4: goto L_0x0171;
            case 5: goto L_0x016d;
            case 6: goto L_0x0169;
            case 7: goto L_0x014b;
            case 8: goto L_0x012d;
            case 9: goto L_0x0129;
            case 10: goto L_0x0124;
            case 11: goto L_0x011f;
            case 12: goto L_0x0113;
            case 13: goto L_0x0106;
            case 14: goto L_0x00f9;
            case 15: goto L_0x00e8;
            case 16: goto L_0x0004;
            case 17: goto L_0x0004;
            case 18: goto L_0x00dc;
            case 19: goto L_0x00cf;
            case 20: goto L_0x00b0;
            case 21: goto L_0x0091;
            case 22: goto L_0x0088;
            case 23: goto L_0x0082;
            case 24: goto L_0x0075;
            case 25: goto L_0x006c;
            case 26: goto L_0x0066;
            case 27: goto L_0x0004;
            case 28: goto L_0x0004;
            case 29: goto L_0x0059;
            case 30: goto L_0x004c;
            case 31: goto L_0x0046;
            case 32: goto L_0x0040;
            case 33: goto L_0x003a;
            case 34: goto L_0x0031;
            case 35: goto L_0x002b;
            case 36: goto L_0x000c;
            case 37: goto L_0x0006;
            default: goto L_0x0004;
        };
    L_0x0004:
        r1 = 0;
        return r1;
    L_0x0006:
        r1 = r0.mo3909p();
        goto L_0x0117;
    L_0x000c:
        r1 = r2.readStrongBinder();
        if (r1 != 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0026;
    L_0x0013:
        r2 = "com.google.android.gms.ads.internal.client.IAdMetadataListener";
        r2 = r1.queryLocalInterface(r2);
        r4 = r2 instanceof com.google.android.gms.internal.ads.aqd;
        if (r4 == 0) goto L_0x0021;
    L_0x001d:
        r4 = r2;
        r4 = (com.google.android.gms.internal.ads.aqd) r4;
        goto L_0x0026;
    L_0x0021:
        r4 = new com.google.android.gms.internal.ads.aqf;
        r4.<init>(r1);
    L_0x0026:
        r0.mo3890a(r4);
        goto L_0x018c;
    L_0x002b:
        r1 = r0.w_();
        goto L_0x00e0;
    L_0x0031:
        r1 = com.google.android.gms.internal.ads.ajn.m18505a(r2);
        r0.mo3901c(r1);
        goto L_0x018c;
    L_0x003a:
        r1 = r0.mo3883E();
        goto L_0x0194;
    L_0x0040:
        r1 = r0.mo3882D();
        goto L_0x0194;
    L_0x0046:
        r1 = r0.mo3881C();
        goto L_0x00e0;
    L_0x004c:
        r1 = com.google.android.gms.internal.ads.arb.CREATOR;
        r1 = com.google.android.gms.internal.ads.ajn.m18501a(r2, r1);
        r1 = (com.google.android.gms.internal.ads.arb) r1;
        r0.mo3893a(r1);
        goto L_0x018c;
    L_0x0059:
        r1 = com.google.android.gms.internal.ads.ary.CREATOR;
        r1 = com.google.android.gms.internal.ads.ajn.m18501a(r2, r1);
        r1 = (com.google.android.gms.internal.ads.ary) r1;
        r0.mo3894a(r1);
        goto L_0x018c;
    L_0x0066:
        r1 = r0.mo3912s();
        goto L_0x0194;
    L_0x006c:
        r1 = r2.readString();
        r0.mo3898a(r1);
        goto L_0x018c;
    L_0x0075:
        r1 = r2.readStrongBinder();
        r1 = com.google.android.gms.internal.ads.go.m30747a(r1);
        r0.mo3896a(r1);
        goto L_0x018c;
    L_0x0082:
        r1 = r0.mo3911r();
        goto L_0x0182;
    L_0x0088:
        r1 = com.google.android.gms.internal.ads.ajn.m18505a(r2);
        r0.mo3899b(r1);
        goto L_0x018c;
    L_0x0091:
        r1 = r2.readStrongBinder();
        if (r1 != 0) goto L_0x0098;
    L_0x0097:
        goto L_0x00ab;
    L_0x0098:
        r2 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider";
        r2 = r1.queryLocalInterface(r2);
        r4 = r2 instanceof com.google.android.gms.internal.ads.aqn;
        if (r4 == 0) goto L_0x00a6;
    L_0x00a2:
        r4 = r2;
        r4 = (com.google.android.gms.internal.ads.aqn) r4;
        goto L_0x00ab;
    L_0x00a6:
        r4 = new com.google.android.gms.internal.ads.aqp;
        r4.<init>(r1);
    L_0x00ab:
        r0.mo3892a(r4);
        goto L_0x018c;
    L_0x00b0:
        r1 = r2.readStrongBinder();
        if (r1 != 0) goto L_0x00b7;
    L_0x00b6:
        goto L_0x00ca;
    L_0x00b7:
        r2 = "com.google.android.gms.ads.internal.client.IAdClickListener";
        r2 = r1.queryLocalInterface(r2);
        r4 = r2 instanceof com.google.android.gms.internal.ads.apk;
        if (r4 == 0) goto L_0x00c5;
    L_0x00c1:
        r4 = r2;
        r4 = (com.google.android.gms.internal.ads.apk) r4;
        goto L_0x00ca;
    L_0x00c5:
        r4 = new com.google.android.gms.internal.ads.apm;
        r4.<init>(r1);
    L_0x00ca:
        r0.mo3888a(r4);
        goto L_0x018c;
    L_0x00cf:
        r1 = r2.readStrongBinder();
        r1 = com.google.android.gms.internal.ads.atk.m30189a(r1);
        r0.mo3895a(r1);
        goto L_0x018c;
    L_0x00dc:
        r1 = r0.mo3885a();
    L_0x00e0:
        r3.writeNoException();
        r3.writeString(r1);
        goto L_0x019a;
    L_0x00e8:
        r1 = r2.readStrongBinder();
        r1 = com.google.android.gms.internal.ads.ag.m29905a(r1);
        r2 = r2.readString();
        r0.mo3886a(r1, r2);
        goto L_0x018c;
    L_0x00f9:
        r1 = r2.readStrongBinder();
        r1 = com.google.android.gms.internal.ads.C6772z.m31244a(r1);
        r0.mo3897a(r1);
        goto L_0x018c;
    L_0x0106:
        r1 = com.google.android.gms.internal.ads.aou.CREATOR;
        r1 = com.google.android.gms.internal.ads.ajn.m18501a(r2, r1);
        r1 = (com.google.android.gms.internal.ads.aou) r1;
        r0.mo3887a(r1);
        goto L_0x018c;
    L_0x0113:
        r1 = r0.mo3904k();
    L_0x0117:
        r3.writeNoException();
        com.google.android.gms.internal.ads.ajn.m18507b(r3, r1);
        goto L_0x019a;
    L_0x011f:
        r0.mo3906m();
        goto L_0x018c;
    L_0x0124:
        r0.mo3910q();
        goto L_0x018c;
    L_0x0129:
        r0.mo3884H();
        goto L_0x018c;
    L_0x012d:
        r1 = r2.readStrongBinder();
        if (r1 != 0) goto L_0x0134;
    L_0x0133:
        goto L_0x0147;
    L_0x0134:
        r2 = "com.google.android.gms.ads.internal.client.IAppEventListener";
        r2 = r1.queryLocalInterface(r2);
        r4 = r2 instanceof com.google.android.gms.internal.ads.aqh;
        if (r4 == 0) goto L_0x0142;
    L_0x013e:
        r4 = r2;
        r4 = (com.google.android.gms.internal.ads.aqh) r4;
        goto L_0x0147;
    L_0x0142:
        r4 = new com.google.android.gms.internal.ads.aqj;
        r4.<init>(r1);
    L_0x0147:
        r0.mo3891a(r4);
        goto L_0x018c;
    L_0x014b:
        r1 = r2.readStrongBinder();
        if (r1 != 0) goto L_0x0152;
    L_0x0151:
        goto L_0x0165;
    L_0x0152:
        r2 = "com.google.android.gms.ads.internal.client.IAdListener";
        r2 = r1.queryLocalInterface(r2);
        r4 = r2 instanceof com.google.android.gms.internal.ads.apn;
        if (r4 == 0) goto L_0x0160;
    L_0x015c:
        r4 = r2;
        r4 = (com.google.android.gms.internal.ads.apn) r4;
        goto L_0x0165;
    L_0x0160:
        r4 = new com.google.android.gms.internal.ads.app;
        r4.<init>(r1);
    L_0x0165:
        r0.mo3889a(r4);
        goto L_0x018c;
    L_0x0169:
        r0.mo3908o();
        goto L_0x018c;
    L_0x016d:
        r0.mo3907n();
        goto L_0x018c;
    L_0x0171:
        r1 = com.google.android.gms.internal.ads.aoq.CREATOR;
        r1 = com.google.android.gms.internal.ads.ajn.m18501a(r2, r1);
        r1 = (com.google.android.gms.internal.ads.aoq) r1;
        r1 = r0.mo3900b(r1);
        goto L_0x0182;
    L_0x017e:
        r1 = r0.mo3905l();
    L_0x0182:
        r3.writeNoException();
        com.google.android.gms.internal.ads.ajn.m18504a(r3, r1);
        goto L_0x019a;
    L_0x0189:
        r0.mo3902i();
    L_0x018c:
        r3.writeNoException();
        goto L_0x019a;
    L_0x0190:
        r1 = r0.mo3903j();
    L_0x0194:
        r3.writeNoException();
        com.google.android.gms.internal.ads.ajn.m18502a(r3, r1);
    L_0x019a:
        r1 = 1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.apz.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
