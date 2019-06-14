package com.google.android.gms.internal.p213l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.internal.l.z */
public final class C5053z implements Creator<C7827y> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        long j = 0;
        long j2 = j;
        long j3 = j2;
        String str = null;
        String str2 = str;
        ft ftVar = str2;
        String str3 = ftVar;
        aq aqVar = str3;
        aq aqVar2 = aqVar;
        aq aqVar3 = aqVar2;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 2:
                    str = C2834b.n(parcel2, a);
                    break;
                case 3:
                    str2 = C2834b.n(parcel2, a);
                    break;
                case 4:
                    ftVar = (ft) C2834b.a(parcel2, a, ft.CREATOR);
                    break;
                case 5:
                    j = C2834b.h(parcel2, a);
                    break;
                case 6:
                    z = C2834b.c(parcel2, a);
                    break;
                case 7:
                    str3 = C2834b.n(parcel2, a);
                    break;
                case 8:
                    aqVar = (aq) C2834b.a(parcel2, a, aq.CREATOR);
                    break;
                case 9:
                    j2 = C2834b.h(parcel2, a);
                    break;
                case 10:
                    aqVar2 = (aq) C2834b.a(parcel2, a, aq.CREATOR);
                    break;
                case 11:
                    j3 = C2834b.h(parcel2, a);
                    break;
                case 12:
                    aqVar3 = (aq) C2834b.a(parcel2, a, aq.CREATOR);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new C7827y(str, str2, ftVar, j, z, str3, aqVar, j2, aqVar2, j3, aqVar3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7827y[i];
    }
}
