package com.google.android.gms.internal.p204c;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.c.k */
public abstract class C6778k extends C4948g implements C4951j {
    /* renamed from: a */
    public static C4951j m31263a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.auth.IAuthManagerService");
        if (queryLocalInterface instanceof C4951j) {
            return (C4951j) queryLocalInterface;
        }
        return new C6779l(iBinder);
    }
}
