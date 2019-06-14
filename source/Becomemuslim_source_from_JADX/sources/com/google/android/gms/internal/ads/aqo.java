package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class aqo extends ajm implements aqn {
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        long a = mo3928a();
        parcel2.writeNoException();
        parcel2.writeLong(a);
        return true;
    }
}
