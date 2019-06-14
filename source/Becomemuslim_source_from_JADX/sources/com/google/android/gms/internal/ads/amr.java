package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class amr implements Creator<amq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        long j = 0;
        long j2 = j;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        Bundle bundle = str4;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    str = C2834b.n(parcel2, a);
                    break;
                case 3:
                    j = C2834b.h(parcel2, a);
                    break;
                case 4:
                    str2 = C2834b.n(parcel2, a);
                    break;
                case 5:
                    str3 = C2834b.n(parcel2, a);
                    break;
                case 6:
                    str4 = C2834b.n(parcel2, a);
                    break;
                case 7:
                    bundle = C2834b.p(parcel2, a);
                    break;
                case 8:
                    z = C2834b.c(parcel2, a);
                    break;
                case 9:
                    j2 = C2834b.h(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new amq(str, j, str2, str3, str4, bundle, z, j2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new amq[i];
    }
}
