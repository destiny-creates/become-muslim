package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.p168b.C4735l;

public abstract class apu extends ajm implements apt {
    public apu() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        apn apn = null;
        IBinder readStrongBinder;
        IInterface queryLocalInterface;
        switch (i) {
            case 1:
                IInterface a = mo3870a();
                parcel2.writeNoException();
                ajn.m18502a(parcel2, a);
                break;
            case 2:
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    apn = queryLocalInterface instanceof apn ? (apn) queryLocalInterface : new app(readStrongBinder);
                }
                mo3872a(apn);
                break;
            case 3:
                mo3875a(awf.m30319a(parcel.readStrongBinder()));
                break;
            case 4:
                mo3876a(awj.m30321a(parcel.readStrongBinder()));
                break;
            case 5:
                mo3879a(parcel.readString(), awp.m30325a(parcel.readStrongBinder()), awm.m30323a(parcel.readStrongBinder()));
                break;
            case 6:
                mo3874a((aus) ajn.m18501a(parcel, aus.CREATOR));
                break;
            case 7:
                aqn aqp;
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    aqp = queryLocalInterface instanceof aqn ? (aqn) queryLocalInterface : new aqp(readStrongBinder);
                }
                mo3873a(aqp);
                break;
            case 8:
                mo3877a(aws.m30327a(parcel.readStrongBinder()), (aou) ajn.m18501a(parcel, aou.CREATOR));
                break;
            case 9:
                mo3871a((C4735l) ajn.m18501a(parcel, C4735l.CREATOR));
                break;
            case 10:
                mo3878a(awv.m30329a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
