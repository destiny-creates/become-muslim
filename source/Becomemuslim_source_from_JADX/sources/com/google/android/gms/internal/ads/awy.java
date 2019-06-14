package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class awy extends ajl implements awx {
    awy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    /* renamed from: a */
    public final void mo4060a() {
        m18500b(2, x_());
    }

    /* renamed from: a */
    public final void mo4061a(String str) {
        Parcel x_ = x_();
        x_.writeString(str);
        m18500b(1, x_);
    }
}
