package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.k.q */
public abstract class C6816q extends C5025j implements C5029p {
    /* renamed from: a */
    public static C5029p m31901a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        return queryLocalInterface instanceof C5029p ? (C5029p) queryLocalInterface : new C6817r(iBinder);
    }
}
