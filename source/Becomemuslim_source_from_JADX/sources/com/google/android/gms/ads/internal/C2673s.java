package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.ads.internal.s */
public final class C2673s implements Creator<C4744r> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f = 0.0f;
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 2:
                    z = C2834b.m8158c(parcel, a);
                    break;
                case 3:
                    z2 = C2834b.m8158c(parcel, a);
                    break;
                case 4:
                    str = C2834b.m8169n(parcel, a);
                    break;
                case 5:
                    z3 = C2834b.m8158c(parcel, a);
                    break;
                case 6:
                    f = C2834b.m8165j(parcel, a);
                    break;
                case 7:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 8:
                    z4 = C2834b.m8158c(parcel, a);
                    break;
                case 9:
                    z5 = C2834b.m8158c(parcel, a);
                    break;
                case 10:
                    z6 = C2834b.m8158c(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4744r(z, z2, str, z3, f, i, z4, z5, z6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4744r[i];
    }
}
