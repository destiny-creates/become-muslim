package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.j */
public final class C2995j implements Creator<RawDataSet> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        int i = 0;
        List list = null;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            int a2 = C2834b.m8147a(a);
            if (a2 != 1) {
                switch (a2) {
                    case 3:
                        list = C2834b.m8157c(parcel, a, RawDataPoint.CREATOR);
                        break;
                    case 4:
                        z = C2834b.m8158c(parcel, a);
                        break;
                    default:
                        C2834b.m8155b(parcel, a);
                        break;
                }
            }
            i = C2834b.m8162g(parcel, a);
        }
        C2834b.m8178w(parcel, b);
        return new RawDataSet(i, list, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new RawDataSet[i];
    }
}
