package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class dx extends ajm implements dw {
    public dx() {
        super("com.google.android.gms.ads.internal.request.IAdResponseListener");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo4240a((dp) ajn.m18501a(parcel, dp.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
