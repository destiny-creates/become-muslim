package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class at implements Creator<MaskedWallet> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        String str2 = str;
        String[] strArr = str2;
        String str3 = strArr;
        C7884s c7884s = str3;
        C7884s c7884s2 = c7884s;
        C7875g[] c7875gArr = c7884s2;
        C7876h[] c7876hArr = c7875gArr;
        UserAddress userAddress = c7876hArr;
        UserAddress userAddress2 = userAddress;
        C7873e[] c7873eArr = userAddress2;
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
                    strArr = C2834b.t(parcel, a);
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
                    c7875gArr = (C7875g[]) C2834b.b(parcel, a, C7875g.CREATOR);
                    break;
                case 9:
                    c7876hArr = (C7876h[]) C2834b.b(parcel, a, C7876h.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) C2834b.a(parcel, a, UserAddress.CREATOR);
                    break;
                case 11:
                    userAddress2 = (UserAddress) C2834b.a(parcel, a, UserAddress.CREATOR);
                    break;
                case 12:
                    c7873eArr = (C7873e[]) C2834b.b(parcel, a, C7873e.CREATOR);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new MaskedWallet(str, str2, strArr, str3, c7884s, c7884s2, c7875gArr, c7876hArr, userAddress, userAddress2, c7873eArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MaskedWallet[i];
    }
}
