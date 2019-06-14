package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.common.util.C2892b;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.k */
public final class C5170k implements Creator<CommonWalletObject> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        ArrayList a = C2892b.a();
        ArrayList a2 = C2892b.a();
        ArrayList a3 = C2892b.a();
        ArrayList a4 = C2892b.a();
        ArrayList arrayList = a;
        ArrayList arrayList2 = a2;
        ArrayList arrayList3 = a3;
        ArrayList arrayList4 = a4;
        ArrayList a5 = C2892b.a();
        ArrayList a6 = C2892b.a();
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        C7890f c7890f = str8;
        String str9 = c7890f;
        String str10 = str9;
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a7 = C2834b.a(parcel);
            switch (C2834b.a(a7)) {
                case 2:
                    str = C2834b.n(parcel2, a7);
                    break;
                case 3:
                    str2 = C2834b.n(parcel2, a7);
                    break;
                case 4:
                    str3 = C2834b.n(parcel2, a7);
                    break;
                case 5:
                    str4 = C2834b.n(parcel2, a7);
                    break;
                case 6:
                    str5 = C2834b.n(parcel2, a7);
                    break;
                case 7:
                    str6 = C2834b.n(parcel2, a7);
                    break;
                case 8:
                    str7 = C2834b.n(parcel2, a7);
                    break;
                case 9:
                    str8 = C2834b.n(parcel2, a7);
                    break;
                case 10:
                    i = C2834b.g(parcel2, a7);
                    break;
                case 11:
                    arrayList = C2834b.c(parcel2, a7, C7892h.CREATOR);
                    break;
                case 12:
                    c7890f = (C7890f) C2834b.a(parcel2, a7, C7890f.CREATOR);
                    break;
                case 13:
                    arrayList2 = C2834b.c(parcel2, a7, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = C2834b.n(parcel2, a7);
                    break;
                case 15:
                    str10 = C2834b.n(parcel2, a7);
                    break;
                case 16:
                    arrayList3 = C2834b.c(parcel2, a7, C7886b.CREATOR);
                    break;
                case 17:
                    z = C2834b.c(parcel2, a7);
                    break;
                case 18:
                    arrayList4 = C2834b.c(parcel2, a7, C7891g.CREATOR);
                    break;
                case 19:
                    a5 = C2834b.c(parcel2, a7, C7889e.CREATOR);
                    break;
                case 20:
                    a6 = C2834b.c(parcel2, a7, C7891g.CREATOR);
                    break;
                default:
                    C2834b.b(parcel2, a7);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new CommonWalletObject(str, str2, str3, str4, str5, str6, str7, str8, i, arrayList, c7890f, arrayList2, str9, str10, arrayList3, z, arrayList4, a5, a6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CommonWalletObject[i];
    }
}
