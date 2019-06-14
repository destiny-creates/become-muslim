package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.k.e */
public abstract class C6810e extends C5025j implements C5023d {
    /* renamed from: a */
    public static C5023d m31889a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        return queryLocalInterface instanceof C5023d ? (C5023d) queryLocalInterface : new C6811f(iBinder);
    }
}
