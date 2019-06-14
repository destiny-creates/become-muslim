package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.k.b */
public abstract class C6808b extends C5025j implements ah {
    /* renamed from: a */
    public static ah m31875a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        return queryLocalInterface instanceof ah ? (ah) queryLocalInterface : new C6809c(iBinder);
    }
}
