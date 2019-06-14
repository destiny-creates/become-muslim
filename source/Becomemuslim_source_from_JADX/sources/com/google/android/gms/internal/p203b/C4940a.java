package com.google.android.gms.internal.p203b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.b.a */
public class C4940a implements IInterface {
    /* renamed from: a */
    private final IBinder f16136a;
    /* renamed from: b */
    private final String f16137b;

    protected C4940a(IBinder iBinder, String str) {
        this.f16136a = iBinder;
        this.f16137b = str;
    }

    public IBinder asBinder() {
        return this.f16136a;
    }

    /* renamed from: a */
    protected final Parcel m20210a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f16137b);
        return obtain;
    }

    /* renamed from: a */
    protected final void m20211a(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f16136a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
