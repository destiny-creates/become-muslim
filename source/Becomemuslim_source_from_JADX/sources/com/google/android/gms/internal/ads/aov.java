package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class aov implements Creator<aou> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        aou[] aouArr = str;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
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
                    i = C2834b.g(parcel, a);
                    break;
                case 4:
                    i2 = C2834b.g(parcel, a);
                    break;
                case 5:
                    z = C2834b.c(parcel, a);
                    break;
                case 6:
                    i3 = C2834b.g(parcel, a);
                    break;
                case 7:
                    i4 = C2834b.g(parcel, a);
                    break;
                case 8:
                    aouArr = (aou[]) C2834b.b(parcel, a, aou.CREATOR);
                    break;
                case 9:
                    z2 = C2834b.c(parcel, a);
                    break;
                case 10:
                    z3 = C2834b.c(parcel, a);
                    break;
                case 11:
                    z4 = C2834b.c(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new aou(str, i, i2, z, i3, i4, aouArr, z2, z3, z4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new aou[i];
    }
}
