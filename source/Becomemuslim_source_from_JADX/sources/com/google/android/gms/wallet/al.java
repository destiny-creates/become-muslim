package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class al implements Creator<C7871c> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        String str2 = str;
        String str3 = str2;
        UserAddress userAddress = str3;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    str = C2834b.n(parcel, a);
                    break;
                case 2:
                    str2 = C2834b.n(parcel, a);
                    break;
                case 3:
                    str3 = C2834b.n(parcel, a);
                    break;
                case 4:
                    i = C2834b.g(parcel, a);
                    break;
                case 5:
                    userAddress = (UserAddress) C2834b.a(parcel, a, UserAddress.CREATOR);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7871c(str, str2, str3, i, userAddress);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7871c[i];
    }
}
