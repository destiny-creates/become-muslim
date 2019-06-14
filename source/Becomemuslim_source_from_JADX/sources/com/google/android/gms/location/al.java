package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.internal.p211j.aj;
import java.util.List;

public final class al implements Creator<C7835j> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = "";
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    list = C2834b.c(parcel, a, aj.CREATOR);
                    break;
                case 2:
                    i = C2834b.g(parcel, a);
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
        return new C7835j(list, i, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7835j[i];
    }
}
