package com.google.android.gms.internal.p215n;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.internal.n.o */
public final class C5068o implements Creator<C7832n> {
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
        return new C7832n(bArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7832n[i];
    }
}
