package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class aps extends ajl implements apq {
    aps(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    /* renamed from: a */
    public final String mo3865a() {
        Parcel a = m18499a(2, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final void mo3866a(aoq aoq) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) aoq);
        m18500b(1, x_);
    }

    /* renamed from: a */
    public final void mo3867a(aoq aoq, int i) {
        Parcel x_ = x_();
        ajn.m18503a(x_, (Parcelable) aoq);
        x_.writeInt(i);
        m18500b(5, x_);
    }

    /* renamed from: b */
    public final String mo3868b() {
        Parcel a = m18499a(4, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: c */
    public final boolean mo3869c() {
        Parcel a = m18499a(3, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }
}
