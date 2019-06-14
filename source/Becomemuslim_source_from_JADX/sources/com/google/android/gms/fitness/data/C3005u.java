package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.fitness.data.u */
public final class C3005u implements Creator<C4801a> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        DataType dataType = null;
        String str = dataType;
        C4802b c4802b = str;
        C4807o c4807o = c4802b;
        String str2 = c4807o;
        int[] iArr = str2;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    dataType = (DataType) C2834b.m8150a(parcel, a, DataType.CREATOR);
                    break;
                case 2:
                    str = C2834b.m8169n(parcel, a);
                    break;
                case 3:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 4:
                    c4802b = (C4802b) C2834b.m8150a(parcel, a, C4802b.CREATOR);
                    break;
                case 5:
                    c4807o = (C4807o) C2834b.m8150a(parcel, a, C4807o.CREATOR);
                    break;
                case 6:
                    str2 = C2834b.m8169n(parcel, a);
                    break;
                case 8:
                    iArr = C2834b.m8173r(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4801a(dataType, str, i, c4802b, c4807o, str2, iArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4801a[i];
    }
}
