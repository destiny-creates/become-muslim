package com.google.android.gms.p190g.p191a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.p190g.p191a.C4820a.C4808a;

/* renamed from: com.google.android.gms.g.a.c */
public final class C3026c implements Creator<C4808a> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        int i = 0;
        String[] strArr = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 2:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 3:
                    strArr = C2834b.m8175t(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4808a(i, strArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4808a[i];
    }
}
