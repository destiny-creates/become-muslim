package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.common.o */
public final class C2878o implements Creator<C4775b> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4775b[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.m8154b(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        String str = pendingIntent;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel, a);
                    break;
                case 2:
                    i2 = C2834b.m8162g(parcel, a);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) C2834b.m8150a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 4:
                    str = C2834b.m8169n(parcel, a);
                    break;
                default:
                    C2834b.m8155b(parcel, a);
                    break;
            }
        }
        C2834b.m8178w(parcel, b);
        return new C4775b(i, i2, pendingIntent, str);
    }
}
