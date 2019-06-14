package com.google.android.gms.internal.p215n;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.internal.n.m */
public final class C5067m implements Creator<C7831l> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        byte[] bArr = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            if (C2834b.a(a) != 2) {
                C2834b.b(parcel, a);
            } else {
                bArr = C2834b.q(parcel, a);
            }
        }
        C2834b.w(parcel, b);
        return new C7831l(bArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7831l[i];
    }
}
