package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

public final class af implements Creator<ae> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        List list = null;
        String str = "";
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    list = C2834b.v(parcel, a);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) C2834b.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 3:
                    str = C2834b.n(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new ae(list, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ae[i];
    }
}
