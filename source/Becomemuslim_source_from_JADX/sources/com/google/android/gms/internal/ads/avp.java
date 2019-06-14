package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;

public final class avp extends ajl implements avn {
    avp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    /* renamed from: a */
    public final void mo4006a() {
        m18500b(2, x_());
    }

    /* renamed from: a */
    public final void mo4007a(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(1, x_);
    }

    /* renamed from: b */
    public final void mo4008b(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(3, x_);
    }
}
