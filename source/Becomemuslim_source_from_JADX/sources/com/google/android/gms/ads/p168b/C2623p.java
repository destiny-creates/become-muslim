package com.google.android.gms.ads.p168b;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.ads.b.p */
public final class C2623p implements Creator<C4735l> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        boolean z = false;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    z = C2834b.m8158c(parcel, a);
                    break;
                case 2:
                    iBinder = C2834b.m8170o(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4735l(z, iBinder);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4735l[i];
    }
}
