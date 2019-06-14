package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class awp extends ajm implements awo {
    public awp() {
        super("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    /* renamed from: a */
    public static awo m30325a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
        return queryLocalInterface instanceof awo ? (awo) queryLocalInterface : new awq(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        awa awa;
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            awa = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
            awa = queryLocalInterface instanceof awa ? (awa) queryLocalInterface : new awc(readStrongBinder);
        }
        mo4057a(awa);
        parcel2.writeNoException();
        return true;
    }
}
