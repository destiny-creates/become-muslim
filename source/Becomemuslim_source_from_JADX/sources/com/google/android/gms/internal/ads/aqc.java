package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.p174b.C2758b;

public final class aqc extends ajl implements aqb {
    aqc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    /* renamed from: a */
    public final IBinder mo3914a(C2758b c2758b, aou aou, String str, bcy bcy, int i, int i2) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        ajn.m18503a(x_, (Parcelable) aou);
        x_.writeString(str);
        ajn.m18502a(x_, (IInterface) bcy);
        x_.writeInt(C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        x_.writeInt(i2);
        Parcel a = m18499a(2, x_);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
