package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.wallet.wobs.o */
public final class C5174o implements Creator<C7887c> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        C7888d c7888d = null;
        C7890f c7890f = c7888d;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            int a2 = C2834b.a(a);
            if (a2 != 5) {
                switch (a2) {
                    case 2:
                        str = C2834b.n(parcel, a);
                        break;
                    case 3:
                        c7888d = (C7888d) C2834b.a(parcel, a, C7888d.CREATOR);
                        break;
                    default:
                        C2834b.b(parcel, a);
                        break;
                }
            }
            c7890f = (C7890f) C2834b.a(parcel, a, C7890f.CREATOR);
        }
        C2834b.w(parcel, b);
        return new C7887c(str, c7888d, c7890f);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7887c[i];
    }
}
