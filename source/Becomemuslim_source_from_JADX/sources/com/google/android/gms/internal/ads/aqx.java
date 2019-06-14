package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class aqx extends ajl implements aqv {
    aqx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    /* renamed from: a */
    public final void mo3937a() {
        m18500b(1, x_());
    }

    /* renamed from: a */
    public final void mo3938a(aqy aqy) {
        Parcel x_ = x_();
        ajn.m18502a(x_, (IInterface) aqy);
        m18500b(8, x_);
    }

    /* renamed from: a */
    public final void mo3939a(boolean z) {
        Parcel x_ = x_();
        ajn.m18504a(x_, z);
        m18500b(3, x_);
    }

    /* renamed from: b */
    public final void mo3940b() {
        m18500b(2, x_());
    }

    /* renamed from: c */
    public final boolean mo3941c() {
        Parcel a = m18499a(4, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: d */
    public final int mo3942d() {
        Parcel a = m18499a(5, x_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    /* renamed from: e */
    public final float mo3943e() {
        Parcel a = m18499a(9, x_());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    /* renamed from: f */
    public final float mo3944f() {
        Parcel a = m18499a(6, x_());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    /* renamed from: g */
    public final float mo3945g() {
        Parcel a = m18499a(7, x_());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    /* renamed from: h */
    public final aqy mo3946h() {
        aqy aqy;
        Parcel a = m18499a(11, x_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            aqy = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            aqy = queryLocalInterface instanceof aqy ? (aqy) queryLocalInterface : new ara(readStrongBinder);
        }
        a.recycle();
        return aqy;
    }

    /* renamed from: i */
    public final boolean mo3947i() {
        Parcel a = m18499a(10, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: j */
    public final boolean mo3948j() {
        Parcel a = m18499a(12, x_());
        boolean a2 = ajn.m18505a(a);
        a.recycle();
        return a2;
    }
}
