package com.google.android.gms.internal.p208g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.g.ay */
public abstract class ay extends C4976z implements ax {
    public ay() {
        super("com.google.android.gms.fitness.internal.IStatusCallback");
    }

    /* renamed from: a */
    public static ax m31281a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IStatusCallback");
        return queryLocalInterface instanceof ax ? (ax) queryLocalInterface : new az(iBinder);
    }

    /* renamed from: a */
    protected final boolean mo4398a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        mo4407a((Status) ap.m20255a(parcel, Status.CREATOR));
        return true;
    }
}
