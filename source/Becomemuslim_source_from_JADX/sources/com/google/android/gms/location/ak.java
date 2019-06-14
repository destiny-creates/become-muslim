package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ak implements Creator<aj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        long j = 50;
        long j2 = Clock.MAX_TIME;
        boolean z = true;
        float f = 0.0f;
        int i = Integer.MAX_VALUE;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    z = C2834b.c(parcel2, a);
                    break;
                case 2:
                    j = C2834b.h(parcel2, a);
                    break;
                case 3:
                    f = C2834b.j(parcel2, a);
                    break;
                case 4:
                    j2 = C2834b.h(parcel2, a);
                    break;
                case 5:
                    i = C2834b.g(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new aj(z, j, f, j2, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new aj[i];
    }
}
