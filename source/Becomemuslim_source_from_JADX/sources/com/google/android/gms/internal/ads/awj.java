package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class awj extends ajm implements awh {
    public awj() {
        super("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    /* renamed from: a */
    public static awh m30321a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
        return queryLocalInterface instanceof awh ? (awh) queryLocalInterface : new awk(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        avw avw;
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            avw = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            avw = queryLocalInterface instanceof avw ? (avw) queryLocalInterface : new avy(readStrongBinder);
        }
        mo4055a(avw);
        parcel2.writeNoException();
        return true;
    }
}
