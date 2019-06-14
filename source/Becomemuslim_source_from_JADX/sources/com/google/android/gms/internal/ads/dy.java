package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class dy extends ajl implements dw {
    dy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdResponseListener");
    }

    /* renamed from: a */
    public final void mo4240a(dp dpVar) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) dpVar);
        m18500b(1, x_);
    }
}
