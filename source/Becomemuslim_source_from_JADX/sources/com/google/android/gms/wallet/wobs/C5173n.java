package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.wallet.wobs.n */
public final class C5173n implements Creator<C7888d> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        String str = null;
        String str2 = str;
        double d = 0.0d;
        long j = 0;
        int i = 0;
        int i2 = -1;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    i = C2834b.g(parcel2, a);
                    break;
                case 3:
                    str = C2834b.n(parcel2, a);
                    break;
                case 4:
                    d = C2834b.l(parcel2, a);
                    break;
                case 5:
                    str2 = C2834b.n(parcel2, a);
                    break;
                case 6:
                    j = C2834b.h(parcel2, a);
                    break;
                case 7:
                    i2 = C2834b.g(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new C7888d(i, str, d, str2, j, i2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7888d[i];
    }
}
