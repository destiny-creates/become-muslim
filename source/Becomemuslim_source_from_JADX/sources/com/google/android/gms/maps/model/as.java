package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class as implements Creator<ab> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        LatLng latLng = null;
        LatLng latLng2 = latLng;
        LatLng latLng3 = latLng2;
        LatLng latLng4 = latLng3;
        LatLngBounds latLngBounds = latLng4;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    latLng = (LatLng) C2834b.a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    latLng2 = (LatLng) C2834b.a(parcel, a, LatLng.CREATOR);
                    break;
                case 4:
                    latLng3 = (LatLng) C2834b.a(parcel, a, LatLng.CREATOR);
                    break;
                case 5:
                    latLng4 = (LatLng) C2834b.a(parcel, a, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C2834b.a(parcel, a, LatLngBounds.CREATOR);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new ab(latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ab[i];
    }
}
