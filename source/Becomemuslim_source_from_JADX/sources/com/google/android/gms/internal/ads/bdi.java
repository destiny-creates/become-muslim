package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class bdi extends ajm implements bdh {
    public bdi() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        i = mo4144a();
        parcel2.writeNoException();
        parcel2.writeInt(i);
        return true;
    }
}
