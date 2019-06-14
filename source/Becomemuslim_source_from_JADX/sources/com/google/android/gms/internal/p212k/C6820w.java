package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.k.w */
public abstract class C6820w extends C5025j implements C5031v {
    /* renamed from: a */
    public static C5031v m31918a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
        return queryLocalInterface instanceof C5031v ? (C5031v) queryLocalInterface : new C6821x(iBinder);
    }
}
