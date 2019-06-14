package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

public final class an implements Creator<C7855s> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        List list = null;
        C7847d c7847d = list;
        C7847d c7847d2 = c7847d;
        List list2 = c7847d2;
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    list = C2834b.c(parcel2, a, LatLng.CREATOR);
                    break;
                case 3:
                    f = C2834b.j(parcel2, a);
                    break;
                case 4:
                    i = C2834b.g(parcel2, a);
                    break;
                case 5:
                    f2 = C2834b.j(parcel2, a);
                    break;
                case 6:
                    z = C2834b.c(parcel2, a);
                    break;
                case 7:
                    z2 = C2834b.c(parcel2, a);
                    break;
                case 8:
                    z3 = C2834b.c(parcel2, a);
                    break;
                case 9:
                    c7847d = (C7847d) C2834b.a(parcel2, a, C7847d.CREATOR);
                    break;
                case 10:
                    c7847d2 = (C7847d) C2834b.a(parcel2, a, C7847d.CREATOR);
                    break;
                case 11:
                    i2 = C2834b.g(parcel2, a);
                    break;
                case 12:
                    list2 = C2834b.c(parcel2, a, C7852n.CREATOR);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new C7855s(list, f, i, f2, z, z2, z3, c7847d, c7847d2, i2, list2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7855s[i];
    }
}
