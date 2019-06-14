package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.k.t */
public abstract class C6818t extends C5025j implements C5030s {
    /* renamed from: a */
    public static C5030s m31910a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        return queryLocalInterface instanceof C5030s ? (C5030s) queryLocalInterface : new C6819u(iBinder);
    }
}
