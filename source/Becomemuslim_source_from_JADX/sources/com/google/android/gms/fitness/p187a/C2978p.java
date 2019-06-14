package com.google.android.gms.fitness.p187a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.fitness.data.DataSet;

/* renamed from: com.google.android.gms.fitness.a.p */
public final class C2978p implements Creator<C4798o> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        DataSet dataSet = null;
        IBinder iBinder = null;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            int a2 = C2834b.m8147a(a);
            if (a2 != 4) {
                switch (a2) {
                    case 1:
                        dataSet = (DataSet) C2834b.m8150a(parcel, a, DataSet.CREATOR);
                        break;
                    case 2:
                        iBinder = C2834b.m8170o(parcel, a);
                        break;
                    default:
                        C2834b.m8155b(parcel, a);
                        break;
                }
            }
            z = C2834b.m8158c(parcel, a);
        }
        C2834b.m8178w(parcel, b);
        return new C4798o(dataSet, iBinder, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4798o[i];
    }
}
