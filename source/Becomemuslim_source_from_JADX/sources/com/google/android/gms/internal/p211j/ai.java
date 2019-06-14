package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.internal.j.ai */
public final class ai implements Creator<ah> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        af afVar = null;
        IBinder iBinder = afVar;
        PendingIntent pendingIntent = iBinder;
        IBinder iBinder2 = pendingIntent;
        IBinder iBinder3 = iBinder2;
        int i = 1;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    i = C2834b.g(parcel, a);
                    break;
                case 2:
                    afVar = (af) C2834b.a(parcel, a, af.CREATOR);
                    break;
                case 3:
                    iBinder = C2834b.o(parcel, a);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) C2834b.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = C2834b.o(parcel, a);
                    break;
                case 6:
                    iBinder3 = C2834b.o(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new ah(i, afVar, iBinder, pendingIntent, iBinder2, iBinder3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ah[i];
    }
}
