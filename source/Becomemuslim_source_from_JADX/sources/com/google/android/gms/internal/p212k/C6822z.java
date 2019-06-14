package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.k.z */
public abstract class C6822z extends C5025j implements C5032y {
    /* renamed from: a */
    public static C5032y m31924a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
        return queryLocalInterface instanceof C5032y ? (C5032y) queryLocalInterface : new aa(iBinder);
    }
}
