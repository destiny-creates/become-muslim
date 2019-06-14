package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class amu extends ajl implements amt {
    amu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    /* renamed from: a */
    public final amn mo3847a(amq amq) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) amq);
        Parcel a = m18499a(1, x_);
        amn amn = (amn) ajn.m18501a(a, amn.CREATOR);
        a.recycle();
        return amn;
    }
}
