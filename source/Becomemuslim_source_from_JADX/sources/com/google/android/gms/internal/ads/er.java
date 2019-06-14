package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class er implements Creator<eq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            if (C2834b.a(a) != 2) {
                C2834b.b(parcel, a);
            } else {
                str = C2834b.n(parcel, a);
            }
        }
        C2834b.w(parcel, b);
        return new eq(str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new eq[i];
    }
}
