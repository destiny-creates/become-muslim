package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.fitness.data.w */
public final class C3007w implements Creator<C4802b> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        String str2 = str;
        String str3 = str2;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    str = C2834b.m8169n(parcel, a);
                    break;
                case 2:
                    str2 = C2834b.m8169n(parcel, a);
                    break;
                case 4:
                    str3 = C2834b.m8169n(parcel, a);
                    break;
                case 5:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 6:
                    i2 = C2834b.m8162g(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4802b(str, str2, str3, i, i2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4802b[i];
    }
}
