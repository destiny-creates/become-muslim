package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.k.ac */
public abstract class ac extends C5025j implements ab {
    /* renamed from: a */
    public static ab m31840a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        return queryLocalInterface instanceof ab ? (ab) queryLocalInterface : new ad(iBinder);
    }
}
