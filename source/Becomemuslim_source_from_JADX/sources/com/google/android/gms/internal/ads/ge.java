package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class ge extends ajl implements gc {
    ge(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    /* renamed from: a */
    public final String mo4247a() {
        Parcel a = m18499a(1, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: b */
    public final int mo4248b() {
        Parcel a = m18499a(2, x_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
