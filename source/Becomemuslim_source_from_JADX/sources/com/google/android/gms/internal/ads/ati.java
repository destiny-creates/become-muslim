package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;

public final class ati extends ajl implements atg {
    ati(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    /* renamed from: a */
    public final String mo3959a() {
        Parcel a = m18499a(1, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final void mo3960a(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        m18500b(3, x_);
    }

    /* renamed from: b */
    public final String mo3961b() {
        Parcel a = m18499a(2, x_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: c */
    public final void mo3962c() {
        m18500b(4, x_());
    }

    /* renamed from: d */
    public final void mo3963d() {
        m18500b(5, x_());
    }
}
