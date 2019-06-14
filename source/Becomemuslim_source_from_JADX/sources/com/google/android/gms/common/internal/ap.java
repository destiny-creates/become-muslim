package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ap implements Creator<C4788y> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4788y[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
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
                    i3 = C2834b.m8162g(parcel, a);
                    break;
                case 4:
                    scopeArr = (Scope[]) C2834b.m8156b(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4788y(i, i2, i3, scopeArr);
    }
}
