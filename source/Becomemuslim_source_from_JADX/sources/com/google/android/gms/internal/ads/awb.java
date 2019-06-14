package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class awb extends ajm implements awa {
    public awb() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    /* renamed from: a */
    public static awa m30304a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        return queryLocalInterface instanceof awa ? (awa) queryLocalInterface : new awc(iBinder);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean dispatchTransaction(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) {
        /*
        r0 = this;
        switch(r1) {
            case 1: goto L_0x0059;
            case 2: goto L_0x004a;
            case 3: goto L_0x003f;
            case 4: goto L_0x003a;
            case 5: goto L_0x002f;
            case 6: goto L_0x002b;
            case 7: goto L_0x0026;
            case 8: goto L_0x0022;
            case 9: goto L_0x001d;
            case 10: goto L_0x000a;
            case 11: goto L_0x0005;
            default: goto L_0x0003;
        };
    L_0x0003:
        r1 = 0;
        return r1;
    L_0x0005:
        r1 = r0.mo4046b();
        goto L_0x0052;
    L_0x000a:
        r1 = r2.readStrongBinder();
        r1 = com.google.android.gms.p174b.C2758b.C4325a.a(r1);
        r1 = r0.mo4045a(r1);
        r3.writeNoException();
        com.google.android.gms.internal.ads.ajn.m18504a(r3, r1);
        goto L_0x0067;
    L_0x001d:
        r1 = r0.mo4051e();
        goto L_0x0052;
    L_0x0022:
        r0.mo4052f();
        goto L_0x0036;
    L_0x0026:
        r1 = r0.mo4048c();
        goto L_0x0052;
    L_0x002b:
        r0.mo4050d();
        goto L_0x0036;
    L_0x002f:
        r1 = r2.readString();
        r0.mo4049c(r1);
    L_0x0036:
        r3.writeNoException();
        goto L_0x0067;
    L_0x003a:
        r1 = r0.mo4053l();
        goto L_0x0061;
    L_0x003f:
        r1 = r0.mo4044a();
        r3.writeNoException();
        r3.writeStringList(r1);
        goto L_0x0067;
    L_0x004a:
        r1 = r2.readString();
        r1 = r0.mo4047b(r1);
    L_0x0052:
        r3.writeNoException();
        com.google.android.gms.internal.ads.ajn.m18502a(r3, r1);
        goto L_0x0067;
    L_0x0059:
        r1 = r2.readString();
        r1 = r0.mo4043a(r1);
    L_0x0061:
        r3.writeNoException();
        r3.writeString(r1);
    L_0x0067:
        r1 = 1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.awb.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
