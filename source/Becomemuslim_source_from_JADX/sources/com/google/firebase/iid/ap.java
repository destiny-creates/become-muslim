package com.google.firebase.iid;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ap implements Creator<ao> {
    ap() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ao[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        parcel = parcel.readStrongBinder();
        return parcel != null ? new ao(parcel) : null;
    }
}
