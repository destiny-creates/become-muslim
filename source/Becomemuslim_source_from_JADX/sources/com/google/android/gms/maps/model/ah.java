package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ah implements Creator<LatLng> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        double d = 0.0d;
        double d2 = 0.0d;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    d = C2834b.l(parcel, a);
                    break;
                case 3:
                    d2 = C2834b.l(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new LatLng(d, d2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LatLng[i];
    }
}
