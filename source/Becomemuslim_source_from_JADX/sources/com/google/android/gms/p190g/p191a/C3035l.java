package com.google.android.gms.p190g.p191a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.p190g.p191a.C4820a.C4815h;

/* renamed from: com.google.android.gms.g.a.l */
public final class C3035l implements Creator<C4815h> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 2:
                    str = C2834b.m8169n(parcel, a);
                    break;
                case 3:
                    str2 = C2834b.m8169n(parcel, a);
                    break;
                case 4:
                    str3 = C2834b.m8169n(parcel, a);
                    break;
                case 5:
                    str4 = C2834b.m8169n(parcel, a);
                    break;
                case 6:
                    str5 = C2834b.m8169n(parcel, a);
                    break;
                case 7:
                    str6 = C2834b.m8169n(parcel, a);
                    break;
                case 8:
                    str7 = C2834b.m8169n(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4815h(str, str2, str3, str4, str5, str6, str7);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4815h[i];
    }
}
