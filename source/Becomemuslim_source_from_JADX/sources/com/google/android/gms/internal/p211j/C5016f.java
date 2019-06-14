package com.google.android.gms.internal.p211j;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.internal.j.f */
public final class C5016f implements Creator<C7821e> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        Status status = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            if (C2834b.a(a) != 1) {
                C2834b.b(parcel, a);
            } else {
                status = (Status) C2834b.a(parcel, a, Status.CREATOR);
            }
        }
        C2834b.w(parcel, b);
        return new C7821e(status);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7821e[i];
    }
}
