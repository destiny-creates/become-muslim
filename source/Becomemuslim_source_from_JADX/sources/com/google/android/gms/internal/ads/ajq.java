package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class ajq extends ajm implements ajp {
    /* renamed from: a */
    public static ajp m29978a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        return queryLocalInterface instanceof ajp ? (ajp) queryLocalInterface : new ajr(iBinder);
    }
}
