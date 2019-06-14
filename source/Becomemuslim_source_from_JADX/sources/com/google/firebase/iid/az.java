package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;

public final class az implements ay {
    /* renamed from: a */
    private final IBinder f24751a;

    az(IBinder iBinder) {
        this.f24751a = iBinder;
    }

    /* renamed from: a */
    public final void mo4892a(Message message) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
        obtain.writeInt(1);
        message.writeToParcel(obtain, 0);
        try {
            this.f24751a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f24751a;
    }
}
