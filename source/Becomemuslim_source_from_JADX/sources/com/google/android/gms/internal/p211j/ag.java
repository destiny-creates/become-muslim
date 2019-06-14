package com.google.android.gms.internal.p211j;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C4783e;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* renamed from: com.google.android.gms.internal.j.ag */
public final class ag implements Creator<af> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        List list = af.f28928a;
        LocationRequest locationRequest = null;
        String str = locationRequest;
        String str2 = str;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            int a2 = C2834b.a(a);
            if (a2 != 1) {
                switch (a2) {
                    case 5:
                        list = C2834b.c(parcel, a, C4783e.CREATOR);
                        break;
                    case 6:
                        str = C2834b.n(parcel, a);
                        break;
                    case 7:
                        z = C2834b.c(parcel, a);
                        break;
                    case 8:
                        z2 = C2834b.c(parcel, a);
                        break;
                    case 9:
                        z3 = C2834b.c(parcel, a);
                        break;
                    case 10:
                        str2 = C2834b.n(parcel, a);
                        break;
                    default:
                        C2834b.b(parcel, a);
                        break;
                }
            }
            locationRequest = (LocationRequest) C2834b.a(parcel, a, LocationRequest.CREATOR);
        }
        C2834b.w(parcel, b);
        return new af(locationRequest, list, str, z, z2, z3, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new af[i];
    }
}
