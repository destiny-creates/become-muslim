package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.p206e.C4959b;
import com.google.android.gms.internal.p206e.C4960c;

public abstract class ay extends C4959b implements ax {
    public ay() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    /* renamed from: a */
    public static ax m14369a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof ax) {
            return (ax) queryLocalInterface;
        }
        return new az(iBinder);
    }

    /* renamed from: a */
    protected final boolean m14370a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                i = mo2469a();
                parcel2.writeNoException();
                C4960c.a(parcel2, i);
                break;
            case 2:
                i = mo2470b();
                parcel2.writeNoException();
                parcel2.writeInt(i);
                break;
            default:
                return false;
        }
        return true;
    }
}
