package com.google.android.gms.maps.p216a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.p212k.C5025j;

/* renamed from: com.google.android.gms.maps.a.r */
public abstract class C6840r extends C5025j implements C5101q {
    public C6840r() {
        super("com.google.android.gms.maps.internal.IOnMapReadyCallback");
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        C5092b c5092b;
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            c5092b = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            c5092b = queryLocalInterface instanceof C5092b ? (C5092b) queryLocalInterface : new ap(readStrongBinder);
        }
        mo6236a(c5092b);
        parcel2.writeNoException();
        return true;
    }
}
