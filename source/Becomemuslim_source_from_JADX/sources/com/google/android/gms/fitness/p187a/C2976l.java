package com.google.android.gms.fitness.p187a;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.fitness.a.l */
public final class C2976l implements Creator<C4796k> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = pendingIntent;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    iBinder = C2834b.m8170o(parcel, a);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) C2834b.m8150a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 3:
                    iBinder2 = C2834b.m8170o(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4796k(iBinder, pendingIntent, iBinder2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4796k[i];
    }
}
