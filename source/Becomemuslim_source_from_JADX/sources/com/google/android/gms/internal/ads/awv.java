package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class awv extends ajm implements awu {
    public awv() {
        super("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    /* renamed from: a */
    public static awu m30329a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
        return queryLocalInterface instanceof awu ? (awu) queryLocalInterface : new aww(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        awz awz;
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            awz = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
            awz = queryLocalInterface instanceof awz ? (awz) queryLocalInterface : new axb(readStrongBinder);
        }
        mo4059a(awz);
        parcel2.writeNoException();
        return true;
    }
}
