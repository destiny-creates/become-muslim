package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class aqe extends ajm implements aqd {
    public aqe() {
        super("com.google.android.gms.ads.internal.client.IAdMetadataListener");
    }

    /* renamed from: a */
    public static aqd m30132a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
        return queryLocalInterface instanceof aqd ? (aqd) queryLocalInterface : new aqf(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo3915a();
        parcel2.writeNoException();
        return true;
    }
}
