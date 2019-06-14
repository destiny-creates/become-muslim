package com.google.android.gms.p190g.p192b.p193a.p194a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.g.b.a.a.k */
public final class C3047k implements Creator<C4822b> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 2:
                    f = C2834b.m8165j(parcel, a);
                    break;
                case 3:
                    f2 = C2834b.m8165j(parcel, a);
                    break;
                case 4:
                    i2 = C2834b.m8162g(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4822b(i, f, f2, i2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4822b[i];
    }
}
