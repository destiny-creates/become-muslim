package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ab implements Creator<C7838p> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    z = C2834b.c(parcel, a);
                    break;
                case 2:
                    z2 = C2834b.c(parcel, a);
                    break;
                case 3:
                    z3 = C2834b.c(parcel, a);
                    break;
                case 4:
                    z4 = C2834b.c(parcel, a);
                    break;
                case 5:
                    z5 = C2834b.c(parcel, a);
                    break;
                case 6:
                    z6 = C2834b.c(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7838p(z, z2, z3, z4, z5, z6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7838p[i];
    }
}
