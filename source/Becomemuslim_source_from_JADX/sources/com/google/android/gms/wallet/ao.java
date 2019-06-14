package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class ao implements Creator<FullWallet> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        String str2 = str;
        C7881o c7881o = str2;
        String str3 = c7881o;
        C7884s c7884s = str3;
        C7884s c7884s2 = c7884s;
        String[] strArr = c7884s2;
        UserAddress userAddress = strArr;
        UserAddress userAddress2 = userAddress;
        C7873e[] c7873eArr = userAddress2;
        C7879k c7879k = c7873eArr;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    str = C2834b.n(parcel, a);
                    break;
                case 3:
                    str2 = C2834b.n(parcel, a);
                    break;
                case 4:
                    c7881o = (C7881o) C2834b.a(parcel, a, C7881o.CREATOR);
                    break;
                case 5:
                    str3 = C2834b.n(parcel, a);
                    break;
                case 6:
                    c7884s = (C7884s) C2834b.a(parcel, a, C7884s.CREATOR);
                    break;
                case 7:
                    c7884s2 = (C7884s) C2834b.a(parcel, a, C7884s.CREATOR);
                    break;
                case 8:
                    strArr = C2834b.t(parcel, a);
                    break;
                case 9:
                    userAddress = (UserAddress) C2834b.a(parcel, a, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress2 = (UserAddress) C2834b.a(parcel, a, UserAddress.CREATOR);
                    break;
                case 11:
                    c7873eArr = (C7873e[]) C2834b.b(parcel, a, C7873e.CREATOR);
                    break;
                case 12:
                    c7879k = (C7879k) C2834b.a(parcel, a, C7879k.CREATOR);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new FullWallet(str, str2, c7881o, str3, c7884s, c7884s2, strArr, userAddress, userAddress2, c7873eArr, c7879k);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new FullWallet[i];
    }
}
