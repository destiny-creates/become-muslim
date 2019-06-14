package com.google.android.gms.p190g.p192b.p193a.p194a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.g.b.a.a.f */
public final class C3044f implements Creator<C4823e> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        float f = -1.0f;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 2:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 3:
                    i2 = C2834b.m8162g(parcel, a);
                    break;
                case 4:
                    i3 = C2834b.m8162g(parcel, a);
                    break;
                case 5:
                    z = C2834b.m8158c(parcel, a);
                    break;
                case 6:
                    z2 = C2834b.m8158c(parcel, a);
                    break;
                case 7:
                    f = C2834b.m8165j(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4823e(i, i2, i3, z, z2, f);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4823e[i];
    }
}
