package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.u */
public final class C5164u implements Creator<C7877i> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        C7871c c7871c = str;
        UserAddress userAddress = c7871c;
        C7879k c7879k = userAddress;
        String str2 = c7879k;
        Bundle bundle = str2;
        String str3 = bundle;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    str = C2834b.n(parcel, a);
                    break;
                case 2:
                    c7871c = (C7871c) C2834b.a(parcel, a, C7871c.CREATOR);
                    break;
                case 3:
                    userAddress = (UserAddress) C2834b.a(parcel, a, UserAddress.CREATOR);
                    break;
                case 4:
                    c7879k = (C7879k) C2834b.a(parcel, a, C7879k.CREATOR);
                    break;
                case 5:
                    str2 = C2834b.n(parcel, a);
                    break;
                case 6:
                    bundle = C2834b.p(parcel, a);
                    break;
                case 7:
                    str3 = C2834b.n(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7877i(str, c7871c, userAddress, c7879k, str2, bundle, str3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7877i[i];
    }
}
