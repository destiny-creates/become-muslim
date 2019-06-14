package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class ao implements Creator<C4787x> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4787x[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        IBinder iBinder = null;
        C4775b c4775b = iBinder;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 2:
                    iBinder = C2834b.m8170o(parcel, a);
                    break;
                case 3:
                    c4775b = (C4775b) C2834b.m8150a(parcel, a, C4775b.CREATOR);
                    break;
                case 4:
                    z = C2834b.m8158c(parcel, a);
                    break;
                case 5:
                    z2 = C2834b.m8158c(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4787x(i, iBinder, c4775b, z, z2);
    }
}
