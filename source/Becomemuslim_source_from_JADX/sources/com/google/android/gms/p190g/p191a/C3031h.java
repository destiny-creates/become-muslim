package com.google.android.gms.p190g.p191a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.p190g.p191a.C4820a.C4808a;
import com.google.android.gms.p190g.p191a.C4820a.C4811d;
import com.google.android.gms.p190g.p191a.C4820a.C4813f;
import com.google.android.gms.p190g.p191a.C4820a.C4815h;
import com.google.android.gms.p190g.p191a.C4820a.C4816i;

/* renamed from: com.google.android.gms.g.a.h */
public final class C3031h implements Creator<C4811d> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        C4815h c4815h = null;
        String str = c4815h;
        String str2 = str;
        C4816i[] c4816iArr = str2;
        C4813f[] c4813fArr = c4816iArr;
        String[] strArr = c4813fArr;
        C4808a[] c4808aArr = strArr;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 2:
                    c4815h = (C4815h) C2834b.m8150a(parcel, a, C4815h.CREATOR);
                    break;
                case 3:
                    str = C2834b.m8169n(parcel, a);
                    break;
                case 4:
                    str2 = C2834b.m8169n(parcel, a);
                    break;
                case 5:
                    c4816iArr = (C4816i[]) C2834b.m8156b(parcel, a, C4816i.CREATOR);
                    break;
                case 6:
                    c4813fArr = (C4813f[]) C2834b.m8156b(parcel, a, C4813f.CREATOR);
                    break;
                case 7:
                    strArr = C2834b.m8175t(parcel, a);
                    break;
                case 8:
                    c4808aArr = (C4808a[]) C2834b.m8156b(parcel, a, C4808a.CREATOR);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4811d(c4815h, str, str2, c4816iArr, c4813fArr, strArr, c4808aArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4811d[i];
    }
}
