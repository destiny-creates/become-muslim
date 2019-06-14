package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.fitness.data.x */
public final class C3008x implements Creator<C4803c> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        int i = 0;
        Boolean bool = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    str = C2834b.m8169n(parcel, a);
                    break;
                case 2:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 3:
                    bool = C2834b.m8159d(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4803c(str, i, bool);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4803c[i];
    }
}
