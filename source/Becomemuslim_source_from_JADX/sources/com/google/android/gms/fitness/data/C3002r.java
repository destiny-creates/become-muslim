package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.fitness.data.r */
public final class C3002r implements Creator<DataPoint> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        C4801a c4801a = null;
        C4806h[] c4806hArr = c4801a;
        C4801a c4801a2 = c4806hArr;
        long j = 0;
        long j2 = j;
        long j3 = j2;
        long j4 = j3;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            int a2 = C2834b.m8147a(a);
            if (a2 != 1) {
                switch (a2) {
                    case 3:
                        j = C2834b.m8163h(parcel2, a);
                        break;
                    case 4:
                        j2 = C2834b.m8163h(parcel2, a);
                        break;
                    case 5:
                        c4806hArr = (C4806h[]) C2834b.m8156b(parcel2, a, C4806h.CREATOR);
                        break;
                    case 6:
                        c4801a2 = (C4801a) C2834b.m8150a(parcel2, a, C4801a.CREATOR);
                        break;
                    case 7:
                        j3 = C2834b.m8163h(parcel2, a);
                        break;
                    case 8:
                        j4 = C2834b.m8163h(parcel2, a);
                        break;
                    default:
                        C2834b.m8155b(parcel2, a);
                        break;
                }
            }
            c4801a = (C4801a) C2834b.m8150a(parcel2, a, C4801a.CREATOR);
        }
        C2834b.m8178w(parcel2, b);
        return new DataPoint(c4801a, j, j2, c4806hArr, c4801a2, j3, j4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataPoint[i];
    }
}
