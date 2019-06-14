package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.auth.api.signin.k */
public final class C2752k implements Creator<SignInAccount> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInAccount[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = "";
        String str2 = "";
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            int a2 = C2834b.m8147a(a);
            if (a2 != 4) {
                switch (a2) {
                    case 7:
                        googleSignInAccount = (GoogleSignInAccount) C2834b.m8150a(parcel, a, GoogleSignInAccount.CREATOR);
                        break;
                    case 8:
                        str2 = C2834b.m8169n(parcel, a);
                        break;
                    default:
                        C2834b.m8155b(parcel, a);
                        break;
                }
            }
            str = C2834b.m8169n(parcel, a);
        }
        C2834b.m8178w(parcel, b);
        return new SignInAccount(str, googleSignInAccount, str2);
    }
}
