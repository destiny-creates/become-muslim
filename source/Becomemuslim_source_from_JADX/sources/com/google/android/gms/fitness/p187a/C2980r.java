package com.google.android.gms.fitness.p187a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.fitness.data.C4801a;
import com.google.android.gms.fitness.data.C4802b;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.a.r */
public final class C2980r implements Creator<C4792a> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        long j = 0;
        long j2 = j;
        long j3 = j2;
        List list = null;
        List list2 = list;
        List list3 = list2;
        List list4 = list3;
        C4801a c4801a = list4;
        IBinder iBinder = c4801a;
        List list5 = iBinder;
        List list6 = list5;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    list = C2834b.m8157c(parcel2, a, DataType.CREATOR);
                    break;
                case 2:
                    list2 = C2834b.m8157c(parcel2, a, C4801a.CREATOR);
                    break;
                case 3:
                    j = C2834b.m8163h(parcel2, a);
                    break;
                case 4:
                    j2 = C2834b.m8163h(parcel2, a);
                    break;
                case 5:
                    list3 = C2834b.m8157c(parcel2, a, DataType.CREATOR);
                    break;
                case 6:
                    list4 = C2834b.m8157c(parcel2, a, C4801a.CREATOR);
                    break;
                case 7:
                    i = C2834b.m8162g(parcel2, a);
                    break;
                case 8:
                    j3 = C2834b.m8163h(parcel2, a);
                    break;
                case 9:
                    c4801a = (C4801a) C2834b.m8150a(parcel2, a, C4801a.CREATOR);
                    break;
                case 10:
                    i2 = C2834b.m8162g(parcel2, a);
                    break;
                case 12:
                    z = C2834b.m8158c(parcel2, a);
                    break;
                case 13:
                    z2 = C2834b.m8158c(parcel2, a);
                    break;
                case 14:
                    iBinder = C2834b.m8170o(parcel2, a);
                    break;
                case 16:
                    list5 = C2834b.m8157c(parcel2, a, C4802b.CREATOR);
                    break;
                case 17:
                    list6 = C2834b.m8176u(parcel2, a);
                    break;
                default:
                    C2834b.m8155b(parcel2, a);
                    break;
            }
        }
        C2834b.m8178w(parcel2, b);
        return new C4792a(list, list2, j, j2, list3, list4, i, j3, c4801a, i2, z, z2, iBinder, list5, list6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4792a[i];
    }
}
