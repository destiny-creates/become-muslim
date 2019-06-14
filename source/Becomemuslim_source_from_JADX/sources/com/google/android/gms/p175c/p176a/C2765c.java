package com.google.android.gms.p175c.p176a;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.c.a.c */
public final class C2765c implements Creator<C4758b> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4758b[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 2:
                    i2 = C2834b.m8162g(parcel, a);
                    break;
                case 3:
                    intent = (Intent) C2834b.m8150a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4758b(i, i2, intent);
    }
}
