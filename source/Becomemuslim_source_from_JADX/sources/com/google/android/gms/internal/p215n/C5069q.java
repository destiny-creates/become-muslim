package com.google.android.gms.internal.p215n;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.RemoteViews;
import com.google.android.gms.common.internal.p181a.C2834b;

/* renamed from: com.google.android.gms.internal.n.q */
public final class C5069q implements Creator<C7833p> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = C2834b.b(parcel);
        String[] strArr = null;
        int[] iArr = null;
        RemoteViews remoteViews = iArr;
        byte[] bArr = remoteViews;
        while (parcel.dataPosition() < b) {
            int a = C2834b.a(parcel);
            switch (C2834b.a(a)) {
                case 1:
                    strArr = C2834b.t(parcel, a);
                    break;
                case 2:
                    iArr = C2834b.r(parcel, a);
                    break;
                case 3:
                    remoteViews = (RemoteViews) C2834b.a(parcel, a, RemoteViews.CREATOR);
                    break;
                case 4:
                    bArr = C2834b.q(parcel, a);
                    break;
                default:
                    C2834b.b(parcel, a);
                    break;
            }
        }
        C2834b.w(parcel, b);
        return new C7833p(strArr, iArr, remoteViews, bArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C7833p[i];
    }
}
