package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class bem extends ajl implements bel {
    bem(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    /* renamed from: a */
    public final void mo4208a(String str) {
        Parcel x_ = x_();
        x_.writeString(str);
        m18500b(3, x_);
    }
}
