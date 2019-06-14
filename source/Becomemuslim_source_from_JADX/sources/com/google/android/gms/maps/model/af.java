package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class af implements Creator<C7849h> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        IBinder iBinder = null;
        LatLng latLng = iBinder;
        LatLngBounds latLngBounds = latLng;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    iBinder = C2834b.o(parcel2, a);
                    break;
                case 3:
                    latLng = (LatLng) C2834b.a(parcel2, a, LatLng.CREATOR);
                    break;
                case 4:
                    f = C2834b.j(parcel2, a);
                    break;
                case 5:
                    f2 = C2834b.j(parcel2, a);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C2834b.a(parcel2, a, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = C2834b.j(parcel2, a);
                    break;
                case 8:
                    f4 = C2834b.j(parcel2, a);
                    break;
                case 9:
                    z = C2834b.c(parcel2, a);
                    break;
                case 10:
                    f5 = C2834b.j(parcel2, a);
                    break;
                case 11:
                    f6 = C2834b.j(parcel2, a);
                    break;
                case 12:
                    f7 = C2834b.j(parcel2, a);
                    break;
                case 13:
                    z2 = C2834b.c(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new C7849h(iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7849h[i];
    }
}
