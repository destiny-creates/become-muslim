package com.google.android.gms.fitness.p188b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.fitness.data.C4801a;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.b.d */
public final class C2985d implements Creator<C4800b> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        List list = null;
        Status status = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    list = C2834b.m8157c(parcel, a, C4801a.CREATOR);
                    break;
                case 2:
                    status = (Status) C2834b.m8150a(parcel, a, Status.CREATOR);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4800b(list, status);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4800b[i];
    }
}
