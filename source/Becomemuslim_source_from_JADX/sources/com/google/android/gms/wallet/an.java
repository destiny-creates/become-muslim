package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.ArrayList;

public final class an implements Creator<C7872d> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        boolean z = false;
        ArrayList arrayList = null;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    arrayList = C2834b.u(parcel, a);
                    break;
                case 2:
                    z2 = C2834b.c(parcel, a);
                    break;
                case 3:
                    z = C2834b.c(parcel, a);
                    break;
                case 4:
                    i = C2834b.g(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7872d(arrayList, z2, z, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7872d[i];
    }
}
