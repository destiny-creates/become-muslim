package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class tp implements Creator<to> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    i = C2834b.g(parcel, a);
                    break;
                case 2:
                    bArr = C2834b.q(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new to(i, bArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new to[i];
    }
}
