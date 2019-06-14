package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.fitness.data.p */
public final class C3000p implements Creator<C4807o> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            int a2 = C2834b.m8147a(a);
            if (a2 == 1) {
                str = C2834b.m8169n(parcel, a);
            } else if (a2 != 3) {
                C2834b.m8155b(parcel, a);
            } else {
                str2 = C2834b.m8169n(parcel, a);
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4807o(str, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4807o[i];
    }
}
