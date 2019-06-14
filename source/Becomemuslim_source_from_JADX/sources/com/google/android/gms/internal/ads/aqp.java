package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class aqp extends ajl implements aqn {
    aqp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }

    /* renamed from: a */
    public final long mo3928a() {
        Parcel a = m18499a(1, x_());
        long readLong = a.readLong();
        a.recycle();
        return readLong;
    }
}
