package com.google.android.gms.internal.p213l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.internal.l.v */
public final class C5051v implements Creator<C7826u> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        long j = 0;
        long j2 = j;
        long j3 = j2;
        long j4 = j3;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        long j5 = -2147483648L;
        boolean z = true;
        boolean z2 = false;
        int i = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = false;
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
                    str3 = C2834b.n(parcel2, a);
                    break;
                case 5:
                    str4 = C2834b.n(parcel2, a);
                    break;
                case 6:
                    j = C2834b.h(parcel2, a);
                    break;
                case 7:
                    j2 = C2834b.h(parcel2, a);
                    break;
                case 8:
                    str5 = C2834b.n(parcel2, a);
                    break;
                case 9:
                    z = C2834b.c(parcel2, a);
                    break;
                case 10:
                    z2 = C2834b.c(parcel2, a);
                    break;
                case 11:
                    j5 = C2834b.h(parcel2, a);
                    break;
                case 12:
                    str6 = C2834b.n(parcel2, a);
                    break;
                case 13:
                    j3 = C2834b.h(parcel2, a);
                    break;
                case 14:
                    j4 = C2834b.h(parcel2, a);
                    break;
                case 15:
                    i = C2834b.g(parcel2, a);
                    break;
                case 16:
                    z3 = C2834b.c(parcel2, a);
                    break;
                case 17:
                    z4 = C2834b.c(parcel2, a);
                    break;
                case 18:
                    z5 = C2834b.c(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new C7826u(str, str2, str3, str4, j, j2, str5, z, z2, j5, str6, j3, j4, i, z3, z4, z5);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7826u[i];
    }
}
