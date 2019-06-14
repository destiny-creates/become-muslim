package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.p168b.C4735l;

public final class apv extends ajl implements apt {
    apv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* renamed from: a */
    public final apq mo3870a() {
        apq apq;
        Parcel a = m18499a(1, x_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            apq = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            apq = queryLocalInterface instanceof apq ? (apq) queryLocalInterface : new aps(readStrongBinder);
        }
        a.recycle();
        return apq;
    }

    /* renamed from: a */
    public final void mo3871a(C4735l c4735l) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) c4735l);
        m18500b(9, x_);
    }

    /* renamed from: a */
    public final void mo3872a(apn apn) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) apn);
        m18500b(2, x_);
    }

    /* renamed from: a */
    public final void mo3873a(aqn aqn) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) aqn);
        m18500b(7, x_);
    }

    /* renamed from: a */
    public final void mo3874a(aus aus) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) aus);
        m18500b(6, x_);
    }

    /* renamed from: a */
    public final void mo3875a(awe awe) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) awe);
        m18500b(3, x_);
    }

    /* renamed from: a */
    public final void mo3876a(awh awh) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) awh);
        m18500b(4, x_);
    }

    /* renamed from: a */
    public final void mo3877a(awr awr, aou aou) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) awr);
        ajn.m18503a(x_, (Parcelable) aou);
        m18500b(8, x_);
    }

    /* renamed from: a */
    public final void mo3878a(awu awu) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) awu);
        m18500b(10, x_);
    }

    /* renamed from: a */
    public final void mo3879a(String str, awo awo, awl awl) {
        Parcel x_ = x_();
        x_.writeString(str);
        ajn.m18502a(x_, (IInterface) awo);
        ajn.m18502a(x_, (IInterface) awl);
        m18500b(5, x_);
    }
}
