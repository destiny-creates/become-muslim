package com.google.android.gms.p190g.p191a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.p190g.p191a.C4820a.C4814g;

/* renamed from: com.google.android.gms.g.a.k */
public final class C3034k implements Creator<C4814g> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        double d = 0.0d;
        double d2 = 0.0d;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 2:
                    d = C2834b.m8167l(parcel, a);
                    break;
                case 3:
                    d2 = C2834b.m8167l(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4814g(d, d2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4814g[i];
    }
}
