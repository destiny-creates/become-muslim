package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ag implements Creator<LatLngBounds> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    latLng = (LatLng) C2834b.a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    latLng2 = (LatLng) C2834b.a(parcel, a, LatLng.CREATOR);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new LatLngBounds(latLng, latLng2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
