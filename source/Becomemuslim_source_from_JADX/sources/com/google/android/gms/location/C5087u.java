package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.location.u */
public final class C5087u implements Creator<LocationRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        long j = 3600000;
        long j2 = 600000;
        long j3 = Clock.MAX_TIME;
        long j4 = 0;
        int i = 102;
        boolean z = false;
        int i2 = Integer.MAX_VALUE;
        float f = 0.0f;
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
                    j2 = C2834b.h(parcel2, a);
                    break;
                case 4:
                    z = C2834b.c(parcel2, a);
                    break;
                case 5:
                    j3 = C2834b.h(parcel2, a);
                    break;
                case 6:
                    i2 = C2834b.g(parcel2, a);
                    break;
                case 7:
                    f = C2834b.j(parcel2, a);
                    break;
                case 8:
                    j4 = C2834b.h(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new LocationRequest(i, j, j2, z, j3, i2, f, j4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationRequest[i];
    }
}
