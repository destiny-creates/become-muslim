package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class ave extends ajm implements avd {
    public ave() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    /* renamed from: a */
    public static avd m30251a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return queryLocalInterface instanceof avd ? (avd) queryLocalInterface : new avf(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                IInterface a = mo3996a();
                parcel2.writeNoException();
                ajn.m18502a(parcel2, a);
                break;
            case 2:
                Parcelable b = mo3997b();
                parcel2.writeNoException();
                ajn.m18507b(parcel2, b);
                break;
            case 3:
                double c = mo3998c();
                parcel2.writeNoException();
                parcel2.writeDouble(c);
                break;
            default:
                return false;
        }
        return true;
    }
}
