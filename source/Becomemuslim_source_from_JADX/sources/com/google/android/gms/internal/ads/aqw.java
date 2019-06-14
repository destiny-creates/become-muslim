package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class aqw extends ajm implements aqv {
    public aqw() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    /* renamed from: a */
    public static aqv m30145a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return queryLocalInterface instanceof aqv ? (aqv) queryLocalInterface : new aqx(iBinder);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean dispatchTransaction(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) {
        /*
        r0 = this;
        switch(r1) {
            case 1: goto L_0x0071;
            case 2: goto L_0x006d;
            case 3: goto L_0x0065;
            case 4: goto L_0x005a;
            case 5: goto L_0x004f;
            case 6: goto L_0x0044;
            case 7: goto L_0x003f;
            case 8: goto L_0x001f;
            case 9: goto L_0x001a;
            case 10: goto L_0x0015;
            case 11: goto L_0x000a;
            case 12: goto L_0x0005;
            default: goto L_0x0003;
        };
    L_0x0003:
        r1 = 0;
        return r1;
    L_0x0005:
        r1 = r0.mo3948j();
        goto L_0x005e;
    L_0x000a:
        r1 = r0.mo3946h();
        r3.writeNoException();
        com.google.android.gms.internal.ads.ajn.m18502a(r3, r1);
        goto L_0x0077;
    L_0x0015:
        r1 = r0.mo3947i();
        goto L_0x005e;
    L_0x001a:
        r1 = r0.mo3943e();
        goto L_0x0048;
    L_0x001f:
        r1 = r2.readStrongBinder();
        if (r1 != 0) goto L_0x0027;
    L_0x0025:
        r1 = 0;
        goto L_0x003b;
    L_0x0027:
        r2 = "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks";
        r2 = r1.queryLocalInterface(r2);
        r4 = r2 instanceof com.google.android.gms.internal.ads.aqy;
        if (r4 == 0) goto L_0x0035;
    L_0x0031:
        r1 = r2;
        r1 = (com.google.android.gms.internal.ads.aqy) r1;
        goto L_0x003b;
    L_0x0035:
        r2 = new com.google.android.gms.internal.ads.ara;
        r2.<init>(r1);
        r1 = r2;
    L_0x003b:
        r0.mo3938a(r1);
        goto L_0x0074;
    L_0x003f:
        r1 = r0.mo3945g();
        goto L_0x0048;
    L_0x0044:
        r1 = r0.mo3944f();
    L_0x0048:
        r3.writeNoException();
        r3.writeFloat(r1);
        goto L_0x0077;
    L_0x004f:
        r1 = r0.mo3942d();
        r3.writeNoException();
        r3.writeInt(r1);
        goto L_0x0077;
    L_0x005a:
        r1 = r0.mo3941c();
    L_0x005e:
        r3.writeNoException();
        com.google.android.gms.internal.ads.ajn.m18504a(r3, r1);
        goto L_0x0077;
    L_0x0065:
        r1 = com.google.android.gms.internal.ads.ajn.m18505a(r2);
        r0.mo3939a(r1);
        goto L_0x0074;
    L_0x006d:
        r0.mo3940b();
        goto L_0x0074;
    L_0x0071:
        r0.mo3937a();
    L_0x0074:
        r3.writeNoException();
    L_0x0077:
        r1 = 1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aqw.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
