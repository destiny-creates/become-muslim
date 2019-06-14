package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.C4744r;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.internal.ads.mv;

/* renamed from: com.google.android.gms.ads.internal.overlay.m */
public final class C2664m implements Creator<AdOverlayInfoParcel> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        C4739c c4739c = null;
        IBinder iBinder = c4739c;
        IBinder iBinder2 = iBinder;
        IBinder iBinder3 = iBinder2;
        IBinder iBinder4 = iBinder3;
        String str = iBinder4;
        String str2 = str;
        IBinder iBinder5 = str2;
        String str3 = iBinder5;
        mv mvVar = str3;
        String str4 = mvVar;
        C4744r c4744r = str4;
        IBinder iBinder6 = c4744r;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 2:
                    c4739c = (C4739c) C2834b.m8150a(parcel2, a, C4739c.CREATOR);
                    break;
                case 3:
                    iBinder = C2834b.m8170o(parcel2, a);
                    break;
                case 4:
                    iBinder2 = C2834b.m8170o(parcel2, a);
                    break;
                case 5:
                    iBinder3 = C2834b.m8170o(parcel2, a);
                    break;
                case 6:
                    iBinder4 = C2834b.m8170o(parcel2, a);
                    break;
                case 7:
                    str = C2834b.m8169n(parcel2, a);
                    break;
                case 8:
                    z = C2834b.m8158c(parcel2, a);
                    break;
                case 9:
                    str2 = C2834b.m8169n(parcel2, a);
                    break;
                case 10:
                    iBinder5 = C2834b.m8170o(parcel2, a);
                    break;
                case 11:
                    i = C2834b.m8162g(parcel2, a);
                    break;
                case 12:
                    i2 = C2834b.m8162g(parcel2, a);
                    break;
                case 13:
                    str3 = C2834b.m8169n(parcel2, a);
                    break;
                case 14:
                    mvVar = (mv) C2834b.m8150a(parcel2, a, mv.CREATOR);
                    break;
                case 16:
                    str4 = C2834b.m8169n(parcel2, a);
                    break;
                case 17:
                    c4744r = (C4744r) C2834b.m8150a(parcel2, a, C4744r.CREATOR);
                    break;
                case 18:
                    iBinder6 = C2834b.m8170o(parcel2, a);
                    break;
                default:
                    C2834b.m8155b(parcel2, a);
                    break;
            }
        }
        C2834b.m8178w(parcel2, b);
        return new AdOverlayInfoParcel(c4739c, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i, i2, str3, mvVar, str4, c4744r, iBinder6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
