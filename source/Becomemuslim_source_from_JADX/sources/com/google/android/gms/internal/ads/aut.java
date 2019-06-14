package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class aut implements Creator<aus> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        ary ary = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    i = C2834b.g(parcel, a);
                    break;
                case 2:
                    z = C2834b.c(parcel, a);
                    break;
                case 3:
                    i2 = C2834b.g(parcel, a);
                    break;
                case 4:
                    z2 = C2834b.c(parcel, a);
                    break;
                case 5:
                    i3 = C2834b.g(parcel, a);
                    break;
                case 6:
                    ary = (ary) C2834b.a(parcel, a, ary.CREATOR);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new aus(i, z, i2, z2, i3, ary);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new aus[i];
    }
}
