package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class arc implements Creator<arb> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            if (C2834b.a(a) != 2) {
                C2834b.b(parcel, a);
            } else {
                i = C2834b.g(parcel, a);
            }
        }
        C2834b.w(parcel, b);
        return new arb(i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new arb[i];
    }
}
