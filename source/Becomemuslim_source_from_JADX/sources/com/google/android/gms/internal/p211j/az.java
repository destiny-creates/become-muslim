package com.google.android.gms.internal.p211j;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.internal.j.az */
public final class az implements Creator<ay> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        aw awVar = null;
        int i = 1;
        IBinder iBinder = null;
        IBinder iBinder2 = iBinder;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    i = C2834b.g(parcel, a);
                    break;
                case 2:
                    awVar = (aw) C2834b.a(parcel, a, aw.CREATOR);
                    break;
                case 3:
                    iBinder = C2834b.o(parcel, a);
                    break;
                case 4:
                    iBinder2 = C2834b.o(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new ay(i, awVar, iBinder, iBinder2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ay[i];
    }
}
