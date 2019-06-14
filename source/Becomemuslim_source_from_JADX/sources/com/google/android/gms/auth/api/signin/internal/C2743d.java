package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.auth.api.signin.internal.d */
public final class C2743d implements Creator<C4752a> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4752a[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        int i = 0;
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 2:
                    i2 = C2834b.m8162g(parcel, a);
                    break;
                case 3:
                    bundle = C2834b.m8171p(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4752a(i, i2, bundle);
    }
}
