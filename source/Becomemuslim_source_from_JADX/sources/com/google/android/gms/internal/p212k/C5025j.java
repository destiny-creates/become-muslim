package com.google.android.gms.internal.p212k;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.k.j */
public class C5025j extends Binder implements IInterface {
    /* renamed from: a */
    private static C5027l f16860a;

    protected C5025j(String str) {
        attachInterface(this, str);
    }

    /* renamed from: a */
    protected boolean mo4705a(int i, Parcel parcel, Parcel parcel2, int i2) {
        return false;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean onTransact;
        if (i > 16777215) {
            onTransact = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            onTransact = false;
        }
        return onTransact ? true : mo4705a(i, parcel, parcel2, i2);
    }
}
