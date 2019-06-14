package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ac implements Creator<CameraPosition> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        float f = 0.0f;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    latLng = (LatLng) C2834b.a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    f = C2834b.j(parcel, a);
                    break;
                case 4:
                    f2 = C2834b.j(parcel, a);
                    break;
                case 5:
                    f3 = C2834b.j(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new CameraPosition(latLng, f, f2, f3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CameraPosition[i];
    }
}
