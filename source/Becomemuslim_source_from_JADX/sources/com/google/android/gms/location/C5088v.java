package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

/* renamed from: com.google.android.gms.location.v */
public final class C5088v implements Creator<LocationResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        List list = LocationResult.f29165a;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            if (C2834b.a(a) != 1) {
                C2834b.b(parcel, a);
            } else {
                list = C2834b.c(parcel, a, Location.CREATOR);
            }
        }
        C2834b.w(parcel, b);
        return new LocationResult(list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationResult[i];
    }
}
