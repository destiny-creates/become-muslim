package com.google.android.gms.p190g.p191a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.p190g.p191a.C4820a.C4809b;
import com.google.android.gms.p190g.p191a.C4820a.C4810c;

/* renamed from: com.google.android.gms.g.a.g */
public final class C3030g implements Creator<C4810c> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        C4809b c4809b = str5;
        C4809b c4809b2 = c4809b;
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
                    c4809b = (C4809b) C2834b.m8150a(parcel, a, C4809b.CREATOR);
                    break;
                case 8:
                    c4809b2 = (C4809b) C2834b.m8150a(parcel, a, C4809b.CREATOR);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4810c(str, str2, str3, str4, str5, c4809b, c4809b2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4810c[i];
    }
}
