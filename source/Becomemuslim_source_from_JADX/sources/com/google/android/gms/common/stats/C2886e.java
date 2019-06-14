package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

/* renamed from: com.google.android.gms.common.stats.e */
public final class C2886e implements Creator<WakeLockEvent> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = C2834b.m8154b(parcel);
        long j = 0;
        long j2 = j;
        long j3 = j2;
        String str = null;
        List list = str;
        String str2 = list;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C2834b.m8148a(parcel);
            switch (C2834b.m8147a(a)) {
                case 1:
                    i = C2834b.m8162g(parcel2, a);
                    break;
                case 2:
                    j = C2834b.m8163h(parcel2, a);
                    break;
                case 4:
                    str = C2834b.m8169n(parcel2, a);
                    break;
                case 5:
                    i3 = C2834b.m8162g(parcel2, a);
                    break;
                case 6:
                    list = C2834b.m8177v(parcel2, a);
                    break;
                case 8:
                    j2 = C2834b.m8163h(parcel2, a);
                    break;
                case 10:
                    str3 = C2834b.m8169n(parcel2, a);
                    break;
                case 11:
                    i2 = C2834b.m8162g(parcel2, a);
                    break;
                case 12:
                    str2 = C2834b.m8169n(parcel2, a);
                    break;
                case 13:
                    str4 = C2834b.m8169n(parcel2, a);
                    break;
                case 14:
                    i4 = C2834b.m8162g(parcel2, a);
                    break;
                case 15:
                    f = C2834b.m8165j(parcel2, a);
                    break;
                case 16:
                    j3 = C2834b.m8163h(parcel2, a);
                    break;
                case 17:
                    str5 = C2834b.m8169n(parcel2, a);
                    break;
                default:
                    C2834b.m8155b(parcel2, a);
                    break;
            }
        }
        C2834b.m8178w(parcel2, b);
        return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5);
    }
}
