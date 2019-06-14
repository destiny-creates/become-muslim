package com.google.android.gms.p175c.p176a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C4786w;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.c.a.j */
public final class C2768j implements Creator<C4760i> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4760i[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        int i = 0;
        C4786w c4786w = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 2:
                    c4786w = (C4786w) C2834b.m8150a(parcel, a, C4786w.CREATOR);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4760i(i, c4786w);
    }
}
