package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class awn extends ajl implements awl {
    awn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    /* renamed from: a */
    public final void mo4056a(awa awa, String str) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) awa);
        x_.writeString(str);
        m18500b(1, x_);
    }
}
