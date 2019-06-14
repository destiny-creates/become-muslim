package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.p206e.C4959b;

public abstract class bc extends C4959b implements bb {
    /* renamed from: a */
    public static bb m14379a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (queryLocalInterface instanceof bb) {
            return (bb) queryLocalInterface;
        }
        return new bd(iBinder);
    }
}
