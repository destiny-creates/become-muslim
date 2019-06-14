package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* renamed from: com.google.android.gms.maps.k */
public final class C5133k implements Creator<GoogleMapOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        CameraPosition cameraPosition = null;
        Float f = cameraPosition;
        Float f2 = f;
        LatLngBounds latLngBounds = f2;
        byte b2 = (byte) -1;
        byte b3 = (byte) -1;
        int i = 0;
        byte b4 = (byte) -1;
        byte b5 = (byte) -1;
        byte b6 = (byte) -1;
        byte b7 = (byte) -1;
        byte b8 = (byte) -1;
        byte b9 = (byte) -1;
        byte b10 = (byte) -1;
        byte b11 = (byte) -1;
        byte b12 = (byte) -1;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    b2 = C2834b.e(parcel2, a);
                    break;
                case 3:
                    b3 = C2834b.e(parcel2, a);
                    break;
                case 4:
                    i = C2834b.g(parcel2, a);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) C2834b.a(parcel2, a, CameraPosition.CREATOR);
                    break;
                case 6:
                    b4 = C2834b.e(parcel2, a);
                    break;
                case 7:
                    b5 = C2834b.e(parcel2, a);
                    break;
                case 8:
                    b6 = C2834b.e(parcel2, a);
                    break;
                case 9:
                    b7 = C2834b.e(parcel2, a);
                    break;
                case 10:
                    b8 = C2834b.e(parcel2, a);
                    break;
                case 11:
                    b9 = C2834b.e(parcel2, a);
                    break;
                case 12:
                    b10 = C2834b.e(parcel2, a);
                    break;
                case 14:
                    b11 = C2834b.e(parcel2, a);
                    break;
                case 15:
                    b12 = C2834b.e(parcel2, a);
                    break;
                case 16:
                    f = C2834b.k(parcel2, a);
                    break;
                case 17:
                    f2 = C2834b.k(parcel2, a);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) C2834b.a(parcel2, a, LatLngBounds.CREATOR);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new GoogleMapOptions(b2, b3, i, cameraPosition, b4, b5, b6, b7, b8, b9, b10, b11, b12, f, f2, latLngBounds);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
