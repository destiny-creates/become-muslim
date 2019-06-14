package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

/* renamed from: com.google.android.gms.location.z */
public final class C5090z implements Creator<C7836n> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        boolean z = false;
        List list = null;
        C7841x c7841x = null;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            int a2 = C2834b.a(a);
            if (a2 != 5) {
                switch (a2) {
                    case 1:
                        list = C2834b.c(parcel, a, LocationRequest.CREATOR);
                        break;
                    case 2:
                        z = C2834b.c(parcel, a);
                        break;
                    case 3:
                        z2 = C2834b.c(parcel, a);
                        break;
                    default:
                        C2834b.b(parcel, a);
                        break;
                }
            }
            c7841x = (C7841x) C2834b.a(parcel, a, C7841x.CREATOR);
        }
        C2834b.w(parcel, b);
        return new C7836n(list, z, z2, c7841x);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7836n[i];
    }
}
