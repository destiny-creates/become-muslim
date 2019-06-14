package com.google.android.gms.internal.p213l;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.l.gw */
public abstract class gw extends gs implements gv {
    /* renamed from: a */
    public static gv m32081a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        return queryLocalInterface instanceof gv ? (gv) queryLocalInterface : new gx(iBinder);
    }
}
