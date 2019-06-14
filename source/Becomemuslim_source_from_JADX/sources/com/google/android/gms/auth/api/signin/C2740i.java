package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.internal.C4752a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.auth.api.signin.i */
public final class C2740i implements Creator<GoogleSignInOptions> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        ArrayList arrayList = null;
        Account account = arrayList;
        String str = account;
        String str2 = str;
        ArrayList arrayList2 = str2;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 2:
                    arrayList = C2834b.m8157c(parcel, a, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) C2834b.m8150a(parcel, a, Account.CREATOR);
                    break;
                case 4:
                    z = C2834b.m8158c(parcel, a);
                    break;
                case 5:
                    z2 = C2834b.m8158c(parcel, a);
                    break;
                case 6:
                    z3 = C2834b.m8158c(parcel, a);
                    break;
                case 7:
                    str = C2834b.m8169n(parcel, a);
                    break;
                case 8:
                    str2 = C2834b.m8169n(parcel, a);
                    break;
                case 9:
                    arrayList2 = C2834b.m8157c(parcel, a, C4752a.CREATOR);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new GoogleSignInOptions(i, arrayList, account, z, z2, z3, str, str2, arrayList2);
    }
}
