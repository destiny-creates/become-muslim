package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

/* renamed from: com.google.android.gms.auth.i */
public final class C2755i implements Creator<TokenData> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new TokenData[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        Long l = str;
        List list = l;
        String str2 = list;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 2:
                    str = C2834b.m8169n(parcel, a);
                    break;
                case 3:
                    l = C2834b.m8164i(parcel, a);
                    break;
                case 4:
                    z = C2834b.m8158c(parcel, a);
                    break;
                case 5:
                    z2 = C2834b.m8158c(parcel, a);
                    break;
                case 6:
                    list = C2834b.m8177v(parcel, a);
                    break;
                case 7:
                    str2 = C2834b.m8169n(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new TokenData(i, str, l, z, z2, list, str2);
    }
}
