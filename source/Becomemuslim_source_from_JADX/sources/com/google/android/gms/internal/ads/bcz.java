package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class bcz extends ajm implements bcy {
    public bcz() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    /* renamed from: a */
    public static bcy m30474a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return queryLocalInterface instanceof bcy ? (bcy) queryLocalInterface : new bda(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface a;
        switch (i) {
            case 1:
                a = mo4102a(parcel.readString());
                break;
            case 2:
                boolean b = mo4103b(parcel.readString());
                parcel2.writeNoException();
                ajn.m18504a(parcel2, b);
                break;
            case 3:
                a = mo4104c(parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        ajn.m18502a(parcel2, a);
        return true;
    }
}
