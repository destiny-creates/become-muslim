package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p174b.C2758b;

/* renamed from: com.google.android.gms.internal.ads.v */
public final class C6769v extends ajl implements C4937u {
    C6769v(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
    }

    /* renamed from: a */
    public final IBinder mo4386a(C2758b c2758b) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) c2758b);
        Parcel a = m18499a(1, x_);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
