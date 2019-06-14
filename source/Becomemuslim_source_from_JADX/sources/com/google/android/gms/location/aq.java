package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.p211j.ab;
import com.google.android.gms.internal.p211j.ap;

public abstract class aq extends ab implements ap {
    /* renamed from: a */
    public static ap m32106a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof ap ? (ap) queryLocalInterface : new ar(iBinder);
    }

    /* renamed from: a */
    protected final boolean mo4639a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo4777a((LocationResult) ap.m21095a(parcel, LocationResult.CREATOR));
                break;
            case 2:
                mo4776a((LocationAvailability) ap.m21095a(parcel, LocationAvailability.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
