package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2834b;
import java.util.List;

public final class ag implements Creator<ActivityRecognitionResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        long j = 0;
        long j2 = j;
        List list = null;
        Bundle bundle = list;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    list = C2834b.c(parcel, a, C7834c.CREATOR);
                    break;
                case 2:
                    j = C2834b.h(parcel, a);
                    break;
                case 3:
                    j2 = C2834b.h(parcel, a);
                    break;
                case 4:
                    i = C2834b.g(parcel, a);
                    break;
                case 5:
                    bundle = C2834b.p(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new ActivityRecognitionResult(list, j, j2, i, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ActivityRecognitionResult[i];
    }
}
