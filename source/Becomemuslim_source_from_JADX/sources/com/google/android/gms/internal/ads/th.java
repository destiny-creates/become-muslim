package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class th extends ajm implements tg {
    /* renamed from: a */
    public static tg m31112a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.omid.IOmid");
        return queryLocalInterface instanceof tg ? (tg) queryLocalInterface : new ti(iBinder);
    }
}
