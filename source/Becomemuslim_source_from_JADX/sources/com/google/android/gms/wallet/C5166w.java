package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.w */
public final class C5166w implements Creator<C7878j> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.b(parcel);
        C7872d c7872d = null;
        C7882p c7882p = c7872d;
        ArrayList arrayList = c7882p;
        C7880l c7880l = arrayList;
        C7883q c7883q = c7880l;
        String str = c7883q;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = true;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    z = C2834b.c(parcel2, a);
                    break;
                case 2:
                    z2 = C2834b.c(parcel2, a);
                    break;
                case 3:
                    c7872d = (C7872d) C2834b.a(parcel2, a, C7872d.CREATOR);
                    break;
                case 4:
                    z3 = C2834b.c(parcel2, a);
                    break;
                case 5:
                    c7882p = (C7882p) C2834b.a(parcel2, a, C7882p.CREATOR);
                    break;
                case 6:
                    arrayList = C2834b.u(parcel2, a);
                    break;
                case 7:
                    c7880l = (C7880l) C2834b.a(parcel2, a, C7880l.CREATOR);
                    break;
                case 8:
                    c7883q = (C7883q) C2834b.a(parcel2, a, C7883q.CREATOR);
                    break;
                case 9:
                    z4 = C2834b.c(parcel2, a);
                    break;
                case 10:
                    str = C2834b.n(parcel2, a);
                    break;
                default:
                    C2834b.b(parcel2, a);
                    break;
            }
        }
        C2834b.w(parcel2, b);
        return new C7878j(z, z2, c7872d, z3, c7882p, arrayList, c7880l, c7883q, z4, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7878j[i];
    }
}
