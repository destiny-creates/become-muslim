package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.k.n */
public abstract class C6814n extends C5025j implements C5028m {
    /* renamed from: a */
    public static C5028m m31897a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        return queryLocalInterface instanceof C5028m ? (C5028m) queryLocalInterface : new C6815o(iBinder);
    }
}
