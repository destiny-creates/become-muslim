package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.fitness.data.k */
public final class C2996k implements Creator<C4804f> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        long j = 0;
        long j2 = j;
        String str = null;
        String str2 = str;
        String str3 = str2;
        C4807o c4807o = str3;
        Long l = c4807o;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    j = C2834b.m8163h(parcel2, a);
                    break;
                case 2:
                    j2 = C2834b.m8163h(parcel2, a);
                    break;
                case 3:
                    str = C2834b.m8169n(parcel2, a);
                    break;
                case 4:
                    str2 = C2834b.m8169n(parcel2, a);
                    break;
                case 5:
                    str3 = C2834b.m8169n(parcel2, a);
                    break;
                case 7:
                    i = C2834b.m8162g(parcel2, a);
                    break;
                case 8:
                    c4807o = (C4807o) C2834b.m8150a(parcel2, a, C4807o.CREATOR);
                    break;
                case 9:
                    l = C2834b.m8164i(parcel2, a);
                    break;
                default:
                    C2834b.m8155b(parcel2, a);
                    break;
            }
        }
        C2834b.m8178w(parcel2, b);
        return new C4804f(j, j2, str, str2, str3, i, c4807o, l);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4804f[i];
    }
}
