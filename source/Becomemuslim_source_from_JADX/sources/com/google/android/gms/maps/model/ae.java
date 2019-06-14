package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

public final class ae implements Creator<C7848f> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        LatLng latLng = null;
        List list = latLng;
        double d = 0.0d;
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    latLng = (LatLng) C2834b.a(parcel2, a, LatLng.CREATOR);
                    break;
                case 3:
                    d = C2834b.l(parcel2, a);
                    break;
                case 4:
                    f = C2834b.j(parcel2, a);
                    break;
                case 5:
                    i = C2834b.g(parcel2, a);
                    break;
                case 6:
                    i2 = C2834b.g(parcel2, a);
                    break;
                case 7:
                    f2 = C2834b.j(parcel2, a);
                    break;
                case 8:
                    z = C2834b.c(parcel2, a);
                    break;
                case 9:
                    z2 = C2834b.c(parcel2, a);
                    break;
                case 10:
                    list = C2834b.c(parcel2, a, C7852n.CREATOR);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new C7848f(latLng, d, f, i, i2, f2, z, z2, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7848f[i];
    }
}
