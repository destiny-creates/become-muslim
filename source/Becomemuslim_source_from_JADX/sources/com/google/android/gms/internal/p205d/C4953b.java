package com.google.android.gms.internal.p205d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.d.b */
public class C4953b extends Binder implements IInterface {
    /* renamed from: a */
    private static C4955d f16198a;

    protected C4953b(String str) {
        attachInterface(this, str);
    }

    /* renamed from: a */
    protected boolean m20229a(int i, Parcel parcel, Parcel parcel2, int i2) {
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
        return m20229a(i, parcel, parcel2, i2);
    }
}
