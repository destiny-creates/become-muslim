package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.fitness.data.m */
public final class C2998m implements Creator<C4805g> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        C4801a c4801a = null;
        DataType dataType = c4801a;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    c4801a = (C4801a) C2834b.m8150a(parcel, a, C4801a.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) C2834b.m8150a(parcel, a, DataType.CREATOR);
                    break;
                case 3:
                    j = C2834b.m8163h(parcel, a);
                    break;
                case 4:
                    i = C2834b.m8162g(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4805g(c4801a, dataType, j, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4805g[i];
    }
}
