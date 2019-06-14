package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.wallet.wobs.s */
public final class C5178s implements Creator<C7892h> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        String str2 = str;
        C7890f c7890f = str2;
        C7891g c7891g = c7890f;
        C7891g c7891g2 = c7891g;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    str = C2834b.n(parcel, a);
                    break;
                case 3:
                    str2 = C2834b.n(parcel, a);
                    break;
                case 4:
                    c7890f = (C7890f) C2834b.a(parcel, a, C7890f.CREATOR);
                    break;
                case 5:
                    c7891g = (C7891g) C2834b.a(parcel, a, C7891g.CREATOR);
                    break;
                case 6:
                    c7891g2 = (C7891g) C2834b.a(parcel, a, C7891g.CREATOR);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7892h(str, str2, c7890f, c7891g, c7891g2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7892h[i];
    }
}
