package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

public final class aos implements Creator<aoq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        Bundle bundle = null;
        List list = bundle;
        String str = list;
        aru aru = str;
        Location location = aru;
        String str2 = location;
        Bundle bundle2 = str2;
        Bundle bundle3 = bundle2;
        List list2 = bundle3;
        String str3 = list2;
        String str4 = str3;
        long j = 0;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    i = C2834b.g(parcel2, a);
                    break;
                case 2:
                    j = C2834b.h(parcel2, a);
                    break;
                case 3:
                    bundle = C2834b.p(parcel2, a);
                    break;
                case 4:
                    i2 = C2834b.g(parcel2, a);
                    break;
                case 5:
                    list = C2834b.v(parcel2, a);
                    break;
                case 6:
                    z = C2834b.c(parcel2, a);
                    break;
                case 7:
                    i3 = C2834b.g(parcel2, a);
                    break;
                case 8:
                    z2 = C2834b.c(parcel2, a);
                    break;
                case 9:
                    str = C2834b.n(parcel2, a);
                    break;
                case 10:
                    aru = (aru) C2834b.a(parcel2, a, aru.CREATOR);
                    break;
                case 11:
                    location = (Location) C2834b.a(parcel2, a, Location.CREATOR);
                    break;
                case 12:
                    str2 = C2834b.n(parcel2, a);
                    break;
                case 13:
                    bundle2 = C2834b.p(parcel2, a);
                    break;
                case 14:
                    bundle3 = C2834b.p(parcel2, a);
                    break;
                case 15:
                    list2 = C2834b.v(parcel2, a);
                    break;
                case 16:
                    str3 = C2834b.n(parcel2, a);
                    break;
                case 17:
                    str4 = C2834b.n(parcel2, a);
                    break;
                case 18:
                    z3 = C2834b.c(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new aoq(i, j, bundle, i2, list, z, i3, z2, str, aru, location, str2, bundle2, bundle3, list2, str3, str4, z3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new aoq[i];
    }
}
