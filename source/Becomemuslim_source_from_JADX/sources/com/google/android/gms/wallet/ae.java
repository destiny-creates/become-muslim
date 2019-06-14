package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.ArrayList;

public final class ae implements Creator<C7882p> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            if (C2834b.a(a) != 1) {
                C2834b.b(parcel, a);
            } else {
                arrayList = C2834b.v(parcel, a);
            }
        }
        C2834b.w(parcel, b);
        return new C7882p(arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7882p[i];
    }
}
