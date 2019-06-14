package com.google.android.gms.internal.p212k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.internal.k.h */
public abstract class C6812h extends C5025j implements C5024g {
    public C6812h() {
        super("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    /* renamed from: a */
    public static C5024g m31894a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        return queryLocalInterface instanceof C5024g ? (C5024g) queryLocalInterface : new C6813i(iBinder);
    }

    /* renamed from: a */
    protected final boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Parcelable a = mo4706a(parcel.readInt(), parcel.readInt(), parcel.readInt());
        parcel2.writeNoException();
        C5026k.m21180b(parcel2, a);
        return true;
    }
}
