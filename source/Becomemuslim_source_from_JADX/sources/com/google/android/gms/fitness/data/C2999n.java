package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.fitness.data.n */
public final class C2999n implements Creator<C4806h> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        String str = null;
        Bundle bundle = str;
        int[] iArr = bundle;
        float[] fArr = iArr;
        byte[] bArr = fArr;
        int i = 0;
        boolean z = false;
        float f = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 2:
                    z = C2834b.m8158c(parcel, a);
                    break;
                case 3:
                    f = C2834b.m8165j(parcel, a);
                    break;
                case 4:
                    str = C2834b.m8169n(parcel, a);
                    break;
                case 5:
                    bundle = C2834b.m8171p(parcel, a);
                    break;
                case 6:
                    iArr = C2834b.m8173r(parcel, a);
                    break;
                case 7:
                    fArr = C2834b.m8174s(parcel, a);
                    break;
                case 8:
                    bArr = C2834b.m8172q(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4806h(i, z, f, str, bundle, iArr, fArr, bArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4806h[i];
    }
}
