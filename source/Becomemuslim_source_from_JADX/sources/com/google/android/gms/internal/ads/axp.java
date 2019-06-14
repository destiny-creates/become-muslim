package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

public final class axp implements Creator<axo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        String str = null;
        byte[] bArr = str;
        String[] strArr = bArr;
        String[] strArr2 = strArr;
        long j = 0;
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    z = C2834b.c(parcel2, a);
                    break;
                case 2:
                    str = C2834b.n(parcel2, a);
                    break;
                case 3:
                    i = C2834b.g(parcel2, a);
                    break;
                case 4:
                    bArr = C2834b.q(parcel2, a);
                    break;
                case 5:
                    strArr = C2834b.t(parcel2, a);
                    break;
                case 6:
                    strArr2 = C2834b.t(parcel2, a);
                    break;
                case 7:
                    z2 = C2834b.c(parcel2, a);
                    break;
                case 8:
                    j = C2834b.h(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new axo(z, str, i, bArr, strArr, strArr2, z2, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new axo[i];
    }
}
