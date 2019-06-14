package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ao implements Creator<C7856w> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        int i = 0;
        byte[] bArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    i = C2834b.g(parcel, a);
                    break;
                case 3:
                    i2 = C2834b.g(parcel, a);
                    break;
                case 4:
                    bArr = C2834b.q(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7856w(i, i2, bArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7856w[i];
    }
}
