package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.wallet.z */
public final class C5181z implements Creator<C7880l> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    i = C2834b.g(parcel, a);
                    break;
                case 3:
                    bundle = C2834b.p(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7880l(i, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7880l[i];
    }
}
