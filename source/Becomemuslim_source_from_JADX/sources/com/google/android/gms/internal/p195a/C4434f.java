package com.google.android.gms.internal.p195a;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.a.f */
public abstract class C4434f extends C3081b implements C3084e {
    /* renamed from: a */
    public static C3084e m14720a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return queryLocalInterface instanceof C3084e ? (C3084e) queryLocalInterface : new C4435g(iBinder);
    }
}
