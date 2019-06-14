package com.google.android.gms.internal.p211j;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C4783e;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.location.aj;
import java.util.List;

/* renamed from: com.google.android.gms.internal.j.ax */
public final class ax implements Creator<aw> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        aj ajVar = aw.f28953b;
        List list = aw.f28952a;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    ajVar = (aj) C2834b.a(parcel, a, aj.CREATOR);
                    break;
                case 2:
                    list = C2834b.c(parcel, a, C4783e.CREATOR);
                    break;
                case 3:
                    str = C2834b.n(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new aw(ajVar, list, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new aw[i];
    }
}
