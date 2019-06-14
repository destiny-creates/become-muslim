package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.auth.api.signin.internal.z */
public final class C2750z implements Creator<SignInConfiguration> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInConfiguration[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            int a2 = C2834b.m8147a(a);
            if (a2 == 2) {
                str = C2834b.m8169n(parcel, a);
            } else if (a2 != 5) {
                C2834b.m8155b(parcel, a);
            } else {
                googleSignInOptions = (GoogleSignInOptions) C2834b.m8150a(parcel, a, GoogleSignInOptions.CREATOR);
            }
        }
        C2834b.m8178w(parcel, b);
        return new SignInConfiguration(str, googleSignInOptions);
    }
}
