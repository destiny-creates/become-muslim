package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

public final class dq implements Creator<dp> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        long j = 0;
        long j2 = j;
        long j3 = j2;
        long j4 = j3;
        String str = null;
        String str2 = str;
        List list = str2;
        List list2 = list;
        List list3 = list2;
        String str3 = list3;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        eb ebVar = str6;
        String str7 = ebVar;
        String str8 = str7;
        hq hqVar = str8;
        List list4 = hqVar;
        List list5 = list4;
        dr drVar = list5;
        String str9 = drVar;
        List list6 = str9;
        String str10 = list6;
        ia iaVar = str10;
        String str11 = iaVar;
        Bundle bundle = str11;
        List list7 = bundle;
        String str12 = list7;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        int i4 = 0;
        boolean z16 = false;
        boolean z17 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    i = C2834b.g(parcel2, a);
                    break;
                case 2:
                    str = C2834b.n(parcel2, a);
                    break;
                case 3:
                    str2 = C2834b.n(parcel2, a);
                    break;
                case 4:
                    list = C2834b.v(parcel2, a);
                    break;
                case 5:
                    i2 = C2834b.g(parcel2, a);
                    break;
                case 6:
                    list2 = C2834b.v(parcel2, a);
                    break;
                case 7:
                    j = C2834b.h(parcel2, a);
                    break;
                case 8:
                    z = C2834b.c(parcel2, a);
                    break;
                case 9:
                    j2 = C2834b.h(parcel2, a);
                    break;
                case 10:
                    list3 = C2834b.v(parcel2, a);
                    break;
                case 11:
                    j3 = C2834b.h(parcel2, a);
                    break;
                case 12:
                    i3 = C2834b.g(parcel2, a);
                    break;
                case 13:
                    str3 = C2834b.n(parcel2, a);
                    break;
                case 14:
                    j4 = C2834b.h(parcel2, a);
                    break;
                case 15:
                    str4 = C2834b.n(parcel2, a);
                    break;
                case 18:
                    z2 = C2834b.c(parcel2, a);
                    break;
                case 19:
                    str5 = C2834b.n(parcel2, a);
                    break;
                case 21:
                    str6 = C2834b.n(parcel2, a);
                    break;
                case 22:
                    z3 = C2834b.c(parcel2, a);
                    break;
                case 23:
                    z4 = C2834b.c(parcel2, a);
                    break;
                case 24:
                    z5 = C2834b.c(parcel2, a);
                    break;
                case 25:
                    z6 = C2834b.c(parcel2, a);
                    break;
                case 26:
                    z7 = C2834b.c(parcel2, a);
                    break;
                case 28:
                    ebVar = (eb) C2834b.a(parcel2, a, eb.CREATOR);
                    break;
                case 29:
                    str7 = C2834b.n(parcel2, a);
                    break;
                case 30:
                    str8 = C2834b.n(parcel2, a);
                    break;
                case 31:
                    z8 = C2834b.c(parcel2, a);
                    break;
                case 32:
                    z9 = C2834b.c(parcel2, a);
                    break;
                case 33:
                    hqVar = (hq) C2834b.a(parcel2, a, hq.CREATOR);
                    break;
                case 34:
                    list4 = C2834b.v(parcel2, a);
                    break;
                case 35:
                    list5 = C2834b.v(parcel2, a);
                    break;
                case 36:
                    z10 = C2834b.c(parcel2, a);
                    break;
                case 37:
                    drVar = (dr) C2834b.a(parcel2, a, dr.CREATOR);
                    break;
                case 38:
                    z11 = C2834b.c(parcel2, a);
                    break;
                case 39:
                    str9 = C2834b.n(parcel2, a);
                    break;
                case 40:
                    list6 = C2834b.v(parcel2, a);
                    break;
                case 42:
                    z12 = C2834b.c(parcel2, a);
                    break;
                case 43:
                    str10 = C2834b.n(parcel2, a);
                    break;
                case 44:
                    iaVar = (ia) C2834b.a(parcel2, a, ia.CREATOR);
                    break;
                case 45:
                    str11 = C2834b.n(parcel2, a);
                    break;
                case 46:
                    z13 = C2834b.c(parcel2, a);
                    break;
                case 47:
                    z14 = C2834b.c(parcel2, a);
                    break;
                case 48:
                    bundle = C2834b.p(parcel2, a);
                    break;
                case 49:
                    z15 = C2834b.c(parcel2, a);
                    break;
                case 50:
                    i4 = C2834b.g(parcel2, a);
                    break;
                case 51:
                    z16 = C2834b.c(parcel2, a);
                    break;
                case 52:
                    list7 = C2834b.v(parcel2, a);
                    break;
                case 53:
                    z17 = C2834b.c(parcel2, a);
                    break;
                case 54:
                    str12 = C2834b.n(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new dp(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, ebVar, str7, str8, z8, z9, hqVar, list4, list5, z10, drVar, z11, str9, list6, z12, str10, iaVar, str11, z13, z14, bundle, z15, i4, z16, list7, z17, str12);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new dp[i];
    }
}
