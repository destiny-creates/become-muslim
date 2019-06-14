package com.google.android.gms.p175c.p176a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.internal.C4787x;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.c.a.l */
public final class C2769l implements Creator<C4761k> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4761k[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        C4775b c4775b = null;
        int i = 0;
        C4787x c4787x = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 2:
                    c4775b = (C4775b) C2834b.m8150a(parcel, a, C4775b.CREATOR);
                    break;
                case 3:
                    c4787x = (C4787x) C2834b.m8150a(parcel, a, C4787x.CREATOR);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4761k(i, c4775b, c4787x);
    }
}
