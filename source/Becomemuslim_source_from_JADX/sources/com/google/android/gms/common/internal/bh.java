package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class bh implements Creator<bg> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new bg[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            if (C2834b.m8147a(a) != 1) {
                C2834b.m8155b(parcel, a);
            } else {
                i = C2834b.m8162g(parcel, a);
            }
        }
        C2834b.m8178w(parcel, b);
        return new bg(i);
    }
}
