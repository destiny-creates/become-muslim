package com.google.android.gms.fitness.p187a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.fitness.data.C4805g;

/* renamed from: com.google.android.gms.fitness.a.n */
public final class C2977n implements Creator<C4797m> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        C4805g c4805g = null;
        boolean z = false;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    c4805g = (C4805g) C2834b.m8150a(parcel, a, C4805g.CREATOR);
                    break;
                case 2:
                    z = C2834b.m8158c(parcel, a);
                    break;
                case 3:
                    iBinder = C2834b.m8170o(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4797m(c4805g, z, iBinder);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4797m[i];
    }
}
