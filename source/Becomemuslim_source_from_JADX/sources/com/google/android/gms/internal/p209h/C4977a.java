package com.google.android.gms.internal.p209h;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.h.a */
public class C4977a implements IInterface {
    /* renamed from: a */
    private final IBinder f16217a;
    /* renamed from: b */
    private final String f16218b;

    protected C4977a(IBinder iBinder, String str) {
        this.f16217a = iBinder;
        this.f16218b = str;
    }

    public IBinder asBinder() {
        return this.f16217a;
    }

    /* renamed from: a */
    protected final Parcel m20264a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f16218b);
        return obtain;
    }

    /* renamed from: a */
    protected final void m20265a(int i, Parcel parcel) {
        try {
            this.f16217a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
