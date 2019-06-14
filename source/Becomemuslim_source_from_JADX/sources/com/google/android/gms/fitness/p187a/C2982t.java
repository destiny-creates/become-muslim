package com.google.android.gms.fitness.p187a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.a.t */
public final class C2982t implements Creator<C4793b> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        List list = null;
        List list2 = null;
        IBinder iBinder = list2;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    list = C2834b.m8157c(parcel, a, DataType.CREATOR);
                    break;
                case 2:
                    list2 = C2834b.m8176u(parcel, a);
                    break;
                case 3:
                    z = C2834b.m8158c(parcel, a);
                    break;
                case 4:
                    iBinder = C2834b.m8170o(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4793b(list, list2, z, iBinder);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4793b[i];
    }
}
