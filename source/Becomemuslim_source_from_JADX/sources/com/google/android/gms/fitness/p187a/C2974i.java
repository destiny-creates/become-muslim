package com.google.android.gms.fitness.p187a;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import com.google.android.gms.fitness.data.C4801a;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.a.i */
public final class C2974i implements Creator<C4795h> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        long j = 0;
        long j2 = j;
        long j3 = j2;
        long j4 = j3;
        C4801a c4801a = null;
        DataType dataType = c4801a;
        IBinder iBinder = dataType;
        PendingIntent pendingIntent = iBinder;
        List list = pendingIntent;
        IBinder iBinder2 = list;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    c4801a = (C4801a) C2834b.m8150a(parcel2, a, C4801a.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) C2834b.m8150a(parcel2, a, DataType.CREATOR);
                    break;
                case 3:
                    iBinder = C2834b.m8170o(parcel2, a);
                    break;
                case 4:
                    i = C2834b.m8162g(parcel2, a);
                    break;
                case 5:
                    i2 = C2834b.m8162g(parcel2, a);
                    break;
                case 6:
                    j = C2834b.m8163h(parcel2, a);
                    break;
                case 7:
                    j2 = C2834b.m8163h(parcel2, a);
                    break;
                case 8:
                    pendingIntent = (PendingIntent) C2834b.m8150a(parcel2, a, PendingIntent.CREATOR);
                    break;
                case 9:
                    j3 = C2834b.m8163h(parcel2, a);
                    break;
                case 10:
                    i3 = C2834b.m8162g(parcel2, a);
                    break;
                case 11:
                    list = C2834b.m8157c(parcel2, a, LocationRequest.CREATOR);
                    break;
                case 12:
                    j4 = C2834b.m8163h(parcel2, a);
                    break;
                case 13:
                    iBinder2 = C2834b.m8170o(parcel2, a);
                    break;
                default:
                    C2834b.m8155b(parcel2, a);
                    break;
            }
        }
        C2834b.m8178w(parcel2, b);
        return new C4795h(c4801a, dataType, iBinder, i, i2, j, j2, pendingIntent, j3, i3, list, j4, iBinder2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C4795h[i];
    }
}
