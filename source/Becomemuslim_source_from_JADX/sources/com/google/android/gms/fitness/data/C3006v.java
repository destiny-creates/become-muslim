package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.v */
public final class C3006v implements Creator<DataType> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        List list = null;
        String str2 = list;
        String str3 = str2;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    str = C2834b.m8169n(parcel, a);
                    break;
                case 2:
                    list = C2834b.m8157c(parcel, a, C4803c.CREATOR);
                    break;
                case 3:
                    str2 = C2834b.m8169n(parcel, a);
                    break;
                case 4:
                    str3 = C2834b.m8169n(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new DataType(str, list, str2, str3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataType[i];
    }
}
