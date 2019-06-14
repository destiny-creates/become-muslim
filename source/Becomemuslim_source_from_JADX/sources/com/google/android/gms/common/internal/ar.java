package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C4776d;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ar implements Creator<aq> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new aq[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        Bundle bundle = null;
        C4776d[] c4776dArr = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    bundle = C2834b.m8171p(parcel, a);
                    break;
                case 2:
                    c4776dArr = (C4776d[]) C2834b.m8156b(parcel, a, C4776d.CREATOR);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new aq(bundle, c4776dArr);
    }
}
