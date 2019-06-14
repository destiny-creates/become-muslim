package com.google.android.gms.p190g.p191a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.p190g.p191a.C4820a.C4809b;

/* renamed from: com.google.android.gms.g.a.f */
public final class C3029f implements Creator<C4809b> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
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
                    i4 = C2834b.m8162g(parcel, a);
                    break;
                case 6:
                    i5 = C2834b.m8162g(parcel, a);
                    break;
                case 7:
                    i6 = C2834b.m8162g(parcel, a);
                    break;
                case 8:
                    z = C2834b.m8158c(parcel, a);
                    break;
                case 9:
                    str = C2834b.m8169n(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4809b(i, i2, i3, i4, i5, i6, z, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4809b[i];
    }
}
