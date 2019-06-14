package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class aj implements Creator<C7851m> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        LatLng latLng = null;
        String str = latLng;
        String str2 = str;
        IBinder iBinder = str2;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    latLng = (LatLng) C2834b.a(parcel2, a, LatLng.CREATOR);
                    break;
                case 3:
                    str = C2834b.n(parcel2, a);
                    break;
                case 4:
                    str2 = C2834b.n(parcel2, a);
                    break;
                case 5:
                    iBinder = C2834b.o(parcel2, a);
                    break;
                case 6:
                    f = C2834b.j(parcel2, a);
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
                    z3 = C2834b.c(parcel2, a);
                    break;
                case 11:
                    f3 = C2834b.j(parcel2, a);
                    break;
                case 12:
                    f4 = C2834b.j(parcel2, a);
                    break;
                case 13:
                    f5 = C2834b.j(parcel2, a);
                    break;
                case 14:
                    f6 = C2834b.j(parcel2, a);
                    break;
                case 15:
                    f7 = C2834b.j(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new C7851m(latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6, f7);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7851m[i];
    }
}
