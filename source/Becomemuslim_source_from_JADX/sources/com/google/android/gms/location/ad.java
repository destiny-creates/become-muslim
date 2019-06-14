package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ad implements Creator<ac> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        long j = -1;
        long j2 = j;
        int i = 1;
        int i2 = 1;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    i = C2834b.g(parcel, a);
                    break;
                case 2:
                    i2 = C2834b.g(parcel, a);
                    break;
                case 3:
                    j = C2834b.h(parcel, a);
                    break;
                case 4:
                    j2 = C2834b.h(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new ac(i, i2, j, j2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ac[i];
    }
}
