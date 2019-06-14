package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class al implements Creator<C7853o> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        LatLng latLng = null;
        String str = null;
        String str2 = str;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    latLng = (LatLng) C2834b.a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    str = C2834b.n(parcel, a);
                    break;
                case 4:
                    str2 = C2834b.n(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7853o(latLng, str, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7853o[i];
    }
}
