package com.google.android.gms.internal.p211j;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.internal.j.ak */
public final class ak implements Creator<aj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        double d = 0.0d;
        double d2 = d;
        String str = null;
        long j = 0;
        int i = 0;
        short s = (short) 0;
        float f = 0.0f;
        int i2 = 0;
        int i3 = -1;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    str = C2834b.n(parcel2, a);
                    break;
                case 2:
                    j = C2834b.h(parcel2, a);
                    break;
                case 3:
                    s = C2834b.f(parcel2, a);
                    break;
                case 4:
                    d = C2834b.l(parcel2, a);
                    break;
                case 5:
                    d2 = C2834b.l(parcel2, a);
                    break;
                case 6:
                    f = C2834b.j(parcel2, a);
                    break;
                case 7:
                    i = C2834b.g(parcel2, a);
                    break;
                case 8:
                    i2 = C2834b.g(parcel2, a);
                    break;
                case 9:
                    i3 = C2834b.g(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new aj(str, i, s, d, d2, f, j, i2, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new aj[i];
    }
}
