package com.google.android.gms.internal.p213l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.internal.l.fu */
public final class fu implements Creator<ft> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        String str = null;
        Long l = str;
        Float f = l;
        String str2 = f;
        String str3 = str2;
        Double d = str3;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    i = C2834b.g(parcel2, a);
                    break;
                case 2:
                    str = C2834b.n(parcel2, a);
                    break;
                case 3:
                    j = C2834b.h(parcel2, a);
                    break;
                case 4:
                    l = C2834b.i(parcel2, a);
                    break;
                case 5:
                    f = C2834b.k(parcel2, a);
                    break;
                case 6:
                    str2 = C2834b.n(parcel2, a);
                    break;
                case 7:
                    str3 = C2834b.n(parcel2, a);
                    break;
                case 8:
                    d = C2834b.m(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new ft(i, str, j, l, f, str2, str3, d);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ft[i];
    }
}
