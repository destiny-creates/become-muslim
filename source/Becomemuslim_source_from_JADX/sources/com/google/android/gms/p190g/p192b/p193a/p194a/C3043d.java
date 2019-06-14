package com.google.android.gms.p190g.p192b.p193a.p194a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.g.b.a.a.d */
public final class C3043d implements Creator<C4821a> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        C4822b[] c4822bArr = null;
        int i = 0;
        int i2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel2, a);
                    break;
                case 2:
                    i2 = C2834b.m8162g(parcel2, a);
                    break;
                case 3:
                    f = C2834b.m8165j(parcel2, a);
                    break;
                case 4:
                    f2 = C2834b.m8165j(parcel2, a);
                    break;
                case 5:
                    f3 = C2834b.m8165j(parcel2, a);
                    break;
                case 6:
                    f4 = C2834b.m8165j(parcel2, a);
                    break;
                case 7:
                    f5 = C2834b.m8165j(parcel2, a);
                    break;
                case 8:
                    f6 = C2834b.m8165j(parcel2, a);
                    break;
                case 9:
                    c4822bArr = (C4822b[]) C2834b.m8156b(parcel2, a, C4822b.CREATOR);
                    break;
                case 10:
                    f7 = C2834b.m8165j(parcel2, a);
                    break;
                case 11:
                    f8 = C2834b.m8165j(parcel2, a);
                    break;
                case 12:
                    f9 = C2834b.m8165j(parcel2, a);
                    break;
                default:
                    C2834b.m8155b(parcel2, a);
                    break;
            }
        }
        C2834b.m8178w(parcel2, b);
        return new C4821a(i, i2, f, f2, f3, f4, f5, f6, c4822bArr, f7, f8, f9);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4821a[i];
    }
}
