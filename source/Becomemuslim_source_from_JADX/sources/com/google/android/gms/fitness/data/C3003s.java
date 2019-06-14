package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.s */
public final class C3003s implements Creator<DataSet> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        List arrayList = new ArrayList();
        int i = 0;
        C4801a c4801a = null;
        List list = c4801a;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            int a2 = C2834b.m8147a(a);
            if (a2 == 1) {
                c4801a = (C4801a) C2834b.m8150a(parcel, a, C4801a.CREATOR);
            } else if (a2 != 1000) {
                switch (a2) {
                    case 3:
                        C2834b.m8153a(parcel, a, arrayList, getClass().getClassLoader());
                        break;
                    case 4:
                        list = C2834b.m8157c(parcel, a, C4801a.CREATOR);
                        break;
                    case 5:
                        z = C2834b.m8158c(parcel, a);
                        break;
                    default:
                        C2834b.m8155b(parcel, a);
                        break;
                }
            } else {
                i = C2834b.m8162g(parcel, a);
            }
        }
        C2834b.m8178w(parcel, b);
        return new DataSet(i, c4801a, arrayList, list, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataSet[i];
    }
}
