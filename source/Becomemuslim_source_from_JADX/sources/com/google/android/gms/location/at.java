package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.p211j.ab;
import com.google.android.gms.internal.p211j.ap;

public abstract class at extends ab implements as {
    public at() {
        super("com.google.android.gms.location.ILocationListener");
    }

    /* renamed from: a */
    public static as m32110a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof as ? (as) queryLocalInterface : new au(iBinder);
    }

    /* renamed from: a */
    protected final boolean mo4639a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo4778a((Location) ap.m21095a(parcel, Location.CREATOR));
        return true;
    }
}
