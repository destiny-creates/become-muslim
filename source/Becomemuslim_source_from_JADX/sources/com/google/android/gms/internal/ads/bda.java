package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class bda extends ajl implements bcy {
    bda(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    /* renamed from: a */
    public final bdb mo4102a(String str) {
        bdb bdb;
        Parcel x_ = x_();
        x_.writeString(str);
        Parcel a = m18499a(1, x_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            bdb = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            bdb = queryLocalInterface instanceof bdb ? (bdb) queryLocalInterface : new bdd(readStrongBinder);
        }
        a.recycle();
        return bdb;
    }

    /* renamed from: b */
    public final boolean mo4103b(String str) {
        Parcel x_ = x_();
        x_.writeString(str);
        Parcel a = m18499a(2, x_);
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: c */
    public final ben mo4104c(String str) {
        Parcel x_ = x_();
        x_.writeString(str);
        Parcel a = m18499a(3, x_);
        ben a2 = beo.m30620a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
