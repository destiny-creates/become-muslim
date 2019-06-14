package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;

public final class awt extends ajl implements awr {
    awt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    /* renamed from: a */
    public final void mo4058a(apy apy, C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) apy);
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(1, x_);
    }
}
