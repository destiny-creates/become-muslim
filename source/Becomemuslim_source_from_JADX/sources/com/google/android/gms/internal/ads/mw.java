package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class mw implements Creator<mv> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    str = C2834b.n(parcel, a);
                    break;
                case 3:
                    i = C2834b.g(parcel, a);
                    break;
                case 4:
                    i2 = C2834b.g(parcel, a);
                    break;
                case 5:
                    z = C2834b.c(parcel, a);
                    break;
                case 6:
                    z2 = C2834b.c(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new mv(str, i, i2, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new mv[i];
    }
}
