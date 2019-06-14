package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.ArrayList;
import java.util.List;

public final class am implements Creator<C7854q> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        List arrayList = new ArrayList();
        List list = null;
        List list2 = null;
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    list = C2834b.c(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    C2834b.a(parcel, a, arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    f = C2834b.j(parcel, a);
                    break;
                case 5:
                    i = C2834b.g(parcel, a);
                    break;
                case 6:
                    i2 = C2834b.g(parcel, a);
                    break;
                case 7:
                    f2 = C2834b.j(parcel, a);
                    break;
                case 8:
                    z = C2834b.c(parcel, a);
                    break;
                case 9:
                    z2 = C2834b.c(parcel, a);
                    break;
                case 10:
                    z3 = C2834b.c(parcel, a);
                    break;
                case 11:
                    i3 = C2834b.g(parcel, a);
                    break;
                case 12:
                    list2 = C2834b.c(parcel, a, C7852n.CREATOR);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7854q(list, arrayList, f, i, i2, f2, z, z2, z3, i3, list2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7854q[i];
    }
}
