package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

public final class ib implements Creator<ia> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        String str2 = str;
        List list = str2;
        List list2 = list;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    str = C2834b.n(parcel, a);
                    break;
                case 3:
                    str2 = C2834b.n(parcel, a);
                    break;
                case 4:
                    z = C2834b.c(parcel, a);
                    break;
                case 5:
                    z2 = C2834b.c(parcel, a);
                    break;
                case 6:
                    list = C2834b.v(parcel, a);
                    break;
                case 7:
                    z3 = C2834b.c(parcel, a);
                    break;
                case 8:
                    z4 = C2834b.c(parcel, a);
                    break;
                case 9:
                    list2 = C2834b.v(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new ia(str, str2, z, z2, list, z3, z4, list2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ia[i];
    }
}
