package com.google.android.gms.iid;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class aa implements Creator<MessengerCompat> {
    aa() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MessengerCompat[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        parcel = parcel.readStrongBinder();
        return parcel != null ? new MessengerCompat(parcel) : null;
    }
}
