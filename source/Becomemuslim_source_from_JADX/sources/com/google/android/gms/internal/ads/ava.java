package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

public abstract class ava extends ajm implements auz {
    public ava() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    /* renamed from: a */
    public static auz m30248a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        return queryLocalInterface instanceof auz ? (auz) queryLocalInterface : new avb(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                String a = mo3994a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                break;
            case 3:
                List b = mo3995b();
                parcel2.writeNoException();
                parcel2.writeList(b);
                break;
            default:
                return false;
        }
        return true;
    }
}
