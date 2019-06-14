package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class arz implements Creator<ary> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    z = C2834b.c(parcel, a);
                    break;
                case 3:
                    z2 = C2834b.c(parcel, a);
                    break;
                case 4:
                    z3 = C2834b.c(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new ary(z, z2, z3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ary[i];
    }
}
