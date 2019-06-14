package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

/* renamed from: com.google.android.gms.auth.api.signin.g */
public final class C2738g implements Creator<GoogleSignInAccount> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        Uri uri = str4;
        String str5 = uri;
        String str6 = str5;
        List list = str6;
        String str7 = list;
        String str8 = str7;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel2, a);
                    break;
                case 2:
                    str = C2834b.m8169n(parcel2, a);
                    break;
                case 3:
                    str2 = C2834b.m8169n(parcel2, a);
                    break;
                case 4:
                    str3 = C2834b.m8169n(parcel2, a);
                    break;
                case 5:
                    str4 = C2834b.m8169n(parcel2, a);
                    break;
                case 6:
                    uri = (Uri) C2834b.m8150a(parcel2, a, Uri.CREATOR);
                    break;
                case 7:
                    str5 = C2834b.m8169n(parcel2, a);
                    break;
                case 8:
                    j = C2834b.m8163h(parcel2, a);
                    break;
                case 9:
                    str6 = C2834b.m8169n(parcel2, a);
                    break;
                case 10:
                    list = C2834b.m8157c(parcel2, a, Scope.CREATOR);
                    break;
                case 11:
                    str7 = C2834b.m8169n(parcel2, a);
                    break;
                case 12:
                    str8 = C2834b.m8169n(parcel2, a);
                    break;
                default:
                    C2834b.m8155b(parcel2, a);
                    break;
            }
        }
        C2834b.m8178w(parcel2, b);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
    }
}
