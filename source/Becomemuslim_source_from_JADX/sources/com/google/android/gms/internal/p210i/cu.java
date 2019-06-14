package com.google.android.gms.internal.p210i;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.i.cu */
public class cu implements IInterface {
    /* renamed from: a */
    private final IBinder f16461a;
    /* renamed from: b */
    private final String f16462b;

    protected cu(IBinder iBinder, String str) {
        this.f16461a = iBinder;
        this.f16462b = str;
    }

    public IBinder asBinder() {
        return this.f16461a;
    }

    /* renamed from: b */
    protected final Parcel m20396b() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f16462b);
        return obtain;
    }

    /* renamed from: a */
    protected final void m20395a(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f16461a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
