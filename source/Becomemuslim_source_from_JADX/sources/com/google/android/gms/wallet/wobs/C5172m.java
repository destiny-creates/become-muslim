package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.common.util.C2892b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.m */
public final class C5172m implements Creator<C7886b> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String str = null;
        ArrayList a = C2892b.a();
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = C2834b.a(parcel);
            switch (C2834b.a(a2)) {
                case 2:
                    str = C2834b.n(parcel, a2);
                    break;
                case 3:
                    str2 = C2834b.n(parcel, a2);
                    break;
                case 4:
                    a = C2834b.c(parcel, a2, C7885a.CREATOR);
                    break;
                default:
                    C2834b.b(parcel, a2);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7886b(str, str2, a);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7886b[i];
    }
}
