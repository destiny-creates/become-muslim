package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class gg extends ajl implements gf {
    gg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    /* renamed from: a */
    public final void mo4249a(gc gcVar, String str) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) gcVar);
        x_.writeString(str);
        m18500b(1, x_);
    }
}
