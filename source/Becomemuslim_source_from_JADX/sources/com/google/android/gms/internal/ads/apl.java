package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class apl extends ajm implements apk {
    public apl() {
        super("com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo3857a();
        parcel2.writeNoException();
        return true;
    }
}
