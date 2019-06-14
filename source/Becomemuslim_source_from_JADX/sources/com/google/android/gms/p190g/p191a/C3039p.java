package com.google.android.gms.p190g.p191a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.p190g.p191a.C4820a.C4819l;

/* renamed from: com.google.android.gms.g.a.p */
public final class C3039p implements Creator<C4819l> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        String str2 = null;
        int i = 0;
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
                    i = C2834b.m8162g(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4819l(str, str2, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4819l[i];
    }
}
