package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class gu implements Creator<gt> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        aoq aoq = null;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    aoq = (aoq) C2834b.a(parcel, a, aoq.CREATOR);
                    break;
                case 3:
                    str = C2834b.n(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new gt(aoq, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new gt[i];
    }
}
