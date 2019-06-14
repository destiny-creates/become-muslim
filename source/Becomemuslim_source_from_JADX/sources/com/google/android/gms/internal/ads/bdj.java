package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class bdj extends ajl implements bdh {
    bdj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
    }

    /* renamed from: a */
    public final int mo4144a() {
        Parcel a = m18499a(1, x_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
