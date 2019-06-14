package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C4776d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class as implements Creator<C4784i> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4784i[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        String str = null;
        IBinder iBinder = str;
        Scope[] scopeArr = iBinder;
        Bundle bundle = scopeArr;
        Account account = bundle;
        C4776d[] c4776dArr = account;
        C4776d[] c4776dArr2 = c4776dArr;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel2, a);
                    break;
                case 2:
                    i2 = C2834b.m8162g(parcel2, a);
                    break;
                case 3:
                    i3 = C2834b.m8162g(parcel2, a);
                    break;
                case 4:
                    str = C2834b.m8169n(parcel2, a);
                    break;
                case 5:
                    iBinder = C2834b.m8170o(parcel2, a);
                    break;
                case 6:
                    scopeArr = (Scope[]) C2834b.m8156b(parcel2, a, Scope.CREATOR);
                    break;
                case 7:
                    bundle = C2834b.m8171p(parcel2, a);
                    break;
                case 8:
                    account = (Account) C2834b.m8150a(parcel2, a, Account.CREATOR);
                    break;
                case 10:
                    c4776dArr = (C4776d[]) C2834b.m8156b(parcel2, a, C4776d.CREATOR);
                    break;
                case 11:
                    c4776dArr2 = (C4776d[]) C2834b.m8156b(parcel2, a, C4776d.CREATOR);
                    break;
                case 12:
                    z = C2834b.m8158c(parcel2, a);
                    break;
                default:
                    C2834b.m8155b(parcel2, a);
                    break;
            }
        }
        C2834b.m8178w(parcel2, b);
        return new C4784i(i, i2, i3, str, iBinder, scopeArr, bundle, account, c4776dArr, c4776dArr2, z);
    }
}
