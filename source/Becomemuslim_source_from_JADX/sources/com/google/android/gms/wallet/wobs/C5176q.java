package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.wallet.wobs.q */
public final class C5176q implements Creator<C7890f> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    j = C2834b.h(parcel, a);
                    break;
                case 3:
                    j2 = C2834b.h(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7890f(j, j2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7890f[i];
    }
}
