package com.google.android.gms.internal.p215n;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.n.a */
public class C5061a implements IInterface {
    /* renamed from: a */
    private final IBinder f17357a;
    /* renamed from: b */
    private final String f17358b;

    protected C5061a(IBinder iBinder, String str) {
        this.f17357a = iBinder;
        this.f17358b = str;
    }

    /* renamed from: a */
    protected final Parcel m21517a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f17358b);
        return obtain;
    }

    /* renamed from: a */
    protected final void m21518a(int i, Parcel parcel) {
        try {
            this.f17357a.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f17357a;
    }
}
