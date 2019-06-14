package com.google.android.gms.p190g.p191a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.p190g.p191a.C4820a.C4812e;

/* renamed from: com.google.android.gms.g.a.i */
public final class C3032i implements Creator<C4812e> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        String str9 = str8;
        String str10 = str9;
        String str11 = str10;
        String str12 = str11;
        String str13 = str12;
        String str14 = str13;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
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
                    str5 = C2834b.m8169n(parcel2, a);
                    break;
                case 7:
                    str6 = C2834b.m8169n(parcel2, a);
                    break;
                case 8:
                    str7 = C2834b.m8169n(parcel2, a);
                    break;
                case 9:
                    str8 = C2834b.m8169n(parcel2, a);
                    break;
                case 10:
                    str9 = C2834b.m8169n(parcel2, a);
                    break;
                case 11:
                    str10 = C2834b.m8169n(parcel2, a);
                    break;
                case 12:
                    str11 = C2834b.m8169n(parcel2, a);
                    break;
                case 13:
                    str12 = C2834b.m8169n(parcel2, a);
                    break;
                case 14:
                    str13 = C2834b.m8169n(parcel2, a);
                    break;
                case 15:
                    str14 = C2834b.m8169n(parcel2, a);
                    break;
                default:
                    C2834b.m8155b(parcel2, a);
                    break;
            }
        }
        C2834b.m8178w(parcel2, b);
        return new C4812e(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4812e[i];
    }
}
