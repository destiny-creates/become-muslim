package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class aqi extends ajm implements aqh {
    public aqi() {
        super("com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    /* renamed from: a */
    public static aqh m30134a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        return queryLocalInterface instanceof aqh ? (aqh) queryLocalInterface : new aqj(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo3916a(parcel.readString(), parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}
