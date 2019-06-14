package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ar implements Creator<C7857y> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        IBinder iBinder = null;
        boolean z = false;
        float f = 0.0f;
        boolean z2 = true;
        float f2 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    iBinder = C2834b.o(parcel, a);
                    break;
                case 3:
                    z = C2834b.c(parcel, a);
                    break;
                case 4:
                    f = C2834b.j(parcel, a);
                    break;
                case 5:
                    z2 = C2834b.c(parcel, a);
                    break;
                case 6:
                    f2 = C2834b.j(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7857y(iBinder, z, f, z2, f2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7857y[i];
    }
}
