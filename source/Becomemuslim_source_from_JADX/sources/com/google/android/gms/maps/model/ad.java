package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ad implements Creator<C7847d> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        IBinder iBinder = null;
        int i = 0;
        Float f = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    i = C2834b.g(parcel, a);
                    break;
                case 3:
                    iBinder = C2834b.o(parcel, a);
                    break;
                case 4:
                    f = C2834b.k(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7847d(i, iBinder, f);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7847d[i];
    }
}
