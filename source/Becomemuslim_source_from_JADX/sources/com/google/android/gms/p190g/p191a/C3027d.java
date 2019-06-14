package com.google.android.gms.p190g.p191a;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.p190g.p191a.C4820a.C4810c;
import com.google.android.gms.p190g.p191a.C4820a.C4811d;
import com.google.android.gms.p190g.p191a.C4820a.C4812e;
import com.google.android.gms.p190g.p191a.C4820a.C4813f;
import com.google.android.gms.p190g.p191a.C4820a.C4814g;
import com.google.android.gms.p190g.p191a.C4820a.C4816i;
import com.google.android.gms.p190g.p191a.C4820a.C4817j;
import com.google.android.gms.p190g.p191a.C4820a.C4818k;
import com.google.android.gms.p190g.p191a.C4820a.C4819l;

/* renamed from: com.google.android.gms.g.a.d */
public final class C3027d implements Creator<C4820a> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        String str = null;
        String str2 = str;
        Point[] pointArr = str2;
        C4813f c4813f = pointArr;
        C4816i c4816i = c4813f;
        C4817j c4817j = c4816i;
        C4819l c4819l = c4817j;
        C4818k c4818k = c4819l;
        C4814g c4814g = c4818k;
        C4810c c4810c = c4814g;
        C4811d c4811d = c4810c;
        C4812e c4812e = c4811d;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 2:
                    i = C2834b.m8162g(parcel2, a);
                    break;
                case 3:
                    str = C2834b.m8169n(parcel2, a);
                    break;
                case 4:
                    str2 = C2834b.m8169n(parcel2, a);
                    break;
                case 5:
                    i2 = C2834b.m8162g(parcel2, a);
                    break;
                case 6:
                    pointArr = (Point[]) C2834b.m8156b(parcel2, a, Point.CREATOR);
                    break;
                case 7:
                    c4813f = (C4813f) C2834b.m8150a(parcel2, a, C4813f.CREATOR);
                    break;
                case 8:
                    c4816i = (C4816i) C2834b.m8150a(parcel2, a, C4816i.CREATOR);
                    break;
                case 9:
                    c4817j = (C4817j) C2834b.m8150a(parcel2, a, C4817j.CREATOR);
                    break;
                case 10:
                    c4819l = (C4819l) C2834b.m8150a(parcel2, a, C4819l.CREATOR);
                    break;
                case 11:
                    c4818k = (C4818k) C2834b.m8150a(parcel2, a, C4818k.CREATOR);
                    break;
                case 12:
                    c4814g = (C4814g) C2834b.m8150a(parcel2, a, C4814g.CREATOR);
                    break;
                case 13:
                    c4810c = (C4810c) C2834b.m8150a(parcel2, a, C4810c.CREATOR);
                    break;
                case 14:
                    c4811d = (C4811d) C2834b.m8150a(parcel2, a, C4811d.CREATOR);
                    break;
                case 15:
                    c4812e = (C4812e) C2834b.m8150a(parcel2, a, C4812e.CREATOR);
                    break;
                default:
                    C2834b.m8155b(parcel2, a);
                    break;
            }
        }
        C2834b.m8178w(parcel2, b);
        return new C4820a(i, str, str2, i2, pointArr, c4813f, c4816i, c4817j, c4819l, c4818k, c4814g, c4810c, c4811d, c4812e);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4820a[i];
    }
}
