package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

public final class ef implements Creator<ee> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        Bundle bundle = null;
        mv mvVar = bundle;
        ApplicationInfo applicationInfo = mvVar;
        String str = applicationInfo;
        List list = str;
        PackageInfo packageInfo = list;
        String str2 = packageInfo;
        String str3 = str2;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    bundle = C2834b.p(parcel, a);
                    break;
                case 2:
                    mvVar = (mv) C2834b.a(parcel, a, mv.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) C2834b.a(parcel, a, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    str = C2834b.n(parcel, a);
                    break;
                case 5:
                    list = C2834b.v(parcel, a);
                    break;
                case 6:
                    packageInfo = (PackageInfo) C2834b.a(parcel, a, PackageInfo.CREATOR);
                    break;
                case 7:
                    str2 = C2834b.n(parcel, a);
                    break;
                case 8:
                    z = C2834b.c(parcel, a);
                    break;
                case 9:
                    str3 = C2834b.n(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new ee(bundle, mvVar, applicationInfo, str, list, packageInfo, str2, z, str3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ee[i];
    }
}
