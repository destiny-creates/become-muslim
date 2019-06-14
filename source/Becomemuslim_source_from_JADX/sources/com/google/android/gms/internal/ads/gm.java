package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.p174b.C2758b;

public final class gm extends ajl implements gl {
    gm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
    }

    /* renamed from: a */
    public final IBinder mo4266a(C2758b c2758b, bcy bcy, int i) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18502a(x_, (IInterface) bcy);
        x_.writeInt(C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        Parcel a = m18499a(1, x_);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
