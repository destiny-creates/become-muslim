package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b.C4325a;

public abstract class avo extends ajm implements avn {
    public avo() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    /* renamed from: a */
    public static avn m30266a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
        return queryLocalInterface instanceof avn ? (avn) queryLocalInterface : new avp(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo4007a(C4325a.a(parcel.readStrongBinder()));
                break;
            case 2:
                mo4006a();
                break;
            case 3:
                mo4008b(C4325a.a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
