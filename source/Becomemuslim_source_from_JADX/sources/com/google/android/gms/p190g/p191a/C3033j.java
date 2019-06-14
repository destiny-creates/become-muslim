package com.google.android.gms.p190g.p191a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.p190g.p191a.C4820a.C4813f;

/* renamed from: com.google.android.gms.g.a.j */
public final class C3033j implements Creator<C4813f> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
        String str3 = str2;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 2:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 3:
                    str = C2834b.m8169n(parcel, a);
                    break;
                case 4:
                    str2 = C2834b.m8169n(parcel, a);
                    break;
                case 5:
                    str3 = C2834b.m8169n(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4813f(i, str, str2, str3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4813f[i];
    }
}
