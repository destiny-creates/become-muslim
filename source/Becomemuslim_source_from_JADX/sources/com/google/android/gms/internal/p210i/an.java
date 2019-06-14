package com.google.android.gms.internal.p210i;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.gms.internal.i.an */
final class an implements Creator<am> {
    an() {
    }

    @Deprecated
    public final /* synthetic */ Object[] newArray(int i) {
        return new am[i];
    }

    @Deprecated
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new am(parcel);
    }
}
