package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.common.z */
public final class C2915z implements Creator<C4790y> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4790y[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    str = C2834b.m8169n(parcel, a);
                    break;
                case 2:
                    iBinder = C2834b.m8170o(parcel, a);
                    break;
                case 3:
                    z = C2834b.m8158c(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4790y(str, iBinder, z);
    }
}
