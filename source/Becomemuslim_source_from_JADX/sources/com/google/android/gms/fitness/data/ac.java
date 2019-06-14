package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

public final class ac implements Creator<RawBucket> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        C4804f c4804f = null;
        List list = c4804f;
        long j = 0;
        long j2 = j;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    j = C2834b.m8163h(parcel2, a);
                    break;
                case 2:
                    j2 = C2834b.m8163h(parcel2, a);
                    break;
                case 3:
                    c4804f = (C4804f) C2834b.m8150a(parcel2, a, C4804f.CREATOR);
                    break;
                case 4:
                    i = C2834b.m8162g(parcel2, a);
                    break;
                case 5:
                    list = C2834b.m8157c(parcel2, a, RawDataSet.CREATOR);
                    break;
                case 6:
                    i2 = C2834b.m8162g(parcel2, a);
                    break;
                case 7:
                    z = C2834b.m8158c(parcel2, a);
                    break;
                default:
                    C2834b.m8155b(parcel2, a);
                    break;
            }
        }
        C2834b.m8178w(parcel2, b);
        return new RawBucket(j, j2, c4804f, i, list, i2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new RawBucket[i];
    }
}
