package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class aa implements Creator<C7837o> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        Status status = null;
        C7838p c7838p = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    status = (Status) C2834b.a(parcel, a, Status.CREATOR);
                    break;
                case 2:
                    c7838p = (C7838p) C2834b.a(parcel, a, C7838p.CREATOR);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7837o(status, c7838p);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7837o[i];
    }
}
