package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public final class dv extends ajl implements dt {
    dv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* renamed from: a */
    public final dp mo4236a(dl dlVar) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) dlVar);
        Parcel a = m18499a(1, x_);
        dp dpVar = (dp) ajn.m18501a(a, dp.CREATOR);
        a.recycle();
        return dpVar;
    }

    /* renamed from: a */
    public final void mo4237a(dl dlVar, dw dwVar) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) dlVar);
        ajn.m18502a(x_, (IInterface) dwVar);
        m18500b(2, x_);
    }

    /* renamed from: a */
    public final void mo4238a(ee eeVar, dz dzVar) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) eeVar);
        ajn.m18502a(x_, (IInterface) dzVar);
        m18500b(4, x_);
    }

    /* renamed from: b */
    public final void mo4239b(ee eeVar, dz dzVar) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) eeVar);
        ajn.m18502a(x_, (IInterface) dzVar);
        m18500b(5, x_);
    }
}
