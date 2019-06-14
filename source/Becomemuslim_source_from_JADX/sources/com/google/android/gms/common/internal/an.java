package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class an implements Creator<C4786w> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4786w[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        Account account = null;
        int i = 0;
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 2:
                    account = (Account) C2834b.m8150a(parcel, a, Account.CREATOR);
                    break;
                case 3:
                    i2 = C2834b.m8162g(parcel, a);
                    break;
                case 4:
                    googleSignInAccount = (GoogleSignInAccount) C2834b.m8150a(parcel, a, GoogleSignInAccount.CREATOR);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4786w(i, account, i2, googleSignInAccount);
    }
}
