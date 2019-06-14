package com.google.android.gms.internal.p213l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.internal.l.ar */
public final class ar implements Creator<aq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        an anVar = str;
        String str2 = anVar;
        long j = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    str = C2834b.n(parcel, a);
                    break;
                case 3:
                    anVar = (an) C2834b.a(parcel, a, an.CREATOR);
                    break;
                case 4:
                    str2 = C2834b.n(parcel, a);
                    break;
                case 5:
                    j = C2834b.h(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new aq(str, anVar, str2, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new aq[i];
    }
}
