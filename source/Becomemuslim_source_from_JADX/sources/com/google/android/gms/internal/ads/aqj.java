package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class aqj extends ajl implements aqh {
    aqj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    /* renamed from: a */
    public final void mo3916a(String str, String str2) {
        Parcel x_ = x_();
        x_.writeString(str);
        x_.writeString(str2);
        m18500b(1, x_);
    }
}
