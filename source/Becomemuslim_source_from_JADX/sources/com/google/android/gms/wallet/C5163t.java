package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* renamed from: com.google.android.gms.wallet.t */
public final class C5163t implements Creator<C7876h> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
        CommonWalletObject commonWalletObject = str2;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    i = C2834b.g(parcel, a);
                    break;
                case 2:
                    str = C2834b.n(parcel, a);
                    break;
                case 3:
                    str2 = C2834b.n(parcel, a);
                    break;
                case 4:
                    commonWalletObject = (CommonWalletObject) C2834b.a(parcel, a, CommonWalletObject.CREATOR);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7876h(i, str, str2, commonWalletObject);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7876h[i];
    }
}
