package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.location.t */
public final class C5086t implements Creator<LocationAvailability> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        long j = 0;
        ac[] acVarArr = null;
        int i = 1000;
        int i2 = 1;
        int i3 = 1;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    i2 = C2834b.g(parcel, a);
                    break;
                case 2:
                    i3 = C2834b.g(parcel, a);
                    break;
                case 3:
                    j = C2834b.h(parcel, a);
                    break;
                case 4:
                    i = C2834b.g(parcel, a);
                    break;
                case 5:
                    acVarArr = (ac[]) C2834b.b(parcel, a, ac.CREATOR);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new LocationAvailability(i, i2, i3, j, acVarArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
