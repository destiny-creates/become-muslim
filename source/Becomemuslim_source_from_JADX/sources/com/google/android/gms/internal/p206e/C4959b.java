package com.google.android.gms.internal.p206e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.e.b */
public class C4959b extends Binder implements IInterface {
    /* renamed from: a */
    private static C4961d f16203a;

    protected C4959b(String str) {
        attachInterface(this, str);
    }

    /* renamed from: a */
    protected boolean m20237a(int i, Parcel parcel, Parcel parcel2, int i2) {
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
        if (onTransact) {
            return true;
        }
        return m20237a(i, parcel, parcel2, i2);
    }
}
