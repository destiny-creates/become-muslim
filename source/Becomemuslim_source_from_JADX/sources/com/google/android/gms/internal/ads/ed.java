package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ed implements Creator<eb> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            if (C2834b.a(a) != 2) {
                C2834b.b(parcel, a);
            } else {
                parcelFileDescriptor = (ParcelFileDescriptor) C2834b.a(parcel, a, ParcelFileDescriptor.CREATOR);
            }
        }
        C2834b.w(parcel, b);
        return new eb(parcelFileDescriptor);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new eb[i];
    }
}
