package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

public final class axr extends ajl implements axq {
    axr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    /* renamed from: a */
    public final ParcelFileDescriptor mo4083a(axm axm) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) axm);
        Parcel a = m18499a(1, x_);
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ajn.m18501a(a, ParcelFileDescriptor.CREATOR);
        a.recycle();
        return parcelFileDescriptor;
    }
}
