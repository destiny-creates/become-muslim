package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.p211j.ab;

public class an extends ab implements am {
    /* renamed from: a */
    public static am m32104a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
        return queryLocalInterface instanceof am ? (am) queryLocalInterface : new ao(iBinder);
    }

    /* renamed from: a */
    protected final boolean mo4639a(int i, Parcel parcel, Parcel parcel2, int i2) {
        throw new NoSuchMethodError();
    }
}
