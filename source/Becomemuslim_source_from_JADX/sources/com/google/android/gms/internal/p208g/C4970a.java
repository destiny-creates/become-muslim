package com.google.android.gms.internal.p208g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.g.a */
public class C4970a implements IInterface {
    /* renamed from: a */
    private final IBinder f16213a;
    /* renamed from: b */
    private final String f16214b;

    protected C4970a(IBinder iBinder, String str) {
        this.f16213a = iBinder;
        this.f16214b = str;
    }

    /* renamed from: a */
    protected final Parcel m20248a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f16214b);
        return obtain;
    }

    /* renamed from: a */
    protected final void m20249a(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f16213a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f16213a;
    }

    /* renamed from: b */
    protected final void m20250b(int i, Parcel parcel) {
        try {
            this.f16213a.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
