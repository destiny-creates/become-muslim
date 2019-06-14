package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class awf extends ajm implements awe {
    public awf() {
        super("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    /* renamed from: a */
    public static awe m30319a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
        return queryLocalInterface instanceof awe ? (awe) queryLocalInterface : new awg(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        avs avs;
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            avs = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            avs = queryLocalInterface instanceof avs ? (avs) queryLocalInterface : new avu(readStrongBinder);
        }
        mo4054a(avs);
        parcel2.writeNoException();
        return true;
    }
}
