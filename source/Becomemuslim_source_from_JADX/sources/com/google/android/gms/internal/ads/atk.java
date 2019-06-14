package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class atk extends ajm implements atj {
    public atk() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    /* renamed from: a */
    public static atj m30189a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
        return queryLocalInterface instanceof atj ? (atj) queryLocalInterface : new atl(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        atg atg;
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            atg = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            atg = queryLocalInterface instanceof atg ? (atg) queryLocalInterface : new ati(readStrongBinder);
        }
        mo3964a(atg);
        parcel2.writeNoException();
        return true;
    }
}
