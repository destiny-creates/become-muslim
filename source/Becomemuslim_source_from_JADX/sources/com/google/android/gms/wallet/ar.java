package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.ArrayList;

public final class ar implements Creator<C7874f> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        ArrayList arrayList = null;
        String str = arrayList;
        String str2 = str;
        ArrayList arrayList2 = str2;
        String str3 = arrayList2;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            int a2 = C2834b.a(a);
            if (a2 != 2) {
                switch (a2) {
                    case 4:
                        str = C2834b.n(parcel, a);
                        break;
                    case 5:
                        str2 = C2834b.n(parcel, a);
                        break;
                    case 6:
                        arrayList2 = C2834b.u(parcel, a);
                        break;
                    case 7:
                        z = C2834b.c(parcel, a);
                        break;
                    case 8:
                        str3 = C2834b.n(parcel, a);
                        break;
                    default:
                        C2834b.b(parcel, a);
                        break;
                }
            }
            arrayList = C2834b.u(parcel, a);
        }
        C2834b.w(parcel, b);
        return new C7874f(arrayList, str, str2, arrayList2, z, str3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7874f[i];
    }
}
