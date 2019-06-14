package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.common.api.t */
public final class C2822t implements Creator<Status> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new Status[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        int i = 0;
        String str = null;
        PendingIntent pendingIntent = str;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            int a2 = C2834b.m8147a(a);
            if (a2 != 1000) {
                switch (a2) {
                    case 1:
                        i2 = C2834b.m8162g(parcel, a);
                        break;
                    case 2:
                        str = C2834b.m8169n(parcel, a);
                        break;
                    case 3:
                        pendingIntent = (PendingIntent) C2834b.m8150a(parcel, a, PendingIntent.CREATOR);
                        break;
                    default:
                        C2834b.m8155b(parcel, a);
                        break;
                }
            }
            i = C2834b.m8162g(parcel, a);
        }
        C2834b.m8178w(parcel, b);
        return new Status(i, i2, str, pendingIntent);
    }
}
