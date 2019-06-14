package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class bdf extends ajm implements bde {
    public bdf() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    /* renamed from: a */
    public static bde m30505a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return queryLocalInterface instanceof bde ? (bde) queryLocalInterface : new bdg(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo4132a();
                break;
            case 2:
                mo4138b();
                break;
            case 3:
                mo4133a(parcel.readInt());
                break;
            case 4:
                mo4139c();
                break;
            case 5:
                mo4140d();
                break;
            case 6:
                mo4141e();
                break;
            case 7:
                bdh bdh;
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    bdh = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    bdh = queryLocalInterface instanceof bdh ? (bdh) queryLocalInterface : new bdj(readStrongBinder);
                }
                mo4135a(bdh);
                break;
            case 8:
                mo4142f();
                break;
            case 9:
                mo4137a(parcel.readString(), parcel.readString());
                break;
            case 10:
                mo4134a(awb.m30304a(parcel.readStrongBinder()), parcel.readString());
                break;
            case 11:
                mo4143g();
                break;
            case 12:
                mo4136a(parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
