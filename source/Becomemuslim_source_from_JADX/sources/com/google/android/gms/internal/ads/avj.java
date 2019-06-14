package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b.C4325a;

public abstract class avj extends ajm implements avi {
    public avj() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    /* renamed from: a */
    public static avi m30258a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        return queryLocalInterface instanceof avi ? (avi) queryLocalInterface : new avk(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo4003a(parcel.readString(), C4325a.a(parcel.readStrongBinder()));
                break;
            case 2:
                IInterface a = mo3999a(parcel.readString());
                parcel2.writeNoException();
                ajn.m18502a(parcel2, a);
                break;
            case 3:
                mo4001a(C4325a.a(parcel.readStrongBinder()));
                break;
            case 4:
                mo4000a();
                break;
            case 5:
                mo4002a(C4325a.a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 6:
                mo4004b(C4325a.a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
