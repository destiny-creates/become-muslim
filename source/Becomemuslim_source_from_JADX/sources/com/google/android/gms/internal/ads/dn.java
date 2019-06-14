package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.ArrayList;
import java.util.List;

public final class dn implements Creator<dl> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        long j = 0;
        long j2 = j;
        Bundle bundle = null;
        aoq aoq = bundle;
        aou aou = aoq;
        String str = aou;
        ApplicationInfo applicationInfo = str;
        PackageInfo packageInfo = applicationInfo;
        String str2 = packageInfo;
        String str3 = str2;
        String str4 = str3;
        mv mvVar = str4;
        Bundle bundle2 = mvVar;
        List list = bundle2;
        Bundle bundle3 = list;
        String str5 = bundle3;
        String str6 = str5;
        List list2 = str6;
        String str7 = list2;
        aus aus = str7;
        List list3 = aus;
        String str8 = list3;
        String str9 = str8;
        String str10 = str9;
        Bundle bundle4 = str10;
        String str11 = bundle4;
        arb arb = str11;
        Bundle bundle5 = arb;
        String str12 = bundle5;
        String str13 = str12;
        String str14 = str13;
        List list4 = str14;
        String str15 = list4;
        List list5 = str15;
        ArrayList arrayList = list5;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i7 = 0;
        boolean z6 = false;
        boolean z7 = false;
        int i8 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    i = C2834b.g(parcel2, a);
                    break;
                case 2:
                    bundle = C2834b.p(parcel2, a);
                    break;
                case 3:
                    aoq = (aoq) C2834b.a(parcel2, a, aoq.CREATOR);
                    break;
                case 4:
                    aou = (aou) C2834b.a(parcel2, a, aou.CREATOR);
                    break;
                case 5:
                    str = C2834b.n(parcel2, a);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) C2834b.a(parcel2, a, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) C2834b.a(parcel2, a, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = C2834b.n(parcel2, a);
                    break;
                case 9:
                    str3 = C2834b.n(parcel2, a);
                    break;
                case 10:
                    str4 = C2834b.n(parcel2, a);
                    break;
                case 11:
                    mvVar = (mv) C2834b.a(parcel2, a, mv.CREATOR);
                    break;
                case 12:
                    bundle2 = C2834b.p(parcel2, a);
                    break;
                case 13:
                    i2 = C2834b.g(parcel2, a);
                    break;
                case 14:
                    list = C2834b.v(parcel2, a);
                    break;
                case 15:
                    bundle3 = C2834b.p(parcel2, a);
                    break;
                case 16:
                    z = C2834b.c(parcel2, a);
                    break;
                case 18:
                    i3 = C2834b.g(parcel2, a);
                    break;
                case 19:
                    i4 = C2834b.g(parcel2, a);
                    break;
                case 20:
                    f = C2834b.j(parcel2, a);
                    break;
                case 21:
                    str5 = C2834b.n(parcel2, a);
                    break;
                case 25:
                    j = C2834b.h(parcel2, a);
                    break;
                case 26:
                    str6 = C2834b.n(parcel2, a);
                    break;
                case 27:
                    list2 = C2834b.v(parcel2, a);
                    break;
                case 28:
                    str7 = C2834b.n(parcel2, a);
                    break;
                case 29:
                    aus = (aus) C2834b.a(parcel2, a, aus.CREATOR);
                    break;
                case 30:
                    list3 = C2834b.v(parcel2, a);
                    break;
                case 31:
                    j2 = C2834b.h(parcel2, a);
                    break;
                case 33:
                    str8 = C2834b.n(parcel2, a);
                    break;
                case 34:
                    f2 = C2834b.j(parcel2, a);
                    break;
                case 35:
                    i5 = C2834b.g(parcel2, a);
                    break;
                case 36:
                    i6 = C2834b.g(parcel2, a);
                    break;
                case 37:
                    z3 = C2834b.c(parcel2, a);
                    break;
                case 38:
                    z4 = C2834b.c(parcel2, a);
                    break;
                case 39:
                    str9 = C2834b.n(parcel2, a);
                    break;
                case 40:
                    z2 = C2834b.c(parcel2, a);
                    break;
                case 41:
                    str10 = C2834b.n(parcel2, a);
                    break;
                case 42:
                    z5 = C2834b.c(parcel2, a);
                    break;
                case 43:
                    i7 = C2834b.g(parcel2, a);
                    break;
                case 44:
                    bundle4 = C2834b.p(parcel2, a);
                    break;
                case 45:
                    str11 = C2834b.n(parcel2, a);
                    break;
                case 46:
                    arb = (arb) C2834b.a(parcel2, a, arb.CREATOR);
                    break;
                case 47:
                    z6 = C2834b.c(parcel2, a);
                    break;
                case 48:
                    bundle5 = C2834b.p(parcel2, a);
                    break;
                case 49:
                    str12 = C2834b.n(parcel2, a);
                    break;
                case 50:
                    str13 = C2834b.n(parcel2, a);
                    break;
                case 51:
                    str14 = C2834b.n(parcel2, a);
                    break;
                case 52:
                    z7 = C2834b.c(parcel2, a);
                    break;
                case 53:
                    list4 = C2834b.u(parcel2, a);
                    break;
                case 54:
                    str15 = C2834b.n(parcel2, a);
                    break;
                case 55:
                    list5 = C2834b.v(parcel2, a);
                    break;
                case 56:
                    i8 = C2834b.g(parcel2, a);
                    break;
                case 57:
                    z8 = C2834b.c(parcel2, a);
                    break;
                case 58:
                    z9 = C2834b.c(parcel2, a);
                    break;
                case 59:
                    z10 = C2834b.c(parcel2, a);
                    break;
                case 60:
                    arrayList = C2834b.v(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new dl(i, bundle, aoq, aou, str, applicationInfo, packageInfo, str2, str3, str4, mvVar, bundle2, i2, list, bundle3, z, i3, i4, f, str5, j, str6, list2, str7, aus, list3, j2, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4, str11, arb, z6, bundle5, str12, str13, str14, z7, list4, str15, list5, i8, z8, z9, z10, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new dl[i];
    }
}
