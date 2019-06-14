package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.firebase.messaging.g */
public final class C5378g implements Creator<C7917d> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new C7917d[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            if (C2834b.a(a) != 2) {
                C2834b.b(parcel, a);
            } else {
                bundle = C2834b.p(parcel, a);
            }
        }
        C2834b.w(parcel, b);
        return new C7917d(bundle);
    }
}
