package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class tr extends ajl implements tq {
    tr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    /* renamed from: a */
    public final to mo4377a(tm tmVar) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) tmVar);
        Parcel a = m18499a(1, x_);
        to toVar = (to) ajn.m18501a(a, to.CREATOR);
        a.recycle();
        return toVar;
    }
}
