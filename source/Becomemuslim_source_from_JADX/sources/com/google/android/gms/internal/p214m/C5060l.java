package com.google.android.gms.internal.p214m;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.internal.m.l */
public final class C5060l implements Creator<C7829k> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    i = C2834b.g(parcel, a);
                    break;
                case 3:
                    i2 = C2834b.g(parcel, a);
                    break;
                case 4:
                    i3 = C2834b.g(parcel, a);
                    break;
                case 5:
                    j = C2834b.h(parcel, a);
                    break;
                case 6:
                    i4 = C2834b.g(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7829k(i, i2, i3, j, i4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7829k[i];
    }
}
