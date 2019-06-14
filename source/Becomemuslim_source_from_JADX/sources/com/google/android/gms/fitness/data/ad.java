package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ad implements Creator<RawDataPoint> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        long j = 0;
        long j2 = j;
        long j3 = j2;
        long j4 = j3;
        C4806h[] c4806hArr = null;
        int i = 0;
        int i2 = 0;
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
                    c4806hArr = (C4806h[]) C2834b.m8156b(parcel2, a, C4806h.CREATOR);
                    break;
                case 4:
                    i = C2834b.m8162g(parcel2, a);
                    break;
                case 5:
                    i2 = C2834b.m8162g(parcel2, a);
                    break;
                case 6:
                    j3 = C2834b.m8163h(parcel2, a);
                    break;
                case 7:
                    j4 = C2834b.m8163h(parcel2, a);
                    break;
                default:
                    C2834b.m8155b(parcel2, a);
                    break;
            }
        }
        C2834b.m8178w(parcel2, b);
        return new RawDataPoint(j, j2, c4806hArr, i, i2, j3, j4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new RawDataPoint[i];
    }
}
