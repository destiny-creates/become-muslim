package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.location.y */
public final class C5089y implements Creator<C7841x> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = "";
        String str2 = "";
        String str3 = "";
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            int a2 = C2834b.a(a);
            if (a2 != 5) {
                switch (a2) {
                    case 1:
                        str2 = C2834b.n(parcel, a);
                        break;
                    case 2:
                        str3 = C2834b.n(parcel, a);
                        break;
                    default:
                        C2834b.b(parcel, a);
                        break;
                }
            }
            str = C2834b.n(parcel, a);
        }
        C2834b.w(parcel, b);
        return new C7841x(str, str2, str3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7841x[i];
    }
}
