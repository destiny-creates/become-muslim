package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class axn implements Creator<axm> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        String[] strArr = null;
        String[] strArr2 = strArr;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    str = C2834b.n(parcel, a);
                    break;
                case 2:
                    strArr = C2834b.t(parcel, a);
                    break;
                case 3:
                    strArr2 = C2834b.t(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new axm(str, strArr, strArr2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new axm[i];
    }
}
