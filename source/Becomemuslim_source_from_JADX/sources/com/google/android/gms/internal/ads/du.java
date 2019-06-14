package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class du extends ajm implements dt {
    public du() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        dw dwVar = null;
        IBinder readStrongBinder;
        IInterface queryLocalInterface;
        ee eeVar;
        dz eaVar;
        switch (i) {
            case 1:
                Parcelable a = mo4236a((dl) ajn.m18501a(parcel, dl.CREATOR));
                parcel2.writeNoException();
                ajn.m18507b(parcel2, a);
                break;
            case 2:
                dl dlVar = (dl) ajn.m18501a(parcel, dl.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    dwVar = queryLocalInterface instanceof dw ? (dw) queryLocalInterface : new dy(readStrongBinder);
                }
                mo4237a(dlVar, dwVar);
                break;
            case 4:
                eeVar = (ee) ajn.m18501a(parcel, ee.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    eaVar = queryLocalInterface instanceof dz ? (dz) queryLocalInterface : new ea(readStrongBinder);
                }
                mo4238a(eeVar, eaVar);
                break;
            case 5:
                eeVar = (ee) ajn.m18501a(parcel, ee.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    eaVar = queryLocalInterface instanceof dz ? (dz) queryLocalInterface : new ea(readStrongBinder);
                }
                mo4239b(eeVar, eaVar);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
