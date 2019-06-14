package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b.C4325a;

public abstract class aws extends ajm implements awr {
    /* renamed from: a */
    public static awr m30327a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
        return queryLocalInterface instanceof awr ? (awr) queryLocalInterface : new awt(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo4058a(apz.m30098a(parcel.readStrongBinder()), C4325a.a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}
